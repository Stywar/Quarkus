package aforo255.transaction.services;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import aforo255.transaction.document.DocumentTransaction;
import aforo255.transaction.domain.Transaction;
import aforo255.transaction.repository.DocumentTransactionRepository;
import aforo255.transaction.repository.TransactionRepository;
@ApplicationScoped
public class TransactionService implements ITransactionService {

	@Inject
	TransactionRepository transaction; 
	
	@Inject
	DocumentTransactionRepository mongoRepo; 
	
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

	@Override
	public DocumentTransaction saveDocument(DocumentTransaction transaction) {
		// TODO Auto-generated method stub
		transaction.persistOrUpdate();
		return transaction;
	}

	@Override
	public List<DocumentTransaction> listAll() {
		// TODO Auto-generated method stub
		return mongoRepo.listAll();
	}

}
