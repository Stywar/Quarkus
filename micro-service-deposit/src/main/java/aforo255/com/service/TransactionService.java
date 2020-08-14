package aforo255.com.service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import aforo255.com.entity.Transaction;
import aforo255.com.repository.TransactionRepository;

@ApplicationScoped
public class TransactionService implements ITransactionService {

	@Inject
	TransactionRepository transaction; 
	
	@Override
	public Transaction findById(Integer id) {
		// TODO Auto-generated method stub
		return transaction.findById(id);
	}

	@Override
	public Transaction save(Transaction transaction) {
		// TODO Auto-generated method stub
		 transaction.persist();
		 return transaction;
	}

}
