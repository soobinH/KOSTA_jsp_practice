package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.Member;

public class MemberDaoImpl implements MemberDao{

	public void insertMember(Member member)throws Exception {
		String sql = "insert into member(id, name, password, email, address) values(?, ?, ?,?,?)";
		Connection conn = JdbcUtil.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getName());
			pstmt.setString(3, member.getPassword());
			pstmt.setString(4, member.getEmail());
			pstmt.setString(5, member.getAddress());
			pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
	}
	
	public Member selectMember(String id)throws Exception{
		String sql = "select * from member where id=?";
		Connection conn= JdbcUtil.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rset = null;
		Member member= null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rset =pstmt.executeQuery();
			if(rset!=null && rset.next()) {
				member =new Member();
				member.setId(rset.getString("id"));
				member.setName(rset.getString("name"));
				member.setPassword(rset.getString("password"));
				member.setEmail(rset.getString("email"));
				member.setAddress(rset.getString("address"));
				
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rset);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		return member;
	}
}
