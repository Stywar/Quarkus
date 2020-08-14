package aforo255.com.repository;

import javax.enterprise.context.ApplicationScoped;

import aforo255.com.entity.Transaction;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

@ApplicationScoped
public class TransactionRepository implements PanacheRepositoryBase<Transaction, Integer>{

}
