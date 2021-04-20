package com.zhanshen.entity;

import java.util.ArrayList;
import java.util.List;

public class Order {
/*	`oid` varchar(50) NOT NULL,
	  `total` double DEFAULT NULL,
	  `state` int(11) DEFAULT NULL,
	  `address` varchar(255) DEFAULT NULL,
	  `name` varchar(50) DEFAULT NULL,
	  `telephone` int(11) DEFAULT NULL,
	  `uid` varchar(50) DEFAULT NULL,*/
	
	private String oid;
	private Double total;
	private Integer state;
	private String address;
	private String name;
	private String telephone;
	private User user;
	private List<OrderItem> list=new ArrayList<>();
	
	public List<OrderItem> getList() {
		return list;
	}
	public void setList(List<OrderItem> list) {
		this.list = list;
	}
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
}
