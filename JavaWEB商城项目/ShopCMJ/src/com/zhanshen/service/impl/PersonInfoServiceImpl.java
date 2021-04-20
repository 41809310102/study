package com.zhanshen.service.impl;

import java.sql.SQLException;

import com.zhanshen.dao.PersonInfoDao;
import com.zhanshen.dao.impl.PersonInfoDaoImpl;
import com.zhanshen.entity.User;
import com.zhanshen.service.PersonInfoService;

public class PersonInfoServiceImpl implements PersonInfoService {
private PersonInfoDao dao=new PersonInfoDaoImpl();
	@Override
	public void update(User user) {
		try {
			dao.update(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
