package com.wv.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wv.service.UserService;

public class ActiveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取注册用户的激活码
		String activeCode = request.getParameter("activeCode");
		UserService service = new  UserService();
	    service.active(activeCode);

	   //跳转到登录页面
	    response.sendRedirect(request.getContextPath()+"/login.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
