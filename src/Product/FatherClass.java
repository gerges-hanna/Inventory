/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Product;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import Admin.*;
import static jdk.nashorn.internal.runtime.Debug.id;

/**
 *
 * @author Gerges hanna FCI-H
 */
// this class Created By Gerges Hanna
public abstract class FatherClass {
    private String ID="";
    private String Pro_ID;
    private String Oper_ID;
    private String Name;
    private String LName;
    private String QueryFile; 
    private int Quantity;
    private String Parcode;
    private double price;
    private String Category;
    private String CategoryDescription;
    private String EXP;
    static private String type;
    private String SupplierAddress;
    private int ContactNumber;
    private String SupplierEmail;
    private static int IDlog=0;
    private String date;
    private String time;

    public String getPro_ID() {
        return Pro_ID;
    }

    public void setPro_ID(String Pro_ID) {
        this.Pro_ID = Pro_ID;
    }

    public String getOper_ID() {
        return Oper_ID;
    }

    public void setOper_ID(String Oper_ID) {
        this.Oper_ID = Oper_ID;
    }
    
    
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public static int getIDlog() {
        return IDlog;
    }

    public static void setIDlog(int IDlog) {
        FatherClass.IDlog = IDlog;
    }
    

    public String getSupplierAddress() {
        return SupplierAddress;
    }

    public void setSupplierAddress(String SupplierAddress) {
        this.SupplierAddress = SupplierAddress;
    }

    public int getContactNumber() {
        return ContactNumber;
    }

    public void setContactNumber(int ContactNumber) {
        this.ContactNumber = ContactNumber;
    }

    public String getSupplierEmail() {
        return SupplierEmail;
    }

    public void setSupplierEmail(String SupplierEmail) {
        this.SupplierEmail = SupplierEmail;
    }
    

    public Files file=new Files();
    
    public FatherClass(String ID, String Name, String LName, int Quantity, String Parcode, double price, String Category, String EXP) {
        this.ID = ID;
        this.Name = Name;
        this.LName = LName;
        this.Quantity = Quantity;
        this.Parcode = Parcode;
        this.price = price;
        this.Category = Category;
        this.EXP = EXP;
    }

    
    public FatherClass(String ID, String Name, int Quantity, String Parcode, double price, String Category, String EXP) {
        this.ID = ID;
        this.Name = Name;
        this.Quantity = Quantity;
        this.Parcode = Parcode;
        this.price = price;
        this.Category = Category;
        this.EXP = EXP;
    }
    

    public static String getType() {
        return type;
    }

    public static void setType(String type) {
        FatherClass.type = type;
    }
    
    
   
    
    public String getQueryFile() {
        return QueryFile;
    }

    public void setQueryFile(String QueryFile) {
        this.QueryFile = QueryFile;
    }

    public String getLName() {
        return LName;
    }

    public void setLName(String LName) {
        this.LName = LName;
    }
    
    public String getCategory() {
        return Category;
    }

    public void setCategory(String Category) {
        this.Category=Category;
     /* Categories c=new Categories();
      c.ReadData();
      int check=0;
      for(int i=0;i<c.categorylist.size();i++)
      {
        if(!Category.equals(c.categorylist.get(i).getCategory()))
        {
        this.Category = Category;
        check++;
        }
      }
      if (check!=0)
      {
          System.out.println("Category already exists");
      }
     */
    }

    public String getEXP() {
        return EXP;
    }

    public void setEXP(String EXP) {
        this.EXP = EXP;
    }

    

    

    public FatherClass() {
    }
    
    

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public String getParcode() {
        return Parcode;
    }

    public void setParcode(String Parcode) {
        this.Parcode = Parcode;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    public void setCategoryDescription(String CategoryDescription) {
        this.CategoryDescription = CategoryDescription;
    }
     public String getCategoryDescription() {
        return CategoryDescription;
    }
    public abstract boolean Add();
    public abstract boolean Delete(Object b1,Object b2);
    public abstract boolean Update(Object ID,Object b1);
       
}
