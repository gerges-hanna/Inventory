/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AllGui;

import Product.Files;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import javax.swing.table.*;

/**
 *
 * @author bebo
 */
public class Supplier implements RunMethod {

    static JTable prosTable = null;
    static ArrayList<Object> pros;
    public JPanel mainPanel;
    private int biggestID = 0;
    public static JTable readSuppliers()
    {
        Files ff = new Files();
        ArrayList<Object> pros2 = ff.read("Supplier.txt");
        //Supplier Query:ID@Name@LName@SupplierAddress@ContactNumber@SupplierEmail@Category
        DefaultTableModel tab = new DefaultTableModel();
        tab.addColumn("Name");
        tab.addColumn("Last Name");
        tab.addColumn("Supplier Address");
        tab.addColumn("Contact Number");
        tab.addColumn("Supplier Email");
        tab.addColumn("Category");
        tab.addColumn("ID");
        String [][]data = new String[pros2.size()][7];
        for(int i = 0; i < pros2.size(); i++)
        {
            ArrayList<Admin.Suppliers> s = (ArrayList<Admin.Suppliers>)(Object)pros2;
            data[i][0] = s.get(i).getName();
            data[i][1] = s.get(i).getLName();
            data[i][2] = s.get(i).getSupplierAddress();
            data[i][3] = Integer.toString(s.get(i).getContactNumber());
            data[i][4] = s.get(i).getSupplierEmail();
            data[i][5] = s.get(i).getCategory();
            data[i][6] = s.get(i).getID();
            tab.addRow(data[i]);
        }
        JTable reval = new JTable(tab);
        return reval;
    }
    @Override
    public JPanel Run()
    {
        mainPanel = new JPanel();
        
        mainPanel.setLayout(null);
        FatherGUI M=new FatherGUI();
        JButton bckBtn=new JButton("Back");
        M.ButtonBackHome(bckBtn);
        Files ff = new Files();
        pros = ff.read("Supplier.txt");
        for(int i = 0; i < pros.size(); i++)
        {
            if(Integer.parseInt(((Admin.Suppliers)pros.get(i)).getID().trim()) > biggestID)
                biggestID = Integer.parseInt(((Admin.Suppliers)pros.get(i)).getID().trim());
        }
        int labelInc = 40;
        
        // ArrayList for labels and text fields
        ArrayList<JTextField> Tfs = new ArrayList<>();
        ArrayList<JLabel> Lbs = new ArrayList<>();
        // initialize the the Tfs and Lbs
        for(int i = 0; i < 7; i++)
        {
            JTextField tf = new JTextField();
            JLabel lb = new JLabel();
            Lbs.add(lb);
            tf.setBounds(150, labelInc + (i *labelInc), 225, 30);
            Tfs.add(tf);
            mainPanel.add(tf);
        }
        Tfs.get(6).setEditable(false);//Supplier Query:ID@Name@LName@SupplierAddress@ContactNumber@SupplierEmail@Category
        // Label Section
        ((JLabel)Lbs.get(0)).setText("Name:");
        ((JLabel)Lbs.get(0)).setBounds(10, labelInc , 150, 30);
        mainPanel.add(((JLabel)Lbs.get(0)));
        ((JLabel)Lbs.get(1)).setText("Last Name:");
        ((JLabel)Lbs.get(1)).setBounds(10, labelInc * 2, 150, 30);
        mainPanel.add(((JLabel)Lbs.get(1)));
        ((JLabel)Lbs.get(2)).setText("Supplier Address:");
        ((JLabel)Lbs.get(2)).setBounds(10, labelInc * 3, 150, 30);
        mainPanel.add(((JLabel)Lbs.get(2)));
        ((JLabel)Lbs.get(3)).setText("Contact Number:");
        ((JLabel)Lbs.get(3)).setBounds(10, labelInc * 4, 150, 30);
        mainPanel.add(((JLabel)Lbs.get(3)));
        ((JLabel)Lbs.get(4)).setText("Supplier Email:");
        ((JLabel)Lbs.get(4)).setBounds(10, labelInc * 5, 150, 30);
        mainPanel.add(((JLabel)Lbs.get(4)));
        ((JLabel)Lbs.get(5)).setText("Category:");
        ((JLabel)Lbs.get(5)).setBounds(10, labelInc * 6, 150, 30);
        mainPanel.add(((JLabel)Lbs.get(5)));
         ((JLabel)Lbs.get(6)).setText("ID:");
        ((JLabel)Lbs.get(6)).setBounds(10, labelInc * 7, 150, 30);
        mainPanel.add(((JLabel)Lbs.get(6)));
        
        // Table Section
        prosTable = readSuppliers();
        prosTable.setBounds(400, 40, 750, 600);
        prosTable.setEnabled(true);
        mainPanel.add(prosTable);
        JScrollPane prosSP = new JScrollPane(prosTable);
        prosSP.setBounds(400, 40, 750, 600);
        mainPanel.add(prosSP);

        //Buttons Section
        JButton addBtn = new JButton("Add");
        addBtn.setBounds(10, labelInc*8, 120, 30);
        addBtn.addActionListener((ActionEvent e) -> 
        {
            int check = 0;
            int r = 0;
            for(int i = 0; i < 6; i++)
            {
                if(!Tfs.get(i).getText().equals(""))
                {
                    r++;
                }
            }
            if(r == 6)
                check++;
            r = 0;
            for(int i = 0; i < Tfs.get(3).getText().length(); i++)
            {
                if(Character.isDigit(Tfs.get(3).getText().charAt(i)))
                {
                    r++;
                }
            }
            if(r == Tfs.get(3).getText().length())
                check++;
            if(check == 2)
            {//Supplier Query:ID@Name@LName@SupplierAddress@ContactNumber@SupplierEmail@Category
                Product.FatherClass newP = new Admin.Suppliers();
                newP.setID(Integer.toString(biggestID + 1));
                newP.setName(Tfs.get(0).getText());
                newP.setLName(Tfs.get(1).getText());
                newP.setSupplierAddress(Tfs.get(2).getText().trim());
                newP.setContactNumber(Integer.parseInt(Tfs.get(3).getText()));
                newP.setSupplierEmail(Tfs.get(4).getText().trim());
                newP.setCategory(Tfs.get(5).getText());
                newP.Add();
                pros.add(newP);
                JTable tmp = readSuppliers();
                DefaultTableModel s = (DefaultTableModel)tmp.getModel();
                prosTable.setModel(s);
                biggestID++;
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
                for(int i = 0; i < 7; i++)
                {
                    Tfs.get(i).setText(tmp.getValueAt(prosTable.getSelectedRow(), i).toString());
                }
            }
        });
        JButton updateBtn = new JButton("Update");
        updateBtn.setBounds(135, labelInc*8, 120, 30);
        updateBtn.addActionListener((ActionEvent e) -> 
        {
            int r = 0;
            if(Tfs.get(3).getText().equals(""))
                r = -1;
            for(int i = 0; i < Tfs.get(3).getText().length(); i++)
            {
                if(Character.isDigit(Tfs.get(3).getText().charAt(i)))
                {
                    r++;
                }
            }
            if(r == Tfs.get(3).getText().length())
            {
                String newLine = Tfs.get(6).getText() + "@"
                        + Tfs.get(0).getText() + "@" +
                        Tfs.get(1).getText() + "@" +
                        Tfs.get(2).getText().trim() + "@" +
                        Tfs.get(3).getText() + "@" + 
                        Tfs.get(4).getText() + "@" +
                        Tfs.get(5).getText();
                ff.update(Tfs.get(6).getText(), "Supplier.txt", newLine);
                JTable tmp = readSuppliers();
                DefaultTableModel g = (DefaultTableModel)tmp.getModel();
                prosTable.setModel(g);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Invalid input");
            }
        });
        JButton delBtn = new JButton("Delete");
        delBtn.setBounds(260, labelInc*8, 120, 30);
        delBtn.addActionListener((ActionEvent e)->
        {
            if(!Tfs.get(6).getText().equals(""))
            {
                ff.delete(Tfs.get(6).getText(), "Supplier.txt");
                JTable tmp = readSuppliers();
                pros = ff.read("Supplier.txt");
                DefaultTableModel g = (DefaultTableModel)tmp.getModel();
                prosTable.setModel(g);
                for(int i = 0; i < 7; i++)
                {
                    Tfs.get(i).setText("");
                }
                for(int i = 0; i < pros.size(); i++)
                {
                    if(Integer.parseInt(((Admin.Suppliers)pros.get(i)).getID().trim()) > biggestID)
                        biggestID = Integer.parseInt(((Admin.Suppliers)pros.get(i)).getID().trim());
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
        return mainPanel;
    }
    //
}
