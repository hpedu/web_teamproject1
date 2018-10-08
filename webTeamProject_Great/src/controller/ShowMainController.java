package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ShowDao;
import model.vo.ProductVO;
import model.vo.RecipeVO;


public class ShowMainController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("show hotP ���� �ȉ�����?");
		ArrayList<RecipeVO> list1 = ShowDao.getInstance().showRecipeRecommend();
		ArrayList<RecipeVO> list2 = ShowDao.getInstance().showRecipeHot();
		
		request.setAttribute("RecommendRlist", list1);
		request.setAttribute("HotPlist", list2);
		
		ModelAndView mv = new ModelAndView();
		System.out.println("ModelAndView...����...");
		mv.setPath("recipeinsert.jsp");
		// mv.setRedirect(true);
		return mv;
	}

}
