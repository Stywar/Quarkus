package aforo255.historical.service;

import java.util.List;

import aforo255.historical.entity.Transaction;


public interface ITransactionService {

	
	public Transaction saveDocument(Transaction transaction);

	public List<Transaction> listAll();
}
