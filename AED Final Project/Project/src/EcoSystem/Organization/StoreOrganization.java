/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EcoSystem.Organization;


import EcoSystem.Role.Role;
import EcoSystem.Role.StoreRole;
import java.util.ArrayList;

/**
 *
 * @author abhinnankit
 */
public class StoreOrganization extends Organization{

    private String orgName;
    private StoreType storeType;
    
    public StoreOrganization(String storeName, StoreType storeType) {
        
        super(Type.Store.getValue());
        this.storeType = storeType;
        this.orgName = storeName;

    }
    
    public enum StoreType {
        
        Grocery("Grocery Store"), Clothes("Clothes Store"), Drug("Drug Store");
        
        private String value;
        private StoreType(String value) {
            this.value = value;
        }
        
        public String getValue() {
            return value;
        }
        
    }

    public StoreType getStoreType() {
        return storeType;
    }

    public void setStoreType(StoreType storeType) {
        this.storeType = storeType;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new StoreRole());
        return roles;
    }
    
    @Override
    public String toString() {
        return orgName;
    }

}
