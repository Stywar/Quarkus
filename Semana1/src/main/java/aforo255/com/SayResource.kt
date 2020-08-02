package aforo255.com

import javax.ws.rs.Path
import javax.inject.Inject
import aforo255.com.service.TestService
import javax.ws.rs.GET
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import javax.ws.rs.PathParam
import javax.enterprise.inject.Default

//@Path("/say")
class SayResource {
	@Inject	
	lateinit var testService: TestService

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	fun say() = "Hello"

	@GET
	@Path("/{name}")
	@Produces(MediaType.TEXT_PLAIN)
	fun sayHello(@PathParam("name") name :String  ):String {
		return testService.test(name);
	}

}