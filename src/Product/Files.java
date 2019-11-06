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
    
    // This function is for reading from a file by passing the absolute file path
    // and it returns an ArrayList<> and that array contains every product
    // Andrew Emad
    public ArrayList<FatherClass> read(String filePath)
    {
        FatherClass newF;
        ArrayList<FatherClass> reval = new ArrayList<>();
        
        newF= new ProductClass();
        // id@name@lastName@quantity@parcode@price@category@EXP@
        try
        {
            Scanner in = new Scanner(new File(filePath));
            while(in.hasNext())
            {
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
                reval.add(newF);
            }
            in.close();
        }
        catch(FileNotFoundException e)
        {
        
        }
        return reval;
    }
}
