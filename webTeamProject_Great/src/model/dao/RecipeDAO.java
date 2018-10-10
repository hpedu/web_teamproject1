package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import model.vo.RecipeVO;
import query.ShowQuery;
import query.StringQuery;

public class RecipeDAO {
  
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
		
		public void recipeWrite(RecipeVO vo) throws SQLException{
			Connection conn = null;
			PreparedStatement ps = null;

			try {
				conn = getConnection();
				ps = conn.prepareStatement(StringQuery.INSERT_RECIPE);
				
				ps.setInt(1, vo.getNum());
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
		
		//레시피삭제
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
		
		//레시피수정
		public void updateRecipe(RecipeVO vo)throws SQLException{
			Connection conn = null;
			PreparedStatement ps = null;
			try {
				conn = getConnection();
				ps = conn.prepareStatement(StringQuery.UPDATE_RECIPE);			
				
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
				ps.setInt(11, vo.getNum());
				
				
				int row=  ps.executeUpdate();
				System.out.println(row+" ROW UPDATE OK!!!");
			}finally {
				closeAll(ps, conn);
			}
		}
		
		
		
		
		
		//--------------------------------------------------------------------------------------------------
		//----------------------------------------show
		
		//관련레시피
		 public ArrayList<RecipeVO> showRelatedRecipe(int no) throws SQLException{
		      Connection conn = null;
		      PreparedStatement ps = null;
		      ResultSet rs = null;
		      ArrayList<RecipeVO> list = new ArrayList<RecipeVO>();
		      try {
		         conn = getConnection();
		         ps = conn.prepareStatement(ShowQuery.SELECT_SHOWRELATEDRECIPE);
		         ps.setInt(1, no);
		         rs = ps.executeQuery();
		         while (rs.next()) {
		            list.add(new RecipeVO(rs.getInt("no"), rs.getString("name"), rs.getString("img_urls"),
		                  rs.getString("main_ingredients"), rs.getString("sub_ingredients"), rs.getString("writer"),
		                  rs.getString("register_date"), rs.getString("type"), rs.getInt("hits"),
		                  rs.getString("descript"), rs.getString("content"), rs.getString("tip"),
		                  rs.getString("recommand")));
		         }
		      } finally {
		         closeAll(rs, ps, conn);
		      }
		      return list;
		   }
		 
		 //추천레시피
		 public ArrayList<RecipeVO> showRecipeRecommend() throws SQLException {
		      Connection conn = null;
		      PreparedStatement ps = null;
		      ResultSet rs = null;
		      ArrayList<RecipeVO> list = new ArrayList<RecipeVO>();
		      try {
		         conn = getConnection();
		         ps = conn.prepareStatement(ShowQuery.SELECT_SHOWRECOMMENDRECIPE);
		         rs = ps.executeQuery();
		         while (rs.next()) {
		            list.add(new RecipeVO(rs.getInt("no"), rs.getString("name"), rs.getString("img_urls"),
		                  rs.getString("main_ingredients"), rs.getString("sub_ingredients"), rs.getString("writer"),
		                  rs.getString("register_date"), rs.getString("type"), rs.getInt("hits"),
		                  rs.getString("descript"), rs.getString("content"), rs.getString("tip"),
		                  rs.getString("recommend")));
		         }
		      } finally {
		         closeAll(rs, ps, conn);
		      }
		      return list;
		   }
		 
		 //최신레시피
		 public ArrayList<RecipeVO> showRecipeNew() throws SQLException {
		      Connection conn = null;
		      PreparedStatement ps = null;
		      ResultSet rs = null;
		      ArrayList<RecipeVO> list = new ArrayList<RecipeVO>();
		      try {
		         conn = getConnection();
		         ps = conn.prepareStatement(ShowQuery.SELECT_SHOWNEWRECIPE);
		         rs = ps.executeQuery();
		         while (rs.next()) {
		            list.add(new RecipeVO(rs.getInt("no"), rs.getString("name"), rs.getString("img_urls"),
		                  rs.getString("main_ingredients"), rs.getString("sub_ingredients"), rs.getString("writer"),
		                  rs.getString("register_date"), rs.getString("type"), rs.getInt("hits"),
		                  rs.getString("descript"), rs.getString("content"), rs.getString("tip"),
		                  rs.getString("recommend")));
		         }
		      } finally {
		         closeAll(rs, ps, conn);
		      }
		      return list;
		   }
		 
		 //핫한 레시피
		 public ArrayList<RecipeVO> showRecipeHot() throws SQLException {
		      Connection conn = null;
		      PreparedStatement ps = null;
		      ResultSet rs = null;
		      ArrayList<RecipeVO> list = new ArrayList<RecipeVO>();
		      try {
		         conn = getConnection();
		         ps = conn.prepareStatement(ShowQuery.SELECT_SHOWHOTRECIPE);
		         rs = ps.executeQuery();
		         while (rs.next()) {
		            list.add(new RecipeVO(rs.getInt("no"), rs.getString("name"), rs.getString("img_urls"),
		                  rs.getString("main_ingredients"), rs.getString("sub_ingredients"), rs.getString("writer"),
		                  rs.getString("register_date"), rs.getString("type"), rs.getInt("hits"),
		                  rs.getString("descript"), rs.getString("content"), rs.getString("tip"),
		                  rs.getString("recommend")));
		         }
		      } finally {
		         closeAll(rs, ps, conn);
		      }
		      return list;
		   }
		 
		 
		 //레시피 디테일
		   public RecipeVO showRecipe(int no) throws SQLException {
		      Connection conn = null;
		      PreparedStatement ps = null;
		      ResultSet rs = null;
		      RecipeVO vo = null;
		      try {
		         conn = getConnection();
		         ps = conn.prepareStatement(ShowQuery.SELECT_SHOWRECIPE);
		         ps.setInt(1, no);
		         rs = ps.executeQuery();
		         if (rs.next()) {
		            vo =new RecipeVO(rs.getInt("no"), rs.getString("name"), rs.getString("img_urls"),
		                  rs.getString("main_ingredients"), rs.getString("sub_ingredients"), rs.getString("writer"),
		                  rs.getString("register_date"), rs.getString("type"), rs.getInt("hits"),
		                  rs.getString("descript"), rs.getString("content"), rs.getString("tip"),
		                  rs.getString("recommend"));
		         }
		      } finally {
		         closeAll(rs, ps, conn);
		      }
		      return vo;
		   }
		   
		   
}
