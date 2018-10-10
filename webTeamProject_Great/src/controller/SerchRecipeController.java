package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ShowDao;
import model.vo.ProductVO;
import model.vo.RecipeVO;


public class SerchRecipeController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String name = request.getParameter("name");
		System.out.println("왜안대"+name);
		ProductVO pvo = ShowDao.getInstance().showProduct(name);
		System.out.println("여긴가");
		request.setAttribute("pvo", pvo);
		
		
		ModelAndView mv = new ModelAndView();
		System.out.println("ModelAndView...생성...");
		mv.setPath("searchRecipeResult.jsp");
		return mv;
	}

}
