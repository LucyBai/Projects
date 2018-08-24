/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EcoSystem.DeliveryPrice;

import EcoSystem.Product.Product;
import java.util.ArrayList;

/**
 *
 * @author Lucy Bai
 */
public class DeliveryPriceCatalog {
    private ArrayList<DeliveryPrice> deliveryPriceCatalog;

    public DeliveryPriceCatalog() {
        deliveryPriceCatalog=new ArrayList();
    }

    public ArrayList<DeliveryPrice> getDeliveryPriceCatalog() {
        return deliveryPriceCatalog;
    }

    public void setDeliveryPriceCatalog(ArrayList<DeliveryPrice> deliveryPriceCatalog) {
        this.deliveryPriceCatalog = deliveryPriceCatalog;
    }
   public DeliveryPrice addDeliveryPrice(){
        DeliveryPrice dp = new DeliveryPrice();
        deliveryPriceCatalog.add(dp);
        return dp;
    }
    
    public void deleteProduct(DeliveryPrice del){
        deliveryPriceCatalog.remove(del);
    }
 
    
}
