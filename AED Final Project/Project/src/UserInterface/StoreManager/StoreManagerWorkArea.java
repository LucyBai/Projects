/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.StoreManager;

import EcoSystem.EcoSystem;
import EcoSystem.Enterprise.Enterprise;
import EcoSystem.Network.Network;
import EcoSystem.Organization.Organization;
import EcoSystem.Organization.StoreOrganization;
import EcoSystem.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author Lucy Bai
 */
public class StoreManagerWorkArea extends javax.swing.JPanel {

    /**
     * Creates new form StoreManagerWorkArea
     */
    private JPanel userProcessContainer;
    private UserAccount account;
    private StoreOrganization storeOrganization;
    private Enterprise enterprise;
    private EcoSystem system;
    private Network network;
    public StoreManagerWorkArea(JPanel userProcessContainer, UserAccount account, Organization storeOrganization, Enterprise enterprise,EcoSystem system) {
        initComponents();
        this.account=account;
        this.enterprise=enterprise;
        this.storeOrganization=(StoreOrganization)storeOrganization;
        this.userProcessContainer=userProcessContainer;
        this.system=system;
        this.network=whatNetwork();
        
        //JOptionPane.showMessageDialog(null, this.storeOrganization.getName());
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

        btnManageInventory = new javax.swing.JButton();
        btnUpdatePrice = new javax.swing.JButton();
        btnMonitor = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnCheckOrder = new javax.swing.JButton();

        btnManageInventory.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        btnManageInventory.setText("Manage Inventory");
        btnManageInventory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageInventoryActionPerformed(evt);
            }
        });

        btnUpdatePrice.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        btnUpdatePrice.setText("Update Product Price");
        btnUpdatePrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdatePriceActionPerformed(evt);
            }
        });

        btnMonitor.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        btnMonitor.setText("Monitor Sales");
        btnMonitor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMonitorActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel4.setText("Store Manager Work Area");

        btnCheckOrder.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        btnCheckOrder.setText("Check Order");
        btnCheckOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckOrderActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(249, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(189, 189, 189))
            .addGroup(layout.createSequentialGroup()
                .addGap(301, 301, 301)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnUpdatePrice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnManageInventory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMonitor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCheckOrder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jLabel4)
                .addGap(117, 117, 117)
                .addComponent(btnManageInventory)
                .addGap(81, 81, 81)
                .addComponent(btnUpdatePrice)
                .addGap(78, 78, 78)
                .addComponent(btnMonitor)
                .addGap(57, 57, 57)
                .addComponent(btnCheckOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(116, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpdatePriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdatePriceActionPerformed
        // TODO add your handling code here:
        UpdatePrice updatePrice = new UpdatePrice(userProcessContainer, account, storeOrganization, enterprise);
        userProcessContainer.add("updatePrice ",updatePrice );
        CardLayout layout=(CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnUpdatePriceActionPerformed

    private void btnManageInventoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageInventoryActionPerformed
        // TODO add your handling code here:
        ManageInventory manageInventory = new ManageInventory(userProcessContainer, account, storeOrganization, enterprise);
        userProcessContainer.add("manageInventory",manageInventory);
        CardLayout layout=(CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnManageInventoryActionPerformed

    private void btnMonitorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMonitorActionPerformed
        // TODO add your handling code here:
        MonitorSales monitorSales= new MonitorSales(userProcessContainer, account, storeOrganization, enterprise);
        userProcessContainer.add("monitorSales",monitorSales);
        CardLayout layout=(CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnMonitorActionPerformed

    private void btnCheckOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckOrderActionPerformed
        // TODO add your handling code here:
        CheckOrder checkOrder= new CheckOrder(userProcessContainer, account, storeOrganization, enterprise,network);
        userProcessContainer.add("checkOrder",checkOrder);
        CardLayout layout=(CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnCheckOrderActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCheckOrder;
    private javax.swing.JButton btnManageInventory;
    private javax.swing.JButton btnMonitor;
    private javax.swing.JButton btnUpdatePrice;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
