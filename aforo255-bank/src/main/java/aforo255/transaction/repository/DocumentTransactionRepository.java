package aforo255.transaction.repository;

import javax.enterprise.context.ApplicationScoped;
import aforo255.transaction.document.DocumentTransaction;
import io.quarkus.mongodb.panache.PanacheMongoRepositoryBase;
@ApplicationScoped
public class DocumentTransactionRepository implements  PanacheMongoRepositoryBase<DocumentTransaction, String> {

	
	
}
