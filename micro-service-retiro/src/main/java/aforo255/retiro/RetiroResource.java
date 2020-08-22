package aforo255.retiro;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

import aforo255.retiro.entity.Transaction;
import aforo255.retiro.service.ITransactionService;



@Path("/retiro")
public class RetiroResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "hello";
    }
    
    @Inject
	ITransactionService service;
	
	@Inject
    @Channel("transactions")
    // Emitter<String> emitter;
	Emitter<Transaction> emitter;
	
	 @POST
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.APPLICATION_JSON)
	    @Transactional
		public Response saveTransaction(Transaction transaction) {
	    	Transaction trx = null;
			Map<String, Object> response = new HashMap<>();
			trx = service.save(transaction);
			//emitter.send(trx);
			 Jsonb create = JsonbBuilder.create();
			 String json= create.toJson(trx);
			 emitter.send(trx);
			response.put("mensaje", "Transaccion realizada con exito!");
			response.put("transaction", trx);
			return Response.status(Status.CREATED).entity(response).build();
	    }
	
}