package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class JdbcUtil {
	
	public static Connection getConnection() {
		Connection conn = null;
		
		try {
			Context initCtx =new InitialContext();
			Context envCtx=(Context)initCtx.lookup("java:/comp/env");
			DataSource ds = (DataSource)envCtx.lookup("jdbc/kosta");
			conn=ds.getConnection();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
//		try (InputStream in = JdbcUtil.class.getResourceAsStream("db.properties")){
//			props.load(in);
//			String driver = props.getProperty("driver");
//			String url = props.getProperty("url");
//			String username = props.getProperty("username");
//			String password = props.getProperty("password");
//			Class.forName(driver);
//			conn=DriverManager.getConnection(url,username,password);
//		} catch(IOException e) {
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} catch(SQLException e) {
//			e.printStackTrace();
//		}
		
		return conn;
	}
	
	public static void close(Connection conn) {
		try {
			if(conn!=null) conn.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Statement stmt) {
		try {
			if(stmt!=null) stmt.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}	
	
	public static void close(ResultSet rset) {
		try {
			if(rset!=null) rset.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
