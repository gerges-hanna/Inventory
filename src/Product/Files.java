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
    // and it returns an ArrayList<> and that array contain every product
    public ArrayList<ProductClass> read(String filePath)
    {
        ArrayList<ProductClass> products = new ArrayList<>();
        ProductClass newProduct = new ProductClass();
        // id@name@quantity@parcode@price@category@EXP@
        try
        {
            Scanner in = new Scanner(new File(filePath));
            while(in.hasNext())
            {
                String tmp = in.nextLine();
                String []data = tmp.split("@");
                newProduct.setID(data[0]);
                newProduct.setName(data[1]);
                newProduct.setQuantity(Double.parseDouble(data[2].trim()));
                newProduct.setParcode(data[3]);
                newProduct.setPrice(Double.parseDouble(data[4].trim()));
                newProduct.setCategory(data[5]);
                newProduct.setEXP(data[6]);
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
