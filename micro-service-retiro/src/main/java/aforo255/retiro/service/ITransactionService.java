package aforo255.retiro.service;

import aforo255.retiro.entity.Transaction;

public interface ITransactionService {
	public Transaction findById(Integer id);

	public Transaction save(Transaction transaction);
}
