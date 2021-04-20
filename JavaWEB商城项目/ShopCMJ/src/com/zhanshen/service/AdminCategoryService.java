package com.zhanshen.service;

import java.sql.SQLException;
import java.util.List;

import com.zhanshen.entity.Category;

public interface AdminCategoryService  {
	public List<Category> list() throws SQLException;
}
