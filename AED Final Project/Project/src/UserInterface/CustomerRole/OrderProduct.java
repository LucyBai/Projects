/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.CustomerRole;

import EcoSystem.EcoSystem;
import EcoSystem.Enterprise.Enterprise;
import EcoSystem.Order.Order;
import EcoSystem.Order.OrderItem;
import EcoSystem.Order.OrderList;
import EcoSystem.Organization.CustomerOrganization;
import EcoSystem.Organization.Organization;
import EcoSystem.Organization.StoreOrganization;
import EcoSystem.Organization.StoreOrganization.StoreType;
import EcoSystem.Product.Product;
import EcoSystem.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lucy Bai
 */
public class OrderProduct extends javax.swing.JPanel {

    /**
     * Creates new form OrderProduct
     */
    private JPanel userProcessContainer;
    private UserAccount account;
    private Enterprise enterprise;
    private Order order;
    private OrderList orderList;
    private EcoSystem system;
    private CustomerOrganization customerOrganization;

   public OrderProduct(JPanel userProcessContainer, UserAccount account, Enterprise enterprise, EcoSystem system, CustomerOrganization customerOrganization) {
        initComponents();
        this.account=account;
        this.enterprise=enterprise;
        this.userProcessContainer=userProcessContainer;
        this.system=system;
        order = new Order();
        this.customerOrganization = customerOrganization;
        orderList = customerOrganization.getOrderList();
        
        populateTypeComboBox();
        populateComboBox();
        populateTable();
     
    }
    
   public void populateComboBox() {
       
       comboStore.removeAllItems();
       for( Organization organization: enterprise.getOrganizationDirectory().getOrganizationList() ) {
           if( organization instanceof StoreOrganization ) {
               StoreOrganization so = (StoreOrganization) organization;
               comboStore.addItem(so);
           }
       }
   }
   
   public void populateTypeComboBox(){
       comboType.removeAllItems();
       comboType.addItem("All Stores");
            for(StoreType type: StoreOrganization.StoreType.values()){
              comboType.addItem(type);
        }
           
        
    }
    public void populateTable() {
       
        DefaultTableModel dtm = (DefaultTableModel) tblProducts.getModel();
        dtm.setRowCount(0);
        StoreOrganization so = (StoreOrganization) comboStore.getSelectedItem();
        if(so != null){
            for( Product p: so.getProducts().getProducts() ) {
                Object row[] = new Object[4];
                row[0] = p;
                row[1] = p.getPrice();
                row[2] = p.getQuatity();
                dtm.addRow(row);
            }
        }
    }
   
    public void refreshOrderTable() {
       
        DefaultTableModel model = (DefaultTableModel)tblCart.getModel();
        model.setRowCount(0);
      
        for(OrderItem oi: order.getOrderItemList()) {
            Object row[]= new Object[5];
            row[0] = oi;
            row[1] = oi.getStoreOrganization().getStoreType();
            row[2] = oi.getSalesPrice();
            row[3] = oi.getQuantity();
            row[4] = oi.getStoreOrganization();
            model.addRow(row);
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

        jLabel1 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        btnViewProduct = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        spinnerQuantity = new javax.swing.JSpinner();
        jLabel7 = new javax.swing.JLabel();
        comboStore = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProducts = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCart = new javax.swing.JTable();
        btnPlaceOrder = new javax.swing.JButton();
        btnModify = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        spinnerModQty = new javax.swing.JSpinner();
        comboType = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        btnremove = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setText("Simple Life Simple Choice");

        btnBack.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        btnBack.setText("<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnViewProduct.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        btnViewProduct.setText("View Product Detail");
        btnViewProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewProductActionPerformed(evt);
            }
        });

        btnAdd.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        btnAdd.setText("Add To Cart");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        spinnerQuantity.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel7.setText("Quantity:");

        comboStore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboStoreActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setText("Store Name:");

        tblProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ProductName", "Price", "Quantity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblProducts);
        if (tblProducts.getColumnModel().getColumnCount() > 0) {
            tblProducts.getColumnModel().getColumn(0).setResizable(false);
            tblProducts.getColumnModel().getColumn(1).setResizable(false);
        }

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cart", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 18))); // NOI18N

        tblCart.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ProductName", "Type", "Price", "Quantity", "Store"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblCart);
        if (tblCart.getColumnModel().getColumnCount() > 0) {
            tblCart.getColumnModel().getColumn(0).setResizable(false);
            tblCart.getColumnModel().getColumn(2).setResizable(false);
            tblCart.getColumnModel().getColumn(4).setResizable(false);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 775, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                .addGap(22, 22, 22))
        );

        btnPlaceOrder.setText("Place order");
        btnPlaceOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlaceOrderActionPerformed(evt);
            }
        });

        btnModify.setText("Modify");
        btnModify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifyActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel8.setText("Modify Quantity:");

        spinnerModQty.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        comboType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTypeActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setText("Store Type:");

        btnremove.setText("Remove Item");
        btnremove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnremoveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(spinnerModQty, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnModify, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnremove, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(btnPlaceOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 798, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAdd)))
                .addGap(0, 42, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(218, 218, 218)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(btnViewProduct)
                        .addGap(91, 91, 91)
                        .addComponent(jLabel7)
                        .addGap(52, 52, 52)
                        .addComponent(spinnerQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(comboStore, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(275, 275, 275)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(comboType, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(comboType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboStore, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(spinnerQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(btnViewProduct))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack)
                    .addComponent(btnPlaceOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModify, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(spinnerModQty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnremove, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
        
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnViewProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewProductActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblProducts.getSelectedRow();
        if( selectedRow >= 0 ) {
            //Need more validation
            
            Product p = (Product) tblProducts.getValueAt(selectedRow, 0);
            ViewProductDetail vpd = new ViewProductDetail(userProcessContainer, p);
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            userProcessContainer.add(vpd);
            layout.next(userProcessContainer);
        }
        else {
            JOptionPane.showMessageDialog(null, "No row selected", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnViewProductActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblProducts.getSelectedRow();
        if( selectedRow >= 0 ) {
            Product p = (Product) tblProducts.getValueAt(selectedRow, 0);
            int fetchQty=(Integer)spinnerQuantity.getValue();
            //Add Validation
            if(fetchQty<=0){
                JOptionPane.showMessageDialog(null, "Quantity cannot be less than 0");
                return;
            }
            double salesPrice = p.getPrice();
            if(fetchQty <= p.getQuatity()) {
                boolean alreadyPresent = false;
                if(order.getOrderItemList() != null )
                for(OrderItem oi: order.getOrderItemList()){
                    if(oi.getP() == p){
                        oi.setQuantity(oi.getQuantity()+fetchQty);
                        oi.setSalesPrice(oi.getSalesPrice()+fetchQty*(p.getPrice()));
                        alreadyPresent=true;
                        
                    }
                }  
                  if(!alreadyPresent){
                      order.addOrderItem((StoreOrganization)comboStore.getSelectedItem(), fetchQty, fetchQty*(p.getPrice()), p);
                 
                    }
              p.setQuatity(p.getQuatity()-fetchQty);
              populateTable();
            refreshOrderTable();
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "Please select a row!", "Error", JOptionPane.ERROR_MESSAGE);
        }
       
    }//GEN-LAST:event_btnAddActionPerformed

    private void comboStoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboStoreActionPerformed
        // TODO add your handling code here:
        
        populateTable();
    }//GEN-LAST:event_comboStoreActionPerformed

    private void comboTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTypeActionPerformed
        // TODO add your handling code here:
        if(comboType.getSelectedIndex() > 1) {
            StoreType st = (StoreType) comboType.getSelectedItem();
            String s =st.getValue();
            if (st!= null){
                populateSelectedStore(s);
            }
        }
        else {
            populateComboBox();
        }
    }//GEN-LAST:event_comboTypeActionPerformed

    private void btnModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifyActionPerformed
        // TODO add your handling code here:
         int slectedRow=tblCart.getSelectedRow();
        if(slectedRow<0){
            JOptionPane.showMessageDialog(null, "Please Select a row");
            return;
        }
        else{
         OrderItem oi = (OrderItem)tblCart.getValueAt(slectedRow,0);
           int currentAvail = oi.getP().getQuatity();
           int oldQty=oi.getQuantity();
           int newQty=(Integer)spinnerModQty.getValue();
           if(newQty>(currentAvail+oldQty)){
                JOptionPane.showMessageDialog(null, "Quantity is more than availibility");
                return;
           }
           else{
               if(newQty<=0){
                    JOptionPane.showMessageDialog(null, "Quantity should more than 0");
                   
               }
               oi.setQuantity(newQty);
               for(Product p:oi.getStoreOrganization().getProducts().getProducts()) {
              if(p.equals(oi.getP())){
                      p.setQuatity(currentAvail+(oldQty-newQty));
              }
              
          }
               populateTable();
               refreshOrderTable();
           }
           
        }
    }//GEN-LAST:event_btnModifyActionPerformed

    private void btnremoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnremoveActionPerformed
        // TODO add your handling code here:
        int slectedRow=tblCart.getSelectedRow();
        if(slectedRow<0){
            JOptionPane.showMessageDialog(null, "Please Select a row");
            return;
        }       
        OrderItem oi = (OrderItem)tblCart.getValueAt(slectedRow,0);
           int oldAvail =oi.getP().getQuatity();
           int oldQty=oi.getQuantity();
           int newQty=oldAvail+oldQty;
          for(Product p:oi.getStoreOrganization().getProducts().getProducts())
          {
              if(p.equals(oi.getP())){
                  p.setQuatity(newQty);
              }
          }
           order.removeOrderitem(oi);
            JOptionPane.showMessageDialog(null, "Item has removed form cart!");
            refreshOrderTable();
            populateTable();
    }//GEN-LAST:event_btnremoveActionPerformed

    private void btnPlaceOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlaceOrderActionPerformed
        // TODO add your handling code here:

        if(tblCart.getColumnCount() >= 0) {
            JOptionPane.showMessageDialog(null, orderList);
            
            orderList.addOrder(order);
            //  or=this.order;
//            OrderItemPlaceWorkRequest orderPlace = new OrderItemPlaceWorkRequest();
//            orderPlace.setBookstatus("booked");
//            orderPlace.setSender(account);
//            orderPlace.setOrder(order);          
            order.setUserAccount(account);
//            enterprise.getWorkQueue().getWorkRequestList().add(orderPlace);
            JOptionPane.showMessageDialog(null, "Order placed successful!");
            CheckOutProduct viewOrder = new CheckOutProduct(userProcessContainer,account,order,enterprise,system);
            userProcessContainer.add("myOrders", viewOrder);
            CardLayout layout=(CardLayout) userProcessContainer.getLayout();
            layout.next(userProcessContainer);
        }
    }//GEN-LAST:event_btnPlaceOrderActionPerformed
   public void populateSelectedStore(String st){
       comboStore.removeAllItems();
       for( Organization organization: enterprise.getOrganizationDirectory().getOrganizationList() ) {
           if( organization instanceof StoreOrganization ) {
               StoreOrganization so = (StoreOrganization) organization;
               if(so.getStoreType().getValue().equals(st))
                 comboStore.addItem(so);
           }
       }
   }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnModify;
    private javax.swing.JButton btnPlaceOrder;
    private javax.swing.JButton btnViewProduct;
    private javax.swing.JButton btnremove;
    private javax.swing.JComboBox comboStore;
    private javax.swing.JComboBox comboType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner spinnerModQty;
    private javax.swing.JSpinner spinnerQuantity;
    private javax.swing.JTable tblCart;
    private javax.swing.JTable tblProducts;
    // End of variables declaration//GEN-END:variables
}