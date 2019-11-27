/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory;

import Product.*;
import Admin.*;
import AllGui.*;
import AllGui.SaleReview;
import AllGui.SellPanel;
import AllGui.Supplier;
import static Product.ProductClass.productList;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.*;
/**
 *
 * @author Gerges hanna FCI-H
 */
public class Inventory {

    public static JFrame frame= new JFrame("Inventory");
    public static JPanel panelHome =new JPanel();
    public static JPanel panel;
    public static AllGui.FatherGUI fatherGUI=new FatherGUI();
    
    /**
     * @param args the command line arguments
     */
    /*
     public static void setProductTable(String [][] items)
    {
        for (int i = 0; i < productList.size(); i++) {
            
       }
            
            for (int i = 0; i < productList.size(); i++) {
                
                    items[i][0]=productList.get(i).getID();
                    items[i][1]=productList.get(i).getName();
                    items[i][2]=productList.get(i).getLName();
                    items[i][3]=String.valueOf(productList.get(i).getQuantity());
                    items[i][4]=productList.get(i).getParcode();
                    items[i][5]=String.valueOf(productList.get(i).getPrice());
                    items[i][6]=productList.get(i).getCategory();
                    items[i][7]=productList.get(i).getEXP();
//                    if(ExpireRemainder(productList.get(i).getEXP()))
//                    {
//                        ExpObject.setID(productList.get(i).getID());
//                        ExpObject.setName(productList.get(i).getName());
//                        ExpObject.setQuantity(productList.get(i).getQuantity());
//                        ExpObject.setParcode(productList.get(i).getParcode());
//                        ExpObject.setRemainderDay(getRemainderDay());
//                        ExpObject.setCategory(productList.get(i).getCategory());
//                        ExpObject.setPrice(productList.get(i).getPrice());
//                        ListExp.add(ExpObject);
//                    }
                
            
        }
    }
    */
    public static void HomePage() {
        
        int btnH=120,btnW=120;
        int y1=5;
        int y2=150;
        JButton btn1=new JButton("Sell");
        JButton btn2=new JButton("SellReview");
        JButton btn3=new JButton("ADD&Update&Delete Product");
        JButton btn4=new JButton("ADD&Update&Delete Supplier");
        JButton btn5=new JButton("Graph");
        JButton btn6=new JButton("My purchases");
        JButton btn7=new JButton("Register");
        JButton btn8=new JButton("Supplier");
        JButton btn9=new JButton("Category");
        btn1.setBounds(10, y1, btnH,btnW);
        btn2.setBounds(180, y1, btnH,btnW);
        btn3.setBounds(350, y1, btnH,btnW);
        btn4.setBounds(520, y1, btnH,btnW);
        btn5.setBounds(690, y1, btnH,btnW);
        btn6.setBounds(860, y1, btnH,btnW);
        btn7.setBounds(1030, y1, btnH,btnW);
        //Second Line
        btn8.setBounds(10, y2, btnH,btnW);
        btn9.setBounds(180, y2, btnH,btnW);
        //BTN Functions
        btn1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                panelHome.setVisible(false);
                frame.remove(panelHome);
                AllGui.SellPanel s=new SellPanel();
                panel=s.Run();
                frame.add(panel);
                fatherGUI.FrameConfigration(frame);
                
                
            }
        });
        btn2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                panelHome.setVisible(false);
                frame.remove(panelHome);
                AllGui.SaleReview s=new SaleReview();
                panel=s.run();
                frame.add(panel);
                fatherGUI.FrameConfigration(frame);
            }
        });
        btn3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                panelHome.setVisible(false);
                frame.remove(panelHome);
                AllGui.Supplier s=new Supplier();
                panel=s.run();
                frame.add(panel);
                //fatherGUI.FrameConfigration(frame);
                frame.invalidate();
                frame.validate();
            }
        });
        btn5.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                panelHome.setVisible(false);
                frame.remove(panelHome);
                AllGui.Report s=new Report();
                panel=s.Run();
                frame.add(panel);
                fatherGUI.FrameConfigration(frame);
            }
        });
        btn7.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                panelHome.setVisible(false);
                frame.remove(panelHome);
                AllGui.Register r=new AllGui.Register();
                panel=r.Run();
                frame.add(panel);
                fatherGUI.FrameConfigration(frame);
            }
        });
        btn8.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae)
            {
                panelHome.setVisible(false);
                frame.remove(panelHome);
                AllGui.Supplier s=new AllGui.Supplier();
                panel=s.run();
                frame.add(panel);
                fatherGUI.FrameConfigration(frame);
              
            }
        });
        btn9.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae)
            {
                panelHome.setVisible(false);
                frame.remove(panelHome);
                AllGui.CategoreyGUI s=new AllGui.CategoreyGUI();
                panel=s.Run();
                frame.add(panel);
                fatherGUI.FrameConfigration(frame);
              
            }
        });
        panelHome.setLayout(null);
        panelHome.setBackground(Color.yellow);
        panelHome.add(btn1);
        panelHome.add(btn2);
        panelHome.add(btn3);
        panelHome.add(btn4);
        panelHome.add(btn5);
        panelHome.add(btn6);
        panelHome.add(btn7);
        panelHome.add(btn8);
        panelHome.add(btn9);
        panelHome.setSize(1200, 700);
        panelHome.setVisible(true);
        frame.add(panelHome);
        fatherGUI.FrameConfigration(frame);
        
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
