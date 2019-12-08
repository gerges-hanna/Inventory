/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AllGui;

import Product.Files;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gerges hanna FCI-H
 */
public class CategoreyGUI implements RunMethod{
    
 static JTable prosTable = null;
    static ArrayList<Object> pros;
    public JPanel mainPanel;
    public static JTable readProducts()
    {
        Files ff = new Files();
        ArrayList<Object> pros2 = ff.read("Category.txt");
        //Supplier Query:Category@CategoryDescription
        DefaultTableModel tab = new DefaultTableModel();
        tab.addColumn("Category");
        tab.addColumn("Description");
        
        String [][]data = new String[pros2.size()][2];
        for(int i = 0; i < pros2.size(); i++)
        {
            ArrayList<Admin.Categories> s = (ArrayList<Admin.Categories>)(Object)pros2;

            data[i][0] = s.get(i).getCategory();
            data[i][1] = s.get(i).getCategoryDescription();
            tab.addRow(data[i]);
        }
        JTable reval = new JTable(tab);
        return reval;
    }
    @Override
    public JPanel Run()
    {
        FatherGUI M=new FatherGUI();
        JButton bckBtn=new JButton("Back");
        M.ButtonBackHome(bckBtn);
        mainPanel = new JPanel();
        mainPanel.setLayout(null);
        Files ff = new Files();
        pros = ff.read("Category.txt");
        
        int labelInc = 40;
      
        // ArrayList for labels and text fields
        ArrayList<JTextField> Tfs = new ArrayList<>();
        ArrayList<JLabel> Lbs = new ArrayList<>();
        // initialize the the Tfs and Lbs
        for(int i = 0; i < 2; i++)
        {
            JTextField tf = new JTextField();
            JLabel lb = new JLabel();
            Lbs.add(lb);
            tf.setBounds(150, labelInc + (i *labelInc), 225, 30);
            Tfs.add(tf);
            mainPanel.add(tf);
        }
        //Categories Query:Category@CategoryDescription
        // Label Section
        ((JLabel)Lbs.get(0)).setText("Category:");
        ((JLabel)Lbs.get(0)).setBounds(10, labelInc , 150, 30);
        mainPanel.add(((JLabel)Lbs.get(0)));
         ((JLabel)Lbs.get(1)).setText("Category Description:");
        ((JLabel)Lbs.get(1)).setBounds(10, labelInc * 2, 150, 30);
        mainPanel.add(((JLabel)Lbs.get(1)));
        
        // Table Section
        prosTable = readProducts();
        prosTable.setBounds(400, 40, 750, 600);
        prosTable.setEnabled(true);
        mainPanel.add(prosTable);
        JScrollPane prosSP = new JScrollPane(prosTable);
        prosSP.setBounds(400, 40, 750, 600);
        mainPanel.add(prosSP);

        //Buttons Section
        JButton addBtn = new JButton("Add");
        addBtn.setBounds(10, labelInc*3, 120, 30);
        addBtn.addActionListener((ActionEvent e) -> 
        {
            int check = 0;
            int r = 0;
            for(int i = 0; i < 2; i++)
            {
                if(!Tfs.get(i).getText().equals(""))
                {
                    r++;
                }
            }
            if(r == 2)
                check++;
            
            if(check == 1)
            {
                boolean append = true;
                for(int i = 0; i < pros.size(); i++)
                {
                    if(Tfs.get(0).getText().equals( ((Admin.Categories)pros.get(i)).getCategory()))
                    {
                        append = false;
                        break;
                    }
                }
                if(append)
                {
                    //Supplier Query:ID@Name@LName@SupplierAddress@ContactNumber@SupplierEmail@Category
                    Product.FatherClass newP = new Admin.Categories();
                    newP.setCategory(Tfs.get(0).getText());
                    newP.setCategoryDescription(Tfs.get(1).getText());
                    newP.Add();
                    pros.add(newP);
                    JTable tmp = readProducts();
                    DefaultTableModel s = (DefaultTableModel)tmp.getModel();
                    prosTable.setModel(s);
                }
                else
                    JOptionPane.showMessageDialog(null, "Category already exists");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Invalid input");
            }
        }
        );
        prosTable.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                DefaultTableModel tmp = (DefaultTableModel)prosTable.getModel();
                for(int i = 0; i < 2; i++)
                {
                    Tfs.get(i).setText(tmp.getValueAt(prosTable.getSelectedRow(), i).toString());
                }
            }
        });
        JButton updateBtn = new JButton("Update");
        updateBtn.setBounds(135, labelInc*3, 120, 30);
        updateBtn.addActionListener((ActionEvent e) -> 
        {
            Product.FatherClass newP = new Admin.Categories();
            newP.setCategory(Tfs.get(0).getText());
            newP.setCategoryDescription(Tfs.get(1).getText());
            ff.delete(newP.getCategory(), "Category.txt");
            newP.Add();
            JTable tmp = readProducts();
            DefaultTableModel g = (DefaultTableModel)tmp.getModel();
            prosTable.setModel(g);
        });
        JButton delBtn = new JButton("Delete");
        delBtn.setBounds(260, labelInc*3, 120, 30);
        delBtn.addActionListener((ActionEvent e)->
        {
            if(!Tfs.get(1).getText().equals(""))
            {
                ff.delete(Tfs.get(0).getText(), "Category.txt");
                JTable tmp = readProducts();
                pros = ff.read("Category.txt");
                DefaultTableModel g = (DefaultTableModel)tmp.getModel();
                prosTable.setModel(g);
                for(int i = 0; i < 2; i++)
                {
                    Tfs.get(i).setText("");
                }
      
            }
        });
        prosTable.setDefaultEditor(Object.class, null);
        mainPanel.add(addBtn);
        mainPanel.add(updateBtn);
        mainPanel.add(delBtn);
        mainPanel.add(bckBtn);
        mainPanel.setVisible(true);
        mainPanel.setSize(1200,700);
        //mainFrame.add(mainPanel);
        return mainPanel;
   } 
}
