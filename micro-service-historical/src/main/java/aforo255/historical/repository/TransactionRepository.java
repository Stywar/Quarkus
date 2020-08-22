package aforo255.historical.repository;

import javax.enterprise.context.ApplicationScoped;

import aforo255.historical.entity.Transaction;
import io.quarkus.mongodb.panache.PanacheMongoRepositoryBase;
@ApplicationScoped
public class TransactionRepository implements  PanacheMongoRepositoryBase<Transaction, String> {

	
	
}
