package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SearchDao;
import dao.ShowDao;
import model.vo.BoardVO2;
import model.vo.ProductVO;
import model.vo.RecipeVO;


public class ShowRecipeController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int num = Integer.parseInt(request.getParameter("num"));
		System.out.println("왜안대"+num);
		RecipeVO rvo = ShowDao.getInstance().showRecipe(num);
		
		ArrayList<ProductVO> plist = ShowDao.getInstance().showIngredientsProduct(rvo.getMain_ingredientents());
		ArrayList<RecipeVO> llist = ShowDao.getInstance().showRelatedRecipe(num);
		System.out.println("여긴가");
		String[] contents =  rvo.getContent().split("///");
		ArrayList<BoardVO2>  bvo = new ArrayList<BoardVO2>();
		for(String str : contents) {
			String[] strs = str.split("//");
			if(strs.length>1) {
				
				

			}
		}
		
		request.setAttribute("rvo", rvo);
		
		request.setAttribute("plist", plist);
		request.setAttribute("llist", llist);
		request.setAttribute("contents", contents);
		System.out.println(contents[0]);
		request.setAttribute("contentindex",contents.length);
		ModelAndView mv = new ModelAndView();
		System.out.println("ModelAndView...생성...");
		mv.setPath("recipedetail.jsp");
		return mv;
	}

}
