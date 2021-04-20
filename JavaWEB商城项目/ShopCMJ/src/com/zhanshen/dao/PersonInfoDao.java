package com.zhanshen.dao;

import java.sql.SQLException;

import com.zhanshen.entity.User;

public interface PersonInfoDao {

	void update(User user) throws SQLException;

}
