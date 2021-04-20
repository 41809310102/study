package com.zhanshen.entity;

public class Address {
/*	  `did` varchar(50) NOT NULL,
	  `province` varchar(10) DEFAULT NULL,
	  `city` varchar(10) DEFAULT NULL,
	  `area` varchar(10) DEFAULT NULL,
	  `address` varchar(50) DEFAULT NULL,
	  `code` int(11) DEFAULT NULL,
	  `phone` int(11) DEFAULT NULL,
	  `telephone` int(11) DEFAULT NULL,*/
	private String did;
	private String province;
	private String city;
	private String area;
	private String address;
	private String code;
	private String phone;
	private String telephone;
	private String name;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDid() {
		return did;
	}
	public void setDid(String did) {
		this.did = did;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	
}
