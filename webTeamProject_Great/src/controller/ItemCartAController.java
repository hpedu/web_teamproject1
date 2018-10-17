package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cartbiz.CartBiz;
import dao.ShowDao;
import model.dao.SalesDAO;
import model.vo.CartVO;
import model.vo.ProductVO;

public class ItemCartAController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String name = request.getParameter("name");
		 /*String[ ] names=request.getParameterValues("delete");*/
		System.out.println(name);
		CartBiz cartBiz=  new CartBiz();
		 
		ProductVO product = ShowDao.getInstance().showProduct(name);
		cartBiz.addCart(request, product);
		 
		CartVO vo =  SalesDAO.getInstance().searchProduct(name);
		System.out.println(vo);
		//SalesDAO.getInstance().purchaseProduct(vo);
		
		
		ModelAndView mv = new ModelAndView();
		mv.setPath("ItemCart.do");
		mv.setRedirect(true);
		return mv;
	}

}
