package cartbiz;
/*
 * itemView 페이지에서 장바구니 담기를 클릭하면 작동해야하는 장바구니의 비지니스 로직
 * 1) 이미 장바구니에 담겨진 Item을 추가하는 경우 
 * 2)장바구니에 담겨지지 않은 Item을 추가하는 경우
 * --> 카트에 추가하려는 Item이 있는지 없는지부터 먼저 알아야 한다
 * 있다면 ---- 수량만 증가
 * 없다면 --- 새로운 Item을 생성
 * ::
 * 1. 세션에 저장된 모든 아이템들을 받아오는 로직..ArrayList가 반환
 * 2. Item을 추가하는 로직 (1번에 따라서 기능이 두갈래로 나뉜다)
 */

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.vo.CartVO;
import model.vo.ProductVO;

public class CartBiz {
	/*
	 * 세션에 바인딩된 cartList리스트 정보를 다 받아온다...
	 */
	public ArrayList<CartVO> getCartList(HttpServletRequest request){
		HttpSession session = request.getSession();	
		ArrayList<CartVO> carList= (ArrayList<CartVO>)session.getAttribute("cartList");
		return carList;
	}
	/*
	 * getCartList()를 호출해야한다.
	 * Item에 해당하는 상품이 cartList에 있다면....수량만 증가
	 * 없다면...Cart에 하나씩 추가해야한다.(Cart를 생성)
	 */	
	public void addCart(HttpServletRequest request,ProductVO product) { //?
		ArrayList<CartVO> cartList=getCartList(request);
		
		if(cartList==null) cartList = new ArrayList<CartVO>();
		
		CartVO cart = null;
		boolean newCart = true;
		//하나 이상의 Item이 장바구니에 있다면...
		//cartList에 들어있는 Item이 추가하려는 Item의 이름과 같다면
		//수량만 증가...
		for(CartVO c :cartList) {
			if(c.getName().equals(product.getName())) {
				newCart = false;
				c.setQuantity(c.getQuantity()+1);
			}//if
		}//for
		
		if(newCart) { //카트에 담겨있는 상품이 아니라면
			cart = new CartVO();
			cart.setImg_urls(product.getImg_urls());
			cart.setName(product.getName());
			cart.setPrice(product.getPrice());
			cart.setQuantity(1); //이떄는 무조건 1이 된다
			cartList.add(cart);
		}//
		
		//세션에 바인딩
		request.getSession().setAttribute("cartList", cartList);		
	}//addCart
	/*
	 * 세션에 바인딩된 ArrayList를 받아와서
	 * 이중에서 수량을 증가하려는 name과 일치하는 상품을 받아와서
	 * name에 해당하는 상품의 수량을 하나만 증가시키는 로직을 작성
	 */
	public void upCartQty(HttpServletRequest request, String name) {
		ArrayList<CartVO> cartList=
				(ArrayList<CartVO>)request.getSession().getAttribute("cartList");
		for(CartVO c : cartList) {
			if(c.getName().equals(name)) c.setQuantity(c.getQuantity()+1);			
		}//for		
	}//upCartQty
	
	public void downCartQty(HttpServletRequest request, String name) {
		ArrayList<CartVO> cartList=
				(ArrayList<CartVO>)request.getSession().getAttribute("cartList");
		for(CartVO c : cartList) {
			if(c.getName().equals(name)) c.setQuantity(c.getQuantity()-1);			
		}//for			
	}//upCartQty
	
	
	public void removeCartItem(HttpServletRequest request, String[] names) {
		ArrayList<CartVO> cartList=
				(ArrayList<CartVO>)request.getSession().getAttribute("cartList");
		
		/*for(String name : names) {
			for(Cart c : cartList) {
				if(name.equals(c.getName())) cartList.remove(c);				
			}//for
		}*///for
		
		for(int i =0; i<names.length; i++) {
			for(int j=0; j<cartList.size(); j++) {
				if(names[i].equals(cartList.get(i).getName()))
					cartList.remove(cartList.get(j));
			}
		}
	}//removeCartItem
}































