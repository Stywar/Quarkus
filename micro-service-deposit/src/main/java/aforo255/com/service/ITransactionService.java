package aforo255.com.service;

import aforo255.com.entity.Transaction;

public interface ITransactionService {
	public Transaction findById(Integer id);

	public Transaction save(Transaction transaction);
}
