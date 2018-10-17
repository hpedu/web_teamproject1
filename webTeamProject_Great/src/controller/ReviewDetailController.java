package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.BoardDAO;
import model.vo.ReviewVO;

public class ReviewDetailController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int no=  Integer.parseInt(request.getParameter("no"));
		String nowpage =request.getParameter("nowpage");
		String about = null;
				String temp=request.getParameter("about");
		
		if(temp.startsWith("re")) {
			
		}
		
		
		System.out.println(no+" // "+nowpage);
		ReviewVO rvo=BoardDAO.getInstance().getReviewByNo(no);
		String str = rvo.getImg_urls();
		String[] strs = str.split("///");
		ArrayList<String> urls = new ArrayList<String>();
		for(String s : strs)
			if(!s.equals(""))urls.add(s);
		request.setAttribute("about", about);
		request.setAttribute("urls", urls);
		request.setAttribute("page", nowpage);
		request.setAttribute("rvo", rvo);
		
		return new ModelAndView("review_detail.jsp");
	}

}
