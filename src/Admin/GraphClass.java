/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin;

import Product.Files;
import Product.ProductClass;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class GraphClass {
    
    Files ff = new Files();
    ArrayList<Object> ca = ff.read("Category.txt");
    ArrayList<Object> products = ff.read("Product.txt");
    public void test()
    {
        ArrayList<Integer> ints = new ArrayList();
        
        for(int i = 0; i < products.size(); i++)
        {
            int f = 0;
            for(int g = 0; g < ca.size(); g++)
            {
                if(((ProductClass)products.get(i)).getCategory().equals( 
                        ((Categories)ca.get(g)).getCategory()))
                {
                    f = ((ProductClass)products.get(i)).getQuantity();
                }
                ints.add(f);
            }
        }
    }
    
}
