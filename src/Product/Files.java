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
import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;
import Admin.*;
import inventory.*;
public class Files 
{
   FatherClass fatherClass; 
    // This function is for writing on the file
    // Query is the string that you want to add on the file
    // filePath is the path to the file
    // Append is a boolean variable, if it's true then this function will
    // will append the file and leave the old text untouched
    // if it's false then this function will delete everything in the file and
    // write the query on a new flat white text
    public boolean write(String Query,String filePath ,boolean Append)
    {
        PrintWriter writer=null;
        try {
            System.out.println("Writing Now In .."+filePath);
            writer=new PrintWriter(new FileWriter(new File(filePath),Append));
            writer.println(Query);
            System.out.println("Writing Done");
            return true;
        } catch (IOException e) {
            System.out.println(e);
        }finally
        {
            if(writer !=null)
                writer.close();
        }
        return false;
    }
    
    // This function is for reading from a file by passing the absolute file path
    // and it returns an ArrayList<> of what file contains
    // Andrew Emad
    
    // PLEASE READ THIS
    // If you used any of the editing function(update or addIn*)
    // please use this function again, non of function above
    // refreshes the array list so you have to refresh it manually by
    // calling this function again
    public ArrayList<Object> read(String filePath)
    {
        ArrayList<Object> reval = new ArrayList<>();
        try
        {
            Scanner in = new Scanner(new File(filePath));
            switch (filePath)
            {
                case "Supplier.txt":
                    // ID@Name@LName@SupplierAddress@ContactNumber@SupplierEmail@Category@
                    while(in.hasNext())
                    {
                        fatherClass= new Suppliers();
                        String tmp = in.nextLine();
                        String []data = tmp.split("@");
                        fatherClass.setID(data[0]);
                        fatherClass.setName(data[1]);
                        fatherClass.setLName(data[2]);
                        fatherClass.setSupplierAddress(data[3]);
                        fatherClass.setContactNumber(Integer.parseInt(data[4].trim()));
                        fatherClass.setSupplierEmail(data[5]);
                        fatherClass.setCategory(data[6]);
                        reval.add(fatherClass);
                    }   
                    break;
                case "Product.txt":
                    // id@name@lastName@quantity@parcode@price@category@EXP@
                    while(in.hasNext())
                    {
                        fatherClass= new ProductClass();
                        String tmp = in.nextLine();
                        String []data = tmp.split("@");
                        fatherClass.setID(data[0]);
                        fatherClass.setName(data[1]);
                        fatherClass.setLName(data[2]);
                        fatherClass.setQuantity(Integer.parseInt(data[3].trim()));
                        fatherClass.setParcode(data[4]);
                        fatherClass.setPrice(Double.parseDouble(data[5].trim()));
                        fatherClass.setCategory(data[6]);
                        fatherClass.setEXP(data[7]);
                        reval.add(fatherClass);
                    }   break;
                case "Login.txt":
                    // Order;userName;password;case;
                    while(in.hasNext())
                    {
                        Login newLog = new Login();
                        String tmp = in.nextLine();
                        String []data = tmp.split(";");
                        newLog.setOrder(Integer.parseInt(data[0].trim()));
                        newLog.setUserName(data[1]);
                        newLog.setPassword(data[2]);
                        newLog.setCase(data[3]);
                        reval.add(newLog);
                    }
                    break;
                default:
                    break;
            }
            in.close();
        }
        catch(FileNotFoundException e)
        {
            System.out.println(e);
        }
        return (ArrayList<Object>)(Object) reval;
    }
    
    /*
        This function is for updating data in a file by passing the id of the
        the data that you want to edit and the absolute file path and the type
        of what is it that you want to edit and the new value of it
        
        this function uses write function to write on the file
    */
    // Andrew Emad
    public boolean update(String id, String filePath, String categ, Object newValue)
    {
        ArrayList<Object> pros = read(filePath);
        if(filePath.equals("Products.txt"))
        {
            fatherClass=new ProductClass();
            String checkID;
            for(int i = 0; i < pros.size(); i++)
            {
                if(((FatherClass)pros.get(i)).getID().equals(id))
                {
                    fatherClass = (ProductClass)pros.get(i);
                    break;
                }
            }
            if(fatherClass == null)
                return false;
            switch(categ)
            {
                // id@name@lastName@quantity@parcode@price@category@EXP@
                case "Name":
                    fatherClass.setName(newValue.toString());
                    break;
                case "LName":
                    fatherClass.setLName(newValue.toString());
                    break;
                case "Quantity":
                    fatherClass.setQuantity(Integer.parseInt(
                            newValue.toString().trim()));
                    break;
                case "Parcode":
                    fatherClass.setParcode(newValue.toString());
                    break;
                case "Price":
                    fatherClass.setPrice(Double.parseDouble(
                            newValue.toString().trim()));
                    break;
                case "Category":
                    fatherClass.setCategory(newValue.toString());
                    break;
                case "EXP":
                    fatherClass.setEXP(newValue.toString());
                    break;
                default: 
                    pros.clear();
                    return false;
            }
            for(int i = 0; i < pros.size(); i++)
            {
                boolean append = false;
                String Query;
                FatherClass s = (FatherClass)pros.get(i);
                checkID = s.getID();
                if(checkID.equals(fatherClass.getID()))
                {
                    Query = fatherClass.getID()+"@"+fatherClass.
                            getName()+"@"+fatherClass.getLName()+"@"
                            +Double.toString(fatherClass.getQuantity())+"@"+
                            fatherClass.getParcode()+"@"+Double.toString
                            (fatherClass.getPrice())+"@"+fatherClass.
                            getCategory()+"@"+fatherClass.getEXP()+"@";

                }
                else
                {
                    Query = ((FatherClass)pros.get(i)).getID()+"@"+
                            ((FatherClass)pros.get(i)).getName()+"@"+
                            ((FatherClass)pros.get(i)).getLName()+"@"+
                            Double.toString(((FatherClass)pros.get(i)).
                            getQuantity())+"@"+((FatherClass)pros.get(i)).
                            getParcode()+"@"+Double.toString(((FatherClass)pros.
                            get(i)).getPrice())+"@"+((FatherClass)pros.get(i))
                            .getCategory()+"@"+((FatherClass)pros.get(i)).
                            getEXP()+"@";
                }
                if(i > 0)
                    append = true;
                write(Query, filePath, append);
            }
        }
        else if(filePath.equals("Supplier.txt"))
        {
            fatherClass=new Suppliers();
            String checkID;
            for(int i = 0; i < pros.size(); i++)
            {
                if(((FatherClass)pros.get(i)).getID().equals(id))
                {
                    fatherClass = (Suppliers)pros.get(i);
                    break;
                }
            }
            if(fatherClass == null)
                return false;
            switch(categ)
            {
                // ID@Name@LName@SupplierAddress@ContactNumber@SupplierEmail@Category
                case "Name":
                    fatherClass.setName(newValue.toString());
                    break;
                case "LName":
                    fatherClass.setLName(newValue.toString());
                    break;
                case "SupplierAddress":
                    fatherClass.setSupplierAddress(newValue.toString());
                    break;
                case "ContactNumber":
                    fatherClass.setContactNumber(Integer.parseInt(newValue.toString
                    ().trim()));
                    break;
                case "SupplierEmail":
                    fatherClass.setSupplierEmail(newValue.toString());
                    break;
                case "Category":
                    fatherClass.setCategory(newValue.toString());
                    break;
                default: 
                    pros.clear();
                    return false;
            }
            for(int i = 0; i < pros.size(); i++)
            {
                // ID@Name@LName@SupplierAddress@ContactNumber@SupplierEmail@Category
                boolean append = false;
                String Query;
                FatherClass s = (FatherClass)pros.get(i);
                checkID = s.getID();
                if(checkID.equals(fatherClass.getID()))
                {
                    Query = fatherClass.getID()+"@"+fatherClass.
                            getName()+"@"+fatherClass.getLName()+"@"
                            +fatherClass.getSupplierAddress()+"@"+
                            Integer.toString(fatherClass.getContactNumber())+"@"+
                            fatherClass.getSupplierEmail()+"@"+fatherClass.getCategory
                            ()+"@";

                }
                else
                {
                    Query = ((Suppliers)pros.get(i)).getID()+"@"+
                            ((Suppliers)pros.get(i)).getName()+"@"+
                            ((Suppliers)pros.get(i)).getLName()+"@"+
                            ((Suppliers)pros.get(i)).getSupplierAddress()+"@"+
                            Integer.toString(((Suppliers)pros.get(i)).
                            getContactNumber())+"@"+((Suppliers)pros.get(i)).
                            getSupplierEmail()+"@"+((Suppliers)pros.get(i)).
                            getCategory()+"@";
                            
                }
                if(i > 0)
                    append = true;
                write(Query, filePath, append);
            }
        }
        return true;
    }
    public boolean delete(String id, String filePath)
    {
        ArrayList<Object> pros = read(filePath);
        boolean append = false;
        String Query;
        switch(filePath)
        {
            case "Product.txt":
                for(int i = 0; i < pros.size(); i++)
                {
                    if(((ProductClass)pros.get(i)).getID().equals(id))
                    {
                        continue;
                    }
                    else
                    {
                        Query = ((FatherClass)pros.get(i)).getID()+"@"+
                            ((FatherClass)pros.get(i)).getName()+"@"+
                            ((FatherClass)pros.get(i)).getLName()+"@"+
                            Integer.toString(((FatherClass)pros.get(i)).
                            getQuantity())+"@"+((FatherClass)pros.get(i)).
                            getParcode()+"@"+Double.toString(((FatherClass)pros.
                            get(i)).getPrice())+"@"+((FatherClass)pros.get(i))
                            .getCategory()+"@"+((FatherClass)pros.get(i)).
                            getEXP()+"@";
                        
                    }
                    write(Query, filePath, append);
                    append = true;
                }
                break;
            case "Category.txt":
                for(int i = 0; i < pros.size(); i++)
                {
                    if(((Admin.Categories)pros.get(i)).getCategory().equals(id))
                        continue;
                    else
                    {
                        Query = ((Admin.Categories)pros.get(i)).getCategory() + "@"
                                + ((Admin.Categories)pros.get(i)).getCategoryDescription() + "@";
                    }
                    write(Query, filePath, append);
                    append = true;
                }
                break;
            case "Supplier.txt":
            //Supplier Query:ID@Name@LName@SupplierAddress@ContactNumber@SupplierEmail@Category
                for(int i = 0; i < pros.size(); i++)
                {
                    if( ((Admin.Suppliers)pros.get(i)).getID().equals(id))
                        continue;
                    else
                    {
                        Query = ((Admin.Suppliers)pros.get(i)).getID() + "@" +
                                ((Admin.Suppliers)pros.get(i)).getName() + "@"+
                                ((Admin.Suppliers)pros.get(i)).getLName() + "@" +
                                ((Admin.Suppliers)pros.get(i)).getSupplierAddress()
                                + "@" + ((Admin.Suppliers)pros.get(i)).getContactNumber()
                                + "@" + ((Admin.Suppliers)pros.get(i)).getSupplierEmail()
                                + "@" + ((Admin.Suppliers)pros.get(i)).getCategory() + "@";
                    }
                    write(Query, filePath, append);
                    append = true;
                }
        }
        return true;
    }
}
