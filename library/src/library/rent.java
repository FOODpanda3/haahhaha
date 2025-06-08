package library;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import library.DBconnection;

public class rent extends javax.swing.JFrame {

    /**
     * Creates new form rent
     */
    public rent() {
        initComponents();
        loadAvailableBooks();
    }
private void loadAvailableBooks() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);

        try (Connection conn = DBconnection.getConnection();
             PreparedStatement pst = conn.prepareStatement("SELECT * FROM book");  // Load all books from "book" table
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                Object[] row = {
                    rs.getInt("ID"),
                    rs.getString("BookName"),
                    rs.getString("Author"),
                    rs.getString("Category"),
                    rs.getString("status")   // Load status column
                };
                model.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading books: " + e.getMessage());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        rent = new javax.swing.JButton();
        Return = new javax.swing.JButton();
        logout = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        rentbtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rent.setText("Rent");
        rent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rentActionPerformed(evt);
            }
        });
        jPanel1.add(rent, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 105, 42));

        Return.setText("Return");
        Return.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReturnActionPerformed(evt);
            }
        });
        jPanel1.add(Return, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, 105, 42));

        logout.setText("Log Out");
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });
        jPanel1.add(logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 650, 90, 40));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "BookName", "Author", "Category", "Status"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        rentbtn.setText("Rent");
        rentbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rentbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 990, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(80, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rentbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(96, 96, 96))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(69, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 557, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(rentbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1280, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 735, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rentActionPerformed
        new rent().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_rentActionPerformed

    private void ReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReturnActionPerformed
        new return1().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ReturnActionPerformed

    private void rentbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rentbtnActionPerformed
           int selectedRow = jTable1.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a book to rent.");
            return;
        }

        // Get book details from selected row
        int bookId = Integer.parseInt(jTable1.getValueAt(selectedRow, 0).toString());
        String bookName = jTable1.getValueAt(selectedRow, 1).toString();
        
        // *** Add status check here ***
        String status = jTable1.getValueAt(selectedRow, 4).toString();
        if (!status.equalsIgnoreCase("Available")) {
            JOptionPane.showMessageDialog(this, "This book is not available for rent.");
            return;
        }

        // Ask user for renter's name and rental date
        String renterName = JOptionPane.showInputDialog(this, "Enter your name:");
        if (renterName == null || renterName.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Name cannot be empty.");
            return;
        }

        String rentalDateStr = JOptionPane.showInputDialog(this, "Enter rental date (YYYY-MM-DD):");
        if (rentalDateStr == null || rentalDateStr.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Date cannot be empty.");
            return;
        }

        try (Connection conn = DBconnection.getConnection()) {
            conn.setAutoCommit(false); // for transaction safety

            // Insert into rented table without book_id, include status
            try (PreparedStatement insertRental = conn.prepareStatement(
                "INSERT INTO rented (book_name, renter_name, rental_date, status) VALUES (?, ?, ?, ?)")) {
                insertRental.setString(1, bookName);
                insertRental.setString(2, renterName);
                insertRental.setDate(3, java.sql.Date.valueOf(rentalDateStr));
                insertRental.setString(4, "Rented");
                insertRental.executeUpdate();
            }
            
            // Update book status to "Rented"
            try (PreparedStatement updateStatus = conn.prepareStatement(
                "UPDATE book SET status = ? WHERE ID = ?")) {
                updateStatus.setString(1, "Rented");
                updateStatus.setInt(2, bookId);
                updateStatus.executeUpdate();
            }

            conn.commit();
            JOptionPane.showMessageDialog(this, "Book rented successfully!");
            loadAvailableBooks();  // refresh table
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
                                  
    }//GEN-LAST:event_rentbtnActionPerformed

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to logout?", "Logout", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            this.dispose(); // close current window
            new Login().setVisible(true); }
    }//GEN-LAST:event_logoutActionPerformed

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
            java.util.logging.Logger.getLogger(rent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(rent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(rent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(rent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new rent().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Return;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton logout;
    private javax.swing.JButton rent;
    private javax.swing.JButton rentbtn;
    // End of variables declaration//GEN-END:variables
}
