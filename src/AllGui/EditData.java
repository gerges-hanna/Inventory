package AllGui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.Border;
public class EditData {
    
    
    public JPanel run(){
        
        FatherGUI f=new FatherGUI();
        
        //Panel
        
        JPanel panelEditData = new JPanel();
        
        //Buttons
        
        JButton BackEditData = new JButton("Back");
        JButton Update = new JButton("Update Data");
        f.ButtonBackHome(BackEditData);
        
        //Labels
        
        JLabel lbOldName = new JLabel("Old Name:");
        JLabel lbNewName = new JLabel("New Name:");
        JLabel lbOldPw = new JLabel("Old Password:");
        JLabel lbNewPw = new JLabel("New Password:");
        JLabel lbOldPhone = new JLabel("Old Phone Number:");
        JLabel lbNewPhone = new JLabel("New Phone Number:");
        
        
        //TextFields
        
        JTextField tfOldName = new JTextField();
        JTextField tfNewName = new JTextField();
        JTextField tfOldPhone = new JTextField();
        JTextField tfNewPhone = new JTextField();
        
        //PasswordField
        
        JPasswordField pfOldPw = new JPasswordField();
        JPasswordField pfNewPw = new JPasswordField();
        
        
        //SetBounds
        
        lbOldName.setBounds(420, 120, 250, 50);
        lbNewName.setBounds(410, 175, 250, 50);
        lbOldPw.setBounds(385, 225, 250, 50);
        lbNewPw.setBounds(376, 275, 250, 50);
        lbOldPhone.setBounds(330, 325, 250, 50);
        lbNewPhone.setBounds(320, 375, 250, 50);
        
        Update.setBounds(490, 520, 180, 70);
        
        tfOldName.setBounds(560,133,320,30);
        tfNewName.setBounds(560, 183, 320, 30);
        pfOldPw.setBounds(560, 233, 320, 30);
        pfNewPw.setBounds(560, 283, 320, 30);
        tfOldPhone.setBounds(560, 333, 320, 30);
        tfNewPhone.setBounds(560, 383, 320, 30);
        
        
        
        
        //Fonts
        lbOldName.setFont(new Font("Tahoma",0,23));
        lbNewName.setFont(new Font("Tahoma",0,23));
        lbOldPw.setFont(new Font("Tahoma",0,23));
        lbNewPw.setFont(new Font("Tahoma",0,23));
        lbOldPhone.setFont(new Font("Tahoma",0,23));
        lbNewPhone.setFont(new Font("Tahoma",0,23));
        BackEditData.setFont(new Font("Tahoma",0,20));
        Update.setFont(new Font("Tahoma",0,20));
        
        
        
        //ADD
        
        panelEditData.add(lbOldName);
        panelEditData.add(lbNewName);
        panelEditData.add(lbOldPhone);
        panelEditData.add(lbNewPhone);
        panelEditData.add(lbOldPw);
        panelEditData.add(lbNewPw);
        panelEditData.add(BackEditData);
        panelEditData.add(Update);
        panelEditData.add(tfOldName);
        panelEditData.add(tfNewName);
        panelEditData.add(tfOldPhone);
        panelEditData.add(tfNewPhone);
        panelEditData.add(pfOldPw);
        panelEditData.add(pfNewPw);
        
        
        
        
        
        
        panelEditData.setSize(1200, 700);
        panelEditData.setBackground(Color.yellow);
        panelEditData.setLayout(null);
        
        return panelEditData;
        
    }
    
}
