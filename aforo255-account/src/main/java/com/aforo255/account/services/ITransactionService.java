package com.aforo255.account.services;

import com.aforo255.account.domain.Transaction;

public interface ITransactionService {

	public Transaction findById(Integer id );
	public Transaction save(Transaction transaction);
}
