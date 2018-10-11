package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.OracleInfo;
import model.vo.BoardVO1;
import model.vo.ProductVO;
import model.vo.RecipeVO;
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
	
	public ArrayList<RecipeVO> searchRecipe(String[] words) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<RecipeVO> list = new ArrayList<RecipeVO>();
		try {
			conn= getConnect();
			for(int i=0; i <= words.length-1;i++) {
				String query = "SELECT no, name, writer,name,imgurls, writer,register_date, type, hits FROM recipe WHERE name LIKE '%"+words[i]+"%'"
						+ " OR content LIKE '%"+words[i]+"%' ORDER BY hits DESC";
				ps = conn.prepareStatement(query);
				
				rs = ps.executeQuery();
				while(rs.next()) {
					list.add(new RecipeVO(rs.getInt("no"),rs.getString("name"),rs.getString("imgurls"),
							rs.getString("writer"), rs.getString("register_date"),rs.getString("type"),rs.getInt("hits")));
				}
			}
		}finally {
			closeAll(rs, ps, conn);
		}
		return list;
	}
	
	public ArrayList<ProductVO> serchRecipeProduct(String word) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<ProductVO> list = new ArrayList<ProductVO>();
		String[] words = word.split(",");
		try {
			conn= getConnect();
			for(int i=0; i <= words.length-1;i++) {
				String query = "SELECT name, price, imgurls, type FROM product WHERE name LIKE '%"+words[i]+"%'"
						+ " OR content LIKE '%"+words[i]+"%' order by hits desc ";
				ps = conn.prepareStatement(query);
				
				rs = ps.executeQuery();
				while(rs.next()) {
					list.add(new ProductVO(rs.getString("name"), rs.getInt("price"), rs.getString("imgurls"), rs.getString("type")));
				}
			}
		}finally {
			closeAll(rs, ps, conn);
		}
		return list;
	}
	// hits순 상위 5개만 보여지게
	public ArrayList<BoardVO1> showRecommandRecipe() throws SQLException {
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
						rs.getString("hits")));
			}
			
		}finally {
			closeAll(rs, ps, conn);
		}
		return list;
	}
	
	
	public static void main(String[] args) throws SQLException {

		/*String[] str= {"소","아리","김"};
		ArrayList<RecipeVO> list = SearchDao.getInstance().searchRecipe(str);
		for(BoardVO1 b : list)
			System.out.println(b);*/
		

/*		ArrayList<BoardVO1> list = SearchDao.getInstance().searchRecommand();
		for(BoardVO1 b : list)
			System.out.println(b);*/
	}
}

