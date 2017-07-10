package com.yc.wowo.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.yc.wowo.dao.DBHelper;
import com.yc.wowo.dao.UserDao;
import com.yc.wowo.entities.AdminInfo;
import com.yc.wowo.entities.UserInfo;

public class UserDaoImpl implements UserDao {

	@Override
	public List<UserInfo> find(Integer pageNo, Integer pageSize) {
		DBHelper db = new DBHelper();
		List<Object> params = new ArrayList<Object>();
		String sql = "";
		if(pageNo == null){
			sql = "select photo,userid,uname,status,tel from userinfo order by userid desc";
		}else{
			sql = "select * from (select a.*,rownum rn from (select photo,userid,uname,status,tel from userinfo order by userid desc) a where rownum<=?) where rn>?";
			params.add(pageNo*pageSize);
			params.add((pageNo-1)*pageSize);
		}
		return db.find(sql, params, UserInfo.class);
	}

	@Override
	public Integer update(Integer userid, Integer status) {
		DBHelper db=new DBHelper();
		List<Object> params=new ArrayList<Object>();
		String sql="update userinfo set status=? where userid=?";
		
		params.add(status);
		params.add(userid);
		return db.doUpdate(sql,params);
	}

	@Override
	public Integer del(String userid) {
		DBHelper db=new DBHelper();
		List<Object> params=new ArrayList<Object>();
		
		String sql="delete userinfo where userid=?";
		params.add(userid);
		return db.doUpdate(sql,params); 
	}

	@Override
	public int getTotal(String userid) {
		DBHelper db=new DBHelper();
		String sql=null;
		List<Object> params=new ArrayList<Object>();
		if(userid==null){
			sql="select count(userid) from userInfo";
		}else{
			sql="select count(userid) from userInfo where userid=?";
			params.add(userid);
		}
		return db.findByOne(sql, params); 
	}

	@Override
	public List<UserInfo> find(Integer userid) {
		DBHelper db=new DBHelper();
		String sql="select photo,userid,uname,status,tel from userinfo where status=1 order by userid asc";
		return db.find(sql,null,UserInfo.class);
	}

	@Override
	public Integer add(String uname, String pwd, String tel, String email,String prov, String city, String district) {
		DBHelper db=new DBHelper();
		List<Object> params=new ArrayList<Object>();
		
		String sqls="insert into userInfo values(seq_userInfo_uid.nextval,?,'',?,?,?,'',?,?,?,0,1)";
		params.add(uname);
		params.add(pwd);
		params.add(tel);
		params.add(email);
		params.add(prov);
		params.add(city);
		params.add(district);
		
		return db.doUpdate(sqls, params);
	}

	@Override
	public UserInfo login(String uname, String pwd) {
		DBHelper db = new DBHelper();
		String sql = "";
		if(uname.contains("@")){//说明是邮箱登陆
			sql = "select * from userinfo  where email=? and pwd=? and status=2 ";
		}else{
			sql = "select * from userinfo where userid=? and pwd=? and status=2 ";
		}
		List<Object> params = new ArrayList<Object>();
		params.add(uname);
		params.add(pwd);
		return db.findByOne(sql, params, UserInfo.class);
	}

}
