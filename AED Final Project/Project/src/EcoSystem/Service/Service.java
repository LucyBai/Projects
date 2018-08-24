/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EcoSystem.Service;

import EcoSystem.Employee.Employee.SkillType;
import EcoSystem.Order.Order;
import java.util.Date;

/**
 *
 * @author Lucy Bai
 */
public class Service extends Order{
    private int hours;
    private String problem;
    private String address;
    private int serviceId;
    private Date serviceDate = new Date();
    private Date serviceTime = new Date();
    private SkillType serviceType;
    public static int count = 1;
    public Service(){
        this.serviceId=count;
        count++;
                
    }

    public SkillType getServiceType() {
        return serviceType;
    }

    public void setServiceType(SkillType serviceType) {
        this.serviceType = serviceType;
    }

    
    public String getProblem() {
        return problem;
        
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public Date getServiceDate() {
        return serviceDate;
    }

    public void setServiceDate(Date serviceDate) {
        this.serviceDate = serviceDate;
    }

    public Date getServiceTime() {
        return serviceTime;
    }

    public void setServiceTime(Date serviceTime) {
        this.serviceTime = serviceTime;
    }
    
}
