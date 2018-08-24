/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EcoSystem.Role;

import EcoSystem.EcoSystem;
import EcoSystem.Enterprise.Enterprise;
import EcoSystem.Organization.BillingOrganization;
import EcoSystem.Organization.Organization;
import EcoSystem.UserAccount.UserAccount;
import UserInterface.BillingManagerRole.BillingManagerWorkArea;
import javax.swing.JPanel;

/**
 *
 * @author UmairAkhtar
 */
public class BillingRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new BillingManagerWorkArea(userProcessContainer, account, (BillingOrganization)organization, enterprise, business);
    }
    
    @Override
    public String toString() {
        return RoleType.Billing.getValue();
    }
    
}
