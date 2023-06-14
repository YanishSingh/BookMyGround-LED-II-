package controller;

import database.myConnection;
import java.sql.*;
import model.ChangeUsernameModel;
import view.ChangeUsernameView;
import view.LoginView;

public class ChangeUsernameController {
    private ChangeUsernameModel model;
    private ChangeUsernameView view;
    private ResultSet rs;
    private Statement stmt;

    public ChangeUsernameController(ChangeUsernameView view) {
        this.view = view;
        new ChangeUsernameListener().actionPerformed();
    }

    class ChangeUsernameListener {
        public void actionPerformed() {
            try {
                model = view.getUser();
                if (checkCredentials(model)) {
                    String newUsername = model.getNewusername();
                    if (!usernameExists(newUsername)) {
                        updateUsername(model.getCurrentusername(), newUsername);
                        view.setMessage("Username changed successfully");
                        closeAllScreensAndOpenLoginView();
                    } else {
                        view.setMessage("Username already exists");
                    }
                } else {
                    view.setMessage("Invalid current username or security question");
                }
            } catch (Exception e1) {
                e1.printStackTrace();
            } finally {
                System.out.println("Change Username executed successfully!");
            }
        }

        public boolean checkCredentials(ChangeUsernameModel user) throws Exception {
            Connection conn = null;
            PreparedStatement pstmt = null;
            ResultSet rs = null;

            try {
                conn = myConnection.myDatabase();

                // Check if the current username and security question match the values in the database
                String sql = "SELECT * FROM credentials WHERE username = ? AND sec_question = ?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, user.getCurrentusername());
                pstmt.setString(2, user.getSecurityq());
                rs = pstmt.executeQuery();

                return rs.next();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                // Close resources in the reverse order of their creation
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            }

            return false;
        }

        private boolean usernameExists(String username) throws Exception {
            Connection conn = null;
            PreparedStatement pstmt = null;
            ResultSet rs = null;

            try {
                conn = myConnection.myDatabase();

                // Check if the username exists in the database
                String sql = "SELECT * FROM credentials WHERE username = ?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, username);
                rs = pstmt.executeQuery();

                return rs.next();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                // Close resources in the reverse order of their creation
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            }

            return false;
        }

        private void updateUsername(String currentUsername, String newUsername) throws Exception {
            Connection conn = null;
            PreparedStatement pstmt = null;

            try {
                conn = myConnection.myDatabase();

                // Update the username field in the credentials table
                String sql = "UPDATE credentials SET username = ? WHERE username = ?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, newUsername);
                pstmt.setString(2, currentUsername);
                pstmt.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                // Close resources in the reverse order of their creation
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            }
        }

        private void closeAllScreensAndOpenLoginView() {
            // Close all screens
            view.dispose();

            // Open the LoginView
            LoginView loginView = new LoginView();
            loginView.setVisible(true);
        }
    }
}
