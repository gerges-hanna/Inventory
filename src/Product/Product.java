
package ProjectPackage;

import java.time.format.*;
import java.time.LocalDateTime;
public class Product 
{
    private int ID;
    private String type;
    private String name;
    private String expireDate;
    private String productionDate;
    private int quantity;
    private int price;

    public Product(int ID, String type, String name, int quantity, String expireDate, String productionDate, int price) {
        this.ID = ID;
        this.type = type;
        this.name = name;
        this.quantity = quantity;
        this.expireDate = expireDate;
        this.productionDate = productionDate;
        this.price = price;
    }
    public Product()
    {
        
    }
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }

    public String getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(String productionDate) {
        this.productionDate = productionDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public boolean isExpired()
    {
        DateTimeFormatter dtfY = DateTimeFormatter.ofPattern("yyyy");
        DateTimeFormatter dtfM = DateTimeFormatter.ofPattern("MM");
        DateTimeFormatter dtfD = DateTimeFormatter.ofPattern("dd");
        
        LocalDateTime nowY = LocalDateTime.now();
        LocalDateTime nowM = LocalDateTime.now();
        LocalDateTime nowD = LocalDateTime.now();
        
        int thisPY, thisPD, thisPM;
        thisPY = Integer.parseInt(expireDate.substring(0, 4).trim());
        thisPD = Integer.parseInt(expireDate.substring(8, 10).trim());
        thisPM = Integer.parseInt(expireDate.substring(5, 7).trim());
        
        if(thisPY < Integer.parseInt(dtfY.format(nowY).trim()))
        {
            return true;
        }
        else if(thisPY == Integer.parseInt(dtfY.format(nowY).trim()) &&
                thisPM < Integer.parseInt(dtfM.format(nowM).trim()))
        {
            return true;
        }
        else if(thisPY == Integer.parseInt(dtfY.format(nowY).trim()) &&
                thisPM == Integer.parseInt(dtfM.format(nowM).trim()) &&
                thisPD <= Integer.parseInt(dtfD.format(nowD).trim()))
        {
            return true;
        }
        else return false;
    }
    public boolean isLow()
    {
        return this.quantity < 10;
    }
}
