/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AllGui;

import Product.Files;
import Product.ProductClass;
import java.awt.Color;
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
import javax.swing.JTextField;

/**
 *
 * @author Gerges hanna FCI-H
 */
public class SellPanel extends Product.ProductClass{

    JPanel panel=new JPanel();
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
        
        
        //x distance any y distance
        f.x1=40;
        f.x2=140;
        f.y1=40;
        f.y2=85;
        f.y3=130;
        f.y4=175;
        f.y5=220;
        
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
            JScrollPane sp=new JScrollPane(Tableproduct);
            
            Tableproduct.setBounds(10, 500, 1200, 490);
            sp.setBounds(10, 500, 1200, 490);
            
//            Tableproduct.setFont(new Font("thoma", 0, 20));
//            Tableproduct.setRowHeight(25);
            
            /** Expire Table **/
            
            String[][] ExpItems=new String[3][6];
            String[] ColoumnEXP={"ID","Name","Parcode","Quantity","Categorey","EXP After"};
            JTable tableEXP=new JTable(ExpItems,ColoumnEXP);
            tableEXP.setEnabled(true);
            JScrollPane sp2 = new JScrollPane(tableEXP);
            
            tableEXP.setBounds(1220, 500, 300, 490);
            sp2.setBounds(1220, 500, 300, 490);
            
        
        
        //Panel ADD 
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
        Tableproduct.setDefaultEditor(Object.class, null);
        tableEXP.setDefaultEditor(Object.class, null);
        panel.add(Tableproduct);
        panel.add(tableEXP);
        
        
        return panel;
    }
    
}
