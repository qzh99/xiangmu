package com.yc.wowo.servlets;

import java.io.File;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.yc.wowo.utils.UploadUtil;

public class InitServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
 
	public void init() throws ServletException {
		String path="../path";
		if(this.getInitParameter("uploadPath")!=null){
			path=this.getInitParameter("uploadPath");
		}
		
		System.out.println(path);
		
		File file=new File(this.getServletContext().getRealPath(path));
		
		if(!file.exists()){
			file.mkdirs();
		}
		
		//修改uploadutil中的上传路径
		UploadUtil.PATH=path;
	}
	
//	public void init(ServletConfig config) throws ServletException{
//		super.init(config);
//		String path="../path";
//		if(config.getInitParameter("uploadPath")!=null){
//			path=config.getInitParameter("uploadPath");
//		}
//		
//		File file=new File(this.getServletContext().getRealPath(path));
//		
//		if(!file.exists()){
//			file.mkdirs();
//		}
//		
//		//修改uploadutil中的上传路径
//		UploadUtil.PATH=path;
//	}

}
