package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cartbiz.CartBiz;

public class ItemCartQtyUpController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String name = request.getParameter("name");
		CartBiz cartBiz = new CartBiz();
		cartBiz.upCartQty(request, name);
		
		ModelAndView mv = new ModelAndView();
		mv.setPath("DispatcherServlet?command=ItemCart");
		mv.setRedirect(true);
		return mv;
	}
}