/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EcoSystem.Organization;

import EcoSystem.Customer.CustomerDirectory;
import EcoSystem.Order.OrderList;
import EcoSystem.Role.CustomerRole;
import EcoSystem.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author UmairAkhtar
 */
public class CustomerOrganization extends Organization{
    
    private OrderList orderList;
    private CustomerDirectory customerDirectory;
    
    public CustomerOrganization() {
        super(Organization.Type.Customer.getValue());
        this.customerDirectory = new CustomerDirectory();
        this.orderList = new OrderList();
    }

    public CustomerDirectory getCustomerDirectory() {
        return customerDirectory;
    }

    public void setCustomerDirectory(CustomerDirectory customerDirectory) {
        this.customerDirectory = customerDirectory;
    }
    
    public OrderList getOrderList() {
        return orderList;
    }

    public void setOrderList(OrderList orderList) {
        this.orderList = orderList;
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new CustomerRole());
        return roles;
    }
    
}
