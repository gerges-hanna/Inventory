/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Product;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Gerges hanna FCI-H
 */

//this class created by Gerges hanna
public class ProductClass extends FatherClass {
   public static ArrayList<ProductClass> productList = new ArrayList<ProductClass>();

    
    
    private int DateDay;
    private int DateMonth;
    private int DateYear;
    private int ExpDay;
    private int ExpMonth;
    private int EXPYear;
    private int RemainderDay;
    private long AllDay;
    private String DateCompare; 
     
    final private String filePath="Product.txt";

    
    public ProductClass() {
    }
    
    

    //Getter And Setter Functions (Gerges)
    public int getDateDay() {
        return DateDay;
    }

    public void setDateDay(int DateDay) {
        this.DateDay = DateDay;
    }

    public int getDateMonth() {
        return DateMonth;
    }

    public void setDateMonth(int DateMonth) {
        this.DateMonth = DateMonth;
    }

    public int getDateYear() {
        return DateYear;
    }

    public void setDateYear(int DateYear) {
        this.DateYear = DateYear;
    }

    public int getExpDay() {
        return ExpDay;
    }

    public void setExpDay(int ExpDay) {
        this.ExpDay = ExpDay;
    }

    public int getExpMonth() {
        return ExpMonth;
    }

    public void setExpMonth(int ExpMonth) {
        this.ExpMonth = ExpMonth;
    }

    public int getEXPYear() {
        return EXPYear;
    }

    public void setEXPYear(int EXPYear) {
        this.EXPYear = EXPYear;
    }

    public int getRemainderDay() {
        return RemainderDay;
    }

    public void setRemainderDay(int RemainderDay) {
        this.RemainderDay = RemainderDay;
    }

    public long getAllDay() {
        return AllDay;
    }

    public void setAllDay(long AllDay) {
        this.AllDay = AllDay;
    }

  
       /*Function return 1 if Days Remainder to Expire is
         less than 60 Days otherwise return 0 and it save Days Remainder to exp
         in RemainderDay Attributs
         it's requre to enter Date Expire(Gerges)
       */
     public boolean ExpireRemainder()
    {
        try
        {
            SimpleDateFormat s=new SimpleDateFormat("dd-MM-yyyy");
            Date d=new Date();
            String Date1=s.format(d);
            String[] currentDate=Date1.split("-");
            this.DateDay=Integer.parseInt(currentDate[0]);
            this.DateMonth=Integer.parseInt(currentDate[1]);
            this.DateYear=Integer.parseInt(currentDate[2]);
            AllDay=DateDay+DateMonth*30+DateYear*365;

            String[] DateCompareSplit=super.getEXP().split("-");
            ExpDay=Integer.parseInt(DateCompareSplit[0]);
            ExpMonth=Integer.parseInt(DateCompareSplit[1]);
            EXPYear=Integer.parseInt(DateCompareSplit[2]);
            RemainderDay=(int) ((ExpDay+ExpMonth*30+EXPYear*365)-AllDay);
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        
        if(RemainderDay<=60)
        {
            return true;
        }else return false;
        
        
        
        
    }
     public void ReadData()
     {
         
         productList=(ArrayList<ProductClass>)(Object) file.read(filePath);
     }

    @Override
    public boolean Add() {
       if(super.getID()==null)
             super.setID("");
         
         if(!super.getID().trim().equals(""))
         {
                super.setQueryFile(super.getID()+"@"
                        +super.getName()+"@"
                        +super.getLName()+"@"
                        +super.getQuantity() +"@"
                        +super.getParcode() +"@"
                        +super.getPrice() +"@"
                        +super.getCategory()+"@"
                        +super.getEXP());
                
                file.write(super.getQueryFile(), filePath, true);
                return true;
         }else
         {
              System.out.println("You must put an ID");
         }
       return false;
    
    }

    @Override
    public boolean Delete(Object ID, Object filePath) {
       return file.delete(ID.toString(), filePath.toString());
    }
    

    @Override
    public boolean Update(Object id, Object categ, Object newValue) {
        return file.update((String)id, filePath,(String)categ, newValue);
    }

   
}
