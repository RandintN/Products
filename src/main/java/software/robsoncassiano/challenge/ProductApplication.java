package software.robsoncassiano.challenge;

import static springfox.documentation.builders.PathSelectors.any;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class ProductApplication {

  public static void main(String[] args) {
    SpringApplication.run(ProductApplication.class, args);
  }

  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2).groupName("Products").select()
        .apis(RequestHandlerSelectors.basePackage("software.robsoncassiano.challenge"))
        .paths(any()).build().apiInfo(new ApiInfo("Product's Service",
            "A set of operations on Products", "1.0.0", null,
            new Contact("Robson Cassiano", "https://twitter.com/RandintN",
                "robson.cordeiro777@gmail.com"), "GPL",
            "https://www.gnu.org/licenses/gpl-3.0.en.html"));
  }
}
