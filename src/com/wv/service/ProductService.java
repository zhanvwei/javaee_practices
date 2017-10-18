package com.wv.service;

import java.sql.SQLException;
import java.util.List;

import com.wv.dao.ProductDao;
import com.wv.domain.Product;

public class ProductService {
   
	//获得热门商品列表
	public List<Product> findHotProductList() {
		ProductDao dao = new ProductDao();
		List<Product> hotProductList = null;
		try {
			hotProductList = dao.findHotProductList();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		 return hotProductList;
	}
	
	//获得最新商品列表
		public List<Product> findNewProductList() {
			ProductDao dao = new ProductDao();
			List<Product> newProductList = null;
			try {
				newProductList = dao.findHotProductList();
			} catch (SQLException e) {
				e.printStackTrace();
			}	
			 return newProductList;
		}
   
}
