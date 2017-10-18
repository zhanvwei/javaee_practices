package com.wv.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.wv.domain.Product;
import com.wv.utils.DataSourceUtils;

public class ProductDao {
     
	//��ѯ������Ʒ
	public List<Product> findHotProductList() throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from product where is_hot = ? limit ?, ?";
		
		return runner.query(sql, new BeanListHandler<Product>(Product.class), 1, 1, 9);
	}
    
	
	//���������Ʒ�б�
		public List<Product> findNewProductList() throws SQLException {
			QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
			String sql = "select * from product order by pdate desc limit ?,?";
	        return runner.query(sql, new BeanListHandler<Product>(Product.class), 1, 9);
		}
}
