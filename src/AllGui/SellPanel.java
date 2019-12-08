/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AllGui;

import static AllGui.ProductGUI.prosTable;
import Product.Files;
import Product.ProductClass;
import static Product.ProductClass.ReviewList;
import static Product.ProductClass.TablePro;
import static Product.ProductClass.productList;
import inventory.Inventory;
import static inventory.Inventory.frame;
import static inventory.Inventory.panelHome;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import javax.swing.table.*;
import javax.swing.text.StyleConstants;

/**
 *
 * @author Gerges hanna FCI-H
 */
public class SellPanel extends Product.ProductClass implements RunMethod{
    
    //Create Objects 
    FatherGUI f=new FatherGUI();
    Product.Files file=new Files();
    ProductClass tosell=new ProductClass();
    
    //Array Lists
    ArrayList<String> listCateg=new ArrayList<String>();
    ArrayList<ProductClass> inSell=new ArrayList<ProductClass>();
    
    
    
    private String [] sellRow=new String[6];
    private DefaultTableModel sellModel=new DefaultTableModel();
     
    
    public SellPanel() {
        TablePro.getDataVector().removeAllElements();
        TablePro.fireTableDataChanged();
        productList.clear();
        ReviewList.clear();
        EXPList.clear();
    }
    
    public void ClearTextField(JTextField t1,JTextField t2,JTextField t3,JTextField t4,JTextField t5,JLabel lbl)
    {
        t1.setText("");
        t2.setText("");
        t3.setText("1");
        t4.setText("");
        t5.setText("");
        lbl.setText("0.0");
    }
    @Override
    public JPanel Run()
    {
        
        JPanel panel=new JPanel();
        
       
        //x distance any y distance
        f.x1=40;
        f.x2=140;
        f.x3=420;
        f.x4=10;
        f.x5=820;
        f.y1=60;
        f.y2=105;
        f.y3=150;
        f.y4=195;
        f.y5=290;
        f.y6=330;
        f.y7=360;
        f.y8=420;
        
        //<<<<Tables>>>>>
         /***   ALLproduct   ***/
            // id@name@lastName@quantity@parcode@price@category@EXP@
            ReadData();
            String[][] items=new String[productList.size()][8];
            JTable Tableproduct=new JTable();
            Tableproduct.setModel(setProductTable(items));
            DefaultTableModel Model =(DefaultTableModel)Tableproduct.getModel();
        
            /** sell Table**/
            String[][] SellItems=new String[3][6];
            String[] ColoumnSell={"ID","Name","Parcode","Quantity","Categorey","sell"};
            sellModel.setColumnIdentifiers(ColoumnSell);
            JTable tableSell=new JTable();
            tableSell.setModel(sellModel);
            
            
            
            
        /** Expire Table **/
            int sizeList=CalculateAllEXP();
            String[][] ExpItems=new String[sizeList][6];
            listConvertToArray(ExpItems);
            String[] ColoumnEXP={"ID","Name","Parcode","Quantity","Categorey","EXP After"};
            JTable tableEXP=new JTable(ExpItems,ColoumnEXP);

            
            
            
            
        //Table  Scroll 
            JScrollPane sp=new JScrollPane(Tableproduct);
            JScrollPane sp3 = new JScrollPane(tableSell);
            JScrollPane sp2 = new JScrollPane(tableEXP);
        //Table setBounds
            sp.setBounds(f.x4, f.y8, 800, 240);
            sp3.setBounds(f.x3, f.y1, 750, 280);
            sp2.setBounds(f.x5, f.y8, 350, 240);
            
            Tableproduct.setBounds(f.x4, f.y8, 800, 240);
            tableSell.setBounds(f.x3, f.y1, 750, 280);
            tableEXP.setBounds(f.x5, f.y8, 350, 240);
            
        //Label Create 
        JLabel lblParcode=new JLabel("Parcode");
        JLabel lblName=new JLabel("Name");
        JLabel lblCategorey=new JLabel("Categorey");
        JLabel lblQuantity=new JLabel("Quantity");
        JLabel lblPrice=new JLabel("Price");
        JLabel lblShowPrice=new JLabel("0.0");
        JLabel lblDate=new JLabel("Date");
//        JLabel label=new JLabel();
//        label.setSize(1200, 700);
//        label.setIcon(new javax.swing.ImageIcon(frame.getClass().getResource("/inventory/Background.jpeg")));
//        
        
        
        //label setBound
        lblParcode.setBounds(f.x1, f.y1, 90, 30);
        lblName.setBounds(f.x1, f.y2, 90, 30);
        lblCategorey.setBounds(f.x1, f.y3, 100, 30);
        lblQuantity.setBounds(f.x1, f.y4, 90, 30);
        lblDate.setBounds(f.x1, f.y4+45, 90, 30);
        lblPrice.setBounds(f.x1, f.y5, 90, 30);
        lblShowPrice.setBounds(f.x2, f.y5,100 , 40);
        
        //Font LBL
        f.AllLblFontSize(lblParcode);
        f.AllLblFontSize(lblName);
        f.AllLblFontSize(lblPrice);
        f.AllLblFontSize(lblCategorey);
        f.AllLblFontSize(lblQuantity);
        f.AllLblFontSize(lblShowPrice);
        f.AllLblFontSize(lblDate);
        
        //btn create
        JButton btnAdd=new JButton("ADD");
        JButton btnClear=new JButton("Clear");
        JButton btnBuy=new JButton("Buy");
        JButton btnRemove=new JButton("Remove");
        JButton btnDeleteBoard=new JButton("Delet Board");
        JButton btnBack=new JButton("Back");
        JButton btnSearch=new JButton("Search");
        JButton btnReset=new JButton("Reset");
        f.ButtonBackHome(btnBack);
        
        //Jtextfield create
        JTextField txtParcode=new JTextField();
        JTextField txtName=new JTextField();
        JTextField txtQuantity=new JTextField();
        JTextField txtCategorey=new JTextField();
        JTextField txtDate=new JTextField();
        
        //
        txtQuantity.setText("1");
        
        //btn SrtBoaunds
        btnAdd.setBounds(30, f.y6, 120, 40);
        btnClear.setBounds(30+130, f.y6, 120, 40);
        btnBuy.setBounds(f.x3, f.y7, 120, 40);
        btnRemove.setBounds(f.x3+130, f.y7, 120, 40);
        btnDeleteBoard.setBounds(f.x3+260, f.y7, 120, 40);
        btnSearch.setBounds(290,f.y6, 120, 40);
        btnReset.setBounds(160,f.y6+50,120, 40);
        
        //btn Functions
        btnAdd.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                for (int i = 0; i < productList.size(); i++) {
                    if(productList.get(i).getID().equalsIgnoreCase(tosell.getID()))
                    {
                        if(tosell.getQuantity()>=Integer.parseInt(txtQuantity.getText()))
                        {
                            productList.get(i).setQuantity(tosell.getQuantity()-Integer.parseInt(txtQuantity.getText()));
                            TablePro.getDataVector().removeAllElements();
                            TablePro.fireTableDataChanged();
                            Tableproduct.setModel(setProductTable(items));
                            tosell.setQuantity(Integer.parseInt(txtQuantity.getText()));
                            inSell.add(tosell);
                            //{"ID","Name","Parcode","Quantity","Categorey","sell"}
                            sellRow[0]=productList.get(i).getID();
                            sellRow[1]=productList.get(i).getName();
                            sellRow[2]=productList.get(i).getParcode();
                            sellRow[3]=txtQuantity.getText();
                            sellRow[4]=productList.get(i).getCategory();
                            sellRow[5]=CalculatePrice(txtQuantity.getText(), productList.get(i).getPrice());
                            sellModel.addRow(sellRow);
                            
                        }else
                        {
                            JOptionPane.showMessageDialog(null, "Quantity Over");
                            
                        }
                        break;
                    }
                }
                ClearTextField(txtName,txtParcode,txtQuantity,txtCategorey,txtDate,lblShowPrice);
            }
        });
        btnClear.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
               ClearTextField(txtName,txtParcode,txtQuantity,txtCategorey,txtDate,lblShowPrice);
               
            }
        });
        btnRemove.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                int select=tableSell.getSelectedRow();
                int Quantity=Integer.parseInt(sellModel.getValueAt(select, 3).toString());
                System.out.println(Quantity);
                for (int i = 0; i < productList.size(); i++) {
                    if(productList.get(i).getID().equalsIgnoreCase(sellModel.getValueAt(select, 0).toString()))
                    {
                        productList.get(i).setQuantity(Quantity+productList.get(i).getQuantity());
                        TablePro.getDataVector().removeAllElements();
                        TablePro.fireTableDataChanged();
                        Tableproduct.setModel(setProductTable(items));
                        sellModel.removeRow(select);
                        break;
                    }
                    
                }
                ClearTextField(txtName,txtParcode,txtQuantity,txtCategorey,txtDate,lblShowPrice);
            }
        });
        btnDeleteBoard.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                
             sellModel.getDataVector().removeAllElements();
             sellModel.fireTableDataChanged();     
             ReadData();
             TablePro.getDataVector().removeAllElements();
             TablePro.fireTableDataChanged();
             Tableproduct.setModel(setProductTable(items));
             ClearTextField(txtName,txtParcode,txtQuantity,txtCategorey,txtDate,lblShowPrice);
            }
        });
        btnBuy.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                setTime(getTimeSell());
                setDate(getDatesSell());
                ReadSellReview();
                if(ReviewList.size()!=0)
                {
                    int p=Integer.parseInt(ReviewList.get(ReviewList.size()-1).getOper_ID());
                    setOper_ID(String.valueOf(p+1));
                }else if(ReviewList.size()==0)
                {
                    setOper_ID("0");
                }
                System.out.println(ReviewList.size());
//                
               while(sellModel.getRowCount()>0)
               {
                   setQueryFile(getOper_ID()+"@"+sellModel.getValueAt(0, 0)+"@"+
                           sellModel.getValueAt(0, 1)+"@"+
                           sellModel.getValueAt(0, 2)+"@"+
                           sellModel.getValueAt(0, 3)+"@"+
                           sellModel.getValueAt(0, 4)+"@"+
                           sellModel.getValueAt(0, 5)+"@"+
                           getTime()+"@"+getDate()
                   +"@"+Product.FatherClass.getIDlog());
                   //operation ID@product_ID@Name@parcode@Quantity@Category@Sell@Time@Date@Login_ID
                   file.write(getQueryFile(),"sellReview.txt", true);
                   sellModel.removeRow(0);
                    
               }
                while(TablePro.getRowCount()>0)
                {
                    setQueryFile(TablePro.getValueAt(0, 0)+"@"+
                            TablePro.getValueAt(0, 1)+"@"+
                            TablePro.getValueAt(0, 2)+"@"+
                            TablePro.getValueAt(0, 3)+"@"+
                            TablePro.getValueAt(0, 4)+"@"+
                            TablePro.getValueAt(0, 5)+"@"+
                            TablePro.getValueAt(0, 6)+"@"+
                            TablePro.getValueAt(0, 7));
                    //file.update(TablePro.getValueAt(0, 0).toString(),"Product.txt", getQueryFile());
                    if(!Update(TablePro.getValueAt(0, 0).toString(), getQueryFile()))
                    {
                        JOptionPane.showMessageDialog(frame,"there is Some thing wrong please restart program");
                    }
                    TablePro.removeRow(0);
                }
                ReadData();
                Tableproduct.setModel(setProductTable(items));
                ClearTextField(txtName,txtParcode,txtQuantity,txtCategorey,txtDate,lblShowPrice);
            }
        });
        btnSearch.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                if(!txtParcode.getText().trim().equalsIgnoreCase(""))
                {
                    TablePro.getDataVector().removeAllElements();
                    TablePro.fireTableDataChanged();
                    for (int i =productList.size()-1 ; i >=0; i--) {
                        if(!productList.get(i).getParcode().equalsIgnoreCase(txtParcode.getText()))
                        {
                            productList.remove(i);
                        }
                    }
                    Tableproduct.setModel(setProductTable(items));
                }else if(!txtName.getText().trim().equalsIgnoreCase(""))
                {
                    TablePro.getDataVector().removeAllElements();
                    TablePro.fireTableDataChanged();
                    for (int i =productList.size()-1 ; i >=0; i--) {
                        if(!productList.get(i).getName().equalsIgnoreCase(txtName.getText()))
                        {
                            productList.remove(i);
                        }
                    }
                    Tableproduct.setModel(setProductTable(items));
                    
                }else if(!txtCategorey.getText().trim().equalsIgnoreCase(""))
                {
                    TablePro.getDataVector().removeAllElements();
                    TablePro.fireTableDataChanged();
                    for (int i =productList.size()-1 ; i >=0; i--) {
                        if(!productList.get(i).getCategory().equalsIgnoreCase(txtCategorey.getText()))
                        {
                            productList.remove(i);
                        }
                    }
                    Tableproduct.setModel(setProductTable(items));
                }else if(!txtDate.getText().trim().equalsIgnoreCase(""))
                {
                    TablePro.getDataVector().removeAllElements();
                    TablePro.fireTableDataChanged();
                    for (int i =productList.size()-1 ; i >=0; i--) {
                        if(!productList.get(i).getEXP().equalsIgnoreCase(txtDate.getText()))
                        {
                            productList.remove(i);
                        }
                    }
                    Tableproduct.setModel(setProductTable(items));
                }
            }
        });
        btnReset.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                ClearTextField(txtName,txtParcode,txtQuantity,txtCategorey,txtDate,lblShowPrice);
                TablePro.getDataVector().removeAllElements();
                 TablePro.fireTableDataChanged();
                ReadData();
                for (int i = 0; i < productList.size(); i++) {
                    for (int j = 0; j < sellModel.getRowCount(); j++) {
                        if(productList.get(i).getID().
                                equalsIgnoreCase(sellModel.getValueAt(j, 0)
                                        .toString()))
                        {
                            productList.get(i).setQuantity(
                                    productList.get(i).getQuantity()
                                            -Integer.parseInt((String) sellModel.getValueAt(j, 3)));
                            
                        }
                    }
                }
                Tableproduct.setModel(setProductTable(items));
            }
        });
        
        

        //text setBounds
        txtParcode.setBounds(f.x2, f.y1, 250, 40);
        txtName.setBounds(f.x2, f.y2, 250, 40);
        txtQuantity.setBounds(f.x2, f.y4, 250, 40);
        txtCategorey.setBounds(f.x2, f.y3, 250, 40);
        txtDate.setBounds(f.x2, f.y4+45,250, 40);
        

        //Font Txt
        f.AllTextFieldFontSize(txtName);
        f.AllTextFieldFontSize(txtParcode);
        f.AllTextFieldFontSize(txtQuantity);
        f.AllTextFieldFontSize(txtCategorey);
        f.AllTextFieldFontSize(txtDate);
        
            //Table Function
            Tableproduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                
                 int SelectedRow =Tableproduct.getSelectedRow();                 
                 txtParcode.setText((String) Model.getValueAt(SelectedRow,4));
                 txtName.setText((String) Model.getValueAt(SelectedRow,1));
                 lblShowPrice.setText((String) Model.getValueAt(SelectedRow,1));
                 txtCategorey.setText((String) Model.getValueAt(SelectedRow,6));
                 txtDate.setText((String) Model.getValueAt(SelectedRow,7));
                 tosell.setName((String) Model.getValueAt(SelectedRow,1));
                 tosell.setQuantity(Integer.parseInt(Model.getValueAt(SelectedRow,3).toString()));
                 tosell.setID((String) Model.getValueAt(SelectedRow,0));
                 tosell.setParcode((String) Model.getValueAt(SelectedRow,4));
                 tosell.setCategory((String) Model.getValueAt(SelectedRow,6));
                 tosell.setPrice(Double.parseDouble( Model.getValueAt(SelectedRow,5).toString()));
                 //Integer.parseInt(txtQuantity.getText())
                 //String[] ColoumnSell={"ID","Name","Parcode","Quantity","Categorey","sell"};
            }
        });
     
        //Panel ADD 
        panel.setLayout(null);
        panel.add(lblParcode);
        panel.add(lblCategorey);
        panel.add(lblName);
        panel.add(lblPrice);
        panel.add(lblQuantity);
        panel.add(lblShowPrice);
        panel.add(txtParcode);
        panel.add(txtName);
        panel.add(txtQuantity);
        panel.add(txtCategorey);
        panel.add(sp);
        panel.add(sp2);
        panel.add(sp3);
        panel.add(btnAdd);
        panel.add(btnBuy);
        panel.add(btnClear);
        panel.add(btnDeleteBoard);
        panel.add(btnRemove);
        panel.add(btnBack);
        panel.add(btnSearch);
        panel.add(btnReset);
        panel.add(lblDate);
        panel.add(txtDate);
//        panel.add(label);
        panel.setSize(1200, 700);
        return panel;
    }
    
}
