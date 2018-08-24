/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.DeliveryManagerRole;

import EcoSystem.DeliveryPrice.DeliveryPrice;
import EcoSystem.Enterprise.Enterprise;
import EcoSystem.Organization.DeliveryOrganization;
import UserInterface.StoreManager.ManageInventory;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JPanel;

/**
 *
 * @author Lucy Bai
 */
public class CreateDeliveryPrice extends javax.swing.JPanel {

    /**
     * Creates new form CreateDeliveryPrice
     */
   private JPanel userProcessContainer;
   private  Enterprise enterprise;
   private DeliveryOrganization deliveryOrganization;

   public CreateDeliveryPrice(JPanel userProcessContainer, Enterprise enterprise, DeliveryOrganization deliveryOrganization) {
       initComponents();
       this.userProcessContainer=userProcessContainer;
       this.enterprise=enterprise;
       this.deliveryOrganization=deliveryOrganization;
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
        jLabel1 = new javax.swing.JLabel();
        txtDeliveryService = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtStandered = new javax.swing.JTextField();
        btnCreate = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtPerPrice = new javax.swing.JTextField();

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel4.setText("CreateDeliveryPrice");

        jLabel1.setText("DeliveryService:");

        jLabel2.setText("Standered Price(<=3kg):");

        txtStandered.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStanderedActionPerformed(evt);
            }
        });

        btnCreate.setText("Create");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        btnBack.setText("<< BACK");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabel3.setText("Price per kg:(over 3 kg part):");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(246, 246, 246)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(196, 196, 196)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtDeliveryService)
                            .addComponent(txtStandered)
                            .addComponent(txtPerPrice, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(230, 230, 230)
                        .addComponent(btnBack)
                        .addGap(186, 186, 186)
                        .addComponent(btnCreate)))
                .addContainerGap(176, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel4)
                .addGap(86, 86, 86)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtDeliveryService, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtStandered, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPerPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(157, 157, 157)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(161, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtStanderedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStanderedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStanderedActionPerformed

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        // TODO add your handling code here:
        String service =txtDeliveryService.getText();
        Double standerPrice = (Double.valueOf(txtStandered.getText()));
        Double pricePer =(Double.valueOf(txtPerPrice.getText()));
        DeliveryPrice deliveryPrice=deliveryOrganization.getPrice().addDeliveryPrice();
        deliveryPrice.setService(service);
        deliveryPrice.setStanderedPrice(standerPrice);
        deliveryPrice.setPerPrice(pricePer);
        
        
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        Component[] componentArray=userProcessContainer.getComponents();
        Component component=componentArray[componentArray.length-1];
        ManageDeliveryPrice manageDeliveryPrice=(ManageDeliveryPrice)component;
        manageDeliveryPrice.populateTable();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCreate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txtDeliveryService;
    private javax.swing.JTextField txtPerPrice;
    private javax.swing.JTextField txtStandered;
    // End of variables declaration//GEN-END:variables
}