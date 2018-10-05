package controller;

import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SearchDao;
import model.vo.BoardVO1;

public class SearchController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String text = request.getParameter("search");
		int i=0;
		text = text.replace(",", " ");
		StringTokenizer st = new StringTokenizer(text, " ");	//,�� �ܾ� ����
		String [] array = new String[st.countTokens()];
		while(st.hasMoreElements()){
			array[i++] = st.nextToken();
		}

		
		ArrayList<BoardVO1> list = SearchDao.getInstance().searchRecipe(array);
		for(BoardVO1 b : list)
		System.out.println(b);
		request.setAttribute("list", list);
				
		return new ModelAndView("recipedetail.jsp");
	}
}
