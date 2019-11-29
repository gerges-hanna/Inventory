/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;
import Product.ImportannFunctions;
import inventory.Login;
import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author Paula Samir
 */
public class ClientClass extends inventory.Login{
    
    public static ArrayList<ClientClass> productList = new ArrayList<ClientClass>();
    
    Login log = new Login();
    
    private String address;
    private int PhoneNumber;
    private String Email;
    private String ID="";
    private String Name;
    private String LName;
    private String pass;
    private String confpass;

    public String getConfpass() {
        return confpass;
    }

    public void setConfpass(String confpass) {
        this.confpass = confpass;
    }

    public ClientClass() {
    }
    
    
    private final String filePath= "Products.txt";

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

    public String getLName() {
        return LName;
    }

    public void setLName(String LName) {
        this.LName = LName;
    }
    

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public int getPhoneNummber() {
        return PhoneNumber;
    }

    public void setPhoneNum(int PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ClientClass(String address, int PhoneNumber, String Email, String Name, String pass,String confpass) {
        this.address = address;
        this.PhoneNumber = PhoneNumber;
        this.Email = Email;
        this.Name = Name;
        this.pass = pass;
        this.confpass=confpass;
        
    }
    
    
    public String Checkpass(){
        if(pass==confpass)
        {
        return pass;
        }
        else  {
            System.out.println("Password Doesn't Match...");
        }
        return Checkpass();
    }
        
    
    
    public void ReadProductFile(){
        if (super.getID()==null)
        {
            super.setID(""); 
        }
        else if(super.equals(ID))
        {
             
        }
            
        else {
            System.out.println("Enter Valid ID!!");
        }
    }
    
     public void ReadProducts()
     {
         
         productList=(ArrayList<ClientClass>)(Object) file.read(filePath);
     }
     
     
}
