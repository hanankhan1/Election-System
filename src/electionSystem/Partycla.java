// party full ok
package electionSystem;
import java.io.IOException;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Partycla {
    public static void addParty(String pname, String pfounder, String pyearStr, String pabbrevation, String pleader, String plogo) {
    if (pname.isEmpty() || pfounder.isEmpty() || pyearStr.isEmpty() || pabbrevation.isEmpty() || pleader.isEmpty() || plogo.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Please fill in all fields.");
        return;
    }

    try {
        ClientConnection.connectToServer();
        int pyear = Integer.parseInt(pyearStr);
        String data = pname + "," + pfounder + "," + pyear + "," + pabbrevation + "," + pleader + "," + plogo;

        ClientConnection.out.println("@@@@;" + data); // & is custom command for addParty
        String response = ClientConnection.in.readLine();
        JOptionPane.showMessageDialog(null, response);
        ClientConnection.socketClose();
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Party year must be a valid number.");
    } catch (IOException e) {
        JOptionPane.showMessageDialog(null, "Error communicating with server: " + e.getMessage());
    }
}

public static void loadParties(JTable table) {
    try {
        ClientConnection.connectToServer();
        ClientConnection.out.println("*");

        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        String line;
        while ((line = ClientConnection.in.readLine()) != null) {
            if (line.equals("END_OF_PARTIES")) break;

            if (line.startsWith("Error")) {
                JOptionPane.showMessageDialog(null, line);
                break;
            }

            String[] parts = line.split(",", -1);
            if (parts.length == 7) {
                model.addRow(new Object[]{
                    Integer.parseInt(parts[0]), // party_id
                    parts[1], // pname
                    parts[2], // pfounder
                    Integer.parseInt(parts[3]), // pyear
                    parts[4], // pabbrevation
                    parts[5], // pleader
                    parts[6]  // plogo
                });
            }
        }

        ClientConnection.socketClose();

    } catch (IOException e) {
        JOptionPane.showMessageDialog(null, "Error loading parties: " + e.getMessage());
    }
}

 public static void searchByAbbreviation(String abbrev, JTable table) {
    DefaultTableModel model = (DefaultTableModel) table.getModel();
    model.setRowCount(0);

    if (abbrev.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Please enter party abbreviation.");
        return;
    }

   try {
       ClientConnection.connectToServer();
    ClientConnection.out.println("^^^^;" + abbrev);  // * is the command for searchParty
    String response;

    while (!(response = ClientConnection.in.readLine()).equals("END")) {
        String[] fields = response.split(",");

        if (fields.length == 7) {  // Ensure proper data
            model.addRow(new Object[] {
                Integer.parseInt(fields[0]), // party_id
                fields[1],                   // pname
                fields[2],                   // pfounder
                Integer.parseInt(fields[3]), // pyear
                fields[4],                   // pabbrevation
                fields[5],                   // pleader
                fields[6]                    // plogo
            });
        } else {
            System.out.println("Invalid row format: " + response);
        }
    }
ClientConnection.socketClose();
    } catch (IOException e) {
    JOptionPane.showMessageDialog(null, "Communication error: " + e.getMessage());
    }

}

 public static void update(String id, String pname, String pfounder, String pyearStr, String pabbrevation, String pleader, String plogo) {
    if (id.isEmpty() || pname.isEmpty() || pfounder.isEmpty() || pyearStr.isEmpty() ||
        pabbrevation.isEmpty() || pleader.isEmpty() || plogo.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Please fill all fields.");
        return;
    }

    try {
        ClientConnection.connectToServer();
        int pyear = Integer.parseInt(pyearStr);

        // Build the data string
        String data = id + "," + pname + "," + pfounder + "," + pyear + "," + pabbrevation + "," + pleader + "," + plogo;

        // Send to server
        ClientConnection.out.println("####;" + data);
        String response = ClientConnection.in.readLine();

        JOptionPane.showMessageDialog(null, response);
ClientConnection.socketClose();
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Year must be a valid number.");
    } catch (IOException e) {
        JOptionPane.showMessageDialog(null, "Communication error: " + e.getMessage());
    }
}


public static void delete(String id) {
    if (id.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Please enter a party ID.");
        return;
    }
    try {
        ClientConnection.connectToServer();
        ClientConnection.out.println("$$$$;" + id); // $$$$ is the command for deleteParty
        String response = ClientConnection.in.readLine();
        JOptionPane.showMessageDialog(null, response);
        ClientConnection.socketClose();
    } catch (IOException e) {
        JOptionPane.showMessageDialog(null, "Communication error: " + e.getMessage());
    }
}



}
//public static void addParty(String pname, String pfounder, String pyearStr, String pabbrevation, String pleader, String plogo) {
//        if (pname.isEmpty() || pfounder.isEmpty() || pyearStr.isEmpty() || pabbrevation.isEmpty() || pleader.isEmpty() || plogo.isEmpty()) {
//            JOptionPane.showMessageDialog(null, "Please fill in all fields.");
//            return;
//        }
//
//        try {
//            int pyear = Integer.parseInt(pyearStr);
//
//            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/EMS", "root", "UO2@iTSn");
//            String sql = "INSERT INTO parties (pname, pfounder, pyear, pabbrevation, pleader, plogo) VALUES (?, ?, ?, ?, ?, ?)";
//            PreparedStatement ps = con.prepareStatement(sql);
//            ps.setString(1, pname);
//            ps.setString(2, pfounder);
//            ps.setInt(3, pyear);
//            ps.setString(4, pabbrevation);
//            ps.setString(5, pleader);
//            ps.setString(6, plogo);
//
//            int result = ps.executeUpdate();
//
//            if (result > 0) {
//                JOptionPane.showMessageDialog(null, "Party added successfully.");
//            } else {
//                JOptionPane.showMessageDialog(null, "Failed to add party.");
//            }
//
//            con.close();
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
//        }
//    }
//
//public static void searchByAbbreviation(String abbrev, JTable table) {
//        DefaultTableModel model = (DefaultTableModel) table.getModel();
//        model.setRowCount(0);
//
//        try {
//            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/EMS", "root", "UO2@iTSn");
//            String query = "SELECT * FROM parties WHERE pabbrevation LIKE ?";
//            PreparedStatement ps = con.prepareStatement(query);
//            ps.setString(1, "%" + abbrev + "%");
//
//            ResultSet rs = ps.executeQuery();
//
//            while (rs.next()) {
//                model.addRow(new Object[]{
//                    rs.getInt("party_id"),
//                    rs.getString("pname"),
//                    rs.getString("pfounder"),
//                    rs.getInt("pyear"),
//                    rs.getString("pabbrevation"),
//                    rs.getString("pleader"),
//                    rs.getString("plogo")
//                });
//            }
//
//            con.close();
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Search error: " + e.getMessage());
//        }
//    }
//public static void update(String id, String pname, String pfounder, String pyearStr, String pabbrevation, String pleader, String plogo) {
//        try {
//            int pyear = Integer.parseInt(pyearStr);
//
//            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/EMS", "root", "UO2@iTSn");
//            String sql = "UPDATE parties SET pname=?, pfounder=?, pyear=?, pabbrevation=?, pleader=?, plogo=? WHERE party_id=?";
//            PreparedStatement ps = con.prepareStatement(sql);
//            ps.setString(1, pname);
//            ps.setString(2, pfounder);
//            ps.setInt(3, pyear);
//            ps.setString(4, pabbrevation);
//            ps.setString(5, pleader);
//            ps.setString(6, plogo);
//            ps.setInt(7, Integer.parseInt(id));
//
//            int rows = ps.executeUpdate();
//
//            if (rows > 0) {
//                JOptionPane.showMessageDialog(null, "Party updated successfully.");
//            } else {
//                JOptionPane.showMessageDialog(null, "Update failed.");
//            }
//
//            con.close();
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Update Error: " + e.getMessage());
//        }
//    }
//public static void delete(String id) {
//        try {
//            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/EMS", "root", "UO2@iTSn");
//            PreparedStatement ps = con.prepareStatement("DELETE FROM parties WHERE party_id = ?");
//            ps.setInt(1, Integer.parseInt(id));
//
//            int rows = ps.executeUpdate();
//
//            if (rows > 0) {
//                JOptionPane.showMessageDialog(null, "Party deleted successfully.");
//            } else {
//                JOptionPane.showMessageDialog(null, "Party not found.");
//            }
//
//            con.close();
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Delete error: " + e.getMessage());
//        }
//    }
