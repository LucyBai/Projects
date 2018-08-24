/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EcoSystem.AccountValidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author abhinnankit
 */
public class Validator {
    
    private static Matcher matcher;
    private static Pattern pattern;
    
    public static boolean isValidUserID(String string) {
        
        String regEx = "[a-z0-9]+(\\.[a-z0-9]+)*";
        pattern = Pattern.compile(regEx);
        matcher = pattern.matcher(string);
        
        return matcher.matches();
        
    }
    
    public static boolean isValidEmail(String string) {
        
        String regEx = "[a-zA-Z0-9]+(?:(\\.|_)[A-Za-z0-9!#$%&'*+/=?^`{|}~-]+)*@(?!([a-zA-Z0-9]*\\.[a-zA-Z0-9]*\\.[a-zA-Z0-9]*\\.))(?:[A-Za-z0-9](?:[a-zA-Z0-9-]*[A-Za-z0-9])?\\.)+[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?";
        pattern = Pattern.compile(regEx);
        matcher = pattern.matcher(string);
        
        return matcher.matches();
        
    }
    
    public static boolean isValidPassword(String string) {
        
        String regEx = "^(?=.{8,})(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\\s).*$";
        pattern = Pattern.compile(regEx);
        matcher = pattern.matcher(string);
        
        return matcher.matches();
        
    }
    
    public static boolean isValidDate(String string) {
        
        String regEx = "^(?=.{8,})(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\\s).*$";
        pattern = Pattern.compile(regEx);
        matcher = pattern.matcher(string);
        
        return matcher.matches();
        
    }
    
}
