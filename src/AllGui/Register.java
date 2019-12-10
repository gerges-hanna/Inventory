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
public class Register extends Client.ClientClass implements RunMethod{
  public  inventory.Login log1=new inventory.Login();
  FatherGUI f = new FatherGUI();
  
    
  @Override
    public JPanel Run(){
        
        JPanel p = new JPanel();
        int fx=385,fy=160;
        final String m="\u27F3";
        
                //set icon
          
        JLabel label=new JLabel();
        label.setBounds(0, 2, 1200, 700);
        label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AllGui/pharma.jpg"))); // NOI18N
        //.......................................
        
        
        JButton Clear=new JButton(m);
        Clear.setBounds(fx+350,fy+300, 80, 35);
        
        
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
        
        JLabel phone = new JLabel("Contact Number: ");
        JTextField ph = new  JTextField();
        JButton b1 = new JButton("Submit");
        JButton b2 = new JButton("Log in");
        JCheckBox box=new JCheckBox("");
        box.setBounds(fx+405,fy+108,25,14);
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
 
        int check1=0,mainChecker=0;
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
                      mainChecker++;
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
                       mainChecker++;
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
                       mainChecker++;
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
             if(ph.getText().length()>=3&&ph.getText().length()<=15)
             {
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
                 mainChecker++;
                
            }
              else {JOptionPane.showMessageDialog(null, "Enter a valid contact number");}
             }
             else 
             {   
                 JOptionPane.showMessageDialog(null, "Enter a number between 3-15 characters");
             }
              //**************************************************************************************************************************
              
              if(cb.getItemAt(cb.getSelectedIndex()).toString().equals("User")||cb.getItemAt(cb.getSelectedIndex()).toString().equals("Client")){
              log1.setCase(cb.getItemAt(cb.getSelectedIndex()).toString());
              mainChecker++;
              }
              //***************************************************************************************************************************
  
              }
         else if(check1==0)
         {
             JOptionPane.showMessageDialog(null, "You must fill out all the required fields")
                 ;}
              if(mainChecker==5)
                  /*if(!log1.getName().equals("")&&!log1.getUserName().equals("")&&!log1.getPassword().equals("")&&!log1.getCase().equals("")&&log1.getContactNumber()!=0)this block of code was used to verify that new accounts setting functionally right before this one*/
              {
                  mainChecker=0;
                  log1.Add();
                    JOptionPane.showMessageDialog(null, "Account created successfully"); 
              }
              
    }
    catch(      NullPointerException | NumberFormatException m){
   }
             
                 
          }//end btn action
        });
        Clear.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent ae) {
               us.setText("");
               ps.setText("");
               cops.setText("");
               cb.setSelectedItem("..");
               na.setText("");
               ph.setText("");
            }
        });
        b2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                AllGui.Login.fLogin.dispose();
                AllGui.Login.fLogin.remove(p);
                AllGui.Login l=new Login();
                l.Run();
                
            }
        });
        b2.setBounds(fx+250,fy+300, 90, 35);
    
        p.setLayout(null);
        p.add(Clear);
        p.add(na);
        p.add(box);
        p.add(name);
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
        p.add(label);
        p.setSize(1200, 700);
        p.setLayout(null);
        p.setVisible(true);
        
        
        return p;
        
    }
       
        
}
