package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cartbiz.CartBiz;

public class ItemCartDController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String[ ] names=request.getParameterValues("delete");
		for(String n : names)
			System.out.println(n);
		CartBiz cartBiz=  new CartBiz();
		cartBiz.removeCartItem(request, names);

		ModelAndView mv = new ModelAndView();
		mv.setPath("ItemCart.do");
		mv.setRedirect(true);
		return mv;
	}
}
