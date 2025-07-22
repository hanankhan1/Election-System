package electionSystem;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Candidatecla {

   public static void addCandidate(String cname, String ccnic, String cdob, int cage, String cgender,
                                      String cconstituency, String cparty, String csymbol) {
    // Validate input fields (optional but recommended)
    if (cname.isEmpty() || ccnic.isEmpty() || cdob.isEmpty() || cgender.isEmpty() ||
        cconstituency.isEmpty() || cparty.isEmpty() || csymbol.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Please fill in all candidate fields.");
        return;
    }

    try {
        ClientConnection.connectToServer();
        // Construct the data string
        String data = cname + "," + ccnic + "," + cdob + "," + cage + "," + cgender + "," + cconstituency + "," + cparty + "," + csymbol;

        // Send command and data to server
        ClientConnection.out.println("@@;" + data);  // e.g., CANDIDATE_ADD is your command tag
        String response = ClientConnection.in.readLine();

        // Show server response
        JOptionPane.showMessageDialog(null, response);
        ClientConnection.socketClose();

    } catch (IOException e) {
        JOptionPane.showMessageDialog(null, "Server communication error: " + e.getMessage());
    }
}

public static void loadCandidates(JTable table) {
    try {
        ClientConnection.connectToServer();
        ClientConnection.out.println("%%%%");

        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        String line;
        while ((line = ClientConnection.in.readLine()) != null) {
            if (line.equals("END_OF_CANDIDATES")) break;
            if (line.startsWith("Error") || line.startsWith("No")) {
                JOptionPane.showMessageDialog(null, line);
                break;
            }

            String[] parts = line.split(",", -1);
            if (parts.length == 10) {
                model.addRow(new Object[]{
                    parts[0], parts[1], parts[2],
                    Integer.parseInt(parts[3]),
                    parts[4], parts[5], parts[6],
                    parts[7], Integer.parseInt(parts[8]),parts[9]
                });
            }
        }

        ClientConnection.socketClose();
    } catch (IOException e) {
        JOptionPane.showMessageDialog(null, "Error loading candidates: " + e.getMessage());
    }
}

public static void searchCandidateByCNIC(
        String cnic,
        JTextField cname, JTextField cdob, JTextField cage,
        JTextField cgender, JTextField cconstituency,
        JTextField cparty, JTextField csymbol
) {
    if (cnic.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Please enter CNIC to search.");
        return;
    }

    try {
        ClientConnection.connectToServer();
        // Send command with CNIC to server
        ClientConnection.out.println("^^;" + cnic);
        String response = ClientConnection.in.readLine();

        if (response.equals("NOT_FOUND")) {
            JOptionPane.showMessageDialog(null, "Candidate not found.");
            return;
        }

        // Parse server response
        String[] fields = response.split(",");

        if (fields.length == 7) {
            cname.setText(fields[0]);
            cdob.setText(fields[1]);
            cage.setText(fields[2]);
            cgender.setText(fields[3]);
            cconstituency.setText(fields[4]);
            cparty.setText(fields[5]);
            csymbol.setText(fields[6]);
        } else {
            JOptionPane.showMessageDialog(null, "Invalid data received.");
        }
        ClientConnection.socketClose();

    } catch (IOException e) {
        JOptionPane.showMessageDialog(null, "Server communication error: " + e.getMessage());
    }
}
    public static void updateCandidate(
    String cnic, String name, String dob, String ageText, String gender,
    String constituency, String party, String symbol
) {
    if (cnic.isEmpty() || name.isEmpty() || dob.isEmpty() || ageText.isEmpty() ||
        gender.isEmpty() || constituency.isEmpty() || party.isEmpty() || symbol.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Please fill all fields before updating.");
        return;
    }

    int age;
    try {
        
        age = Integer.parseInt(ageText);
        if (age < 18) {
            JOptionPane.showMessageDialog(null, "Age must be 18 or older.");
            return;
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Age must be a valid number.");
        return;
    }

    try {
        ClientConnection.connectToServer();
        // Combine data into a single string
        String data = String.join(",", cnic, name, dob, String.valueOf(age), gender, constituency, party, symbol);

        // Send update request to server
        ClientConnection.out.println("##;" + data); // ## = Update Candidate command
        String response = ClientConnection.in.readLine();

        // Show server response
        JOptionPane.showMessageDialog(null, response);
        ClientConnection.socketClose();
    } catch (IOException e) {
        JOptionPane.showMessageDialog(null, "Communication error: " + e.getMessage());
    }
}




       public static void deleteCandidate(String cnic) {
    if (cnic.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Please enter CNIC to delete.");
        return;
    }

    try {
        ClientConnection.connectToServer();
        ClientConnection.out.println("$$;" + cnic);  // ###; is the deleteCandidate command
        String response = ClientConnection.in.readLine();
        JOptionPane.showMessageDialog(null, response);
        ClientConnection.socketClose();
    } catch (IOException e) {
        JOptionPane.showMessageDialog(null, "Communication Error: " + e.getMessage());
    }
}
public static void getResultForCandidate(JTable table, String cnic) {
    try {
        ClientConnection.connectToServer();
        ClientConnection.out.println("%%%%%;" + cnic); // Command + CNIC

        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        String line;
        while ((line = ClientConnection.in.readLine()) != null) {
            if (line.equals("END_OF_RESULT")) break;

            if (line.startsWith("Error") || line.equals("Candidate not found.") || line.equals("Election is not currently active. Results cannot be viewed.")) {
                JOptionPane.showMessageDialog(null, line);
                break;
            }

            String[] parts = line.split(",", -1);
            if (parts.length == 7) {
                model.addRow(new Object[]{
                    parts[0], // CNIC
                    parts[1], // Name
                    parts[2], // Constituency
                    parts[3], // City
                    parts[4], // Symbol
                    Integer.parseInt(parts[5]), // Votes
                    parts[6]  // Outcome
                });
            }
        }

        ClientConnection.socketClose();

    } catch (IOException e) {
        JOptionPane.showMessageDialog(null, "Error receiving result: " + e.getMessage());
    }
}

}
//public static void addCandidate(String cname, String ccnic, String cdob, int cage, String cgender,
//                                String cconstituency, String cparty, String csymbol) {
//
//    try {
//        Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/EMS", "root", "UO2@iTSn");
//
//        // Check if constituency exists
//        PreparedStatement checkCon = con.prepareStatement("SELECT constituency_id FROM constituency WHERE conname = ?");
//        checkCon.setString(1, cconstituency);
//        ResultSet rsCon = checkCon.executeQuery();
//        if (!rsCon.next()) {
//            JOptionPane.showMessageDialog(null, "Constituency not found!");
//            return;
//        }
//        int conId = rsCon.getInt("constituency_id");
//
//        // Check if party exists
//        PreparedStatement checkParty = con.prepareStatement("SELECT party_id FROM parties WHERE pname = ?");
//        checkParty.setString(1, cparty);
//        ResultSet rsParty = checkParty.executeQuery();
//        if (!rsParty.next()) {
//            JOptionPane.showMessageDialog(null, "Party not found!");
//            return;
//        }
//        int partyId = rsParty.getInt("party_id");
//
//        // Check if symbol already exists in the same constituency
//        PreparedStatement checkSymbol = con.prepareStatement(
//            "SELECT * FROM candidates WHERE csymbol = ? AND constituency_id = ?"
//        );
//        checkSymbol.setString(1, csymbol);
//        checkSymbol.setInt(2, conId);
//        ResultSet rsSymbol = checkSymbol.executeQuery();
//        if (rsSymbol.next()) {
//            JOptionPane.showMessageDialog(null, "This symbol is already assigned to a candidate in the same constituency.");
//            return;
//        }
//
//        // Insert candidate
//        PreparedStatement ps = con.prepareStatement(
//            "INSERT INTO candidates (cname, ccnic, cdob, cage, cgender, constituency_id, party_id, csymbol) " +
//            "VALUES (?, ?, ?, ?, ?, ?, ?, ?)"
//        );
//        ps.setString(1, cname);
//        ps.setString(2, ccnic);
//        ps.setString(3, cdob);
//        ps.setInt(4, cage);
//        ps.setString(5, cgender);
//        ps.setInt(6, conId);
//        ps.setInt(7, partyId);
//        ps.setString(8, csymbol);
//
//        int rows = ps.executeUpdate();
//        if (rows > 0) {
//            JOptionPane.showMessageDialog(null, "Candidate added successfully!");
//        } else {
//            JOptionPane.showMessageDialog(null, "Candidate insertion failed.");
//        }
//
//        con.close();
//    } catch (Exception e) {
//        JOptionPane.showMessageDialog(null, "Database Error: " + e.getMessage());
//    }
//}
//public static void searchCandidateByCNIC(
//            String cnic,
//            JTextField cname, JTextField cdob, JTextField cage,
//            JTextField cgender, JTextField cconstituency,
//            JTextField cparty, JTextField csymbol
//    ) {
//        if (cnic.isEmpty()) {
//            JOptionPane.showMessageDialog(null, "Please enter CNIC to search.");
//            return;
//        }
//        try {
//            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/EMS", "root", "UO2@iTSn");
//
//            String query = "SELECT c.cname, c.ccnic, c.cdob, c.cage, c.cgender, " +
//                           "cs.conname, p.pname, c.csymbol " +
//                           "FROM candidates c " +
//                           "JOIN constituency cs ON c.constituency_id = cs.constituency_id " +
//                           "JOIN parties p ON c.party_id = p.party_id " +
//                           "WHERE c.ccnic = ?";
//
//            PreparedStatement ps = con.prepareStatement(query);
//            ps.setString(1, cnic);
//
//            ResultSet rs = ps.executeQuery();
//
//            if (rs.next()) {
//                cname.setText(rs.getString("cname"));
//                cdob.setText(rs.getString("cdob"));
//                cage.setText(String.valueOf(rs.getInt("cage")));
//                cgender.setText(rs.getString("cgender"));
//                cconstituency.setText(rs.getString("conname"));
//                cparty.setText(rs.getString("pname"));
//                csymbol.setText(rs.getString("csymbol"));
//            } else {
//                JOptionPane.showMessageDialog(null, "Candidate not found.");
//            }
//
//            rs.close();
//            ps.close();
//            con.close();
//
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
//        }
//    }
//public static void updateCandidate(String cnic, String cname, String cdob, int age, String gender,
//                                       String constituency, String party, String symbol) {
//
//        try (Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/EMS", "root", "UO2@iTSn")) {
//
//            // Get IDs
//            PreparedStatement psCon = con.prepareStatement("SELECT constituency_id FROM constituency WHERE conname = ?");
//            psCon.setString(1, constituency);
//            ResultSet rsCon = psCon.executeQuery();
//            if (!rsCon.next()) {
//                JOptionPane.showMessageDialog(null, "Invalid Constituency");
//                return;
//            }
//            int conId = rsCon.getInt("constituency_id");
//
//            PreparedStatement psParty = con.prepareStatement("SELECT party_id FROM parties WHERE pname = ?");
//            psParty.setString(1, party);
//            ResultSet rsParty = psParty.executeQuery();
//            if (!rsParty.next()) {
//                JOptionPane.showMessageDialog(null, "Invalid Party");
//                return;
//            }
//            int partyId = rsParty.getInt("party_id");
//
//            // Update
//            PreparedStatement ps = con.prepareStatement(
//                "UPDATE candidates SET cname = ?, cdob = ?, cage = ?, cgender = ?, " +
//                "constituency_id = ?, party_id = ?, csymbol = ? WHERE ccnic = ?"
//            );
//            ps.setString(1, cname);
//            ps.setString(2, cdob);
//            ps.setInt(3, age);
//            ps.setString(4, gender);
//            ps.setInt(5, conId);
//            ps.setInt(6, partyId);
//            ps.setString(7, symbol);
//            ps.setString(8, cnic);
//
//            int updated = ps.executeUpdate();
//            if (updated > 0) {
//                JOptionPane.showMessageDialog(null, "Candidate updated successfully!");
//            } else {
//                JOptionPane.showMessageDialog(null, "Update failed.");
//            }
//
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e.getMessage());
//        }
//    }
// public static void deleteCandidate(String cnic) {
//        try (Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/EMS", "root", "UO2@iTSn")) {
//            PreparedStatement ps = con.prepareStatement("DELETE FROM candidates WHERE ccnic = ?");
//            ps.setString(1, cnic);
//            int deleted = ps.executeUpdate();
//            if (deleted > 0) {
//                JOptionPane.showMessageDialog(null, "Candidate deleted successfully!");
//            } else {
//                JOptionPane.showMessageDialog(null, "No candidate found.");
//            }
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e.getMessage());
//        }
//    }




         
     
     
     
     
     
     
     
     
     
     
     
     
     
     













