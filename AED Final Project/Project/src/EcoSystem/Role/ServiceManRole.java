/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EcoSystem.Role;

import EcoSystem.EcoSystem;
import EcoSystem.Enterprise.Enterprise;
import EcoSystem.Organization.Organization;
import EcoSystem.Organization.ServiceOrganization;
import EcoSystem.UserAccount.UserAccount;
import UserInterface.ServiceMan.ServiceManWorkArea;
import javax.swing.JPanel;

/**
 *
 * @author abhinnankit
 */
public class ServiceManRole extends Role {

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new ServiceManWorkArea(userProcessContainer, account, (ServiceOrganization)organization, enterprise);
    }
    
    @Override
    public String toString() {
        return RoleType.ServiceMan.getValue();
    }
    
}
