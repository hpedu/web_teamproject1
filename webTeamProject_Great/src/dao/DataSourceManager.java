package dao;
/*
 * DataSource�� �ϳ� ���Ϲ޴� ������ DaoŬ������ ������ �ȿ��� �ߴ�
 * �̶� NamingService�� ����ߴ�(Context,lookup())
 * 
 * �� �κ��� DAO�� �����ڰ� �ƴ϶� DAtaSourceManager��� ������ Ŭ������ �����
 * �̰����� �ش������ ���� �ϰڴ�.
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
