package com.zhanshen.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.taglibs.standard.lang.jstl.test.Bean1;

import com.zhanshen.dao.PrivilegeDao;
import com.zhanshen.entity.Address;
import com.zhanshen.entity.Order;
import com.zhanshen.entity.OrderItem;
import com.zhanshen.entity.User;
import com.zhanshen.utils.DataSourceUtils;

public class PrivilegeDaoImpl implements PrivilegeDao {

	@Override
	public List<Address> addressList() throws SQLException {
		QueryRunner queryRunner=new QueryRunner(DataSourceUtils.getDataSource());
		List<Address> list = queryRunner.query("select * from address", new BeanListHandler<>(Address.class));
		return list;
	}

	@Override
	public Address findAddressById(String did) throws SQLException {
		QueryRunner queryRunner=new QueryRunner(DataSourceUtils.getDataSource());
		
		return queryRunner.query("select * from address where did = ?",new BeanHandler<>(Address.class), did);
	}
	@Override
	public void updateAddress(Address address) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner queryRunner=new QueryRunner(DataSourceUtils.getDataSource());
		String sql="update address set province=?,city=?,area=?,address=?,code=?,phone=?,telephone=?,name=? where did = ?";
		queryRunner.update(sql,address.getProvince(),address.getCity(),address.getArea(),address.getAddress(),
				address.getCode(),address.getPhone(),address.getTelephone(),address.getName(),address.getDid());
	}

	@Override
	public void deleteAddress(String did) {
		QueryRunner queryRunner=new QueryRunner(DataSourceUtils.getDataSource());
		String sql="delete from address where did=? ";
		try {
			queryRunner.update(sql,did);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void saveOrderItem(List<OrderItem> list) throws SQLException {
		QueryRunner queryRunner=new QueryRunner(DataSourceUtils.getDataSource());
		String sql="insert into orderitem values(?,?,?,?,?)";
		for (OrderItem orderItem : list) {
			queryRunner.update(sql,orderItem.getItem_id(),orderItem.getCount(),orderItem.getSubtotal()
					,orderItem.getProduct().getPid(),orderItem.getOrder().getOid());
			
		}
		
	}

	@Override
	public void saveOrder(Order order) throws SQLException {
		QueryRunner queryRunner=new QueryRunner(DataSourceUtils.getDataSource());
		String sql="insert into orders values(?,?,?,?,?,?,?)";
		queryRunner.update(sql,order.getOid(),order.getTotal(),order.getState(),order.getAddress(),order.getName(),order.getTelephone(),
				order.getUser().getUid());
		
	}

	
	@Override
	public   List<Order> myOrder(String uid) throws SQLException {
		QueryRunner queryRunner=new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select * from orders where uid = ?";
	      List<Order> list = queryRunner.query(sql, new BeanListHandler<>(Order.class),uid);
		return list;
	}
	@Override
	public List<Map<String, Object>> myOrderitemList(String oid) throws SQLException {
		QueryRunner queryRunner=new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select p.pimage,p.pname,p.price,m.count,m.subtotal from product p,orderitem m where m.pid=p.pid and oid = ?";
		List<Map<String, Object>> list = queryRunner.query(sql, new MapListHandler(),oid);
		return list;
	}
	

}
