package aforo255.com;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.faulttolerance.Timeout;
import org.jboss.logging.Logger;

import aforo255.com.entity.Account;
@Path("/account")
public class AccountResource {
	 public static Logger LOGGER = Logger.getLogger(AccountResource.class.getName());
	 
	    @GET
	    @Produces(MediaType.APPLICATION_JSON)
	    //Cambiar maxRetries=1 , para el ejemplo
	    //@Retry(maxRetries = 4,delay = 1000L)
	    //@Timeout
	    // @Fallback(fallbackMethod = "getFallbackAccounts")
	    @CircuitBreaker(failureRatio = 0.5, requestVolumeThreshold = 5, failOn = RuntimeException.class, delay = 20000L)
	   // public List<Account> getAccount(@QueryParam("id") String id) throws InterruptedException {
	    public List<Account> getAccount(@QueryParam("id") String id){
	    	//Comentar esto cuando implementamos Timeout
	     	final boolean fail= new Random().nextBoolean();
	       if(fail) {
	    	   LOGGER.info("No se puede conectar a la BD");
	    	   //Timeut comentar
	    	  throw new RuntimeException("No se puede conectar a la BD");
	    	   //Thread.sleep(2000L);
	       }
	    	/*if (true) {
	            LOGGER.info("No se puede conectar a la BD");
	            throw new RuntimeException("No se puede conectar a la BD");
	        }*/
	        return Arrays.asList(
	                new Account("1", "cuenta1", "cuenta ahorros"),
	                new Account("2", "prestamo", "pago pepito"),
	                new Account("3", "cuenta2", "cuenta debito")
	        );
	        
	    	
	    }
	    
	    
	    
	    public List<Account> getAccount2(@QueryParam("id") String id) {
		       final boolean fail= new Random().nextBoolean();
		       if(fail) {
		    	   throw new RuntimeException("No se puede conectar a la BD");
		       }
		    	/*if (true) {
		            LOGGER.info("No se puede conectar a la BD");
		            throw new RuntimeException("No se puede conectar a la BD");
		        }*/
		        return Arrays.asList(
		                new Account("1", "cuenta1", "cuenta ahorros"),
		                new Account("2", "prestamo", "pago pepito"),
		                new Account("3", "cuenta2", "cuenta debito")
		        );
		    }
		    
	    

	    public List<Account> getFallbackAccounts(@QueryParam("id") String id) {
	        LOGGER.info("Id is " + id);
	        return Arrays.asList(
	                new Account("1", "Fallback cuenta1", "cuenta1"),
	                new Account("2", "Fallback cuenta2", "cuenta2"),
	                new Account("3", "Fallback cuenta3", "cuenta3")
	        );
	    }
}
