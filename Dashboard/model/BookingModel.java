/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author BEASTMODE
 */
public class BookingModel {
    
    String futsalname,timing, bookedby,phonenumber,additionalinfo,date;
    
     public BookingModel(String futsalname, String timing,String bookedby, String phonenumber,String additionalinfo, String date)
    {
        this.futsalname = futsalname;
        this.date = date;
        this.timing = timing;
        this.bookedby = bookedby;
        this.phonenumber=phonenumber;
        this.additionalinfo = additionalinfo;
    }

    public String getFutsalname() {
        return futsalname;
    }

    public void setFutsalname(String futsalname) {
        this.futsalname = futsalname;
    }

    public String getTiming() {
        return timing;
    }

    public void setTiming(String timing) {
        this.timing = timing;
    }

    public String getBookedby() {
        return bookedby;
    }

    public void setBookedby(String bookedby) {
        this.bookedby = bookedby;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getAdditionalinfo() {
        return additionalinfo;
    }

    public void setAdditionalinfo(String additionalinfo) {
        this.additionalinfo = additionalinfo;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
}
