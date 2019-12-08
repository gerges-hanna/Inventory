package AllGui;

import Product.FatherClass;
import Product.Files;
import Product.ProductClass;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class ClientReview implements RunMethod
{
    private double totalProfitNumber;
    private DefaultTableModel updateTable()
    {
        //operation ID@product_ID@Name@parcode@Quantity@Category@Sell@Time@Date@Login_ID
        Files f = new Files();
        DefaultTableModel tmpM = new DefaultTableModel();
        tmpM.addColumn("ID");
        tmpM.addColumn("Product ID");
        tmpM.addColumn("Name");
        tmpM.addColumn("Parcode");
        tmpM.addColumn("Qunatity");
        tmpM.addColumn("Category");
        tmpM.addColumn("Sell");
        tmpM.addColumn("Time");
        tmpM.addColumn("Date");
        ArrayList<Object> data = f.read("sellReview.txt");
        String [][]rows = new String[data.size()][9];
        totalProfitNumber = 0;
        for(int i = 0; i < data.size(); i++)
        {
            if(FatherClass.getIDlog().equals(((ProductClass)data.get(i)).getID()))
            {
                rows[i][0] = ((ProductClass)data.get(i)).getOper_ID();
                rows[i][1] = ((ProductClass)data.get(i)).getPro_ID();
                rows[i][2] = ((ProductClass)data.get(i)).getName();
                rows[i][3] = ((ProductClass)data.get(i)).getParcode();
                rows[i][4] = Integer.toString(((ProductClass)data.get(i)).getQuantity());
                rows[i][5] = ((ProductClass)data.get(i)).getCategory();
                rows[i][6] = Double.toString(((ProductClass)data.get(i)).getPrice());
                rows[i][7] = ((ProductClass)data.get(i)).getTime();
                rows[i][8] = ((ProductClass)data.get(i)).getDate();
                totalProfitNumber += ((ProductClass)data.get(i)).getPrice();
                tmpM.addRow(rows[i]);
            }
        }
        
        return tmpM;
    }
    
    private DefaultTableModel searchTable(String what, String type)
    {
        Files f = new Files();
        DefaultTableModel tmpM = new DefaultTableModel();
        tmpM.addColumn("ID");
        tmpM.addColumn("Product ID");
        tmpM.addColumn("Name");
        tmpM.addColumn("Parcode");
        tmpM.addColumn("Qunatity");
        tmpM.addColumn("Category");
        tmpM.addColumn("Sell");
        tmpM.addColumn("Time");
        tmpM.addColumn("Date");
        tmpM.addColumn("Login ID");
        ArrayList<Object> data = f.read("sellReview.txt");
        String [][]rows = new String[data.size()][10];
        totalProfitNumber = 0;
        for(int i = 0; i < data.size(); i++)
        {
            if(FatherClass.getIDlog().equals(((ProductClass)data.get(i)).getID()))
            {
                switch(type)
                {
                    case "Product ID":
                        if(((ProductClass)data.get(i)).getPro_ID().equals(what))
                        {
                            rows[i][0] = ((ProductClass)data.get(i)).getOper_ID();
                            rows[i][1] = ((ProductClass)data.get(i)).getPro_ID();
                            rows[i][2] = ((ProductClass)data.get(i)).getName();
                            rows[i][3] = ((ProductClass)data.get(i)).getParcode();
                            rows[i][4] = Integer.toString(((ProductClass)data.get(i)).getQuantity());
                            rows[i][5] = ((ProductClass)data.get(i)).getCategory();
                            rows[i][6] = Double.toString(((ProductClass)data.get(i)).getPrice());
                            rows[i][7] = ((ProductClass)data.get(i)).getTime();
                            rows[i][8] = ((ProductClass)data.get(i)).getDate();
                            totalProfitNumber += ((ProductClass)data.get(i)).getPrice();
                            tmpM.addRow(rows[i]);
                        }
                        break;
                    case "Name":
                        if(((ProductClass)data.get(i)).getName().equals(what))
                        {
                            rows[i][0] = ((ProductClass)data.get(i)).getOper_ID();
                            rows[i][1] = ((ProductClass)data.get(i)).getPro_ID();
                            rows[i][2] = ((ProductClass)data.get(i)).getName();
                            rows[i][3] = ((ProductClass)data.get(i)).getParcode();
                            rows[i][4] = Integer.toString(((ProductClass)data.get(i)).getQuantity());
                            rows[i][5] = ((ProductClass)data.get(i)).getCategory();
                            rows[i][6] = Double.toString(((ProductClass)data.get(i)).getPrice());
                            rows[i][7] = ((ProductClass)data.get(i)).getTime();
                            rows[i][8] = ((ProductClass)data.get(i)).getDate();
                            totalProfitNumber += ((ProductClass)data.get(i)).getPrice();
                            tmpM.addRow(rows[i]);
                        }
                        break;
                    case "Parcode":
                        if(((ProductClass)data.get(i)).getParcode().equals(what))
                        {
                            rows[i][0] = ((ProductClass)data.get(i)).getOper_ID();
                            rows[i][1] = ((ProductClass)data.get(i)).getPro_ID();
                            rows[i][2] = ((ProductClass)data.get(i)).getName();
                            rows[i][3] = ((ProductClass)data.get(i)).getParcode();
                            rows[i][4] = Integer.toString(((ProductClass)data.get(i)).getQuantity());
                            rows[i][5] = ((ProductClass)data.get(i)).getCategory();
                            rows[i][6] = Double.toString(((ProductClass)data.get(i)).getPrice());
                            rows[i][7] = ((ProductClass)data.get(i)).getTime();
                            rows[i][8] = ((ProductClass)data.get(i)).getDate();
                            totalProfitNumber += ((ProductClass)data.get(i)).getPrice();
                            tmpM.addRow(rows[i]);
                        }
                        break;
                    case "Qunatity":
                        if(Integer.toString(((ProductClass)data.get(i)).getQuantity()).equals(what))
                        {
                            rows[i][0] = ((ProductClass)data.get(i)).getOper_ID();
                            rows[i][1] = ((ProductClass)data.get(i)).getPro_ID();
                            rows[i][2] = ((ProductClass)data.get(i)).getName();
                            rows[i][3] = ((ProductClass)data.get(i)).getParcode();
                            rows[i][4] = Integer.toString(((ProductClass)data.get(i)).getQuantity());
                            rows[i][5] = ((ProductClass)data.get(i)).getCategory();
                            rows[i][6] = Double.toString(((ProductClass)data.get(i)).getPrice());
                            rows[i][7] = ((ProductClass)data.get(i)).getTime();
                            rows[i][8] = ((ProductClass)data.get(i)).getDate();
                            totalProfitNumber += ((ProductClass)data.get(i)).getPrice();
                            tmpM.addRow(rows[i]);
                        }
                        break;
                    case "Category":
                        if(((ProductClass)data.get(i)).getCategory().equals(what))
                        {
                            rows[i][0] = ((ProductClass)data.get(i)).getOper_ID();
                            rows[i][1] = ((ProductClass)data.get(i)).getPro_ID();
                            rows[i][2] = ((ProductClass)data.get(i)).getName();
                            rows[i][3] = ((ProductClass)data.get(i)).getParcode();
                            rows[i][4] = Integer.toString(((ProductClass)data.get(i)).getQuantity());
                            rows[i][5] = ((ProductClass)data.get(i)).getCategory();
                            rows[i][6] = Double.toString(((ProductClass)data.get(i)).getPrice());
                            rows[i][7] = ((ProductClass)data.get(i)).getTime();
                            rows[i][8] = ((ProductClass)data.get(i)).getDate();
                            totalProfitNumber += ((ProductClass)data.get(i)).getPrice();
                            tmpM.addRow(rows[i]);
                        }
                        break;
                    case "Sell":
                        if((((ProductClass)data.get(i)).getPrice()) == Double.parseDouble(what))
                        {
                            rows[i][0] = ((ProductClass)data.get(i)).getOper_ID();
                            rows[i][1] = ((ProductClass)data.get(i)).getPro_ID();
                            rows[i][2] = ((ProductClass)data.get(i)).getName();
                            rows[i][3] = ((ProductClass)data.get(i)).getParcode();
                            rows[i][4] = Integer.toString(((ProductClass)data.get(i)).getQuantity());
                            rows[i][5] = ((ProductClass)data.get(i)).getCategory();
                            rows[i][6] = Double.toString(((ProductClass)data.get(i)).getPrice());
                            rows[i][7] = ((ProductClass)data.get(i)).getTime();
                            rows[i][8] = ((ProductClass)data.get(i)).getDate();
                            totalProfitNumber += ((ProductClass)data.get(i)).getPrice();
                            tmpM.addRow(rows[i]);
                        }
                        break;
                    case "Time":
                        if(((ProductClass)data.get(i)).getTime().equals(what))
                        {
                            rows[i][0] = ((ProductClass)data.get(i)).getOper_ID();
                            rows[i][1] = ((ProductClass)data.get(i)).getPro_ID();
                            rows[i][2] = ((ProductClass)data.get(i)).getName();
                            rows[i][3] = ((ProductClass)data.get(i)).getParcode();
                            rows[i][4] = Integer.toString(((ProductClass)data.get(i)).getQuantity());
                            rows[i][5] = ((ProductClass)data.get(i)).getCategory();
                            rows[i][6] = Double.toString(((ProductClass)data.get(i)).getPrice());
                            rows[i][7] = ((ProductClass)data.get(i)).getTime();
                            rows[i][8] = ((ProductClass)data.get(i)).getDate();
                            totalProfitNumber += ((ProductClass)data.get(i)).getPrice();
                            tmpM.addRow(rows[i]);
                        }
                        break;
                    case "Date":
                        if(((ProductClass)data.get(i)).getDate().equals(what))
                        {
                            rows[i][0] = ((ProductClass)data.get(i)).getOper_ID();
                            rows[i][1] = ((ProductClass)data.get(i)).getPro_ID();
                            rows[i][2] = ((ProductClass)data.get(i)).getName();
                            rows[i][3] = ((ProductClass)data.get(i)).getParcode();
                            rows[i][4] = Integer.toString(((ProductClass)data.get(i)).getQuantity());
                            rows[i][5] = ((ProductClass)data.get(i)).getCategory();
                            rows[i][6] = Double.toString(((ProductClass)data.get(i)).getPrice());
                            rows[i][7] = ((ProductClass)data.get(i)).getTime();
                            rows[i][8] = ((ProductClass)data.get(i)).getDate();
                            totalProfitNumber += ((ProductClass)data.get(i)).getPrice();
                            tmpM.addRow(rows[i]);
                        }
                        break;
                    case "ID":
                        if(((ProductClass)data.get(i)).getOper_ID().equals(what))
                        {
                            rows[i][0] = ((ProductClass)data.get(i)).getOper_ID();
                            rows[i][1] = ((ProductClass)data.get(i)).getPro_ID();
                            rows[i][2] = ((ProductClass)data.get(i)).getName();
                            rows[i][3] = ((ProductClass)data.get(i)).getParcode();
                            rows[i][4] = Integer.toString(((ProductClass)data.get(i)).getQuantity());
                            rows[i][5] = ((ProductClass)data.get(i)).getCategory();
                            rows[i][6] = Double.toString(((ProductClass)data.get(i)).getPrice());
                            rows[i][7] = ((ProductClass)data.get(i)).getTime();
                            rows[i][8] = ((ProductClass)data.get(i)).getDate();
                            totalProfitNumber += ((ProductClass)data.get(i)).getPrice();
                            tmpM.addRow(rows[i]);
                        }
                        break;
                }
            }
        }
        return tmpM;
        
    }
    
    private String[] comboboxData()
    {
        String[] reval = 
        {
            "ID",
            "Product ID",
            "Name",
            "Parcode",
            "Qunatity",
            "Category",
            "Sell",
            "Time",
            "Date"
        };
        return reval;
    }

        
    @Override
    public JPanel Run()
    {
        FatherGUI f=new FatherGUI();
        //Create
        JTextField searchBar = new JTextField();
        JPanel panelsalereview = new JPanel();
        JButton buttonSaleReview = new JButton("Search");
        JButton backButton = new JButton("Back");
        JButton resetBtn = new JButton("Reset Table");
        f.ButtonBackHome(backButton);
        
        JTable tableSaleReview = new JTable(updateTable());
        JScrollPane sp=new JScrollPane(tableSaleReview); 
        
        JComboBox cbsr = new JComboBox(comboboxData());
        JLabel lbTotal = new JLabel("Total Sales:" + " " + Double.toString(totalProfitNumber));
        JLabel lbSearchBar = new JLabel("Search:");
        /*String tableData[][]=new String[100][2];
        String tableColumn[]={"1","2"};*/

        

        //bounds
        lbSearchBar.setBounds(170, 37, 150, 50);
        searchBar.setBounds(270,45,350,30);
        cbsr.setBounds(635, 45, 200, 30);
        buttonSaleReview.setBounds(850,45,100,30);
        resetBtn.setBounds(850,600,150,30);
        tableSaleReview.setBounds(100,100,1000,400);
        sp.setBounds(100,130,1000,400);
        lbTotal.setBounds(25, 570, 1200, 50);
        //fonts
        lbSearchBar.setFont(new Font("Tahoma",0,25));
        searchBar.setFont(new Font("Tahoma",0,20));
        cbsr.setFont(new Font("Tahoma",0,20));
        buttonSaleReview.setFont(new Font("Tahoma",0,20));
        resetBtn.setFont(new Font("Tahoma",0,20));
        tableSaleReview.setFont(new Font("Tahoma",0,20));
        lbTotal.setFont(new Font("Tahoma",0,25));
        tableSaleReview.setRowHeight(22);

        //colors
        panelsalereview.setBackground(Color.white);
        searchBar.setBackground(Color.white);
        cbsr.setBackground(Color.white);   
        tableSaleReview.setBackground(Color.LIGHT_GRAY);

        panelsalereview.setLayout(null);
        panelsalereview.setSize(1200, 700); 
        panelsalereview.setVisible(true);

        panelsalereview.add(searchBar);
        panelsalereview.add(cbsr);
        panelsalereview.add(buttonSaleReview);
        panelsalereview.add(sp);
        panelsalereview.add(lbTotal);
        panelsalereview.add(lbSearchBar);
        panelsalereview.add(backButton);
        panelsalereview.add(resetBtn);
        panelsalereview.setSize(1200,700);
        // actions
        buttonSaleReview.addActionListener((ActionEvent e) ->
        {
            if(!searchBar.getText().equals(""))
            {
                tableSaleReview.setModel( searchTable(searchBar.getText(),cbsr.getSelectedItem().toString() ) );
                lbTotal.setText("Total Sales:" + " " + Double.toString(totalProfitNumber));
            }
        });
        resetBtn.addActionListener((ActionEvent e) ->
        {
            if(!searchBar.getText().equals(""))
            {
                tableSaleReview.setModel( updateTable());
                lbTotal.setText("Total Sales:" + " " + Double.toString(totalProfitNumber));
            }
        });
        return panelsalereview;
    }
    //
}
