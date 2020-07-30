package aforo255.transaction.services;

import java.util.List;

import aforo255.transaction.document.DocumentTransaction;
import aforo255.transaction.domain.Transaction;

public interface ITransactionService {

	public Transaction findById(Integer id);

	public Transaction save(Transaction transaction);

	public DocumentTransaction saveDocument(DocumentTransaction transaction);

	public List<DocumentTransaction> listAll();
}
