package SuperMarket.Store.Service;

import SuperMarket.Store.Entity.Product;
import SuperMarket.Store.Entity.ProductResponse;
import SuperMarket.Store.Exception.ProductNotFoundException;
import SuperMarket.Store.Repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StoreServiceImpl implements StoreService{

    @Autowired
    public ProductRepository productRepository;

    @Override
    public List<Product> saveProducts(List<Product> products) {
        return productRepository.saveAll(products);
    }
    @Override
    public ProductResponse addProductQty(Product product) throws ProductNotFoundException {

        Optional<Product> pdt = productRepository.findByProductId(product.getProductId());
        if(!pdt.isPresent()) {
            throw new ProductNotFoundException("Product with productId " + product.getProductId() + "is not there in store, recommend to save the product.");
        } else {
            Product updatedProduct = new Product(product.getProductId(), product.getProductName(),
                    pdt.get().getQty() + product.getQty());
            productRepository.save(updatedProduct);
            ProductResponse productResponse = new ProductResponse(updatedProduct.getProductId(), updatedProduct.getProductName(), updatedProduct.getQty(),
                    product.getQty() + " units of " + product.getProductName() + " has been added.");
            return productResponse;
        }
    }

    @Override
    public Optional<Product> getProductByProductId(int productId) throws ProductNotFoundException {
        Optional<Product> pdt = productRepository.findByProductId(productId);
        if(!pdt.isPresent()) {
            throw new ProductNotFoundException("Product with productId " + productId + " is not there in store.");
        } else {
            return pdt;
        }
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public String[] checkingAvailabilityOfProducts(List<Product> products) throws ProductNotFoundException {
        String[] comment = new String[products.size()];
        for(int i=0;i<products.size();i++) {
            Optional<Product> pdt = productRepository.findByProductId(products.get(i).getProductId());
            if(!pdt.isPresent()) {
                comment[i] =  products.get(i).getProductName() + " is not available in the store.";
            } else if (pdt.get().getQty()< products.get(i).getQty()) {
                comment[i] =  "Only " + pdt.get().getQty() + " unit(s) of " + pdt.get().getProductName() + " is available, which is "
                        + (products.get(i).getQty() - pdt.get().getQty()) + " units short for your order.";
            } else {
                comment[i] =  pdt.get().getQty() + " unit(s) of " + pdt.get().getProductName() + " is available for purchase.";
            }
        }
        return comment;
    }


}
