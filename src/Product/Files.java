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
}
