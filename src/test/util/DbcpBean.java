package test.util;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DbcpBean {
	private Connection conn;
	//생성자에서 Connection 객체를 얻어온다.
	public DbcpBean(){
		try{
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
			conn = ds.getConnection();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//Connection 객체 리턴하는 함수
	public Connection getConn(){
		return conn;
	}
}
