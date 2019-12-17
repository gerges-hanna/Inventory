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
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
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
    public static JPanel panelHome =null;
    public static JPanel panel;
    public static AllGui.FatherGUI fatherGUI=new FatherGUI();
    
    /**
     * @param args the command line arguments
     */

    
    public static void HomePage() {
        panelHome=new JPanel();
        int btnH=142,btnW=72;
        int y1=5;
        int y2=150;
        JButton btn1=new JButton("Buy");
        JButton btn2=new JButton("Sell Review");
        JButton btn3=new JButton("Product");
        JButton btn4=new JButton("Supplier");
        JButton btn5=new JButton("Graph");
        JButton btn6=new JButton("My Purchases");
        JButton btn7=new JButton("Contact Us");
        JButton btn8=new JButton("Category");
        JButton btn9=new JButton("Log Out");
        JButton btn10=new JButton("Edit Data");
        btn1.setBounds(386, 92, btnH,btnW);
        btn2.setBounds(671, 93, btnH,btnW);
        btn3.setBounds(257,432, btnH,btnW);
        btn4.setBounds(257, 196, btnH,btnW);
        btn5.setBounds(903, 315, btnH,btnW);
        btn6.setBounds(800, 196, btnH,btnW);
        btn7.setBounds(385,536, btnH,btnW);
//        //Second Line
        btn8.setBounds(153, 315, btnH,btnW);
        btn9.setBounds(671,536, btnH,btnW);
        btn10.setBounds(800,433, btnH, btnW);      
 //Button Color
          btn1.setBackground(new Color(38, 34, 15));
          btn2.setBackground(new Color(38, 34, 15));
          btn3.setBackground(new Color(38, 34, 15));
          btn4.setBackground(new Color(38, 34, 15));
          btn5.setBackground(new Color(38, 34, 15));
          btn6.setBackground(new Color(38, 34, 15));
          btn7.setBackground(new Color(38, 34, 15));
          btn8.setBackground(new Color(38, 34, 15));
          btn9.setBackground(new Color(38, 34, 15));
          btn10.setBackground(new Color(38, 34, 15));
          
        //Button font Color
          btn1.setForeground(Color.WHITE);
          btn2.setForeground(Color.WHITE);
          btn3.setForeground(Color.WHITE);
          btn4.setForeground(Color.WHITE);
          btn5.setForeground(Color.WHITE);
          btn6.setForeground(Color.WHITE);
          btn7.setForeground(Color.WHITE);
          btn8.setForeground(Color.WHITE);
          btn9.setForeground(Color.WHITE);
          btn10.setForeground(Color.WHITE);
          
        //Button text Size
          btn1.setFont(new Font("Tahoma", 0, 20));
          btn2.setFont(new Font("Tahoma", 0, 20));
          btn3.setFont(new Font("Tahoma", 0, 20));
          btn4.setFont(new Font("Tahoma", 0, 20));
          btn5.setFont(new Font("Tahoma", 0, 20));
          btn6.setFont(new Font("Tahoma", 0, 18));
          btn7.setFont(new Font("Tahoma", 0, 20));
          btn8.setFont(new Font("Tahoma", 0, 20));
          btn9.setFont(new Font("Tahoma", 0, 20));
          btn10.setFont(new Font("Tahoma", 0, 20));
          
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
                panel=s.Run();
                frame.add(panel);
                fatherGUI.FrameConfigration(frame);
            }
        });
        btn3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                panelHome.setVisible(false);
                frame.remove(panelHome);
                AllGui.ProductGUI s=new AllGui.ProductGUI();
                panel=s.Run();
                frame.add(panel);
                fatherGUI.FrameConfigration(frame);
            }
        });
        btn4.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae)
            {
                panelHome.setVisible(false);
                frame.remove(panelHome);
                AllGui.Supplier s=new AllGui.Supplier();
                panel=s.Run();
                frame.add(panel);
                fatherGUI.FrameConfigration(frame);
              
            }
        });
        btn5.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                AllGui.Report s=new Report();
                s.Run();
            }
        });
        btn6.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                panelHome.setVisible(false);
                frame.remove(panelHome);
                AllGui.ClientReview r=new AllGui.ClientReview();
                panel=r.Run();
                frame.add(panel);
                fatherGUI.FrameConfigration(frame);
            }
        });
        btn7.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                panelHome.setVisible(false);
                frame.remove(panelHome);
                AllGui.ContactUs r=new AllGui.ContactUs();
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
                AllGui.CategoreyGUI s=new AllGui.CategoreyGUI();
                panel=s.Run();
                frame.add(panel);
                fatherGUI.FrameConfigration(frame);
              
            }
        });
        btn9.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                AllGui.Login l=new AllGui.Login();
                FatherClass.setType(null);
                l.Run();
                frame.remove(panelHome);
                frame.dispose();
            }
        });
        btn10.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
            
                panelHome.setVisible(false);
                frame.remove(panelHome);
                AllGui.EditData s=new EditData();
                panel=s.Run();
                frame.add(panel);
                fatherGUI.FrameConfigration(frame);
            }
        });
        
        JLabel label=new JLabel();
        label.setIcon(new ImageIcon("src/inventory/newcolor9-01.png"));
        label.setBounds(0, 0, 1200, 700);
        if(FatherClass.getType().equalsIgnoreCase("User"))
        {
            btn2.setEnabled(false);
            btn5.setEnabled(false);
            btn8.setEnabled(false);
        }else if(FatherClass.getType().equalsIgnoreCase("Client"))
        {
            btn2.setEnabled(false);
            btn3.setEnabled(false);
            btn4.setEnabled(false);
            btn5.setEnabled(false);
            btn8.setEnabled(false);
        }else if(FatherClass.getType().equalsIgnoreCase("Admin"))
        {
            btn10.setEnabled(false);
        }
        
        panelHome.setLayout(null);
        panelHome.add(btn1);
        panelHome.add(btn2);
        panelHome.add(btn3);
        panelHome.add(btn4);
        panelHome.add(btn5);
        panelHome.add(btn6);
        panelHome.add(btn7);
        panelHome.add(btn8);
        panelHome.add(btn9);
        panelHome.add(btn10);
        panelHome.setSize(1200, 700);
        panelHome.add(label);
        panelHome.setVisible(true);
        frame.add(panelHome);
        fatherGUI.FrameConfigration(frame);
        
    }
    public static void runPanel()
    {
        
        panelHome.setSize(1200, 700);
         panelHome.setVisible(true);
         panel.setVisible(false);
        frame.remove(panel);
        frame.add(panelHome);
        fatherGUI.FrameConfigration(frame);
        
    }
    public static void main(String[] args) {
        // TODO code application logic here
       // HomePage(); 
        AllGui.Login l=new AllGui.Login();
        l.Run();
        
        
//        

       
       
               
    }
    
}
