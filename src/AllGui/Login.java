/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AllGui;

import Client.ClientClass;
import Product.FatherClass;
import Product.ProductClass;
import inventory.Inventory;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.text.StyleConstants;

/**
 *
 * @author Gerges hanna FCI-H
 */
public class Login {
    //initialize Gui 
      private FatherGUI ft=new FatherGUI();
      private JFrame fLogin=new JFrame("Login");
     private  JPanel panelLogin=new JPanel();
    //here the type of class is responsible for this gui
         inventory.Login log=new inventory.Login();
         

    public void FrameConfigration(JFrame f) {
        f.setSize(450,300);  
        f.setLocationRelativeTo(null); 
        f.setLayout(null);    
        f.setVisible(true);
        f.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE); //To change body of generated methods, choose Tools | Templates.
    }

    public void panelMainConfigration(JPanel jPanel1, JFrame frame1) {
        jPanel1.setSize(450, 300); //To change body of generated methods, choose Tools | Templates.
        jPanel1.setBackground(Color.RED);
        
    }
    
    

    
    
         
     
 
    
    
    public void run()
    { 
        
        int x1=60,x2=160;
        JButton btn1=new JButton("Login");
        JLabel userlbl=new JLabel("Username");
        userlbl.setBounds(x1, 5, 180, 100);
        JLabel passlbl=new JLabel("Password");
        passlbl.setBounds(x1, 40, 180, 100);
        JTextField usertxt=new JTextField();
        usertxt.setBounds(x2, 40, 180, 30);
        JPasswordField passtxt=new JPasswordField();
        passtxt.setBounds(x2, 80, 180, 30);
        JComboBox typeComboBox=new javax.swing.JComboBox();
        typeComboBox.setModel(new DefaultComboBoxModel(new String[]
        { "Admin", "User", "Client"}));
        typeComboBox.setBounds(x2, 120, 100, 20);
        btn1.setBounds(x2, 150, 100, 30);
        
        panelLogin.setSize(450, 300);
        panelLogin.setLayout(null);
        // panel contains
        panelLogin.add(userlbl);
        panelLogin.add(usertxt);
        panelLogin.add(passlbl);
        panelLogin.add(passtxt);
        panelLogin.add(typeComboBox);
        panelLogin.add(btn1);
        //Font
        ft.AllTextFieldFontSize(usertxt);
        ft.AllTextFieldFontSize(passtxt);
        ft.AllLblFontSize(passlbl);
        ft.AllLblFontSize(userlbl);
        //work
        btn1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                 
                 if(!typeComboBox.getSelectedItem().equals("Admin"))
                 {
                     if(log.Checker(usertxt.getText(),passtxt.getText(), (String) typeComboBox.getSelectedItem()))
                    {
                        FatherClass.setType(typeComboBox.getSelectedItem()+"");
                        inventory.Inventory s=new Inventory();
                        FatherClass.setIDlog(String.valueOf(log.getOrder()));
                        System.out.println(log.getOrder());
                        s.HomePage();
                        fLogin.remove(panelLogin);
                        fLogin.dispose();
                    }else
                    {
                        JOptionPane.showMessageDialog(fLogin, "Incorrect Password");
                    }
                 }
                 else
                 {
                     if (log.getAdmin_UserName().equals(usertxt.getText()) && log.getAdmin_Password().equals(passtxt.getText())) {
                         
                         FatherClass.setType("Admin");
                         FatherClass.setIDlog("Admin");
                         inventory.Inventory s=new Inventory();
                         s.HomePage();
                        fLogin.dispose();
                     }else
                     {
                         JOptionPane.showMessageDialog(fLogin, "Incorrect Password");
                     }
                     
                 }
                //System.out.println("\\"+usertxt.getText()+"\\"+passtxt.getText()+"\\"+typeComboBox.getSelectedItem());
                 
            }
        });
        
        
        
        
        
        // fundumental in any GUI
        FrameConfigration(fLogin);
        fLogin.add(panelLogin);
        

        
      
    }
    
 

    
}
