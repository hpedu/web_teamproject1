package controller;

import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.ProductDAO;
import model.vo.ProductVO;
import service.PListVO;
import service.RListVO;
import service.RPService;

public class SearchController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("여기는 오냐!!!!!!!!!!");
		String text = request.getParameter("search");
		request.setAttribute("search", text);
		String page=request.getParameter("page");
		
		System.out.println(page);
		System.out.println(text);
		String [] array =  {" "};
		if(text!=null) {
		int i=0;
		text = text.replace(",", " ");
		StringTokenizer st = new StringTokenizer(text, " ");	//,로 단어 구분
		
			if(!request.getParameter("search").equals("")) {
				while(st.hasMoreElements()){
					array[i++] = st.nextToken();
				}
			}
			for(String str : array)
			System.out.println(str);
		}else
		System.out.println("널이니까 바로 일루와");
		System.out.println(array);
		
		RListVO rlist = RPService.getInstance().searchrecipe(array, page);
		PListVO plist =  RPService.getInstance().searchProduct(array, page);
		
		ArrayList<ProductVO> list3 = ProductDAO.getInstance().showProductHot();
		System.out.println("3");
		ArrayList<ProductVO> list4 = ProductDAO.getInstance().showProductRecommend();
		System.out.println("4");
		request.setAttribute("HotPlist", list3);
		request.setAttribute("RecommendPlist", list4);
		
		System.out.println(rlist);
		request.setAttribute("rlist", rlist);
		request.setAttribute("plist", plist);	
		System.out.println("mv반환");
		return new ModelAndView("searchRecipeResult.jsp");
	}
}
