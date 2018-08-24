/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EcoSystem.Enterprise;

import java.util.ArrayList;

/**
 *
 * @author abhinnankit
 */
public class EnterpriseDirectory {
    
    
    private ArrayList<Enterprise> enterpriseList;
    
    public EnterpriseDirectory() {
        enterpriseList = new ArrayList<>();
    }

    public ArrayList<Enterprise> getEnterpriseList() {
        return enterpriseList;
    }

    public void setEnterpriseList(ArrayList<Enterprise> enterpriseList) {
        this.enterpriseList = enterpriseList;
    }

    public Enterprise createAndAddEnterprise(String name, Enterprise.EnterpriseType enterpriseType) {
        Enterprise enterprise = null;
        if(enterpriseType == Enterprise.EnterpriseType.Billing_Shipment) {
            enterprise = new Billing_ShipmentEnterprise(name);
            enterpriseList.add(enterprise);
        }
        else if (enterpriseType == Enterprise.EnterpriseType.Marketplace ){
            enterprise = new MarketplaceEnterprise(name);
            enterpriseList.add(enterprise);
        }
        return enterprise;
    }
    
}
