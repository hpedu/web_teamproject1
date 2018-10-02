package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.OracleInfo;
import model.vo.ProductVO;
import model.vo.RecipeVO;
import model.vo.ReviewVO;
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
	

	
	public void recipeWrite(RecipeVO vo) throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = getConnect();
			ps = conn.prepareStatement(StringQuery.INSERT_RECIPE);
			
			ps.setInt(1, vo.getNo());
			ps.setString(2, vo.getName());
			ps.setString(3, vo.getImgurls());
			ps.setString(4, vo.getMain_ingredientents());
			ps.setString(5, vo.getSub_ingredientents());
			ps.setString(6, vo.getWriter());
			
			ps.setString(7, vo.getType());
			ps.setInt(8, vo.getHits());
			ps.setString(9, vo.getDescript());			
			ps.setString(10, vo.getContent());
			ps.setString(11, vo.getTip());
			
						
			int row = ps.executeUpdate();
			System.out.println(row+" row insert recipe ok....");
			
			System.out.println("dao CURRENT_NO...before...."+vo.getName());//x
		
			
		}finally{
			closeAll(ps, conn);
		}
	}	
	
	
	public void reviewWrite(ReviewVO vo) throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = getConnect();
			ps = conn.prepareStatement(StringQuery.INSERT_REVIEW);
			
			ps.setInt(1, vo.getNo());
			ps.setString(2, vo.getWriter());
			ps.setString(3, vo.getImg_urls());
			
			ps.setString(4, vo.getContent());
			
			
						
			int row = ps.executeUpdate();
			System.out.println(row+" row insert review ok....");
			
			System.out.println("dao CURRENT_NO...before...."+vo.getWriter());//x
			
		/*	ps = conn.prepareStatement(StringQuery.CURRENT_NO);
			rs = ps.executeQuery();
			if(rs.next()) 
				vo.setNo(rs.getInt(1));
			
			System.out.println("dao CURRENT_NO...after...."+vo.getWriter());//o
*/		}finally{
			closeAll(ps, conn);
		}
	}	
	
	public void productWrite(ProductVO vo) throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = getConnect();
			ps = conn.prepareStatement(StringQuery.INSERT_PRODUCT);
			
			ps.setString(1, vo.getName());
			ps.setInt(2, vo.getPrice());
			ps.setString(3, vo.getOrigin());
			ps.setString(4, vo.getImg_urls());
			ps.setString(5, vo.getContent());
			ps.setString(6, vo.getType());
			ps.setString(7, vo.getBrand());
			ps.setInt(8, vo.getSales_volume());
			ps.setString(9, vo.getRecommend());
			
		
						
			int row = ps.executeUpdate();
			System.out.println(row+" row insert product ok....");
			
			System.out.println("dao CURRENT_NO...before...."+vo.getName());//x
			
			
		}finally{
			closeAll(ps, conn);
		}
	}	
	
	public void deleteRecipe(int no) throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnect();
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
			conn = getConnect();
			ps = conn.prepareStatement(StringQuery.DELETE_REVIEW);
			ps.setInt(1, no);
			int row = ps.executeUpdate();
			System.out.println(row+ "ROW DELETE OK!!! ");
		}finally {
			closeAll(ps, conn);
		}
	}
	
	public void deleteProduct(String name) throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnect();
			ps = conn.prepareStatement(StringQuery.DELETE_PRODUCT);
			ps.setString(1, name);
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
			conn = getConnect();
			ps = conn.prepareStatement(StringQuery.UPDATE_RECIPE);			
			
			//String UPDATE_RECIPE="UPDATE recipe SET name=?, img_urls=? , main_ingredients=?, sub_ingredients=?, writer=?, type=?, hits=?, descript=?, content=?, tip=? WHERE no=?";
			ps.setString(1, vo.getName());
			ps.setString(2, vo.getImgurls());
			ps.setString(3, vo.getMain_ingredientents());
			ps.setString(4, vo.getSub_ingredientents());
			ps.setString(5, vo.getWriter());
			
			ps.setString(6, vo.getType());
			ps.setInt(7, vo.getHits());
			ps.setString(8, vo.getDescript());			
			ps.setString(9, vo.getContent());
			ps.setString(10, vo.getTip());
			ps.setInt(11, vo.getNo());
			
			
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
			conn = getConnect();
			ps = conn.prepareStatement(StringQuery.UPDATE_REVIEW);			
			
			ps.setString(1, vo.getWriter());
			ps.setString(2, vo.getImg_urls());
		
			ps.setString(3, vo.getContent());
			ps.setInt(4, vo.getNo());
			
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
			conn = getConnect();
			ps = conn.prepareStatement(StringQuery.UPDATE_PRODUCT);			
			
			
			
			ps.setInt(1, vo.getPrice());
			ps.setString(2, vo.getOrigin());
			ps.setString(3, vo.getImg_urls());
			ps.setString(4, vo.getContent());
			ps.setString(5, vo.getType());
			ps.setString(6, vo.getBrand());
			ps.setString(7, vo.getRecommend());
			ps.setInt(8, vo.getSales_volume());
			ps.setString(9, vo.getName());
			
			int row=  ps.executeUpdate();
			System.out.println(row+" ROW UPDATE OK!!!");
		}finally {
			closeAll(ps, conn);
		}
	}
	
	public static void main(String[] args) throws SQLException {
		Connection conn = CUDdao.getInstance().getConnect();
		
		/*RecipeVO rvo = new RecipeVO(0, "aaa","aaa","aaa","aaa","aaa","aaa",1,"aaa","aaa","aaa");
		CUDdao.getInstance().recipeWrite(rvo);*/
		
		
		
		/*ReviewVO rvo = new ReviewVO(1, "bbb", "bbb", "bbb");
		CUDdao.getInstance().reviewWrite(rvo);*/
		
				
	/*	ProductVO rvo =new ProductVO("ccc",1,"ccc","ccc","ccc","ccc","ccc",2,"ccc");
		CUDdao.getInstance().productWrite(rvo);*/
		
		//CUDdao.getInstance().deleteRecipe(0);
		
		/*CUDdao.getInstance().deleteReview(1);*/
		
		/*CUDdao.getInstance().deleteProduct("ccc");*/
		
		/*RecipeVO rvo = new RecipeVO(0, "ddd", "ddd", "ddd", "ddd", "ddd", "ddd", 0, "ddd", "ddd", "ddd");
		CUDdao.getInstance().updateRecipe(rvo);*/
		
		/*ReviewVO rvo = new ReviewVO(0, "ccc", "ccc", "ccc");
		CUDdao.getInstance().updateReview(rvo);*/
		
		/*ProductVO rvo = new ProductVO("ccc", 2, "aaa", "aaa", "aaa", "aaa", "aaa", 2, "aaa");
		CUDdao.getInstance().updateProduct(rvo);*/
		
		
		System.out.println("rvo");
	}

}
