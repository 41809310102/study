package com.zhanshen.service.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.zhanshen.dao.PrivilegeDao;
import com.zhanshen.dao.impl.PrivilegeDaoImpl;
import com.zhanshen.entity.Address;
import com.zhanshen.entity.Order;
import com.zhanshen.entity.OrderItem;
import com.zhanshen.entity.User;
import com.zhanshen.service.PrivilegeService;

public class PrivilegeServiceImpl implements PrivilegeService {
	private PrivilegeDao dao=new PrivilegeDaoImpl();

	@Override
	public List<Address> addressList() throws SQLException {
		List<Address> list = dao.addressList();
		return list;
	}

	@Override
	public Address findAddressById(String did) throws SQLException {
		
		return dao.findAddressById(did);
	}
	@Override
	public void updateAddress(Address address) throws SQLException {
		dao.updateAddress(address);
		
	}

	@Override
	public void deleteAddress(String did) {
		dao.deleteAddress(did);
		
	}

	@Override
	public void saveOrderItem(List<OrderItem> list) {
		try {
			dao.saveOrderItem(list);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void saveOrder(Order order) {
		try {
			dao.saveOrder(order);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Order> myOrder(String uid) throws SQLException {
		
		return dao.myOrder(uid);
	}
	@Override
	public List<Map<String, Object>> myOrderItemList(String oid) throws SQLException {
		
		return dao.myOrderitemList(oid);
	}



}
