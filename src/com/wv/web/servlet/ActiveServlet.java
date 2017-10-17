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
		//��ȡע���û��ļ�����
		String activeCode = request.getParameter("activeCode");
		UserService service = new  UserService();
	    service.active(activeCode);

	   //��ת����¼ҳ��
	    response.sendRedirect(request.getContextPath()+"/login.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
