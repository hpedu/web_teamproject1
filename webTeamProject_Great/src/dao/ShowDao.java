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
         ps = conn.prepareStatement(ShowQuery.SELECT_SHOWHOTPRODUCT);
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

   public ArrayList<ProductVO> showProductRecommend() throws SQLException {
      Connection conn = null;
      PreparedStatement ps = null;
      ResultSet rs = null;
      ArrayList<ProductVO> list = new ArrayList<ProductVO>();
      try {
         conn = getConnection();
         ps = conn.prepareStatement(ShowQuery.SELECT_SHOWRECOMMENDPRODUCT);
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
   
   public ArrayList<ProductVO> showIngredientsProduct(int no) throws SQLException{
      Connection conn = null;
      PreparedStatement ps = null;
      ResultSet rs = null;
      ArrayList<ProductVO> list = new ArrayList<ProductVO>();
      try {
         conn = getConnection();
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