package com.aforo255.account.services;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.aforo255.account.domain.Transaction;
import com.aforo255.account.repository.TransactionRepository;
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
