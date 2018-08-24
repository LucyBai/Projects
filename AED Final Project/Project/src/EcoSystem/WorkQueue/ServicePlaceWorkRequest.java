/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EcoSystem.WorkQueue;

import EcoSystem.Service.Service;


/**
 *
 * @author Lucy Bai
 */
public class ServicePlaceWorkRequest extends WorkRequest{
    private Service service;
    public ServicePlaceWorkRequest(){
        service=new Service();
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }
    
}
