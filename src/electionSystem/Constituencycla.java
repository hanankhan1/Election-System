//full ok ha
package electionSystem;
import java.io.IOException;
 import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
public class Constituencycla {
  
    public static void addConstituency(String conname, String contype, String concity, String conprovience) {
    if (conname.isEmpty() || contype.isEmpty() || concity.isEmpty() || conprovience.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Please fill in all fields before adding a constituency.");
        return;
    }

    try {
        ClientConnection.connectToServer();
        String data = conname + "," + contype + "," + concity + "," + conprovience;
        ClientConnection.out.println("@@@;" + data);  // Use '&' to denote "AddConstituency"
        String response = ClientConnection.in.readLine();
        JOptionPane.showMessageDialog(null, response);
        ClientConnection.socketClose();
    } catch (IOException e) {
        JOptionPane.showMessageDialog(null, "Error communicating with server: " + e.getMessage());
    }
}

 public static void loadConstituencies(JTable table) {
    DefaultTableModel model = (DefaultTableModel) table.getModel();
    model.setRowCount(0); // Clear old rows

    try {
        ClientConnection.connectToServer();
        ClientConnection.out.println("&");  // Custom command to request constituency data

        String line;
        while ((line = ClientConnection.in.readLine()) != null) {
            if (line.equals("No constituencies found.") || line.startsWith("Error")) {
                JOptionPane.showMessageDialog(null, line);
                break;
            }

            String[] parts = line.split(",", -1); // Allow empty fields
            if (parts.length == 5) {
                model.addRow(new Object[] {
                    Integer.parseInt(parts[0]), // constituency_id
                    parts[1],                   // conname
                    parts[2],                   // contype
                    parts[3],                   // concity
                    parts[4]                    // conprovience
                });
            }
        }

        ClientConnection.socketClose();
    } catch (IOException e) {
        JOptionPane.showMessageDialog(null, "Error receiving constituency data: " + e.getMessage());
    }
}


 public static void searchByName(String name, JTable table) {
    DefaultTableModel model = (DefaultTableModel) table.getModel();
    model.setRowCount(0);

    if (name.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Please enter a constituency name to search.");
        return;
    }

    try {
        ClientConnection.connectToServer();
        ClientConnection.out.println("^^^;" + name);  // Use '*' to represent search by constituency name
        String response = ClientConnection.in.readLine();

        if (response == null || response.equals("No Records")) {
            JOptionPane.showMessageDialog(null, "No matching constituencies found.");
            return;
        }

        String[] rows = response.split("\n");
        for (String row : rows) {
            String[] fields = row.split(",");
            if (fields.length == 5) {
                model.addRow(new Object[]{
                    Integer.parseInt(fields[0]),  // constituency_id
                    fields[1],                    // conname
                    fields[2],                    // contype
                    fields[3],                    // concity
                    fields[4]                     // conprovience
                });
            }
        }
ClientConnection.socketClose();
    } catch (IOException e) {
        JOptionPane.showMessageDialog(null, "Communication error: " + e.getMessage());
    }
}

public static void update(String id, String name, String type, String city, String prov) {
    if (id.isEmpty() || name.isEmpty() || type.isEmpty() || city.isEmpty() || prov.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Please fill in all fields to update.");
        return;
    }

    try {
        ClientConnection.connectToServer();
        String data = id + "," + name + "," + type + "," + city + "," + prov;
        ClientConnection.out.println("###;" + data);  // '&' used as updateConstituency command
        String response = ClientConnection.in.readLine();

        JOptionPane.showMessageDialog(null, response);
        ClientConnection.socketClose();
    } catch (IOException e) {
        JOptionPane.showMessageDialog(null, "Communication error: " + e.getMessage());
    }
}

 public static void delete(String id) {
    if (id.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Please provide a constituency ID to delete.");
        return;
    }

    int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this constituency?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
    if (confirm != JOptionPane.YES_OPTION) return;

    try {
        ClientConnection.connectToServer();
        ClientConnection.out.println("$$$;" + id);  // * is command for deleteConstituency
        String response = ClientConnection.in.readLine();
        JOptionPane.showMessageDialog(null, response);
        ClientConnection.socketClose();
    } catch (IOException e) {
        JOptionPane.showMessageDialog(null, "Communication error: " + e.getMessage());
    }
}

}
// public static void addConstituency(String conname, String contype, String concity, String conprovience) 
//    {
//        if (conname.isEmpty() || contype.isEmpty() || concity.isEmpty() || conprovience.isEmpty()) {
//            JOptionPane.showMessageDialog(null, "Please fill in all fields before adding a constituency.");
//            return;
//        }
//
//        try {
//            // 1. Load MySQL Driver
//            Class.forName("com.mysql.cj.jdbc.Driver");
//
//            // 2. Connect to Database
//            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/EMS", "root", "UO2@iTSn");
//
//            // 3. Prepare Insert Query
//            String sql = "INSERT INTO constituency (conname, contype, concity, conprovience) VALUES (?, ?, ?, ?)";
//            PreparedStatement ps = con.prepareStatement(sql);
//            ps.setString(1, conname);
//            ps.setString(2, contype);
//            ps.setString(3, concity);
//            ps.setString(4, conprovience);
//
//            int rows = ps.executeUpdate();
//
//            if (rows > 0) {
//                JOptionPane.showMessageDialog(null, "Constituency added successfully.");
//            } else {
//                JOptionPane.showMessageDialog(null, "Failed to add constituency.");
//            }
//
//            con.close();
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
//        }
//    }
// public static void searchByName(String name, JTable table) {
//        DefaultTableModel model = (DefaultTableModel) table.getModel();
//        model.setRowCount(0);
//
//        try {
//            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/EMS", "root", "UO2@iTSn");
//            PreparedStatement ps = con.prepareStatement("SELECT * FROM constituency WHERE conname LIKE ?");
//            ps.setString(1, "%" + name + "%");
//
//            ResultSet rs = ps.executeQuery();
//
//            while (rs.next()) {
//                model.addRow(new Object[]{
//                    rs.getInt("constituency_id"),
//                    rs.getString("conname"),
//                    rs.getString("contype"),
//                    rs.getString("concity"),
//                    rs.getString("conprovience")
//                });
//            }
//
//            con.close();
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Search Error: " + e.getMessage());
//        }
//    }

//public static void update(String id, String name, String type, String city, String prov) {
//        try {
//            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/EMS", "root", "UO2@iTSn");
//
//            PreparedStatement ps = con.prepareStatement(
//                "UPDATE constituency SET conname=?, contype=?, concity=?, conprovience=? WHERE constituency_id=?"
//            );
//            ps.setString(1, name);
//            ps.setString(2, type);
//            ps.setString(3, city);
//            ps.setString(4, prov);
//            ps.setInt(5, Integer.parseInt(id));
//
//            int rows = ps.executeUpdate();
//
//            if (rows > 0) {
//                JOptionPane.showMessageDialog(null, "Constituency updated successfully.");
//            } else {
//                JOptionPane.showMessageDialog(null, "No record updated.");
//            }
//
//            con.close();
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Update error: " + e.getMessage());
//        }
//    }
//
//public static void delete(String id) {
//        try {
//            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/EMS", "root", "UO2@iTSn");
//
//            PreparedStatement ps = con.prepareStatement("DELETE FROM constituency WHERE constituency_id = ?");
//            ps.setInt(1, Integer.parseInt(id));
//
//            int rows = ps.executeUpdate();
//
//            if (rows > 0) {
//                JOptionPane.showMessageDialog(null, "Constituency deleted.");
//            } else {
//                JOptionPane.showMessageDialog(null, "No such constituency found.");
//            }
//
//            con.close();
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Delete error: " + e.getMessage());
//        }
//    }
