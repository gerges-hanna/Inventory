/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin;

import Product.*;
import java.util.ArrayList;

public class GraphClass
{
    private final Files f = new Files();
    private final ArrayList<Integer> categoryQuantities;
    private final ArrayList<String> categoryNames;
    public GraphClass()
    {
        ArrayList<Object> dataReaded = f.read("sellReview.txt");
        categoryQuantities = new ArrayList<>();
        categoryNames = new ArrayList<>();
        for(int i = 0; i < dataReaded.size(); i++)
        {
            int x = ((FatherClass)dataReaded.get(i)).getQuantity();
            String x2 = ((FatherClass)dataReaded.get(i)).getCategory();
            categoryQuantities.add(x);
            categoryNames.add(x2);
        }
    }

    public ArrayList<Integer> getCategoryQuantities()
    {
        return categoryQuantities;
    }
    public ArrayList<String> getCategoryNames()
    {
        return categoryNames;
    }
}
