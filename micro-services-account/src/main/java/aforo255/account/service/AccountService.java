package aforo255.account.service;

import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.LockModeType;

import aforo255.account.consumer.entity.Account;
import aforo255.account.repository.AccountRepository;
import io.smallrye.reactive.messaging.annotations.Blocking;
@ApplicationScoped
public class AccountService implements IAccountService {
	@Inject
	AccountRepository accountRepository;
	@Inject
    EntityManager entityManager;
	@Override
	public List<Account> findAllAccount() {
		// TODO Auto-generated method stub
		return accountRepository.findAll().list();
	}
	@Override	
	public  Account findAccountById(Integer id) {
		
		Account account = accountRepository.findById(id);
		// TODO Auto-generated method stub
		entityManager.lock(account, LockModeType.PESSIMISTIC_WRITE);
		return account;
	}
	@Override
	public Account mergeAccount(Account account) {
		// TODO Auto-generated method stub
		account.persist();
		return account;
	}

	
}
