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
public class Files 
{
    public boolean write(String Query,String filePath ,boolean Append)
    {
        PrintWriter writer=null;
        try {
            System.out.println("Writing Now In .."+filePath);
            writer=new PrintWriter(new FileWriter(new File(filePath),Append));
            writer.println(Query);
            System.out.println("Write Done");
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
        ArrayList<ProductClass> reval = new ArrayList<ProductClass>();
        // id@name@lastName@quantity@parcode@price@category@EXP@
        try
        {
            Scanner in = new Scanner(new File(filePath));
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
        FatherClass updatingProduct = null;
        String checkID;
        for(int i = 0; i < pros.size(); i++)
        {
            FatherClass s = (FatherClass)pros.get(i);
            checkID = s.getID();
            if(checkID.equals(id))
            {
                updatingProduct = (FatherClass)pros.get(i);
            }
        }
        if(updatingProduct != null)
        {
            switch(categ)
            {
                case "name":
                    updatingProduct.setName(newValue.toString());
                    break;
                case "lastName":
                    updatingProduct.setLName(newValue.toString());
                    break;
                case "quantity":
                    updatingProduct.setQuantity(Double.parseDouble(
                            newValue.toString().trim()));
                    break;
                case "parcode":
                    updatingProduct.setParcode(newValue.toString());
                    break;
                case "price":
                    updatingProduct.setPrice(Double.parseDouble(
                            newValue.toString().trim()));
                    break;
                case "categ":
                    updatingProduct.setCategory(newValue.toString());
                    break;
                case "exp":
                    updatingProduct.setEXP(newValue.toString());
                    break;
                default: 
                    pros.clear();
                    return false;
            }
            for(int i = 0; i < pros.size(); i++)
            {
                // id@name@lastName@quantity@parcode@price@category@EXP@
                boolean append = false;
                String Query;
                FatherClass s = (FatherClass)pros.get(i);
                checkID = s.getID();
                if(checkID.equals(updatingProduct.getID()))
                {
                    Query = updatingProduct.getID()+"@"+updatingProduct.
                            getName()+"@"+updatingProduct.getLName()+"@"
                            +Double.toString(updatingProduct.getQuantity())+"@"+
                            updatingProduct.getParcode()+"@"+Double.toString
                            (updatingProduct.getPrice())+"@"+updatingProduct.
                            getCategory()+"@"+updatingProduct.getEXP()+"@";
                            
                }
                else
                {
                    Query = ((FatherClass)pros.get(i)).getID()+"@"+
                            ((FatherClass)pros.get(i)).getName()+"@"+
                            ((FatherClass)pros.get(i)).getLName()+"@"+
                            Double.toString(((FatherClass)pros.get(i)).
                            getQuantity())+"@"+((FatherClass)pros.get(i)).
                            getParcode()+"@"+Double.toString(((FatherClass)pros.get(i)).
                            getPrice())+"@"+((FatherClass)pros.get(i))
                            .getCategory()+"@"+((FatherClass)pros.get(i)).
                            getEXP()+"@";
                }
                if(i > 0)
                    append = true;
                write(Query, filePath, append);
            }
            return true;
        }
        else
            return false;
    }
}
