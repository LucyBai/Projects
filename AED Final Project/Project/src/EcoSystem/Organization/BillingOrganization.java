/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EcoSystem.Organization;

import EcoSystem.Role.BillingRole;
import EcoSystem.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author UmairAkhtar
 */
public class BillingOrganization extends Organization{
    public BillingOrganization() {
        super(Organization.Type.Billing.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new BillingRole());
        return roles;
    }
    
}
