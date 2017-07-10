package com.yc.wowo.biz.impl;

import java.util.List;
import java.util.Map;

import com.yc.wowo.biz.IOrdersBiz;
import com.yc.wowo.dao.IOrdersDao;
import com.yc.wowo.dao.impl.OrdersDaoImpl;
import com.yc.wowo.entities.Orders;

public class OrdersBizImpl implements IOrdersBiz{

	@Override
	public int add(int usid, int gid, int nums, int totalprice) {
		IOrdersDao ordersDao=new OrdersDaoImpl();
		return ordersDao.add(usid, gid, nums, totalprice);
	}

	@Override
	public int del(String oid) {
		IOrdersDao ordersDao=new OrdersDaoImpl();
		return ordersDao.del(oid);
	}

	@Override
	public int update(int oid, int status) {
		IOrdersDao ordersDao=new OrdersDaoImpl();
		return ordersDao.update(oid, status);
	}

	@Override
	public List<Orders> find(int usid, int pageNo, int pageSize) {
		IOrdersDao ordersDao=new OrdersDaoImpl();
		return ordersDao.find(usid, pageNo, pageSize);
	}

	@Override
	public List<Orders> find(int pageNo, int pageSize) {
		IOrdersDao ordersDao=new OrdersDaoImpl();
		return ordersDao.find(pageNo, pageSize);
	}

	@Override
	public List<Orders> find(Map<String, String> map, int pageNo, int pageSize) {
		IOrdersDao ordersDao=new OrdersDaoImpl();
		return ordersDao.find(map, pageNo, pageSize);
	}

	@Override
	public int getTotal(Integer usid) {
		IOrdersDao ordersDao=new OrdersDaoImpl();
		return ordersDao.getTotal(usid);
	}

	@Override
	public List<Orders> findAll() {
		IOrdersDao ordersDao=new OrdersDaoImpl();
		return ordersDao.findAll();
	}

}
