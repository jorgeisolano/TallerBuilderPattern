
package co.unicauca.restaurant.italian;

import co.unicauca.restaurant.oriental.*;
import co.unicauca.restaurant.domain.Dish;
import co.unicauca.restaurant.domain.Product;
import co.unicauca.restaurant.domain.Size;
import java.util.List;
import java.util.Vector;

public class ItalianDish extends Dish{
    
    private Product base;
    private List<Product> myOptions;
    private Size size;

    ItalianDish(double p) {
        this.price = p;
        myOptions = new Vector<>();
    }

    void setBase(Product base) {
        this.base = base; 
    }

    void addOption(Product option) {
        getMyOptions().add(option);
    }


    public Product getBase() {
        return base;
    }

  
    public List<Product> getMyOptions() {
        return myOptions;
    }


    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }
    
    
    @Override
    public double getPrice(){
        price = base.getPrice();
        for(Product each: myOptions){
            price = price + each.getPrice();
        }
        if(size==Size.DOUBLE) price = 1.9*price;
        if(size==Size.FAMILY) price = 3.5*price;
        return price;
    }
    
}
