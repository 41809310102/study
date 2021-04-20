package com.zhanshen.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.zhanshen.dao.AdminProductDao;
import com.zhanshen.dao.impl.AdminProductDaoImpl;
import com.zhanshen.entity.Product;
import com.zhanshen.service.AdminProductService;

import sun.reflect.generics.tree.BaseType;

public class AdminProductServiceImpl implements AdminProductService{
  private AdminProductDao dao=new AdminProductDaoImpl();
	@Override
	public boolean save(Product product) throws SQLException {
		int i=dao.save(product);
		return i>0?true:false;
	}
	@Override
	public List<Product> list() throws SQLException {
		
		return dao.list();
	}
	@Override
	public void delete(String[] ids) throws SQLException {
		dao.delete(ids);
		
	}

}
