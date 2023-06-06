package controller;

import database.myConnection;

import model.*;
import view.*;
import java.sql.*;

/**
 *
 * @author BEASTMODE
 */
public class LoginController {
    
    LoginModel model;
    LoginView view;
    ResultSet rs;
    Statement stmt;
    
    public LoginController(LoginView view)
    {
        this.view=view;
        
        new LoginListener().actionPerformed();
        
        
    }
class LoginListener {
    public void actionPerformed() {
        try {
            model = view.getUser();
            if (checkUser(model)) {
                
                dashboardView d = new dashboardView();
                d.setVisible(true);
                view.dispose();
            } else {
                view.setMessage("Invalid username or password");
            }
        } catch (Exception e1) {
            System.out.println(e1.getMessage());
        } finally {
            System.out.println("Login System Executed Successfully!");
        }
    }

    public boolean checkUser(LoginModel user) throws Exception {
        Connection conn = myConnection.myDatabase();
        String sql = "SELECT * FROM credentials WHERE (username = ? OR phnumber = ?) AND pass = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getUsername());
            stmt.setString(3, user.getPassword());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return true;
            }
            conn.close();
        } catch (Exception e2) {
            System.out.println(e2.getMessage());
        }
        return false;
    }
}
}
