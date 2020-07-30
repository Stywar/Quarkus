package aforo255.transaction.services;

import java.util.List;
import aforo255.transaction.domain.Account;

public interface IAccountService {
	public List<Account> findAllAccount();
	public  Account findAccountById(Integer id);	
	public Account mergeAccount (Account account);
}
