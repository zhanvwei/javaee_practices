package com.wv.dao;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.wv.domain.User;
import com.wv.utils.DataSourceUtils;

public class UserDao {
      //ע��
	public int regist(User user) throws SQLException {
        QueryRunner  runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "insert into user values(?,?,?,?,?,?,?,?,?,?)";
        int update = runner.update(sql,user.getUid(),user.getUsername(),user.getPassword(),
				user.getName(),user.getEmail(),user.getTelephone(),user.getBirthday(),
                user.getSex(),user.getState(),user.getCode());
		return update;
	}
     
	//����
	public void active(String activeCode) throws SQLException {
		 QueryRunner  runner = new QueryRunner(DataSourceUtils.getDataSource());
		 String sql = "update user set state=? where code=?";
		 runner.update(sql, 1, activeCode);
	}

	//У���û����Ƿ����
	public Long checkUsername(String username) throws SQLException {
	    QueryRunner  runner = new QueryRunner(DataSourceUtils.getDataSource());
	    String sql = "select count(*) from user where username=?";
	    Long query = (Long) runner.query(sql, new ScalarHandler(), username);
		return query;
	}
  
}
