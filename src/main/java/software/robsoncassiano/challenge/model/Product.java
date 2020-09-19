package software.robsoncassiano.challenge.model;

import java.math.BigDecimal;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Products")
public class Product {

  @Id
  private String id;

  @Indexed(direction = IndexDirection.ASCENDING)
  private final String name;
  private final String description;
  private final BigDecimal price;
  private final String brand;

  public Product(String name, String description, BigDecimal price, String brand) {
    this.name = name;
    this.description = description;
    this.price = price;
    this.brand = brand;
  }

  public String getId() {
    return id;
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
