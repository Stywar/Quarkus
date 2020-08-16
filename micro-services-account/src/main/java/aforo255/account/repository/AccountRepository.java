package aforo255.account.repository;
import javax.enterprise.context.ApplicationScoped;

import aforo255.account.consumer.entity.Account;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

@ApplicationScoped
public class AccountRepository implements PanacheRepositoryBase<Account,Integer> {

	/*public List<Account> findAllAccount() {
		return findAll().list();
	}
	
	public Account findAccountById(Integer id) {
		
		return findById(id);
	}*/

}
