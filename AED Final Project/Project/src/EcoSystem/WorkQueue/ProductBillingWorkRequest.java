/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EcoSystem.WorkQueue;

import EcoSystem.Order.Order;

/**
 *
 * @author Lucy Bai
 */
public class ProductBillingWorkRequest extends WorkRequest{
    
    private Order order;
    public ProductBillingWorkRequest(){
        order =new Order();
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
    
}
