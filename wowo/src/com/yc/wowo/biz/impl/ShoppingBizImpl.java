package com.yc.wowo.biz.impl;

import java.util.List;

import com.yc.wowo.biz.ShoppingBiz;
import com.yc.wowo.dao.ShoppingDao;
import com.yc.wowo.dao.impl.ShoppingDaoImpl;
import com.yc.wowo.entities.Shopping;

public class ShoppingBizImpl implements ShoppingBiz {

	@Override
	public Integer add(String sname, String prov, String city, String area,
			String points, String tel, String date, String info) {
		ShoppingDao shoppingDao=new ShoppingDaoImpl();
		return shoppingDao.add(sname, prov, city, area, points, tel, date, info);
	}

	@Override
	public List<Shopping> find(Integer pageNo, Integer pageSize) {
		ShoppingDao shoppingDao=new ShoppingDaoImpl();
		return shoppingDao.find(pageNo, pageSize);
	}

	@Override
	public int getTotal(Object object) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(String sname, String prov, String city, String area,String points, String tel, String date, String info,String spid) {
		ShoppingDao shoppingDao=new ShoppingDaoImpl();
		return shoppingDao.update(sname, prov, city, area, points, tel, date, info, spid);
	}

	@Override
	public Integer del(Integer spid) {
		ShoppingDao shoppingDao=new ShoppingDaoImpl();
		return shoppingDao.del(spid);
	}

}
