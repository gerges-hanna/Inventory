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
public class Login implements RunMethod {
    //initialize Gui 
      private FatherGUI ft=new FatherGUI();
      public static JFrame fLogin=new JFrame("Login");
     private  JPanel panelLogin=new JPanel();
    //here the type of class is responsible for this gui
         inventory.Login log=new inventory.Login();
         
    public void closeJframe()
    {
        fLogin.dispose();
    }
    public void FrameConfigration(JFrame f) {
        f.setSize(700,338);  
        f.setLocationRelativeTo(null); 
        f.setLayout(null);    
        f.setVisible(true);
        f.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE); //To change body of generated methods, choose Tools | Templates.
    }

   /* public void panelMainConfigration(JPanel jPanel1, JFrame frame1) {
        jPanel1.setSize(700, 338); //To change body of generated methods, choose Tools | Templates.
        jPanel1.setBackground(Color.RED);
        
    }*/
    
    

         
     
 
    
    
      @Override
    public JPanel Run()
    { 
        
        //set icon
    
    JLabel label=new JLabel();
    label.setBounds(0,0,500 ,338);
            label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AllGui/flat-pharmacist-attending-customers-background_23-2148168554.jpg"))); // NOI18N
//**************
        int x1=360,x2=460;
        JButton btn1=new JButton("Login");
        JButton btn2=new JButton("Register");
        JLabel userlbl=new JLabel("Username");
        userlbl.setBounds(x1, 5, 180, 100);
        JLabel passlbl=new JLabel("Password");
        passlbl.setBounds(x1, 55, 180, 100);
        JTextField usertxt=new JTextField();
        usertxt.setBounds(x2, 40, 180, 30);
        JPasswordField passtxt=new JPasswordField();
        passtxt.setBounds(x2, 90, 180, 30);
        JComboBox typeComboBox=new javax.swing.JComboBox();
        typeComboBox.setModel(new DefaultComboBoxModel(new String[]
        { "Admin", "User", "Client"}));
        typeComboBox.setBounds(x2, 140, 100, 25);
        btn1.setBounds(x2-1, 250, 100, 30);
     
        btn2.setBounds(x2+99, 250, 100, 30);
        
        panelLogin.setSize(700, 338);
        panelLogin.setBackground(Color.getHSBColor(220, 222, 227));
        panelLogin.setLayout(null);
        btn2.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent ae) {
         panelLogin.setVisible(false);
         Register r=new Register();
         fLogin.setSize(1200, 700);
         fLogin.setLocationRelativeTo(null);
         fLogin.add(r.Run());
         
        }
    });
        // panel contains
       
        panelLogin.add(userlbl);
        panelLogin.add(usertxt);
        panelLogin.add(passlbl);
        panelLogin.add(passtxt);
        panelLogin.add(typeComboBox);
        panelLogin.add(btn1);
        panelLogin.add(btn2);

        panelLogin.add(label);
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
                        JOptionPane.showMessageDialog(fLogin, "Inavlid username,password or case");
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
                         JOptionPane.showMessageDialog(fLogin, "Inavlid username,password or case");
                     }
                     
                 }
                //System.out.println("\\"+usertxt.getText()+"\\"+passtxt.getText()+"\\"+typeComboBox.getSelectedItem());
                 
            }
        });
        
        
        
        
        
        // fundumental in any GUI
        FrameConfigration(fLogin);
        fLogin.add(panelLogin);
        

        
      return panelLogin;
    }

    
    
 

    
}
