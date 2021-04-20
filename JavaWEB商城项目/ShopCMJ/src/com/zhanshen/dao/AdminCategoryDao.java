package com.zhanshen.dao;


import java.sql.SQLException;
import java.util.List;

import com.zhanshen.entity.Category;

public interface AdminCategoryDao {
   public List<Category> list() throws SQLException;
}
