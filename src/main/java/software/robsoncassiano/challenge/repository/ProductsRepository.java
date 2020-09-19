package software.robsoncassiano.challenge.repository;

import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import software.robsoncassiano.challenge.model.Product;

@Component
public interface ProductsRepository extends MongoRepository<Product, String> {

  Optional<Product> findById(String id);

  Product findByName(String name);
}
