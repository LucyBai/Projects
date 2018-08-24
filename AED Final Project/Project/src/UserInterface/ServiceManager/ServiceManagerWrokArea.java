/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.ServiceManager;

import EcoSystem.Enterprise.Enterprise;
import EcoSystem.Organization.ServiceOrganization;
import EcoSystem.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author Lucy Bai
 */
public class ServiceManagerWrokArea extends javax.swing.JPanel {

    /**
     * Creates new form ServiceManagerWrokArea
     */
    private JPanel userProcessContainer;
    private UserAccount account;
    private ServiceOrganization serviceOrganization;
    private Enterprise enterprise;
    public ServiceManagerWrokArea(JPanel userProcessContainer, UserAccount account, ServiceOrganization serviceOrganization, Enterprise enterprise) {
        initComponents();
        this.account=account;
        this.enterprise=enterprise;
        this.serviceOrganization=(ServiceOrganization)serviceOrganization;
        this.userProcessContainer=userProcessContainer;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        btnManageSchedules = new javax.swing.JButton();
        btnManageEquipments = new javax.swing.JButton();

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel4.setText("Service Manager Work Area");

        btnManageSchedules.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        btnManageSchedules.setText("Manage Schedules");
        btnManageSchedules.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageSchedulesActionPerformed(evt);
            }
        });

        btnManageEquipments.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        btnManageEquipments.setText("Manage Equipments");
        btnManageEquipments.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageEquipmentsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(266, 266, 266)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnManageSchedules, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnManageEquipments, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(250, 250, 250)
                        .addComponent(jLabel4)))
                .addContainerGap(168, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jLabel4)
                .addGap(101, 101, 101)
                .addComponent(btnManageSchedules)
                .addGap(72, 72, 72)
                .addComponent(btnManageEquipments)
                .addContainerGap(149, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnManageSchedulesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageSchedulesActionPerformed
        // TODO add your handling code here:
        ManageSchedules manageSchedules = new ManageSchedules(userProcessContainer, account, serviceOrganization, enterprise);
        userProcessContainer.add("manageSchedules",manageSchedules);
        CardLayout layout=(CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnManageSchedulesActionPerformed

    private void btnManageEquipmentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageEquipmentsActionPerformed
        // TODO add your handling code here:
//        ManageEquipment manageEquipment = new ManageEquipment(userProcessContainer, account, serviceOrganization, enterprise);
//        userProcessContainer.add("manageEquipment",manageEquipment);
//        CardLayout layout=(CardLayout) userProcessContainer.getLayout();
//        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnManageEquipmentsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnManageEquipments;
    private javax.swing.JButton btnManageSchedules;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}