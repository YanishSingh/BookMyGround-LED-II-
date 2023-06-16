/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author BEASTMODE
 */
public class myConnection {

    public static Connection myDatabase()
    {
        System.out.println("print works");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/futsaldb","root","#IMUNITED@2002");
            System.out.println("Connected to Database");
            return conn;
        } catch (Exception e) {
        }
        return null;
    }
    
    
}

    
    
    
//     public static Connection dbConnect()
//    {
//        {
//        try
//        {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//                    Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/pos","root","#IMUNITED@2002");
//                    System.out.println("Database Connected!");
//                    return conn;
//        }
//        catch (Exception e)
//        
//        {
//        return null;    
//        }
//        
//        }
    
     
  
   

