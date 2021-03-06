/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl;

import beans.UserBean;
import java.io.InputStream;
import java.util.ArrayList;
import javax.swing.JTable;
import reports.JasperReportGenerator;
import services.ManageUserServices;
import services.UserReportsServices;

/**
 *
 * @author hp
 */
public class UserReports extends javax.swing.JPanel {

    private ArrayList<UserBean> al = null;
    private ArrayList<UserBean> all = null;

    /**
     * Creates new form UserReport
     */
    public UserReports() {
        initComponents();
        all = ManageUserServices.getAllUsers();
        // showTable();
    }

    private void showTable(ArrayList<UserBean> all) {
        String heading[] = {"Username", "User Type", "User Status", "Name", "ContactNo", "Email Id"};
        String data[][] = new String[all.size()][heading.length];
        for (int i = 0; i < all.size(); i++) {
            UserBean objbean = all.get(i);
            data[i][0] = objbean.getUsername();
            data[i][1] = objbean.getUsertype();
            if (objbean.isUserstatus()) {
                data[i][2] = "Active";
            } else {
                data[i][2] = "InActive";
            }
            data[i][3] = objbean.getName();
            data[i][4] = objbean.getContactno();
            data[i][5] = objbean.getEmailid();
        }

        tblUserReports = new JTable(data, heading);
        jScrollPane1.setViewportView(tblUserReports);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblUserReports = new javax.swing.JTable();
        btnPrint = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnList = new javax.swing.JButton();
        btnListAll = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        ddlUserType = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        ddlUserStatus = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();

        setBackground(new java.awt.Color(204, 204, 255));
        setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        setPreferredSize(new java.awt.Dimension(1350, 720));

        tblUserReports.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblUserReports.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Username", "UserType", "UserStatus", "Name", "ContactNo", "EmailId"
            }
        ));
        jScrollPane1.setViewportView(tblUserReports);

        btnPrint.setBackground(new java.awt.Color(0, 0, 255));
        btnPrint.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnPrint.setForeground(new java.awt.Color(255, 255, 255));
        btnPrint.setText("Print");
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });

        btnCancel.setBackground(new java.awt.Color(0, 0, 255));
        btnCancel.setForeground(new java.awt.Color(255, 255, 255));
        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnList.setBackground(new java.awt.Color(0, 0, 255));
        btnList.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnList.setForeground(new java.awt.Color(255, 255, 255));
        btnList.setText("List");
        btnList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListActionPerformed(evt);
            }
        });

        btnListAll.setBackground(new java.awt.Color(0, 0, 255));
        btnListAll.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnListAll.setForeground(new java.awt.Color(255, 255, 255));
        btnListAll.setText("List All");
        btnListAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListAllActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("User Type");

        ddlUserType.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ddlUserType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrator", "User", "Null" }));
        ddlUserType.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 255)));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("User Status");

        ddlUserStatus.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ddlUserStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Active", "InActive", "Null" }));
        ddlUserStatus.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 255)));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Name");

        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ddlUserType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(159, 159, 159)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ddlUserStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(153, 153, 153)
                .addComponent(btnList, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91)
                .addComponent(btnListAll, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
            .addGroup(layout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(136, 136, 136)
                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1281, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnList, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ddlUserType, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ddlUserStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnListAll, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        InputStream is = getClass().getResourceAsStream("..\\reports\\userreport.jrxml");
        /* JasperReportGenerator jrg=*/ new JasperReportGenerator(is);
    }//GEN-LAST:event_btnPrintActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        MainFrame.c.setVisible(false);
    }//GEN-LAST:event_btnCancelActionPerformed

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void btnListAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListAllActionPerformed
        showTable(all);
    }//GEN-LAST:event_btnListAllActionPerformed

    private void btnListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListActionPerformed
        String n = txtName.getText().trim();
        String ut = String.valueOf(ddlUserType.getSelectedItem());
        String us = String.valueOf(ddlUserStatus.getSelectedItem());

        if (n.equalsIgnoreCase("") && ut.equalsIgnoreCase("null")) {
            al = UserReportsServices.getAllUsersByStatus(us);
        } else if (n.equalsIgnoreCase("") && us.equalsIgnoreCase("null")) {
            al = UserReportsServices.getAllUsersByType(ut);
        } else if (ut.equalsIgnoreCase("null") && us.equalsIgnoreCase("null")) {
            al = UserReportsServices.getAllUsersByName(n);
        } else if (n.equalsIgnoreCase("")) {
            al = UserReportsServices.getAllUsersByTypeAndStatus(ut, us);
        } else if (ut.equalsIgnoreCase("null")) {
            al = UserReportsServices.getAllUsersByNameAndStatus(n, us);
        } else if (us.equalsIgnoreCase("null")) {
            al = UserReportsServices.getAllUsersByNameAndType(n, ut);
        } else {
            al = UserReportsServices.getAllUsersByNameTypeAndStatus(n, ut, us);
        }
        showTable(al);
    }//GEN-LAST:event_btnListActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnList;
    private javax.swing.JButton btnListAll;
    private javax.swing.JButton btnPrint;
    private javax.swing.JComboBox<String> ddlUserStatus;
    private javax.swing.JComboBox<String> ddlUserType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblUserReports;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
