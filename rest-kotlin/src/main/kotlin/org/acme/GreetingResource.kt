package org.acme

import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import javax.inject.Inject
import org.acme.service.HelloService
import javax.ws.rs.PathParam

@Path("/greeting")
class GreetingResource {

	@Inject	
	lateinit var testService: HelloService
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    fun hello() = "hello"
	
	@GET
	@Path("/{name}")
	@Produces(MediaType.TEXT_PLAIN)
	fun sayHello(@PathParam("name") name :String  ):String {
		return testService.test(name);
	}
	
}