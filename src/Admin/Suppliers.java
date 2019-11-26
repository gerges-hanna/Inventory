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
 * @author Bebo
 */
public class Suppliers extends Product.FatherClass{
    

    final private String filepath="Supplier.txt";//Final variable can't be modifed

   


   public void ReadData()
     {
         
         productList=(ArrayList<ProductClass>)(Object) file.read(filepath);
     }
     
     
//Supplier Query:ID@Name@LName@SupplierAddress@ContactNumber@SupplierEmail@Category
    @Override
    public boolean Add() {
        if(super.getID()==null)
             super.setID("");
         
         if(!super.getID().trim().equals(""))
         {
            super.setQueryFile(
                    super.getID()+"@"
                    +super.getName()+"@"
                    +super.getLName() +"@"
                    +super.getSupplierAddress()+"@"
                    +super.getContactNumber()+"@"
                    +super.getSupplierEmail()+"@"
                   +super.getCategory()
             );
            
                file.write(super.getQueryFile(), filepath, true);
                return true;
         }else
         {
              System.out.println("You must put an ID");
         }
         return false;
    }

    @Override
    public boolean Delete(Object b1, Object b2) {
        return false;
       
    }

    @Override
    public boolean Update(Object id,Object categ,Object newValue) {
        
        return file.update((String)id, filepath,(String) categ, newValue);
    }
}
