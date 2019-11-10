/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory;

import Product.ProductClass;
import java.util.ArrayList;

/**
 *
 * @author bebo
 */
public class Login extends Product.FatherClass {
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
    

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {//entered usernames  must be between 4 and 8 characters
  if(UserName.equals("")||(
          UserName.length()>=4    && 
          UserName.length()<=8     && 
          UserName.charAt(0)!='@' && 
          UserName.charAt(0)!='-' && 
          UserName.charAt(0)!='+' && 
          UserName.charAt(0)!='=' &&
          UserName.charAt(0)!='~' &&
          UserName.charAt(0)!='$'  ))
        {
        this.UserName = UserName;
        }
        else 
        {
            System.out.println("Username must be between 4-8 characters and not "
                    + "starting with (@,-,+,=,~,$) ");
      
        }
    }

    public String getPassword() {
        return Password;
    }

   public void setPassword(String Password) {//entered passwords must be between 4 and 8 characters
        if(Password.equals("")||
        (Password.length()>=4&&Password.length()<=8 && 
         Password.charAt(0)!='@' &&
         Password.charAt(0)!='~' &&
         Password.charAt(0)!='-' &&
         Password.charAt(0)!='+' &&
         Password.charAt(0)!='=' &&
         Password.charAt(0)!='$'))
        {
        this.Password = Password;
        }
        else 
        {
            System.out.println("Password must be between 4-8 characters and not starting with (@,-,+,=,~,$) ");
        }
    
    }

    public String getCase() {
        return Case;
    }

    public void setCase(String Case) {
        if(Case.equals("")||(Case.equals("user")||Case.equals("client")))
        {
        this.Case = Case;
        }
        else      
        {
            System.out.println("Enter a valid regiester case (user&client)");
        }
       
        
    }
    private void IncreamentID()
    {
        LoginList=(ArrayList<Login>)(Object) file.read(filepath);
        int size=LoginList.size();
        if(size!=0){Order=LoginList.get(size-1).getOrder()+1;}   
    }
  
public void AddInFileLogin()
{
    if(getUserName()==null)
    {
        setUserName("");
    }else if(getPassword()==null)
    {
        setPassword("");
    }
    else if(getCase()==null)
    {
        setCase("");
    }
    
    IncreamentID();
    //****************************************
    
    if( !getUserName().equals("") && 
            !getPassword().trim().equals("") && 
            !getCase().equals(""))
    {

        setQueryFile(Order+";"+UserName+";"+Password+";"+Case);


        file.write(super.getQueryFile(), filepath, true);
        
    }
    else {
        System.out.print("you must enter a valid username,password and case");
    }
}
//Waiting reading function***************************************
}
