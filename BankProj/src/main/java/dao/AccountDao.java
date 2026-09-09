package dao;

import java.util.List;

import dto.Account;

public interface AccountDao {
	void insertAccount(Account acc) throws Exception;
	void updateAccount(Account acc) throws Exception;
	Account selectAccount(String id)throws Exception;
	List<Account> selectAccountList() throws Exception;

}
