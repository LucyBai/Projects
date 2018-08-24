/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EcoSystem.Service;

import java.util.ArrayList;

/**
 *
 * @author Lucy Bai
 */
public class ServiceList {
    private ArrayList<Service> services;
    public ServiceList(){
        services =new ArrayList();
        
    }

    public ArrayList<Service> getServices() {
        return services;
    }
    public void setServices(ArrayList<Service> services) {
        this.services = services;
    }
    public Service addService(Service service){
        services.add(service);
        return service;
    }
}
