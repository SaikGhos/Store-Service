package SuperMarket.Store.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(value = "pdt")
public class Product {


    @NotNull
    @PrimaryKeyColumn(name = "ProductId", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private int productId;
    @NotBlank
    @Column("Name")
    @CassandraType(type = CassandraType.Name.TEXT)
    private String productName;
    @NotNull
    @Column("InStock")
    @CassandraType(type = CassandraType.Name.INT)
    private int qty;

}
