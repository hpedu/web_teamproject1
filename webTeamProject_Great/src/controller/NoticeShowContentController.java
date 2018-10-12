package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.vo.BoardVO;
import model.dao.BoardDAO;

public class NoticeShowContentController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int no=  Integer.parseInt(request.getParameter("no"));
		BoardVO rvo=BoardDAO.getInstance().getNoticeByNo(no);
		
		request.setAttribute("rvo", rvo);
		return new ModelAndView("show_content.jsp",false);//forward¹æ½Ä
	}

}
