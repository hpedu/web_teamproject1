package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cartbiz.CartBiz;

public class ItemCartQtyUpController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String realName = request.getParameter("name");

		CartBiz cartBiz = new CartBiz();
		
		cartBiz.upCartQty(request, realName);
		
		ModelAndView mv = new ModelAndView();
		mv.setPath("ItemCart.do");
		mv.setRedirect(true);
		return mv;
	}
}
