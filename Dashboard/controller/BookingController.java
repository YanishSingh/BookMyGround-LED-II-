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
public class BookingController {
    
    BookingModel model;
    BookingsView view;
    ResultSet rs;
    Statement stmt;
    
    public BookingController(BookingsView view)
    {
        this.view=view;
        
        new BookingListener().actionPerformed();
        
        
    }
    
    class BookingListener {
    public void actionPerformed() {
        
         try{
            model = view.getUser();
            

            // Check if any of the fields are empty
            if (model.getFutsalname().isEmpty() || model.getDate().isEmpty() ||
                model.getTiming().isEmpty() || model.getPhonenumber().isEmpty() ||
                model.getBookedby().isEmpty() ||model.getAdditionalinfo().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill in all the fields");
                return;
            }
            
            // Connect to the database
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/futsaldb", "root", "#IMUNITED@2002");

                // Prepare the SQL statement
                String sql = "INSERT INTO Booking (Futsal_Name, Date, Timing, Booked_By, PhoneNumber, Additional_Info) " +
                        "VALUES (?, ?, ?, ?, ?, ?)";
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, model.getFutsalname());
                statement.setString(2, model.getDate());
                statement.setString(3, model.getTiming());
                statement.setString(4, model.getBookedby());
                statement.setString(5, model.getPhonenumber());
                statement.setString(6, model.getAdditionalinfo());

                // Execute the SQL statement
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    JOptionPane.showMessageDialog(null, "Booking added successfully");
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to add booking");
                }

                // Close the connection
                conn.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}