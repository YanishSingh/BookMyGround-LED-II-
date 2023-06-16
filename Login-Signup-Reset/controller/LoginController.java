package controller;

import connection.myConnection;

import model.*;
import view.*;
import java.sql.*;

/**
 *
 * @author asism
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
    class LoginListener
    {
        public void actionPerformed() {
            try
            {
                model=view.getUser();
                if(checkUser(model))
                {
                    view.setMessage("Login Successfully");
                    Dashboard d=new Dashboard();
                    d.setVisible(true);
                    view.dispose();
                }
                else
                {
                    view.setMessage("Invalid username or password");
                    
                }
            }
            catch(Exception e1)
            {
                System.out.println(e1.getMessage());
            }
            
            finally {
                System.out.println("Login System Executed Successfully!");
            }
        }
        
    public boolean checkUser(LoginModel user) throws Exception
        {
          Connection conn = myConnection.myDatabase();
          String sql="select * from credentials where username='"+user.getUsername()+"' AND pass='"+user.getPassword()+"'";
          try
          {
            stmt=conn.createStatement();
            rs=stmt.executeQuery(sql);
            if(rs.next())
             {
                 return true;
             }
             conn.close();

          }
          catch(Exception e2)
          {
              System.out.println(e2.getMessage());
          }         
            
            return false;
        }

        }
    
}
