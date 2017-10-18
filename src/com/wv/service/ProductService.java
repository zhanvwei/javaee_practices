package com.wv.service;

import java.sql.SQLException;
import java.util.List;

import com.wv.dao.ProductDao;
import com.wv.domain.Product;

public class ProductService {
   
	//���������Ʒ�б�
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
	
	//���������Ʒ�б�
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
