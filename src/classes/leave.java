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
import java.text.SimpleDateFormat;
import java.util.Locale;
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
public class leave extends javax.swing.JPanel {

    /**
     * Creates new form session_reporting
     */
    Connection con = null;
    ResultSet rs;
    Statement st;
        ResultSet rsb;
    Statement stb;
    PreparedStatement pst = null;
     
public Boolean check(String emp_no){
Boolean status=null;
                 try {
            String sql2c = "SELECT * FROM employee_leave ";
            stb = con.createStatement();
            rsb = stb.executeQuery(sql2c);
            int x=2;
            while (rsb.next()) {
                if(emp_no.equals(rsb.getString("employee_number"))){
                  x=3;   
                }
            }
            if(x==3){
            status=true;
            }else{
             status=false;
            }
            
        } catch (Exception e) {
         JOptionPane.showMessageDialog(null, e, "Alert", 1);
        }
             
    
    return status ;
}
    public leave() {
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
        
        
            DefaultTableModel model = new DefaultTableModel();
        try {
            model = (DefaultTableModel) eTable.getModel();

            String sql2 = "SELECT * FROM employee ";
            st = con.createStatement();
            rs = st.executeQuery(sql2);
            model.setRowCount(0);
            while (rs.next()) {
                String emp_no = rs.getString("employee_number");
                String name = rs.getString("name");               
                String department = rs.getString("department");
                   Boolean abc=check(emp_no);
                   String stat="";
                   if(abc==true){
                   stat="Active";
                   }else{
                    stat="Inactive";
                   }
                model.addRow(new Object[]{emp_no, name, department,stat});

            }
        } catch (Exception e) {
         JOptionPane.showMessageDialog(null, e, "Alert", 1);
        }
        
       
        
        String id=(model.getValueAt(0, 0).toString());
        
        try {
            String sql2 = "SELECT * FROM employee ";
            st = con.createStatement();
            rs = st.executeQuery(sql2);
            
            while (rs.next()) {
                if(id.equals(rs.getString("employee_number"))){
              e1.setText(rs.getString("employee_number"));
                e2.setText( rs.getString("name"));            
               e9.setText(rs.getString("department"));
                e18.setText(rs.getString("position"));                           
                
                try {
            String sql2c = "SELECT * FROM employee_leave ";
            st = con.createStatement();
            rs = st.executeQuery(sql2c);
          
            while (rs.next()) {
                if(id.equals(rs.getString("employee_number"))){
                     e11.setSelectedItem(rs.getString("leave_type"));            
               
                      String date = rs.getString("from_date");
   java.util.Date date2 = new SimpleDateFormat("dd/mm/yyyy").parse(date);
   e16.setDate(date2);
                     
                   String c = rs.getString("to_date");
   java.util.Date d = new SimpleDateFormat("dd/mm/yyyy").parse(c);
   e7.setDate(d);
                    
                break;
                }
            }
           
            
        } catch (Exception e) {
         JOptionPane.showMessageDialog(null, e, "Alert", 1);
        }
                
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
        e2 = new javax.swing.JTextField();
        bl = new javax.swing.JLabel();
        e1 = new javax.swing.JTextField();
        uL10 = new javax.swing.JLabel();
        uL4 = new javax.swing.JLabel();
        uL11 = new javax.swing.JLabel();
        e9 = new javax.swing.JTextField();
        e18 = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        uL9 = new javax.swing.JLabel();
        e11 = new javax.swing.JComboBox<String>();
        uL18 = new javax.swing.JLabel();
        lB5 = new javax.swing.JButton();
        lB4 = new javax.swing.JButton();
        uL20 = new javax.swing.JLabel();
        e16 = new com.toedter.calendar.JDateChooser();
        e7 = new com.toedter.calendar.JDateChooser();
        jScrollPane2 = new javax.swing.JScrollPane();
        eTable = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1142, 560));
        setPreferredSize(new java.awt.Dimension(1142, 560));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Employee Details   ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Trebuchet MS", 0, 18))); // NOI18N
        jPanel2.setOpaque(false);
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        e2.setEditable(false);
        e2.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        e2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel2.add(e2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 280, 30));

        bl.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        bl.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        bl.setText("Name");
        jPanel2.add(bl, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 110, 20));

        e1.setEditable(false);
        e1.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        e1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel2.add(e1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, 280, -1));

        uL10.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        uL10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        uL10.setText("Emp_no ");
        jPanel2.add(uL10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 90, 20));

        uL4.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        uL4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        uL4.setText("Department");
        jPanel2.add(uL4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 140, 30));

        uL11.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        uL11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        uL11.setText("Position");
        jPanel2.add(uL11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 140, 30));

        e9.setEditable(false);
        e9.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        e9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel2.add(e9, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 110, 240, 30));

        e18.setEditable(false);
        e18.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        e18.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel2.add(e18, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, 240, 30));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "leave Details  ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Trebuchet MS", 0, 18))); // NOI18N
        jPanel4.setOpaque(false);
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        uL9.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        uL9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        uL9.setText("Leave Type");
        jPanel4.add(uL9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 100, 30));

        e11.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        e11.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Annual Leave", "Maternity Leave", "Other Leave" }));
        e11.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                e11ItemStateChanged(evt);
            }
        });
        jPanel4.add(e11, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 240, 30));

        uL18.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        uL18.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        uL18.setText("To");
        jPanel4.add(uL18, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 80, 30));

        lB5.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        lB5.setText("Grant");
        lB5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lB5ActionPerformed(evt);
            }
        });
        jPanel4.add(lB5, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 190, 120, 40));

        lB4.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        lB4.setText("Terminate");
        lB4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lB4ActionPerformed(evt);
            }
        });
        jPanel4.add(lB4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 140, 120, 40));

        uL20.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        uL20.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        uL20.setText("From");
        jPanel4.add(uL20, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, 80, 30));

        e16.setDateFormatString("dd/mm/yyyy");
        e16.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jPanel4.add(e16, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, 240, 30));

        e7.setDateFormatString("dd/mm/yyyy");
        e7.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jPanel4.add(e7, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 240, 30));

        eTable.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        eTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Emp_no", "Name", "Department", "Leave Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(211, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                        .addGap(64, 64, 64))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lB4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lB4ActionPerformed
String ID = e1.getText();
        try {
            String sql = "delete from employee_leave where employee_number='" + ID + "'";

            pst = con.prepareStatement(sql);
            pst.execute();
             
         DefaultTableModel model = new DefaultTableModel();
        try {
            model = (DefaultTableModel) eTable.getModel();

            String sql2 = "SELECT * FROM employee ";
            st = con.createStatement();
            rs = st.executeQuery(sql2);
            model.setRowCount(0);
            while (rs.next()) {
                String emp_no = rs.getString("employee_number");
                String name = rs.getString("name");               
                String department = rs.getString("department");
                   Boolean abc=check(emp_no);
                   String stat="";
                   if(abc==true){
                   stat="Active";
                   }else{
                    stat="Inactive";
                   }
                model.addRow(new Object[]{emp_no, name, department,stat});

            }
        } catch (Exception e) {
         JOptionPane.showMessageDialog(null, e, "Alert", 1);
        }

            JOptionPane.showMessageDialog(this, "Leave Terminated Succesful", "Alert", 1);
            
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e, "Alert", 1);
        }  
        // TODO add your handling code here:
    }//GEN-LAST:event_lB4ActionPerformed

    private void lB5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lB5ActionPerformed
        String id = e1.getText();
        String leave_type = (String) e11.getSelectedItem();       
        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy", Locale.getDefault());
     String from_date = sdf.format(e16.getDate());   
        String to_date = sdf.format(e7.getDate());   
       
        

        if (from_date.equals("") || to_date.equals("")) {
            JOptionPane.showMessageDialog(this, "Kindly fill all fields", "Alert", 1);
        } else {
            try {

                String sql5 = "INSERT INTO employee_leave(employee_number,leave_type,from_date,to_date)"
                        + "VALUES('" + id + "','" + leave_type + "','" + from_date + "','" + to_date  +"')";
                pst = con.prepareStatement(sql5);
                pst.execute();
                
                 DefaultTableModel model = new DefaultTableModel();
        try {
            model = (DefaultTableModel) eTable.getModel();

            String sql2 = "SELECT * FROM employee ";
            st = con.createStatement();
            rs = st.executeQuery(sql2);
            model.setRowCount(0);
            while (rs.next()) {
                String emp_no = rs.getString("employee_number");
                String name = rs.getString("name");               
                String department = rs.getString("department");
                   Boolean abc=check(emp_no);
                   String stat="";
                   if(abc==true){
                   stat="Active";
                   }else{
                    stat="Inactive";
                   }
                model.addRow(new Object[]{emp_no, name, department,stat});

            }
        } catch (Exception e) {
         JOptionPane.showMessageDialog(null, e, "Alert", 1);
        }
                              
                JOptionPane.showMessageDialog(this, "Leave Granted Succesfully", "Alert", 1);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e, "Alert", 1);
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_lB5ActionPerformed

    private void e11ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_e11ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_e11ItemStateChanged

    private void eTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eTableMouseClicked
 TableModel model=eTable.getModel();
        int row =eTable.getSelectedRow();
        String id=(model.getValueAt(row, 0).toString());
        
        try {
            String sql2 = "SELECT * FROM employee ";
            st = con.createStatement();
            rs = st.executeQuery(sql2);
            
            while (rs.next()) {
                if(id.equals(rs.getString("employee_number"))){
               e1.setText(rs.getString("employee_number"));
                e2.setText( rs.getString("name"));            
               e9.setText(rs.getString("department"));
                e18.setText(rs.getString("position"));     
                     
                 try {
            String sql2c = "SELECT * FROM employee_leave ";
            st = con.createStatement();
            rs = st.executeQuery(sql2c);
          
            while (rs.next()) {
                if(id.equals(rs.getString("employee_number"))){
                     e11.setSelectedItem(rs.getString("leave_type"));            
               
                     String date = rs.getString("from_date");
   java.util.Date date2 = new SimpleDateFormat("dd/mm/yyyy").parse(date);
   e16.setDate(date2);
                     
                   String c = rs.getString("to_date");
   java.util.Date d = new SimpleDateFormat("dd/mm/yyyy").parse(c);
   e7.setDate(d);
                     
                break;
                }
            }
           
            
        } catch (Exception e) {
         JOptionPane.showMessageDialog(null, e, "Alert", 1);
        }
                
                break;
                }
            }
        } catch (Exception e) {
         JOptionPane.showMessageDialog(null, e, "Alert", 1);
        }
        
        
        // TODO add your handling code here:
    }//GEN-LAST:event_eTableMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bl;
    private javax.swing.JTextField e1;
    private javax.swing.JComboBox<String> e11;
    private com.toedter.calendar.JDateChooser e16;
    private javax.swing.JTextField e18;
    private javax.swing.JTextField e2;
    private com.toedter.calendar.JDateChooser e7;
    private javax.swing.JTextField e9;
    private javax.swing.JTable eTable;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton lB4;
    private javax.swing.JButton lB5;
    private javax.swing.JLabel uL10;
    private javax.swing.JLabel uL11;
    private javax.swing.JLabel uL18;
    private javax.swing.JLabel uL20;
    private javax.swing.JLabel uL4;
    private javax.swing.JLabel uL9;
    // End of variables declaration//GEN-END:variables
}
