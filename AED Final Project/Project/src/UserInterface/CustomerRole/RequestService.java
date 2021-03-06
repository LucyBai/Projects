/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.CustomerRole;

import EcoSystem.EcoSystem;
import EcoSystem.Enterprise.Enterprise;
import EcoSystem.Enterprise.MarketplaceEnterprise;
import EcoSystem.Network.Network;
import EcoSystem.Employee.Employee.SkillType;
import EcoSystem.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author Lucy Bai
 */
public class RequestService extends javax.swing.JPanel {

    /**
     * Creates new form RequestService
     */
    private JPanel userProcessContainer;
    private UserAccount account;
    private EcoSystem system;
    private Enterprise enterprise;
    private Network network;

    public RequestService(JPanel userProcessContainer, UserAccount account, EcoSystem system, Enterprise enterprise) {
        initComponents();
        this.account = account;
        this.system = system;
        this.enterprise = enterprise;
        this.userProcessContainer=userProcessContainer;
        this.network = whatNetwork();
        
    }
    
    public final Network whatNetwork() {
        Network n = null;
        for(Network network: system.getNetworkList()) {
            for( Enterprise enterprise: network.getEnterpriseDirectory().getEnterpriseList() ) {
                if( enterprise == this.enterprise ) {
                    n = network;
                    break;
                }
            }
        }
        return n;
    }
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnPlumbing = new javax.swing.JButton();
        btnHandyMan = new javax.swing.JButton();
        btnCleaning = new javax.swing.JButton();
        btnElectrical = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setText("Request Service");

        btnPlumbing.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        btnPlumbing.setText("Plumbing");
        btnPlumbing.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlumbingActionPerformed(evt);
            }
        });

        btnHandyMan.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        btnHandyMan.setText("HandyMan");
        btnHandyMan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHandyManActionPerformed(evt);
            }
        });

        btnCleaning.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        btnCleaning.setText("Cleaning");
        btnCleaning.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCleaningActionPerformed(evt);
            }
        });

        btnElectrical.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        btnElectrical.setText("Electrical");
        btnElectrical.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnElectricalActionPerformed(evt);
            }
        });

        btnBack.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btnBack.setText("<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnPlumbing, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                            .addComponent(btnCleaning, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnHandyMan, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                            .addComponent(btnElectrical, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(181, 181, 181)
                        .addComponent(jLabel1)))
                .addContainerGap(127, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addGap(97, 97, 97)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnPlumbing, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                    .addComponent(btnHandyMan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCleaning, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                    .addComponent(btnElectrical, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(btnBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(88, 88, 88))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnPlumbingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlumbingActionPerformed
        // TODO add your handling code here:
        OrderService orderService = new OrderService(userProcessContainer, account, network, enterprise, SkillType.Plumbing.getValue());
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.add(orderService);
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnPlumbingActionPerformed

    private void btnCleaningActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCleaningActionPerformed
        // TODO add your handling code here:
        OrderService orderService = new OrderService(userProcessContainer, account, network, enterprise, SkillType.Cleaning.getValue());
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.add(orderService);
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnCleaningActionPerformed

    private void btnHandyManActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHandyManActionPerformed
        // TODO add your handling code here:
        OrderService orderService = new OrderService(userProcessContainer, account, network, enterprise, SkillType.Handyman.getValue());
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.add(orderService);
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnHandyManActionPerformed

    private void btnElectricalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnElectricalActionPerformed
        // TODO add your handling code here:
        OrderService orderService = new OrderService(userProcessContainer, account, network, enterprise, SkillType.Electrical.getValue());
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.add(orderService);
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnElectricalActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCleaning;
    private javax.swing.JButton btnElectrical;
    private javax.swing.JButton btnHandyMan;
    private javax.swing.JButton btnPlumbing;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
