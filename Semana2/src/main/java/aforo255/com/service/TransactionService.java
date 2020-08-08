package aforo255.com.service;

import javax.enterprise.context.ApplicationScoped;
import javax.validation.Valid;

import aforo255.com.entity.Transaction;

@ApplicationScoped
public class TransactionService {

	public Transaction checkTransaction(@Valid Transaction transac) {
		return transac;
	}
}
