/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EcoSystem.Order;

import EcoSystem.Organization.StoreOrganization;
import EcoSystem.Product.Product;

/**
 *
 * @author abhinnankit
 */
public class OrderItem {
    
    private double salesPrice;
    private int quantity;
    private StoreOrganization storeOrganization;
    private Product p;

    public OrderItem() {
        
        storeOrganization = null;
        p = null;
    }

    public double getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(double salesPrice) {
        this.salesPrice = salesPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public StoreOrganization getStoreOrganization() {
        return storeOrganization;
    }

    public void setStoreOrganization(StoreOrganization storeOrganization) {
        this.storeOrganization = storeOrganization;
    }

    public Product getP() {
        return p;
    }

    public void setP(Product p) {
        this.p = p;
    }
    
    @Override
    public String toString() {
        return this.getP().toString();
    }
    
}
    

