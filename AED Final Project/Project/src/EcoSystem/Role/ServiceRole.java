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
import UserInterface.ServiceManager.ServiceManagerWrokArea;
import javax.swing.JPanel;

/**
 *
 * @author UmairAkhtar
 */
public class ServiceRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new ServiceManagerWrokArea(userProcessContainer, account, (ServiceOrganization)organization, enterprise);
    }
    
    @Override
    public String toString() {
        return RoleType.Service.getValue();
    }
    
}
