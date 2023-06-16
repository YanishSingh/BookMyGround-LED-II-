/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

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
     
     class RegisterListener
    {
        public void actionPerformed(){
        
            try
            {
                model=view.getUser();
                if (checkUser(model))
                {
                    view.setMessage("Registered Successfully!");
                    
                }
//                else
//                {
//                    view.setMessage("Invalid");
//                }
                }
            catch (Exception e1)
            {
                System.out.println(e1.getMessage());
            }
        }
        
       public boolean checkUser(RegisterModel user) throws Exception {
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/futsaldb", "root", "#IMUNITED@2002");

        // Check if the username already exists
        String checkUsernameQuery = "SELECT COUNT(*) FROM credentials WHERE username = ?";
        PreparedStatement checkUsernameStmt = conn.prepareStatement(checkUsernameQuery);
        checkUsernameStmt.setString(1, user.getUsername());
        ResultSet usernameResult = checkUsernameStmt.executeQuery();
        usernameResult.next();
        int usernameCount = usernameResult.getInt(1);
        if (usernameCount > 0) {
            System.out.println("Username already exists");
            JOptionPane.showMessageDialog(null, "Username already exists\n Try diferent Username");
            // Perform necessary actions or show an error message
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
            // Perform necessary actions or show an error message
            return false;
        }

        // If both username and phone number are unique, insert the data
        String insertQuery = "INSERT INTO credentials (fname, lname, username, pass, phnumber, securityq) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement insertStmt = conn.prepareStatement(insertQuery);
        insertStmt.setString(1, user.getFirstname());
        insertStmt.setString(2, user.getLastname());
        insertStmt.setString(3, user.getUsername());
        insertStmt.setString(4, user.getPassword());
        insertStmt.setString(5, user.getPhonenumber());
        insertStmt.setString(6, user.getSec_question());

        insertStmt.executeUpdate();
        System.out.println("Data Inserted");
        JOptionPane.showMessageDialog(null, "Data Registered Successfully");
        LoginView lv = new LoginView();
        lv.setVisible(true);
        view.dispose();

    } 
    catch (Exception e2) {
        System.out.println(e2.getMessage());
    }
    return false;
}
     }

    
}
