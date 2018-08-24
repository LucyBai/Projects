/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EcoSystem.Order;

import java.util.ArrayList;

/**
 *
 * @author abhinnankit
 */
public class OrderList {
    
    private ArrayList<Order> orders;
    
    public  OrderList() {
        orders = new ArrayList<>();
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }
    
    public Order addOrder(Order order) {
         orders.add(order);
         return order;
    }
    
    public boolean searchOrder(Order order) {
        for(Order o: getOrders()) {
            if(order.getOrderId() == o.getOrderId()) {
                return true;
            }
        }
        return false;
    }
    
}
