package com.zhanshen.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.zhanshen.dao.AdminCategoryDao;
import com.zhanshen.dao.AdminProductDao;
import com.zhanshen.dao.impl.AdminCategoryDaoImpl;
import com.zhanshen.dao.impl.AdminProductDaoImpl;
import com.zhanshen.entity.Category;
import com.zhanshen.entity.Product;
import com.zhanshen.service.AdminCategoryService;
import com.zhanshen.service.AdminProductService;

import sun.reflect.generics.tree.BaseType;

public class AdminCategoryServiceImpl implements AdminCategoryService{
private AdminCategoryDao dao=new AdminCategoryDaoImpl();

	@Override
	public List<Category> list() throws SQLException {
		// TODO Auto-generated method stub
		return dao.list();
	}


}
