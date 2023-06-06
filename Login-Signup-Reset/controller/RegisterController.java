/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.RegisterModel;
import view.RegisterView;
import model.*;
import view.*;
import javax.swing.*;
import java.sql.*;

/**
 *
 * @author BEASTMODE
 */
public class RegisterController {
    
    RegisterModel model;
    RegisterView view;
    ResultSet rs;
    PreparedStatement pst=null;
    
     public RegisterController(RegisterView view)
    {
        this.view = view;
        
        new RegisterListener().actionPerformed();
    }
     
 class RegisterListener {
    public void actionPerformed() {
        try {
            model = view.getUser();
            
            String password = model.getPassword(); // Get the value from the password field
            String confirmPassword = model.getConfirmpass(); // Get the value from the confirmPassword field

            // Check if any of the fields are empty
            if (model.getUsername().isEmpty() || model.getFirstname().isEmpty() ||
                model.getLastname().isEmpty() || model.getPhonenumber().isEmpty() ||
                model.getSec_question().isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill in all the fields");
                return;
            }

            if (password.equals(confirmPassword)) { // Check if the password and confirmPassword values are the same
                if (insertUser(model)) { // Insert the data into the database
                    JOptionPane.showMessageDialog(null, "Data Registered Successfully");
                } else {
                    view.setMessage("Failed to register. Please try again.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Password and Confirm Password values do not match");
            }
            
        } catch (Exception e1) {
            System.out.println(e1.getMessage());
        }
    }
    }
    
    public boolean insertUser(RegisterModel user) throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/futsaldb", "root", "#IMUNITED@2002");
    
            // Check if the username already exists
            String checkUsernameQuery = "SELECT COUNT(*) FROM credentials WHERE username = ?";
            PreparedStatement checkUsernameStmt = conn.prepareStatement(checkUsernameQuery);
            checkUsernameStmt.setString(1, user.getUsername());
            ResultSet usernameResult = checkUsernameStmt.executeQuery();
            usernameResult.next();
            int usernameCount = usernameResult.getInt(1);
            if (usernameCount > 0) {
                System.out.println("Username already exists");
                JOptionPane.showMessageDialog(null, "Username already exists\n Try different Username");
                return false;
            }
    
            // Check if the phone number already exists
            String checkPhoneNumberQuery = "SELECT COUNT(*) FROM credentials WHERE phnumber = ?";
            PreparedStatement checkPhoneNumberStmt = conn.prepareStatement(checkPhoneNumberQuery);
            checkPhoneNumberStmt.setString(1, user.getPhonenumber());
            ResultSet phoneNumberResult = checkPhoneNumberStmt.executeQuery();
            phoneNumberResult.next();
            int phoneNumberCount = phoneNumberResult.getInt(1);
            if (phoneNumberCount > 0) {
                System.out.println("Phone number already exists");
                JOptionPane.showMessageDialog(null, "Phone number already exists");
                return false;
            }
    
            // If both username and phone number are unique, insert the data
            String insertQuery = "INSERT INTO credentials (fname, lname, username, pass, phnumber, sec_question) VALUES (?, ?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(insertQuery);
            pstmt.setString(1, user.getFirstname());
            pstmt.setString(2, user.getLastname());
            pstmt.setString(3, user.getUsername());
            pstmt.setString(4, user.getPassword());
            pstmt.setString(5, user.getPhonenumber());
            pstmt.setString(6, user.getSec_question());
    
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Data Inserted");
//                JOptionPane.showMessageDialog(null, "Data Registered Successfully");
                // LoginView lv = new LoginView();
                // lv.setVisible(true);
                view.dispose();
                return true;
            } else {
                System.out.println("Failed to insert data");
                return false;
            }
    
        } catch (Exception e2) {
            System.out.println(e2.getMessage());
            return false;
        } finally {
            // Close resources in the reverse order of their creation
            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }
}

