package aforo255.transaction.services;

import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import aforo255.transaction.domain.Account;
import aforo255.transaction.repository.AccountRepository;
@ApplicationScoped
public class AccountService implements IAccountService {

	@Inject
	AccountRepository accountRepository;
	@Override
	public List<Account> findAllAccount() {
		// TODO Auto-generated method stub
		return accountRepository.findAll().list();
	}
	@Override
	public  Account findAccountById(Integer id) {
		// TODO Auto-generated method stub
		return accountRepository.findById(id);
	}
	@Override
	public Account mergeAccount(Account account) {
		// TODO Auto-generated method stub
		account.persist();
		return account;
	}

	
}
