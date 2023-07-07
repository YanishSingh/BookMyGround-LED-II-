package model;

import java.util.Date;

public class EventsModel {
    private String eventName;
    private Date eventStartDate;
    private Date eventEndDate;
    private double pricePerTime;
    private int numOfTeams;
    private Date registrationEndDate;

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Date getEventStartDate() {
        return eventStartDate;
    }

    public void setEventStartDate(Date eventStartDate) {
        this.eventStartDate = eventStartDate;
    }

    public Date getEventEndDate() {
        return eventEndDate;
    }

    public void setEventEndDate(Date eventEndDate) {
        this.eventEndDate = eventEndDate;
    }

    public double getPricePerTime() {
        return pricePerTime;
    }

    public void setPricePerTime(double pricePerTime) {
        this.pricePerTime = pricePerTime;
    }

    public int getNumOfTeams() {
        return numOfTeams;
    }

    public void setNumOfTeams(int numOfTeams) {
        this.numOfTeams = numOfTeams;
    }

    public Date getRegistrationEndDate() {
        return registrationEndDate;
    }

    public void setRegistrationEndDate(Date registrationEndDate) {
        this.registrationEndDate = registrationEndDate;
    }

    public boolean createEvent() {
        // TODO: Implement the logic to create an event in the database
        System.out.println("Creating event: " + eventName);
        // Placeholder return statement
        return true;
    }

    public static void main(String[] args) {
        EventsModel event = new EventsModel();
        event.setEventName("Event 1");
        event.setEventStartDate(new Date());
        event.setEventEndDate(new Date());
        event.setPricePerTime(10.5);
        event.setNumOfTeams(5);
        event.setRegistrationEndDate(new Date());

        boolean success = event.createEvent();

        if (success) {
            System.out.println("Event created successfully!");
        } else {
            System.out.println("Failed to create event.");
        }
    }
}
