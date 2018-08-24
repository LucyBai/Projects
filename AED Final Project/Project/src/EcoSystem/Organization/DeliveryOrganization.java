/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EcoSystem.Organization;

import EcoSystem.DeliveryPrice.DeliveryPriceCatalog;
import EcoSystem.Role.DeliveryManRole;
import EcoSystem.Role.DeliveryRole;
import EcoSystem.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author UmairAkhtar
 */
public class DeliveryOrganization extends Organization{
    private String orgName;
    private DeliveryType deliveryType;
    private DeliveryPriceCatalog  price;
    public DeliveryOrganization( String deliveryName, DeliveryType deliveryType) {
        super(Organization.Type.Delivery.getValue());
        this.orgName=deliveryName;
        this.deliveryType=deliveryType;
        this.price=new DeliveryPriceCatalog();
    }
      @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new DeliveryRole());
        roles.add(new DeliveryManRole());
        return roles;
    }
    public enum DeliveryType{
        UPS("Ups Delivery"),
        Fedex("Fedex Delivery"),
        USPS("Usps Delivery");
        
        private String value;
        private DeliveryType(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }    
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public DeliveryPriceCatalog getPrice() {
        return price;
    }

    public void setPrice(DeliveryPriceCatalog price) {
        this.price = price;
    }



    public DeliveryType getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(DeliveryType deliveryType) {
        this.deliveryType = deliveryType;
    }
    @Override
    public String toString() {
        return orgName;
    }
    
}
