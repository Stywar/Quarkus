package aforo255.account.consumer;

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

import aforo255.account.consumer.entity.Account;
import aforo255.account.consumer.entity.Transaction;
import aforo255.account.service.IAccountService;



@ApplicationScoped
@ActivateRequestContext
public class TransactionConsumer {

	@Inject
	IAccountService account;
	
	@Incoming("transaction")
	@Transactional
    public  CompletionStage<?>  reciveTransaction(String  json) {
		
		 ManagedExecutor executor = ManagedExecutor.builder()
		            .maxAsync(5)
		            .propagated(ThreadContext.CDI, 
		                        ThreadContext.TRANSACTION)
		            .build();
		    //TODO: move to CDI producer
		    ThreadContext threadContext = ThreadContext.builder()
		                     .propagated(ThreadContext.CDI, 
		                                 ThreadContext.TRANSACTION)
		                     .build();
		    
		    return executor.runAsync(threadContext.contextualRunnable(() -> {
		       
		    	Jsonb create = JsonbBuilder.create();
		        Transaction trx = create.fromJson(json, Transaction.class);
		        System.out.println("=========================================");
		        System.out.println(json);
		        System.out.println("=========================================");
		        System.out.println("Transaction =>" + trx.getId());
		        System.out.println("Transaction =>" + trx.getAccountId());
		        if(trx!=null) { 
				   
		        	double newmonto = 0;
					Account objAccount = new Account();
					objAccount = account.findAccountById(trx.getAccountId());
		         String jsonobjAccount= create.toJson(objAccount);
		         System.out.println("jsonobjAccount =>" + jsonobjAccount);
					switch (trx.getType()) {
					case "deposito":
						newmonto = objAccount.getTotalAmount() + trx.getAmount();
						break;

					case "retiro":
						newmonto = objAccount.getTotalAmount() - trx.getAmount();
						break;

					}
					 System.out.println("Nuevo monto" + newmonto);
					objAccount.setTotalAmount(newmonto);
					account.mergeAccount(objAccount);
				}
		        //restaurante.persist(pgPool);
		    	
		    }));    
		
        
		
    }
}
