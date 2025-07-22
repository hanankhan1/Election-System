//full ok
package electionSystem;

import Designe.Login;
import Designe.VRegForm;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class Registartion {

    public static void registerUser(
            String name, String cnic, String dob, String ageText, String city,
            String pass, String cpass, String question, String answer, String gender
    ) {
        // Validate individual fields
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter your name.");
            return;
        }
        if (cnic.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter your CNIC.");
            return;
        }
        if (!cnic.matches("\\d{5}-\\d{7}-\\d")) {
            JOptionPane.showMessageDialog(null, "CNIC format is invalid. Use xxxxx-xxxxxxx-x.");
            return;
        }
        if (dob.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter your date of birth.");
            return;
        }
        if (ageText.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter your age.");
            return;
        }

        int age;
        try {
            age = Integer.parseInt(ageText);
            if (age < 18) {
                JOptionPane.showMessageDialog(null, "Voter must be at least 18 years old.");
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please enter a valid number for age.");
            return;
        }

        if (city.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter your city.");
            return;
        }
        if (pass.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter a password.");
            return;
        }
        if (cpass.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please confirm your password.");
            return;
        }
        if (!pass.equals(cpass)) {
            JOptionPane.showMessageDialog(null, "Passwords do not match.");
            return;
        }
        if (question == null || question.equals("Select a question")) {
            JOptionPane.showMessageDialog(null, "Please select a security question.");
            return;
        }
        if (answer.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please answer the security question.");
            return;
        }
        if (gender == null || gender.equals("Select gender")) {
            JOptionPane.showMessageDialog(null, "Please select your gender.");
            return;
        }
        try {
            ClientConnection.connectToServer();
            String data = name + "," + cnic + "," + dob + "," + age + "," + city + "," + pass + "," + question + "," + answer + "," + gender;
            ClientConnection.out.println("@;" + data);
            String response = ClientConnection.in.readLine();
            System.out.println("Add Voter Response: " + response + "\n");
            
            ClientConnection.socketClose();
        } catch (IOException e) {
            System.out.println("Error communicating with server: " + e.getMessage() + "\n");
        }
        //Proceed to registration direct data base
//    try {
//        Class.forName("com.mysql.cj.jdbc.Driver");
//        Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/EMS", "root", "UO2@iTSn");
//
//        // Check for duplicate CNIC
//        PreparedStatement checkStmt = con.prepareStatement("SELECT * FROM users WHERE ucnic = ?");
//        checkStmt.setString(1, cnic);
//        ResultSet rs = checkStmt.executeQuery();
//        if (rs.next()) {
//            JOptionPane.showMessageDialog(null, "This CNIC is already registered.");
//            return;
//        }

//        // Insert into users table
//        PreparedStatement ps = con.prepareStatement(
//            "INSERT INTO users (uname, ucnic, udob, uage, ucity, upass, upuestion, uanswer, ugender) " +
//            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)"
//        );
//        ps.setString(1, name);
//        ps.setString(2, cnic);
//        ps.setString(3, dob);
//        ps.setInt(4, age);
//        ps.setString(5, city);
//        ps.setString(6, pass);
//        ps.setString(7, question);
//        ps.setString(8, answer);
//        ps.setString(9, gender);
//
//        int i = ps.executeUpdate();
//        ps.close();
//
//        if (i > 0) {
//            // Now insert into voters table based on matching city with constituency
//            PreparedStatement voterStmt = con.prepareStatement(
//                "INSERT INTO voters (vcnic, vname, vage, vcity, vconname) " +
//                "SELECT ?, ?, ?, ?, c.conname FROM constituency c WHERE c.concity = ?"
//            );
//            voterStmt.setString(1, cnic);
//            voterStmt.setString(2, name);
//            voterStmt.setInt(3, age);
//            voterStmt.setString(4, city);
//            voterStmt.setString(5, city);
//
//            int voterRows = voterStmt.executeUpdate();
//            voterStmt.close();
//
//            if (voterRows > 0) {
//                JOptionPane.showMessageDialog(null, "Registration successful! Voter added.");
//            } else {
//                JOptionPane.showMessageDialog(null, "User registered, but voter not added (no matching constituency).");
//            }
//        } else {
//            JOptionPane.showMessageDialog(null, "Registration failed.");
//        }
//
//        con.close();
//    } catch (Exception e) {
//        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
//    }
//}
    }
}
