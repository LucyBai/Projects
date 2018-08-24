/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EcoSystem.Product;

import java.util.ArrayList;

/**
 *
 * @author Lucy Bai
 */
public class ProductCatalog {
    private ArrayList<Product> products;

    public ProductCatalog(){
        products = new ArrayList<>();
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public Product addProduct(){
        Product p = new Product();
        products.add(p);
        System.out.print("#");
        return p;
    }
    
    public void deleteProduct(Product pro){
        products.remove(pro);
    }
    
}
