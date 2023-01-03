package SuperMarket.Store.Repo;

import SuperMarket.Store.Entity.Product;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends CassandraRepository<Product, Integer> {
    @AllowFiltering
    public Optional<Product> findByProductId(int productId);
}
