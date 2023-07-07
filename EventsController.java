package controller;

import model.EventsModel;
import view.EventsView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class EventsController {
    private EventsModel model;
    private EventsView view;

    // Database connection details
    private static final String DB_URL = "jdbc:mysql://localhost:3306/event_management";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    public EventsController(EventsModel model, EventsView view) {
        this.model = model;
        this.view = view;
    }

    public boolean createEvent() {
        // SQL query to insert event into the database
        String query = "INSERT INTO events (event_name, event_start_date, event_end_date, price_per_time, num_of_teams, registration_end_date) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try {
            // Create a connection to the database
            Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            // Create a prepared statement for the SQL query
            PreparedStatement statement = connection.prepareStatement(query);

            // Set the parameter values for the prepared statement
            statement.setString(1, model.getEventName());
            statement.setString(2, formatDate(model.getEventStartDate()));
            statement.setString(3, formatDate(model.getEventEndDate()));
            statement.setDouble(4, model.getPricePerTime());
            statement.setInt(5, model.getNumOfTeams());
            statement.setString(6, formatDate(model.getRegistrationEndDate()));

            // Execute the prepared statement
            int rowsAffected = statement.executeUpdate();

            // Close the statement and connection
            statement.close();
            connection.close();

            // Return true if the event was successfully created
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Return false if the event creation failed
        return false;
    }

    private String formatDate(java.util.Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(date);
    }

    public static void main(String[] args) {
        EventsModel model = new EventsModel();
        EventsView view = new EventsView();
        EventsController controller = new EventsController(model, view);

        // Set up event listeners and handle user interactions
        view.getExitbtn8().addActionListener(e -> {
            // Get the input values from the view
            String eventName = view.getjTextField1().getText();
            java.util.Date startDate = view.getjDateChooser3().getDate();
            java.util.Date endDate = view.getjDateChooser2().getDate();
            double pricePerTime = Double.parseDouble(view.getjTextField2().getText());
            int numOfTeams = Integer.parseInt(view.getjTextField11().getText());
            java.util.Date registrationEndDate = view.getjDateChooser5().getDate();

            // Set the values in the model
            model.setEventName(eventName);
            model.setEventStartDate(startDate);
            model.setEventEndDate(endDate);
            model.setPricePerTime(pricePerTime);
            model.setNumOfTeams(numOfTeams);
            model.setRegistrationEndDate(registrationEndDate);

            // Call the method in the controller to create the event
            boolean success = controller.createEvent();

            // Display a message based on the success of the operation
            if (success) {
                System.out.println("Event created successfully!");
            } else {
                System.out.println("Failed to create event.");
            }
        });

        view.setVisible(true);
    }
}
