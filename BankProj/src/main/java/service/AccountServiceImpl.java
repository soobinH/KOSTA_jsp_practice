package service;

import java.util.List;

import dao.AccountDao;
import dao.AccountDaoImpl;
import dto.Account;
import exc.BankException;
import exc.ERR_CODE;

public class AccountServiceImpl implements AccountService {

	private AccountDao accountDao;
	
	public AccountServiceImpl() {
		accountDao = new AccountDaoImpl();
	}
	@Override
	public void makeAccount(Account acc) throws Exception {
		if(accountDao.selectAccount(acc.getId())!= null) throw new BankException(ERR_CODE.DOUBLEID); 
		accountDao.insertAccount(acc);

	}

	@Override
	public Account deposit(String id, Integer money) throws Exception {
		Account acc = accountDao.selectAccount(id);
		if(acc==null) throw new BankException(ERR_CODE.ACCID);
		acc.deposit(money);
		accountDao.updateAccount(acc);
		return acc;
	}

	@Override
	public Account withdraw(String id, Integer money) throws Exception {
		Account acc = accountDao.selectAccount(id);
		if(acc==null) throw new BankException(ERR_CODE.ACCID);
		acc.withdraw(money);
		accountDao.updateAccount(acc);
		return acc;
	}

	@Override
	public Account accountInfo(String id) throws Exception {
		Account acc = accountDao.selectAccount(id);
		if(acc==null)throw new BankException(ERR_CODE.ACCID);
		return acc;
	}

	@Override
	public List<Account> allAccountInfo() throws Exception {
		List<Account> accList = accountDao.selectAccountList();
		if(accList.size() == 0) throw new BankException(ERR_CODE.NODATA);
		
		return accList;
	}

	@Override
	public Account transfer(String sid, String rid, Integer money) throws Exception {
		Account send = accountDao.selectAccount(sid);
		if(send == null) throw new BankException(ERR_CODE.SENDACCID);
		Account receive = accountDao.selectAccount(rid);
		if(receive == null) throw new BankException(ERR_CODE.RECVACCID);
		send.withdraw(money);
		receive.deposit(money);
		accountDao.updateAccount(receive);
		accountDao.updateAccount(send);
		return send;
	}

}
