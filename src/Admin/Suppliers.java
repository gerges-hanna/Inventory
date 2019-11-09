/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin;
/**
 *
 * @author Bebo
 */
public class Suppliers extends Product.FatherClass{
    private String SupplierAddress;
    private int ContactNumber;
    private String SupplierEmail;

    private String Query;
    final private String filepath="Supplier.txt";//Final variable can't be modifed

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

//Supplier Query:ID@Name@LName@SupplierAddress@ContactNumber@SupplierEmail@Category
  public void AddInFileSupplier()
     {
         if(super.getID().trim()!=null && !super.getID().trim().equals(""))
         {
             Query= super.getID()+"@"+super.getName()+"@"+super.getLName()
                +"@"+SupplierAddress+"@"+ContactNumber+"@"+
                SupplierEmail+"@"+super.getCategory();
             
                super.setQueryFile(Query);
                file.write(Query, filepath, true);
         }else
         {
              System.out.println("You must put an ID");
         }
        
     }
}
