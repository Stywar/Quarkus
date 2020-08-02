package aforo255.com;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.startsWith;
import java.util.UUID;

@QuarkusTest
public class ExampleResourceTest {

	@Test
	public void testHelloEndpoint() {
		given().when().get("/hello").then().statusCode(200).body(is("hello test"));
	}

	@Test
	public void testHelloWithNameEndpoint() {
		final String name = UUID.randomUUID().toString();
		given().when().get("/hello/" + name).then().statusCode(200)
				.body(startsWith("Hello " + name + ", your account is 123"));
	}
	
	/*
	 Nota : Para kotlin crear otro proyecto
	 mvn io.quarkus:quarkus-maven-plugin:1.6.1.Final:create -Dextensions="kotlin,resteasy-jsonb"
    
    -DprojectGroupId=org.acme \
    -DprojectArtifactId=rest-kotlin-quickstart \
    -DclassName="org.acme.rest.GreetingResource" \
    -Dpath="/greeting" \  
	 
	  
	 * */

}