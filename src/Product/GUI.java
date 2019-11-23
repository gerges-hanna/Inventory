/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Product;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import javax.swing.table.*;


public class GUI
{
    static JTable prosTable = null;
    static ArrayList<Object> pros;
    public static JTable readProducts()
    {
        Files ff = new Files();
        ArrayList<Object> pros2 = ff.read("Products.txt");
        DefaultTableModel tab = new DefaultTableModel();
        tab.addColumn("Name");
        tab.addColumn("Last Name");
        tab.addColumn("Quantity");
        tab.addColumn("Parcode");
        tab.addColumn("Price");
        tab.addColumn("Category");
        tab.addColumn("Expire Date");
        tab.addColumn("ID");
        String [][]data = new String[pros2.size()][8];
        for(int i = 0; i < pros2.size(); i++)
        {
            ArrayList<ProductClass> s = (ArrayList<ProductClass>)(Object)pros2;
            data[i][0] = s.get(i).getName();
            data[i][1] = s.get(i).getLName();
            data[i][2] = Integer.toString(s.get(i).getQuantity());
            data[i][3] = s.get(i).getParcode();
            data[i][4] = Double.toString(s.get(i).getPrice());
            data[i][5] = s.get(i).getCategory();
            data[i][6] = s.get(i).getEXP();
            data[i][7] = s.get(i).getID();
            tab.addRow(data[i]);
        }
        JTable reval = new JTable(tab);
        return reval;
    }
    public static void main(String []args)
    {
        Files ff = new Files();
        pros = ff.read("Products.txt");
        int labelInc = 25;
        JFrame mainF = new JFrame();
        mainF.setLayout(null);
        mainF.setTitle("Products");
        mainF.setBounds(0, 0, 800, 600);
        mainF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // ArrayList for labels and text fields
        ArrayList<JTextField> Tfs = new ArrayList<>();
        ArrayList<JLabel> Lbs = new ArrayList<>();
        // initialize the the Tfs and Lbs
        for(int i = 0; i < 8; i++)
        {
            JTextField tf = new JTextField();
            JLabel lb = new JLabel();
            Lbs.add(lb);
            tf.setBounds(100, 30 + (i * 25), 100, 20);
            Tfs.add(tf);
            mainF.add(tf);
        }
        // Label Section
        ((JLabel)Lbs.get(0)).setText("Name:");
        ((JLabel)Lbs.get(0)).setBounds(10, 25, 100, 20);
        mainF.add(((JLabel)Lbs.get(0)));
        ((JLabel)Lbs.get(1)).setText("Last Name:");
        ((JLabel)Lbs.get(1)).setBounds(10, labelInc * 2, 100, 20);
        mainF.add(((JLabel)Lbs.get(1)));
        ((JLabel)Lbs.get(2)).setText("Quantity:");
        ((JLabel)Lbs.get(2)).setBounds(10, labelInc * 3, 100, 20);
        mainF.add(((JLabel)Lbs.get(2)));
        ((JLabel)Lbs.get(3)).setText("Parcode:");
        ((JLabel)Lbs.get(3)).setBounds(10, labelInc * 4, 100, 20);
        mainF.add(((JLabel)Lbs.get(3)));
        ((JLabel)Lbs.get(4)).setText("Price:");
        ((JLabel)Lbs.get(4)).setBounds(10, labelInc * 5, 100, 20);
        mainF.add(((JLabel)Lbs.get(4)));
        ((JLabel)Lbs.get(5)).setText("Category");
        ((JLabel)Lbs.get(5)).setBounds(10, labelInc * 6, 100, 20);
        mainF.add(((JLabel)Lbs.get(5)));
        ((JLabel)Lbs.get(6)).setText("Expire Date:");
        ((JLabel)Lbs.get(6)).setBounds(10, labelInc * 7, 100, 20);
        mainF.add(((JLabel)Lbs.get(6)));
        ((JLabel)Lbs.get(7)).setText("ID:");
        ((JLabel)Lbs.get(7)).setBounds(10, labelInc * 8, 100, 20);
        mainF.add(((JLabel)Lbs.get(7)));
        
        // Table Section
        prosTable = readProducts();
        prosTable.setBounds(250, 30, 500, 500);
        prosTable.setEnabled(true);
        mainF.add(prosTable);
        JScrollPane prosSP = new JScrollPane(prosTable);
        prosSP.setBounds(250, 30, 500, 500);
        mainF.add(prosSP);

        //Buttons Section
        JButton addBtn = new JButton("Add");
        addBtn.setBounds(20, 250, 70, 25);
        addBtn.addActionListener((ActionEvent e) -> 
        {
            int check = 0;
            for(int i = 0; i < pros.size(); i++)
            {
                if(((ProductClass)pros.get(i)).getID().equals(Tfs.get(7).getText()))
                {
                    JOptionPane.showMessageDialog(null, "Conflict ID");
                    check = -1;
                    break;
                }
            }
            int len = Tfs.get(2).getText().trim().length(), r = 0;
            for(int i = 0; i < len; i++)
            {
                if(Character.isDigit(Tfs.get(2).getText().trim().charAt(i)))
                    r++;
            }
            if(r == len)
                check++;
            len = Tfs.get(4).getText().trim().length();
            r = 0;
            for(int i = 0; i < len; i++)
            {
                try
                {
                    if(Character.isDigit(Tfs.get(4).getText().trim().charAt(i)) ||
                    (Character.isDigit(Tfs.get(4).getText().trim().charAt(Tfs.get(4).getText().trim().indexOf('.') - 1))
                    && Character.isDigit(Tfs.get(4).getText().trim().charAt(Tfs.get(4).getText().trim().indexOf('.') + 1))
                    ))
                        r++;
                }
                catch(StringIndexOutOfBoundsException tt)
                {
                    check = -1;
                }
            }
            if(r == len)
                check++;
            if(check == 2)
            {
                ProductClass newP = new ProductClass();
                newP.setID(Tfs.get(7).getText());
                newP.setName(Tfs.get(0).getText());
                newP.setLName(Tfs.get(1).getText());
                newP.setQuantity(Integer.parseInt(Tfs.get(2).getText().trim()));
                newP.setParcode(Tfs.get(3).getText());
                newP.setPrice(Double.parseDouble(Tfs.get(4).getText().trim()));
                newP.setCategory(Tfs.get(5).getText());
                newP.setEXP(Tfs.get(6).getText());
                newP.Add();
                pros.add(newP);
                JTable tmp = readProducts();
                DefaultTableModel s = (DefaultTableModel)tmp.getModel();
                prosTable.setModel(s);
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
                for(int i = 0; i < 8; i++)
                {
                    Tfs.get(i).setText(tmp.getValueAt(prosTable.getSelectedRow(), i).toString());
                }
            }
        });
        JButton updateBtn = new JButton("Update");
        updateBtn.setBounds(100, 250, 100, 25);
        updateBtn.addActionListener((ActionEvent e) -> 
        {
            ProductClass newP = new ProductClass();
            newP.setID(Tfs.get(7).getText());
            newP.setName(Tfs.get(0).getText());
            newP.setLName(Tfs.get(1).getText());
            newP.setQuantity(Integer.parseInt(Tfs.get(2).getText().trim()));
            newP.setParcode(Tfs.get(3).getText());
            newP.setPrice(Double.parseDouble(Tfs.get(4).getText().trim()));
            newP.setCategory(Tfs.get(5).getText());
            newP.setEXP(Tfs.get(6).getText());
            ff.delete(newP.getID(), "Products.txt");
            newP.Add();
            JTable tmp = readProducts();
            DefaultTableModel g = (DefaultTableModel)tmp.getModel();
            prosTable.setModel(g);
        }  
        );
        mainF.add(addBtn);
        mainF.add(updateBtn);
        mainF.setVisible(true);
    }
}
