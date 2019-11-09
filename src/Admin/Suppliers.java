/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin;
import Product.Files;//To use Files Class
/**
 *
 * @author Bebo
 */
public class Suppliers extends Product.FatherClass{
    private String SupplierAddress;
    private int ContactNumber;
    private String SupplierEmail;
    private String category;
    private String Query;
    final private String filepath="/Users/salib/file/Supplier.txt";//Final variable can't be modifed

    public String getcategory() {
        return category;
    }

    public void setcategory(String Category) {
        this.category = Category;
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
Files obj1=new Files();//obj1 from file class
//Supplier Query:ID@Name@lastname@Address@contact_number@Email@category
  public void AddInFileSupplier()
     {
         if(super.getID().trim()!=null || super.getID().trim().equals(""))
         {
             Query= super.getID()+"@"+super.getName()+"@"+super.getLName()
                +"@"+SupplierAddress+"@"+ContactNumber+"@"+
                SupplierEmail+"@"+super.getCategory();
             
                super.setQueryFile(Query);
                obj1.write(Query, filepath, true);
         }else
         {
              System.out.println("You must put ID");
         }
        
     }
}
