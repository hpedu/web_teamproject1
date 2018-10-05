package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.OracleInfo;
import model.vo.BoardVO1;
import query.ShowQuery;

public class SearchDao {

	private String url;
	private String user;
	private String pass;
	
	
	
	static private SearchDao dao = new SearchDao();
	private SearchDao( ) {								
				url=OracleInfo.URL;
				user=OracleInfo.USER;
				pass=OracleInfo.PASS;
	};
	 
	public static SearchDao getInstance() {
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
	
	public ArrayList<BoardVO1> searchRecipe(String[] words) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<BoardVO1> list = new ArrayList<BoardVO1>();
		try {
			conn= getConnect();
			for(int i=0; i <= words.length-1;i++) {
				String query = "SELECT no, title, writer, password, content, hits, time_posted FROM board WHERE title LIKE '%"+words[i]+"%'"
						+ " OR content LIKE '%"+words[i]+"%' ORDER BY hits DESC";
				ps = conn.prepareStatement(query);
				
				rs = ps.executeQuery();
				while(rs.next()) {
					list.add(new BoardVO1(rs.getInt("no"),rs.getString("title"),
							rs.getString("writer"),rs.getString("password"),rs.getString("content"),
							rs.getInt("hits"), rs.getString("time_posted")));
				}
			}
		}finally {
			closeAll(rs, ps, conn);
		}
		return list;
	}
	
	// hits순 상위 5개만 보여지게
	public ArrayList<BoardVO1> searchRecommand() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<BoardVO1> list = new ArrayList<BoardVO1>();
		try {
			conn= getConnect();
			ps = conn.prepareStatement(ShowQuery.RECOMMEND_RECIPE);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new BoardVO1(rs.getInt("no"),rs.getString("title"),
						rs.getString("writer"),rs.getString("content"),
						rs.getInt("hits")));
			}
			
		}finally {
			closeAll(rs, ps, conn);
		}
		return list;
	}
	
	
	public static void main(String[] args) throws SQLException {

		String[] str= {"소","아리","김"};
		ArrayList<BoardVO1> list = SearchDao.getInstance().searchRecipe(str);
		for(BoardVO1 b : list)
			System.out.println(b);
		

/*		ArrayList<BoardVO1> list = SearchDao.getInstance().searchRecommand();
		for(BoardVO1 b : list)
			System.out.println(b);*/
	}
}

