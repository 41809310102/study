package com.zhanshen.service;

import java.sql.SQLException;
import java.util.List;

import com.zhanshen.entity.Address;
import com.zhanshen.entity.Product;
import com.zhanshen.entity.User;

public interface ProductService {
	public User login(String username,String password) throws SQLException;

	public void register(User user);
	public List<Product> cateProductList(String cid) throws SQLException;
	public Product findProductById(String pid) throws SQLException;

	public void saveAddress(Address address) throws SQLException;

	public Address findAddressByDid(String did);

	public void updateStateByOid(String r6_Order);

	public List<Product> searchProduct(String title) throws SQLException;

	public List<Product> priceAreaOrder(String min, String max) throws SQLException;

	public List<Object> findProductListByName(String name) throws SQLException;

	
}
