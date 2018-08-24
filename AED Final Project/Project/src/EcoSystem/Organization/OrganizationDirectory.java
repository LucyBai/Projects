/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EcoSystem.Organization;

import EcoSystem.Organization.Organization.Type;
import java.util.ArrayList;

/**
 *
 * @author abhinnankit
 */
public class OrganizationDirectory {
    
    private ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList<>();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }
    
    public Organization createOrganization(Type type, StoreOrganization.StoreType storeType, String storeName,DeliveryOrganization.DeliveryType deliveryType,String deliveryName){
        Organization organization = null;
        if (type.getValue().equals(Type.Store.getValue())){
            organization = new StoreOrganization(storeName, storeType);
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.Service.getValue())){
            organization = new ServiceOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.Billing.getValue())){
            organization = new BillingOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.Delivery.getValue())){
            organization = new DeliveryOrganization(deliveryName,deliveryType);
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.Customer.getValue())){
            organization = new CustomerOrganization();
            organizationList.add(organization);
        }
        return organization;
    }
}