package com.yc.wowo.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yc.wowo.biz.ShoppingBiz;
import com.yc.wowo.biz.UserBiz;
import com.yc.wowo.biz.impl.ShoppingBizImpl;
import com.yc.wowo.biz.impl.UserBizImpl;
import com.yc.wowo.entities.Shopping;
import com.yc.wowo.entities.UserInfo;

/**
 * Servlet implementation class Shopping
 */
@WebServlet("/Shopping")
public class ShoppingServlet extends BasicServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op=request.getParameter("op");
		
		if("addShopping".equals(op)){	
			addShopping(request,response);
		}else if("findShoppingByPage".equals(op)){
			findShoppingByPage(request,response);
		}else if("updateShopping".equals(op)){
			updateShopping(request,response);
		}else if("deleteShopping".equals(op)){
			deleteShopping(request,response);
		}else if("findStoreInfo".equals(op)){
			findStoreInfo(request, response);
		}
	}


	private void findStoreInfo(HttpServletRequest request,
			HttpServletResponse response) {
		ShoppingBiz shoppingBiz=new ShoppingBizImpl();
		this.out(response, shoppingBiz.find(null, null));
	}


	private void deleteShopping(HttpServletRequest request,HttpServletResponse response) {
		String spid=request.getParameter("spid");
		
		ShoppingBiz shoppingBiz=new ShoppingBizImpl();
		int result=shoppingBiz.del(Integer.parseInt(spid));
		this.out(response, result);
	}


	private void updateShopping(HttpServletRequest request,HttpServletResponse response) {
		String sname=request.getParameter("sname");
		String spid=request.getParameter("spid");
		String prov=request.getParameter("prov");
		String city=request.getParameter("city");
		String area=request.getParameter("area");
		String tel=request.getParameter("tel");
		String points=request.getParameter("points");
		String info=request.getParameter("info");
		String date=request.getParameter("date");
		
		
		ShoppingBiz shoppingBiz=new ShoppingBizImpl();
		int result=shoppingBiz.update(sname, prov, city, area, points, tel, date, info, spid);
		this.out(response, result);
	}


	private void findShoppingByPage(HttpServletRequest request,HttpServletResponse response) {
		String pageNo=request.getParameter("page");
		String pageSize=request.getParameter("rows");
		
		ShoppingBiz shoppingBiz=new ShoppingBizImpl();
		List<Shopping> list=shoppingBiz.find(Integer.parseInt(pageNo), Integer.parseInt(pageSize));
		this.out(response,list,((ShoppingBiz) shoppingBiz).getTotal(null));
		
	}


	private void addShopping(HttpServletRequest request,HttpServletResponse response) {
		String sname=request.getParameter("sname");
		String prov=request.getParameter("prov");
		String city=request.getParameter("city");
		String area=request.getParameter("area");
		String points=request.getParameter("addr");
		String tel=request.getParameter("tel");
		String date=request.getParameter("date");
		String info=request.getParameter("editor");
		
		ShoppingBiz shoppingBiz=new ShoppingBizImpl();
		int result=0;
		result=shoppingBiz.add(sname, prov, city, area, points, tel, date, info);
		this.out(response, result);
	}

}
