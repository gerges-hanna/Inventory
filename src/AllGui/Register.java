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
    
    public JPanel Run(){
        
        JPanel p = new JPanel();
        
        JButton btn = new JButton("Back");
        
        JLabel user = new JLabel("UserName : ");
        JTextField us = new  JTextField();
        
        JLabel pass = new JLabel("Password : ");
        JPasswordField ps = new  JPasswordField();
        
        JLabel conpass = new JLabel("Confirm Pass : ");
        JPasswordField cops = new  JPasswordField();
        
        String case1[]={"....","User","Client"};    
        
        JComboBox cb=new JComboBox(case1);
        
        
        JLabel name = new JLabel("Name : ");
        JTextField na = new  JTextField();
        
        JLabel phone = new JLabel("PhoneNumber : ");
        JTextField ph = new  JTextField();
        
        JButton b = new JButton("..Submit..");
        JButton b2 = new JButton("Clear");
        
        p.setBackground(Color.RED);
        
        //BOUNDS 
        
        btn.setBounds(0,0, 80, 25);
        
        name.setBounds(418, 45, 200, 75);
        na.setBounds(500, 70, 280, 30);
        name.setFont(new Font("Tahoma", 0, 24));
        
        
        user.setBounds(370, 85, 200,75);
        us.setBounds(500, 110,280,30);
        user.setFont(new Font("Tahoma", 0, 24));
        
        pass.setBounds(380,130 ,200,75);
        ps.setBounds(500, 155, 280, 30);
        pass.setFont(new Font("Tahoma", 5, 24));
        
        conpass.setBounds(345, 175, 200, 75);
        cops.setBounds(500, 198, 280, 30);
        conpass.setFont(new Font("Tahoma", 5, 24));
       
        
        phone.setBounds(334, 210, 200, 75);
        ph.setBounds(500, 235, 280, 30);
        phone.setFont(new Font("Tahoma", 5, 24));
        
        cb.setBounds(500, 280 , 250, 30);
        
        b.setBounds(500, 320, 90, 35);
        b.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
              log1.setPassword("");
              log1.setUserName("");
              log1.setCase("");
              log1.Add();
            }
        });
        b2.setBounds(600,320, 90, 35);
    
        p.setLayout(null);
        p.add(na);
        p.add(name);
        p.add(btn);
        p.add(user);
        p.add(us);
        p.add(pass);
        p.add(ps);
        p.add(conpass);
        p.add(cops);
        p.add(cb);
        p.add(phone);
        p.add(ph);
        p.add(b);
        p.add(b2);
        p.setSize(1200, 700);
        p.setLayout(null);
        p.setVisible(true);
        
        
        return p;
        
    }
       
        
}
