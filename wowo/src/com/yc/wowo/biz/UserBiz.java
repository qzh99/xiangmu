package com.yc.wowo.biz;

import java.util.List;

import com.yc.wowo.entities.AdminInfo;
import com.yc.wowo.entities.UserInfo;

public interface UserBiz {
	
	public UserInfo login(String uname,String pwd);
	
	public List<UserInfo> find(Integer userid);
	
	/**
	 * 分页查询用户信息
	 * @param pageNo
	 * @param PageSize
	 * @return
	 */
	public List<UserInfo> find(Integer pageNo,Integer pageSize);
	
	/**
	 * 修改用户状态
	 * @param aid
	 * @param status
	 * @return
	 */
	public Integer update(Integer userid,Integer status);
	
	/**
	 * 删除用户 信息
	 * @param aid
	 * @return
	 */
	public Integer del(String userid);
	
	
	public Integer add(String uname,String pwd,String tel,String email,String prov,String city,String area);
	
	/**
	 * 查询总数
	 * @param userid
	 * @return
	 */
	public int getTotal(String userid);
}
