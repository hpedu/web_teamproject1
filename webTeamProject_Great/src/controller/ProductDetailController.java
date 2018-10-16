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
      /*ps.setString(1, vo.getName());
      ps.setInt(2, vo.getPrice());
      ps.setString(3, vo.getOrigin());
      ps.setString(4, vo.getImg_urls());
      ps.setString(5, vo.getContent());
      ps.setString(6, vo.getType());
      ps.setString(7, vo.getBrand());
      ps.setInt(8, vo.getSales_volume());
      ps.setString(9, vo.getRecommend());*/
      
      
      String name=request.getParameter("name");
      System.out.println(name+ " search....");
      
      String[] array= {name};
      PListVO plist =  RPService.getInstance().searchProduct(array, "1");
      ProductVO pvo=ShowDao.getInstance().showProduct(name); 
      System.out.println("검색결과입니다 :: "+pvo);
      
      request.setAttribute("product", pvo);
      request.setAttribute("plist", plist);
      ModelAndView mv= new ModelAndView();
      System.out.println("ModelAndView 생성...");
      mv.setPath("prodjuctdeatails.jsp");
      System.out.println("prodjuctdeatails.jsp로 값 전송함");
      return mv;
   }
}