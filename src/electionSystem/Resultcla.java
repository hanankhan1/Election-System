//full ok
package electionSystem;

import java.io.IOException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JTextField;

public class Resultcla {
//   public static long endTime_milis=0;

    public static void getPAResult(JTable patable) {
        DefaultTableModel model = (DefaultTableModel) patable.getModel();
        model.setRowCount(0); // Clear table first

        try {
            ClientConnection.connectToServer();
            ClientConnection.out.println("%%%%%%"); // Command to request PA result

            String line;
            while ((line = ClientConnection.in.readLine()) != null) {
                if (line.equals("END_OF_PA_RESULT")) {
                    break;
                }

                if (line.startsWith("Error")) {
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
                        parts[6] // Outcome
                    });
                }
            }

            ClientConnection.socketClose();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error retrieving PA results: " + e.getMessage());
        }
    }

    public static void getNAResult(JTable natable) {
        DefaultTableModel model = (DefaultTableModel) natable.getModel();
        model.setRowCount(0);

        try {
            ClientConnection.connectToServer();
            ClientConnection.out.println("%%%%%%%"); // Request NA result

            String line;
            while ((line = ClientConnection.in.readLine()) != null) {
                if (line.equals("END_OF_NA_RESULT")) {
                    break;
                }

                if (line.startsWith("Error")) {
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
                        parts[6] // Outcome
                    });
                }
            }

            ClientConnection.socketClose();

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error receiving NA results: " + e.getMessage());
        }
    }

    public static void startElection(JTextField year, JTextField date, JTextField time) {
        try {
            String electionYearStr = year.getText();
            String endDateStr = date.getText();
            String endTime12Str = time.getText();

            if (electionYearStr == null || endDateStr == null || endTime12Str == null
                    || electionYearStr.trim().isEmpty() || endDateStr.trim().isEmpty() || endTime12Str.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "All fields are required.");
                return;
            }

            int electionYear = Integer.parseInt(electionYearStr);

            // Get current date and time
            LocalDate currentDate = LocalDate.now();
            LocalTime currentTime = LocalTime.now();
            String startDate = currentDate.toString();
            String startTime = currentTime.format(DateTimeFormatter.ofPattern("HH:mm:ss"));

            // Convert 12-hour time to 24-hour format
            SimpleDateFormat inputFormat = new SimpleDateFormat("hh:mm a");
            SimpleDateFormat outputFormat = new SimpleDateFormat("HH:mm:ss");
            Date endParsed = inputFormat.parse(endTime12Str);
            String endTime24Str = outputFormat.format(endParsed);

            // Prepare data to send
            String dataToSend = String.join(",",
                    String.valueOf(electionYear),
                    startDate,
                    startTime,
                    endDateStr,
                    endTime24Str
            );

            // Send to server
            ClientConnection.connectToServer();
            ClientConnection.out.println("!!;" + dataToSend);
            String response = ClientConnection.in.readLine();
            JOptionPane.showMessageDialog(null, response);
            ClientConnection.socketClose();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid year format.");
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Invalid end time format. Use format like 06:00 PM.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }
}