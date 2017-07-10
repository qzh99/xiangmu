package com.yc.wowo.servlets;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspFactory;
import javax.servlet.jsp.PageContext;

import com.yc.wowo.biz.IWowoGoodsBiz;
import com.yc.wowo.biz.impl.WowoGoodsBizImpl;
import com.yc.wowo.utils.UploadUtil;

public class WowoGoodsServlet extends BasicServlet{

	private static final long serialVersionUID = -519030391459818074L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");
		if("addGoods".equals(op)){
			addGoods(request, response);
		}else if("findGoods".equals(op)){
			findGoods(request, response);
		}else if("showGoodsInIndex".equals(op)){
			showGoodsInIndex(request, response, op);
		}else if("comboSearch".equals(op)){
			comboSearch(request, response);
		}
	}


	/**
	 * 带模糊查询的组合查询
	 * @param request
	 * @param response
	 */
	private void comboSearch(HttpServletRequest request, HttpServletResponse response) {
		String type = request.getParameter("type");
		String gname = request.getParameter("gname"); 
		String sname = request.getParameter("sname");
		
		IWowoGoodsBiz goodsBiz = new WowoGoodsBizImpl();
		this.out(response, goodsBiz.comboSearch(type, gname, sname));
	}

	/**
	 * 查询指定的字段
	 * @param request
	 * @param response
	 */
	private void showGoodsInIndex(HttpServletRequest request, HttpServletResponse response, String op) {
		IWowoGoodsBiz goodsBiz = new WowoGoodsBizImpl();
		this.out(response, goodsBiz.findGoods(op));
	}

	/**
	 * 查询商品
	 * @param request
	 * @param response
	 */
	private void findGoods(HttpServletRequest request, HttpServletResponse response) {
		String pageNo = request.getParameter("page");
		String pageSize = request.getParameter("row");
		
		IWowoGoodsBiz goodsBiz = new WowoGoodsBizImpl();
		//List<WowoGoods> list = goodsBiz.findGoods(null, pageNo, pageSize);
		this.out(response, goodsBiz.findGoods(null, pageNo, pageSize));
	}

	/**
	 * 添加商品
	 * @param request
	 * @param response
	 */
	private void addGoods(HttpServletRequest request, HttpServletResponse response) {
		PageContext pageContext = JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true, 2048, true);
		UploadUtil upload = new UploadUtil();
		Map<String,String> map = upload.upload(pageContext);
		//System.out.println(map);
		if(map.get("shop") == null || map.get("goodstype") == null){
			return;
		}
		if(map.get("photo") == null){
			map.put("photo","../wowoPic/zanwu.jpg");
		}
		IWowoGoodsBiz goodsBiz = new WowoGoodsBizImpl();
		this.out(response, (int)goodsBiz.add(map.get("shop"), map.get("goodstype"), map.get("tag"), map.get("title"), map.get("mark"), map.get("wowoprice"), map.get("price"), map.get("photo")));
	}
}
