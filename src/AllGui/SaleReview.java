package AllGui;
import java.awt.Color;
import javax.swing.*;
import java.awt.event.*;
public class SaleReview extends Client.ClientClass{
    
    
   public JPanel run(){
    JTextField searchBar = new JTextField();
    JPanel panel = new JPanel();
    
    JPanel panelsalereview = new JPanel();

    JButton buttonsalereview = new JButton("Search");
    
    String salereviewcb[]={};
    JComboBox cbsr = new JComboBox(salereviewcb);
    
    JLabel lbTotal = new JLabel();
    JLabel lbProfit = new JLabel();
    
    String tableData[]={};
    String tableColumn[]={};
    
    
    
    
    
    
    panelsalereview.setBackground(Color.cyan);
    
    
    return panelsalereview;
    
    }
    
    
    
}
