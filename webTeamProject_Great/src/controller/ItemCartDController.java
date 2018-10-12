package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cartbiz.CartBiz;
import dao.ShowDao;
import model.vo.CartVO;
import model.vo.ProductVO;

public class ItemCartDController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		/* String name=request.getParameter("name");*/
		 String[ ] names=request.getParameterValues("delete");
		 System.out.println(names);
		 CartBiz cartBiz=  new CartBiz();
		 
		 /*ProductVO product= ShowDao.getInstance().showProduct(name);
		 cartBiz.addCart(request, product);
		 CartBiz cartBiz2=  new CartBiz();*/
		 cartBiz.removeCartItem(request, names);
		 System.out.println("여기서 안되겟지");
			ModelAndView mv = new ModelAndView();
			mv.setPath("DispatcherServlet?command=ItemCart");
			mv.setRedirect(true);
			return mv;
	}

}
