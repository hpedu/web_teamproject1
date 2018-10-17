package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import model.vo.BoardVO;
import model.vo.ReviewVO;
import query.StringQuery;

public class BoardDAO {
DataSource ds;
	
	private static BoardDAO dao= new BoardDAO();
	
	private BoardDAO() {
		ds=DataSourceManager.getInstance().getConnection();
	}
	
	public static BoardDAO getInstance() {
		
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
	
	public int getTotalPostingCount() throws SQLException{
		Connection conn = null;
		PreparedStatement ps =null;
		ResultSet rs=  null;
		int count=-1;
		try{
			conn=  getConnection();
			ps = conn.prepareStatement(StringQuery.TOTAL_COUNT);
			rs = ps.executeQuery();
			if(rs.next()) count = rs.getInt(1);
		}finally{
			closeAll(rs, ps, conn);
		}
		return count;
	}
	
	public ArrayList<BoardVO> showNotice(int pageNo) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		try {
			conn=  getConnection();
			ps = conn.prepareStatement(StringQuery.PAGE_LIST);
			System.out.println(StringQuery.PAGE_LIST);
			ps.setInt(1, pageNo);
			rs = ps.executeQuery();
			System.out.println("1!!");
			
			while(rs.next()) {
				list.add(new BoardVO(rs.getInt("no"), 
									 rs.getString("writer"),  
									 rs.getString("register_date"), 
									 rs.getString("title"),
									 rs.getInt("hits"),
									 rs.getString("content")));
									 
			}
			System.out.println(list);
		}finally {
			closeAll(rs, ps, conn);
		}
		return list;
	}
	
	public void updateHits(int no, int hits)throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnection();
			ps = conn.prepareStatement(StringQuery.UPDATE_HITS);
			ps.setInt(1, hits);
			ps.setInt(2, no);
			int row = ps.executeUpdate();
			System.out.println(row+"ROW Á¶È¸");
		}finally {
			closeAll(ps, conn);
		}
	}
	
	public BoardVO getNoticeByNo(int no) throws SQLException{
		BoardVO vo = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn=  getConnection();
			ps = conn.prepareStatement(StringQuery.SELECT_NOTICE);
			ps.setInt(1, no);
			rs = ps.executeQuery();
			if(rs.next()) {
				vo = new BoardVO(no, 
								 rs.getString("writer"),  
								 rs.getString("register_date"), 
								 rs.getString("title"),
								 rs.getInt("hits"),
								 rs.getString("content"));				
			}
		}finally{
			closeAll(rs,ps, conn);
		}
		return vo;
	}//
}
