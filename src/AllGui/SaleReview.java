package AllGui;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.Border;
public class SaleReview extends Client.ClientClass{
    private Border Border;
    
    
   public JPanel run(){
       
       //Create
    JTextField searchBar = new JTextField();
    
    
    JPanel panelsalereview = new JPanel();

    JButton buttonSaleReview = new JButton("Search");
    JButton backButton = new JButton("Back");
    
    String salereviewcb[]={};
    JComboBox cbsr = new JComboBox(salereviewcb);
    
    JLabel lbTotal = new JLabel("Total Sales:");
    JLabel lbProfit = new JLabel("Total Profit:");
    JLabel lbSearchBar = new JLabel("Search:");
    
    String tableData[][]=new String[100][2];
    String tableColumn[]={"1","2"};
    
    

  
           
              
    
    
    JTable tableSaleReview=new JTable(tableData,tableColumn);
     JScrollPane sp=new JScrollPane(tableSaleReview); 
     
    
    
    
    //BOUNDS
    backButton.setBounds(25,25,70,30);
    lbSearchBar.setBounds(170, 39, 150, 50);
    searchBar.setBounds(270,45,350,30);
    cbsr.setBounds(635, 45, 200, 30);
    buttonSaleReview.setBounds(850,45,100,30);
    tableSaleReview.setBounds(100,100,1000,400);
    sp.setBounds(100,130,1000,400);
    lbTotal.setBounds(25, 570, 150, 50);
    lbProfit.setBounds(300, 570, 150, 50);
    
   //fonts
   lbSearchBar.setFont(new Font("Tahoma",0,25));
    searchBar.setFont(new Font("Tahoma",0,20));
    cbsr.setFont(new Font("Tahoma",0,20));
    buttonSaleReview.setFont(new Font("Tahoma",0,20));
    tableSaleReview.setFont(new Font("Tahoma",0,20));
    lbTotal.setFont(new Font("Tahoma",0,25));
    lbProfit.setFont(new Font("Tahoma",0,25)); 
    
    
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
    panelsalereview.add(lbProfit);
    panelsalereview.add(lbSearchBar);
    panelsalereview.add(backButton);
    panelsalereview.setSize(1200,700);
    
    
    
    return panelsalereview;
    
    }
    
    
    
}
