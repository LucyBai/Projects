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
public class MarketplaceEnterprise extends Enterprise {
    
    private boolean serviceOrgPresent = false;
    
    public MarketplaceEnterprise(String name) {
        super(name, EnterpriseType.Marketplace);
    }
    
    public boolean isServiceOrgPresent() {
        return serviceOrgPresent;
    }

    public void setServiceOrgPresent(boolean serviceOrgPresent) {
        this.serviceOrgPresent = serviceOrgPresent;
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
    
}