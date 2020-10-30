
package co.unicauca.restaurant.accces;
import co.unicauca.restaurant.domain.Product;
import java.util.ArrayList;
import java.util.List;



public class ItalianProductRepositoryImplArrays implements IProductRepository {

    public static List<Product> products;
    public ItalianProductRepositoryImplArrays(){
        products = new ArrayList<>();
        initialize();
    }
    
    private void initialize() {
        products.add(new Product(1, "Pasta", 5800d));
        products.add(new Product(2, "Rissoto", 5200d));
        products.add(new Product(3, "Lasaña", 6000d));
        products.add(new Product(4, "Carpaccio", 5200d));
        products.add(new Product(5, "Mozzarella", 2900d));
        products.add(new Product(6, "Prosciutto", 4000d));
        products.add(new Product(7, "Vegetales salteados", 3000d));
    }
    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public Product findById(Integer id) {
        for(Product prod:products){
            if (prod.getId() == id) {
                return prod;
            }
        }
        return null;
    }

    @Override
    public boolean create(Product newProduct) {
        Product prod = this.findById(newProduct.getId());
        if (prod != null) {
                //Ya existe
                return false;
        }
        products.add(newProduct);
        return true;
    }

    @Override
    public boolean update(Product newProduct) {
        Product prod = this.findById(newProduct.getId());
        if (prod != null) {
            prod.setName(newProduct.getName());
            prod.setPrice(newProduct.getPrice());
        return true;
        }
    return false;
    }

    @Override
    public boolean delete(Integer id) {
        for (Product prod : products) {
                if (prod.getId() == id) {
                    products.remove(prod);
                    return true;
                }
        }
        return false;
    }
}
