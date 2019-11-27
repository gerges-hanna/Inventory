/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory;

import Product.*;
import Admin.*;
import AllGui.FatherGUI;
import AllGui.SaleReview;
import AllGui.SellPanel;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
/**
 *
 * @author Gerges hanna FCI-H
 */
public class Inventory {

    public static JFrame frame= new JFrame("Inventory");
    public static JPanel panelHome =new JPanel();
    public static JPanel panel;
    
    /**
     * @param args the command line arguments
     */

    public static void HomePage() {
        AllGui.FatherGUI fatherGUI=new FatherGUI();
        int btnH=120,btnW=120;
        int y1=5;
        JButton btn1=new JButton("Sell");
        JButton btn2=new JButton("SellReview");
        JButton btn3=new JButton("ADD&Update&Delete Product");
        JButton btn4=new JButton("ADD&Update&Delete Supplier");
        JButton btn5=new JButton("Graph");
        JButton btn6=new JButton("My purchases");
        btn1.setBounds(10, y1, btnH,btnW);
        btn2.setBounds(180, y1, btnH,btnW);
        btn3.setBounds(350, y1, btnH,btnW);
        btn4.setBounds(520, y1, btnH,btnW);
        btn5.setBounds(690, y1, btnH,btnW);
        btn6.setBounds(860, y1, btnH,btnW);
        //BTN Functions
        btn1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.remove(panelHome);
                AllGui.SellPanel s=new SellPanel();
                panel=s.Run();
                fatherGUI.panelMainConfigration(panel, frame);
                frame.add(panel);
            }
        });
        btn2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(panelHome);
                AllGui.SaleReview s=new SaleReview();
                panel=s.run();
                fatherGUI.panelMainConfigration(panel, frame);
                frame.add(panel);
            }
        });
        panelHome.setBackground(Color.yellow);
        panelHome.add(btn1);
        panelHome.add(btn2);
        panelHome.add(btn3);
        panelHome.add(btn4);
        panelHome.add(btn5);
        panelHome.add(btn6);
        fatherGUI.FrameConfigration(frame);
        fatherGUI.panelMainConfigration(panelHome, frame);
    }
    public static void runPanel()
    {
        frame.remove(panel);
        frame.add(panelHome);
        
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
