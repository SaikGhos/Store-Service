package SuperMarket.Store.Controller;

import SuperMarket.Store.Entity.Product;
import SuperMarket.Store.Entity.ProductResponse;
import SuperMarket.Store.Exception.ProductNotFoundException;
import SuperMarket.Store.Service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StoreController {

    @Autowired
    public StoreService storeService;

    @PostMapping("/saveProducts")
    public List<Product> saveProducts(@RequestBody List<Product> products) {
        return storeService.saveProducts(products);
    }
    @PostMapping("/addProduct")
    public ProductResponse addProduct(@RequestBody Product products) {
        return storeService.addProduct(products);
    }
    @GetMapping("/getProductByProductId/{productId}")
    public Optional<Product> getProductByProductId(@PathVariable int productId) throws ProductNotFoundException{
        return storeService.getProductByProductId(productId);
    }
    @GetMapping("/getAllProducts")
    public List<Product> getProducts() {
        return storeService.getAllProducts();
    }
    @GetMapping("/checkingAvailabilityOfProducts")
    public String[] checkingAvailabilityOfProducts(@RequestBody List<Product> products) throws ProductNotFoundException {
        return storeService.checkingAvailabilityOfProducts(products);
    }
}
