package com.zhanshen.entity;

public class User {
/*	 `uid` varchar(50) NOT NULL,
	  `username` varchar(20) DEFAULT NULL,
	  `password` varchar(10) DEFAULT NULL,
	  `name` varchar(10) DEFAULT NULL,
	  `sex` varchar(10) DEFAULT NULL,*/
	private String uid;
	private String username;
	private String password;
	private String name;
	private String sex;
	private String email;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	
	
}
