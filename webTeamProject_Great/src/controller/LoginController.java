package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDAO;
import model.vo.MemberVO;

public class LoginController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String path = "login_fail.jsp";
		String id = request.getParameter("id");
		String password = request.getParameter("password");

		MemberVO vo = MemberDAO.getInstance().login(id, password);
		
		if(vo !=null){
			HttpSession session = request.getSession();
			session.setAttribute("login", vo);
			path = "login_ok.jsp";
		}
		System.out.println(vo);
		return new ModelAndView(path);
	}
}
