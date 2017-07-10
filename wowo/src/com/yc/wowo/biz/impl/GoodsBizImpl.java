package com.yc.wowo.biz.impl;

import java.util.List;
import java.util.Map;

import com.yc.wowo.dao.GoodsDao;
import com.yc.wowo.dao.impl.GoodsDaoImpl;
import com.yc.wowo.biz.GoodsBiz;
import com.yc.wowo.entities.Goods;

public class GoodsBizImpl implements GoodsBiz{

	@Override
	public Integer add( String goodname, String mark,  String price,String photo,String spit) {
		GoodsDao goodsDao = new GoodsDaoImpl();
		return goodsDao.add( goodname, mark, price, photo,spit);
	}

	@Override
	public Integer updateGoods(Map<String, String> map, String flag) {
		return null;
	}

	@Override
	public List<Goods> findGoods(Map<String, String> map, String pageNo, String pageSize) {
		GoodsDao goodsDao = new GoodsDaoImpl();
		return goodsDao.findGoods(map, pageNo, pageSize);
	}

	@Override
	public Integer delGoods(Map<String, String> map) {
		return null;
	}

	@Override
	public List<Goods> findGoods(String op) {
		if(op == null){
			return null;
		}
		GoodsDao goodsDao = new GoodsDaoImpl();
		return goodsDao.findGoods(op);
	}

	@Override
	public List<Goods> find() {
		GoodsDao goodsDao = new GoodsDaoImpl();
		return goodsDao.find();
	}

	@Override
	public List<Goods> find(Integer gid) {
		GoodsDao goodsDao = new GoodsDaoImpl();
		return goodsDao.find(gid);
	}

}
