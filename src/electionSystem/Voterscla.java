package electionSystem;

import java.io.IOException;
import java.sql.*;
import java.util.Arrays;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

public class Voterscla {

    public static void loadVoterData(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Clear previous rows

        try {
            ClientConnection.connectToServer();
            ClientConnection.out.println("%");  // Send command to server
            String line;

            while ((line = ClientConnection.in.readLine()) != null) {
                if (line.equals("No voters found.") || line.startsWith("Error")) {
                    JOptionPane.showMessageDialog(null, line);
                    break;
                }

                String[] parts = line.split(",", -1); // Allow empty fields
                if (parts.length == 8) {
                    model.addRow(new Object[]{
                        parts[0], // vname
                        parts[1], // vcnic
                        Integer.parseInt(parts[2]), // vage
                        parts[3], // vcity
                        parts[4], // na_conname
                        parts[5], // pa_conname
                        parts[6], // has_voted_na
                        parts[7] // has_voted_pa
                    });
                }
            }
            ClientConnection.socketClose();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error receiving voter data: " + e.getMessage());
        }
    }
    // Search and load voter from 'voters' table by CNIC

    public static void searchVoterByCnic(JTable table, String cnic) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        if (cnic.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter CNIC to search.");
            return;
        }

        try {
            ClientConnection.connectToServer();
            // Send search command to server
            ClientConnection.out.println("^;" + cnic);
            String response = ClientConnection.in.readLine();

            if (response.startsWith("Error") || response.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No voter found or error: " + response);
                return;
            }

            // Expected format: name,cnic,age,city,na_conname,has_voted_na,pa_conname,has_voted_pa
            String[] fields = response.split(",");

            model.addRow(new Object[]{
                fields[0], // vname
                fields[1], // vcnic
                Integer.parseInt(fields[2]), // vage
                fields[3], // vcity
                fields[4] + " / " + fields[6], // NA + PA constituency
                (fields[5].equals("1") ? "Yes (NA)" : "No (NA)") + " | "
                + (fields[7].equals("1") ? "Yes (PA)" : "No (PA)")
            });
            ClientConnection.socketClose();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error communicating with server: " + e.getMessage());
        }
    }

    // Delete voter by CNIC
    public static void deleteVoterByCnic(String cnic) {
        if (cnic.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter CNIC to delete.");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(null,
                "Are you sure you want to delete this voter?",
                "Confirm Delete", JOptionPane.YES_NO_OPTION);

        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }

        try {
            ClientConnection.connectToServer();
            ClientConnection.out.println("$;" + cnic); // "$" for delete
            String response = ClientConnection.in.readLine();
            JOptionPane.showMessageDialog(null, response);
            ClientConnection.socketClose();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error communicating with server: " + e.getMessage());
        }
    }

    // Update voter data directly in voters table
    public static void updateVoterDirect(String cnic, String name, String conname, String city, String ageStr) {
        if (cnic.isEmpty() || name.isEmpty() || conname.isEmpty() || city.isEmpty() || ageStr.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill all fields to update.");
            return;
        }

        int age;
        try {

            age = Integer.parseInt(ageStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Age must be a valid number.");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(null,
                "Are you sure you want to update this voter's info?",
                "Confirm Update", JOptionPane.YES_NO_OPTION);

        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }

        try {
            ClientConnection.connectToServer();
            String data = cnic + "," + name + "," + conname + "," + city + "," + age;
            ClientConnection.out.println("#;" + data);

            String response = ClientConnection.in.readLine();
            JOptionPane.showMessageDialog(null, response);
            ClientConnection.socketClose();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Communication error: " + e.getMessage());
        }
    }

   
    public static void loadNACandidatesForVoting(String vcnic, JTable natable) {
        if (vcnic == null || vcnic.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter CNIC.");
            return;
        }

        try {
            ClientConnection.connectToServer();
            ClientConnection.out.println("%%;" + vcnic);

            String line = ClientConnection.in.readLine();

            if (line == null) {
                JOptionPane.showMessageDialog(null, "No response from server.");
                return;
            }

            if (line.equals("VOTER_NOT_FOUND")) {
                JOptionPane.showMessageDialog(null, "Voter not found.");
                return;
            }

            if (line.equals("ALREADY_VOTED")) {
                JOptionPane.showMessageDialog(null, "You have already cast your NA vote.");
                return;
            }

            if (line.startsWith("Error:")) {
                JOptionPane.showMessageDialog(null, line);
                return;
            }

            // Create table model with checkbox in last column
            DefaultTableModel model = new DefaultTableModel(
                    new Object[]{"CNIC", "Name", "Age", "City", "Constituency", "PartySymbol", "Vote"}, 0) {
                @Override
                public Class<?> getColumnClass(int columnIndex) {
                    return columnIndex == 6 ? Boolean.class : String.class;
                }

                @Override
                public boolean isCellEditable(int row, int column) {
                    return column == 6; // Only the Vote checkbox is editable
                }
            };

            model.setRowCount(0);
            String[] rows = line.split(";");
            for (String row : rows) {
                String[] cols = row.split(",");
                if (cols.length == 6) {
                    Object[] rowData = new Object[7];
                    for (int i = 0; i < 6; i++) {
                        rowData[i] = cols[i];
                    }
                    rowData[6] = false; // Initialize "Vote" column checkbox to false
                    model.addRow(rowData);
                }
            }

            natable.setModel(model);
            natable.setCellSelectionEnabled(true);
            ClientConnection.socketClose();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error loading candidates: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void loadPACandidatesForVoting(String vcnic, JTable patable) {
        if (vcnic == null || vcnic.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter CNIC.");
            return;
        }

        try {
            ClientConnection.connectToServer();
            ClientConnection.out.println("%%%;" + vcnic); // '%%%' command for PA candidates

            String line = ClientConnection.in.readLine();

            if (line == null) {
                JOptionPane.showMessageDialog(null, "No response from server.");
                return;
            }

            if (line.equals("VOTER_NOT_FOUND")) {
                JOptionPane.showMessageDialog(null, "Voter not found.");
                return;
            }

            if (line.equals("ALREADY_VOTED")) {
                JOptionPane.showMessageDialog(null, "You have already cast your PA vote.");
                return;
            }

            if (line.startsWith("Error:")) {
                JOptionPane.showMessageDialog(null, line);
                return;
            }

            // Table model with checkbox in last column
            DefaultTableModel model = new DefaultTableModel(
                    new Object[]{"CNIC", "Name", "Age", "City", "Constituency", "PartySymbol", "Vote"}, 0) {
                @Override
                public Class<?> getColumnClass(int columnIndex) {
                    return columnIndex == 6 ? Boolean.class : String.class;
                }

                @Override
                public boolean isCellEditable(int row, int column) {
                    return column == 6; // Only the Vote checkbox is editable
                }
            };

            model.setRowCount(0);
            String[] rows = line.split(";");
            for (String row : rows) {
                String[] cols = row.split(",");
                if (cols.length == 6) {
                    Object[] rowData = new Object[7];
                    for (int i = 0; i < 6; i++) {
                        rowData[i] = cols[i];
                    }
                    rowData[6] = false; // Initialize "Vote" column checkbox to false
                    model.addRow(rowData);
                }
            }

            patable.setModel(model);
            patable.setCellSelectionEnabled(true);

            ClientConnection.socketClose();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error loading PA candidates: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void castNAVote(String vcnic, JTable natable) {
        if (vcnic == null || vcnic.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter your CNIC.");
            return;
        }

        String selectedCandidateCnic = null;
        for (int i = 0; i < natable.getRowCount(); i++) {
            Boolean vote = (Boolean) natable.getValueAt(i, 6); // Column 6 = "Vote"
            if (vote != null && vote) {
                selectedCandidateCnic = natable.getValueAt(i, 0).toString(); // CNIC
                break;
            }
        }

        if (selectedCandidateCnic == null) {
            JOptionPane.showMessageDialog(null, "Please select a candidate to vote.");
            return;
        }

        try {
            ClientConnection.connectToServer();
            // Send command + data in format: "NAVOTE;vcnic,candidateCnic"
            ClientConnection.out.println("!@;" + vcnic + "," + selectedCandidateCnic);

            String response = ClientConnection.in.readLine();
            JOptionPane.showMessageDialog(null, response);

            ClientConnection.socketClose();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error connecting to server: " + e.getMessage());
        }
    }

    public static void castPAVote(String vcnic, JTable patable) {
        if (vcnic == null || vcnic.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter your CNIC.");
            return;
        }

        String selectedCandidateCnic = null;
        for (int i = 0; i < patable.getRowCount(); i++) {
            Boolean vote = (Boolean) patable.getValueAt(i, 6); // Column 6 = "Vote"
            if (vote != null && vote) {
                selectedCandidateCnic = patable.getValueAt(i, 0).toString(); // Candidate CNIC
                break;
            }
        }

        if (selectedCandidateCnic == null) {
            JOptionPane.showMessageDialog(null, "Please select a candidate to vote.");
            return;
        }

        try {
            ClientConnection.connectToServer();
            ClientConnection.out.println("!!@@;" + vcnic + "," + selectedCandidateCnic);

            String response = ClientConnection.in.readLine();
            JOptionPane.showMessageDialog(null, response);

            ClientConnection.socketClose();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error connecting to server: " + e.getMessage());
        }
    }

}
//public static void updateVoterDirect(String cnic, String name, String conname, String city, String ageStr) {
//    if (cnic.isEmpty() || name.isEmpty() || conname.isEmpty() || city.isEmpty() || ageStr.isEmpty()) {
//        JOptionPane.showMessageDialog(null, "Please fill all fields to update.");
//        return;
//    }
//
//    int age;
//    try {
//        age = Integer.parseInt(ageStr);
//    } catch (NumberFormatException e) {
//        JOptionPane.showMessageDialog(null, "Age must be a valid number.");
//        return;
//    }
//
//    int confirm = JOptionPane.showConfirmDialog(null, 
//        "Are you sure you want to update this voter's info?", 
//        "Confirm Update", JOptionPane.YES_NO_OPTION);
//    
//    if (confirm != JOptionPane.YES_OPTION) return;
//
//    try {
//        Class.forName("com.mysql.cj.jdbc.Driver");
//        Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/EMS", "root", "UO2@iTSn");
//
//        String sql = """
//            UPDATE voters 
//            SET vname = ?, 
//                vage = ?, 
//                vcity = ?, 
//                vconname = ? 
//            WHERE vcnic = ?
//        """;
//
//        PreparedStatement ps = con.prepareStatement(sql);
//        ps.setString(1, name);
//        ps.setInt(2, age);
//        ps.setString(3, city);
//        ps.setString(4, conname);
//        ps.setString(5, cnic);
//
//        int rows = ps.executeUpdate();
//        if (rows > 0) {
//            JOptionPane.showMessageDialog(null, "Voter updated successfully.");
//        } else {
//            JOptionPane.showMessageDialog(null, "No voter found with this CNIC.");
//        }
//
//        con.close();
//    } catch (Exception e) {
//        JOptionPane.showMessageDialog(null, "Update error: " + e.getMessage());
//    }
//} 
//
//public static void deleteVoterByCnic(String cnic) {
//        if (cnic.isEmpty()) {
//            JOptionPane.showMessageDialog(null, "Please enter CNIC to delete.");
//            return;
//        }
//
//        int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this voter?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
//        if (confirm != JOptionPane.YES_OPTION) return;
//
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/EMS", "root", "UO2@iTSn");
//
//            String sql = "DELETE FROM voters WHERE vcnic = ?";
//            PreparedStatement ps = con.prepareStatement(sql);
//            ps.setString(1, cnic);
//            int rows = ps.executeUpdate();
//
//            if (rows > 0) {
//                JOptionPane.showMessageDialog(null, "Voter deleted successfully.");
//            } else {
//                JOptionPane.showMessageDialog(null, "No voter found with that CNIC.");
//            }
//
//            con.close();
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Delete error: " + e.getMessage());
//        }
//    }
// Load all voters from 'voters' table
//    public static void loadVoterData(JTable table) {
//    DefaultTableModel model = (DefaultTableModel) table.getModel();
//    model.setRowCount(0); // Clear existing rows
//
//    try {
//        Class.forName("com.mysql.cj.jdbc.Driver");
//        Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/EMS", "root", "UO2@iTSn");
//
//        String sql = "SELECT vname, vcnic, vage, vcity, na_conname, pa_conname, has_voted_na, has_voted_pa FROM voters";
//        PreparedStatement ps = con.prepareStatement(sql);
//        ResultSet rs = ps.executeQuery();
//
//        while (rs.next()) {
//            model.addRow(new Object[]{
//                rs.getString("vname"),
//                rs.getString("vcnic"),
//                rs.getInt("vage"),
//                rs.getString("vcity"),
//                rs.getString("na_conname"),
//                rs.getString("pa_conname"),
//                rs.getBoolean("has_voted_na") ? "Yes" : "No",
//                rs.getBoolean("has_voted_pa") ? "Yes" : "No"
//            });
//        }
//
//        con.close();
//    } catch (Exception e) {
//        JOptionPane.showMessageDialog(null, "Error loading voter data: " + e.getMessage());
//    }
//}

//public static void searchVoterByCnic(JTable table, String cnic) {
//        DefaultTableModel model = (DefaultTableModel) table.getModel();
//        model.setRowCount(0);
//
//        if (cnic.isEmpty()) {
//            JOptionPane.showMessageDialog(null, "Please enter CNIC to search.");
//            return;
//        }
//
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/EMS", "root", "UO2@iTSn");
//
//            String sql = "SELECT vname, vcnic, vage, vcity, vconname, has_voted FROM voters WHERE vcnic = ?";
//            PreparedStatement ps = con.prepareStatement(sql);
//            ps.setString(1, cnic);
//            ResultSet rs = ps.executeQuery();
//
//            while (rs.next()) {
//                model.addRow(new Object[]{
//                    rs.getString("vname"),
//                    rs.getString("vcnic"),
//                    rs.getInt("vage"),
//                    rs.getString("vcity"),
//                    rs.getString("vconname"),
//                    rs.getBoolean("has_voted") ? "Yes" : "No"
//                });
//            }
//
//            con.close();
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Search error: " + e.getMessage());
//        }
//    } change this as you have change above 
//public static void loadPACandidatesForVoting(String vcnic, JTable table) {
//    if (vcnic == null || vcnic.trim().isEmpty()) {
//        JOptionPane.showMessageDialog(null, "Please enter CNIC.");
//        return;
//    }
//
//    try (Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/EMS", "root", "UO2@iTSn")) {
//        PreparedStatement voterStmt = con.prepareStatement("SELECT pa_conname, has_voted_pa, vcity FROM voters WHERE vcnic = ?");
//        voterStmt.setString(1, vcnic);
//        ResultSet voterRS = voterStmt.executeQuery();
//
//        if (!voterRS.next()) {
//            JOptionPane.showMessageDialog(null, "Voter not found.");
//            return;
//        }
//
//        String conname = voterRS.getString("pa_conname");
//        boolean hasVotedPA = voterRS.getBoolean("has_voted_pa");
//        String city = voterRS.getString("vcity");
//
//        if (hasVotedPA) {
//            JOptionPane.showMessageDialog(null, "You have already cast your PA vote.");
//            return;
//        }
//
//        String sql = """
//            SELECT c.ccnic, c.cname, c.cage, ?, co.conname, p.plogo, c.csymbol
//            FROM candidates c
//            JOIN constituency co ON c.constituency_id = co.constituency_id
//            JOIN parties p ON c.party_id = p.party_id
//            WHERE co.conname = ? AND co.contype = 'PA'
//        """;
//
//        PreparedStatement ps = con.prepareStatement(sql);
//        ps.setString(1, city);
//        ps.setString(2, conname);
//        ResultSet rs = ps.executeQuery();
//
//        DefaultTableModel model = new DefaultTableModel(
//            new Object[]{"CNIC", "Name", "Age", "City", "Constituency", "PartySymbol", "Vote"}, 0) {
//            @Override
//            public Class<?> getColumnClass(int columnIndex) {
//                return columnIndex == 6 ? Boolean.class : String.class;
//            }
//
//            @Override
//            public boolean isCellEditable(int row, int column) {
//                return column == 6;
//            }
//        };
//
//        while (rs.next()) {
//            model.addRow(new Object[]{
//                rs.getString("ccnic"),
//                rs.getString("cname"),
//                rs.getInt("cage"),
//                city,
//                rs.getString("conname"),
//                rs.getString("plogo"),
//                false
//            });
//        }
//
//        table.setModel(model);
//
//    } catch (Exception e) {
//        JOptionPane.showMessageDialog(null, "Error loading PA candidates: " + e.getMessage());
//    }
//}  
//public static void loadNACandidatesForVoting(String vcnic, JTable table) {
//    if (vcnic == null || vcnic.trim().isEmpty()) {
//        JOptionPane.showMessageDialog(null, "Please enter CNIC.");
//        return;
//    }
//
//    try (Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/EMS", "root", "UO2@iTSn")) {
//        PreparedStatement voterStmt = con.prepareStatement("SELECT na_conname, has_voted_na, vcity FROM voters WHERE vcnic = ?");
//        voterStmt.setString(1, vcnic);
//        ResultSet voterRS = voterStmt.executeQuery();
//
//        if (!voterRS.next()) {
//            JOptionPane.showMessageDialog(null, "Voter not found.");
//            return;
//        }
//
//        String conname = voterRS.getString("na_conname");
//        boolean hasVotedNA = voterRS.getBoolean("has_voted_na");
//        String city = voterRS.getString("vcity");
//
//        if (hasVotedNA) {
//            JOptionPane.showMessageDialog(null, "You have already cast your NA vote.");
//            return;
//        }
//
//        String sql = """
//            SELECT c.ccnic, c.cname, c.cage, ?, co.conname, p.plogo, c.csymbol
//            FROM candidates c
//            JOIN constituency co ON c.constituency_id = co.constituency_id
//            JOIN parties p ON c.party_id = p.party_id
//            WHERE co.conname = ? AND co.contype = 'NA'
//        """;
//
//        PreparedStatement ps = con.prepareStatement(sql);
//        ps.setString(1, city);
//        ps.setString(2, conname);
//        ResultSet rs = ps.executeQuery();
//
//        DefaultTableModel model = new DefaultTableModel(
//            new Object[]{"CNIC", "Name", "Age", "City", "Constituency", "PartySymbol", "Vote"}, 0) {
//            @Override
//            public Class<?> getColumnClass(int columnIndex) {
//                return columnIndex == 6 ? Boolean.class : String.class;
//            }
//
//            @Override
//            public boolean isCellEditable(int row, int column) {
//                return column == 6;
//            }
//        };
//
//        while (rs.next()) {
//            model.addRow(new Object[]{
//                rs.getString("ccnic"),
//                rs.getString("cname"),
//                rs.getInt("cage"),
//                city,
//                rs.getString("conname"),
//                rs.getString("plogo"),
//                false
//            });
//        }
//
//        table.setModel(model);
//
//    } catch (Exception e) {
//        JOptionPane.showMessageDialog(null, "Error loading NA candidates: " + e.getMessage());
//    }
//}
