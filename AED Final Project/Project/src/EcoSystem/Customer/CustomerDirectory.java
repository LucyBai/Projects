/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EcoSystem.Customer;

import java.util.ArrayList;

/**
 *
 * @author abhinnankit
 */
public class CustomerDirectory {
    
    private ArrayList<Customer> customers;

    public CustomerDirectory() {
        customers = new ArrayList<>();
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }
    
    public Customer addCustomer() {
        
        Customer customer = new Customer();
        customers.add(customer);
        return customer;
        
    }
    
}
