package controller;

import database.myConnection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.DeleteAccModel;
import view.DeleteAccView;

public class DeleteAccController {
    private DeleteAccView view;

    public DeleteAccController(DeleteAccView view) {
        this.view = view;
        this.view.addLoginListner(new DeleteButtonListener());
    }

    class DeleteButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                DeleteAccModel model = view.getUser();
                if (checkCredentials(model)) {
                    deleteAccount(model.getUsername());
                    JOptionPane.showMessageDialog(view, "Account deleted successfully.");
                    view.dispose();
                } else {
                    JOptionPane.showMessageDialog(view, "Invalid Username or Security Question");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(view, "An error occurred while processing your request.");
            }
        }
    }

    private boolean checkCredentials(DeleteAccModel user) throws SQLException {
        try (Connection conn = myConnection.myDatabase();
             PreparedStatement pstmt = conn.prepareStatement(
                     "SELECT * FROM credentials WHERE username = ? AND pass = ? AND sec_question = ?")) {

            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPass());
            pstmt.setString(3, user.getSecurityq());

            try (ResultSet rs = pstmt.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw ex; // Rethrow the exception for higher-level handling
        }
    }

    private void deleteAccount(String username) throws SQLException {
        try (Connection conn = myConnection.myDatabase();
             PreparedStatement pstmt = conn.prepareStatement(
                     "DELETE FROM credentials WHERE username = ?")) {

            pstmt.setString(1, username);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw ex; // Rethrow the exception for higher-level handling
        }
    }
}
