package com.aforo255.account.repository;

import javax.enterprise.context.ApplicationScoped;
import com.aforo255.account.document.DocumentTransaction;
import io.quarkus.mongodb.panache.PanacheMongoRepositoryBase;
@ApplicationScoped
public class DocumentTransactionRepository implements  PanacheMongoRepositoryBase<DocumentTransaction, String> {

	
	
}
