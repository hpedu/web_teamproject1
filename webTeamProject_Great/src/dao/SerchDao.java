package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.OracleInfo;
import model.vo.BoardVO1;

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
	public ArrayList<BoardVO1> searchRe(String writer) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<BoardVO1> list = new ArrayList<BoardVO1>();
		try {
			conn= getConnect();
			String query = "SELECT no, title, writer, password, content, hits, time_posted FROM board WHERE writer LIKE '%"+writer+"%'";
			ps = conn.prepareStatement(query);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new BoardVO1(rs.getInt("no"),rs.getString("title"),
						rs.getString("writer"),rs.getString("password"),rs.getString("content"),
						rs.getInt("hits"), rs.getString("time_posted")));
			}
		}finally {
			closeAll(rs, ps, conn);
		}
		return list;
	}
	
	public static void main(String[] args) throws SQLException {

		ArrayList<BoardVO1> list = SearchDao.getInstance().searchRe("1");
		for(BoardVO1 b : list)
			System.out.println(b);
	}
}

