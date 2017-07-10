package com.yc.wowo.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.yc.wowo.dao.DBHelper;
import com.yc.wowo.dao.IOrdersDao;
import com.yc.wowo.entities.Orders;

public class OrdersDaoImpl implements IOrdersDao{

	@Override
	public int add(int usid, int gid, int nums, int totalprice) {
		DBHelper db=new DBHelper();
		String sql="insert into orders values(seq_orders_oid.nextval,'',?,?,?,?,0)";
		List<Object> params=new ArrayList<Object>();
		params.add(usid);
		params.add(gid);
		params.add(nums);
		params.add(totalprice);
		return db.doUpdate(sql, params);
	}

	@Override
	public int del(String oid) {
		DBHelper db=new DBHelper();
		String sql="";
		List<Object> params=new ArrayList<Object>();
		if(oid.contains(",")){
			sql="delete from orders where oid in("+oid+")";
		}else{
			sql="delete from orders where oid=?";
			params.add(oid);
		}
		return db.doUpdate(sql, params);
	}

	@Override
	public int update(int oid, int status) {
		DBHelper db=new DBHelper();
		String sql="update orders set status=? where oid=?";
		List<Object> params=new ArrayList<Object>();
		params.add(status);
		params.add(oid);
		return db.doUpdate(sql, params);
	}

	@Override
	public List<Orders> find(int usid, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Orders> find(int pageNo, int pageSize) {
		DBHelper db=new DBHelper();
		String sql="select *from (select a.*,rownum as rn from (select *from Orders order by gid asc) a where rownum<=?) where rn>?";
		List<Object> params=new ArrayList<Object>();
		params.add(pageNo*pageSize);
		params.add((pageNo-1)*pageSize);
		return db.find(sql, params, Orders.class);
	}

	@Override
	public List<Orders> find(Map<String, String> map, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTotal(Integer usid) {
		DBHelper db=new DBHelper();
		String sql=null;
		List<Object> params=new ArrayList<Object>();
		if(usid==null){
			sql="select count(oid) from orders";
		}else{
			sql="select count(oid) from orders where usid=?";
			params.add(usid);
		}
		return db.findByOne(sql, params);
	}

	@Override
	public List<Orders> findAll() {
		DBHelper db=new DBHelper();
		String sql=null;
		List<Object> params=new ArrayList<Object>();
		sql="select * from orders order by oid asc";
		
		return db.find(sql, params, Orders.class);
	}

	
}
