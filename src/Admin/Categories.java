/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin;

import Product.*;
import static Product.ProductClass.productList;
import java.util.ArrayList;

/**
 *
 * @author bebo
 */
public class Categories extends Product.FatherClass {
    
    
    final private String filepath="Category.txt";//Final variable can't be modifed

    /*
    private double CategoryPrice;//this variable contain the whole Category price
    public double getCategoryPrice() {
        return CategoryPrice;
    }

    public void setCategoryPrice(int CategoryPrice) {
        this.CategoryPrice = CategoryPrice;
    }*/
    
     public void ReadData()
     {
         
         productList=(ArrayList<ProductClass>)(Object) file.read(filepath);
     }
     

    @Override
    public boolean Add() {//Query: Category@CategoryDescription
        if(super.getID()==null)
             super.setID("");
         
         if(!super.getID().trim().equals(""))
         {
                 super.setQueryFile(super.getCategory() + "@" +super.getCategoryDescription());
                file.write(super.getQueryFile(), filepath, true);
                return true;
         }
         else
         {
               System.out.println("You must put valid Category name");    
         }
        return false;
    }

    @Override
    public boolean Delete(Object b1, Object b2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean Update(Object id, Object categ, Object newValue) {
        return file.update((String)id, filepath,(String) categ, newValue);
    }
    
}
