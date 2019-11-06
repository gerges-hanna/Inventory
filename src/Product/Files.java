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
    public ArrayList<ProductClass> read(String filePath)
    {
        ArrayList<ProductClass> products = new ArrayList<>();
        ProductClass newProduct = new ProductClass();
        // id@name@lastName@quantity@parcode@price@category@EXP@
        try
        {
            Scanner in = new Scanner(new File(filePath));
            while(in.hasNext())
            {
                String tmp = in.nextLine();
                String []data = tmp.split("@");
                newProduct.setID(data[0]);
                newProduct.setName(data[1]);
                newProduct.setLName(data[2]);
                newProduct.setQuantity(Double.parseDouble(data[3].trim()));
                newProduct.setParcode(data[4]);
                newProduct.setPrice(Double.parseDouble(data[5].trim()));
                newProduct.setCategory(data[6]);
                newProduct.setEXP(data[7]);
                products.add(newProduct);
            }
            in.close();
        }
        catch(FileNotFoundException e)
        {
        
        }
        return products;
    }
}
