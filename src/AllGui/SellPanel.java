/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AllGui;

import Product.Files;
import Product.ProductClass;
import java.awt.Color;
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

/**
 *
 * @author Gerges hanna FCI-H
 */
public class SellPanel extends Product.ProductClass{

    FatherGUI f=new FatherGUI();
    Product.Files file=new Files();
    ProductClass ExpObject=new ProductClass();
    //Array Lists
        ArrayList<String> listCateg=new ArrayList<String>();
        ArrayList<ProductClass> ListExp=new ArrayList<ProductClass>();
    
    public SellPanel() {
        
    }
    
    public void setProductTable(String [][] items)
    {
        for (int i = 0; i < productList.size(); i++) {
            
       }
            
            for (int i = 0; i < productList.size(); i++) {
                
                    items[i][0]=productList.get(i).getID();
                    items[i][1]=productList.get(i).getName();
                    items[i][2]=productList.get(i).getLName();
                    items[i][3]=String.valueOf(productList.get(i).getQuantity());
                    items[i][4]=productList.get(i).getParcode();
                    items[i][5]=String.valueOf(productList.get(i).getPrice());
                    items[i][6]=productList.get(i).getCategory();
                    items[i][7]=productList.get(i).getEXP();
//                    if(ExpireRemainder(productList.get(i).getEXP()))
//                    {
//                        ExpObject.setID(productList.get(i).getID());
//                        ExpObject.setName(productList.get(i).getName());
//                        ExpObject.setQuantity(productList.get(i).getQuantity());
//                        ExpObject.setParcode(productList.get(i).getParcode());
//                        ExpObject.setRemainderDay(getRemainderDay());
//                        ExpObject.setCategory(productList.get(i).getCategory());
//                        ExpObject.setPrice(productList.get(i).getPrice());
//                        ListExp.add(ExpObject);
//                    }
                
            
        }
    }
    
    public JPanel Run()
    {
        
        JPanel panel=new JPanel();
        //x distance any y distance
        f.x1=40;
        f.x2=140;
        f.x3=420;
        f.y1=40;
        f.y2=85;
        f.y3=130;
        f.y4=175;
        f.y5=220;
        f.y6=280;
        
        //Label Create 
        JLabel lblParcode=new JLabel("Parcode");
        JLabel lblName=new JLabel("Name");
        JLabel lblCategorey=new JLabel("Categorey");
        JLabel lblQuantity=new JLabel("Quantity");
        JLabel lblPrice=new JLabel("Price");
        JLabel lblShowPrice=new JLabel("Show Price");
        
        //label setBound
        lblParcode.setBounds(f.x1, f.y1, 90, 30);
        lblName.setBounds(f.x1, f.y2, 90, 30);
        lblCategorey.setBounds(f.x1, f.y3, 100, 30);
        lblQuantity.setBounds(f.x1, f.y4, 90, 30);
        lblPrice.setBounds(f.x1, f.y5, 90, 30);
        lblShowPrice.setBounds(f.x2, f.y5,100 , 40);
        
        //Font LBL
        f.AllLblFontSize(lblParcode);
        f.AllLblFontSize(lblName);
        f.AllLblFontSize(lblPrice);
        f.AllLblFontSize(lblCategorey);
        f.AllLblFontSize(lblQuantity);
        f.AllLblFontSize(lblShowPrice);
        
        //btn create
        JButton btnAdd=new JButton("ADD");
        JButton btnClear=new JButton("Clear");
        JButton btnBuy=new JButton("Buy");
        JButton btnRemove=new JButton("Remove");
        JButton btnDeleteBoard=new JButton("Delet Board");
        
        //btn SrtBoaunds
        btnAdd.setBounds(f.x2, f.y6, 120, 40);
        btnClear.setBounds(f.x2+130, f.y6, 120, 40);
        btnBuy.setBounds(f.x3, f.y1+310, 120, 40);
        btnRemove.setBounds(f.x3+130, f.y1+310, 120, 40);
        btnDeleteBoard.setBounds(f.x3+260, f.y1+310, 120, 40);
               
        
        //Jtextfield create
        JTextField txtParcode=new JTextField();
        JTextField txtName=new JTextField();
        JTextField txtQuantity=new JTextField();

        //text setBounds
        txtParcode.setBounds(f.x2, f.y1, 250, 40);
        txtName.setBounds(f.x2, f.y2, 250, 40);
        txtQuantity.setBounds(f.x2, f.y4, 250, 40);

        //Font Txt
        f.AllTextFieldFontSize(txtName);
        f.AllTextFieldFontSize(txtParcode);
        f.AllTextFieldFontSize(txtQuantity);
        
        //combo box
        
        String category[]=new String[listCateg.size()];
        JComboBox categoreBox=new JComboBox(listCateg.toArray(category));
        categoreBox.setBounds(f.x2, f.y3, 250, 40);
        
        //JTable create
          /***   ALLproduct   ***/
            // id@name@lastName@quantity@parcode@price@category@EXP@
            ReadData();
            String[][] items=new String[productList.size()][8];
            setProductTable(items);
            String [] ColumnsProduct={"ID","Name","LName","Quantity","Parcode","Price","Categorey","EXP"};
            JTable Tableproduct=new JTable(items,ColumnsProduct);
            Tableproduct.setBounds(10, f.y1+360, 800, 250);
            
            JScrollPane sp=new JScrollPane(Tableproduct);
            sp.setBounds(10, f.y1+360, 800, 250);
       
            
            
            
//            Tableproduct.setFont(new Font("thoma", 0, 20));
//            Tableproduct.setRowHeight(25);
            
            /** Expire Table **/
            
            String[][] ExpItems=new String[3][6];
            String[] ColoumnEXP={"ID","Name","Parcode","Quantity","Categorey","EXP After"};
            JTable tableEXP=new JTable(ExpItems,ColoumnEXP);
            tableEXP.setEnabled(true);
            JScrollPane sp2 = new JScrollPane(tableEXP);
            tableEXP.setBounds(820, f.y1+360, 350, 250);
            sp2.setBounds(820, f.y1+360, 350, 250);
            
            
            /** sell Table**/
            String[][] SellItems=new String[3][6];
            String[] ColoumnSell={"ID","Name","Parcode","Quantity","Categorey","sell"};
            JTable tableSell=new JTable(SellItems,ColoumnSell);
            JScrollPane sp3 = new JScrollPane(tableSell);
            tableSell.setBounds(f.x3, f.y1, 750, 300);
            sp3.setBounds(f.x3, f.y1, 750, 300);
        
        
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
        panel.add(categoreBox);
        panel.add(sp);
        panel.add(sp2);
        panel.add(sp3);
        panel.add(btnAdd);
        panel.add(btnBuy);
        panel.add(btnClear);
        panel.add(btnDeleteBoard);
        panel.add(btnRemove);
        panel.setSize(1200, 700);
        
        

        
        
        
        
        return panel;
    }
    
}
