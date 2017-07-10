package com.yc.wowo.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspFactory;
import javax.servlet.jsp.PageContext;

import com.yc.wowo.biz.IAdminInfoBiz;
import com.yc.wowo.biz.impl.AdminInfoBizImpl;
import com.yc.wowo.entities.AdminInfo;
import com.yc.wowo.utils.AttributeData;
import com.yc.wowo.utils.UploadUtil;
@SuppressWarnings("unused")

public class AdminInfoServlet extends BasicServlet{

	private static final long serialVersionUID = -1542722378160782915L;
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		String op=request.getParameter("op");
		
		if("adminLogin".equals(op)){	//管理员登录
			adminLogin(request,response);
		}else if("getLoginInfo".equals(op)){	//获取登录信息
			getLoginInfo(request,response);
		}else if("findAdminInfoByPage".equals(op)){	//分页查询管理员信息
			findAdminInfoByPage(request,response);
		}else if("addAdminInfo".equals(op)){	//添加管理员信息
			addAdminInfo(request,response);
		}else if("updateAdminInfo".equals(op)){	//修改管理员信息
			updateAdminInfo(request,response);
		}else if("searchAdminInfoByPage".equals(op)){	//修改管理员信息
			searchAdminInfoByPage(request,response);
		}else if("register".equals(op)){	//修改管理员信息
			register(request,response);
		}else if("deleteAdminInfo".equals(op)){	//修改管理员信息
			deleteAdminInfo(request,response);
		}
	}

	private void deleteAdminInfo(HttpServletRequest request,HttpServletResponse response) {
		String aid=request.getParameter("aid");
		if(aid==null){
			return;
		}
		int result=0;
		int temp=0;
		IAdminInfoBiz adminInfoBiz=new AdminInfoBizImpl();
		temp=adminInfoBiz.del(aid);
		if(temp>0){
			result=1;//删除成功
		}
		//result=2;删除失败
		this.out(response, result);
	}

	private void register(HttpServletRequest request,HttpServletResponse response) {
		String registerRoles=request.getParameter("registerRoles");
		String rname=request.getParameter("rname");
		String rpwd=request.getParameter("rpwd");
		String rpwds=request.getParameter("rpwds");
		String email=request.getParameter("email");
		String tel=request.getParameter("tel");
		String photo=null;
		
		HttpSession session=request.getSession();
		int result=0;
		if(registerRoles==null||"".equals(registerRoles)){
			result=1;//未选定角色
		}
		int temp=0;
		IAdminInfoBiz adminInfoBiz=new AdminInfoBizImpl();
		temp=adminInfoBiz.add(rname, rpwd, registerRoles, email, tel, photo);
		if(temp>0){
			result=2;//注册成功
		}else{
			result=3;//注册失败
		}
		
		this.out(response, result);
		//System.out.println(registerRoles+" "+rname+" "+rpwd+" "+rpwds+" "+email+" "+tel);
	}

	/**
	 * 多条件查询
	 * @param request
	 * @param response
	 */
	private void searchAdminInfoByPage(HttpServletRequest request,HttpServletResponse response) {
		String rid=request.getParameter("rid");
		String aname=request.getParameter("aname");
		String status=request.getParameter("status");
		String pageNo=request.getParameter("page");
		String pageSize=request.getParameter("rows");
		
		Map<String,String> parsms=new HashMap<String,String>();
		
		if(!"-1".equals(rid)){
			parsms.put("rid=",rid);
		}
		
		if(!"-1".equals(status)){
			parsms.put("status=",status);
		}
		
		if(aname!=null && !"".equals(aname)){
			parsms.put("aname like ","%"+aname+"%");
		}
		
		IAdminInfoBiz adminInfoBiz=new AdminInfoBizImpl();
		List<AdminInfo> list=adminInfoBiz.find(parsms, Integer.parseInt(pageNo), Integer.parseInt(pageSize));
		List<AdminInfo> list1=adminInfoBiz.find(parsms, null,null);
		this.out(response, list,list1.size());
		
	}

	/**
	 * 修改管理员信息
	 * @param request
	 * @param response
	 */
	private void updateAdminInfo(HttpServletRequest request,HttpServletResponse response) {
		UploadUtil upload=new UploadUtil();
		PageContext pagecontext=JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true, 2048, true);
		Map<String,String> map=upload.upload(pagecontext);
		//System.out.println(map);
		IAdminInfoBiz adminInfoBiz=new AdminInfoBizImpl();
		int result=(int)adminInfoBiz.update(map.get("aid"), map.get("email"));
		if(result>0){
			this.out(response,(int)adminInfoBiz.update(map.get("aname"), map.get("rid"), map.get("tel"), map.get("photo"), map.get("aid")));
		}else{
			this.out(response,result);
		}
		
	}

	/**
	 * 添加管理员信息
	 * @param request
	 * @param response
	 */
	private void addAdminInfo(HttpServletRequest request,HttpServletResponse response) {
		String rid=request.getParameter("rid");
		String aname=request.getParameter("aname");
		String pwd=request.getParameter("pwd");
		String email=request.getParameter("email");
		String tel=request.getParameter("tel");
		String photo=request.getParameter("photo");
		
		PageContext pagecontext=JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true, 2048, true);
		
		UploadUtil upload=new UploadUtil();
		//System.out.println(upload.upload(pagecontext, photo, null));
		IAdminInfoBiz adminInfoBiz=new AdminInfoBizImpl();
		this.out(response, (int)adminInfoBiz.add(aname, pwd, rid, email, tel, upload.upload(pagecontext, photo, null)));
		
	}

	/**
	 * 分页查询管理员信息
	 * @param request
	 * @param response
	 */
	private void findAdminInfoByPage(HttpServletRequest request,HttpServletResponse response) {
		String pageNo=request.getParameter("page");
		String pageSize=request.getParameter("rows");
		IAdminInfoBiz adminInfoBiz=new AdminInfoBizImpl();
		List<AdminInfo> list=adminInfoBiz.find(Integer.parseInt(pageNo), Integer.parseInt(pageSize));
		this.out(response,list,((AdminInfoBizImpl) adminInfoBiz).getTotal(null));
	}

	/**
	 * 获取当前登录用户信息
	 * @param request
	 * @param response
	 */
	
	
	private void getLoginInfo(HttpServletRequest request,HttpServletResponse response) {
		//System.out.println(1);
		HttpSession session=request.getSession();
		Object obj=session.getAttribute(AttributeData.CURRENTADMINLOGIN);
		if(obj==null){	//说明用户没有登录
			this.out(response, obj);
		}else{
			this.out(response,(AdminInfo)obj );
		}
		
	}
	

	/**
	 * 后台管理员登录
	 * @param request
	 * @param response
	 */
	private void adminLogin(HttpServletRequest request,HttpServletResponse response) {
		String role=request.getParameter("role");
		String name=request.getParameter("name");
		String pwd=request.getParameter("pwd");
		String code=request.getParameter("code");
		//System.out.println(role+" "+name+" "+pwd+" "+code);
		//在访问业务层之前，先可以检验验证码
		HttpSession session=request.getSession();
		String codes=(String)session.getAttribute("rand");
		int result=0;
		if(codes.equals(code)){	//如果用户输入的验证码是正确的，则调用业务层继续往后校验
			IAdminInfoBiz adminInfoBiz=new AdminInfoBizImpl();
			AdminInfo adminInfo=adminInfoBiz.login(name, pwd, role);
			if(adminInfo==null){	//说明用户或密码错误
				result=2;
			}else{
				result=3;//登录成功
				//将当前登录用户存起来，以便以后的页面中使用当前用户信息
				session.setAttribute(AttributeData.CURRENTADMINLOGIN, adminInfo);
			}
		}else{
			result=1;	//校验码错误
		}
		this.out(response, result);
	}
}
