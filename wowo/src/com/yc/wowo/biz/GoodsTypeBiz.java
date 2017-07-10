package com.yc.wowo.biz;

import java.util.List;

import com.yc.wowo.entities.GoodsType;

public interface GoodsTypeBiz {
	
	public Integer add(String tname,String des);
	
	public List<GoodsType> find(Integer tid);
	
	/**
	 * 分页查询商品类型信息
	 * @param pageNo
	 * @param PageSize
	 * @return
	 */
	public List<GoodsType> find(Integer pageNo,Integer pageSize);
	
	/**
	 * 修改商品类型状态
	 * @param aid
	 * @param status
	 * @return
	 */
	public Integer update(Integer tid,String tname,String des );
	
	/**
	 * 删除商品类型信息
	 * @param aid
	 * @return
	 */
	public Integer del(String tid);
	
	/**
	 * 查询总数
	 * @param userid
	 * @return
	 */
	public int getTotal(String userid);
}
