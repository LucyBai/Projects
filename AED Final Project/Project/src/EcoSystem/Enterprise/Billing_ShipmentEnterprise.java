/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EcoSystem.Enterprise;

import EcoSystem.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author UmairAkhtar
 */
public class Billing_ShipmentEnterprise extends Enterprise{
    
    private boolean billingOrgPresent = false;
    
    public Billing_ShipmentEnterprise(String name) {
        super(name, EnterpriseType.Billing_Shipment);
    }
    
    public boolean isBillingOrgPresent() {
        return billingOrgPresent;
    }

    public void setBillingOrgPresent(boolean billingOrgPresent) {
        this.billingOrgPresent = billingOrgPresent;
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
    
}
