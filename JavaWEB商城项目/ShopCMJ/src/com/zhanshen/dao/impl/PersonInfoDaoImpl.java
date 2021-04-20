package com.zhanshen.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.zhanshen.dao.PersonInfoDao;
import com.zhanshen.entity.User;
import com.zhanshen.utils.DataSourceUtils;

public class PersonInfoDaoImpl implements PersonInfoDao {

	@Override
	public void update(User user) throws SQLException {
		QueryRunner queryRunner=new QueryRunner(DataSourceUtils.getDataSource());
		queryRunner.update("update user set name=?,sex=? where uid= ?",user.getName(),user.getSex(),user.getUid());
	}

}
