/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EcoSystem;
import EcoSystem.Enterprise.Enterprise;
import EcoSystem.Network.Network;
import EcoSystem.Organization.Organization;
import EcoSystem.Role.Role;
import EcoSystem.Role.SystemAdminRole;
import java.util.ArrayList;

/**
 *
 * @author abhinnankit
 */
public class EcoSystem extends Organization {
    
    
    private ArrayList<Network> networkList;
    private static EcoSystem system;
    
    private String name = "Ecosystem";
    
    private EcoSystem() {
        super(null);
        networkList = new ArrayList<>();
    }
    
    public static EcoSystem getInstance() {
        if(system == null) {
            system = new EcoSystem();
        }
        return system;
    }

    public ArrayList<Network> getNetworkList() {
        return networkList;
    }

    public void setNetworkList(ArrayList<Network> networkList) {
        this.networkList = networkList;
    }
    
    public Network createAndAddNetwork() {
        Network network = new Network();
        networkList.add(network);
        return network;
    }
    
    public boolean checkIfUserIsUnique(String userName) {
        
        if(!this.getUserAccountDirectory().checkIfUsernameIsUnique(userName)) {
            return false;
        }
        
        for (Network network: networkList) {
            for( Enterprise e: network.getEnterpriseDirectory().getEnterpriseList()) {
                if(!e.getUserAccountDirectory().checkIfUsernameIsUnique(userName))
                    return false;
                for( Organization o : e.getOrganizationDirectory().getOrganizationList()) {
                    if(!o.getUserAccountDirectory().checkIfUsernameIsUnique(userName))
                        return false;
                }
            }
        }
        return true;
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roleList = new ArrayList<>();
        roleList.add(new SystemAdminRole());
        return roleList;
    }
    
}
