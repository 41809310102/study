package com.zhanshen.entity;

import java.util.Date;

public class Product {
	/*`pid` varchar(50) NOT NULL,
	  `pname` varchar(20) DEFAULT NULL,
	  `pimage` varchar(255) DEFAULT NULL,
	  `price` double DEFAULT NULL,
	  `succ_count` int(11) DEFAULT NULL,
	  `pdesc` text,
	  `is_hot` int(11) DEFAULT NULL,
	  `pnumer` int(11) DEFAULT NULL,
	  `pdate` date DEFAULT NULL,
	  `cid` varchar(50) DEFAULT NULL,*/
		private String pid;
		private String pname;
		private String pimage;
		private double price;
		private Integer succ_count;
		private String pdesc;
		private Integer is_hot;
		private Date pdate;
		private Category category;
		private Integer pnumber;
		private Integer pflag;
		
		public Integer getPflag() {
			return pflag;
		}
		public void setPflag(Integer pflag) {
			this.pflag = pflag;
		}
		public String getPid() {
			return pid;
		}
		public void setPid(String pid) {
			this.pid = pid;
		}
		public String getPname() {
			return pname;
		}
		public void setPname(String pname) {
			this.pname = pname;
		}
		public String getPimage() {
			return pimage;
		}
		public void setPimage(String pimage) {
			this.pimage = pimage;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		public Integer getSucc_count() {
			return succ_count;
		}
		public void setSucc_count(Integer succ_count) {
			this.succ_count = succ_count;
		}
		public String getPdesc() {
			return pdesc;
		}
		public void setPdesc(String pdesc) {
			this.pdesc = pdesc;
		}
		public Integer getIs_hot() {
			return is_hot;
		}
		public void setIs_hot(Integer is_hot) {
			this.is_hot = is_hot;
		}
		
		public Integer getPnumber() {
			return pnumber;
		}
		public void setPnumber(Integer pnumber) {
			this.pnumber = pnumber;
		}
		public Date getPdate() {
			return pdate;
		}
		public void setPdate(Date pdate) {
			this.pdate = pdate;
		}
		public Category getCategory() {
			return category;
		}
		public void setCategory(Category category) {
			this.category = category;
		}
		
}
