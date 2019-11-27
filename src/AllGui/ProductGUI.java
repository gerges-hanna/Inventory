/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AllGui;
import Product.*;
import java.awt.PopupMenu;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import javax.swing.table.*;


public class ProductGUI
{
    static JTable prosTable = null;
    static ArrayList<Object> pros;
    public JPanel mainPanel;
    private int biggestID = 0;
    public static JTable readProducts()
    {
        Files ff = new Files();
        ArrayList<Object> pros2 = ff.read("Product.txt");
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
    public JPanel run()
    {
        FatherGUI gg = new FatherGUI();
        mainPanel = new JPanel();
        //mainPanel.setSize(mainFrame.getSize());
        mainPanel.setLayout(null);
        Files ff = new Files();
        pros = ff.read("Product.txt");
        for(int i = 0; i < pros.size(); i++)
        {
            if(Integer.parseInt(((ProductClass)pros.get(i)).getID().trim()) > biggestID)
                biggestID = Integer.parseInt(((ProductClass)pros.get(i)).getID().trim());
        }
        int labelInc = 30;
        //JFrame mainF = new JFrame();
        //mainF.setLayout(null);
        //mainF.setTitle("Products");
        //mainF.setBounds(0, 0, 800, 600);
        //mainF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // ArrayList for labels and text fields
        ArrayList<JTextField> Tfs = new ArrayList<>();
        ArrayList<JLabel> Lbs = new ArrayList<>();
        // initialize the the Tfs and Lbs
        for(int i = 0; i < 7; i++)
        {
            JTextField tf = new JTextField();
            JLabel lb = new JLabel();
            Lbs.add(lb);
            if(i >= 5)
                tf.setBounds(125, 60 + (i * 30), 125, 30);
            else
                tf.setBounds(125, 30 + (i * 30), 125, 30);
            gg.AllTextFieldFontSize(tf);
            Tfs.add(tf);
            mainPanel.add(tf);
        }
        
        
        ArrayList<Object> cats = ff.read("Category.txt");
        String []fg = new String[cats.size()];
        for(int i = 0; i < cats.size(); i++)
        {
            fg[i] = ((Admin.Categories)cats.get(i)).getCategory();
        }
        JComboBox catC = new JComboBox(fg);
        catC.setBounds(125, 30 + 5*30, 125, 30);
        JLabel lb = new JLabel();
        Lbs.add(lb);
        Tfs.get(6).setEditable(false);
        // Label Section
        Lbs.get(0).setText("Name:");
        Lbs.get(0).setBounds(10, 25, 125, 25);
        gg.AllLblFontSize(Lbs.get(0));
        mainPanel.add(((JLabel)Lbs.get(0)));
        Lbs.get(1).setText("Last Name:");
        Lbs.get(1).setBounds(10, labelInc * 2, 125, 25);
        gg.AllLblFontSize(Lbs.get(1));
        mainPanel.add(((JLabel)Lbs.get(1)));
        Lbs.get(2).setText("Quantity:");
        Lbs.get(2).setBounds(10, labelInc * 3, 125, 25);
        gg.AllLblFontSize(Lbs.get(2));
        mainPanel.add(((JLabel)Lbs.get(2)));
        Lbs.get(3).setText("Parcode:");
        Lbs.get(3).setBounds(10, labelInc * 4, 125, 25);
        gg.AllLblFontSize(Lbs.get(3));
        mainPanel.add(((JLabel)Lbs.get(3)));
        Lbs.get(4).setText("Price:");
        Lbs.get(4).setBounds(10, labelInc * 5, 125, 25);
        gg.AllLblFontSize(Lbs.get(4));
        mainPanel.add(((JLabel)Lbs.get(4)));
        Lbs.get(5).setText("Category:");
        Lbs.get(5).setBounds(10, labelInc * 6, 125, 25);
        gg.AllLblFontSize(Lbs.get(5));
        mainPanel.add(((JLabel)Lbs.get(5)));
        Lbs.get(6).setText("Expire Date:");
        Lbs.get(6).setBounds(10, labelInc * 7, 125, 25);
        gg.AllLblFontSize(Lbs.get(6));
        mainPanel.add(((JLabel)Lbs.get(6)));
        Lbs.get(7).setText("ID:");
        Lbs.get(7).setBounds(10, labelInc * 8, 125, 20);
        gg.AllLblFontSize(Lbs.get(7));
        mainPanel.add(((JLabel)Lbs.get(7)));
        
        // Table Section
        prosTable = readProducts();
        prosTable.setBounds(300, 20, 500, 500);
        prosTable.setEnabled(true);
        mainPanel.add(prosTable);
        JScrollPane prosSP = new JScrollPane(prosTable);
        prosSP.setBounds(300, 20, 500, 500);
        mainPanel.add(prosSP);

        //Buttons Section
        JButton addBtn = new JButton("Add");
        addBtn.setBounds(20, 300, 100, 25);
        addBtn.addActionListener((ActionEvent e) -> 
        {
            int check = 0;
            int g = 0;
            for(int i = 0; i < 6; i++)
            {
                if(!Tfs.get(i).getText().equals(""))
                    g++;
            }
            if(g == 6)
                check++;
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
            if(check == 3)
            {
                ProductClass newP = new ProductClass();
                newP.setID(Integer.toString(biggestID + 1));
                newP.setName(Tfs.get(0).getText());
                newP.setLName(Tfs.get(1).getText());
                newP.setQuantity(Integer.parseInt(Tfs.get(2).getText().trim()));
                newP.setParcode(Tfs.get(3).getText());
                newP.setPrice(Double.parseDouble(Tfs.get(4).getText().trim()));
                newP.setCategory(catC.getItemAt(catC.getSelectedIndex()).toString());
                newP.setEXP(Tfs.get(5).getText());
                newP.Add();
                pros.add(newP);
                JTable tmp = readProducts();
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
                for(int i = 0; i < Tfs.size(); i++)
                {
                    if(i >= 5)
                        Tfs.get(i).setText(tmp.getValueAt(prosTable.getSelectedRow(), i+1).toString());
                    else
                        Tfs.get(i).setText(tmp.getValueAt(prosTable.getSelectedRow(), i).toString());
                }
                String comp = tmp.getValueAt(prosTable.getSelectedRow(), 5).toString();
                for(int i = 0; i < catC.getItemCount(); i++)
                {
                    if(comp.equals(catC.getItemAt(i).toString()))
                    {
                        catC.setSelectedIndex(i);
                        break;
                    }
                }
            }
        });
        JButton updateBtn = new JButton("Update");
        updateBtn.setBounds(125, 300, 100, 25);
        updateBtn.addActionListener((ActionEvent e) -> 
        {
            int check = 0;
            int g = 0;
            for(int i = 0; i < 6; i++)
            {
                if(!Tfs.get(i).getText().equals(""))
                    g++;
            }
            if(g == 6)
                check++;
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
            if(check == 3)
            {
                // id@name@lastName@quantity@parcode@price@category@EXP@
                String Query = Tfs.get(6).getText() + "@" +Tfs.get(0).getText()
                        + "@" +Tfs.get(1).getText()+ "@" +Tfs.get(2).getText() +"@"
                        +Tfs.get(3).getText() +"@" +Tfs.get(4).getText().trim() +"@" +
                        catC.getItemAt(catC.getSelectedIndex()) + "@"
                        +Tfs.get(5).getText() +"@" +Tfs.get(6).getText() +"@";
                ff.update(Tfs.get(6).getText(), "Product.txt", Query);
                JTable tmp = readProducts();
                DefaultTableModel gf = (DefaultTableModel)tmp.getModel();
                prosTable.setModel(gf);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Invalid input");
            }
        });
        JButton delBtn = new JButton("Delete");
        delBtn.setBounds(70, 340, 100, 25);
        delBtn.addActionListener((ActionEvent e)->
        {
            if(!Tfs.get(6).getText().equals(""))
            {
                ff.delete(Tfs.get(6).getText(), "Product.txt");
                JTable tmp = readProducts();
                pros = ff.read("Product.txt");
                DefaultTableModel g = (DefaultTableModel)tmp.getModel();
                prosTable.setModel(g);
                for(int i = 0; i < 7; i++)
                {
                    Tfs.get(i).setText("");
                }
                for(int i = 0; i < pros.size(); i++)
                {
                    if(Integer.parseInt(((ProductClass)pros.get(i)).getID().trim()) > biggestID)
                        biggestID = Integer.parseInt(((ProductClass)pros.get(i)).getID().trim());
                }
            }
        });
        JButton backBtn = new JButton("Back");
        gg.ButtonBackHome(backBtn);
        backBtn.setBounds(50, 600, 100, 25);
        prosTable.setDefaultEditor(Object.class, null);
        mainPanel.add(addBtn);
        mainPanel.add(updateBtn);
        mainPanel.add(delBtn);
        mainPanel.add(backBtn);
        mainPanel.add(catC);
        mainPanel.setVisible(true);
        mainPanel.setSize(1200,700);
        //mainFrame.add(mainPanel);
        return mainPanel;
    }
}
