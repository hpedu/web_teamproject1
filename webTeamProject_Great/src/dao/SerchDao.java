package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.OracleInfo;
import model.vo.BoardVO;

public class SerchDao {

	private String url;
	private String user;
	private String pass;
	
	
	
	static private SerchDao dao = new SerchDao();
	private SerchDao( ) {								
				url=OracleInfo.URL;
				user=OracleInfo.USER;
				pass=OracleInfo.PASS;
	};
	 
	public static SerchDao getInstance() {
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
	public ArrayList<BoardVO> searchRe(String writer) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		try {
			conn= getConnect();
			String query = "SELECT no, title, writer, password, content, hits, time_posted FROM board WHERE writer LIKE '%"+writer+"%'";
			ps = conn.prepareStatement(query);
			
			rs = ps.executeQuery();
			while(rs.next()) {
					}
		}finally {
			closeAll(rs, ps, conn);
		}
		return list;
	}
	
	public static void main(String[] args) throws SQLException {

		ArrayList<BoardVO> list = SerchDao.getInstance().searchRe("1");
		for(BoardVO b : list)
			System.out.println(b);
	}
}

