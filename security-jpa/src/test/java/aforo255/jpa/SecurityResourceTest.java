package aforo255.jpa;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class SecurityResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/security")
          .then()
             .statusCode(200)
             .body(is("hello"));
    }

}