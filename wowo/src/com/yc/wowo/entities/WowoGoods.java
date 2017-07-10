package com.yc.wowo.entities;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author Apple
 * 商品表
 */
public class WowoGoods implements Serializable{
	private static final long serialVersionUID = -5596345548207793979L;
	private Integer goodsid;//商品标号
	private Integer shop;//属于哪一个商店
	private Integer goodstype;//商品类型
	private String tag;//标签，是否免预约
	private String title;//标题，也算是商品名
	private String mark;//商品描述
	private BigDecimal wowoprice;//窝窝价
	private BigDecimal price;//原价
	private String pic;//商品展示的图片
	
	private String area;
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	private String sname;//店铺名字
	private String tname;//类型名
	public Integer getGoodsid() {
		return goodsid;
	}
	public void setGoodsid(Integer goodsid) {
		this.goodsid = goodsid;
	}
	public Integer getShop() {
		return shop;
	}
	public void setShop(Integer shop) {
		this.shop = shop;
	}
	public Integer getGoodstype() {
		return goodstype;
	}
	public void setGoodstype(Integer goodstype) {
		this.goodstype = goodstype;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
	public BigDecimal getWowoprice() {
		return wowoprice;
	}
	public void setWowoprice(BigDecimal wowoprice) {
		this.wowoprice = wowoprice;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((area == null) ? 0 : area.hashCode());
		result = prime * result + ((goodsid == null) ? 0 : goodsid.hashCode());
		result = prime * result + ((goodstype == null) ? 0 : goodstype.hashCode());
		result = prime * result + ((mark == null) ? 0 : mark.hashCode());
		result = prime * result + ((pic == null) ? 0 : pic.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((shop == null) ? 0 : shop.hashCode());
		result = prime * result + ((sname == null) ? 0 : sname.hashCode());
		result = prime * result + ((tag == null) ? 0 : tag.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((tname == null) ? 0 : tname.hashCode());
		result = prime * result + ((wowoprice == null) ? 0 : wowoprice.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WowoGoods other = (WowoGoods) obj;
		if (area == null) {
			if (other.area != null)
				return false;
		} else if (!area.equals(other.area))
			return false;
		if (goodsid == null) {
			if (other.goodsid != null)
				return false;
		} else if (!goodsid.equals(other.goodsid))
			return false;
		if (goodstype == null) {
			if (other.goodstype != null)
				return false;
		} else if (!goodstype.equals(other.goodstype))
			return false;
		if (mark == null) {
			if (other.mark != null)
				return false;
		} else if (!mark.equals(other.mark))
			return false;
		if (pic == null) {
			if (other.pic != null)
				return false;
		} else if (!pic.equals(other.pic))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (shop == null) {
			if (other.shop != null)
				return false;
		} else if (!shop.equals(other.shop))
			return false;
		if (sname == null) {
			if (other.sname != null)
				return false;
		} else if (!sname.equals(other.sname))
			return false;
		if (tag == null) {
			if (other.tag != null)
				return false;
		} else if (!tag.equals(other.tag))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (tname == null) {
			if (other.tname != null)
				return false;
		} else if (!tname.equals(other.tname))
			return false;
		if (wowoprice == null) {
			if (other.wowoprice != null)
				return false;
		} else if (!wowoprice.equals(other.wowoprice))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "WowoGoods [goodsid=" + goodsid + ", shop=" + shop + ", goodstype=" + goodstype + ", tag=" + tag
				+ ", title=" + title + ", mark=" + mark + ", wowoprice=" + wowoprice + ", price=" + price + ", pic="
				+ pic + ", sname=" + sname + ", tname=" + tname + ", area=" + area + "]";
	}
	public WowoGoods() {
		super();
	}
	public WowoGoods(Integer goodsid, Integer shop, Integer goodstype, String tag, String title, String mark,
			BigDecimal wowoprice, BigDecimal price, String pic, Integer status, String sname, String tname, String area) {
		super();
		this.goodsid = goodsid;
		this.shop = shop;
		this.goodstype = goodstype;
		this.tag = tag;
		this.title = title;
		this.mark = mark;
		this.wowoprice = wowoprice;
		this.price = price;
		this.pic = pic;
		this.sname = sname;
		this.tname = tname;
		this.area = area;
	}
	
}
