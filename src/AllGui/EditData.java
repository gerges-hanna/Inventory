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
        
        //Labels
        
        JLabel lbOldName = new JLabel("Old Username:");
        JLabel lbNewName = new JLabel("New Username:");
        JLabel lbOldPw = new JLabel("Old Password:");
        JLabel lbNewPw = new JLabel("New Password:");
        
        
        panelEditData.setSize(1200, 700);
        panelEditData.setBackground(Color.yellow);
        panelEditData.setLayout(null);
        
        return panelEditData;
        
    }
    
}
