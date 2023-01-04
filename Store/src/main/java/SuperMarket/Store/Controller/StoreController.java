package SuperMarket.Store.Controller;

import SuperMarket.Store.Entity.Product;
import SuperMarket.Store.Entity.ProductResponse;
import SuperMarket.Store.Exception.ProductNotFoundException;
import SuperMarket.Store.Service.StoreService;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
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

    @PutMapping("/updateUsingTTL")
    public void updateUsingTTL(@RequestBody  Product product) throws ProductNotFoundException {
        storeService.updateUsingTTL(product);
    }

    @PostMapping("/insertUsingCsv_file")
    public String processCsvFile(@RequestParam("file") MultipartFile file) throws Exception {
        try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            System.out.print(reader.read());
            List<Product> csvToBean = new CsvToBeanBuilder<Product>(reader)
                    .withType(Product.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .withIgnoreEmptyLine(true)
                    .build()
                    .parse();
            csvToBean.forEach(System.out::println);
            return storeService.processCsvData(csvToBean);
        } catch (IOException ex) {ex.getStackTrace();}
        return "";
    }
}
