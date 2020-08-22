package aforo255.retiro.repository;

import javax.enterprise.context.ApplicationScoped;

import aforo255.retiro.entity.Transaction;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

@ApplicationScoped
public class TransactionRepository implements PanacheRepositoryBase<Transaction, Integer>{

}
