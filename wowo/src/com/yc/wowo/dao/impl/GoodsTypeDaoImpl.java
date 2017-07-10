package com.yc.wowo.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.yc.wowo.dao.DBHelper;
import com.yc.wowo.dao.GoodsTypeDao;
import com.yc.wowo.entities.GoodsType;

public class GoodsTypeDaoImpl implements GoodsTypeDao {

	@Override
	public List<GoodsType> find(Integer tid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GoodsType> find(Integer pageNo, Integer pageSize) {
		DBHelper db = new DBHelper();
		List<Object> params = new ArrayList<Object>();
		String sql = "";
		if(pageNo == null){
			sql = "select * from goodstype order by tid desc";
		}else{
			sql = "select * from (select a.*,rownum rn from (select * from goodstype order by tid desc) a where rownum<=?) where rn>?";
			params.add(pageNo*pageSize);
			params.add((pageNo-1)*pageSize);
		}
		return db.find(sql, params, GoodsType.class);
	}

	@Override
	public Integer update(Integer tid, String tname,String des) {
		DBHelper db = new DBHelper();
		List<Object> params = new ArrayList<Object>();
		String sql = "update goodstype set tname=?,des=? where tid=?";
		params.add(tname);
		params.add(des);
		params.add(tid);
		return db.doUpdate(sql, params);
	}

	@Override
	public Integer del(String tid) {
		DBHelper db = new DBHelper();
		List<Object> params = new ArrayList<Object>();
		String sql = "delete goodstype where tid=?";
		params.add(tid);
		return db.doUpdate(sql, params);
	}

	@Override
	public int getTotal(String userid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Integer add(String tname, String des) {
		DBHelper db = new DBHelper();
		List<Object> params = new ArrayList<Object>();
		String sql = "insert into goodstype values(seq_goodstype_tid.nextval,?,?,1)";
		params.add(tname);
		params.add(des);
		return db.doUpdate(sql, params);
	}

}
