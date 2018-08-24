/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EcoSystem.UserAccount;

import EcoSystem.Customer.Customer;
import EcoSystem.Employee.Employee;
import EcoSystem.Employee.Employee.SkillType;
import EcoSystem.Role.Role;
import EcoSystem.WorkQueue.WorkQueue;

/**
 *
 * @author abhinnankit
 */
public class UserAccount {
    
    private String username;
    private String password;
    private Employee employee;
    private Role role;
    private WorkQueue workQueue;
    private Customer customer;
    private SkillType skillType;

    public UserAccount() {
        workQueue = new WorkQueue();
        employee = null;
        customer = null;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Employee getEmployee() {
        return employee;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
    @Override
    public String toString() {
        return username;
    }

    public SkillType getSkillType() {
        return skillType;
    }

    public void setSkillType(SkillType skillType) {
        this.skillType = skillType;
    }
    
}