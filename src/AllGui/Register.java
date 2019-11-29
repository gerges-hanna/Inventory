/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AllGui;

import javax.swing.*;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.*;

/**
 *
 * @author Paula Samir
 */
public class Register extends Client.ClientClass{
  public  inventory.Login log1=new inventory.Login();
  FatherGUI f = new FatherGUI();
    
    public JPanel Run(){
        
        JPanel p = new JPanel();
        int fx=350,fy=100,fxt=500,wid=200,hgt=30;
        JButton btn = new JButton("Back");
        f.ButtonBackHome(btn);
        
        JLabel user = new JLabel("Username: ");
        JTextField us = new  JTextField();
        
        JLabel pass = new JLabel("Password: ");
        JPasswordField ps = new  JPasswordField();
        
        JLabel conpass = new JLabel("Confirm Password: ");
        JPasswordField cops = new  JPasswordField();
        
        String case1[]={"..","User","Client"};    
        
        JComboBox cb=new JComboBox(case1);
        JLabel type=new JLabel("Case:");
        
        
        JLabel name = new JLabel("Name: ");
        JTextField na = new  JTextField();
        
        JLabel phone = new JLabel("Phone Number: ");
        JTextField ph = new  JTextField();
        JButton b1 = new JButton("Submit");
        JButton b2 = new JButton("Log in");
        JCheckBox box=new JCheckBox("");
        box.setBounds(fx+403,fy+95,100,40);
        box.addActionListener(new ActionListener() {
                public void actionPerformed (ActionEvent e){
                
                if(box.isSelected())
                { 
                    ps.setEchoChar((char)0);
                    cops.setEchoChar((char)0);
                }
                else 
                {
                ps.setEchoChar('*');
                cops.setEchoChar('*');
                }
                
                }
                });
        p.setBackground(Color.LIGHT_GRAY);
        
        //BOUNDS 
        
        
        name.setBounds(fx, fy-1, 300, 30);
        na.setBounds(fx+150, fy, 280,30 );
        name.setFont(new Font("Tahoma", 0, 17));
        
        user.setBounds(fx, fy+49, 300,30);
        us.setBounds(fx+150, fy+50,280,30);
        user.setFont(new Font("Tahoma", 0, 17));
        
        pass.setBounds(fx,fy+99 ,300,30);
        ps.setBounds(fx+150, fy+100, 280, 30);
        pass.setFont(new Font("Tahoma", 0, 17));
        
        conpass.setBounds(fx, fy+149, 300, 30);
        cops.setBounds(fx+150, fy+150, 280, 30);
        conpass.setFont(new Font("Tahoma", 0, 17));
       
        
        phone.setBounds(fx, fy+199, 300, 30);
        ph.setBounds(fx+150, fy+200, 280, 30);
        phone.setFont(new Font("Tahoma", 0, 17));
        
        
        type.setBounds(fx,fy+249,300,30);
        type.setFont(new Font("Tahoma", 0, 17));
        cb.setBounds(fx+150, fy+250 ,150, 30);
        
        b1.setBounds(fx+150, fy+300, 90, 35);
        b1.addActionListener(new ActionListener() {

         public boolean usernameChecker(){
        ReadData();
        for(int i=0;i<LoginList.size();i++)
         {
         if(LoginList.get(i).getUserName().equals(us.getText()))
         {
             JOptionPane.showMessageDialog(null, "Username already exists!");
             return true; 
         }
         }
        return false;
       
     }
           
            @Override
            public void actionPerformed(ActionEvent e) {
      
    try
    {
 
        int check1=0;
         if(!us.getText().equals("")&&!ps.getText().equals("")&&!na.getText().equals("")&&!cops.getText().equals("")&&!cb.getItemAt(cb.getSelectedIndex()).toString().equals("..")&&!ph.getText().equals(""))
              {
              check1++;
    
  
           //***************************************************************************************************************************
     //Name checking conditions**********************
            if(na.getText().equals("")||( na.getText().length()>=3 && na.getText().length()<=20))
            {
   
             int check=0;
            for(int i=0;i<na.getText().length();i++)
            {
                    if( na.getText().charAt(i)!='@' && 
                        na.getText().charAt(i)!=';' && 
                        na.getText().charAt(i)!='-' && 
                        na.getText().charAt(i)!='+' && 
                        na.getText().charAt(i)!='=' &&
                        na.getText().charAt(i)!='~' &&
                        na.getText().charAt(i)!='$')
                       {
                       check++;
                       if(na.getText().length()==check)
                       {
                      log1.setName(na.getText());  
                       }
                       }  
                    else {
                    JOptionPane.showMessageDialog(null, "Name cant include any (@ ; - + = ~ $)");
                    break;
                    }
            }
         
           }
         else{JOptionPane.showMessageDialog(null, "Enter a name between 3-20 characters");}
               //Name checking conditions**********************
               //***************************************************************************************************************************
     //***************************************************************************************************************************
     //Username checking conditions**********************
   
        
            if(us.getText().equals("")||( us.getText().length()>=4 && us.getText().length()<=12))
            {
                int check=0;
            for(int i=0;i<us.getText().length();i++)
            {
                    if(
                        us.getText().charAt(i)!=';' && 
                        us.getText().charAt(i)!='-' && 
                        us.getText().charAt(i)!='+' && 
                        us.getText().charAt(i)!='=' &&
                        us.getText().charAt(i)!='~' &&
                        us.getText().charAt(i)!='$'
                       )
                       {
                       check++;
                       if(us.getText().length()==check&&!usernameChecker())
                       {
                      log1.setUserName(us.getText());  
                       }
                       }  
                    else {
                    JOptionPane.showMessageDialog(null, "Username cant include any ( ; - + = ~ $)");
                    break;
                    }
            }
         
           }
         else{JOptionPane.showMessageDialog(null, "Enter username between 4-12 characters");}
              
               //Username checking conditions**********************
               //***************************************************************************************************************************
                //Password checking conditions**********************
            if(ps.getText().equals("")||( ps.getText().length()>=4 && ps.getText().length()<=8&&ps.getText().equals(cops.getText())))
            {
             int check=0;
            for(int i=0;i<ps.getText().length();i++)
            {
                    if( ps.getText().charAt(i)!='@' && 
                        ps.getText().charAt(i)!=';' && 
                        ps.getText().charAt(i)!='-' && 
                        ps.getText().charAt(i)!='+' && 
                        ps.getText().charAt(i)!='=' &&
                        ps.getText().charAt(i)!='~' &&
                        ps.getText().charAt(i)!='$')
                       {
                       check++;
                       if(ps.getText().length()==check)
                       {
                      log1.setPassword(ps.getText());  
                       }
                       }  
                    else {
                    JOptionPane.showMessageDialog(null, "Password cant include any (@ ; - + = ~ $)");
                    break;
                    }
            }
         
           }
         else{JOptionPane.showMessageDialog(null, "Enter password between 4-8 characters\nPassword must match with Confirm Password");}
               //Password checking conditions**********************
         //*******************************************************************************************************
               //Phone Number checking condition*************************
              int r = 0;
              
            for(int i = 0; i < ph.getText().length(); i++)
            {
                if(Character.isDigit(ph.getText().charAt(i)))
                {
                    r++;
                }
            }
            if(r == ph.getText().length())
            {
                
                log1.setContactNumber(Integer.parseInt(ph.getText()));
                
            }
              else {JOptionPane.showMessageDialog(null, "Enter valid phone number");}
              
              //**************************************************************************************************************************
              log1.setCase(cb.getItemAt(cb.getSelectedIndex()).toString());
              //***************************************************************************************************************************
  
              }
         else if(check1==0)
         {
             JOptionPane.showMessageDialog(null, "You must fill all inputs")
                 ;}
              if(!log1.getUserName().equals("")&&!log1.getPassword().equals("")&&!log1.getCase().equals("")&&log1.getContactNumber()!=0)
              {
                  log1.Add();
                    JOptionPane.showMessageDialog(null, "Account created successfully"); 
              }
              
    }
    catch(      NullPointerException | NumberFormatException m){
   }
             
                 
          }//end btn action
        });
        b2.setBounds(fx+250,fy+300, 90, 35);
    
        p.setLayout(null);
        p.add(na);
        p.add(box);
        p.add(name);
        p.add(btn);
        p.add(user);
        p.add(us);
        p.add(pass);
        p.add(ps);
        p.add(conpass);
        p.add(cops);
        p.add(cb);
        p.add(type);
        p.add(phone);
        p.add(ph);
        p.add(b1);
        p.add(b2);
        p.setSize(1200, 700);
        p.setLayout(null);
        p.setVisible(true);
        
        
        return p;
        
    }
       
        
}
