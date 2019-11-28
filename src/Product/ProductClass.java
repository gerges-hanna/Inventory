/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Product;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gerges hanna FCI-H
 */

//this class created by Gerges hanna
public class ProductClass extends FatherClass {
   public static ArrayList<ProductClass> productList = new ArrayList<ProductClass>();
   public static ArrayList<ProductClass> ReviewList = new ArrayList<ProductClass>();
   public static ArrayList<ProductClass> EXPList = new ArrayList<ProductClass>();
   public static DefaultTableModel TablePro = new DefaultTableModel();

    
    
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

    public String getDatesSell()
    {
        SimpleDateFormat s=new SimpleDateFormat("dd-MM-yyyy");
            Date d=new Date();
            String Date1=s.format(d);
       return Date1;
            
    }
    public String getTimeSell()
    {
        Calendar cal = Calendar.getInstance();
        Date date=cal.getTime();
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        String formattedDate=dateFormat.format(date);
        return formattedDate;
        
    }
       /*Function return 1 if Days Remainder to Expire is
         less than 60 Days otherwise return 0 and it save Days Remainder to exp
         in RemainderDay Attributs
         it's requre to enter Date Expire(Gerges)
       */
     public int ExpireRemainder(String EXP1)
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
            String[] DateCompareSplit=EXP1.split("-");
            ExpDay=Integer.parseInt(DateCompareSplit[0]);
            ExpMonth=Integer.parseInt(DateCompareSplit[1]);
            EXPYear=Integer.parseInt(DateCompareSplit[2]);
            RemainderDay=(int) ((ExpDay+ExpMonth*30+EXPYear*365)-AllDay);
            //System.out.println(DateDay+" "+DateMonth+" "+DateYear+" "+AllDay+" "+ExpDay+" "+ExpMonth+" "+EXPYear+" "+RemainderDay+" ");
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        
        return RemainderDay;
        
        
        
        
    }
     public void ReadData()
     {
         
         productList=(ArrayList<ProductClass>)(Object) file.read(filePath);
     }
     public void ReadSellReview()
     {
         
         ReviewList=(ArrayList<ProductClass>)(Object) file.read("sellReview.txt");
     }
      public int CalculateAllEXP()
      {
          for(int i=0;i<productList.size();i++)
          {
              
              int re=ExpireRemainder(productList.get(i).getEXP());
              System.out.println(re+" "+productList.get(i).getEXP()+" "+productList.size()+" "+i);
              if(re<=30)
              {
                  ProductClass x=new ProductClass();
                  //"ID","Name","Parcode","Quantity","Categorey","EXP After"
                  x.setName(productList.get(i).getName());
                  x.setID(productList.get(i).getID());
                  x.setParcode(productList.get(i).getParcode());
                  x.setQuantity(productList.get(i).getQuantity());
                  x.setCategory(productList.get(i).getCategory());
                  x.setEXP(re+"");
                  EXPList.add(x);
                 
              }
          }
          
          return EXPList.size();
          
      }
      public void listConvertToArray(String [][] items)
      {
          for (int i = 0; i < EXPList.size(); i++) {
                items[i][0]=EXPList.get(i).getID();
                items[i][1]=EXPList.get(i).getName();
                items[i][2]=EXPList.get(i).getParcode();
                items[i][3]=String.valueOf(EXPList.get(i).getQuantity());
                items[i][4]=EXPList.get(i).getCategory();
                items[i][5]=EXPList.get(i).getEXP();
          }
      }
      public DefaultTableModel setProductTable(String [][] items)
    {
        
        String [] ColumnsProduct={"ID","Name","LName","Quantity","Parcode","Price","Categorey","EXP"};
        TablePro.setColumnIdentifiers(ColumnsProduct);
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
                    TablePro.addRow(items[i]);
                
            
        }
          
          return TablePro;
    }

      public String CalculatePrice(String Quantity,double price)
      {
         return (Double.parseDouble(Quantity)*price)+"";
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
    public boolean Update(Object ID,Object b1){
        return file.update((String)ID, filePath,(String)b1);
    }

   
}
