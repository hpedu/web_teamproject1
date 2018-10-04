package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.HandlerMapping;

public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//원래는 hidden태그를 이용해서 어디서 들어온 요청인지 구분했음
		String requestURI = request.getRequestURI();
		
		System.out.println(requestURI);
		String contextpath = request.getContextPath();
		System.out.println(contextpath);
		
		String command = requestURI.substring(contextpath.length()+1);
		System.out.println(command);
		HandlerMapping factory = HandlerMapping.getInstance();
		Controller controller = factory.createFactory(command);
		
		ModelAndView mv = null;
		
		try {
			mv = controller.handleReqeust(request, response);
			System.out.println(mv);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(mv!=null) {
			HashMap<String, Object> map = mv.getModelMap();
			System.out.println(mv);
			Iterator<String> it = map.keySet().iterator();
			while(it.hasNext()) {
				String key = it.next();
				request.setAttribute(key, map.get(key));
				System.out.println(key + " / "+ map.get(key));
			}
		
		if(mv.isRedirect())response.sendRedirect(mv.getView());
		else	request.getRequestDispatcher(mv.getView()).forward(request, response);
		
			
	}else {
		System.out.println("mvloading 실패");
	}}
}
