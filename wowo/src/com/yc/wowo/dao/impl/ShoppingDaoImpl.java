package com.yc.wowo.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.yc.wowo.dao.DBHelper;
import com.yc.wowo.dao.ShoppingDao;
import com.yc.wowo.entities.Shopping;

public class ShoppingDaoImpl implements ShoppingDao {

	@Override
	public Integer add(String sname, String prov, String city, String area,String points, String tel, String date, String info) {
		DBHelper db = new DBHelper();
		List<Object> params = new ArrayList<Object>();
		String sql = "insert into shopping  values(seq_shopping_spid.nextval,?,?,?,?,?,?,?,?,'')";
		params.add(sname);
		params.add(prov);
		params.add(city);
		params.add(area);
		params.add(points);
		params.add(tel);
		params.add(date);
		params.add(info);
		
		return db.doUpdate(sql, params);
	}

	@Override
	public List<Shopping> find(Integer pageNo, Integer pageSize) {
		DBHelper db = new DBHelper();
		List<Object> params = new ArrayList<Object>();
		String sql = "";
		if(pageNo == null){
			sql = "select * from shopping order by spid desc";
		}else{
			sql = "select * from (select a.*,rownum rn from (select * from shopping order by spid desc) a where rownum<=?) where rn>?";
			params.add(pageNo*pageSize);
			params.add((pageNo-1)*pageSize);
		}
		return db.find(sql, params, Shopping.class);
	}

	@Override
	public int update(String sname, String prov, String city, String area,String points, String tel, String date, String info,String spid) {
		DBHelper db=new DBHelper();
		List<Object> params=new ArrayList<Object>();
		String sql="update shopping set sname=?,prov=?,city=?,area=?,points=?,tel=?,sdate=?,info=? where spid=?";
		
		params.add(sname);
		params.add(prov);
		params.add(city);
		params.add(area);
		params.add(points);
		params.add(tel);
		params.add(date);
		params.add(info);
		params.add(spid);
		return db.doUpdate(sql,params);
	}

	@Override
	public Integer del(Integer spid) {
		DBHelper db=new DBHelper();
		List<Object> params=new ArrayList<Object>();
		
		String sql="delete shopping where spid=?";
		params.add(spid);
		return db.doUpdate(sql,params);
	}

}
