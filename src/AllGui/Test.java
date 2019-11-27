/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AllGui;

import javax.swing.*;

public class Test {
    JPanel p=new JPanel();
    public JPanel run()
    {
        String [][]data = {
            
            {"Gerges", "Gerges", "Bebo"},
            {"John", "Poula", "Abanoun"},
            {"Gerges", "Gerges", "Bebo"},
            {"John", "Poula", "Abanoun"},
            {"Gerges", "Gerges", "Bebo"},
            {"John", "Poula", "Abanoun"},
            {"Gerges", "Gerges", "Bebo"},
            {"John", "Poula", "Abanoun"},
            {"Gerges", "Gerges", "Bebo"},
            {"John", "Poula", "Abanoun"},
            {"Gerges", "Gerges", "Bebo"},
            {"John", "Poula", "Abanoun"},
            {"Gerges", "Gerges", "Bebo"},
            {"John", "Poula", "Abanoun"},
            {"Gerges", "Gerges", "Bebo"},
            {"John", "Poula", "Abanoun"},
            {"Gerges", "Gerges", "Bebo"},
            {"John", "Poula", "Abanoun"},
            {"Gerges", "Gerges", "Bebo"},
            {"John", "Poula", "Abanoun"}
           
        };
        p.setLayout(null);
        String []cols = { "NAME", "Fuck", "5ara"};
        JTable t=new JTable(data, cols);
        JScrollPane s = new JScrollPane(t);
        t.setBounds(10, 10, 100, 100);
        s.setBounds(10, 10, 10, 100);
        p.add(s);
        p.add(t);
        
                
        return p;
    }
}
