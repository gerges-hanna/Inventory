package AllGui;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.Border;

public class ClientReview extends Client.ClientClass{
    
    public JPanel run(){
        
        FatherGUI f=new FatherGUI();
       
       //Create
    JTextField searchBarCR = new JTextField();
    
    
    JPanel panelClientReview = new JPanel();

    JButton buttonClientReview = new JButton("Search");
    JButton backButtonCR = new JButton("Back");
    f.ButtonBackHome(backButtonCR);
    
    String clientreviewcb[]={};
    JComboBox cbCR = new JComboBox(clientreviewcb);
    
    JLabel lbTotalCR = new JLabel("Total Sales:");
    JLabel lbProfitCR = new JLabel("Total Profit:");
    JLabel lbSearchBarCR = new JLabel("Search:");
    
    String tableDataCR[][]= new String[100][2];
    String tableColumnCR[]={"1","2"};
    
    JTable tableClientReview=new JTable(tableDataCR,tableColumnCR);
    JScrollPane spCR=new JScrollPane(tableClientReview);
    
    //BOUNDS
    
    lbSearchBarCR.setBounds(170, 39, 150, 50);
    searchBarCR.setBounds(270,45,350,30);
    cbCR.setBounds(635, 45, 200, 30);
    buttonClientReview.setBounds(850,45,100,30);
    tableClientReview.setBounds(100,100,1000,400);
    spCR.setBounds(100,130,1000,400);
    lbTotalCR.setBounds(25, 570, 150, 50);
    lbProfitCR.setBounds(300, 570, 150, 50);
    
   //fonts
   lbSearchBarCR.setFont(new Font("Tahoma",0,25));
    searchBarCR.setFont(new Font("Tahoma",0,20));
    cbCR.setFont(new Font("Tahoma",0,20));
    buttonClientReview.setFont(new Font("Tahoma",0,20));
    tableClientReview.setFont(new Font("Tahoma",0,20));
    lbTotalCR.setFont(new Font("Tahoma",0,25));
    lbProfitCR.setFont(new Font("Tahoma",0,25)); 
    
    
    //colors
    panelClientReview.setBackground(Color.white);
    searchBarCR.setBackground(Color.white);
    cbCR.setBackground(Color.white);
    tableClientReview.setBackground(Color.LIGHT_GRAY);
    
    
    
    panelClientReview.setLayout(null);   
    panelClientReview.setSize(1200, 700); 
    panelClientReview.setVisible(true);
    
    
    
    //ADD
    panelClientReview.add(spCR);
    panelClientReview.add(searchBarCR);
    panelClientReview.add(cbCR);
    panelClientReview.add(buttonClientReview);
    panelClientReview.add(tableClientReview);
    panelClientReview.add(lbTotalCR);
    panelClientReview.add(lbProfitCR);
    panelClientReview.add(lbSearchBarCR);
    panelClientReview.add(backButtonCR);
    
    
    
    return panelClientReview;
    
    }
    
    
}
