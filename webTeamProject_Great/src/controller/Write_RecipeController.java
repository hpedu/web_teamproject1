package controller;

import java.text.Normalizer.Form;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ShowDao;
import model.vo.RecipeVO;

public class Write_RecipeController implements Controller {

   @Override
   public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
      int num=Integer.parseInt(request.getParameter("num"));
      String name=request.getParameter("name.value");
      System.out.println(name);
      /*String type=request.getParameter();
      String main_ingredientent=request.getParameter();*/
      String sub_ingredientents;
      String writer;
      String date;
      
      int hits;
      String descript;
      String content;
      String tip;
      String recommend;
       
       
      System.out.println("Write_RecipeController"+num);
      RecipeVO rvo = ShowDao.getInstance().showRecipe(num);
      System.out.println("Write_RecipeController.....하는중");
      
      ModelAndView mv= new ModelAndView();
      System.out.println("ModelAndView 생성....");
      mv.setPath("recipedetail.jsp");
      return mv;
      
      
      
      
      
      
   }
   
   /*
       @Override
   public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
      String writer=request.getParameter("writer");
      String title=request.getParameter("title");
      String password=request.getParameter("password");
      String content=request.getParameter("content");
      
      //파리미터 vo  즉 pvo
      BoardVO pvo=new BoardVO(title, writer, password, content);
      BoardDao.getInstance().posting(pvo);
            
      ModelAndView mv= new ModelAndView();
      mv.setPath("DispatcherServlet?command=showContent&&no="+pvo.getNo());
      mv.setRedirect(true);
      
      return mv;
   }
    */
}