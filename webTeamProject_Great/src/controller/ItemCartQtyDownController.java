package controller;

import java.net.URLDecoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cartbiz.CartBiz;

public class ItemCartQtyDownController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String name = request.getParameter("name");
		String realName = URLDecoder.decode( name , "UTF-8" );
		CartBiz cartBiz = new CartBiz();
		cartBiz.downCartQty(request, realName);
		
		System.out.println("====================="+realName);
		ModelAndView mv = new ModelAndView();
		mv.setPath("ItemCart.do");
		mv.setRedirect(true);
		return mv;
	}

}
