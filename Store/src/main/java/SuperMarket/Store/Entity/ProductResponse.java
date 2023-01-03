package SuperMarket.Store.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse {

    private int productId;
    private String productName;
    private int qty;
    private String status;
}

