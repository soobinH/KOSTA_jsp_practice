package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dto.Account;

public class AccountDaoImpl implements AccountDao {

	@Override
	public void insertAccount(Account acc) throws Exception {
		String sql = "insert into account(id, name, balance,type, grade) values(?, ?,?,?,?)";
		Connection conn = JdbcUtil.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,  acc.getId());
			pstmt.setString(2,  acc.getName());
			pstmt.setInt(3,  acc.getBalance());
			pstmt.setString(4, acc.getType());
			pstmt.setString(5, acc.getGrade());
			pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		

	}

	@Override
	public void updateAccount(Account acc) throws Exception {
		String sql = "update account set balance=? where id=?";
		Connection conn = JdbcUtil.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,  acc.getBalance());
			pstmt.setString(2, acc.getId());
			pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}

	}

	@Override
	public Account selectAccount(String id) throws Exception {
		String sql = "select id, name, balance, type, grade from account where id=?";
		Connection conn =JdbcUtil.getConnection();
		PreparedStatement pstmt= null;
		ResultSet rset = null;
		Account acc = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,  id);
			rset = pstmt.executeQuery();
			if(rset!=null && rset.next()) {
				acc = new Account();
				acc.setId(rset.getString("id"));
				acc.setName(rset.getString("name"));
				acc.setBalance(rset.getInt("balance"));
				acc.setType(rset.getString("type"));
				acc.setGrade(rset.getString("grade"));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rset);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		
		return acc;
	}

	@Override
	public List<Account> selectAccountList() throws Exception {
		String sql = "select * from account";
		Connection conn = JdbcUtil.getConnection();
		Statement stmt = null;
		ResultSet rset = null;
		List<Account> accList = new ArrayList<>();
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);
			if(rset!=null) {
				while(rset.next()) {
					Account acc = new Account();
					acc.setId(rset.getString("id"));
					acc.setName(rset.getString("name"));
					acc.setBalance(rset.getInt("balance"));
					acc.setType(rset.getString("type"));
					acc.setGrade(rset.getString("grade"));
					accList.add(acc);
				}
			} 
		}catch(SQLException e) {
				e.printStackTrace();
			} finally {
				JdbcUtil.close(rset);
				JdbcUtil.close(stmt);
				JdbcUtil.close(conn);
			
				}
		return accList;
	}

}
