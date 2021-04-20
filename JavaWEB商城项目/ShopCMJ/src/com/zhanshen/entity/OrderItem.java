package com.zhanshen.entity;

public class OrderItem {
	/*
	 * CREATE TABLE `orderitem` ( `item_id` varchar(50) NOT NULL, `count`
	 * int(11) DEFAULT NULL, `subtotal` double DEFAULT NULL, `pid` varchar(50)
	 * DEFAULT NULL, `oid` varchar(50) DEFAULT NULL, PRIMARY KEY (`item_id`),
	 * KEY `fk_f006` (`pid`), KEY `fk_f002` (`oid`), CONSTRAINT `fk_f002`
	 * FOREIGN KEY (`oid`) REFERENCES `orders` (`oid`), CONSTRAINT `fk_f006`
	 * FOREIGN KEY (`pid`) REFERENCES `product` (`pid`) ) ENGINE=InnoDB DEFAULT
	 * CHARSET=utf8;
	 */
	private String item_id;
	private Integer count;
	private Double subtotal;
	private Product product;
	private Order order;

	public String getItem_id() {
		return item_id;
	}

	public void setItem_id(String item_id) {
		this.item_id = item_id;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

}
