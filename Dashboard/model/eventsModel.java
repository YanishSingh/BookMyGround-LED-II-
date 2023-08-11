/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author BEASTMODE
 */
public class eventsModel {
    int event_id, ground_id;
    String event_name;
    String ground_name;
    String organised_by, organiser_phnum;
    String start_date, end_date;
    String event_type;
    


 public eventsModel(int event_id, int ground_id,String event_name, String ground_name, String organised_by, String organiser_phnum, String start_date, String end_date, String event_type) {
        this.event_id = event_id;
        this.ground_id = ground_id;
        this.event_name = event_name;
        this.ground_name = ground_name;
        this.organised_by = organised_by;
        this.organiser_phnum = organiser_phnum;
        this.start_date = start_date;
        this.end_date = end_date;
        this.event_type = event_type;
    }

    public int getEvent_id() {
        return event_id;
    }

    public void setEvent_id(int event_id) {
        this.event_id = event_id;
    }

    public int getGround_id() {
        return ground_id;
    }

    public void setGround_id(int ground_id) {
        this.ground_id = ground_id;
    }

    public String getEvent_name() {
        return event_name;
    }

    public void setEvent_name(String event_name) {
        this.event_name = event_name;
    }

    public String getGround_name() {
        return ground_name;
    }

    public void setGround_name(String ground_name) {
        this.ground_name = ground_name;
    }

    public String getOrganised_by() {
        return organised_by;
    }

    public void setOrganised_by(String organised_by) {
        this.organised_by = organised_by;
    }

    public String getOrganiser_phnum() {
        return organiser_phnum;
    }

    public void setOrganiser_phnum(String organiser_phnum) {
        this.organiser_phnum = organiser_phnum;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getEvent_type() {
        return event_type;
    }

    public void setEvent_type(String event_type) {
        this.event_type = event_type;
    }
}
