package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ShowDao;
import model.vo.RecipeVO;

public class Write_RecipeController implements Controller {

	@Override
	public ModelAndView handleReqeust(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int num=Integer.parseInt(request.getParameter("num"));
		System.out.println("Write_RecipeController"+num);
		RecipeVO rvo = ShowDao.getInstance().showRecipe(num);
		System.out.println("Write_RecipeController.....하는중");
		
		ModelAndView mv= new ModelAndView();
		System.out.println("ModelAndView 생성....");
		return mv;
	}
}
