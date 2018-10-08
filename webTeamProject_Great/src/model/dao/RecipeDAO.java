package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import model.vo.RecipeVO;
import query.StringQuery;

public class RecipeDAO {
  /*private int num;
	private String name;
	private String imgurls;
	private String main_ingredientents;
	private String sub_ingredientents;
	private String writer;
	private String register_date;
	private String type;
	private int hits;
	private String descript;
	private String content;
	private String tip;
	private boolean recommend;
	*/
	DataSource ds;
	private static RecipeDAO dao= RecipeDAO();
	private RecipeDAO() {
		ds=DataSourceManager.getInstance().getConnection();
	}
	public static RecipeDAO RecipeDAO() {
		
		return dao;
	}
	public Connection getConnection() throws SQLException{
		return ds.getConnection();
	}
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException{
		if(ps!=null) ps.close();
		if(conn!=null) conn.close();
	}
	public void closeAll(ResultSet rs,PreparedStatement ps, Connection conn) throws SQLException{
		if(rs!=null) rs.close();
		closeAll(ps, conn);
	}
	
	//레시피 등록
		public void registerRecipe(RecipeVO mvo) throws SQLException{
			Connection conn = null;
			PreparedStatement ps = null;
			try{
				//id,password,name,email,birthday,address
				conn=getConnection();
				ps = conn.prepareStatement(StringQuery.INSERT_RECIPE);
				ps.setInt(1, 1);
				ps.setString(2, mvo.getName());
				ps.setString(3, mvo.getImgurls());
				ps.setString(4, mvo.getMain_ingredientents());
				ps.setString(5, mvo.getSub_ingredientents());
				ps.setString(6, mvo.getWriter());
				ps.setString(7, mvo.getDate());
				ps.setString(8, mvo.getType());
				ps.setInt(9, mvo.getHits());
				ps.setString(10, mvo.getDescript());
				ps.setString(11, mvo.getContent());
				ps.setString(12, mvo.getTip());
				if(ps.executeUpdate()!=0){
					System.out.println(mvo.getName()+" 메뉴 등록 성공!!");
				}
			}finally{
				closeAll(ps, conn);
			}
		}
}
