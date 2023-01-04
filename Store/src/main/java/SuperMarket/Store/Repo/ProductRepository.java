package SuperMarket.Store.Repo;

import SuperMarket.Store.Entity.Product;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Repository
public interface ProductRepository extends CassandraRepository<Product, Integer> {
    @AllowFiltering
    public Optional<Product> findByProductId(int productId);

    public Boolean existsByProductId(int productId);

    @AllowFiltering
    @Transactional
    @Query("INSERT INTO pdt (product_id, name, in_stock) VALUES (?0, ?1, ?2) USING TTL 60")
    public void updateUsingTTL(@Param("productId") int productId, @Param("product_name") String productName, @Param("quantity") int qty);
}
