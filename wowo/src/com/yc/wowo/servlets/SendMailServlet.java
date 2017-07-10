package com.yc.wowo.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yc.wowo.dao.DBHelper;
import com.yc.wowo.entities.AdminInfo;
import com.yc.wowo.utils.MailConnect;

/**
 * Servlet implementation class SendMailServlet
 */
@WebServlet("/SendMailServlet")
public class SendMailServlet extends BasicServlet {
	private static final long serialVersionUID = 1L;
    private HttpSession session;
    String code=getCode();
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op=request.getParameter("op");
		
		if("rolesGetCode".equals(op)){	//管理员登录
			rolesGetCode(request,response);
		}else if("adminGetCode".equals(op)){	//获取登录信息
			adminGetCode(request,response);
		}else if("checkCode".equals(op)){	//获取登录信息
			checkCode(request,response);
		}else if("setPwd".equals(op)){	//获取登录信息
			setPwd(request,response);
		}
	}

	private void setPwd(HttpServletRequest request, HttpServletResponse response) {
		String pwd=request.getParameter("rpwds");
		String aid=request.getParameter("username");
		DBHelper db=new DBHelper();
		String sqls=null;
		List<Object> params=new ArrayList<Object>();
		sqls="update admininfo  set pwd=? where aid=?";
		params.add(pwd);
		params.add(aid);
		int result=0;
		result=db.doUpdate(sqls, params);
		this.out(response, result);
	}

	private void checkCode(HttpServletRequest request,HttpServletResponse response) {
		String rcode=request.getParameter("rcode");
		if(rcode.equals(code)){
			this.out(response, 1);
		}else{
			this.out(response, 0);//验证码错误
			return;
		}
		
	}

	private String getCode(){
		List<String> list=new ArrayList<String>();
		Collections.addAll(list,"1","2","3","4","5","6","7","8","9");
		for(int i=97;i<123;i++){
			list.add(String.valueOf( (char)i) );
		}
		Collections.shuffle(list);
		String code="";
		for(int i=0;i<6;i++){
			code+=list.get(i);
		}
		return code;
	}

	private void adminGetCode(HttpServletRequest request,HttpServletResponse response) {
		String username=request.getParameter("username");
		String email=request.getParameter("email");
		
		DBHelper db=new DBHelper();
		String sql=null;
		List<Object> params=new ArrayList<Object>();
		sql="select * from admininfo  where aid=? and email=? and status=2 ";
		params.add(username);
		params.add(email);
		db.findByOne(sql, params, AdminInfo.class);
		
		if(db.findByOne(sql, params, AdminInfo.class)==null){
				this.out(response, 0);//用户名和邮箱不匹配
		}else{
			boolean bl=MailConnect.sendQQmail("qzh1393950470@163.com", "qzh1393950470", email, code, username);
			if(bl){
				this.out(response, 1);//用户名和邮箱匹配
			}
		}
	}
	
	private void rolesGetCode(HttpServletRequest request,HttpServletResponse response) {
		String uname=request.getParameter("uname");
		String email=request.getParameter("email");
		String code=getCode();
		
		session=request.getSession();
		session.setAttribute("rolesCode", code);
		//1393950470@qq.com kptzrfbiibyzjibb
		boolean bl=MailConnect.sendQQmail("qzh1393950470@163.com", "qzh1393950470", email, code, uname);
		//1293580602@qq.com   mwdiuiqtdrfnbaeh
		//启动定时器开始计时
		starTimer(request);
		
		if(bl){
			this.out(response, 1);
		}else{
			this.out(response, 0);
		}
	}
	
	private void starTimer(final HttpServletRequest req){
		final Timer timer=new Timer();
		//timer.schedule(task, time);一段时间后开始执行方法一次
		//timer.scheduleAtFixedRate(task, delay, period);delay时间后开始执行task，以后每隔period执行一次task
		timer.schedule(new TimerTask(){
			public void run(){
				session.removeAttribute("sendCode");
				timer.cancel();
			}
		},60000);
	}
	

}
