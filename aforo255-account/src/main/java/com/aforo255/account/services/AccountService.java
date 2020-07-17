package com.aforo255.account.services;

import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.aforo255.account.domain.Account;
import com.aforo255.account.repository.AccountRepository;
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
