/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

/**
 *
 * @author Paula Samir
 */
public class ClientClass extends inventory.Login {
    private String address;
    private Long phoneNum;
    private String Email;
    private String ID="";
    private String Name;
    private String LName;

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

    public Long getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(Long phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ClientClass(String address, Long phoneNum, String Email, String Name, String LName) {
        this.address = address;
        this.phoneNum = phoneNum;
        this.Email = Email;
        this.Name = Name;
        this.LName = LName;
    }
    
    

    
    
}
