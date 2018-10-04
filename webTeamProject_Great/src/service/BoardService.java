package service;

import java.util.ArrayList;

import dao.ShowDao;
import model.dao.PagingBean;
import model.vo.BoardVO;

public class BoardService {
	private ShowDao dao;
	private static BoardService service = new BoardService();
	private BoardService() {
		dao = ShowDao.getInstance();
	}
	public static BoardService getInstance() {
		return service;
	}
	
	public ListVO showNotice(String pageNo) throws Exception {
		int pn =1;
		if(pageNo !=null) pn = Integer.parseInt(pageNo);
		
		ArrayList<BoardVO> list = dao.showNotice();
		int total = dao.getReviewTotalPostingCount();
		PagingBean pb = new PagingBean(total,pn);
		
		return new ListVO(pb,list);
	}
	
	public ListVO showReview(String pageNo) throws Exception {
		int pn =1;
		if(pageNo !=null) pn = Integer.parseInt(pageNo);
		
		ArrayList<BoardVO> list = dao.showReview();
		int total = dao.getNoticeTotalPostingCount();
		PagingBean pb = new PagingBean(total,pn);
		
		return new ListVO(pb,list);
	}
}
