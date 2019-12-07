/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AllGui;

import Admin.GraphClass;
import java.awt.*;
import java.io.File;
import javax.swing.*;

/*
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
*/
/**
 *
 * @author user
 */


public class Report  {
    
    public JPanel Run(){
        
        JPanel p = new JPanel();
        FatherGUI f=new FatherGUI();
        JButton bBack=new JButton("Back");
       f.ButtonBackHome(bBack);
       
       /*
       
       // To Make Variable From GraphClass
       GraphClass gc = new GraphClass();
       
       //Make For Loop To Add Values
       DefaultCategoryDataset dataset = new DefaultCategoryDataset();
       for(int i = 0; i< gc.getCategoryQuantities().size(); i++)
       {
           dataset.setValue(gc.getCategoryQuantities().get(i),"Quantity Sold From",gc.getCategoryNames().get(i));      
       }
       
       
        JFreeChart chart = ChartFactory.createBarChart3D("Graph Category",
                "Category", 
                "Quantity",
                dataset, 
                PlotOrientation.VERTICAL,
                true,
                true,
                true);
        chart.setBackgroundPaint(Color.lightGray);
        chart.getTitle().setPaint(Color.BLUE);
        chart.setBorderPaint(Color.GRAY);
        CategoryPlot plot = chart.getCategoryPlot();
        plot.setRangeGridlinePaint(Color.GREEN);
        ChartFrame frame = new ChartFrame("Graph For Category", chart);
        frame.setVisible(true);
        frame.setSize(1200,700);
        frame.setResizable(false);
        */
        
        
        p.add(bBack);
        p.setBackground(Color.WHITE);
        p.setLayout(null);
        p.setVisible(true);
        p.setSize(1200,700);
        return p;
    }
    
}
