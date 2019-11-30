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
        JButton Clear = new JButton("Clear");
        f.ButtonBackHome(BackEditData);
        
        //Labels
        
        JLabel lbOldName = new JLabel("Old Name:");
        JLabel lbNewName = new JLabel("New Name:");
        JLabel lbOldPw = new JLabel("Old Password:");
        JLabel lbNewPw = new JLabel("New Password:");
        JLabel lbConfirmNewPw = new JLabel("Confirm New Password:");
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
        JPasswordField pfConfirmNewPw = new JPasswordField();
        
        
        //SetBounds
        
        lbOldName.setBounds(200, 100, 250, 50);
        lbNewName.setBounds(660, 100, 250, 50);
        lbOldPhone.setBounds(200, 200, 250, 50);
        lbNewPhone.setBounds(660, 200, 250, 50);
        lbOldPw.setBounds(200, 300, 250, 50);
        lbNewPw.setBounds(660, 300, 250, 50);
        lbConfirmNewPw.setBounds(660,400,250,50);
        
        
        Update.setBounds(640, 520, 150, 50);
        Clear.setBounds(380,520,150,50);
        
        tfOldName.setBounds(200,143,320,30);
        tfNewName.setBounds(660, 143, 320, 30);
        tfOldPhone.setBounds(200, 243, 320, 30);
        tfNewPhone.setBounds(660, 243, 320, 30);
        pfOldPw.setBounds(200, 343, 320, 30);
        pfNewPw.setBounds(660, 343, 320, 30);
        pfConfirmNewPw.setBounds(660,443,320,30);
       
        
        
        
        
        //Fonts
        lbOldName.setFont(new Font("Tahoma",0,23));
        lbNewName.setFont(new Font("Tahoma",0,23));
        lbOldPw.setFont(new Font("Tahoma",0,23));
        lbNewPw.setFont(new Font("Tahoma",0,23));
        lbOldPhone.setFont(new Font("Tahoma",0,23));
        lbNewPhone.setFont(new Font("Tahoma",0,23));
        BackEditData.setFont(new Font("Tahoma",0,20));
        Update.setFont(new Font("Tahoma",0,20));
        lbConfirmNewPw.setFont(new Font("Tahoma",0,23));
        Clear.setFont(new Font("Tahoma",0,23));
        
        
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
        panelEditData.add(lbConfirmNewPw);
        panelEditData.add(pfConfirmNewPw);
        panelEditData.add(Clear);
        
        
        
        
        
        
        panelEditData.setSize(1200, 700);
        panelEditData.setBackground(Color.yellow);
        panelEditData.setLayout(null);
        
        return panelEditData;
        
    }
    
}
