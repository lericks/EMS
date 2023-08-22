/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.FontUIResource;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author G50
 */
public class options extends javax.swing.JPanel {

    /**
     * Creates new form session_reporting
     */
     Connection con = null;
    ResultSet rs;
    Statement st;  
    PreparedStatement pst = null;
    public options() {
        initComponents();

UIManager UI = new UIManager();
        UI.put("OptionPane.messageFont", new FontUIResource(new Font("Trebuchet MS", 1, 15)));
        UI.put("OptionPane.background", new ColorUIResource(255, 255, 255));
        UI.put("Panel.background", new ColorUIResource(255, 255, 255));
        try {
            String dbname = "ems";
            String pass = "password";
            String username = "root";
            String Url = "jdbc:mysql://localhost:3306/";
            String Drivers = "com.mysql.jdbc.Driver";

            Class.forName(Drivers);
            con = DriverManager.getConnection(Url + dbname, username, pass);
            //JOptionPane.showMessageDialog(null, "Connection succesful", "Lericks Student Aid Alert", 1);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Connection to database unsuccesful", "Alert", 1);
            System.exit(0);
        }
        
         try {
            String sql2 = "SELECT * FROM company ";
            st = con.createStatement();
            rs = st.executeQuery(sql2);
            
            while (rs.next()) {
                if("1".equals(rs.getString("id"))){
              c1.setText(rs.getString("name"));
                c2.setText( rs.getString("address"));
               c3.setText(rs.getString("tagline"));
               c4.setText(rs.getString("email"));
               c5.setText(rs.getString("pin"));             
                break;
                }
            }
        } catch (Exception e) {
         JOptionPane.showMessageDialog(null, e, "Alert", 1);
        }
        DefaultTableModel model = new DefaultTableModel();
        try {
            model = (DefaultTableModel) eTable.getModel();

            String sql2 = "SELECT * FROM user ";
            st = con.createStatement();
            rs = st.executeQuery(sql2);
            model.setRowCount(0);
            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                String level = rs.getString("level");
            
                

                model.addRow(new Object[]{username, password, level});

            }
        } catch (Exception e) {
         JOptionPane.showMessageDialog(null, e, "Alert", 1);
        }
        
       
        
        String id=(model.getValueAt(0, 0).toString());
        
        try {
            String sql2 = "SELECT * FROM user ";
            st = con.createStatement();
            rs = st.executeQuery(sql2);
            
            while (rs.next()) {
                if(id.equals(rs.getString("username"))){
              u1.setText(rs.getString("username"));
                u2.setText( rs.getString("password"));
               u3.setSelectedItem(rs.getString("level"));
                        
                break;
                }
            }
        } catch (Exception e) {
         JOptionPane.showMessageDialog(null, e, "Alert", 1);
        }
 
         
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        c2 = new javax.swing.JTextField();
        bl = new javax.swing.JLabel();
        c1 = new javax.swing.JTextField();
        uL10 = new javax.swing.JLabel();
        bl5 = new javax.swing.JLabel();
        c3 = new javax.swing.JTextField();
        bl7 = new javax.swing.JLabel();
        c5 = new javax.swing.JTextField();
        c4 = new javax.swing.JTextField();
        bl12 = new javax.swing.JLabel();
        lB6 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        u2 = new javax.swing.JTextField();
        bl1 = new javax.swing.JLabel();
        u1 = new javax.swing.JTextField();
        uL11 = new javax.swing.JLabel();
        bl6 = new javax.swing.JLabel();
        lB7 = new javax.swing.JButton();
        u3 = new javax.swing.JComboBox<String>();
        lB8 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        eTable = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1142, 560));
        setPreferredSize(new java.awt.Dimension(1142, 560));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Company Details   ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Trebuchet MS", 0, 18))); // NOI18N
        jPanel2.setOpaque(false);
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        c2.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        c2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel2.add(c2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 280, 30));

        bl.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        bl.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        bl.setText("address");
        jPanel2.add(bl, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 80, 30));

        c1.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        c1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel2.add(c1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 280, -1));

        uL10.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        uL10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        uL10.setText("name");
        jPanel2.add(uL10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 60, 20));

        bl5.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        bl5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        bl5.setText("tagline");
        jPanel2.add(bl5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 70, 30));

        c3.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        c3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel2.add(c3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 280, 30));

        bl7.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        bl7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        bl7.setText("Pin");
        jPanel2.add(bl7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 70, 30));

        c5.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        c5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel2.add(c5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, 280, 30));

        c4.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        c4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel2.add(c4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, 280, 30));

        bl12.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        bl12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        bl12.setText("email");
        jPanel2.add(bl12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 70, 30));

        lB6.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        lB6.setText("Update");
        lB6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lB6ActionPerformed(evt);
            }
        });
        jPanel2.add(lB6, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 230, -1, -1));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Users Details   ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Trebuchet MS", 0, 18))); // NOI18N
        jPanel3.setOpaque(false);
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        u2.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        u2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel3.add(u2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 270, 30));

        bl1.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        bl1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        bl1.setText("password");
        jPanel3.add(bl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 80, 30));

        u1.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        u1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel3.add(u1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 270, -1));

        uL11.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        uL11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        uL11.setText("username");
        jPanel3.add(uL11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 80, 20));

        bl6.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        bl6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        bl6.setText("level");
        jPanel3.add(bl6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 70, 30));

        lB7.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        lB7.setText("Save");
        lB7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lB7ActionPerformed(evt);
            }
        });
        jPanel3.add(lB7, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, 130, -1));

        u3.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        u3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Admin", "Non - Admin" }));
        u3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                u3ItemStateChanged(evt);
            }
        });
        jPanel3.add(u3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 270, 30));

        lB8.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        lB8.setText("Delete");
        lB8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lB8ActionPerformed(evt);
            }
        });
        jPanel3.add(lB8, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 160, 90, -1));

        eTable.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        eTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Username", "Password", "Level"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        eTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                eTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(eTable);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 240, 350, 108));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(340, 340, 340)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(181, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lB6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lB6ActionPerformed
        String name = c1.getText();
        String address = c2.getText();
        String tagline = c3.getText();
        String email = c4.getText();
        String pin = c5.getText();
       

        if (name.equals("") || address.equals("") || tagline.equals("") || email.equals("")|| pin.equals("") 
        ) {
            JOptionPane.showMessageDialog(this, "Kindly fill all fields", "Alert", 1);
        } else {
            try {

                String sql = "Update company set name='" + name + "',address='" + address + "',tagline='" + tagline + "',pin='" + pin +"',email='" + email  +"' where id='" + 1 + "'";

                pst = con.prepareStatement(sql);
                pst.executeUpdate();
               
                JOptionPane.showMessageDialog(this, "Changes Saved Succesfully", "Alert", 1);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e, "Alert", 1);
            }
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_lB6ActionPerformed

    private void lB7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lB7ActionPerformed
                                   
        String username = u1.getText();
        String level = (String) u3.getSelectedItem();      
        String password = u2.getText();
        

        if (username.equals("") || password.equals("")  ) {
            JOptionPane.showMessageDialog(this, "Kindly fill all fields", "Alert", 1);
        } else {
            try {

                String sql5 = "INSERT INTO user(username,password,level)"
                        + "VALUES('" + username + "','" + password + "','" + level  +"')";
                pst = con.prepareStatement(sql5);
                pst.execute();
                DefaultTableModel model = new DefaultTableModel();
        try {
            model = (DefaultTableModel) eTable.getModel();

            String sql2 = "SELECT * FROM user ";
            st = con.createStatement();
            rs = st.executeQuery(sql2);
            model.setRowCount(0);
            while (rs.next()) {
                String usernamex = rs.getString("username");
                String passwordx = rs.getString("password");
                String levelx = rs.getString("level");
            
                

                model.addRow(new Object[]{usernamex, passwordx, levelx});

            }
        } catch (Exception e) {
         JOptionPane.showMessageDialog(null, e, "Alert", 1);
        }
                JOptionPane.showMessageDialog(this, "User Added Succesfully", "Alert", 1);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e, "Alert", 1);
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_lB7ActionPerformed

    private void lB8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lB8ActionPerformed

        String ID = u1.getText();
        try {
            String sql = "delete from user where username='" + ID + "'";

            pst = con.prepareStatement(sql);
            pst.execute();  
            u1.setText("");
            u2.setText("");
            DefaultTableModel model = new DefaultTableModel();
        try {
            model = (DefaultTableModel) eTable.getModel();

            String sql2 = "SELECT * FROM user ";
            st = con.createStatement();
            rs = st.executeQuery(sql2);
            model.setRowCount(0);
            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                String level = rs.getString("level");
            
                

                model.addRow(new Object[]{username, password, level});

            }
        } catch (Exception e) {
         JOptionPane.showMessageDialog(null, e, "Alert", 1);
        }
            JOptionPane.showMessageDialog(this, "Operation  Succesful", "Alert", 1);                                     
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e, "Alert", 1);
        }
        
        
        
        // TODO add your handling code here:
    }//GEN-LAST:event_lB8ActionPerformed

    private void eTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eTableMouseClicked
        TableModel model=eTable.getModel();
        int row =eTable.getSelectedRow();
        String id=(model.getValueAt(row, 0).toString());

        try {
            String sql2 = "SELECT * FROM user ";
            st = con.createStatement();
            rs = st.executeQuery(sql2);

            while (rs.next()) {
                if(id.equals(rs.getString("username"))){
                     u1.setText(rs.getString("username"));
                u2.setText( rs.getString("password"));
               u3.setSelectedItem(rs.getString("level"));
                    break;
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Alert", 1);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_eTableMouseClicked

    private void u3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_u3ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_u3ItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bl;
    private javax.swing.JLabel bl1;
    private javax.swing.JLabel bl12;
    private javax.swing.JLabel bl5;
    private javax.swing.JLabel bl6;
    private javax.swing.JLabel bl7;
    private javax.swing.JTextField c1;
    private javax.swing.JTextField c2;
    private javax.swing.JTextField c3;
    private javax.swing.JTextField c4;
    private javax.swing.JTextField c5;
    private javax.swing.JTable eTable;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton lB6;
    private javax.swing.JButton lB7;
    private javax.swing.JButton lB8;
    private javax.swing.JTextField u1;
    private javax.swing.JTextField u2;
    private javax.swing.JComboBox<String> u3;
    private javax.swing.JLabel uL10;
    private javax.swing.JLabel uL11;
    // End of variables declaration//GEN-END:variables
}
