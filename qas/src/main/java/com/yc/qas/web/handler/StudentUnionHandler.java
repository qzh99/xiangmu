package com.yc.qas.web.handler;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.qas.entity.StudentUnion;
import com.yc.qas.service.StudentUnionService;
import com.yc.qas.util.AttributeData;

@Controller
public class StudentUnionHandler {
	@Autowired
	private StudentUnionService studentUnionService;
	
	@RequestMapping("/studentUnionLogin")
	@ResponseBody
	public int login(int suId,String suPwd, HttpSession session) {
		
		StudentUnion studentUnion=new StudentUnion(suId,suPwd);
		studentUnion=studentUnionService.login(studentUnion);
		
			int result=0;
			if (studentUnion != null) {
				result=2;
				session.setAttribute(AttributeData.CURRENTUSER, studentUnion);
			} else {
				result=1;
			}
			return result;
	}
	
	
	@RequestMapping("/studentUnionChangePwd")
	@ResponseBody
	public int ChangePwd(String newPwd, HttpSession session) {
		
		StudentUnion studentUnion=(StudentUnion) session.getAttribute("currentuser");
		int  suId=studentUnion.getSuId();
		String pwd=studentUnion.getSuPwd();
		
		int result=0;
		if(newPwd.equals(pwd)){
			result=2;
		}else{
			if(studentUnionService.changePwd(newPwd, suId)){
				result=1;
			}
		}
		return result;
	}
}
