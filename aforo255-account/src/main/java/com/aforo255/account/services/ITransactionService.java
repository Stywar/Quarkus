package com.aforo255.account.services;

import java.util.List;

import com.aforo255.account.document.DocumentTransaction;
import com.aforo255.account.domain.Transaction;

public interface ITransactionService {

	public Transaction findById(Integer id);

	public Transaction save(Transaction transaction);

	public DocumentTransaction saveDocument(DocumentTransaction transaction);

	public List<DocumentTransaction> listAll();
}
