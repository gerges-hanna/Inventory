/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory;

import Product.Files;
import Product.ProductClass;
import Admin.*;
/**
 *
 * @author Gerges hanna FCI-H
 */
public class Inventory {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
      
      /* Suppliers obj=new Suppliers();//set files for suppliers try1
       obj.setID("20180007");
       obj.setName("abanoub");
       obj.setLName("rafaat");
       obj.setSupplierAddress("4 St.dokki medan El 7orya");
       obj.setContactNumber(01213124);
       obj.setSupplierEmail("hope1pharmacy@gmail.com");
       obj.setCategory("shampo");
       obj.AddInFileSupplier();
       obj.ReadData();
       obj.UpdateFile("20180007","name","david");*/
      
      //***********************************************
 
       /*Categories obj2=new Categories();//set files for categories try1
       obj2.setCategory("BabiesCategory");
       obj2.setCategoryDescription("include all the products used by babies");
       obj2.AddInFileCategory();
       obj2.setCategory("PainKillers");
       obj2.setCategoryDescription("used to reduce pains");
       obj2.AddInFileCategory();
       obj2.setCategory("Detergents");
       obj2.setCategoryDescription("used in cleaning");
       obj2.AddInFileCategory();
       obj2.setCategory("DiabetesMedications");
       obj2.setCategoryDescription("Used by diabetes");
       obj2.AddInFileCategory();*/
       
       //**************************************************
    
       /*ProductClass p1=new ProductClass();//set files for products try1
       p1.setPrice(223);
       p1.setID(null);
       p1.AddInFileProduct();
       */
       
        //**************************************************
       
       
       
       Login obj3=new Login();
       //obj3.ForgetPassword("HopeAdmin");
      obj3.setUserName("~ueza");
      obj3.setPassword("=ew");
      obj3.setCase("admin");
       obj3.AddInFileLogin();
       
       
       
               
    }
    
}
