/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AllGui;

import inventory.Inventory;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Gerges hanna FCI-H
 */
public class FatherGUI {
    
    public int x1,x2,x3,x4,x5,x6,x7,x8,x9,x10;
    public int y1,y2,y3,y4,y5,y6,y7,y8,y9,y10;
    
    /********************************************/
    //GUI Functions
    
    //this must put end thing in the run method
         /* like
         FrameConfigration(frame);
         panelMainConfigration(panel,frame);
         frame.add(panel);
         
         */
    public void FrameConfigration(JFrame f)
    {
//        f.setSize(1200,700);  
//        f.setLocationRelativeTo(null); 
//        f.setLayout(null);    
//        f.setVisible(true);
//        f.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
//        f.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        f.setSize(1200,730);  
        f.setLocationRelativeTo(null); 
        f.setLayout(null);
        f.setVisible(true);
        f.setResizable(false);
        f.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    }
    
    public void AllTextFieldFontSize(JTextField txt)
    {
        txt.setFont(new Font("Tahoma", 0, 24));
    }
    public void AllLblFontSize(JLabel lbl)
    {
        lbl.setFont(new Font("Tahoma", 0, 20));
    }
    public void ButtonBackHome(JButton btn)
    {
         btn.setBounds(7, 7, 90, 30);
        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
            inventory.Inventory in=new Inventory();
             in.runPanel();
            }
        });
    }
    
    /********************************************/
}
