package com.yc.wowo.biz;

import java.util.List;
import java.util.Map;

import com.yc.wowo.entities.WowoGoods;

public interface IWowoGoodsBiz {
	/**
	 * 添加商品
	 * @param shop：属于哪个商店
	 * @param Goods：什么类型的商品
	 * @param tag：免预约
	 * @param title：商品名或者标题
	 * @param mark：商品说明
	 * @param wowoprice：窝窝价
	 * @param price：原价
	 * @param photo：商品有关的图片
	 * @return
	 */
	public Integer add(String shop, String type, String tag, String title, String mark, String wowoprice, String price, String photo);
	
	/**
	 * 更新商品信息
	 * @param map：要更新的字段和值
	 * @param flag：根据这个flag来修改
	 * @return
	 */
	public Integer updateGoods(Map<String,String> map, String flag);
	
	/**
	 * 查找
	 * @param map：查找的条件
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public List<WowoGoods> findGoods(Map<String,String> map, String pageNo, String pageSize);
	
	/**
	 * 删除
	 * @param map：根据什么删除
	 * @return
	 */
	public Integer delGoods(Map<String,String> map);
	
	/**
	 * 连接查询指定的字段
	 * @param op
	 * @return
	 */
	public List<WowoGoods> findGoods(String op);
	
	/**
	 * 组合查询
	 * @param type：类型
	 * @param gname：商品名
	 * @param sname：商店名
	 * @return
	 */
	public List<WowoGoods> comboSearch(String type, String gname, String sname);
	
	/**
	 * 获取所有
	 * @param type：类型编号，为空则表示所有类型
	 * @return
	 */
	public Integer getTotal(String type);
}
