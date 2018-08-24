/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EcoSystem.WorkQueue;

import EcoSystem.Employee.Employee;
import EcoSystem.Order.Order;
import java.util.Date;

/**
 *
 * @author Lucy Bai
 */
public class DeliveryProductWorkRequest extends WorkRequest{
    private Order order;
    private Date date;
    private Employee employee;
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    
}
