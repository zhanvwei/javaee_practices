package com.wv.service;

import java.sql.SQLException;

import com.wv.dao.UserDao;
import com.wv.domain.User;

public class UserService {
	public boolean regist(User user) {
		UserDao dao = new UserDao();
		int row = 0;
		try {
			row = dao.regist(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row > 0 ? true : false;
	}
     
	//����
	public void active(String activeCode) {
		UserDao dao = new UserDao();
		try {
			dao.active(activeCode);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	//У���û����Ƿ����
	public boolean checkUsername(String username) {
		UserDao dao = new UserDao();
		Long isExist = 0L;
		try {
			 isExist = dao.checkUsername(username);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isExist>0?true:false;
	}

}
