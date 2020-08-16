package aforo255.account.service;

import java.util.List;

import aforo255.account.consumer.entity.Account;

public interface IAccountService {
	public List<Account> findAllAccount();
	public  Account findAccountById(Integer id);	
	public Account mergeAccount (Account account);
}
