package obenkyou;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class LearningJson {

  public static void main(String[] args) throws IOException {
    final ObjectMapper objectMapper = new ObjectMapper();

    final URL url = new URL("https://reqres.in/api/users?page=2");
    final JsonNode jsonFromFile = objectMapper.readTree(new File("src/main/resources/Jsons/file.json"));

    JsonFactory jsonFactory = new JsonFactory();
    try (JsonParser jsonParser = jsonFactory.createParser(url)) {
      JsonToken token;
      while ((token = jsonParser.nextToken()) != null) {
        if (token.isScalarValue()) {
          final String currentName = jsonParser.getCurrentName();
          if (currentName != null) {
            final String text = jsonParser.getText();
            System.out.printf("%s: $s %n", currentName, text);

          }
        }
      }
    }


  }
}
