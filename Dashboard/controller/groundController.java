/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package controller;

import java.sql.*;
import java.util.*;
import database.*;
import model.*;


/**
 *
 * @author BEASTMODE
 */
public class groundController {
    
    //boolean function to add new ground in table: membership
    public static boolean addGround(groundModel ground){
        try{
            Connection connection = myConnection.myDatabase();
            PreparedStatement pst = connection.prepareStatement("INSERT INTO ground VALUES(?,?,?,?,?,?,?)");
            pst.setObject(1,ground.getGround_id());
            pst.setObject(2,ground.getGround_name());
            pst.setObject(3,ground.getGround_address());
            pst.setObject(4,ground.getContact_person());
            pst.setObject(5,ground.getRating());
            pst.setObject(6,ground.getContact_no()); 
            pst.setObject(7,ground.getRate()); 
            
            int result = pst.executeUpdate();
            return(result>0);
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
        
        return false;
    }
    
//boolean function to search ground in table: membership
    public static groundModel searchGround(String ground_id){
        
        groundModel ground=null;
        try{
            String sql = "SELECT * FROM ground WHERE gid = '"+ ground_id+"' ";
            Connection connection = myConnection.myDatabase();
            Statement stm = connection.createStatement();
            ResultSet rset = stm.executeQuery(sql);
            if (rset.next()){
                ground = new groundModel(
                rset.getInt(1),
                rset.getString(2),
                rset.getString(3),
                rset.getString(4),
                rset.getString(5),
                rset.getString(6),
                rset.getDouble(7));
            }
        }
        catch (SQLException e2){
            System.out.println(e2.getMessage());
        }
        return ground;
    }
    
    //function to search ground by using ID in table: membership
    public static groundModel searchGroundbyID(String ground_id){
        
        groundModel ground=null;
        try{
            String sql = "SELECT * FROM ground WHERE gid = '"+ ground_id+"' ";
            Connection connection = myConnection.myDatabase();
            Statement stm = connection.createStatement();
            ResultSet rset = stm.executeQuery(sql);
            if (rset.next()){
                ground = new groundModel(
                rset.getInt(1),
                rset.getString(2),
                rset.getString(3),
                rset.getString(4),
                rset.getString(5),
                rset.getString(6),
                rset.getDouble(7));
            }
        }
        catch (SQLException e2){
            System.out.println(e2.getMessage());
        }
        return ground;
    }
    
  //boolean function to update existing ground in table: membership  
public static boolean updateGround(groundModel ground){
        try{
            String sql = "UPDATE ground SET gname = ?, gaddress = ?, cperson = ?, rating = ?, cnum = ?, rate =? WHERE gid = ? ";
            Connection connection = myConnection.myDatabase();
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setObject(7,ground.getGround_id());
            pst.setObject(1,ground.getGround_name());
            pst.setObject(2,ground.getGround_address());
            pst.setObject(3,ground.getContact_person());
            pst.setObject(4,ground.getRating());
            pst.setObject(5,ground.getContact_no());  
            pst.setObject(6,ground.getRate());  
            int result = pst.executeUpdate();
            return(result>0);
        }
        catch (SQLException e3){
            System.out.println(e3.getMessage());
        }
        return false;
    }


//boolean function to delete existing ground from table: membership
public static boolean deleteGround(groundModel ground){
    try{
        Connection connection = myConnection.myDatabase();
        String sql = "DELETE FROM ground WHERE gid = ?";
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setObject(1, ground.getGround_id());
        int result = pst.executeUpdate();
        return (result>0);
    }
    catch (SQLException e3){
            System.out.println(e3.getMessage());
        }
        return false;
}

//function to get all exisiting ground from table membership to load into the grounds table in view
public static ArrayList<groundModel> getAllGrounds(){
    ArrayList<groundModel> allGround = new ArrayList<>();
    try{
        String sql = "SELECT * FROM ground";
        Connection connection = myConnection.myDatabase();
        Statement stm = connection.createStatement();
        ResultSet rset = stm.executeQuery(sql);
        
        while (rset.next()){
             int g_id = rset.getInt("gid");
                String g_name = rset.getString("gname");
                String g_address = rset.getString("gaddress");
                String g_contact = rset.getString("cperson");
                String g_rating = rset.getString("rating");
                String g_num = rset.getString("cnum");
                double rate = rset.getDouble("rate");
            
            groundModel ground = new groundModel(g_id,g_name,g_address,g_contact,g_rating,g_num,rate);
            allGround.add(ground);
        }
    }
    catch (SQLException e3){
            System.out.println(e3.getMessage());
        }
    return allGround;
}

//function to load last ground to display the next ground id for easy addition of ground from table: membership
public int loadLastGround(){
    
        int lastGround = 0;
        
        
        try {
        
        Connection connection = myConnection.myDatabase();
        Statement s = connection.createStatement();
        ResultSet rs = s.executeQuery("SELECT gid FROM ground ORDER BY gid DESC LIMIT 1");
          
          if (rs.next()) {
              
              
              
              lastGround = rs.getInt("gid");
              
              
          }
          
          rs.close();
          s.close();
          connection.close();
                    
          
      } catch (Exception e) {
      }
     return lastGround;
             
      }

}
