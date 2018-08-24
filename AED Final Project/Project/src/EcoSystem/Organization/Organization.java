/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EcoSystem.Organization;

import EcoSystem.UserAccount.UserAccountDirectory;
import EcoSystem.Employee.EmployeeDirectory;
import EcoSystem.Product.ProductCatalog;
import EcoSystem.Role.Role;
import EcoSystem.WorkQueue.WorkQueue;
import java.util.ArrayList;

/**
 *
 * @author abhinnankit
 */
public abstract class Organization {
    
    private String name;
    private WorkQueue workQueue;
    private EmployeeDirectory employeeDirectory;
    private UserAccountDirectory userAccountDirectory;
    private int organizationID = 1;
    private static int counter;
    private ProductCatalog products;
    public ProductCatalog getProducts() {
        return products;
    }

    public void setProducts(ProductCatalog products) {
        this.products = products;
    }

    public enum Type {
        
        Admin("Admin Organization"),
        Store("Store Organization"),
        Service("Service Organization"),
        Customer("Customer Organization"),
        Billing("Billing Organization"),
        Delivery("Delivery Organization");
        
        private String value;
        private Type(String value) {
            this.value = value;
        }
        
        public String getValue() {
            return value;
        }
        
    }
    
    public Organization(String name) {
        this.name = name;
        workQueue = new WorkQueue();
        employeeDirectory = new EmployeeDirectory();
        userAccountDirectory = new UserAccountDirectory();
        products = new ProductCatalog();

        organizationID = counter;
        ++counter;
    }

    public abstract ArrayList<Role> getSupportedRole();
    
    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }

    public int getOrganizationID() {
        return organizationID;
    }

    public EmployeeDirectory getEmployeeDirectory() {
        return employeeDirectory;
    }
    
    public String getName() {
        return name;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }

    @Override
    public String toString() {
        return name;
    }
    
}