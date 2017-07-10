package com.yc.wowo.biz;

import java.util.List;
import java.util.Map;

import com.yc.wowo.entities.Orders;

public interface IOrdersBiz {

	public int add(int usid, int gid, int nums, int totalprice);  
	
	public int del(String oid);
	
	public int update(int oid,int status);
	
	public List<Orders> find(int usid,int pageNo,int pageSize);
	
	public List<Orders> find(int pageNo, int pageSize);
	
	public List<Orders> find(Map<String,String> map,int pageNo,int pageSize);
	
	public int getTotal(Integer usid);
	
	public List<Orders> findAll();
}
