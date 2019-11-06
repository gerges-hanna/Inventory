/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Product;

/**
 *
 * @author Gerges hanna FCI-H
 */
// this class Created By Gerges Hanna
public class FatherClass {
    private String ID;
    private String Name;
    private String LName;

    public String getLName() {
        return LName;
    }

    public void setLName(String LName) {
        this.LName = LName;
    }
    private double Quantity;
    private String Parcode;
    private double price;
    private String Category;
    private String EXP;

    

    
    public FatherClass(String ID, String Name, double Quantity, String Parcode, double price, String Category, String EXP) {
        this.ID = ID;
        this.Name = Name;
        this.Quantity = Quantity;
        this.Parcode = Parcode;
        this.price = price;
        this.Category = Category;
        this.EXP = EXP;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String Category) {
        this.Category = Category;
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

    public double getQuantity() {
        return Quantity;
    }

    public void setQuantity(double Quantity) {
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
    
    
}
