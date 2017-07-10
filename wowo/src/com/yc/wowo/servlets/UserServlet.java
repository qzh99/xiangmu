package com.yc.wowo.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yc.wowo.biz.UserBiz;
import com.yc.wowo.biz.impl.UserBizImpl;
import com.yc.wowo.entities.AdminInfo;
import com.yc.wowo.entities.UserInfo;
import com.yc.wowo.utils.AttributeData;

@WebServlet("/UserServlet")
public class UserServlet extends BasicServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op=request.getParameter("op");
		
		if("findUserByPage".equals(op)){	
			findUserByPage(request,response);
		}else if("updateUser".equals(op)){
			updateUser(request,response);
		}else if("deleteUser".equals(op)){
			deleteUser(request,response);
		}else if("userRegister".equals(op)){
			userRegister(request,response);
		}else if("userLogin".equals(op)){
			userLogin(request,response);
		}else if("getLoginInfo".equals(op)){
			getLoginInfo(request,response);
		}
	}

	private void getLoginInfo(HttpServletRequest request,HttpServletResponse response) {
		HttpSession session=request.getSession();
		Object obj=session.getAttribute(AttributeData.CURRENTUSERLOGIN);
		if(obj==null){	//说明用户没有登录
			this.out(response, obj);
		}else{
			this.out(response,(UserInfo)obj );
		}
		
	}

	private void userLogin(HttpServletRequest request,HttpServletResponse response) {
		String uname=request.getParameter("uname");
		String pwd=request.getParameter("pwd");
		String code=request.getParameter("code");
		
		HttpSession session=request.getSession();
		String codes=(String)session.getAttribute("rand");
		int result=0;
		
		if(codes.equals(code)){	//如果用户输入的验证码是正确的，则调用业务层继续往后校验
			UserBiz userBiz=new UserBizImpl();
			UserInfo userInfo=userBiz.login(uname, pwd);
			if(userInfo==null){	//说明用户或密码错误
				result=2;
			}else{
				result=3;//登录成功
				//将当前登录用户存起来，以便以后的页面中使用当前用户信息
				session.setAttribute(AttributeData.CURRENTUSERLOGIN, userInfo);
			}
		}else{
			result=1;	//校验码错误
		}
		this.out(response, result);
		
		
	}

	private void userRegister(HttpServletRequest request,HttpServletResponse response) {
		String email=request.getParameter("email");
		String uname=request.getParameter("uname");
		String pwd=request.getParameter("pwd");
		String code=request.getParameter("code");
		String tel=request.getParameter("tel");
		String prov=request.getParameter("prov");
		String city=request.getParameter("city");
		String district=request.getParameter("district");
		
		HttpSession session=request.getSession();
		String codes=(String)session.getAttribute("rand");
		int result=0;
		if(codes.equals(code)){	//如果用户输入的验证码是正确的，则调用业务层继续往后校验
			UserBiz userBiz=new UserBizImpl();
			result=userBiz.add(uname, pwd, tel, email, prov, city, district);
		}else{
			return ;
		}
		this.out(response, result);
		
	}

	private void deleteUser(HttpServletRequest request,HttpServletResponse response) {
		String userid=request.getParameter("userid");
		UserBiz userBiz=new UserBizImpl();
		int result=userBiz.del(userid);
		this.out(response, result);
	}

	private void updateUser(HttpServletRequest request,HttpServletResponse response) {
		String status=request.getParameter("statusStr");
		String userid=request.getParameter("userid");
		
		UserBiz userBiz=new UserBizImpl();
		int result=userBiz.update(Integer.parseInt(userid), Integer.parseInt(status));
		this.out(response, result);
	}

	private void findUserByPage(HttpServletRequest request,HttpServletResponse response) {
		String pageNo=request.getParameter("page");
		String pageSize=request.getParameter("rows");
		
		UserBiz userBiz=new UserBizImpl();
		List<UserInfo> list=userBiz.find(Integer.parseInt(pageNo), Integer.parseInt(pageSize));
		this.out(response,list,userBiz.getTotal(null));
	}

}
