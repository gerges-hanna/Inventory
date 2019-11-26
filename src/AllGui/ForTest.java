/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AllGui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Gerges hanna FCI-H
 */
public class ForTest extends FatherGUI{
    //initialize Gui 
         
       
       public boolean flag=false;
         
     public JPanel panel =new JPanel();
 
    
    
       public void runt()
    { 
        
        int x1=60,x2=140;
        JButton btn1=new JButton("Login");
        JLabel userlbl=new JLabel("UserName");
        userlbl.setBounds(x1, 5, 180, 100);
        JLabel passlbl=new JLabel("PassWord");
        passlbl.setBounds(x1, 40, 180, 100);
        JTextField usertxt=new JTextField();
        usertxt.setBounds(x2, 40, 180, 30);
        JTextField passtxt=new JTextField();
        passtxt.setBounds(x2, 80, 180, 30);
        JComboBox typeComboBox=new javax.swing.JComboBox();
        typeComboBox.setModel(new DefaultComboBoxModel(new String[]
        { "Admin", "User", "Client"}));
        typeComboBox.setBounds(x2, 120, 100, 20);
        btn1.setBounds(x2, 150, 100, 30);
        
        // panel contains
        panel.add(userlbl);
        panel.add(usertxt);
        panel.add(passlbl);
        panel.add(passtxt);
        panel.add(typeComboBox);
        panel.add(btn1);
        panel.setBackground(Color.yellow);
        
        //work
        btn1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                
            }
        });
        
        
        
        
        
        // fundumental in any GUI
        FrameConfigration(frame);
        super.panelMainConfigration(panel,frame);
        frame.add(panel);

    }
}
