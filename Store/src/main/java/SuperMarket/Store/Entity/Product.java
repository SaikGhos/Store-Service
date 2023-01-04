package SuperMarket.Store.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(value = "pdt")
public class Product {


    @NotNull
    @PrimaryKey(value = "product_id")
    private int productId;
    @NotBlank
    @Column("name")
    @CassandraType(type = CassandraType.Name.TEXT)
    private String productName;
    @NotNull
    @Column("in_stock")
    @CassandraType(type = CassandraType.Name.INT)
    private int qty;

}
