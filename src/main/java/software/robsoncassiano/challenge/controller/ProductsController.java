package software.robsoncassiano.challenge.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import software.robsoncassiano.challenge.dto.ProductDTO;
import software.robsoncassiano.challenge.model.Product;
import software.robsoncassiano.challenge.repository.ProductsRepository;

@RestController
@RequestMapping("/products")
@Api(value = "Products")
public class ProductsController {

  private final ProductsRepository productsRepository;

  public ProductsController(ProductsRepository productsRepository) {
    this.productsRepository = productsRepository;
  }

  @GetMapping("/all")
  @ApiOperation(value = "Get All Products")
  public Page<Product> getAllProducts(
      @RequestParam(value = "size", defaultValue = "10") int resultSize) {
    return this.productsRepository.findAll(PageRequest.of(0, resultSize));
  }

  @GetMapping("/ordered")
  @ApiOperation(value = "Get a list of all products ordered by name")
  public Page<Product> getOrderedProductsListByName(
      @RequestParam(value = "page", defaultValue = "0") int page,
      @RequestParam(value = "resultSize", defaultValue = "10") int resultSize) {
    return this.productsRepository.findAll(
        PageRequest.of(page, resultSize, Sort.by(Sort.Direction.ASC, "name")));
  }

  @PostMapping("/new")
  @ApiOperation(value = "Create a new product on database")
  public ResponseEntity<String> insertNewProduct(@RequestBody ProductDTO product) {
    this.productsRepository.insert(product.mapToDto());
    return ResponseEntity.ok("created");
  }

  @PutMapping("/update")
  @ApiOperation(value = "Update product on database")
  public ResponseEntity<String> updateProductName(@RequestBody ProductDTO product) {
    this.productsRepository.save(product.mapToDto());
    return ResponseEntity.ok("updated");
  }

  @GetMapping("/{id}")
  @ApiOperation(value = "Get a product by it's id")
  public Optional<Product> getProductById(@PathVariable("id") String id) {
    return this.productsRepository.findById(id);
  }

  @GetMapping
  @ApiOperation(value = "Get a product by it's name")
  public Product getProductByName(@RequestParam(value = "name") String name) {
    return this.productsRepository.findByName(name);
  }

  @DeleteMapping("{id}")
  @ApiOperation(value = "Delete a product")
  public ResponseEntity<String> deleteOneProduct(@PathVariable("id") String id) {
    this.productsRepository.deleteById(id);
    return ResponseEntity.ok("deleted!");
  }
}

