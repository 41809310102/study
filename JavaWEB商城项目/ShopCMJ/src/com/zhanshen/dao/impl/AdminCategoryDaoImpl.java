package com.zhanshen.dao.impl;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.taglibs.standard.tag.common.sql.DataSourceUtil;
import org.eclipse.jdt.core.compiler.CategorizedProblem;

import com.zhanshen.dao.AdminCategoryDao;
import com.zhanshen.entity.Category;
import com.zhanshen.entity.Product;
import com.zhanshen.service.AdminProductService;
import com.zhanshen.utils.DataSourceUtils;

public class AdminCategoryDaoImpl implements AdminCategoryDao{

	@Override
	public List<Category> list() throws SQLException {
		QueryRunner queryRunner=new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select * from category";
		List<Category> list = queryRunner.query(sql,new BeanListHandler<>(Category.class));
		return list;
	}


}
