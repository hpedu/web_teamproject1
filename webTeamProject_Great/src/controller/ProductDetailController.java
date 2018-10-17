package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ShowDao;
import model.vo.ProductVO;
import service.PListVO;
import service.RPService;


public class ProductDetailController implements Controller {

   @Override
   public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
      
      String name=request.getParameter("name");
      System.out.println(name+ " search....");
      
      String[] array= {name};
      PListVO plist =  RPService.getInstance().searchProduct(array, "1");
      ProductVO pvo = ShowDao.getInstance().showProduct(name); 
      System.out.println("검색결과입니다 :: "+pvo);
      
      request.setAttribute("product", pvo);
      request.setAttribute("plist", plist);
      ModelAndView mv= new ModelAndView();
      System.out.println("ModelAndView 생성...");
      mv.setPath("prodjuctdeatails.jsp");
      return mv;
   }
}