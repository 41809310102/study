package com.zhanshen.entity;

import java.util.HashMap;
import java.util.Map;

public class Cart {
	private double total;
	private Map<String, CartItem> map=new HashMap<>();
	
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public Map<String, CartItem> getMap() {
		return map;
	}
	public void setMap(Map<String, CartItem> map) {
		this.map = map;
	}
	
	
}
