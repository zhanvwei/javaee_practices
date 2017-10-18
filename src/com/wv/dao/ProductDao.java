package com.wv.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.wv.domain.Product;
import com.wv.utils.DataSourceUtils;

public class ProductDao {
     
	//查询热门商品
	public List<Product> findHotProductList() throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from product where is_hot = ? limit ?, ?";
		
		return runner.query(sql, new BeanListHandler<Product>(Product.class), 1, 1, 9);
	}
    
	
	//获得最新商品列表
		public List<Product> findNewProductList() throws SQLException {
			QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
			String sql = "select * from product order by pdate desc limit ?,?";
	        return runner.query(sql, new BeanListHandler<Product>(Product.class), 1, 9);
		}
}
