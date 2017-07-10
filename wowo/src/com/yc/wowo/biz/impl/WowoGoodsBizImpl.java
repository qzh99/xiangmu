package com.yc.wowo.biz.impl;

import java.util.List;
import java.util.Map;

import com.yc.wowo.biz.IWowoGoodsBiz;
import com.yc.wowo.dao.IWowoGoodsDao;
import com.yc.wowo.dao.impl.WowoGoodsDaoImpl;
import com.yc.wowo.entities.WowoGoods;

public class WowoGoodsBizImpl implements IWowoGoodsBiz{

	@Override
	public Integer add(String shop, String type, String tag, String title, String mark, String wowoprice, String price,
			String photo) {
		IWowoGoodsDao goodsDao = new WowoGoodsDaoImpl();
		return goodsDao.add(shop, type, tag, title, mark, wowoprice, price, photo);
	}

	@Override
	public Integer updateGoods(Map<String, String> map, String flag) {
		return null;
	}

	@Override
	public List<WowoGoods> findGoods(Map<String, String> map, String pageNo, String pageSize) {
		IWowoGoodsDao goodsDao = new WowoGoodsDaoImpl();
		return goodsDao.findGoods(map, pageNo, pageSize);
	}

	@Override
	public Integer delGoods(Map<String, String> map) {
		return null;
	}

	@Override
	public List<WowoGoods> findGoods(String op) {
		if(op == null){
			return null;
		}
		IWowoGoodsDao goodsDao = new WowoGoodsDaoImpl();
		return goodsDao.findGoods(op);
	}

	/**
	 * 商品的组合查询
	 * @param type：类型
	 * @param gname：商品名
	 * @param sname：店铺名
	 * @return
	 */
	public List<WowoGoods> comboSearch(String type, String gname, String sname){
		IWowoGoodsDao goodsDao = new WowoGoodsDaoImpl();
		return goodsDao.comboSearch(type, gname, sname);
	}

	@Override
	public Integer getTotal(String type) {
		IWowoGoodsDao goodsDao = new WowoGoodsDaoImpl();
		return goodsDao.getTotal(type);
	}
}
