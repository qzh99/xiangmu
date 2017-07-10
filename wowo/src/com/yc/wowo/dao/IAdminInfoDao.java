package com.yc.wowo.dao;

import java.util.List;
import java.util.Map;

import com.yc.wowo.entities.AdminInfo;

public interface IAdminInfoDao {
	/**
	 * 
	 * @param name
	 * @param pwd
	 * @return
	 */
	public AdminInfo login(String name,String pwd,String rid);
	
	/**
	 * 
	 * @param aid
	 * @return
	 */
	public AdminInfo find(Integer aid);
	/**
	 * 分页查询管理员信息
	 * @param pageNo
	 * @param PageSize
	 * @return
	 */
	public List<AdminInfo> find(Integer pageNo,Integer PageSize);
	/**
	 * 根据角色分页查询管理员信息
	 * @param rid
	 * @param pageNo
	 * @param PageSize
	 * @return
	 */
	public List<AdminInfo> find(Integer rid,Integer pageNo,Integer PageSize);
	/**
	 * 修改管理员 图像
	 * @param aid
	 * @param status
	 * @param mark
	 * @return
	 */
	public Integer update(String aid,String status,String mark);
	/**
	 * 
	 * @param aid
	 * @param photo
	 * @return
	 */
	public Integer update(Integer aid,String photo);
	/**
	 * 
	 * @param aid
	 * @param oldPwd
	 * @param newPwd
	 * @return
	 */
	public Integer update(Integer aid,String oldPwd,String newPwd);
	/**
	 * 
	 * @param aid
	 * @return
	 */
	public Integer update(String aid);
	/**
	 * 
	 * @param aname
	 * @param rid
	 * @param tel
	 * @param photo
	 * @return
	 */
	public Integer update(String aname,String rid,String tel,String photo,String aid);
	/**
	 * 
	 * @param aid
	 * @param email
	 * @return
	 */
	public Integer update(String aid,String email);
	/**
	 * 
	 * @param aname
	 * @param pwd
	 * @param rid
	 * @param email
	 * @param tel
	 * @param photo
	 * @return
	 */
	public Integer add(String aname,String pwd,String rid,String email,String tel,String photo);
	/**
	 * 
	 * @param aid
	 * @return
	 */
	public Integer del(String aid);
	
	/**
	 * 获取总记录数
	 * @param rid
	 * @return
	 */
	public int getTotal(Integer rid);
	
	public List<AdminInfo> find(Map<String,String> parsms,Integer pageNo,Integer pageSize);
}
