/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EcoSystem.Role;

import EcoSystem.EcoSystem;
import EcoSystem.Enterprise.Enterprise;
import EcoSystem.Organization.DeliveryOrganization;
import EcoSystem.Organization.Organization;
import EcoSystem.UserAccount.UserAccount;
import UserInterface.DeliveryManRole.DeliveryManWorkArea;
import javax.swing.JPanel;

/**
 *
 * @author Lucy Bai
 */
public class DeliveryManRole extends Role{
    
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new DeliveryManWorkArea(userProcessContainer, account, (DeliveryOrganization)organization, enterprise);
    }
    
    @Override
    public String toString() {
        return Role.RoleType.DeliveryMan.getValue();
    }
}
