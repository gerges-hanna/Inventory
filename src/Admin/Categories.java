/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin;

/**
 *
 * @author bebo
 */
public class Categories extends Product.FatherClass {
    private String CategoryDescription;
    private String Query;
    
    final private String filepath="Category.txt";//Final variable can't be modifed
    public String getCategoryDescription() {
        return CategoryDescription;
    }

    public void setCategoryDescription(String CategoryDescription) {
        this.CategoryDescription = CategoryDescription;
    }
    /*
    private double CategoryPrice;//this variable contain the whole Category price
    public double getCategoryPrice() {
        return CategoryPrice;
    }

    public void setCategoryPrice(int CategoryPrice) {
        this.CategoryPrice = CategoryPrice;
    }*/
    
    
    public void AddInFileCategory()
     {
      
             if( super.getCategory().trim() != null && !super.getCategory().trim().equals("")){
                 Query= super.getCategory() + "@" +CategoryDescription;
             
                super.setQueryFile(Query);
                file.write(Query, filepath, true);
           
             }
         else
         {
               System.out.println("You must put valid Category name");
                
         }
        
     }
    
}
