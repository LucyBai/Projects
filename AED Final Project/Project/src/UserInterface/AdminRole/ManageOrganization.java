/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.AdminRole;

import EcoSystem.Enterprise.Billing_ShipmentEnterprise;
import EcoSystem.Enterprise.Enterprise;
import EcoSystem.Enterprise.MarketplaceEnterprise;
import EcoSystem.Organization.BillingOrganization;
import EcoSystem.Organization.DeliveryOrganization;
import EcoSystem.Organization.DeliveryOrganization.DeliveryType;
import EcoSystem.Organization.Organization;
import EcoSystem.Organization.Organization.Type;
import EcoSystem.Organization.ServiceOrganization;
import EcoSystem.Organization.StoreOrganization;
import EcoSystem.Organization.StoreOrganization.StoreType;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author abhinnankit
 */
public class ManageOrganization extends javax.swing.JPanel {

    /**
     * Creates new form ManageOrganization
     */
    private Enterprise enterprise;
    private JPanel userProcessContainer;
    public ManageOrganization(JPanel userProcessContainer, Enterprise enterprise) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        populateCombo();
    }
    
    private void populateCombo() {
        
        comboOrganizationType.removeAllItems();
        cmbStoreType.removeAllItems();
        if( enterprise instanceof MarketplaceEnterprise ){
            comboOrganizationType.addItem(Organization.Type.Store);
            comboOrganizationType.addItem(Organization.Type.Service);
            for( StoreType type: StoreType.values()) {
                cmbStoreType.addItem(type);
            }
        }
        else if( enterprise instanceof Billing_ShipmentEnterprise) {
            comboOrganizationType.addItem(Organization.Type.Billing);
            comboOrganizationType.addItem(Organization.Type.Delivery);
                for( DeliveryType type: DeliveryType.values()) {
                cmbDeliveryType.addItem(type);
            }
        }
        
    }
    
    private void storeFieldsVisibility(boolean state) {
        lblDelivery.setVisible(state);
        lblStoreName.setVisible(state);
        lblName.setVisible(state);
        txtName.setVisible(state);
        cmbStoreType.setVisible(state);
        cmbDeliveryType.setVisible(state);
        lblName.revalidate();
        lblStoreName.revalidate();
        cmbStoreType.revalidate();
        txtName.revalidate();
        cmbDeliveryType.revalidate();
          lblDelivery.setVisible(state);
    }
    private void cmbStoreVisibility(boolean state){
        lblStoreName.setVisible(state);
        cmbStoreType.setVisible(state);
        cmbStoreType.revalidate();
         lblStoreName.revalidate();
    }
        private void cmbDeliveryVisibility(boolean state){
        lblDelivery.setVisible(state);
        cmbDeliveryType.setVisible(state);
        cmbDeliveryType.revalidate();
        lblDelivery.setVisible(state);
       
    }
    
    private void populateTable() {
        
        DefaultTableModel model = (DefaultTableModel) tblStoreOrg.getModel();
        model.setRowCount(0);
        Type type = (Type) comboOrganizationType.getSelectedItem();
        
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
            Object[] row = new Object[2];
            if( organization instanceof StoreOrganization && type == Type.Store) {
                row[0] = organization.getOrganizationID();
                row[1] = organization;
                model.addRow(row);
            }
            else if( organization instanceof ServiceOrganization && type == Type.Service) {
                row[0] = organization.getOrganizationID();
                row[1] = organization;
                model.addRow(row);
            }
            else if( organization instanceof BillingOrganization && type == Type.Billing) {
                row[0] = organization.getOrganizationID();
                row[1] = organization;
                model.addRow(row);
            }
            else if( organization instanceof DeliveryOrganization && type == Type.Delivery) {
                row[0] = organization.getOrganizationID();
                row[1] = organization;
                model.addRow(row);
            }
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

        jLabel2 = new javax.swing.JLabel();
        backJButton = new javax.swing.JButton();
        addJButton = new javax.swing.JButton();
        txtName = new javax.swing.JTextField();
        lblStoreName = new javax.swing.JLabel();
        cmbStoreType = new javax.swing.JComboBox();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblStoreOrg = new javax.swing.JTable();
        lblName = new javax.swing.JLabel();
        comboOrganizationType = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        lblDelivery = new javax.swing.JLabel();
        cmbDeliveryType = new javax.swing.JComboBox();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jLabel2.setText("Manage Organization");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(189, 24, -1, -1));

        backJButton.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 498, -1, -1));

        addJButton.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        addJButton.setText("Add Organization");
        addJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addJButtonActionPerformed(evt);
            }
        });
        add(addJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(357, 498, -1, -1));
        add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(345, 411, 145, -1));

        lblStoreName.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblStoreName.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblStoreName.setText("Store Type ");
        add(lblStoreName, new org.netbeans.lib.awtextra.AbsoluteConstraints(192, 373, -1, -1));

        cmbStoreType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbStoreTypeActionPerformed(evt);
            }
        });
        add(cmbStoreType, new org.netbeans.lib.awtextra.AbsoluteConstraints(345, 372, 145, -1));

        tblStoreOrg.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblStoreOrg);

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 168, 480, 176));

        lblName.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblName.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblName.setText("Name");
        add(lblName, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 413, 107, -1));

        comboOrganizationType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboOrganizationTypeActionPerformed(evt);
            }
        });
        add(comboOrganizationType, new org.netbeans.lib.awtextra.AbsoluteConstraints(348, 104, 161, -1));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel7.setText("Organization Type ");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 105, -1, -1));

        lblDelivery.setText("Delivery Type");
        add(lblDelivery, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 450, -1, -1));

        add(cmbDeliveryType, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 450, 140, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void addJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addJButtonActionPerformed
        // TODO add your handling code here:
        Type type = (Type) comboOrganizationType.getSelectedItem();
        if(type == Type.Service) {
            if(!((MarketplaceEnterprise)enterprise).isServiceOrgPresent()) {
                enterprise.getOrganizationDirectory().createOrganization(type, (StoreType)cmbStoreType.getSelectedItem(), Type.Service.getValue(),(DeliveryType)cmbDeliveryType.getSelectedItem(),Type.Delivery.getValue());
                ((MarketplaceEnterprise)enterprise).setServiceOrgPresent(true);
            }
            else {
                JOptionPane.showMessageDialog(null, "Service Organization already Present!!", "We have don't add more organization", JOptionPane.ERROR_MESSAGE);
            }
        }
        else if(type == Type.Billing) {
            if(!((Billing_ShipmentEnterprise)enterprise).isBillingOrgPresent()) {
                enterprise.getOrganizationDirectory().createOrganization(type, (StoreType)cmbStoreType.getSelectedItem(), Type.Billing.getValue(),(DeliveryType)cmbDeliveryType.getSelectedItem(),Type.Delivery.getValue());
                ((Billing_ShipmentEnterprise)enterprise).setBillingOrgPresent(true);
            }
            else {
                JOptionPane.showMessageDialog(null, "Billing Organization already Present!!", "We don't have to add more organizations", JOptionPane.ERROR_MESSAGE);
            }
        }
   
        else if(type == Type.Delivery) {
            enterprise.getOrganizationDirectory().createOrganization(type, (StoreType)cmbStoreType.getSelectedItem(), txtName.getText(),(DeliveryType)cmbDeliveryType.getSelectedItem(),txtName.getText());
        }
        else{
              enterprise.getOrganizationDirectory().createOrganization(type, (StoreType)cmbStoreType.getSelectedItem(), txtName.getText(),(DeliveryType)cmbDeliveryType.getSelectedItem(),txtName.getText());
        }
        populateTable();
    }//GEN-LAST:event_addJButtonActionPerformed

    private void comboOrganizationTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboOrganizationTypeActionPerformed
        // TODO add your handling code here:
        Type type = (Type) comboOrganizationType.getSelectedItem();
        if( type == Type.Service || type == Type.Billing/* || type == Type.Delivery */) {
            storeFieldsVisibility(false);
        }
        
        else if (type == Type.Store ) {
            storeFieldsVisibility(true);
            cmbDeliveryVisibility(false);
        }
        else if(type == Type.Delivery){
            storeFieldsVisibility(true);
            cmbStoreVisibility(false);
        }
        populateTable();
    }//GEN-LAST:event_comboOrganizationTypeActionPerformed

    private void cmbStoreTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbStoreTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbStoreTypeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addJButton;
    private javax.swing.JButton backJButton;
    private javax.swing.JComboBox cmbDeliveryType;
    private javax.swing.JComboBox cmbStoreType;
    private javax.swing.JComboBox comboOrganizationType;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblDelivery;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblStoreName;
    private javax.swing.JTable tblStoreOrg;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
