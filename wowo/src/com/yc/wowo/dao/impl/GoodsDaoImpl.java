package com.yc.wowo.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.yc.wowo.dao.DBHelper;
import com.yc.wowo.dao.GoodsDao;
import com.yc.wowo.entities.Goods;

public class GoodsDaoImpl implements GoodsDao{

	@Override
	public Integer add( String name, String mark, String price,String photo,String spit) {
		DBHelper db = new DBHelper();
		List<Object> params = new ArrayList<Object>();
		String sql = "insert into goods  values(seq_goods_gid.nextval,?,?,?,?,0,?,'')";
		params.add(name);
		params.add(mark);
		params.add(price);
		params.add(photo);
		params.add(spit);
		System.out.println(name+""+mark+""+price+""+photo+""+spit);
		return db.doUpdate(sql, params);
	}

	@Override
	public Integer updateGoods(Map<String, String> map, String flag) {
		return null;
	}

	@Override
	public List<Goods> findGoods(Map<String, String> map, String pageNo, String pageSize) {
		DBHelper db = new DBHelper();
		List<Object> params = new ArrayList<Object>();
		String sql = "select i.*,j.sname,k.tname from goods i,shopping j,goodstype k where i.spid=j.spid and j.tid=k.tid";
		if(map != null && map.size() > 0){//说明要组合查询
			Set<String> keys = map.keySet();
			for(String key : keys){
				sql += " and "+key+"=?";
				params.add(map.get(key));
			}
		}
		if(pageNo != null && pageSize != null){//说明要分页查询
			sql = "select * from (select c.*,rownum rn from (select * from goods ) c where rownum <=?) where rn>?";
			int pageno = Integer.parseInt(pageNo);
			int pagesize = Integer.parseInt(pageSize);
			params.add(pageno*pagesize);
			params.add((pageno-1)*pagesize);
		}
		return db.find(sql, params, Goods.class);
	}

	@Override
	public Integer delGoods(Map<String, String> map) {
		return null;
	}

	@Override
	public List<Goods> findGoods(String op) {
		String sql = "";
		if("showGoodsInIndex".equals(op)){
			sql = "select i.title,i.mark,i.pic,i.wowoprice,i.price,i.tag,j.sname,j.area from goods i,shopstore j where i.shop=j.ssid";
		}
		DBHelper db = new DBHelper();
		return db.find(sql, null, Goods.class);
	}
	
	public List<Goods> find(){
		DBHelper db = new DBHelper();
		List<Object> params = new ArrayList<Object>();
		String sql = "select * from goods order by gid";
		return db.find(sql, params, Goods.class);
	}

	@Override
	public List<Goods> find(Integer gid) {
		DBHelper db = new DBHelper();
		List<Object> params = new ArrayList<Object>();
		String sql = "select * from goods where gid=?";
		params.add(gid);
		return db.find(sql, params, Goods.class);
	};
}
