package com.wv.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wv.domain.Product;
import com.wv.service.ProductService;

/**
 * Servlet implementation class indexServlet
 */
public class indexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   ProductService service = new ProductService();
		   
		   //准备热门商品  hotProductList
		    List<Product> hotProductList = service.findHotProductList();
		    
		    //准备最新商品     newProductList
		    List<Product> newProductList = service.findNewProductList();
		    
		    request.setAttribute("hotProductList", hotProductList);
		    request.setAttribute("newProductList", newProductList);
		    
		    request.getRequestDispatcher("/index.jsp").forward(request, response);
		   
		   
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
