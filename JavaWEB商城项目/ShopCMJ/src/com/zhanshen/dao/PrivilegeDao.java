package com.zhanshen.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.zhanshen.entity.Address;
import com.zhanshen.entity.Order;
import com.zhanshen.entity.OrderItem;
import com.zhanshen.entity.User;

public interface PrivilegeDao {	
	public List<Address> addressList() throws SQLException;
	public void updateAddress(Address address) throws SQLException;
	public Address findAddressById(String did) throws SQLException;
	public void deleteAddress(String did);
	public void saveOrderItem(List<OrderItem> list) throws SQLException;
	public void saveOrder(Order order) throws SQLException;
	List<Order> myOrder(String uid) throws SQLException;
	List<Map<String, Object>> myOrderitemList(String oid) throws SQLException;
}
