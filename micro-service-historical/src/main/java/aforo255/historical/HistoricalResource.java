package aforo255.historical;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import aforo255.historical.entity.Transaction;
import aforo255.historical.service.ITransactionService;



@Path("/historical")
public class HistoricalResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "hello";
    }
    
    @Inject
	ITransactionService service;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getAll")
	public List<Transaction> getTransaction() {
		return service.listAll();
	}

}