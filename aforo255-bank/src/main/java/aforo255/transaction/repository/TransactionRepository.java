package aforo255.transaction.repository;

import javax.enterprise.context.ApplicationScoped;

import aforo255.transaction.domain.Transaction;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
@ApplicationScoped
public class TransactionRepository implements PanacheRepositoryBase<Transaction, Integer>{

}
