package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.OracleInfo;

public class MemberDao {

	private String url;
	private String user;
	private String pass;
	
	
	
	static private MemberDao dao = new MemberDao();
	private MemberDao( ) {								
				url=OracleInfo.URL;
				user=OracleInfo.USER;
				pass=OracleInfo.PASS;
	};
	 
	public static MemberDao getInstance() {
		return dao;
	}
	
	
	

	private Connection getConnect() throws SQLException {

		Connection conn = DriverManager.getConnection(url, user, pass);
		System.out.println("db connection....");
		return conn;
	}

	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		if (ps != null)
			ps.close();
		if (conn != null)
			conn.close();
	}

	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		if (rs != null)
			rs.close();
		closeAll(ps, conn);
	}
	public static void main(String[] args) throws SQLException {
		Connection conn = MemberDao.getInstance().getConnect();
		
		System.out.println("ss");
	}
}
