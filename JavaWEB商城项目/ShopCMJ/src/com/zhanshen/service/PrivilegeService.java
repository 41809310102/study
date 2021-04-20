package com.zhanshen.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.zhanshen.entity.Address;
import com.zhanshen.entity.Order;
import com.zhanshen.entity.OrderItem;
import com.zhanshen.entity.User;

public interface PrivilegeService {
	public List<Address> addressList() throws SQLException;
	public void updateAddress(Address address) throws SQLException;
	public Address findAddressById(String parameter) throws SQLException;
	public void deleteAddress(String did);
	public void saveOrderItem(List<OrderItem> list);
	public void saveOrder(Order order);
	List<Order> myOrder(String uid) throws SQLException;
	List<Map<String, Object>> myOrderItemList(String oid) throws SQLException;
}
