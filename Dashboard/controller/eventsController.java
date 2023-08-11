/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
public class eventsController {
    
    public static boolean addEvents(eventsModel events) {
    try {
       

        Connection connection = myConnection.myDatabase();
        PreparedStatement pst = connection.prepareStatement("INSERT INTO eevents VALUES(?,?,?,?,?,?,?,?,?)");
        pst.setObject(1, events.getEvent_id());
        pst.setObject(2, events.getGround_id());
        pst.setObject(3, events.getGround_name());
        pst.setObject(4, events.getEvent_name());
        pst.setObject(5, events.getEvent_type());
        pst.setObject(6, events.getOrganised_by());
        pst.setObject(7, events.getOrganiser_phnum());
        pst.setObject(8, events.getStart_date());
        pst.setObject(9, events.getEnd_date());
        int result = pst.executeUpdate();
        return (result > 0);
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
    
    return false;
}
    
    //function to get all exisiting booking from table booking to load into the bookings table in view
public static ArrayList<eventsModel> getAllEvent(){
    ArrayList<eventsModel> allEvents = new ArrayList<>();
    try{
        String sql = "SELECT * FROM eevents";
        Connection connection = myConnection.myDatabase();
        Statement stm = connection.createStatement();
        ResultSet rset = stm.executeQuery(sql);
        
        while (rset.next()){
            int event_id = rset.getInt("event_id");
            int ground_id = rset.getInt("ground_id");
            String ground_name = rset.getString("ground_name");
            String event_name = rset.getString("event_name");
            String organised_by = rset.getString("organised_by");
            String organiser_phnum = rset.getString("organiser_mobile");
            String start_date = rset.getString("start_date");
            String end_date = rset.getString("end_date");
            String event_type = rset.getString("event_type");
            
            eventsModel events = new eventsModel(event_id, ground_id, event_name, ground_name, organised_by, organiser_phnum, start_date, end_date, event_type);
            allEvents.add(events);
        }
    }
    catch (SQLException e3){
            System.out.println(e3.getMessage());
        }
    return allEvents;
}
    
    public int loadLastEvent(){
    
        int lastEvent = 0;
        
        
        try {
        
        Connection connection = myConnection.myDatabase();
        Statement s = connection.createStatement();
        ResultSet rs = s.executeQuery("SELECT event_id FROM eevents ORDER BY event_id DESC LIMIT 1");
          
          if (rs.next()) {
              
              
              
              lastEvent = rs.getInt("event_id");
              
              
          }
          
          rs.close();
          s.close();
          connection.close();
                    
          
      } catch (Exception e) {
      }
     return lastEvent;
             
      }
    
}
