package cartbiz;
/*
 * itemView ���������� ��ٱ��� ��⸦ Ŭ���ϸ� �۵��ؾ��ϴ� ��ٱ����� �����Ͻ� ����
 * 1) �̹� ��ٱ��Ͽ� ����� Item�� �߰��ϴ� ��� 
 * 2)��ٱ��Ͽ� ������� ���� Item�� �߰��ϴ� ���
 * --> īƮ�� �߰��Ϸ��� Item�� �ִ��� ���������� ���� �˾ƾ� �Ѵ�
 * �ִٸ� ---- ������ ����
 * ���ٸ� --- ���ο� Item�� ����
 * ::
 * 1. ���ǿ� ����� ��� �����۵��� �޾ƿ��� ����..ArrayList�� ��ȯ
 * 2. Item�� �߰��ϴ� ���� (1���� ���� ����� �ΰ����� ������)
 */

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.vo.CartVO;
import model.vo.ProductVO;

public class CartBiz {
	/*
	 * ���ǿ� ���ε��� cartList����Ʈ ������ �� �޾ƿ´�...
	 */
	public ArrayList<CartVO> getCartList(HttpServletRequest request){
		HttpSession session = request.getSession();	
		ArrayList<CartVO> carList= (ArrayList<CartVO>)session.getAttribute("cartList");
		return carList;
	}
	/*
	 * getCartList()�� ȣ���ؾ��Ѵ�.
	 * Item�� �ش��ϴ� ��ǰ�� cartList�� �ִٸ�....������ ����
	 * ���ٸ�...Cart�� �ϳ��� �߰��ؾ��Ѵ�.(Cart�� ����)
	 */	
	public void addCart(HttpServletRequest request,ProductVO product) { //?
		ArrayList<CartVO> cartList=getCartList(request);
		
		if(cartList==null) cartList = new ArrayList<CartVO>();
		
		CartVO cart = null;
		boolean newCart = true;
		//�ϳ� �̻��� Item�� ��ٱ��Ͽ� �ִٸ�...
		//cartList�� ����ִ� Item�� �߰��Ϸ��� Item�� �̸��� ���ٸ�
		//������ ����...
		for(CartVO c :cartList) {
			if(c.getName().equals(product.getName())) {
				newCart = false;
				c.setQuantity(c.getQuantity()+1);
			}//if
		}//for
		
		if(newCart) { //īƮ�� ����ִ� ��ǰ�� �ƴ϶��
			cart = new CartVO();
			cart.setImg_urls(product.getImg_urls());
			cart.setName(product.getName());
			cart.setPrice(product.getPrice());
			cart.setQuantity(1); //�̋��� ������ 1�� �ȴ�
			cartList.add(cart);
		}//
		
		//���ǿ� ���ε�
		request.getSession().setAttribute("cartList", cartList);		
	}//addCart
	/*
	 * ���ǿ� ���ε��� ArrayList�� �޾ƿͼ�
	 * ���߿��� ������ �����Ϸ��� name�� ��ġ�ϴ� ��ǰ�� �޾ƿͼ�
	 * name�� �ش��ϴ� ��ǰ�� ������ �ϳ��� ������Ű�� ������ �ۼ�
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































