/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.StoreManager;

import EcoSystem.Enterprise.Enterprise;
import EcoSystem.Network.Network;
import EcoSystem.Order.Order;
import EcoSystem.Order.OrderItem;
import EcoSystem.Organization.CustomerOrganization;
import EcoSystem.Organization.Organization;
import EcoSystem.Organization.StoreOrganization;
import EcoSystem.UserAccount.UserAccount;
import EcoSystem.WorkQueue.OrderPlaceWorkRequest;
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
public class CheckOrder extends javax.swing.JPanel {

    /**
     * Creates new form CheckOrder
     */
private JPanel userProcessContainer;
private UserAccount account;
private StoreOrganization storeOrganization;
private Enterprise enterprise;
private Network network;

    public CheckOrder(JPanel userProcessContainer, UserAccount account, StoreOrganization storeOrganization, Enterprise enterprise,Network network) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.account = account;
        this.storeOrganization = storeOrganization;
        this.enterprise = enterprise;
        this.network=network;
        populateTable();
    }
   
    public void populateTable(){
        DefaultTableModel model = (DefaultTableModel) tblOrder.getModel();
        model.setRowCount(0);
        for(WorkRequest wk: storeOrganization.getWorkQueue().getWorkRequestList()) {
            if(wk instanceof OrderPlaceWorkRequest)
           
              //get all orderItem
            for(OrderItem oi: ((OrderPlaceWorkRequest) wk).getOrder().getOrderItemList()) {
                Object[] row = new Object[7];
                row[0] = ((OrderPlaceWorkRequest) wk).getOrder();
                row[1] = oi;
                row[2] = oi.getQuantity();
                row[3] = wk.getSender();
                row[4] = ((OrderPlaceWorkRequest) wk).getOrder().isDelivery();
                row[6] =((OrderPlaceWorkRequest) wk).getStatus();
                  for(Organization organization: enterprise.getOrganizationDirectory().getOrganizationList()) {
                // JOptionPane.showMessageDialog(null,"org"+organization.getName());
                    if( organization instanceof CustomerOrganization ) {
                  //            JOptionPane.showMessageDialog(null,((CustomerOrganization) organization).getUserAccountDirectory().getUserAccountList().size());
                        for(UserAccount userAccount: ((CustomerOrganization) organization).getUserAccountDirectory().getUserAccountList()) {
                    //         JOptionPane.showMessageDialog(null,"size"+userAccount.getWorkQueue().getWorkRequestList().size());
                                for(WorkRequest wkk: userAccount.getWorkQueue().getWorkRequestList()) {
                       //         JOptionPane.showMessageDialog(null, wk);
                                    if(wkk instanceof ProductBillingWorkRequest){
                          //              JOptionPane.showMessageDialog(null, (((ProductBillingWorkRequest) wk).getOrder()==or));
                                          if(((ProductBillingWorkRequest) wkk).getOrder()==((OrderPlaceWorkRequest) wk).getOrder()){
                                         row[5]=wkk.getStatus();
                                           
                                    }
                                    }
                                }
                                
                        }
                    }
          }   
                model.addRow(row);
            }
            
            // JOptionPane.showMessageDialog(null, wk);
//            if(wk instanceof OrderPlaceWorkRequest){
//                for(Organization organization: enterprise.getOrganizationDirectory().getOrganizationList()) {
//                    if(organization instanceof CustomerOrganization)
//                    for(Order o: ((CustomerOrganization)organization).getOrderList().getOrders()){
//                        //JOptionPane.showMessageDialog(null,"Insider oder "+ (((OrderItemPlaceWorkRequest) wk).getOrder() == o) );
//                        if(((OrderPlaceWorkRequest) wk).getOrder() == o){
//                            for(OrderItem oi: o.getOrderItemList()){
//                                // JOptionPane.showMessageDialog(null, "Inside OIIIII " + (oi.getStoreOrganization() == storeOrganization) );
//                                if(oi.getStoreOrganization() == storeOrganization){
//                                    Object[] row = new Object[5];
//                                    row[0]=o;
//                                    row[1]=oi;
//                                    row[2]=oi.getQuantity();
//                                    row[3]=o.getUserAccount();
//                                    row[4]=o.isDelivery();
//                                    model.addRow(row);
//                                } 
//                            }
//                        }
//                    }
//                }
//            }
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

        jLabel6 = new javax.swing.JLabel();
        JScrollPane = new javax.swing.JScrollPane();
        tblOrder = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();
        btnDelivery1 = new javax.swing.JButton();

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel6.setText("Check Order");

        tblOrder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "OrderId", "Product", "Quatity", "UserID", "Delivery", "Payment", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JScrollPane.setViewportView(tblOrder);
        if (tblOrder.getColumnModel().getColumnCount() > 0) {
            tblOrder.getColumnModel().getColumn(0).setResizable(false);
            tblOrder.getColumnModel().getColumn(1).setResizable(false);
            tblOrder.getColumnModel().getColumn(2).setResizable(false);
            tblOrder.getColumnModel().getColumn(3).setResizable(false);
            tblOrder.getColumnModel().getColumn(4).setResizable(false);
            tblOrder.getColumnModel().getColumn(5).setResizable(false);
            tblOrder.getColumnModel().getColumn(6).setResizable(false);
        }

        btnBack.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        btnBack.setText("<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnDelivery1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        btnDelivery1.setText("Choose to delivery");
        btnDelivery1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelivery1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(299, 299, 299)
                .addComponent(jLabel6)
                .addContainerGap(350, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 749, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
            .addGroup(layout.createSequentialGroup()
                .addGap(148, 148, 148)
                .addComponent(btnBack)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDelivery1)
                .addGap(94, 94, 94))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jLabel6)
                .addGap(30, 30, 30)
                .addComponent(JScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack)
                    .addComponent(btnDelivery1))
                .addGap(172, 172, 172))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnDelivery1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelivery1ActionPerformed
        // TODO add your handling code here:
       int selectedRow = tblOrder.getSelectedRow();
        if( selectedRow >= 0 ) {  
          Order or=(Order)tblOrder.getValueAt(selectedRow, 0);
        ChooseDelivery cd = new ChooseDelivery(userProcessContainer, enterprise, or,network,account);
        userProcessContainer.add("EnsureDelivery",cd);
        CardLayout layout=(CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
        }
        else{
               JOptionPane.showMessageDialog(null, "Please select a row!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnDelivery1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane JScrollPane;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDelivery1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTable tblOrder;
    // End of variables declaration//GEN-END:variables
}
