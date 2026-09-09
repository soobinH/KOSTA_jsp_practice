package service;

import java.util.List;

import dto.Account;
public interface AccountService {
	void makeAccount(Account acc)throws Exception;
	Account deposit(String id, Integer money)throws Exception;
	Account withdraw(String id, Integer money) throws Exception;
	Account accountInfo(String id)throws Exception;
	List<Account> allAccountInfo() throws Exception;
	Account transfer(String sid, String rid, Integer money) throws Exception;
	
}
