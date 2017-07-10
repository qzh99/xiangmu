package com.yc.wowo.biz.impl;

import java.util.List;

import com.yc.wowo.biz.GoodsTypeBiz;
import com.yc.wowo.dao.GoodsTypeDao;
import com.yc.wowo.dao.impl.GoodsTypeDaoImpl;
import com.yc.wowo.entities.GoodsType;

public class GoodsTypeBizImpl implements GoodsTypeBiz {
	
	public Integer add(String tname,String des){
		if(tname == null || "".equals(tname)){
			return null;
		}
		
		GoodsTypeDao goodsTypeDao = new GoodsTypeDaoImpl();
		return goodsTypeDao.add(tname, des);
	};
	@Override
	public List<GoodsType> find(Integer tid) {
		GoodsTypeDao goodsTypeDao = new GoodsTypeDaoImpl();
		return goodsTypeDao.find(tid);
	}

	@Override
	public List<GoodsType> find(Integer pageNo, Integer pageSize) {
		GoodsTypeDao goodsTypeDao = new GoodsTypeDaoImpl();
		return goodsTypeDao.find(pageNo, pageSize);
	}

	@Override
	public Integer update(Integer tid, String tname,String des) {
		if(tname == null || "".equals(tname)){
			return null;
		}
		GoodsTypeDao goodsTypeDao = new GoodsTypeDaoImpl();
		return goodsTypeDao.update(tid,tname,des);
	}

	@Override
	public Integer del(String tid) {
		GoodsTypeDao goodsTypeDao = new GoodsTypeDaoImpl();
		return goodsTypeDao.del(tid);
	}

	@Override
	public int getTotal(String tid) {
		GoodsTypeDao goodsTypeDao = new GoodsTypeDaoImpl();
		return goodsTypeDao.getTotal(tid);
	}

}
