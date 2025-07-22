//full ok 
package electionSystem;

import Designe.AdminDash;
import Designe.CandidateDash;
import Designe.VoterDash;
import java.io.IOException;
import java.sql.*;
import javax.swing.*;

public class Logincla {

    public String logcnic;

    public static void loginUser(String cnic, String password, String role, JFrame currentFrame) {
        // Input validation
        String ucnic = cnic;

        if (cnic.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter your CNIC.");
            return;
        }
        if (password.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter your password.");
            return;
        }
        if (role == null || role.equals("Select Role")) {
            JOptionPane.showMessageDialog(null, "Please select a user role.");
            return;
        }

        // Admin (hardcoded)
        if (role.equals("Admin")) {
            if (cnic.equals("35401-7589883-7") && password.equals("1122")) { 
                currentFrame.dispose();
                new AdminDash().setVisible(true);
                return;
            } else {
                JOptionPane.showMessageDialog(null, "Invalid Admin credentials.");
                return;
            }
        }

        // Client-Server login
        try {
            ClientConnection.connectToServer();
            String data = cnic + "," + password + "," + role;
            ClientConnection.out.println("!;" + data);
            String response = ClientConnection.in.readLine();

            if (response.startsWith("Success")) {
                currentFrame.dispose();
                if (role.equals("Voter")) {
                    new VoterDash(cnic).setVisible(true);
                } else if (role.equals("Candidate")) {

                    new CandidateDash(cnic).setVisible(true);
                }

            } else {
                JOptionPane.showMessageDialog(null, response); // Shows error returned by server
            }
            ClientConnection.socketClose();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Server communication error: " + e.getMessage());
        }
    }

}
