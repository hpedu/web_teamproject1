package controller;

import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.ShowDao;
import model.dao.RecipeDAO;
import model.vo.RecipeVO;

public class Write_RecipeController implements Controller {

   @Override
   public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
	   String realFolder = "";
	   String filename1 = "";
	   int maxSize = 1024*1024*5;
	   String encType = "utf-8";
	   String savefile = "img";
	   ServletContext scontext = request.getServletContext();
	   realFolder = scontext.getRealPath(savefile);
	   MultipartRequest multi=new MultipartRequest(request, realFolder, maxSize, encType, new DefaultFileRenamePolicy());

	   try{
	    
	    Enumeration<?> files = multi.getFileNames();
	       String file1 = (String)files.nextElement();
	       filename1 = multi.getFilesystemName(file1);
	   } catch(Exception e) {
	    e.printStackTrace();
	   }
	   
	   String fullpath = ".\\"+savefile + "\\" + filename1;
	   
	   
      String name=multi.getParameter("name");
      System.out.println("name:"+name);
      String imgurls="./";
      if(!multi.getParameter("imgurls").equals(null))
    	  	imgurls=multi.getParameter("imgurls");
      
      System.out.println(name+"/"+imgurls);
      String main_ingredientent=multi.getParameter("ingredient1");
      for(int i=2; i<=3; i++) {
    	  if(!multi.getParameter("ingredient"+i).equals("")) {
    		  main_ingredientent+=",";
    	 	  main_ingredientent+=multi.getParameter("ingredient"+i);
    	  }else {break;}
      }
      
      String sub_ingredientent=multi.getParameter("sub_ingredient1");
      for(int i=2; i<=3; i++) {
    	  if(!multi.getParameter("sub_ingredient"+i).equals("")) {
    		  sub_ingredientent+=",";
    		  sub_ingredientent+=multi.getParameter("sub_ingredient"+i);
    	  }else {break;}
      }
      System.out.println("main : "+main_ingredientent+"/sub : "+sub_ingredientent);
      
      //HttpSession session = request.getSession();
      String type=multi.getParameter("type");
      
      String writer = "관리자"; //(String) session.getAttribute("id");
      //if(writer.equals(null)) writer="관리자";
      System.out.println(writer);
      String discript = request.getParameter("discript");
      System.out.println(discript);
      int count = Integer.parseInt((String)multi.getParameter("count"));
      System.out.println("count : "+count);
      String content = multi.getParameter("way_1");
      if(!multi.getParameter("way_1_url").equals(null)) 
    	  content +="/_/"+multi.getParameter("way_1_url");
      else
    	  content +="/_/"+"null";
      
      for(int i=2; i<count; i++) {
    	  if(!multi.getParameter("way_"+i).equals("")) {
    		  content+="///"+multi.getParameter("way_"+i)+"/_/";
    	  
    	  if(!request.getParameter("way_"+i+"_url").equals(null))
    		  content+=multi.getParameter("way_"+i+"_url");
    	  else content+="null";
    	  
    	  }else if(!multi.getParameter("way_"+i+"_url").equals(null))
    		  content+="///null/_/"+multi.getParameter("way_"+i+"_url");
    	  }
      System.out.println(content);
     String tip = request.getParameter("tip");
     
     
     
     
     RecipeVO rvo = new RecipeVO(name, imgurls, main_ingredientent, sub_ingredientent, writer, type, discript, content, tip);
     System.out.println(rvo);
     int num= RecipeDAO.getInstance().recipeWrite(rvo);
     System.out.println("Write_RecipeController"+num);
     
     RecipeVO svo=ShowDao.getInstance().showRecipe(num);
     System.out.println("Write_RecipeController.....하는중");
     
     request.setAttribute("rvo", svo);
     ModelAndView mv= new ModelAndView();
     System.out.println("ModelAndView 생성....");
     mv.setPath("recipedetail.jsp");
     return mv;
     
   	}
      
  
      
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
