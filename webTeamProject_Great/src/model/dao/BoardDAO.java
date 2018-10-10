package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import model.vo.ReviewVO;
import query.StringQuery;

public class BoardDAO {
DataSource ds;
	
	private static BoardDAO dao= BoardDAO();
	
	private BoardDAO() {
		ds=DataSourceManager.getInstance().getConnection();
	}
	
	public static BoardDAO BoardDAO() {
		
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
	
	
	
	public void reviewWrite(ReviewVO vo) throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = getConnection();
			ps = conn.prepareStatement(StringQuery.INSERT_REVIEW);
			
			ps.setInt(1, vo.getNo());
			ps.setString(2, vo.getWriter());
			ps.setString(3, vo.getImg_urls());
			
			ps.setString(4, vo.getContent());
			
			
						
			int row = ps.executeUpdate();
			System.out.println(row+" row insert review ok....");
			
		}finally{
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
	
	public void updateReview(ReviewVO vo)throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnection();
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
}
