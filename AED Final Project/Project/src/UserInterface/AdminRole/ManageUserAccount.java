/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.AdminRole;

import EcoSystem.Employee.Employee;
import EcoSystem.Enterprise.Billing_ShipmentEnterprise;
import EcoSystem.Enterprise.Enterprise;
import EcoSystem.Enterprise.MarketplaceEnterprise;
import EcoSystem.Organization.Organization;
import EcoSystem.Organization.ServiceOrganization;
import EcoSystem.Organization.StoreOrganization;
import EcoSystem.Employee.Employee.SkillType;
import EcoSystem.Organization.BillingOrganization;
import EcoSystem.Organization.DeliveryOrganization;
import EcoSystem.Role.Role;
import EcoSystem.Role.ServiceManRole;
import EcoSystem.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lucy Bai
 */
public final class ManageUserAccount extends javax.swing.JPanel {

    /**
     * Creates new form ManageUserAccountJPanel
     */
    private JPanel container;
    private Enterprise enterprise;
    public ManageUserAccount(JPanel userProcessContainer, Enterprise enterprise) {
        initComponents();
        this.enterprise = enterprise;
        this.container = userProcessContainer;
        populateOrgCmbBox();
        populateSkillCmbBox();
    }
    
    private void populateSkillCmbBox() {
        
        cmbSkill.removeAllItems();
        for(SkillType skillType: SkillType.values()) {
            cmbSkill.addItem(skillType);
        }
        
    }
    
    private void populateOrgCmbBox() {
        
        organizationJComboBox.removeAllItems();
        if( enterprise instanceof MarketplaceEnterprise ) {
            for( Organization organization: enterprise.getOrganizationDirectory().getOrganizationList() ) {
                if(organization instanceof StoreOrganization || organization instanceof ServiceOrganization) {
                    organizationJComboBox.addItem(organization);
                }
            }
        }
        else if( enterprise instanceof Billing_ShipmentEnterprise) {
            for( Organization organization: enterprise.getOrganizationDirectory().getOrganizationList() ) {
                if(organization instanceof BillingOrganization || organization instanceof DeliveryOrganization) {
                    organizationJComboBox.addItem(organization);
                }
            }
        }
    }
    
    private void populateEmployeeComboBox(Organization organization){
        employeeJComboBox.removeAllItems();        
        for (Employee employee : organization.getEmployeeDirectory().getEmployeeList()){
            employeeJComboBox.addItem(employee);
        }
    }
    
    private void populateRoleComboBox(Organization organization){
        roleJComboBox.removeAllItems();
        for (Role role : organization.getSupportedRole()){
            roleJComboBox.addItem(role);
        }
    }

    private void populateData(Organization organization) {
        DefaultTableModel model = (DefaultTableModel) tblUserAccount.getModel();
        model.setRowCount(0);
        for (UserAccount ua : organization.getUserAccountDirectory().getUserAccountList()) {
            Object row[] = new Object[2];
            row[0] = ua;
            row[1] = ua.getRole();
            model.addRow(row);
        }
    }
    
    private void skillVisible(boolean state) {
        
        cmbSkill.setVisible(state);
        lblSkill.setVisible(state);
        cmbSkill.revalidate();
        lblSkill.revalidate();
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCreate = new javax.swing.JButton();
        nameJTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUserAccount = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        passwordJTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        employeeJComboBox = new javax.swing.JComboBox();
        backjButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        organizationJComboBox = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        roleJComboBox = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        cmbSkill = new javax.swing.JComboBox();
        lblSkill = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCreate.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        btnCreate.setText("Create Account");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });
        add(btnCreate, new org.netbeans.lib.awtextra.AbsoluteConstraints(442, 670, -1, -1));
        add(nameJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(362, 542, 220, 36));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setText("User Name");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(233, 549, -1, -1));

        tblUserAccount.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "User Name", "Role"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblUserAccount);
        if (tblUserAccount.getColumnModel().getColumnCount() > 0) {
            tblUserAccount.getColumnModel().getColumn(0).setResizable(false);
            tblUserAccount.getColumnModel().getColumn(1).setResizable(false);
        }

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 123, 462, 156));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("Password");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(246, 603, -1, -1));
        add(passwordJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(362, 596, 220, 36));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setText("Employee");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(242, 386, -1, -1));

        add(employeeJComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(362, 380, 220, 36));

        backjButton1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        backjButton1.setText("<< Back");
        backjButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backjButton1ActionPerformed(evt);
            }
        });
        add(backjButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 670, 168, -1));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setText("Organization");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(221, 332, -1, -1));

        organizationJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                organizationJComboBoxActionPerformed(evt);
            }
        });
        add(organizationJComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(362, 326, 220, 36));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setText("Role");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(281, 440, -1, -1));

        roleJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roleJComboBoxActionPerformed(evt);
            }
        });
        add(roleJComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(362, 434, 220, 36));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel6.setText("Manage UserAccount Work Area");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(141, 32, -1, -1));

        add(cmbSkill, new org.netbeans.lib.awtextra.AbsoluteConstraints(362, 488, 220, 36));

        lblSkill.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblSkill.setText("Skill");
        add(lblSkill, new org.netbeans.lib.awtextra.AbsoluteConstraints(281, 494, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        String userName = nameJTextField.getText();
        String password = passwordJTextField.getText();
        Organization organization = (Organization) organizationJComboBox.getSelectedItem();
        Employee employee = (Employee) employeeJComboBox.getSelectedItem();
        Role role = (Role) roleJComboBox.getSelectedItem();
        if(cmbSkill.getSelectedItem() != null)
            organization.getUserAccountDirectory().createUserAccount(userName, password, employee, role, employee.getClass().getName(), (SkillType)cmbSkill.getSelectedItem());
        else
            organization.getUserAccountDirectory().createUserAccount(userName, password, employee, role, employee.getClass().getName(), (SkillType)cmbSkill.getSelectedItem());
        populateData(organization);
    }//GEN-LAST:event_btnCreateActionPerformed

    private void backjButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backjButton1ActionPerformed
        container.remove(this);
        CardLayout layout = (CardLayout) container.getLayout();
        layout.previous(container);
    }//GEN-LAST:event_backjButton1ActionPerformed

    private void organizationJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_organizationJComboBoxActionPerformed
        Organization organization = (Organization) organizationJComboBox.getSelectedItem();
        if (organization != null){
            populateEmployeeComboBox(organization);
            populateRoleComboBox(organization);
            populateData(organization);
        }
    }//GEN-LAST:event_organizationJComboBoxActionPerformed

    private void roleJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roleJComboBoxActionPerformed
        // TODO add your handling code here:
        Role role = (Role) roleJComboBox.getSelectedItem();
        if(role instanceof ServiceManRole) {
            skillVisible(true);
            populateSkillCmbBox();
        }
        else {
            skillVisible(false);
            cmbSkill.removeAllItems();
            cmbSkill.addItem(null);
            cmbSkill.setSelectedItem(null);
        }
    }//GEN-LAST:event_roleJComboBoxActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backjButton1;
    private javax.swing.JButton btnCreate;
    private javax.swing.JComboBox cmbSkill;
    private javax.swing.JComboBox employeeJComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblSkill;
    private javax.swing.JTextField nameJTextField;
    private javax.swing.JComboBox organizationJComboBox;
    private javax.swing.JTextField passwordJTextField;
    private javax.swing.JComboBox roleJComboBox;
    private javax.swing.JTable tblUserAccount;
    // End of variables declaration//GEN-END:variables
}
