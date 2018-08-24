/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.CustomerRole;

import EcoSystem.AccountValidator.Validator;
import EcoSystem.Customer.Customer;
import EcoSystem.Customer.CustomerDirectory;
import EcoSystem.EcoSystem;
import EcoSystem.Enterprise.Enterprise;
import EcoSystem.Enterprise.EnterpriseDirectory;
import EcoSystem.Enterprise.MarketplaceEnterprise;
import EcoSystem.Network.Network;
import EcoSystem.Organization.CustomerOrganization;
import EcoSystem.Organization.Organization;
import EcoSystem.Role.CustomerRole;
import EcoSystem.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author abhinnankit
 */
public class CustomerRegister extends javax.swing.JPanel {

    /**
     * Creates new form CustomerRegister
     */
    private EcoSystem system;
    private JPanel container;
    private JButton btnLogin;
    private JTextField txtUserName;
    private JTextField txtPwd;
    private JButton btnReg;
    
    public CustomerRegister(JPanel container, EcoSystem system, JButton btnLogin, JTextField txtUserName, JTextField txtPwd, JButton btnRegister) {
        initComponents();
        this.system = system;
        this.container = container;
        this.btnLogin = btnLogin;
        this.txtUserName = txtUserName;
        this.txtPwd = txtPwd;
        this.btnReg = btnRegister;
        populateCmbBox();
    }
    
    private void populateCmbBox() {
        
        cmbNetwork.removeAllItems();
        cmbNetwork.addItem(null);
        for( Network network: system.getNetworkList())
            cmbNetwork.addItem(network);
        
    }
    
    private void enableLoginFields() {
        btnLogin.setEnabled(true);
        txtPwd.setEnabled(true);
        txtUserName.setEnabled(true);
        btnReg.setEnabled(true);
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
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        btnRegister = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtUsrID = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        cmbNetwork = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jLabel1.setText("Register Your Account With Us");

        jLabel2.setText("Name:");

        jLabel4.setText("Address:");

        jLabel5.setText("E-Mail:");

        btnRegister.setText("REGISTER");
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });

        btnReset.setText("RESET");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnCancel.setText("CANCEL");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        jLabel6.setText("User ID:");

        jLabel7.setText("Password:");

        cmbNetwork.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel8.setText("Place:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                            .addComponent(txtUsrID, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtName))
                        .addGap(98, 98, 98)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbNetwork, 0, 182, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                                .addComponent(txtAddress))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(191, 191, 191)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(194, 194, 194)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68)
                        .addComponent(btnRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(68, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(cmbNetwork, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtUsrID, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(89, 89, 89)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(42, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        txtAddress.setText("");
        txtEmail.setText("");
        txtName.setText("");
        txtPassword.setText("");
        txtUsrID.setText("");
        cmbNetwork.setSelectedItem(null);
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        container.remove(this);
        CardLayout layout = (CardLayout) container.getLayout();
        enableLoginFields();
        layout.previous(container);
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        // TODO add your handling code here:
        
        // Validation check
//        if( Validator.isValidUserID(txtUsrID.getText()) 
//            && Validator.isValidEmail(txtEmail.getText()) 
//            && Validator.isValidPassword(String.valueOf(txtPassword.getPassword())) 
//            && !txtAddress.getText().trim().isEmpty() 
//            && cmbNetwork.getSelectedItem() != null 
//            && !txtName.getText().trim().isEmpty() ) {
            
            boolean uniqueUser = isUserNameUnique(txtEmail.getText(), txtUsrID.getText());
            if(uniqueUser) {
                for(Network network: system.getNetworkList()){
                    if( (Network)cmbNetwork.getSelectedItem() == network ) {
                        EnterpriseDirectory ed = network.getEnterpriseDirectory();
                        for( Enterprise e: ed.getEnterpriseList() ) {
                            if(e instanceof MarketplaceEnterprise) {
                                CustomerOrganization org = null;
                                boolean orgPresent = false;
                                for(Organization o : ((MarketplaceEnterprise) e).getOrganizationDirectory().getOrganizationList()) {
                                    if(o instanceof CustomerOrganization) {
                                        org = (CustomerOrganization)o;
                                        orgPresent = true;
                                    }
                                }
                                if(!orgPresent) {
                                    org = new CustomerOrganization();
                                    e.getOrganizationDirectory().getOrganizationList().add(org);
                                }
                                Customer c = org.getCustomerDirectory().addCustomer();
                                org.getUserAccountDirectory().createUserAccount(txtUsrID.getText(), String.valueOf(txtPassword.getPassword()), c, new CustomerRole(), c.getClass().getName());
                                c.setName(txtName.getText());
                                c.setAddress(txtAddress.getText());
                                c.setEmail(txtEmail.getText());
                                JOptionPane.showMessageDialog(null, "User Successfully Added!!", "Congratulations!!", JOptionPane.INFORMATION_MESSAGE);
                                enableLoginFields();
                                return;
                            }
                        }
                    }
                }
            }
//        }
//        
//        else {
//            if( txtName.getText().trim().isEmpty() )
//                JOptionPane.showMessageDialog(null, "Name can't be left blank!", "WHO ARE YOU??", JOptionPane.ERROR_MESSAGE);
//            else if( cmbNetwork.getSelectedItem() == null )
//                JOptionPane.showMessageDialog(null, "Please select a place!", "You must be living somewhere!", JOptionPane.ERROR_MESSAGE);
//            else if ( !Validator.isValidEmail(txtEmail.getText()) )
//                JOptionPane.showMessageDialog(null, "Please Enter Valid Email!", "Invalid Email ID", JOptionPane.ERROR_MESSAGE);
//            else if( txtAddress.getText().trim().isEmpty() )
//                JOptionPane.showMessageDialog(null, "Address can't be left blank!", "You must be living somewhere!", JOptionPane.ERROR_MESSAGE);
//            else if( !Validator.isValidUserID(txtUsrID.getText()) ) 
//                JOptionPane.showMessageDialog(null, "Please Enter Valid User ID!", "Invalid User ID", JOptionPane.ERROR_MESSAGE);
//            else if ( !Validator.isValidPassword(String.valueOf(txtPassword.getPassword())) )
//                JOptionPane.showMessageDialog(null, "Password should at least contain one uppercase, one lowercase, one number and 8 character length!", 
//                        "Password too weak", JOptionPane.ERROR_MESSAGE);
//            
//        }
    }//GEN-LAST:event_btnRegisterActionPerformed
    
    private boolean isUserNameUnique(String email, String userID) {
        
        if(!system.checkIfUserIsUnique(userID)) {
            JOptionPane.showMessageDialog(null, "User ID not available!", "Choose a different UserID", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        for(Network network: system.getNetworkList()) {
            EnterpriseDirectory ed = network.getEnterpriseDirectory();
            for( Enterprise e: ed.getEnterpriseList()) {
                if(e instanceof MarketplaceEnterprise) {
                    MarketplaceEnterprise mpt = (MarketplaceEnterprise) e;
                    CustomerDirectory cd = null;
                    for( Organization o: mpt.getOrganizationDirectory().getOrganizationList()) {
                        if(o instanceof CustomerOrganization) {
                            cd = ((CustomerOrganization) o).getCustomerDirectory();
                        }
                    }
                    if( cd != null ) {
                        for(Customer c: cd.getCustomers()) {
                            //Check whether email matches or not
                            if(email.equalsIgnoreCase(c.getEmail())) {
                                JOptionPane.showMessageDialog(null, "Email already registered!!", "Choose a different Email", JOptionPane.ERROR_MESSAGE);
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnRegister;
    private javax.swing.JButton btnReset;
    private javax.swing.JComboBox cmbNetwork;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtName;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsrID;
    // End of variables declaration//GEN-END:variables
}
