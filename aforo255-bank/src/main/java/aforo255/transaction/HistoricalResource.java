package aforo255.transaction;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import aforo255.transaction.document.DocumentTransaction;
import aforo255.transaction.services.ITransactionService;

@Path("/historical")
public class HistoricalResource {
	@Inject
	ITransactionService service;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getAll")
	public List<DocumentTransaction> getTransaction() {
		return service.listAll();
	}

}
