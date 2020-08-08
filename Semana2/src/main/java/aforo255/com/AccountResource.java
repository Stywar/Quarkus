package aforo255.com;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.jboss.logging.Logger;

import aforo255.com.entity.Account;
@Path("/account")
public class AccountResource {
	 public static Logger LOGGER = Logger.getLogger(AccountResource.class.getName());
	 
	   @GET
	    @Produces(MediaType.APPLICATION_JSON)
	    @CircuitBreaker(failureRatio = 0.5, requestVolumeThreshold = 5, failOn = RuntimeException.class, delay = 20000L)
	    public List<Account> getBooks(@QueryParam("id") String id) {
	        if (true) {
	            LOGGER.info("Couldn't connect to database");
	            throw new RuntimeException("Couldn't connect to database");
	        }
	        return Arrays.asList(
	                new Account("1", "cuenta1", "cuenta ahorros"),
	                new Account("2", "prestamo", "pago pepito"),
	                new Account("3", "cuenta2", "cuenta debito")
	        );
	    }

	    public List<Account> getFallbackBooks(@QueryParam("id") String id) {
	        LOGGER.info("Id is " + id);
	        return Arrays.asList(
	                new Account("1", "Fallback cuenta1", "cuenta1"),
	                new Account("2", "Fallback cuenta2", "cuenta2"),
	                new Account("3", "Fallback cuenta3", "cuenta3")
	        );
	    }
}
