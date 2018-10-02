package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.OracleInfo;
import model.BoardVO;
import query.StringQuery;

public class CUDdao {

	private String url;
	private String user;
	private String pass;
	
	
	
	static private CUDdao dao = new CUDdao();
	private CUDdao( ) {								
				url=OracleInfo.URL;
				user=OracleInfo.USER;
				pass=OracleInfo.PASS;
	};
	 
	public static CUDdao getInstance() {
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
		Connection conn = CUDdao.getInstance().getConnect();
		
		System.out.println("ss");
	}
	
	public void recipeWrite(RecipeVO vo) throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			ps = conn.prepareStatement(StringQuery.INSERT_RECIPE);
			
			ps.setString(1, vo.getname());
			ps.setString(2, vo.getimgurls());
			ps.setString(3, vo.getmain_ingredientents());
			ps.setString(4, vo.getsub_ingredientents());
			ps.setString(5, vo.writer());
			ps.setString(6, vo.date());
			ps.setString(7, vo.type());
			ps.setint(8, vo.hits());
			ps.setString(9, vo.descript());			
			ps.setString(10, vo.content());
			ps.setString(11, vo.tip());
			
						
			int row = ps.executeUpdate();
			System.out.println(row+" row insert recipe ok....");
			
			System.out.println("dao CURRENT_NO...before...."+vo.getNo());//x
			
			ps = conn.prepareStatement(StringQuery.CURRENT_NO);
			rs = ps.executeQuery();
			if(rs.next()) 
				vo.setNo(rs.getInt(1));
			
			System.out.println("dao CURRENT_NO...after...."+vo.getNo());//o
		}finally{
			closeAll(ps, conn);
		}
	}	
	
	
	public void reviewWrite(ReviewVO vo) throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			ps = conn.prepareStatement(StringQuery.INSERT_REVIEW);
			
			ps.setString(1, vo.getwritere());
			ps.setString(2, vo.getimg_urls());
			ps.setString(3, vo.date());
			ps.setString(4, vo.content());
			
			
						
			int row = ps.executeUpdate();
			System.out.println(row+" row insert review ok....");
			
			System.out.println("dao CURRENT_NO...before...."+vo.getNo());//x
			
			ps = conn.prepareStatement(StringQuery.CURRENT_NO);
			rs = ps.executeQuery();
			if(rs.next()) 
				vo.setNo(rs.getInt(1));
			
			System.out.println("dao CURRENT_NO...after...."+vo.getNo());//o
		}finally{
			closeAll(ps, conn);
		}
	}	
	
	public void productWrite(ProductVO vo) throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			ps = conn.prepareStatement(StringQuery.INSERT_PRODUCT);
			
			ps.setString(1, vo.getname());
			ps.setString(2, vo.price());
			ps.setString(3, vo.origin());
			ps.setString(4, vo.img_urls());
			ps.setString(5, vo.content());
			ps.setString(6, vo.type());
			ps.setString(7, vo.brand());
			
		
						
			int row = ps.executeUpdate();
			System.out.println(row+" row insert product ok....");
			
			System.out.println("dao CURRENT_NO...before...."+vo.getNo());//x
			
			ps = conn.prepareStatement(StringQuery.CURRENT_NO);
			rs = ps.executeQuery();
			if(rs.next()) 
				vo.setNo(rs.getInt(1));
			
			System.out.println("dao CURRENT_NO...after...."+vo.getNo());//o
		}finally{
			closeAll(ps, conn);
		}
	}	
	
	public void deleteRecipe(int no) throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnection();
			ps = conn.prepareStatement(StringQuery.DELETE_RECIPE);
			ps.setInt(1, no);
			int row = ps.executeUpdate();
			System.out.println(row+ "ROW DELETE OK!!! ");
		}finally {
			closeAll(ps, conn);
		}
	}
	
	public void deleteReview(int no) throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnection();
			ps = conn.prepareStatement(StringQuery.DELETE_REVIEW);
			ps.setInt(1, no);
			int row = ps.executeUpdate();
			System.out.println(row+ "ROW DELETE OK!!! ");
		}finally {
			closeAll(ps, conn);
		}
	}
	
	public void deleteProduct(int no) throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnection();
			ps = conn.prepareStatement(StringQuery.DELETE_PRODUCT);
			ps.setInt(1, no);
			int row = ps.executeUpdate();
			System.out.println(row+ "ROW DELETE OK!!! ");
		}finally {
			closeAll(ps, conn);
		}
	}
	
	public void updateRecipe(RecipeVO vo)throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnection();
			ps = conn.prepareStatement(StringQuery.UPDATE_RECIPE);			
			
			ps.setString(1, vo.getname());
			ps.setString(2, vo.getimgurls());
			ps.setString(3, vo.getmain_ingredientents());
			ps.setString(4, vo.getsub_ingredientents());
			ps.setString(5, vo.writer());
			ps.setString(6, vo.date());
			ps.setString(7, vo.type());
			ps.setint(8, vo.hits());
			ps.setString(9, vo.descript());			
			ps.setString(10, vo.content());
			ps.setString(11, vo.tip());
			
			
			int row=  ps.executeUpdate();
			System.out.println(row+" ROW UPDATE OK!!!");
		}finally {
			closeAll(ps, conn);
		}
	}
	
	public void updateReview(ReviewVO vo)throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnection();
			ps = conn.prepareStatement(StringQuery.UPDATE_REVIEW);			
			
			ps.setString(1, vo.getwritere());
			ps.setString(2, vo.getimg_urls());
			ps.setString(3, vo.date());
			ps.setString(4, vo.content());
			
			
			int row=  ps.executeUpdate();
			System.out.println(row+" ROW UPDATE OK!!!");
		}finally {
			closeAll(ps, conn);
		}
	}
	
	public void updateProduct(ProductVO vo)throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnection();
			ps = conn.prepareStatement(StringQuery.UPDATE_PRODUCT);			
			
			ps.setString(1, vo.getname());
			ps.setString(2, vo.price());
			ps.setString(3, vo.origin());
			ps.setString(4, vo.img_urls());
			ps.setString(5, vo.content());
			ps.setString(6, vo.type());
			ps.setString(7, vo.brand());
			
						
			int row=  ps.executeUpdate();
			System.out.println(row+" ROW UPDATE OK!!!");
		}finally {
			closeAll(ps, conn);
		}
	}
	
	public static void main(String[] args) {
		cuddao
	}
}
