package dao;
/*
 * DataSource를 하나 리턴받는 로직은 Dao클래스의 생성자 안에서 했다
 * 이때 NamingService를 사용했다(Context,lookup())
 * 
 * 이 부분을 DAO의 생성자가 아니라 DAtaSourceManager라는 별도의 클래스를 만들고
 * 이곳에서 해당로직을 진행 하겠다.
 */

import java.sql.Connection;
import java.sql.DriverManager;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DataSourceManager {
	private Connection conn;
	private DataSource ds;
	
	private static DataSourceManager instance = new DataSourceManager();
	
	private DataSourceManager() {
		try {	Context ic = new InitialContext();
				ds=(DataSource)ic.lookup("java:comp/env/jdbc/oracleDB");
				System.out.println("DataSource Lookup");
		}catch(Exception e){
			System.out.println("ds lookup fail");
		}
	}
	public static DataSourceManager getInstance() {
		return instance;
	}
	
	public DataSource getconnection(){

		return ds;	
	}
}
