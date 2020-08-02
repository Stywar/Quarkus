package aforo255.com;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
//import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import aforo255.com.service.AccountService;
@Path("/hello")
public class HelloResource {

	@Inject
	private AccountService account;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String hello() {
	//	return new AccountService().sayHello(qname);
		return account.sayHello();

	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	//public String hello(@QueryParam("name") String qname) {
    @Path("/{name}")
	public String hello(@PathParam("name") String qname) {
	//	return new AccountService().sayHello(qname);
		return account.sayHello(qname);

	}

}
