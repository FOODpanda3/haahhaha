/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package library;

import javax.swing.JOptionPane;
import java.util.HashMap;
import java.io.File;// Handles file input/output operations for saving and loading the user database
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.*; // Provides GUI components like buttons, text fields, labels, and dialog boxes.

/**
 *
 * @author Jassen
 */
public class Login extends javax.swing.JFrame {
  private static HashMap<String, String> userDatabase;
    private boolean isLoginAttemptInProgress = false;
    
    public Login() {
        initComponents();
        userDatabase = new HashMap<>(); //Ensures the user database is initialized as an empty HashMap.
        loadUserDatabase(); //Loads the user data from a file (userDatabase.ser).
         setLocationRelativeTo(null);
    }

    public static void loadUserDatabase() {
     try {
        File file = new File("userDatabase.ser");
        if (file.exists()) {
            FileInputStream fileIn = new FileInputStream(file);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            userDatabase = (HashMap<String, String>) in.readObject();
            in.close();
            fileIn.close();
        } else {
            userDatabase = new HashMap<>();
        }
    } catch (IOException | ClassNotFoundException e) {
        JOptionPane.showMessageDialog(null, "Error data: " + e.getMessage());
        userDatabase = new HashMap<>();
    }

   
    if (!userDatabase.containsKey("admin")) {
        userDatabase.put("admin", "admin123"); 
        saveUserDatabase(); 
    }
    }

    public static void saveUserDatabase() {
        try {
            FileOutputStream fileOut = new FileOutputStream("userDatabase.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(userDatabase);
            out.close();
            fileOut.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error saving data: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        signupbtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        usernametext = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        showpass = new javax.swing.JCheckBox();
        Login = new javax.swing.JButton();
        pass = new javax.swing.JPasswordField();

        jLabel4.setText("jLabel4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        signupbtn.setText("sign up");
        signupbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signupbtnActionPerformed(evt);
            }
        });
        jPanel2.add(signupbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 430, -1, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/library/Blue and Gray Illustrative Digital Book Library Logo.png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Username");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Password");

        showpass.setText("Show Password");
        showpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showpassActionPerformed(evt);
            }
        });

        Login.setText("Log In");
        Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 935, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(57, 57, 57)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(usernametext, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(pass, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(200, 200, 200)
                            .addComponent(showpass))
                        .addComponent(Login, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 58, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 610, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(160, 160, 160)
                            .addComponent(jLabel2)
                            .addGap(0, 0, 0)
                            .addComponent(usernametext, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(jLabel3)
                            .addGap(10, 10, 10)
                            .addComponent(pass, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(showpass)
                            .addGap(40, 40, 40)
                            .addComponent(Login, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void signupbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signupbtnActionPerformed
        signup signupForm = new signup();
        signupForm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_signupbtnActionPerformed

    private void showpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showpassActionPerformed
        if (showpass.isSelected()) {
            pass.setEchoChar((char) 0);
        } else {
            pass.setEchoChar('*');
        }
    }//GEN-LAST:event_showpassActionPerformed

    private void LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginActionPerformed
        if (isLoginAttemptInProgress) {
            return;
        }

        isLoginAttemptInProgress = true;
        loadUserDatabase();

        String username = usernametext.getText().trim();
        String password = String.valueOf(pass.getPassword()).trim();

        System.out.println("Username entered: '" + username + "'");

        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter username and password.");
            isLoginAttemptInProgress = false;
            return;
        }

        if (!userDatabase.containsKey(username)) {
            JOptionPane.showMessageDialog(this, "does not exist.");
            isLoginAttemptInProgress = false;
        } else if (!userDatabase.get(username).equals(password)) {
            JOptionPane.showMessageDialog(this, "Incorrect password.");
            isLoginAttemptInProgress = false;
        } else {

            try {
                if (username.equalsIgnoreCase("admin123")) {
                    JOptionPane.showMessageDialog(this, "Redirecting to Admin Dashboard...");
                    admindash adminDashboard = new    admindash();
                    adminDashboard.setVisible(true);
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Login successful!");
                    maindash form = new maindash();
                    form.setVisible(true);
                    this.dispose();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error opening: " + e.getMessage());
                e.printStackTrace();
            } finally {
                isLoginAttemptInProgress = false;
            }
        }

    }//GEN-LAST:event_LoginActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Login;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField pass;
    private javax.swing.JCheckBox showpass;
    private javax.swing.JButton signupbtn;
    private javax.swing.JTextField usernametext;
    // End of variables declaration//GEN-END:variables
}
