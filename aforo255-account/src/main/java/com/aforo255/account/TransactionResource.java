package com.aforo255.account;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.aforo255.account.document.DocumentTransaction;
import com.aforo255.account.domain.Account;
import com.aforo255.account.domain.Transaction;
import com.aforo255.account.services.IAccountService;
import com.aforo255.account.services.ITransactionService;

@Path("/transaction")
public class TransactionResource {
	@Inject
	ITransactionService service;
	@Inject
	IAccountService account;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional
	public Transaction saveTransaction(Transaction transaction) {
		Transaction trx = service.save(transaction);
		if (trx != null) {
			if (trx.getId() > 0) {

				System.out.println("Transaction =>" + trx.getId());
				double newmonto = 0;
				Account objAccount = new Account();
				objAccount = account.findAccountById(trx.getAccountId());

				switch (trx.getType()) {
				case "deposito":
					newmonto = objAccount.getTotalAmount() + trx.getAmount();
					break;

				case "retiro":
					newmonto = objAccount.getTotalAmount() - trx.getAmount();
					break;

				}

				objAccount.setTotalAmount(newmonto);
				account.mergeAccount(objAccount);

				DocumentTransaction document = setDocument(trx);
				service.saveDocument(document);
				

			}
		}

		return trx;
	}

	private DocumentTransaction setDocument(Transaction trx) {
		DocumentTransaction document = new DocumentTransaction();
		document.setId(trx.getId().toString());
		document.setAccountId(trx.getAccountId());
		document.setAmount(trx.getAmount());
		document.setCreationDate(trx.getCreationDate());
		document.setType(trx.getType());

		return document;

	}

}
