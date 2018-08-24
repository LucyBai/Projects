/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EcoSystem.Enterprise;

import EcoSystem.Order.OrderList;
import EcoSystem.Organization.Organization;
import EcoSystem.Organization.OrganizationDirectory;

/**
 *
 * @author abhinnankit
 */
public abstract class Enterprise extends Organization {
    
    private EnterpriseType enterpriseType;
    private OrganizationDirectory organizationDirectory;

    public enum EnterpriseType {
        
        Billing_Shipment("Billing_Shipment"),
        Marketplace("Marketplace");
        
        private EnterpriseType(String value) {
            this.value = value;
        }
        
        private String value;

        public String getValue() {
            return value;
        }
        
        @Override
        public String toString() {
            return value;
        }
    }
    
    public OrganizationDirectory getOrganizationDirectory() {
        return organizationDirectory;
    }

    public EnterpriseType getEnterpriseType() {
        return enterpriseType;
    }

    public void setEnterpriseType(EnterpriseType enterpriseType) {
        this.enterpriseType = enterpriseType;
    }
    
    public Enterprise(String name, EnterpriseType type) {
        super(name);
        this.enterpriseType = type;
        this.organizationDirectory = new OrganizationDirectory();
    }
    
}
