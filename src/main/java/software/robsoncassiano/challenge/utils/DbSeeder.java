package software.robsoncassiano.challenge.utils;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import software.robsoncassiano.challenge.model.Product;
import software.robsoncassiano.challenge.repository.ProductsRepository;

@Component
public class DbSeeder implements CommandLineRunner {
  private static final String CERVEJA = "Cerveja";
  private static final String REFRIGERANTE = "Refrigerante";
  private static final String AGUA = "AGUA";

  private final ProductsRepository productsRepository;

  public DbSeeder(ProductsRepository productsRepository) {
    this.productsRepository = productsRepository;
  }

  @Override
  public void run(String... strings) {
    final Product product1 = new Product("Sukita", REFRIGERANTE, new BigDecimal("6.50"), "Marca1");
    final Product product2 = new Product("Brahma", CERVEJA, new BigDecimal("5.70"), "Marca2");
    final Product product3 = new Product("Bohemia", CERVEJA, new BigDecimal("7.40"), "Marca3");
    final Product product4 = new Product("Skol", CERVEJA, new BigDecimal("8.60"), "Marca4");
    final Product product5 = new Product("H2OH!", AGUA, new BigDecimal("6.30"), "Marca5");
    final Product product6 = new Product("Antarctica", REFRIGERANTE, new BigDecimal("7.30"), "Marca6");

    // drop all products collections if they exists
    this.productsRepository.deleteAll();

    // Add mock products to database
    List<Product> products = Arrays
        .asList(product1, product2, product3, product4, product5, product6);
    this.productsRepository.saveAll(products);
  }
}
