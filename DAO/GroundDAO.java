package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import database.myConnection;
import model.groundModel;

public class GroundDAO {
    
    private static final String INSERT_QUERY = "INSERT INTO ground (gid, gname, gaddress, cperson, rating, cnum, rate) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String SELECT_BY_ID_QUERY = "SELECT * FROM ground WHERE gid = ?";
    private static final String UPDATE_QUERY = "UPDATE ground SET gname = ?, gaddress = ?, cperson = ?, rating = ?, cnum = ?, rate = ? WHERE gid = ?";
    private static final String DELETE_QUERY = "DELETE FROM ground WHERE gid = ?";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM ground";
    private static final String SELECT_LAST_GROUND_QUERY = "SELECT gid FROM ground ORDER BY gid DESC LIMIT 1";

    public boolean addGround(groundModel ground) {
        try (Connection connection = myConnection.myDatabase();
                PreparedStatement pst = connection.prepareStatement(INSERT_QUERY)) {
            pst.setInt(1, ground.getGround_id());
            pst.setString(2, ground.getGround_name());
            pst.setString(3, ground.getGround_address());
            pst.setString(4, ground.getContact_person());
            pst.setString(5, ground.getRating());
            pst.setString(6, ground.getContact_no());
            pst.setDouble(7, ground.getRate());
            int result = pst.executeUpdate();
            return (result > 0);
        } catch (SQLException e) {
        }
        return false;
    }

    public groundModel getGroundById(String ground_id) {
        groundModel ground = null;
        try (Connection connection = myConnection.myDatabase();
                PreparedStatement pst = connection.prepareStatement(SELECT_BY_ID_QUERY)) {
            pst.setString(1, ground_id);
            ResultSet rset = pst.executeQuery();
            if (rset.next()) {
                ground = new groundModel(
                        rset.getInt(1),
                        rset.getString(2),
                        rset.getString(3),
                        rset.getString(4),
                        rset.getString(5),
                        rset.getString(6),
                        rset.getDouble(7)
                );
            }
        } catch (SQLException e) {
        }
        return ground;
    }

    public boolean updateGround(groundModel ground) {
        try (Connection connection = myConnection.myDatabase();
                PreparedStatement pst = connection.prepareStatement(UPDATE_QUERY)) {
            pst.setString(1, ground.getGround_name());
            pst.setString(2, ground.getGround_address());
            pst.setString(3, ground.getContact_person());
            pst.setString(4, ground.getRating());
            pst.setString(5, ground.getContact_no());
            pst.setDouble(6, ground.getRate());
            pst.setInt(7, ground.getGround_id());
            int result = pst.executeUpdate();
            return (result > 0);
        } catch (SQLException e) {
        }
        return false;
    }

    public boolean deleteGround(groundModel ground) {
        try (Connection connection = myConnection.myDatabase();
                PreparedStatement pst = connection.prepareStatement(DELETE_QUERY)) {
            pst.setInt(1, ground.getGround_id());
            int result = pst.executeUpdate();
            return (result > 0);
        } catch (SQLException e) {
        }
        return false;
    }

    public List<groundModel> getAllGrounds() {
        List<groundModel> allGrounds = new ArrayList<>();
        try (Connection connection = myConnection.myDatabase();
                Statement stm = connection.createStatement();
                ResultSet rset = stm.executeQuery(SELECT_ALL_QUERY)) {
            while (rset.next()) {
                groundModel ground = new groundModel(
                        rset.getInt("gid"),
                        rset.getString("gname"),
                        rset.getString("gaddress"),
                        rset.getString("cperson"),
                        rset.getString("rating"),
                        rset.getString("cnum"),
                        rset.getDouble("rate")
                );
                allGrounds.add(ground);
            }
        } catch (SQLException e) {
        }
        return allGrounds;
    }

    public int loadLastGround() {
        int lastGround = 0;
        try (Connection connection = myConnection.myDatabase();
                Statement s = connection.createStatement();
                ResultSet rs = s.executeQuery(SELECT_LAST_GROUND_QUERY)) {
            if (rs.next()) {
                lastGround = rs.getInt("gid");
            }
        } catch (SQLException e) {
        }
        return lastGround;
    }
}
