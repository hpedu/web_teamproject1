<<<<<<< HEAD
package controller;

import java.io.IOException;
<<<<<<< HEAD
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("command");
		Controller controller=HandlerMapping.getInstance().createController(command);
		
		String path=  "index.jsp";
		ModelAndView mv = null;
		boolean isRedirect = true;		
		try {
			System.out.println("DispatcherServlet handleRequest..call...");
			mv=controller.handleRequest(request, response);
			System.out.println("DispatcherServlet handleRequest...mv :: "+mv);
			path = mv.getPath();
			isRedirect = mv.isRedirect();
		}catch(Exception e) {
			
		}//
		
		if(isRedirect) response.sendRedirect(path);
		else request.getRequestDispatcher(path).forward(request, response);		
	}
}












=======
<<<<<<< HEAD
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

		String command = request.getParameter("command");
		Controller controller = HandlerMapping.getInstance().createFactory(command);
		
		String path="index.jsp";
		ModelAndView mv = null;
		boolean isRedirect = true;
		
		try {
			mv = controller.handleRequest(request, response);
			path = mv.getPath();
			isRedirect = mv.isRedirect();
			System.out.println(mv);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(mv!=null) {
			HashMap<String, Object> map = mv.getModelMap();
			Iterator<String> it = map.keySet().iterator();
			
			while(it.hasNext()) {
				String key = it.next();
				request.setAttribute(key, map.get(key));
				System.out.println(key + " / "+ map.get(key));
			}
		
		if(isRedirect)	response.sendRedirect(path);
		else	request.getRequestDispatcher(path).forward(request, response);
	}
			
//	}else {
//		System.out.println("mvloading ½ÇÆÐ");
//	}
	}
}
=======
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("command");
		Controller controller=HandlerMapping.getInstance().createController(command);
		
		String path= "index.jsp";
		ModelAndView mv = null;
		boolean isRedirect = true;		
		try {
			System.out.println("DispatcherServlet handleRequest..call...");
			mv = controller.handleRequest(request, response);
			System.out.println("DispatcherServlet handleRequest...mv :: "+mv);
			path = mv.getPath();
			isRedirect = mv.isRedirect();
		}catch(Exception e) {
			
		}//
		
		if(isRedirect) response.sendRedirect(path);
		else request.getRequestDispatcher(path).forward(request, response);		
	}
}
>>>>>>> refs/remotes/origin/master

=======
package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("command");
		Controller controller=HandlerMapping.getInstance().createFactory(command);
		
		String path= "index.jsp";
		ModelAndView mv = null;
		boolean isRedirect = true;		
		try {
			System.out.println("DispatcherServlet handleRequest..call...");
			mv = controller.handleRequest(request, response);
			System.out.println("DispatcherServlet handleRequest...mv :: "+mv);
			path = mv.getPath();
			isRedirect = mv.isRedirect();
		}catch(Exception e) {
			
		}//
		
		if(isRedirect) response.sendRedirect(path);
		else request.getRequestDispatcher(path).forward(request, response);		
	}
}

>>>>>>> branch 'master' of https://github.com/hpedu/web_teamproject1.git
