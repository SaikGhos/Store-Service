package SuperMarket.Store.Service;

import SuperMarket.Store.Entity.Product;
import SuperMarket.Store.Entity.ProductResponse;
import SuperMarket.Store.Exception.ProductNotFoundException;

import java.util.List;
import java.util.Optional;

public interface StoreService {
    public List<Product> saveProducts(List<Product> products);
    public ProductResponse addProductQty(Product product) throws ProductNotFoundException ;
    public Optional<Product> getProductByProductId(int productId) throws ProductNotFoundException;
    public List<Product> getAllProducts();
    public String[] checkingAvailabilityOfProducts(List<Product> products) throws ProductNotFoundException;


}
