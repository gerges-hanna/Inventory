/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AllGui;

import java.awt.Font;
import javax.swing.GroupLayout;
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
        f.setSize(1200,700);  
        f.setLocationRelativeTo(null); 
        f.setLayout(null);
        f.setVisible(true);
        f.setResizable(false);
        f.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    }
    
    //panel Configration 
//    public void panelMainConfigration(JPanel jPanel1,JFrame frame1)
//    {
//        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
//        jPanel1.setLayout(jPanel1Layout);
//        jPanel1Layout.setHorizontalGroup(
//            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
//            .addGap(0, 400, Short.MAX_VALUE)
//        );
//        jPanel1Layout.setVerticalGroup(
//            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
//            .addGap(0, 300, Short.MAX_VALUE)
//        );
//
//        GroupLayout layout = new GroupLayout(frame1.getContentPane());
//        frame1.getContentPane().setLayout(layout);
//        layout.setHorizontalGroup(
//            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
//            .addComponent(jPanel1, GroupLayout.Alignment.TRAILING
//                    ,GroupLayout.DEFAULT_SIZE
//                    ,GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//        );
//        layout.setVerticalGroup(
//            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
//            .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE,
//                    GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//        );
//
//        
//    }
    
    public void AllTextFieldFontSize(JTextField txt)
    {
        txt.setFont(new Font("Tahoma", 0, 24));
    }
    public void AllLblFontSize(JLabel lbl)
    {
        lbl.setFont(new Font("Tahoma", 0, 20));
    }
    
    
    /********************************************/
}
