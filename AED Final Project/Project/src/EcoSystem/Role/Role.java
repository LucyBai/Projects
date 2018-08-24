/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EcoSystem.Role;

import EcoSystem.EcoSystem;
import EcoSystem.Enterprise.Enterprise;
import EcoSystem.Organization.Organization;
import EcoSystem.UserAccount.UserAccount;
import javax.swing.JPanel;

/**
 *
 * @author abhinnankit
 */
public abstract class Role {
    
    public enum RoleType{
        Admin("Admin"),
        Store("Store Manager"),
        Service("Service Manager"), 
        Customer("Customer"),
        Billing("Billing Manager"),
        Delivery("Delivery Manager"),
        ServiceMan("Service Man"),
        DeliveryMan("Delivery Man");
        
        private String value;
        private RoleType(String value){
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }
    
    public abstract JPanel createWorkArea(JPanel userProcessContainer, 
            UserAccount account, 
            Organization organization, 
            Enterprise enterprise, 
            EcoSystem business);

    @Override
    public String toString() {
        return this.getClass().getName();
    }
    
}