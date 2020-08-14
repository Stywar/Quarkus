package aforo255.com;

import javax.enterprise.context.ApplicationScoped;

import io.quarkus.vertx.web.Route;
import io.quarkus.vertx.web.RouteBase;
import io.vertx.core.http.HttpMethod;
import io.vertx.ext.web.RoutingContext;

//@ApplicationScoped
@RouteBase(path = "/test1", produces = "text/html")
public class ExampleRouteResource {

	@Route(methods=HttpMethod.GET)
	public void test(RoutingContext rc) {
		
		rc.response().end("hello hola");
	}
	
	/*@Route(path = "/hello2" , methods=HttpMethod.GET)
	public void testHello(RoutingContext rc) {
		
		rc.response().end("hello232");
	}*/
}
