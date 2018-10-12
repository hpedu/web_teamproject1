package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cartbiz.CartBiz;
import dao.ShowDao;
import model.vo.CartVO;
import model.vo.ProductVO;

public class ItemCartShowController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		 /*String name=request.getParameter("name");
		 String[ ] names=request.getParameterValues("delete");
		 System.out.println(name);*/
		 CartBiz cartBiz=  new CartBiz();
		 
		 /*ProductVO product= ShowDao.getInstance().showProduct(name);
		 cartBiz.addCart(request, product);*/
		 /*cartBiz.removeCartItem(request, names);*/
		 
		 ArrayList<CartVO> cartList=cartBiz.getCartList(request);
		 
		 System.out.println("�������ɱ�");
		 System.out.println(cartList);

		   int sumMoney = 0;
			for(CartVO c : cartList) {
				int money = c.getPrice()*c.getQuantity();
				sumMoney +=money;
			}
			//���⼭�� �ٷ� ��� �������� ����...forward������� ����...request�� ���ε�
			request.setAttribute("sumMoney", sumMoney);
			request.setAttribute("cartList", cartList);
			request.setAttribute("cartSize", cartList.size());
			System.out.println(sumMoney);
			ModelAndView mv = new ModelAndView();
			mv.setPath("productCartList.jsp");		
			return mv;
	}

}
