/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EcoSystem.DeliveryPrice;

/**
 *
 * @author Lucy Bai
 */
public class DeliveryPrice {
    private String service;
    private Double standeredPrice;
    private Double perPrice;

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public Double getStanderedPrice() {
        return standeredPrice;
    }

    public void setStanderedPrice(Double standeredPrice) {
        this.standeredPrice = standeredPrice;
    }

    public Double getPerPrice() {
        return perPrice;
    }

    public void setPerPrice(Double perPrice) {
        this.perPrice = perPrice;
    }

    @Override
    public String toString() {
        return service;
    }
    
}
