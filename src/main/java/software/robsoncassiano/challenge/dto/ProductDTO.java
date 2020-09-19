package software.robsoncassiano.challenge.dto;

import java.math.BigDecimal;
import software.robsoncassiano.challenge.model.Product;

public class ProductDTO {

  private final String name;
  private final String description;
  private final BigDecimal price;
  private final String brand;

  public ProductDTO(String name, String description, BigDecimal price, String brand) {
    this.name = name;
    this.description = description;
    this.price = price;
    this.brand = brand;
  }

  public Product mapToDto() {
    return new Product(name, description, price, brand);
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public String getBrand() {
    return brand;
  }
}
