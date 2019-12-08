/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AllGui;

import java.awt.Color;
import javax.swing.JPanel;

/**
 *
 * @author Gerges hanna FCI-H
 */
public class ContactUs implements RunMethod{
    
    @Override
    public JPanel Run() {
        JPanel panel=new JPanel();
        panel.setBackground(Color.yellow);
        panel.setLayout(null);
        panel.setSize(1200, 700);
        return panel;
    }
    
}
