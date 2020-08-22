package aforo255.historical.consumer;

import java.util.concurrent.CompletionStage;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.control.ActivateRequestContext;
import javax.inject.Inject;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.transaction.Transactional;

import org.eclipse.microprofile.context.ManagedExecutor;
import org.eclipse.microprofile.context.ThreadContext;
import org.eclipse.microprofile.reactive.messaging.Incoming;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import aforo255.historical.entity.Transaction;
import io.smallrye.reactive.messaging.annotations.Blocking;
@ApplicationScoped
@ActivateRequestContext
public class TransactionConsumer {


	
	@Incoming("transactions")
	@Blocking
    public void reciveTransactionHistorical(Transaction      trx)  {		
			
		 System.out.println("=============MICRO SERVICE HISTORICAL ============================");
		 System.out.println("====================HISTORICAL=====================================");	    
	     System.out.println("===================================================================");
	     Jsonb create = JsonbBuilder.create();
	     String json = create.toJson(trx);
	     System.out.println(String.format("Transaction : %s", json));	    
	     Transaction trxHistorical =trx;
	     trxHistorical.persist();   
	     System.out.println("Transaction save "+trx.getId());	  	     
    }	
}
