package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import config.MybatisSqlSessionFactory;
import dto.Account;
import exc.BankException;
import exc.ERR_CODE;

public class AccountDaoImpl implements AccountDao {

	@Override
	public void insertAccount(Account acc) throws Exception {
		SqlSession sqlSession = MybatisSqlSessionFactory.getSqlSessionFactory().openSession();
		try {
			sqlSession.insert("mapper.account.insertAccount",acc);
			sqlSession.commit();
		} catch(Exception e) {
			sqlSession.rollback();
			throw e;
		} finally {
			sqlSession.close();
		}
		

	}

	@Override
	public void updateAccount(Account acc) throws Exception {
		SqlSession sqlSession = MybatisSqlSessionFactory.getSqlSessionFactory().openSession();
		try {
			sqlSession.update("mapper.account.updateBalance", acc);
			sqlSession.commit();
		}catch(Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
			throw e;
		} finally {
			sqlSession.close();
		}

	}

	@Override
	public Account selectAccount(String id) throws Exception {
		Account acc = null;
		try(SqlSession sqlSession = MybatisSqlSessionFactory.getSqlSessionFactory().openSession()) {
			acc = sqlSession.selectOne("mapper.account.selectAccount", id);
		} catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
		return acc;
	}

	@Override
	public List<Account> selectAccountList() throws Exception {
		// TODO Auto-generated method stub
		try(SqlSession sqlSession = MybatisSqlSessionFactory.getSqlSessionFactory().openSession()) {
			return sqlSession.selectList("mapper.account.accountList");
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public Account transfer(String sid, String rid, Integer money) throws Exception {
		SqlSession sqlSession = MybatisSqlSessionFactory.getSqlSessionFactory().openSession();
		Account sacc = null;
		try {
			sacc = selectAccount(sid);
			if(sacc==null) throw new BankException(ERR_CODE.SENDACCID);
			Account racc = selectAccount(rid);
			if(racc==null) throw new BankException(ERR_CODE.RECVACCID);
			sacc.withdraw(money);
			racc.deposit(money);
			sqlSession.update("mapper.account.updateBalance", sacc);
			sqlSession.update("mapper.account.updateBalance", racc);
			sqlSession.commit();
		} catch(Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
			throw e;
		} finally {
			sqlSession.close();
		}
		
		return sacc;
		
	}

}
