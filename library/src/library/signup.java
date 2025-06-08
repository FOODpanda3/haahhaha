package library;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import javax.swing.JOptionPane;
import static library.signup.loadUserDatabase;
import static library.signup.userDatabase;
public class signup extends javax.swing.JFrame {

   public static HashMap<String, String> userDatabase = new HashMap<>();
    public signup() {
        initComponents();
         addPlaceholderText();
        loadUserDatabase();
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
                userDatabase = new HashMap<>(); // 
            }
        } catch (IOException | ClassNotFoundException e) {
            userDatabase = new HashMap<>(); 
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
            JOptionPane.showMessageDialog(null, "Error saving: " + e.getMessage());
        }
    }

    private void addPlaceholderText() {
      
        usertext.setText("Enter username");
        usertext.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent evt) {
                if (usertext.getText().equals("Enter username")) {
                    usertext.setText("");
                }
            }

            public void focusLost(FocusEvent evt) {
                if (usertext.getText().equals("")) {
                    usertext.setText("Enter username");
                }
            }
        });

        passtext.setEchoChar((char) 0);
        passtext.setText("Enter password");
        passtext.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent evt) {
                if (String.valueOf(passtext.getPassword()).equals("Enter password")) {
                    passtext.setEchoChar('*');
                    passtext.setText("");
                }
            }

            public void focusLost(FocusEvent evt) {
                if (String.valueOf(passtext.getPassword()).equals("")) {
                    passtext.setText("Enter password");
                    passtext.setEchoChar((char) 0);
                }
            }
        });

        confirmpass.setText("Confirm password");
        confirmpass.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent evt) {
                if (String.valueOf(confirmpass.getPassword()).equals("Confirm password")) {
                    confirmpass.setText("");
                }
            }

            public void focusLost(FocusEvent evt) {
                if (String.valueOf(confirmpass.getPassword()).equals("")) {
                    confirmpass.setText("Confirm password");
                }
            }
        });
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        usertext = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        passtext = new javax.swing.JPasswordField();
        signupbtn2 = new javax.swing.JButton();
        showpass = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        confirmpass = new javax.swing.JPasswordField();
        jPanel2 = new javax.swing.JPanel();
        loginbtn = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("REGISTER");

        jLabel5.setText("Username");

        usertext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usertextActionPerformed(evt);
            }
        });

        jLabel6.setText("Password");

        passtext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passtextActionPerformed(evt);
            }
        });

        signupbtn2.setBackground(new java.awt.Color(49, 121, 82));
        signupbtn2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        signupbtn2.setText("SIGN UP");
        signupbtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signupbtn2ActionPerformed(evt);
            }
        });

        showpass.setText("Show Password");
        showpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showpassActionPerformed(evt);
            }
        });

        jLabel2.setText("Confirm Password");

        confirmpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmpassActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        loginbtn.setText("Log In");
        loginbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginbtnActionPerformed(evt);
            }
        });
        jPanel2.add(loginbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 430, 100, 40));

        jLabel7.setText("jLabel7");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, -10, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/library/Blue and Gray Illustrative Digital Book Library Logo.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 70, 470, 440));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(534, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(usertext, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(passtext, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(confirmpass, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addComponent(showpass))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(signupbtn2)))
                .addGap(157, 157, 157))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 516, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(154, 154, 154)
                .addComponent(jLabel3)
                .addGap(23, 23, 23)
                .addComponent(jLabel5)
                .addGap(4, 4, 4)
                .addComponent(usertext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jLabel6)
                .addGap(4, 4, 4)
                .addComponent(passtext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jLabel2)
                .addGap(4, 4, 4)
                .addComponent(confirmpass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(showpass)
                .addGap(40, 40, 40)
                .addComponent(signupbtn2)
                .addContainerGap(207, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void usertextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usertextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usertextActionPerformed

    private void passtextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passtextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passtextActionPerformed

    private void signupbtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signupbtn2ActionPerformed
        String username = this.usertext.getText();
        String password = new String(this.passtext.getPassword());

        if (userDatabase.containsKey(username)) {
            JOptionPane.showMessageDialog(this, "Username already exists!");
            return;
        }

        if (username.equals("admin")) {
            userDatabase.put(username, password);
            saveUserDatabase();
            JOptionPane.showMessageDialog(this, "Admin User Registered Successfully!");
            admindash adminDashboard = new admindash();
            adminDashboard.setVisible(true);
            this.dispose();
        } else {
            userDatabase.put(username, password);
            saveUserDatabase();
            JOptionPane.showMessageDialog(this, "User Registered Successfully!");
            Login loginForm = new Login();
            loginForm.setVisible(true);
            this.setVisible(false);
        }
        }

        private void cancelbtnActionPerformed(java.awt.event.ActionEvent evt) {
            Login loginForm = new Login();
            loginForm.setVisible(true);
            this.setVisible(false);
    }//GEN-LAST:event_signupbtn2ActionPerformed

    private void showpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showpassActionPerformed
        //This method is triggered when the user clicks the "Show Password" checkbox
        if (showpass.isSelected()) {
            passtext.setEchoChar((char) 0);
            confirmpass.setEchoChar((char) 0);
        } else {
            passtext.setEchoChar('*');
            confirmpass.setEchoChar('*');
        }
    }//GEN-LAST:event_showpassActionPerformed

    private void confirmpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmpassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_confirmpassActionPerformed

    private void loginbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginbtnActionPerformed
        Login signupForm = new Login();
        signupForm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_loginbtnActionPerformed

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
            java.util.logging.Logger.getLogger(signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new signup().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField confirmpass;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton loginbtn;
    private javax.swing.JPasswordField passtext;
    private javax.swing.JCheckBox showpass;
    private javax.swing.JButton signupbtn2;
    private javax.swing.JTextField usertext;
    // End of variables declaration//GEN-END:variables
}
