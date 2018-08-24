/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EcoSystem.Order;

import EcoSystem.Organization.StoreOrganization;
import EcoSystem.Product.Product;
import EcoSystem.UserAccount.UserAccount;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author abhinnankit
 */
public class Order {
    
    private UserAccount userAccount;
    private int orderId;
    public static int count = 1;
    private double price;
    private boolean  delivery;
    private boolean paid;
    private Date date;
    private String address;
    private ArrayList<OrderItem> orderItemList;
    
    public Order() {
        this.userAccount = new UserAccount();
        this.orderId = count;
        count++;
        orderItemList = new ArrayList<>();
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    public boolean isDelivery() {
        return delivery;
    }

    public void setDelivery(boolean delivery) {
        this.delivery = delivery;
    }
    
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public ArrayList<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(ArrayList<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }
    
    public void removeOrderitem(OrderItem orderItem) {
        orderItemList.remove(orderItem);
    }
    
    public OrderItem addOrderItem(StoreOrganization so,int quantity, double price, Product P) {
        OrderItem o = new OrderItem();
        o.setP(P);
        o.setStoreOrganization(so);
        o.setQuantity(quantity);
        o.setSalesPrice(price);
        orderItemList.add(o);
        return o;
    }
        
    @Override
    public String toString() {
        return String.valueOf(this.orderId);
    }
    
}
