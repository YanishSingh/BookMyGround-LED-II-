package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.bookingModel;
import database.myConnection;

public class BookingDAO {
    
    private static final String INSERT_QUERY = "INSERT INTO booking (booking_id, ground_id, ground_name, booked_remarks, booked_mobile, booked_by, booked_date, booked_time) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SELECT_BY_ID_QUERY = "SELECT * FROM booking WHERE booking_id = ?";
    private static final String UPDATE_QUERY = "UPDATE booking SET ground_id = ?, ground_name = ?, booked_by = ?, booked_mobile = ?, booked_remarks = ?, booked_date = ?, booked_time = ? WHERE booking_id = ?";
    private static final String DELETE_QUERY = "DELETE FROM booking WHERE booking_id = ?";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM booking";
    private static final String SELECT_LAST_BOOKING_QUERY = "SELECT booking_id FROM booking ORDER BY booking_id DESC LIMIT 1";

    public boolean addBooking(bookingModel booking) {
        try (Connection connection = myConnection.myDatabase();
                PreparedStatement pst = connection.prepareStatement(INSERT_QUERY)) {
            pst.setInt(1, booking.getBooking_id());
            pst.setInt(2, booking.getGround_id());
            pst.setString(3, booking.getGround_name());
            pst.setString(4, booking.getBooked_remarks());
            pst.setString(5, booking.getBooked_mobile());
            pst.setString(6, booking.getBooked_by());
            pst.setString(7, booking.getBooked_date());
            pst.setString(8, booking.getBooked_time());
            int result = pst.executeUpdate();
            return (result > 0);
        } catch (SQLException e) {
        }
        return false;
    }

    public bookingModel getBookingById(String booking_id) {
        bookingModel booking = null;
        try (Connection connection = myConnection.myDatabase();
                PreparedStatement pst = connection.prepareStatement(SELECT_BY_ID_QUERY)) {
            pst.setString(1, booking_id);
            ResultSet rset = pst.executeQuery();
            if (rset.next()) {
                booking = new bookingModel(
                        rset.getInt(1),
                        rset.getInt(2),
                        rset.getString(3),
                        rset.getString(4),
                        rset.getString(5),
                        rset.getString(6),
                        rset.getString(7),
                        rset.getString(8)
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return booking;
    }

    public boolean updateBooking(bookingModel booking) {
        try (Connection connection = myConnection.myDatabase();
                PreparedStatement pst = connection.prepareStatement(UPDATE_QUERY)) {
            pst.setInt(1, booking.getGround_id());
            pst.setString(2, booking.getGround_name());
            pst.setString(3, booking.getBooked_by());
            pst.setString(4, booking.getBooked_mobile());
            pst.setString(5, booking.getBooked_remarks());
            pst.setString(6, booking.getBooked_date());
            pst.setString(7, booking.getBooked_time());
            pst.setInt(8, booking.getBooking_id());
            int result = pst.executeUpdate();
            return (result > 0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteBooking(bookingModel booking) {
        try (Connection connection = myConnection.myDatabase();
                PreparedStatement pst = connection.prepareStatement(DELETE_QUERY)) {
            pst.setInt(1, booking.getBooking_id());
            int result = pst.executeUpdate();
            return (result > 0);
        } catch (SQLException e) {
        }
        return false;
    }

    public List<bookingModel> getAllBookings() {
        List<bookingModel> allBookings = new ArrayList<>();
        try (Connection connection = myConnection.myDatabase();
                Statement stm = connection.createStatement();
                ResultSet rset = stm.executeQuery(SELECT_ALL_QUERY)) {
            while (rset.next()) {
                bookingModel booking = new bookingModel(
                        rset.getInt("booking_id"),
                        rset.getInt("ground_id"),
                        rset.getString("ground_name"),
                        rset.getString("booked_by"),
                        rset.getString("booked_mobile"),
                        rset.getString("booked_remarks"),
                        rset.getString("booked_date"),
                        rset.getString("booked_time")
                );
                allBookings.add(booking);
            }
        } catch (SQLException e) {
        }
        return allBookings;
    }

    public int loadLastBooking() {
        int lastBooking = 0;
        try (Connection connection = myConnection.myDatabase();
                Statement s = connection.createStatement();
                ResultSet rs = s.executeQuery(SELECT_LAST_BOOKING_QUERY)) {
            if (rs.next()) {
                lastBooking = rs.getInt("booking_id");
            }
        } catch (SQLException e) {
        }
        return lastBooking;
    }
}
