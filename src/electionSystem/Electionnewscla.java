// ful ok ha
package electionSystem;
import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Electionnewscla {
    
    public static void addNews(String newsText, JTable table) {
    if (newsText.trim().isEmpty()) {
        JOptionPane.showMessageDialog(null, "News content cannot be empty.");
        return;
    }

    try {
        ClientConnection.connectToServer();
        // Send command with news data to server
        ClientConnection.out.println("@@@@@;" + newsText.trim());

        // Read and show server response
        String response = ClientConnection.in.readLine();
        JOptionPane.showMessageDialog(null, response);

        
        if (response.equalsIgnoreCase("Election news added successfully.")) {
            showNewsInTable(table);  
        }
ClientConnection.socketClose();
    } catch (IOException e) {
        JOptionPane.showMessageDialog(null, "Communication Error: " + e.getMessage());
    }
}

    
public static void loadNewsIntoTextArea(JTextArea newsArea) {
    try {
        ClientConnection.connectToServer();
        // Send request to server
        ClientConnection.out.println("#####");  // Command to get news
        StringBuilder sb = new StringBuilder();
        String line;

        // Read full response until null (or implement a delimiter like "END" if needed)
        while ((line = ClientConnection.in.readLine()) != null) {
            sb.append(line).append("\n");
            if (line.trim().equals("END")) break;
        }

        // Set text in the news area
        String result = sb.toString().replace("END\n", "").trim();
        newsArea.setText(result);
        ClientConnection.socketClose();
    } catch (IOException e) {
        JOptionPane.showMessageDialog(null, "Error loading news: " + e.getMessage());
    }
}

public static void showNewsInTable(JTable table) {
    try {
        ClientConnection.connectToServer();
        ClientConnection.out.println("%%%%%%%%");  // Request server to send news data

        String line;
        DefaultTableModel model = new DefaultTableModel(new String[]{"ID", "News", "Posted At"}, 0);

        while ((line = ClientConnection.in.readLine()) != null) {
            if (line.equals("No data") || line.startsWith("Error")) {
                JOptionPane.showMessageDialog(null, line);
                break;
            }

            String[] parts = line.split(",", 3); // Split into 3 parts only
            if (parts.length == 3) {
                model.addRow(new Object[]{
                    Integer.parseInt(parts[0]),
                    parts[1],
                    parts[2]
                });
            }
        }

        table.setModel(model);
ClientConnection.socketClose();
    } catch (IOException e) {
        JOptionPane.showMessageDialog(null, "Error receiving news data: " + e.getMessage());
    }
}


public static void deleteNewsByTextField(JTextField newsidField, JTable table, JTextArea candidateNews, JTextArea voterNews) {
    String idText = newsidField.getText().trim();

    if (idText.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Please enter or select a News ID to delete.");
        return;
    }

    try {
        ClientConnection.connectToServer();
        ClientConnection.out.println("$$$$$;" + idText);
        String response = ClientConnection.in.readLine();

        JOptionPane.showMessageDialog(null, response);

        if (response.equals("News deleted successfully.")) {
            // Clear input field
            newsidField.setText("");

            // Refresh table and text areas
            showNewsInTable(table);
            showNewsInTextArea(candidateNews);
            showNewsInTextArea(voterNews);
        }
ClientConnection.socketClose();
    } catch (IOException e) {
        JOptionPane.showMessageDialog(null, "Error communicating with server: " + e.getMessage());
    }
}

public static void showNewsInTextArea(JTextArea textArea) {
     try {
         ClientConnection.connectToServer();
        ClientConnection.out.println("&&&&&");  // Request formatted news
        StringBuilder responseBuilder = new StringBuilder();
        String line;

        // Read multi-line news from server until it finishes (assuming END signal not required here)
        while ((line = ClientConnection.in.readLine()) != null) {
            responseBuilder.append(line).append("\n");
            // Optional: break if server is sending one long line
            break;
        }

        textArea.setText(responseBuilder.toString());
        ClientConnection.socketClose();
    } catch (IOException e) {
        JOptionPane.showMessageDialog(null, "Error loading news from server: " + e.getMessage());
    }
}


}
// public static void addNews(String news, JTable table) {
//    if (news.isEmpty()) {
//        JOptionPane.showMessageDialog(null, "News content cannot be empty.");
//        return;
//    }
//
//    try {
//        Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/EMS", "root", "UO2@iTSn");
//        PreparedStatement ps = con.prepareStatement("INSERT INTO electionnews (news) VALUES (?)");
//        ps.setString(1, news);
//        int rows = ps.executeUpdate();
//
//        if (rows > 0) {
//            JOptionPane.showMessageDialog(null, "Election news added successfully.");
//            // Refresh the news table immediately
//            showNewsInTable(table);
//        } else {
//            JOptionPane.showMessageDialog(null, "Failed to add news.");
//        }
//
//        ps.close();
//        con.close();
//    } catch (Exception e) {
//        JOptionPane.showMessageDialog(null, "Database Error: " + e.getMessage());
//    }
//}
//public static void loadNewsIntoTextArea(JTextArea newsArea) {
//    try {
//        Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/EMS", "root", "UO2@iTSn");
//        Statement stmt = con.createStatement();
//        ResultSet rs = stmt.executeQuery("SELECT news, posted_at FROM electionnews ORDER BY posted_at DESC");
//
//        StringBuilder sb = new StringBuilder();
//        while (rs.next()) {
//            sb.append("Date: ").append(rs.getTimestamp("posted_at")).append("\n");
//            sb.append(rs.getString("news")).append("\n\n");
//        }
//
//        newsArea.setText(sb.toString());
//
//        rs.close();
//        stmt.close();
//        con.close();
//    } catch (Exception e) {
//        JOptionPane.showMessageDialog(null, "Error loading news: " + e.getMessage());
//    }
//}
//public static void deleteNewsByTextField(JTextField newsidField, JTable table, JTextArea candidateNews, JTextArea voterNews) {
//    String idText = newsidField.getText().trim();
//
//    if (idText.isEmpty()) {
//        JOptionPane.showMessageDialog(null, "Please enter or select a News ID to delete.");
//        return;
//    }
//
//    try {
//        int newsId = Integer.parseInt(idText);
//
//        Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/EMS", "root", "UO2@iTSn");
//
//        PreparedStatement ps = con.prepareStatement("DELETE FROM electionnews WHERE id = ?");
//        ps.setInt(1, newsId);
//
//        int rows = ps.executeUpdate();
//
//        if (rows > 0) {
//            JOptionPane.showMessageDialog(null, "News deleted successfully.");
//
//            // Clear field
//            newsidField.setText("");
//
//            // Refresh the table
//            showNewsInTable(table);
//
//            // Refresh dashboards (assuming showNewsInTextArea updates the JTextArea from DB)
//            showNewsInTextArea(candidateNews);
//            showNewsInTextArea(voterNews);
//
//        } else {
//            JOptionPane.showMessageDialog(null, "No news found with the given ID.");
//        }
//
//        ps.close();
//        con.close();
//
//    } catch (NumberFormatException e) {
//        JOptionPane.showMessageDialog(null, "Invalid News ID. Please enter a number.");
//    } catch (Exception e) {
//        JOptionPane.showMessageDialog(null, "Error deleting news: " + e.getMessage());
//    }
//}
//public static void showNewsInTextArea(JTextArea textArea) {
//    try {
//        Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/EMS", "root", "UO2@iTSn");
//        Statement stmt = con.createStatement();
//        ResultSet rs = stmt.executeQuery("SELECT news FROM electionnews ORDER BY posted_at DESC");
//
//        StringBuilder newsBuilder = new StringBuilder();
//        while (rs.next()) {
//            newsBuilder.append("• ").append(rs.getString("news")).append("\n\n");
//        }
//
//        textArea.setText(newsBuilder.toString());
//
//        rs.close();
//        stmt.close();
//        con.close();
//    } catch (Exception e) {
//        JOptionPane.showMessageDialog(null, "Error loading news: " + e.getMessage());
//    }
//}
// public static void showNewsInTable(JTable table) {
//        try {
//            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/EMS", "root", "UO2@iTSn");
//            Statement stmt = con.createStatement();
//            ResultSet rs = stmt.executeQuery("SELECT id, news, posted_at FROM electionnews ORDER BY id DESC");
//
//            DefaultTableModel model = new DefaultTableModel(new String[]{"ID", "News", "Posted At"}, 0);
//
//            while (rs.next()) {
//                int id = rs.getInt("id");
//                String news = rs.getString("news");
//                Timestamp time = rs.getTimestamp("posted_at");
//                String formattedTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(time);
//
//                model.addRow(new Object[]{id, news, formattedTime});
//            }
//
//            table.setModel(model);
//
//            rs.close();
//            stmt.close();
//            con.close();
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Error loading news: " + e.getMessage());
//        }
//    }

