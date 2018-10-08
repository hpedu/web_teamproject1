package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ShowDao;
import model.vo.RecipeVO;


public class ShowRecipeController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int num = Integer.parseInt(request.getParameter("num"));
		System.out.println("�־ȴ�"+num);
		RecipeVO rvo = ShowDao.getInstance().showRecipe(num);
		System.out.println("���䰡");
		request.setAttribute("rvo", rvo);
		
		
		ModelAndView mv = new ModelAndView();
		System.out.println("ModelAndView...����...");
		mv.setPath("recipedetail.jsp");
		return mv;
	}

}
