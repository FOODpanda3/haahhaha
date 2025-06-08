/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package library;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jassen
 */
public class addbook extends javax.swing.JFrame {

    /**
     * Creates new form addbook
     */
    public addbook() {
        initComponents();
         setLocationRelativeTo(null);
        loadBooks(); 
          loadStatusOptions(); 
         loadCategories();
          addTableSelectionListener();
    }
private void loadStatusOptions() {
    status.removeAllItems();
    status.addItem("Available");
    status.addItem("Rented");
    status.addItem("Lost");
    // add any other status values you want
}
  private void loadBooks() {
      String query = "SELECT * FROM book";
    try (Connection conn = DBconnection.getConnection();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(query)) {
        DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();
        tableModel.setRowCount(0);
        while (rs.next()) {
            tableModel.addRow(new Object[]{
                rs.getInt("ID"),
                rs.getString("BookName"),
                rs.getString("Author"),
                rs.getString("Category"),
                rs.getString("status")  // Add this line
            });
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
    }
}
 private void loadCategories() {
    Set<String> categories = new HashSet<>();
    category.removeAllItems();
    category.addItem("Select Category");

    String query = "SELECT DISTINCT Category FROM book";
    try (Connection conn = DBconnection.getConnection();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(query)) {
        while (rs.next()) {
            String c = rs.getString("Category");
            if (categories.add(c)) {
                category.addItem(c);
            }
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error fetching categories: " + e.getMessage());
    }
}
 private void addTableSelectionListener() {
    jTable1.getSelectionModel().addListSelectionListener(e -> {
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow >= 0) {
            bookname.setText(jTable1.getValueAt(selectedRow, 1).toString());
            author.setText(jTable1.getValueAt(selectedRow, 2).toString());
            category.setSelectedItem(jTable1.getValueAt(selectedRow, 3).toString());
            status.setSelectedItem(jTable1.getValueAt(selectedRow, 4).toString());
        }
    });
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        addbook = new javax.swing.JButton();
        rented = new javax.swing.JButton();
        logout = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        bookname = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        author = new javax.swing.JTextField();
        category = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        delete = new javax.swing.JButton();
        add = new javax.swing.JButton();
        update = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        status = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        addbook.setText("Add Book");
        addbook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addbookActionPerformed(evt);
            }
        });
        jPanel1.add(addbook, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 105, 42));

        rented.setText("Rented");
        rented.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rentedActionPerformed(evt);
            }
        });
        jPanel1.add(rented, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, 105, 42));

        logout.setText("Log Out");
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });
        jPanel1.add(logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 590, 90, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 170, 740));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "BookName", "Author", "Category", "status"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 693, 621));

        jLabel1.setText("Name of Book");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 120, -1, -1));

        bookname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                booknameActionPerformed(evt);
            }
        });
        jPanel2.add(bookname, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 140, 300, -1));

        jLabel2.setText("Author");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 170, -1, -1));

        author.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                authorActionPerformed(evt);
            }
        });
        jPanel2.add(author, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 190, 300, -1));

        category.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        category.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryActionPerformed(evt);
            }
        });
        jPanel2.add(category, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 250, 300, -1));

        jLabel3.setText("Category");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 220, -1, -1));

        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        jPanel2.add(delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 380, 90, 30));

        add.setText("Add");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        jPanel2.add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 380, 90, 30));

        update.setText("Update");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        jPanel2.add(update, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 380, 90, 30));

        jLabel4.setText("status");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 280, -1, -1));

        status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusActionPerformed(evt);
            }
        });
        jPanel2.add(status, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 310, 300, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 0, 1190, 740));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addbookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addbookActionPerformed
              new addbook().setVisible(true);
    this.dispose(); 
    }//GEN-LAST:event_addbookActionPerformed

    private void rentedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rentedActionPerformed
             new rented().setVisible(true);
    this.dispose(); 
    }//GEN-LAST:event_rentedActionPerformed

    private void booknameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_booknameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_booknameActionPerformed

    private void authorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_authorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_authorActionPerformed

    private void categoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_categoryActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
int selectedRow = jTable1.getSelectedRow();
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(null, "Please select a book to delete.");
        return;
    }

    int id = Integer.parseInt(jTable1.getValueAt(selectedRow, 0).toString());
    int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this book?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
    if (confirm != JOptionPane.YES_OPTION) {
        return;
    }

    try {
        String query = "DELETE FROM book WHERE ID = ?";
        try (Connection conn = DBconnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Book deleted successfully!");
            loadBooks();
            loadCategories();
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
    }    
    }//GEN-LAST:event_deleteActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
String book = bookname.getText();
    String auth = author.getText();
    String cat = (String) category.getSelectedItem();

    if (book.isEmpty() || auth.isEmpty() || cat.equals("Select Category")) {
        JOptionPane.showMessageDialog(null, "Please fill all fields correctly.");
        return;
    }

    String query = "INSERT INTO book (BookName, Author, Category, status) VALUES (?, ?, ?, ?)";

try (Connection conn = DBconnection.getConnection();
     PreparedStatement pstmt = conn.prepareStatement(query)) {
    pstmt.setString(1, book);
    pstmt.setString(2, auth);
    pstmt.setString(3, cat);
    pstmt.setString(4, "Available");  // Default status when adding book
    pstmt.executeUpdate();
    JOptionPane.showMessageDialog(null, "Book added successfully!");
    loadBooks();
    loadCategories();
} catch (Exception e) {
    JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());

    }

    bookname.setText("");
    author.setText("");
    category.setSelectedIndex(0); 
    status.setSelectedIndex(0);
    }//GEN-LAST:event_addActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
int selectedRow = jTable1.getSelectedRow();
if (selectedRow == -1) {
    JOptionPane.showMessageDialog(null, "Please select a book to update.");
    return;
}

int id = Integer.parseInt(jTable1.getValueAt(selectedRow, 0).toString());
String book = bookname.getText();
String auth = author.getText();
String cat = (String) category.getSelectedItem();
String stat = (String) status.getSelectedItem();

if (book.isEmpty() || auth.isEmpty() || cat.equals("Select Category") || stat == null) {
    JOptionPane.showMessageDialog(null, "Please fill all fields correctly.");
    return;
}

String query = "UPDATE book SET BookName = ?, Author = ?, Category = ?, status = ? WHERE ID = ?";
try (Connection conn = DBconnection.getConnection();
     PreparedStatement pstmt = conn.prepareStatement(query)) {
    pstmt.setString(1, book);
    pstmt.setString(2, auth);
    pstmt.setString(3, cat);
    pstmt.setString(4, stat);
    pstmt.setInt(5, id);
    pstmt.executeUpdate();
    JOptionPane.showMessageDialog(null, "Book updated successfully!");
    loadBooks();
    loadCategories();
} catch (Exception e) {
    JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());}
    }//GEN-LAST:event_updateActionPerformed

    private void statusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_statusActionPerformed

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
            java.util.logging.Logger.getLogger(addbook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addbook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addbook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addbook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new addbook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JButton addbook;
    private javax.swing.JTextField author;
    private javax.swing.JTextField bookname;
    private javax.swing.JComboBox<String> category;
    private javax.swing.JButton delete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton logout;
    private javax.swing.JButton rented;
    private javax.swing.JComboBox<String> status;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
