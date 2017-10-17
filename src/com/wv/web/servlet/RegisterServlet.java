package com.wv.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

import com.wv.domain.User;
import com.wv.service.UserService;
import com.wv.utils.CommonUtils;
import com.wv.utils.MailUtils;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		// 获得表单数据
		Map<String, String[]> properties = request.getParameterMap();
		User user = new User();
		try {
			ConvertUtils.register(new Converter() {

				public Object convert(Class clazz, Object value) {
					// 将value转换成Date类型
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); // 指定日期格式
					Date parse = null;
					try {
						parse = format.parse(value.toString());
					} catch (ParseException e) {
						e.printStackTrace();
					}
					return parse;
				}
			}, Date.class);
			BeanUtils.populate(user, properties);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

		// user中还有缺一些数据uid, telephone, state, code
		user.setUid(CommonUtils.getUUID());
		user.setTelephone(null);
		String activeCode = CommonUtils.getUUID();
		user.setCode(activeCode);

		// 将user转给下一层
		UserService service = new UserService();
		boolean isRegisterSuccess = service.regist(user);

		if (isRegisterSuccess) {
			//注册时给用户发送激活邮件
			String emailMsg = "恭喜您注册成功，请点击下面的连接进行激活账户"
					+ "<a href='http://localhost:8080/WebShop/active?activeCode="+activeCode+"'>"
							+ "http://localhost:8080/WebShop/active?activeCode="+activeCode+"</a>";
			try {
				MailUtils.sendMail(user.getEmail(), emailMsg);
			} catch (AddressException e) {
				e.printStackTrace();
			} catch (MessagingException e) {
				e.printStackTrace();
			}
			//跳转到注册成功页面,重定向
			response.sendRedirect(request.getContextPath() + "/registerSuccess.jsp");
		} else {
			//跳转到注册失败页面
		    response.sendRedirect(request.getContextPath() + "/registerFail.jsp");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		    doGet(request, response);
	}

}
