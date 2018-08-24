/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EcoSystem.Role;

//import Business.Business;

import EcoSystem.EcoSystem;
import EcoSystem.Enterprise.Enterprise;
import EcoSystem.Organization.Organization;
import EcoSystem.UserAccount.UserAccount;
import UserInterface.AdminRole.AdminWorkArea;
import javax.swing.JPanel;

/**
 *
 * @author raunak
 */
public class AdminRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new AdminWorkArea(userProcessContainer, enterprise);
    }
    
    @Override
    public String toString() {
        return RoleType.Admin.getValue();
    }
    
}
