package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ShowDao;
import model.vo.RecipeVO;


public class ShowRecipeController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int no = Integer.parseInt(request.getParameter("num"));
		System.out.println(no + "�� ���� Ŭ��!");
		RecipeVO rvo = ShowDao.getInstance().showRecipe(no);
		
		request.setAttribute("rvo", rvo);
		 
		System.out.println("ModelAndView...����...");
		return new ModelAndView("recipedetail.jsp");

	}

}
