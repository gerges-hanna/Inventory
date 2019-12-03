/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory;

import Product.*;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author bebo
 */
public class Login extends Product.FatherClass{
    //Note: our pharmacy name's Hope
    public ArrayList<Login> LoginList = new ArrayList<Login>();
    private final String Admin_UserName="HopeAdmin";
    private final String Admin_Password="Hope4321";
    //The two variables can't be modifed 
    public void ForgetPassword(String UserName)//this function takes username as a parameter and return password if found
    {
        if(UserName.equals(Admin_UserName))
        {
        System.out.println("Your Password is:"+Admin_Password);
        }
        else 
        {
            System.out.println("Invalid UserName ");
        }
    }
    //User&Client part
    private final String filepath="Login.txt";
    private String UserName;
    private String Password;
    private String Case;//Note:cases are user or client only
    private int Order=0;

    public int getOrder() {
        return Order;
    }

    public void setOrder(int Order) {
        this.Order = Order;
    }

    public String getAdmin_UserName() {
        return Admin_UserName;
    }

    public String getAdmin_Password() {
        return Admin_Password;
    }
    
    
    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {//entered usernames  must be between 4 and 8 characters
        if(UserName==null)
        {
            UserName="";
        }
        else 
        {
                 this.UserName = UserName;
        }
        
    }

    public String getPassword() {
        return Password;
    }

   public void setPassword(String Password) {//entered passwords must be between 4 and 8 characters
        if(Password==null)
         {
           Password="";
         }
        else 
        {
                 this.Password = Password;
        }
    
    }

    public String getCase() {
        return Case;
    }

    public void setCase(String Case) {
        if(Case==null)
        {
            Case="";
        }
        
        else      
        {
            this.Case = Case;
        }
       
        
    }

    private void IncreamentID()
    {
        LoginList=(ArrayList<Login>)(Object) file.read(filepath);
        int size=LoginList.size();
        if(size!=0){Order=LoginList.get(size-1).getOrder()+1;}   
    }
  



    @Override
    public boolean Add() {
        
               if(getUserName()==null)
     {
         setUserName("");
     }
     else if(getPassword()==null)
     {
         setPassword("");
     }
     else if(getCase()==null)
     {
         setCase("");
     }
     else if(getName()==null)
     {
         setName("");
     }
   
    
        IncreamentID();
        //****************************************

        if( !getUserName().equals("") && 
                !getPassword().trim().equals("") && 
                !getCase().equals(""))
        {

            setQueryFile(Order+";"+UserName+";"+Password+";"+Case+";"+super.getName()+";"+super.getContactNumber());


            file.write(super.getQueryFile(), filepath, true);
            UserName=null;
            Password=null;
            super.setName(null);
            super.setContactNumber(0);
            
            return true;
        }
        else {
            System.out.print("you must enter a valid username,password and case\n");
        }
        return false;
    }

    @Override
    public boolean Delete(Object b1, Object b2) {
        return false;
       
    }

    @Override
    public boolean Update(Object ID,Object b1){
        return file.update((String)ID, filepath,(String)b1);
    }

public void ReadData()//read data from filepath and return it as an array list
     {
        LoginList=(ArrayList<Login>)(Object) file.read(filepath);
     }


public boolean Checker(String username, String password,String Case)//this function takes username&password and return true if found 
{
    ReadData();
    for(int i=0;i<LoginList.size();i++)
    {
        if(LoginList.get(i).getUserName().equals(username)&&
                LoginList.get(i).getPassword().equals(password)&&
                LoginList.get(i).getCase().equalsIgnoreCase(Case))
        {
            setOrder(LoginList.get(i).getOrder());
            return true;
        }
      
    }
    return false;
}
}   