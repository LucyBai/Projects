/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.BillingManagerRole;

import EcoSystem.Enterprise.Enterprise;
import EcoSystem.Enterprise.MarketplaceEnterprise;
import EcoSystem.Network.Network;
import EcoSystem.Order.Order;
import EcoSystem.Organization.CustomerOrganization;
import EcoSystem.Organization.Organization;
import EcoSystem.UserAccount.UserAccount;
import EcoSystem.WorkQueue.ProductBillingWorkRequest;
import EcoSystem.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lucy Bai
 */
public class ConfirmPayment extends javax.swing.JPanel {

    /**
     * Creates new form ConfirmPayment
     */
   private JPanel userProcessContainer;
   private Enterprise enterprise;
   private Network network;
   private Organization organization;
   
    public ConfirmPayment(JPanel userProcessContainer, Network network, Enterprise enterprise, Organization organization) {
        initComponents();
        this.userProcessContainer=userProcessContainer;
        this.enterprise=enterprise;
        this.network = network;
        this.organization = organization;
        populateOrganization();
        populateTable();
    }
    
    public void populateOrganization() {
        
        cmbOrganization.removeAllItems();
        cmbOrganization.addItem(Organization.Type.Store);
        cmbOrganization.addItem(Organization.Type.Service);
        
    }
    
    public void populateTable() {
        
        DefaultTableModel model = (DefaultTableModel) tblBilling.getModel();
        model.setRowCount(0);
        
        for( Enterprise e : network.getEnterpriseDirectory().getEnterpriseList() ) {
            if( e instanceof MarketplaceEnterprise ) {
                for(Organization organization: e.getOrganizationDirectory().getOrganizationList()) {
                    if( organization instanceof CustomerOrganization ) {
//                        JOptionPane.showMessageDialog(null, organization);
//                        JOptionPane.showMessageDialog(null, ((CustomerOrganization) organization).getUserAccountDirectory().getUserAccountList().size());
                        for(UserAccount userAccount: ((CustomerOrganization) organization).getUserAccountDirectory().getUserAccountList()) {
                            if( cmbOrganization.getSelectedItem() == Organization.Type.Store ) {
                                for(WorkRequest wk: userAccount.getWorkQueue().getWorkRequestList()) {
//                                    JOptionPane.showMessageDialog(null, wk);
                                    if(wk instanceof ProductBillingWorkRequest){
                                      //  if(wk.getStatus().equals("Processing")) {
//                                            JOptionPane.showMessageDialog(null, ((CustomerOrganization) organization).getOrderList().getOrders().size());
                                            for(Order o: ((CustomerOrganization) organization).getOrderList().getOrders()){
                                                if(((ProductBillingWorkRequest) wk).getOrder()==o){
                                                    Object[] row = new Object[3];
                                                    row[0]=wk;
                                                    row[1]=o.getDate();
                                                    row[2]=((ProductBillingWorkRequest) wk).getStatus();
                                                    model.addRow(row);
                                                }
                                            }
                                      //  }// if status processing
                                    }// if instance productbiilingworkrequest
                                }//for wk
                            }//if store
                            else if( cmbOrganization.getSelectedItem() == Organization.Type.Service) {





                            }
                        }
                    }
                }
            }
        }

//        for(WorkRequest wk: enterprise.getWorkQueue().getWorkRequestList()) {
//            JOptionPane.showMessageDialog(null, wk);
//            if(wk instanceof ProductBillingWorkRequest){
//                 for(Order o: enterprise.getOrderList().getOrders()){
//                       JOptionPane.showMessageDialog(null,"Insider oder "+ (((OrderItemPlaceWorkRequest) wk).getOrder() == o) );
//                    if(((ProductBillingWorkRequest) wk).getOrder()==o){
//                      Object[] row = new Object[3];
//                         row[0]=o;
//                         row[1]=o.getDate();
//                         row[2]=((ProductBillingWorkRequest) wk).getStatus();
//                         model.addRow(row);
//                    }
//                }
//            }
//        }

        
    }
    /**
     * 
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBilling = new javax.swing.JTable();
        btnConfirm = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        cmbOrganization = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        txtConfirm = new javax.swing.JTextField();

        jPasswordField1.setText("jPasswordField1");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel6.setText("Confirm Payment");

        tblBilling.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "OrderId", "RequestDate", "BillingStatus"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblBilling);
        if (tblBilling.getColumnModel().getColumnCount() > 0) {
            tblBilling.getColumnModel().getColumn(0).setResizable(false);
            tblBilling.getColumnModel().getColumn(1).setResizable(false);
            tblBilling.getColumnModel().getColumn(2).setResizable(false);
        }

        btnConfirm.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        btnConfirm.setText("Confirm");
        btnConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmActionPerformed(evt);
            }
        });

        btnBack.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        btnBack.setText("<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        cmbOrganization.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbOrganization.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbOrganizationActionPerformed(evt);
            }
        });

        jLabel1.setText("Update Payment");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(278, 278, 278)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(306, 306, 306)
                        .addComponent(cmbOrganization, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 671, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(225, 225, 225)
                        .addComponent(jLabel1)
                        .addGap(58, 58, 58)
                        .addComponent(txtConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(98, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(cmbOrganization, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConfirm)
                    .addComponent(btnBack))
                .addContainerGap(51, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmActionPerformed
        // TODO add your handling code here:
   
        int selectedRow = tblBilling.getSelectedRow();
        if( selectedRow >= 0 ) {
         
            WorkRequest pb=( ProductBillingWorkRequest)tblBilling.getValueAt(selectedRow, 0);
          
         
             pb.setStatus("Confirmed");
            populateTable();
      
               }
            
        else{
             JOptionPane.showMessageDialog(null, "Please select a row!", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnConfirmActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBackActionPerformed

    private void cmbOrganizationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbOrganizationActionPerformed
        // TODO add your handling code here:
        populateTable();
    }//GEN-LAST:event_cmbOrganizationActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnConfirm;
    private javax.swing.JComboBox cmbOrganization;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblBilling;
    private javax.swing.JTextField txtConfirm;
    // End of variables declaration//GEN-END:variables
}
