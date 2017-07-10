package com.yc.wowo.servlets;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspFactory;
import javax.servlet.jsp.PageContext;

import com.yc.wowo.utils.UploadUtil;
import com.yc.wowo.biz.GoodsBiz;
import com.yc.wowo.biz.impl.GoodsBizImpl;


public class GoodsServlet extends BasicServlet{

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
		}else if("userFind".equals(op)){
			userFind(request, response);
		}else if(op.equals("getGoodsMessage")){
			getGoodsMessage(request,response);
		}
	}

	private void getGoodsMessage(HttpServletRequest request,HttpServletResponse response) {
		String gid=request.getParameter("gid");
		System.out.println(gid);
		GoodsBiz goodsBiz=new GoodsBizImpl();
		this.out(response, goodsBiz.find(Integer.parseInt(gid)));
		
	}
	

	private void userFind(HttpServletRequest request,HttpServletResponse response) {
		GoodsBiz goodsBiz = new GoodsBizImpl();
		this.out(response, goodsBiz.find());
	}

	/**
	 * 查询指定的字段
	 * @param request
	 * @param response
	 */
	private void showGoodsInIndex(HttpServletRequest request, HttpServletResponse response, String op) {
		GoodsBiz goodsBiz = new GoodsBizImpl();
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
		
		GoodsBiz goodsBiz = new GoodsBizImpl();
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
		GoodsBiz goodsBiz = new GoodsBizImpl();
		this.out(response,(int)goodsBiz.add(map.get("name") ,map.get("mark") ,map.get("price")  ,map.get("photo"),map.get("spit")));
	}
}
