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
public class ClientClass extends Product.FatherClass{
    private String address;
    private String phoneNum;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
    // first to read the full data of the customer ....ID,Name,LName,Address,PhoneNum!!
    
    
}
