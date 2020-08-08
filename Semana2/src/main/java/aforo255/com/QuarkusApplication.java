package aforo255.com;

import javax.ws.rs.core.Application;

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Info;
//import org.eclipse.microprofile.openapi.annotations.servers.Server;

@OpenAPIDefinition(info = 
@Info(
		title = "Getting Started API!",
		description = "My Firts API !", 
		version = "1.0")//,
//servers = @Server(
	//	url = "dev.aforo255.com"
		//)
)
public class QuarkusApplication extends Application {

}
