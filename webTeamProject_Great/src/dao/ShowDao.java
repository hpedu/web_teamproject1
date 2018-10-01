package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.OracleInfo;

public class ShowDao {

	private String url;
	private String user;
	private String pass;

	static private ShowDao dao = new ShowDao();
	private ShowDao( ) {								
				url=OracleInfo.URL;
				user=OracleInfo.USER;
				pass=OracleInfo.PASS;
	};
	 
	public static ShowDao getInstance() {
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
	
	public ArrayList<BoardVo> showNotice throws SQLException {
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			try {
				conn = getConnection();
				ps = conn.prepareStatement(StringQuery.INSERT_POSTING);
				ps.setString(1, vo.getTitle());
				ps.setString(2, vo.getWriter());
				ps.setString(3, vo.getPassword());
				ps.setString(4, vo.getContent());

				int row = ps.executeUpdate();
				System.out.println(row + " row insert Posting ok...");

				ps = conn.prepareStatement(StringQuery.CURRENT_NO);
				rs = ps.executeQuery();
				if (rs.next()) {
					vo.setNo(rs.getInt(1));
				}
				System.out.println("Dao current no? " + vo.getNo());
			} finally {
				closeAll(rs, ps, conn);
			}
		}
	}
	
	
	
	public static void main(String[] args) throws SQLException {
		Connection conn = ShowDao.getInstance().getConnect();
		
		System.out.println("ss");
	}
	
	
}
