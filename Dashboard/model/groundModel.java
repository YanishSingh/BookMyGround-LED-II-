/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author BEASTMODE
 */
public class groundModel {
    
   int ground_id;
   String ground_name, ground_address, contact_person, rating;
   String contact_no;
   double rate;

    public groundModel(int ground_id, String ground_name, String ground_address, String contact_person, String rating, String contact_no,double rate) {
        this.ground_id = ground_id;
        this.ground_name = ground_name;
        this.ground_address = ground_address;
        this.contact_person = contact_person;
        this.rating = rating;
        this.contact_no = contact_no;
        this.rate=rate;
    }
   
   
    public int getGround_id() {
        return ground_id;
    }

    public void setGround_id(int ground_id) {
        this.ground_id = ground_id;
    }

    public String getGround_name() {
        return ground_name;
    }

    public void setGround_name(String ground_name) {
        this.ground_name = ground_name;
    }

    public String getGround_address() {
        return ground_address;
    }

    public void setGround_address(String ground_address) {
        this.ground_address = ground_address;
    }

    public String getContact_person() {
        return contact_person;
    }

    public void setContact_person(String contact_person) {
        this.contact_person = contact_person;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getContact_no() {
        return contact_no;
    }

    public void setContact_no(String contact_no) {
        this.contact_no = contact_no;
    }
   
   public double getRate(){
       return rate;
   }
   
   public void setRate(double rate){
       this.rate=rate;
   }
    
    
   
}
