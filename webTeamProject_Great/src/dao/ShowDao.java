package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import model.dao.DataSourceManager;
import model.vo.ProductVO;
import model.vo.RecipeVO;
import query.ShowQuery;

public class ShowDao {
   DataSource ds;
   private static ShowDao dao = new ShowDao();

   private ShowDao() {
      ds = DataSourceManager.getInstance().getConnection();
   }

   public static ShowDao getInstance() {
      return dao;
   }

   public Connection getConnection() throws SQLException {
      return ds.getConnection();
   }

<<<<<<< HEAD
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		if (rs != null)
			rs.close();
		closeAll(ps, conn);
	}
	
<<<<<<< HEAD
	public ArrayList<RecipeVO> showRecipeHot() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<RecipeVO> list = new ArrayList<RecipeVO>();
		try {
			conn=  getConnect();
			ps = conn.prepareStatement(ShowQuery.SELECT_SHOWHOTRECIPE);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new RecipeVO(
						 rs.getInt("no"),
						 rs.getString("name"),
						 rs.getString("img_urls"),
						 rs.getString("main_ingredients"),
						 rs.getString("sub_ingredients"),
						 rs.getString("writer"),
						 rs.getString("register_date"),
						 rs.getString("type"),
						 rs.getInt("hits"),
						 rs.getString("descript"),
						 rs.getString("content"),
						 rs.getString("tip"),
						 rs.getBoolean("recommend")));
			}
		}finally {
			closeAll(rs, ps, conn);
		}
		return list;
	}
	
	public ArrayList<RecipeVO> showRecipeNew() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<RecipeVO> list = new ArrayList<RecipeVO>();
		try {
			conn=  getConnect();
			ps = conn.prepareStatement(ShowQuery.SELECT_SHOWNEWRECIPE);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new RecipeVO(
						 rs.getInt("no"),
						 rs.getString("name"),
						 rs.getString("img_urls"),
						 rs.getString("main_ingredients"),
						 rs.getString("sub_ingredients"),
						 rs.getString("writer"),
						 rs.getString("register_date"),
						 rs.getString("type"),
						 rs.getInt("hits"),
						 rs.getString("descript"),
						 rs.getString("content"),
						 rs.getString("tip"),
						 rs.getBoolean("recommend")));
			}
		}finally {
			closeAll(rs, ps, conn);
		}
		return list;
	}
	
	public ArrayList<RecipeVO> showRecipeRecommend() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<RecipeVO> list = new ArrayList<RecipeVO>();
		try {
			conn=  getConnect();
			ps = conn.prepareStatement(ShowQuery.SELECT_SHOWRECOMMENDRECIPE);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new RecipeVO(
						 rs.getInt("no"),
						 rs.getString("name"),
						 rs.getString("img_urls"),
						 rs.getString("main_ingredients"),
						 rs.getString("sub_ingredients"),
						 rs.getString("writer"),
						 rs.getString("register_date"),
						 rs.getString("type"),
						 rs.getInt("hits"),
						 rs.getString("descript"),
						 rs.getString("content"),
						 rs.getString("tip"),
						 rs.getBoolean("recommend")));
			}
		}finally {
			closeAll(rs, ps, conn);
		}
		return list;
	}
	
	public ArrayList<ProductVO> showProductHot() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<ProductVO> list = new ArrayList<ProductVO>();
		try {
			conn=  getConnect();
			ps = conn.prepareStatement(ShowQuery.SELECT_SHOWHOTPRODUCT);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new ProductVO(rs.getString("name"), 
						               rs.getInt("price"), 
						               rs.getString("origin"),
						               rs.getString("img_urls"),
						               rs.getString("content"),
						               rs.getString("type"),
						               rs.getString("brand"), 
						               rs.getInt("sales_volume"),
						               rs.getBoolean("recommend")));
			}
		}finally {
			closeAll(rs, ps, conn);
		}
		return list;
	}
	
	public ArrayList<ProductVO> showProductRecommend() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<ProductVO> list = new ArrayList<ProductVO>();
		try {
			conn=  getConnect();
			ps = conn.prepareStatement(ShowQuery.SELECT_SHOWRECOMMENDPRODUCT);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new ProductVO(rs.getString("name"), 
						               rs.getInt("price"), 
						               rs.getString("origin"),
						               rs.getString("img_urls"),
						               rs.getString("content"),
						               rs.getString("type"),
						               rs.getString("brand"), 
						               rs.getInt("sales_volume"),
						               rs.getBoolean("recommend")));
			}
		}finally {
			closeAll(rs, ps, conn);
		}
		return list;
	}
	
	
	
	public ArrayList<BoardVO> showNotice() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		try {
			conn = getConnect();
			ps = conn.prepareStatement(StringQuery.REVIEW);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new BoardVO(rs.getInt("no"), 
									 rs.getString("writer"), 
									 rs.getString("register_date"),
									 rs.getString("content")));
				}
		} finally {
			closeAll(rs, ps, conn);
		}
		return list;
	}
	
	public ArrayList<BoardVO> showReview() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		try {
			conn = getConnect();
			ps = conn.prepareStatement(StringQuery.REVIEW);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new BoardVO(rs.getInt("no"), 
									 rs.getString("writer"),
									 rs.getString("img_urls"), 
									 rs.getString("register_date"),
									 rs.getString("content")));
				}
		} finally {
			closeAll(rs, ps, conn);
		}
		return list;
	}
	
	public int getReviewTotalPostingCount() throws SQLException{
		Connection conn = null;
		PreparedStatement ps =null;
		ResultSet rs=  null;
		int count=-1;
		try{
			conn=  getConnect();
			ps = conn.prepareStatement(StringQuery.TOTAL_COUNT);
			rs = ps.executeQuery();
			if(rs.next()) count = rs.getInt(1);
		}finally{
			closeAll(rs, ps, conn);
		}
		return count;
	}
	
	public int getNoticeTotalPostingCount() throws SQLException{
		Connection conn = null;
		PreparedStatement ps =null;
		ResultSet rs=  null;
		int count=-1;
		try{
			conn=  getConnect();
			ps = conn.prepareStatement(StringQuery.TOTAL_COUNT);
			rs = ps.executeQuery();
			if(rs.next()) count = rs.getInt(1);
		}finally{
			closeAll(rs, ps, conn);
		}
		return count;
	}
	
	
	public ArrayList<ProductVO> showIngredientsProduct(int no) throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<ProductVO> list = new ArrayList<ProductVO>();
		try {
			conn = getConnect();
			ps = conn.prepareStatement(ShowQuery.SELECT_SHOWINGREDIENTSPRODUCT);
			ps.setInt(1, no);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new ProductVO(rs.getString("name"), rs.getInt("price"), rs.getString("origin"),
						rs.getString("img_urls"), rs.getString("content"), rs.getString("type"), rs.getString("brand"),
						rs.getInt("sales_volume"), rs.getString("recommend"), rs.getString("amount")));
			}
		} finally {
			closeAll(rs, ps, conn);
		}
		return list;
	}
	
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		ShowDao db = new ShowDao("127.0.0.1");
		System.out.println("hot recipe");
		ArrayList<RecipeVO> list= ShowDao.getInstance().showRecipeHot();
		System.out.println(list.size());
		for(RecipeVO recipes : list) {
			System.out.println(recipes);
		}
		System.out.println("hot product");
		ArrayList<ProductVO> list2= ShowDao.getInstance().showProductHot();
		System.out.println(list2.size());
		for(ProductVO product : list2) {
			System.out.println(product);
		}
		System.out.println("new recipe");
		ArrayList<RecipeVO> list3= ShowDao.getInstance().showRecipeNew();
		System.out.println(list3.size());
		for(RecipeVO recipes : list3) {
			System.out.println(recipes);
		}
		
		System.out.println("recommend recipe");
		ArrayList<RecipeVO> list4= ShowDao.getInstance().showRecipeRecommend();
		System.out.println(list4.size());
		for(RecipeVO recipes : list4) {
			System.out.println(recipes);
		}
		System.out.println("recommend product");
		ArrayList<ProductVO> list5= ShowDao.getInstance().showProductRecommend();
		System.out.println(list5.size());
		for(ProductVO recipes : list5) {
			System.out.println(recipes);
		}
	}
=======
	public RecipeVO showRecipe(int num) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		RecipeVO vo = null;
		try {
			conn = getConnection();
			ps = conn.prepareStatement(ShowQuery.SELECT_SHOWRECIPE);
			ps.setInt(1, num);
			rs = ps.executeQuery();
			if (rs.next()) {
				vo =new RecipeVO(rs.getInt("num"), rs.getString("name"), rs.getString("img_urls"),
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
	
	public ArrayList<RecipeVO> showRecipeHot() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<RecipeVO> list = new ArrayList<RecipeVO>();
		try {
			conn=  getConnect();
			ps = conn.prepareStatement(ShowQuery.SELECT_SHOWHOTRECIPE);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new RecipeVO(
						 rs.getInt("no"),
						 rs.getString("name"),
						 rs.getString("img_urls"),
						 rs.getString("main_ingredients"),
						 rs.getString("sub_ingredients"),
						 rs.getString("writer"),
						 rs.getString("register_date"),
						 rs.getString("type"),
						 rs.getInt("hits"),
						 rs.getString("descript"),
						 rs.getString("content"),
						 rs.getString("tip"),
						 rs.getBoolean("recommend")));
			}
		}finally {
			closeAll(rs, ps, conn);
		}
		return list;
	}
	
	public ArrayList<RecipeVO> showRecipeNew() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<RecipeVO> list = new ArrayList<RecipeVO>();
		try {
			conn=  getConnect();
			ps = conn.prepareStatement(ShowQuery.SELECT_SHOWNEWRECIPE);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new RecipeVO(
						 rs.getInt("no"),
						 rs.getString("name"),
						 rs.getString("img_urls"),
						 rs.getString("main_ingredients"),
						 rs.getString("sub_ingredients"),
						 rs.getString("writer"),
						 rs.getString("register_date"),
						 rs.getString("type"),
						 rs.getInt("hits"),
						 rs.getString("descript"),
						 rs.getString("content"),
						 rs.getString("tip"),
						 rs.getBoolean("recommend")));
			}
		}finally {
			closeAll(rs, ps, conn);
		}
		return list;
	}
	
	public ArrayList<RecipeVO> showRecipeRecommend() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<RecipeVO> list = new ArrayList<RecipeVO>();
		try {
			conn=  getConnect();
			ps = conn.prepareStatement(ShowQuery.SELECT_SHOWRECOMMENDRECIPE);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new RecipeVO(
						 rs.getInt("no"),
						 rs.getString("name"),
						 rs.getString("img_urls"),
						 rs.getString("main_ingredients"),
						 rs.getString("sub_ingredients"),
						 rs.getString("writer"),
						 rs.getString("register_date"),
						 rs.getString("type"),
						 rs.getInt("hits"),
						 rs.getString("descript"),
						 rs.getString("content"),
						 rs.getString("tip"),
						 rs.getBoolean("recommend")));
			}
		}finally {
			closeAll(rs, ps, conn);
		}
		return list;
	}
	
	public ArrayList<ProductVO> showProductHot() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<ProductVO> list = new ArrayList<ProductVO>();
		try {
			conn=  getConnect();
			ps = conn.prepareStatement(ShowQuery.SELECT_SHOWHOTPRODUCT);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new ProductVO(rs.getString("name"), 
						               rs.getInt("price"), 
						               rs.getString("origin"),
						               rs.getString("img_urls"),
						               rs.getString("content"),
						               rs.getString("type"),
						               rs.getString("brand"), 
						               rs.getInt("sales_volume"),
						               rs.getString("recommend")));
			}
		}finally {
			closeAll(rs, ps, conn);
		}
		return list;
	}
	
	public ArrayList<ProductVO> showProductRecommend() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<ProductVO> list = new ArrayList<ProductVO>();
		try {
			conn=  getConnect();
			ps = conn.prepareStatement(ShowQuery.SELECT_SHOWRECOMMENDPRODUCT);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new ProductVO(rs.getString("name"), 
						               rs.getInt("price"), 
						               rs.getString("origin"),
						               rs.getString("img_urls"),
						               rs.getString("content"),
						               rs.getString("type"),
						               rs.getString("brand"), 
						               rs.getInt("sales_volume"),
						               rs.getString("recommend")));
			}
		}finally {
			closeAll(rs, ps, conn);
		}
		return list;
	}
	
	
	public ArrayList<BoardVO> showNotice() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		try {
			conn = getConnect();
			ps = conn.prepareStatement(StringQuery.NOTICE);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new BoardVO(rs.getInt("no"), 
									 rs.getString("writer"),
									 rs.getString("img_urls"), 
									 rs.getString("register_date"),
									 rs.getString("content")));
				}
		} finally {
			closeAll(rs, ps, conn);
		}
		return list;
	}
	
	public int getTotalPostingCount() throws SQLException{
		Connection conn = null;
		PreparedStatement ps =null;
		ResultSet rs=  null;
		int count=-1;
		try{
			conn=  getConnect();
			ps = conn.prepareStatement(StringQuery.TOTAL_COUNT);
			rs = ps.executeQuery();
			if(rs.next()) count = rs.getInt(1);
		}finally{
			closeAll(rs, ps, conn);
		}
		return count;
	}
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
=======
   public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
      if (ps != null)
         ps.close();
      if (conn != null)
         conn.close();
   }
>>>>>>> branch 'master' of https://github.com/hpedu/web_teamproject1.git

<<<<<<< HEAD
		System.out.println("hot recipe");
		ArrayList<RecipeVO> list= ShowDao.getInstance().showRecipeHot();
		System.out.println(list.size());
		for(RecipeVO recipes : list) {
			System.out.println(recipes);
		}
		System.out.println("hot product");
		ArrayList<ProductVO> list2= ShowDao.getInstance().showProductHot();
		System.out.println(list2.size());
		for(ProductVO product : list2) {
			System.out.println(product);
		}
		System.out.println("new recipe");
		ArrayList<RecipeVO> list3= ShowDao.getInstance().showRecipeNew();
		System.out.println(list3.size());
		for(RecipeVO recipes : list3) {
			System.out.println(recipes);
		}
		
		System.out.println("recommend recipe");
		ArrayList<RecipeVO> list4= ShowDao.getInstance().showRecipeRecommend();
		System.out.println(list4.size());
		for(RecipeVO recipes : list4) {
			System.out.println(recipes);
		}
		System.out.println("recommend product");
		ArrayList<ProductVO> list5= ShowDao.getInstance().showProductRecommend();
		System.out.println(list5.size());
		for(ProductVO recipes : list5) {
			System.out.println(recipes);
		}
	}
	
>>>>>>> refs/remotes/origin/master
}
=======
   public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
      if (rs != null)
         rs.close();
      closeAll(ps, conn);
   }

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
   
   public ProductVO showProduct(String name) throws SQLException {
	      Connection conn = null;
	      PreparedStatement ps = null;
	      ResultSet rs = null;
	      ProductVO vo = null;
	      try {
	         conn = getConnection();
	         ps = conn.prepareStatement(ShowQuery.SELECT_SHOWPRODUCT);
	         ps.setString(1, name);
	         rs = ps.executeQuery();
	         if (rs.next()) {
	        	 vo = new ProductVO(rs.getString("name"), rs.getInt("price"), rs.getString("origin"),
	                     rs.getString("img_urls"), rs.getString("content"), rs.getString("type"), rs.getString("brand"),
	                     rs.getInt("sales_volume"), rs.getString("recommend"), rs.getString("amount"));
	            }
	      } finally {
	         closeAll(rs, ps, conn);
	      }
	      return vo;
  }

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

   public ArrayList<ProductVO> showProductHot() throws SQLException {
      Connection conn = null;
      PreparedStatement ps = null;
      ResultSet rs = null;
      ArrayList<ProductVO> list = new ArrayList<ProductVO>();
      try {
         conn = getConnection();
         System.out.println("¿©±âµÊ?");
         ps = conn.prepareStatement(ShowQuery.SELECT_SHOWHOTPRODUCT);
         System.out.println(ShowQuery.SELECT_SHOWHOTPRODUCT);
         rs = ps.executeQuery();
         System.out.println(rs);
         while (rs.next()) {
        	 ProductVO pvo =new ProductVO(rs.getString("name"), rs.getInt("price"), rs.getString("origin"),
                     rs.getString("imgurls"), rs.getString("content"), rs.getString("type"), rs.getString("brand"),
                     rs.getInt("sales_volume"), rs.getString("recommend"), rs.getString("amount"));
        	 System.out.println(pvo);
            list.add(pvo);
         }
      } finally {
         closeAll(rs, ps, conn);
      }
      return list;
   }

   public ArrayList<ProductVO> showProductRecommend() throws SQLException {
      Connection conn = null;
      PreparedStatement ps = null;
      ResultSet rs = null;
      ArrayList<ProductVO> list = new ArrayList<ProductVO>();
      try {
         conn = getConnection();
         ps = conn.prepareStatement(ShowQuery.SELECT_SHOWRECOMMENDPRODUCT);
         System.out.println(ShowQuery.SELECT_SHOWRECOMMENDPRODUCT);
         rs = ps.executeQuery();
         while (rs.next()) {
            list.add(new ProductVO(rs.getString("name"), rs.getInt("price"), rs.getString("origin"),
                  rs.getString("imgurls"), rs.getString("content"), rs.getString("type"), rs.getString("brand"),
                  rs.getInt("sales_volume"), rs.getString("recommend"), rs.getString("amount")));
         }
      } finally {
         closeAll(rs, ps, conn);
      }
      return list;
   }
   
   public ArrayList<ProductVO> showIngredientsProduct(String ingrediants) throws SQLException{
      Connection conn = null;
      PreparedStatement ps = null;
      ResultSet rs = null;
      ArrayList<ProductVO> list = new ArrayList<ProductVO>();
      String[] words = ingrediants.split(",");
      System.out.println(words);
      try {
         conn = getConnection();
         
         String query = "SELECT name, price, imgurls, type FROM product WHERE name LIKE '%"+words[0]+"%'";
         if(words.length>0) {
         for(int i=1; i < words.length;i++) {
        	 	
						query += " OR name LIKE '%"+words[i]+"%'";
         }
         	query+= "order by sales_volume desc";
         	
				ps = conn.prepareStatement(query);
				rs = ps.executeQuery();
				while(rs.next()) {
					list.add(new ProductVO(rs.getString("name"), rs.getInt("price"), rs.getString("imgurls"), rs.getString("type")));
				}
         
				
      }
      } finally {
         closeAll(rs, ps, conn);
      }
      return list;
   }
   
   public ArrayList<RecipeVO> showRelatedRecipe(int no) throws SQLException{
	   System.out.println(no);
      Connection conn = null;
      PreparedStatement ps = null;
      ResultSet rs = null;
      ArrayList<RecipeVO> list = new ArrayList<RecipeVO>();
      try {
         conn = getConnection();
         ps = conn.prepareStatement(ShowQuery.SELECT_SHOWRELATEDRECIPE);
         System.out.println(ShowQuery.SELECT_SHOWRELATEDRECIPE);
         ps.setInt(1, no);
         rs = ps.executeQuery();
         System.out.println("¿©±ä µÅ? "+rs);
         while (rs.next()) {
        	 RecipeVO rvo =new RecipeVO(rs.getInt("no"), rs.getString("name"), rs.getString("img_urls"), rs.getString("writer"),rs.getString("recommend"));
            list.add(rvo);
            System.out.println(rvo);
         }
      } finally {
         closeAll(rs, ps, conn);
      }
      return list;
   }
   
   /*public static void main(String[] args) throws SQLException, ClassNotFoundException {
      System.out.println("hot recipe");
      ArrayList<RecipeVO> list = ShowDao.getInstance().showRecipeHot();
      System.out.println(list.size());
      for (RecipeVO recipes : list) {
         System.out.println(recipes);
      }
      System.out.println("hot product");
      ArrayList<ProductVO> list2 = ShowDao.getInstance().showProductHot();
      System.out.println(list2.size());
      for (ProductVO product : list2) {
         System.out.println(product);
      }
      System.out.println("new recipe");
      ArrayList<RecipeVO> list3 = ShowDao.getInstance().showRecipeNew();
      System.out.println(list3.size());
      for (RecipeVO recipes : list3) {
         System.out.println(recipes);
      }

      System.out.println("recommend recipe");
      ArrayList<RecipeVO> list4 = ShowDao.getInstance().showRecipeRecommend();
      System.out.println(list4.size());
      for (RecipeVO recipes : list4) {
         System.out.println(recipes);
      }
      System.out.println("recommend product");
      ArrayList<ProductVO> list5 = ShowDao.getInstance().showProductRecommend();
      System.out.println(list5.size());
      for (ProductVO recipes : list5) {
         System.out.println(recipes);
      }
      ArrayList<ProductVO> list6 = ShowDao.getInstance().showIngredientsProduct(2);
      System.out.println(list6.size());
      for (ProductVO recipes : list6) {
         System.out.println(recipes);
      }
      ArrayList<RecipeVO> list = ShowDao.getInstance().showRecipe(1);
      System.out.println(list.size());
      for (RecipeVO recipes : list) {
         System.out.println(recipes);
      }
      
   }*/
   
}
>>>>>>> branch 'master' of https://github.com/hpedu/web_teamproject1.git
