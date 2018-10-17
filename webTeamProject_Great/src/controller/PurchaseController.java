package controller;

import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cartbiz.CartBiz;
import model.vo.CartVO;

public class PurchaseController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String[] names = request.getParameterValues("delete");
		for(String c : names)
			System.out.println("Purchase :: " + c);
		
		CartBiz cartBiz=  new CartBiz();
		ArrayList<CartVO> cartList=cartBiz.getCartList(request);
		
		for(CartVO c : cartList)
			System.out.println("Purchase :: " + c);
		
		 for(String name : names) {
	         Iterator<CartVO> iter = cartList.iterator();
	         while(iter.hasNext()) {
	            if(iter.next().getName().equals(name))
	               iter.remove();
	         }
		 }
		
		System.out.println("ModelAndView...»ý¼º...");
		ModelAndView mv = new ModelAndView();
		mv.setPath("purchase_ok.jsp");
		mv.setRedirect(true);
		return mv;
	}

}
