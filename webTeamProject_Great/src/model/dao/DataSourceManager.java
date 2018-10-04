package model.dao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
/*
 * was ���� �����ϴ� ResourceFactory�� ã�ƿ��� ���..�̶� Jndi Service�� �̿��Ѵ�
 */
public class DataSourceManager {
	private DataSource ds;
	private static DataSourceManager instance = new DataSourceManager();
	private DataSourceManager(){
		try{
			Context ic = new InitialContext();
			ds=(DataSource)ic.lookup("java:comp/env/jdbc/oracleDB");
			System.out.println("DataSource Lookup.....");
		}catch(NamingException e){
			e.printStackTrace();
		}
	}
	public static DataSourceManager getInstance(){
		return instance;
	}
	
	public DataSource getConnection(){
		return ds;
	}
}








