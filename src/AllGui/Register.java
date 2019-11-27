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
import java.awt.event.*;

/**
 *
 * @author Paula Samir
 */
public class Register extends Client.ClientClass{
    public JPanel Run(){
        
        JPanel p = new JPanel();
        
        JPanel register = new JPanel();
        
        JLabel user = new JLabel("UserName");
        JTextField us = new  JTextField();
        
        JLabel pass = new JLabel("Password");
        JTextField ps = new  JTextField();
        
        JLabel conpass = new JLabel("Confirm Password");
        JTextField cops = new  JTextField();
        
        String case1[]={"....","User","Client"};    
        
        JComboBox cb=new JComboBox(case1);
        
        
        JLabel name = new JLabel("Name");
        JTextField na = new  JTextField();
        
        JLabel phone = new JLabel("PhoneNumber");
        JTextField ph = new  JTextField();
        
        JButton b = new JButton("Submit");
        
        register.setBackground(Color.magenta);
    
    
        return register;
        
    }
       
        
}
