/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EcoSystem.UserAccount;

import EcoSystem.Customer.Customer;
import EcoSystem.Employee.Employee;
import EcoSystem.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author abhinnankit
 */
public class UserAccountDirectory {
    
    private ArrayList<UserAccount> userAccountList;

    public UserAccountDirectory() {
        userAccountList = new ArrayList<>();
    }

    public ArrayList<UserAccount> getUserAccountList() {
        return userAccountList;
    }
    
    public UserAccount authenticateUser(String username, String password){
        for (UserAccount ua : userAccountList)
            if (ua.getUsername().equals(username) && ua.getPassword().equals(password)){
                return ua;
            }
        return null;
    }
    
    public UserAccount createUserAccount(String username, String password, Object o, Role role, String className) {
        
        UserAccount userAccount = new UserAccount();
        userAccount.setUsername(username);
        userAccount.setPassword(password);
        if(className.substring(className.lastIndexOf('.')+1, className.length()).equals(Employee.class.getName().substring(Employee.class.getName().lastIndexOf('.')+1, Employee.class.getName().length()))) {
            userAccount.setEmployee((Employee)o);
        }
        else if(className.substring(className.lastIndexOf('.')+1, className.length()).equals(Customer.class.getName().substring(Customer.class.getName().lastIndexOf('.')+1, Customer.class.getName().length()))) {
            userAccount.setCustomer((Customer)o);
        }
        userAccount.setRole(role);
        userAccountList.add(userAccount);
        return userAccount;
    }
    
    public UserAccount createUserAccount(String username, String password, Object o, Role role, String className, Employee.SkillType skillType) {
        
        UserAccount userAccount = new UserAccount();
        userAccount.setUsername(username);
        userAccount.setPassword(password);
        if(className.substring(className.lastIndexOf('.')+1, className.length()).equals(Employee.class.getName().substring(Employee.class.getName().lastIndexOf('.')+1, Employee.class.getName().length()))) {
            userAccount.setEmployee((Employee)o);
            userAccount.setSkillType(skillType);
        }
        else if(className.substring(className.lastIndexOf('.')+1, className.length()).equals(Customer.class.getName().substring(Customer.class.getName().lastIndexOf('.')+1, Customer.class.getName().length()))) {
            userAccount.setCustomer((Customer)o);
        }
        userAccount.setRole(role);
        userAccountList.add(userAccount);
        return userAccount;
    }
    
    public boolean checkIfUsernameIsUnique(String username) {
        
        if(userAccountList != null)
        for (UserAccount ua : userAccountList){
            if (ua.getUsername().equals(username))
                return false;
        }
        return true;
        
    }
}
