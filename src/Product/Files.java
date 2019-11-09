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
public class Files 
{
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
    // and it returns an ArrayList<> and that array contains every product
    // Andrew Emad
    public ArrayList<Object> read(String filePath)
    {
        ArrayList<FatherClass> reval = new ArrayList<>();
        try
        {
            Scanner in = new Scanner(new File(filePath));
            if(filePath.equals("Supplier.txt"))
            {
                // ID@Name@LName@SupplierAddress@ContactNumber@SupplierEmail@Category@
                while(in.hasNext())
                {
                    Suppliers newSup = new Suppliers();
                    String tmp = in.nextLine();
                    String []data = tmp.split("@");
                    newSup.setID(data[0]);
                    newSup.setName(data[1]);
                    newSup.setLName(data[2]);
                    newSup.setSupplierAddress(data[3]);
                    newSup.setContactNumber(Integer.parseInt(data[4].trim()));
                    newSup.setSupplierEmail(data[5]);
                    newSup.setCategory(data[6]);
                    reval.add((Suppliers) newSup);
                }
            }
            else if(filePath.equals("Products.txt"))
            {
                // id@name@lastName@quantity@parcode@price@category@EXP@
                while(in.hasNext())
                {
                    FatherClass newF;
                    newF= new ProductClass();
                    String tmp = in.nextLine();
                    String []data = tmp.split("@");
                    newF.setID(data[0]);
                    newF.setName(data[1]);
                    newF.setLName(data[2]);
                    newF.setQuantity(Double.parseDouble(data[3].trim()));
                    newF.setParcode(data[4]);
                    newF.setPrice(Double.parseDouble(data[5].trim()));
                    newF.setCategory(data[6]);
                    newF.setEXP(data[7]);
                    reval.add((ProductClass) newF);
                }
            }
            in.close();
        }
        catch(FileNotFoundException e)
        {
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
            FatherClass updating = null;
            String checkID;
            for(int i = 0; i < pros.size(); i++)
            {
                if(((FatherClass)pros.get(i)).getID().equals(id))
                {
                    updating = (ProductClass)pros.get(i);
                    break;
                }
            }
            if(updating == null)
                return false;
            switch(categ)
            {
                // id@name@lastName@quantity@parcode@price@category@EXP@
                case "name":
                    updating.setName(newValue.toString());
                    break;
                case "lastName":
                    updating.setLName(newValue.toString());
                    break;
                case "quantity":
                    updating.setQuantity(Double.parseDouble(
                            newValue.toString().trim()));
                    break;
                case "parcode":
                    updating.setParcode(newValue.toString());
                    break;
                case "price":
                    updating.setPrice(Double.parseDouble(
                            newValue.toString().trim()));
                    break;
                case "categ":
                    updating.setCategory(newValue.toString());
                    break;
                case "exp":
                    updating.setEXP(newValue.toString());
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
                if(checkID.equals(updating.getID()))
                {
                    Query = updating.getID()+"@"+updating.
                            getName()+"@"+updating.getLName()+"@"
                            +Double.toString(updating.getQuantity())+"@"+
                            updating.getParcode()+"@"+Double.toString
                            (updating.getPrice())+"@"+updating.
                            getCategory()+"@"+updating.getEXP()+"@";

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
            Suppliers updating = null;
            String checkID;
            for(int i = 0; i < pros.size(); i++)
            {
                if(((FatherClass)pros.get(i)).getID().equals(id))
                {
                    updating = (Suppliers)pros.get(i);
                    break;
                }
            }
            if(updating == null)
                return false;
            switch(categ)
            {
                // ID@Name@LName@SupplierAddress@ContactNumber@SupplierEmail@Category
                case "name":
                    updating.setName(newValue.toString());
                    break;
                case "lastName":
                    updating.setLName(newValue.toString());
                    break;
                case "supplierAddress":
                    updating.setSupplierAddress(newValue.toString());
                    break;
                case "contactNumber":
                    updating.setContactNumber(Integer.parseInt(newValue.toString
                    ().trim()));
                    break;
                case "supplierEmail":
                    updating.setSupplierEmail(newValue.toString());
                    break;
                case "category":
                    updating.setCategory(newValue.toString());
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
                if(checkID.equals(updating.getID()))
                {
                    Query = updating.getID()+"@"+updating.
                            getName()+"@"+updating.getLName()+"@"
                            +updating.getSupplierAddress()+"@"+
                            Integer.toString(updating.getContactNumber())+"@"+
                            updating.getSupplierEmail()+"@"+updating.getCategory
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
}
