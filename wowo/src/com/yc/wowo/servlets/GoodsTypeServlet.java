package com.yc.wowo.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yc.wowo.biz.GoodsTypeBiz;
import com.yc.wowo.biz.impl.GoodsTypeBizImpl;
import com.yc.wowo.entities.GoodsType;

/**
 * Servlet implementation class GoodsTypeServlet
 */
@WebServlet("/GoodsTypeServlet")
public class GoodsTypeServlet extends BasicServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op=request.getParameter("op");
		
		if("findGoodsTypeByPage".equals(op)){	
			findGoodsTypeByPage(request,response);
		}else if("addGoodsType".equals(op)){
			addGoodsType(request,response);
		}else if("deleteGoodsType".equals(op)){
			deleteGoodsType(request,response);
		}else if("updateGoodsType".equals(op)){
			updateGoodsType(request,response);
		}else if("findAllTypes".equals(op)){
			findAllTypes(request, response);
		}
	}

	private void findAllTypes(HttpServletRequest request,
			HttpServletResponse response) {
		GoodsTypeBiz GoodsTypeBiz=new GoodsTypeBizImpl();
		
		this.out(response, GoodsTypeBiz.find(null, null));
	}

	private void updateGoodsType(HttpServletRequest request,HttpServletResponse response) {
		String tname=request.getParameter("tname");
		String des=request.getParameter("des");
		String tid=request.getParameter("tid");
		
		GoodsTypeBiz GoodsTypeBiz=new GoodsTypeBizImpl();
		int result=GoodsTypeBiz.update(Integer.parseInt(tid), tname,des);
		this.out(response,result);
	}

	private void deleteGoodsType(HttpServletRequest request,HttpServletResponse response) {
		String tid=request.getParameter("tid");
		
		GoodsTypeBiz GoodsTypeBiz=new GoodsTypeBizImpl();
		int result=GoodsTypeBiz.del(tid);
		this.out(response,result);
	}

	private void addGoodsType(HttpServletRequest request,HttpServletResponse response) {
		String tname=request.getParameter("tname");
		String des=request.getParameter("des");
		
		GoodsTypeBiz GoodsTypeBiz=new GoodsTypeBizImpl();
		int result=GoodsTypeBiz.add(tname, des);
		this.out(response, result);

	}

	private void findGoodsTypeByPage(HttpServletRequest request,HttpServletResponse response) {
		String pageNo=request.getParameter("page");
		String pageSize=request.getParameter("rows");
		
		System.out.println(pageNo+"\t"+pageSize);
		
		GoodsTypeBiz GoodsTypeBiz=new GoodsTypeBizImpl();
		List<GoodsType> list=GoodsTypeBiz.find(Integer.parseInt(pageNo), Integer.parseInt(pageSize));
		this.out(response,list,GoodsTypeBiz.getTotal(null));
		
	}

}
