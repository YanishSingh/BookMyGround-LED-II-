package controller;

import database.*;
import java.sql.*;
import model.ResetPassModel;
import view.ResetPassView;

/**
 * 
 * author BEASTMODE
 */
public class ResetPassController {
    private ResetPassModel model;
    private ResetPassView view;
    private ResultSet rs;
    private Statement stmt;

    public ResetPassController(ResetPassView view) {
        this.view = view;
        new ResetPassListener().actionPerformed();
    }

    class ResetPassListener {
        public void actionPerformed() {
           try {
            model = view.getUser();
            if (checkUser(model)) {
                String password = model.getNewPass(); // Get the value from the password field
                String confirmPassword = model.getConfirmNewPass(); // Get the value from the confirmPassword field
                if (password.equals(confirmPassword)) { // Check if the password and confirmPassword values are the same
                    updatePassword(model.getUsername(), password); // Update the password in the database
                    view.setMessage("Changed Password Successfully");
                    view.dispose();
                } else {
                    view.setMessage("Passwords do not match");
                }
            } else {
                view.setMessage("Invalid username or security answer");
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        } finally {
            System.out.println("Reset Password executed successfully!");
        }
        }

        public boolean checkUser(ResetPassModel user) throws Exception {
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    
    try {
        conn = myConnection.myDatabase();
        
        // Check if the username and security question match the values in the database
        String sql = "SELECT * FROM credentials WHERE username = ? AND sec_question = ?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, user.getUsername());
        pstmt.setString(2, user.getSecurityq());
        rs = pstmt.executeQuery();
        
        if (rs.next()) {
            // Username and security question match, open a new window
            updatePassword(sql, sql);
            return true;
        } else {
            // Username and/or security question do not match
            if (!usernameExists(user.getUsername())) {
                System.out.println("Invalid username: " + user.getUsername());
            } else {
                System.out.println("Invalid security question for username: " + user.getUsername());
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        // Close resources in the reverse order of their creation
        if (rs != null) {
            rs.close();
        }
        if (pstmt != null) {
            pstmt.close();
        }
        if (conn != null) {
            conn.close();
        }
    }
    
    return false;
}

private boolean usernameExists(String username) throws Exception {
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    
    try {
        conn = myConnection.myDatabase();
        
        // Check if the username exists in the database
        String sql = "SELECT * FROM credentials WHERE username = ?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, username);
        rs = pstmt.executeQuery();
        
        return rs.next();
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        // Close resources in the reverse order of their creation
        if (rs != null) {
            rs.close();
        }
        if (pstmt != null) {
            pstmt.close();
        }
        if (conn != null) {
            conn.close();
        }
    }
    
    return false;
}

private void updatePassword(String username, String password) throws Exception {
    Connection conn = null;
    PreparedStatement pstmt = null;
    
    try {
        conn = myConnection.myDatabase();
        
        // Update the pass field in the credentials table
        String sql = "UPDATE credentials SET pass = ? WHERE username = ?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, password);
        pstmt.setString(2, username);
        pstmt.executeUpdate();
    } catch (Exception e) {
        e.printStackTrace();
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
}
