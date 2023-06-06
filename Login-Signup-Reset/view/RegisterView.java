/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import javax.swing.*;
import java.sql.*;
import database.myConnection;
import model.*;
import controller.*;
import java.awt.event.*;
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JTextField;

/**
 *
 * @author BEASTMODE
 */
public class RegisterView extends javax.swing.JFrame {
    RegisterModel model;
    /**
     * Creates new form SignUpPage
     */
    public RegisterView() {
        initComponents();
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Call the method to handle window closing
                handleWindowClosing();
            }
        });
    }
    
    // Method to handle the window closing event
    private void handleWindowClosing() {
        // Close only this window
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    
       
    }
    
    public RegisterModel getUser()
    {
         model = new RegisterModel (fnametxt.getText(),lnametxt.getText(), usernametxt.getText(),passtxt.getText(), phnumtxt.getText(),Sec_Questiontxtbox.getText(),conpasstxt.getText());
        return model;
    }
      
     public void setMessage (String msg)
    {
        JOptionPane.showMessageDialog(this,msg);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        fnametxt = new javax.swing.JTextField();
        lnametxt = new javax.swing.JTextField();
        usernametxt = new javax.swing.JTextField();
        passtxt = new javax.swing.JTextField();
        conpasstxt = new javax.swing.JTextField();
        phnumtxt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        signupbtn = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        Sec_Questiontxtbox = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(164, 255, 184));

        jLabel1.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Sign Up for BOOKMYGROUND");

        jLabel2.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        jLabel2.setText("First Name");

        jLabel3.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        jLabel3.setText("Last Name");

        jLabel4.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        jLabel4.setText("UserName");

        jLabel5.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        jLabel5.setText("Password");

        jLabel6.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        jLabel6.setText("Phone Number");

        jLabel7.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        jLabel7.setText("Confirm Password");

        fnametxt.setBackground(new java.awt.Color(51, 51, 51));
        fnametxt.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        fnametxt.setForeground(new java.awt.Color(255, 255, 255));
        fnametxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fnametxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fnametxtActionPerformed(evt);
            }
        });

        lnametxt.setBackground(new java.awt.Color(51, 51, 51));
        lnametxt.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        lnametxt.setForeground(new java.awt.Color(255, 255, 255));
        lnametxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lnametxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lnametxtActionPerformed(evt);
            }
        });

        usernametxt.setBackground(new java.awt.Color(51, 51, 51));
        usernametxt.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        usernametxt.setForeground(new java.awt.Color(255, 255, 255));
        usernametxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        usernametxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernametxtActionPerformed(evt);
            }
        });

        passtxt.setBackground(new java.awt.Color(51, 51, 51));
        passtxt.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        passtxt.setForeground(new java.awt.Color(255, 255, 255));
        passtxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        passtxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passtxtActionPerformed(evt);
            }
        });

        conpasstxt.setBackground(new java.awt.Color(51, 51, 51));
        conpasstxt.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        conpasstxt.setForeground(new java.awt.Color(255, 255, 255));
        conpasstxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        conpasstxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                conpasstxtActionPerformed(evt);
            }
        });

        phnumtxt.setBackground(new java.awt.Color(51, 51, 51));
        phnumtxt.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        phnumtxt.setForeground(new java.awt.Color(255, 255, 255));
        phnumtxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        phnumtxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phnumtxtActionPerformed(evt);
            }
        });

        jLabel8.setIcon(new javax.swing.ImageIcon("C:\\Users\\BEASTMODE\\Documents\\logoFutsal.png")); // NOI18N

        signupbtn.setBackground(new java.awt.Color(0, 153, 204));
        signupbtn.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        signupbtn.setText("Sign Up");
        signupbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signupbtnActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        jLabel9.setText("SECURITY QUESTION: From Where Did You Complete Your Schooling?");

        Sec_Questiontxtbox.setBackground(new java.awt.Color(51, 51, 51));
        Sec_Questiontxtbox.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(156, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7)))
                .addGap(54, 54, 54)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(phnumtxt)
                    .addComponent(usernametxt)
                    .addComponent(fnametxt)
                    .addComponent(lnametxt)
                    .addComponent(passtxt)
                    .addComponent(conpasstxt, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(145, 145, 145))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(jLabel9))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(217, 217, 217)
                        .addComponent(Sec_Questiontxtbox, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(269, 269, 269)
                        .addComponent(signupbtn)))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fnametxt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lnametxt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usernametxt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(conpasstxt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phnumtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Sec_Questiontxtbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(signupbtn)
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fnametxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fnametxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fnametxtActionPerformed

    private void lnametxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lnametxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lnametxtActionPerformed

    private void usernametxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernametxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernametxtActionPerformed

    private void passtxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passtxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passtxtActionPerformed

    private void conpasstxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_conpasstxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_conpasstxtActionPerformed

    private void phnumtxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phnumtxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phnumtxtActionPerformed

    private void signupbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signupbtnActionPerformed
        // TODO add your handling code here:
        
        RegisterController r = new RegisterController(this);
////        String firstName = fnametxt.getText();
////        String lastName = lnametxt.getText();
////        String username = usernametxt.getText();
////        String password = passtxt.getText();
////        String phoneNumber = phnumtxt.getText();
////        
////        
////        
////        
////
////        Connection connection = null;
////    try {
////        // Establish connection
////        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/futsaldb","root","#IMUNITED@2002");
////
////        // Check if the username already exists in the database
////        if (isValueExists("username", username)) {
////            JOptionPane.showMessageDialog(this, "Username already exists in the database!");
////            return; // Stop further execution
////        }
////
////        // Check if the phone number already exists in the database
////        if (isValueExists("phnumber", phoneNumber)) {
////            JOptionPane.showMessageDialog(this, "Phone number already exists in the database!");
////            return; // Stop further execution
////        }
////            // Insert the user details into the database
////             String insertQuery = "INSERT INTO credentials (fname, lname, username, pass, phnumber) VALUES (?, ?, ?, ?, ?)";
////                    PreparedStatement statement = connection.prepareStatement(insertQuery);
////                    statement.setString(1, firstName);
////                    statement.setString(2, lastName);
////                    statement.setString(3, username);
////                    statement.setString(4, password);
////                    statement.setString(5, phoneNumber);
////                    statement.executeUpdate();
////
////                    System.out.println("User details inserted successfully!");
////                    
////            // Clear the text fields
////            fnametxt.setText("");
////            lnametxt.setText("");
////            usernametxt.setText("");
////            passtxt.setText("");
////            phnumtxt.setText("");
////
////        } catch (SQLException ex) {
////            ex.printStackTrace();
////        } finally {
////            // Close the database connection
////            if (connection != null) {
////                try {
////                    connection.close();
////                } catch (SQLException ex) {
////                    ex.printStackTrace();
////                }
////            }
////        }
////     
    }//GEN-LAST:event_signupbtnActionPerformed
//    private boolean isValueExists(String columnName, String value) {
////    try {
////        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/futsaldb","root","#IMUNITED@2002");
////        String query = "SELECT COUNT(*) FROM credentials WHERE " + columnName + " = ?";
////        PreparedStatement statement = connection.prepareStatement(query);
////        statement.setString(1, value);
////        ResultSet resultSet = statement.executeQuery();
////        resultSet.next();
////        int count = resultSet.getInt(1);
////        return count > 0;
////    } catch (SQLException ex) {
////        ex.printStackTrace();
////        return false;
////    }
//}
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RegisterView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegisterView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Sec_Questiontxtbox;
    private javax.swing.JTextField conpasstxt;
    private javax.swing.JTextField fnametxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField lnametxt;
    private javax.swing.JTextField passtxt;
    private javax.swing.JTextField phnumtxt;
    private javax.swing.JButton signupbtn;
    private javax.swing.JTextField usernametxt;
    // End of variables declaration//GEN-END:variables
}
