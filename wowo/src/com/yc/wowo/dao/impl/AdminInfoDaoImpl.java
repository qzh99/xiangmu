package com.yc.wowo.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.yc.wowo.dao.DBHelper;
import com.yc.wowo.dao.IAdminInfoDao;
import com.yc.wowo.entities.AdminInfo;

public class AdminInfoDaoImpl implements IAdminInfoDao{

	

	@Override
	public AdminInfo login(String name, String pwd, String rid) {
		//在dao里面不做为空判断，应该是，在dao里面只负责处理，判断什么的  都放在业务层去做
		DBHelper db = new DBHelper();
		String sql = "";
		if(name.contains("@")){//说明是邮箱登陆
			sql = "select * from admininfos where email=? and pwd=? and status=2 and rid = ?";
		}else{
			sql = "select * from admininfos where aid=? and pwd=? and status=2 and rid = ?";
		}
		List<Object> params = new ArrayList<Object>();
		params.add(name);
		params.add(pwd);
		params.add(rid);
		return db.findByOne(sql, params, AdminInfo.class);
	}

	@Override
	public AdminInfo find(Integer aid) {
		DBHelper db = new DBHelper();
		List<Object> params = new ArrayList<Object>();
		params.add(aid);
		String sql = "select * from admininfos where aid=?";
		return db.findByOne(sql, params, AdminInfo.class);
	}

	@Override
	public List<AdminInfo> find(Integer pageNo, Integer pageSize) {
		DBHelper db = new DBHelper();
		List<Object> params = new ArrayList<Object>();
		String sql = "";
		if(pageNo == null){
			sql = "select * from admininfos order by aid desc";
		}else{
			sql = "select * from (select a.*,rownum rn from (select * from admininfos order by aid desc) a where rownum<=?) where rn>?";
			params.add(pageNo*pageSize);
			params.add((pageNo-1)*pageSize);
		}
		return db.find(sql, params, AdminInfo.class);
	}

	@Override
	public List<AdminInfo> find(Integer rid, Integer pageNo, Integer pageSize) {
		DBHelper db = new DBHelper();
		List<Object> params = new ArrayList<Object>();
		String sql = "";
		if(rid == null && pageNo == null){
			sql = "select * from admininfos order by aid desc";
		}else if(rid != null && pageNo == null){
			sql = "select * from admininfos where rid=? order by aid desc";
			params.add(rid);
		}else if(rid != null && pageNo != null){
			sql = "select * from (select a.*,rownum rn from (select * from admininfos where rid=? order by aid desc) a where rownum<=?) where rn>?";
			params.add(rid);
			params.add(pageNo*pageSize);
			params.add((pageNo-1)*pageSize);
		}else if(rid == null && pageNo != null){
			sql = "select * from (select a.*,rownum rn from (select * from admininfos order by aid desc) a where rownum<=?) where rn>?";
			params.add(pageNo*pageSize);
			params.add((pageNo-1)*pageSize);
		}
		return db.find(sql, params, AdminInfo.class);
	}

	@Override
	public Integer update(String aid, String status, String mark) {
		DBHelper db = new DBHelper();
		List<Object> params = new ArrayList<Object>();
		String sql = "";
		if(aid.contains(",") && !aid.contains(" or")){
			sql = "update admininfo set status=?,mark=? where aid in("+aid+")";
			params.add(status);
			params.add(mark);
		}else{
			sql = "update admininfo set status=?,mark=? where aid=?";
			params.add(status);
			params.add(mark);
			params.add(aid);
		}
		return db.doUpdate(sql, params);
	}

	@Override
	public Integer update(Integer aid, String photo) {
		DBHelper db = new DBHelper();
		List<Object> params = new ArrayList<Object>();
		String sql = "update admininfo set photo=? where aid=?";
		params.add(photo);
		params.add(aid);
		return db.doUpdate(sql,params);
	}

	@Override
	public Integer update(Integer aid, String oldPwd, String newPwd) {
		DBHelper db = new DBHelper();
		List<Object> params = new ArrayList<Object>();
		String sql = "update admininfo set pwd=? where aid=? and pwd=?";
		params.add(newPwd);
		params.add(aid);
		params.add(oldPwd);
		return db.doUpdate(sql,params);
	}

	@Override
	public Integer update(String aid) {
		DBHelper db = new DBHelper();
		List<Object> params = new ArrayList<Object>();
		String sql = "";
		if(aid.contains(",") && !aid.contains(" or")){
			sql = "update admininfo set pwd='aaaaaa' where aid in("+aid+")";
		}else{
			sql = "update admininfo set pwd='aaaaaa' where aid=?";
			params.add(aid);
		}
		return db.doUpdate(sql, params);
	}

	@Override
	public Integer update(String aname, String rid, String tel, String photo, String aid) {
		DBHelper db = new DBHelper();
		List<Object> params = new ArrayList<Object>();
		String sql = "update admininfo set aid=aid";
		if(aname!= null){
			sql+=",aname=?";
			params.add(aname);
		}
		if(rid!= null){
			sql+=",rid=?";
			params.add(rid);
		}
		if(tel!= null){
			sql+=",tel=?";
			params.add(tel);
		}
		if(photo!= null){
			sql+=",photo=?";
			params.add(photo);
		}
		sql+=" where aid=?";
		params.add(aid);
		return db.doUpdate(sql, params);
	}

	@Override
	public Integer update(String aid, String email) {
		DBHelper db = new DBHelper();
		List<Object> params = new ArrayList<Object>();
		String sql = "update admininfo set email=? where aid=?";
		params.add(email);
		params.add(aid);
		return db.doUpdate(sql, params);
	}

	@Override
	public Integer add(String aname, String pwd, String rid, String email, String tel, String photo) {
		DBHelper db = new DBHelper();
		List<Object> params = new ArrayList<Object>();
		String sql = "insert into admininfo values (seq_admininfo_aid.nextval,?,?,?,?,?,?,0,'')";
		params.add(aname);
		params.add(pwd);
		params.add(rid);
		params.add(email);
		params.add(tel);
		params.add(photo);
		return db.doUpdate(sql, params);
	}

	@Override
	public Integer del(String aid) {
		DBHelper db = new DBHelper();
		List<Object> params = new ArrayList<Object>();
		String sql = "";
		if(aid.contains(",") && !aid.contains(" or")){
			sql = "delete admininfo where aid in("+aid+")";
		}else{
			sql = "delete admininfo  where aid=?";
			params.add(aid);
		}
		return db.doUpdate(sql, params);
	}

	@Override
	public int getTotal(Integer rid) {
		DBHelper db=new DBHelper();
		String sql=null;
		List<Object> params=new ArrayList<Object>();
		if(rid==null){
			sql="select count(aid) from adminInfo";
		}else{
			sql="select count(aid) from adminInfo where rid=?";
			params.add(rid);
		}
		return db.findByOne(sql, params); 
	}

	@Override
	public List<AdminInfo> find(Map<String, String> parsms, Integer pageNo,
			Integer pageSize) {
		DBHelper db=new DBHelper(); 
		List<Object> params=new ArrayList<Object>();
		String sql="select * from adminInfos"; 
		if(parsms!=null && parsms.size()>0){
			sql+=" where 1=1 "; 
			Set<String> keys=parsms.keySet(); 
			for(String key:keys){
				sql+=" and "+key+"?"; 	//and rid=?
				params.add(parsms.get(key)); 
			}
		}
		sql+=" order by aid desc"; 
		if(pageNo!=null){
			sql="select * from (select a.*,rownum rn from ("+sql+") a where rownum<=?)where rn>?"; 
			params.add(pageNo*pageSize);
			params.add((pageNo-1)*pageSize); 
		}
		return db.find(sql, params,AdminInfo.class); 
	}

	
	
}
