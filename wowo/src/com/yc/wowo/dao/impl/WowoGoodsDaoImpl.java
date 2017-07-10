package com.yc.wowo.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.yc.wowo.dao.DBHelper;
import com.yc.wowo.dao.IWowoGoodsDao;
import com.yc.wowo.entities.AdminInfo;
import com.yc.wowo.entities.WowoGoods;

public class WowoGoodsDaoImpl implements IWowoGoodsDao{

	@Override
	public Integer add(String shop, String type, String tag, String title, String mark, String wowoprice, String price, String photo) {
		if(shop == null || type == null || title == null || wowoprice == null || price == null){
			return 0;
		}
		DBHelper db = new DBHelper();
		List<Object> params = new ArrayList<Object>();
		String sql = "insert into wowogoods(goodsid,shop,goodstype,tag,title,mark,wowoprice,price,pic) values(seq_wowogoods_goodsid.nextval,?,?,?,?,?,?,?,?)";
		params.add(shop);
		params.add(type);
		params.add(tag);
		params.add(title);
		params.add(mark);
		params.add(wowoprice);
		params.add(price);
		params.add(photo);
		return db.doUpdate(sql, params);
	}

	@Override
	public Integer updateGoods(Map<String, String> map, String flag) {
		return null;
	}

	@Override
	public List<WowoGoods> findGoods(Map<String, String> map, String pageNo, String pageSize) {
		DBHelper db = new DBHelper();
		List<Object> params = new ArrayList<Object>();
		String sql = "select i.*,j.sname,k.tname from wowogoods i,shopping j,goodstype k where i.shop=j.spid and i.goodstype=k.tid";
		if(map != null && map.size() > 0){//说明要组合查询
			Set<String> keys = map.keySet();
			for(String key : keys){
				sql += " and "+key+"=?";
				params.add(map.get(key));
			}
		}
		if(pageNo != null && pageSize != null){//说明要分页查询
			sql = "select * from (select c.*,rownum rn from ("+sql+") c where rownum <=?) where rn>?";
			int pageno = Integer.parseInt(pageNo);
			int pagesize = Integer.parseInt(pageSize);
			params.add(pageno*pagesize);
			params.add((pageno-1)*pagesize);
		}
		return db.find(sql, params, WowoGoods.class);
	}

	@Override
	public Integer delGoods(Map<String, String> map) {
		return null;
	}

	@Override
	public List<WowoGoods> findGoods(String op) {
		String sql = "";
		if("showGoodsInIndex".equals(op)){
			sql = "select i.title,i.mark,i.pic,i.wowoprice,i.price,i.tag,j.area from wowogoods i,shopstore j where i.shop=j.ssid";
		}
		DBHelper db = new DBHelper();
		return db.find(sql, null, WowoGoods.class);
	}

	@Override
	public List<WowoGoods> comboSearch(String type, String gname, String sname) {
		String sql = "select i.*,j.sname,k.tname from wowogoods i,shopstore j,goodstype k where i.shop=j.ssid and i.goodstype=k.tid";
		List<Object> params = new ArrayList<Object>();
		if(type != null && !"".equals(type)){
			sql += " and goodstype=?";
			params.add(type);
		}
		if(gname != null && !"".equals(gname)){
			sql += " and title like '%"+gname+"%'";
		}
		if(sname != null && !"".equals(sname)){
			sql += " and sname like '%"+sname+"%'";
		}
		DBHelper db = new DBHelper();
		//System.out.println(sql);return null;
		return db.find(sql, params, WowoGoods.class);
	}

	@Override
	public Integer getTotal(String type) {
		String sql = "select count(goodsid) from ";
		return null;
	}

}
