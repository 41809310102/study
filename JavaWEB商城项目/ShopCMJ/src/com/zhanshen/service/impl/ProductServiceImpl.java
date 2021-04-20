package com.zhanshen.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.zhanshen.dao.ProductDao;
import com.zhanshen.dao.impl.ProductDaoImpl;
import com.zhanshen.entity.Address;
import com.zhanshen.entity.Product;
import com.zhanshen.entity.User;
import com.zhanshen.service.ProductService;

public class ProductServiceImpl implements ProductService {
	  private ProductDao dao=new ProductDaoImpl();

	  @Override
	  public User login(String username, String password) throws SQLException {
	  	
	  	return dao.login(username, password);
	  }

	@Override
	public void register(User user) {
		try {
			dao.register(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Product> cateProductList(String cid) throws SQLException {
		List<Product> list=dao.cateProductList(cid);
		return list;
	}

	@Override
	public Product findProductById(String pid) throws SQLException {
		
		return dao.findProductById(pid);
	}

	@Override
	public void saveAddress(Address address) throws SQLException {
		dao.saveAddress(address);
		
	}

	@Override
	public Address findAddressByDid(String did) {
		Address address=null;
		try {
			address = dao.findAddressByDid(did);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return address;
	}

	@Override
	public void updateStateByOid(String r6_Order) {
		try {
			dao.updateStateByOid(r6_Order);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Product> searchProduct(String title) throws SQLException {
		
		return dao.searchProduct(title);
	}

	@Override
	public List<Product> priceAreaOrder(String min, String max) throws SQLException {
		
		return dao.priceAreaOrder(min,max);
	}

	@Override
	public List<Object> findProductListByName(String name) throws SQLException {
		// TODO Auto-generated method stub
		return dao.findProductListByName(name);
	}

	

}
