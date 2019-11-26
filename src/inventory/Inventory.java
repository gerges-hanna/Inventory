/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory;

import Product.*;
import Admin.*;
import AllGui.FatherGUI;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 *
 * @author Gerges hanna FCI-H
 */
public class Inventory {

    public static JFrame frame= new JFrame("Inventory");
    public static JPanel panelHome =new JPanel();
    
    /**
     * @param args the command line arguments
     */
    public static void HomePage()
    {
        AllGui.FatherGUI fatherGUI=new FatherGUI();
        int btnHigw,btnWidth;
        int x1,x2,x3,x4,x5,x6;
        int y1,y2;
        
        JButton btn1=new JButton();
        JButton btn2=new JButton();
        JButton btn3=new JButton();
        JButton btn4=new JButton();
        JButton btn5=new JButton();
        JButton btn6=new JButton();
        panelHome.setBackground(Color.yellow);
        
        
        
        
        fatherGUI.FrameConfigration(frame);
        fatherGUI.panelMainConfigration(panelHome, frame);
    }
    public static void main(String[] args) {
        // TODO code application logic here
        HomePage();
        
      /*
       Suppliers obj=new Suppliers();//set files for suppliers try1
       obj.setID("kjoi");
       obj.setName("bebo");
       obj.setLName("pop");
       obj.setSupplierAddress("share3 el fegla");
       obj.setContactNumber(01213345124);
       obj.setSupplierEmail("hope1pharmacy@gmail.com");
       obj.setCategory("shampo");
       obj.Add();
        obj.ReadData();
       obj.Update("20180007","name","david");
        */
      
      
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
       
    
//        try {
//            AllGui.Login l=new AllGui.Login();
//            l.run();
//        } catch (Exception e) {
//        }
        
//      inventory.Login log=new Login();
//     if(log.Checker("gesre8","128438","client"))
//     {
//         System.out.println("exist");
//     }
//     else {
//         System.out.println("dosent exist");
//     }
       
       
       
               
    }
    
}
