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
      System.out.println("ShowMainController 왔음");
      ArrayList<RecipeVO> list1 = ShowDao.getInstance().showRecipeRecommend();
      ArrayList<RecipeVO> list2 = ShowDao.getInstance().showRecipeHot();
      ArrayList<ProductVO> list3 = ShowDao.getInstance().showProductHot();
      ArrayList<ProductVO> list4 = ShowDao.getInstance().showProductRecommend();

      request.setAttribute("RecommendRlist", list1);
      request.setAttribute("HotRlist", list2);
      request.setAttribute("HotPlist", list3);
      request.setAttribute("RecommendPlist", list4);
      
      ModelAndView mv = new ModelAndView();
      System.out.println("ModelAndView...생성...");
      mv.setPath("recipemain.jsp");
      return mv;
   }
}