package com.yc.wowo.biz.impl;

import java.util.List;

import com.yc.wowo.biz.UserBiz;
import com.yc.wowo.dao.UserDao;
import com.yc.wowo.dao.impl.UserDaoImpl;
import com.yc.wowo.entities.UserInfo;

public class UserBizImpl implements UserBiz {

	
	public List<UserInfo> find(Integer pageNo, Integer pageSize) {
		UserDao userDao = new UserDaoImpl();
		return userDao.find(pageNo, pageSize);
	}

	@Override
	public Integer update(Integer userid, Integer status) {
		UserDao userDao=new UserDaoImpl();
		return userDao.update(userid, status);
	}

	@Override
	public Integer del(String userid) {
		UserDao userDao = new UserDaoImpl();
		return userDao.del(userid);
	}

	public int getTotal(String userid) {
		UserDao userDao = new UserDaoImpl();
		return userDao.getTotal(userid);
	}

	@Override
	public List<UserInfo> find(Integer userid){
		UserDao userDao= new UserDaoImpl();
		return userDao.find( userid);
	}

	@Override
	public Integer add(String uname, String pwd, String tel, String email,
			String prov, String city, String district) {
		UserDao userDao= new UserDaoImpl();
		return userDao.add( uname,  pwd,  tel, email,prov,  city,  district);
	}

	@Override
	public UserInfo login(String uname, String pwd) {
		UserDao userDao= new UserDaoImpl();
		return userDao.login(uname, pwd);
	}

}
