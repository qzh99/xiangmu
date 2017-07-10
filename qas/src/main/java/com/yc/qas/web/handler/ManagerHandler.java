package com.yc.qas.web.handler;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.qas.entity.Manager;
import com.yc.qas.service.ManagerService;
import com.yc.qas.util.AttributeData;

@Controller
public class ManagerHandler {
	@Resource(name="managerService")
	private ManagerService managerService;

	@RequestMapping("/managerLogin")
	@ResponseBody
	public int login(int mId,String mPwd, HttpSession session){
		Manager manager = new Manager(mId,mPwd);
		manager = managerService.login(manager);
		
		int result=0;
		if (manager != null) {
			result=2;
			session.setAttribute(AttributeData.CURRENTUSER, manager);
		} else {
			result=1;
		}
		return result;
	}
	
	@RequestMapping("/managerChangePwd")
	@ResponseBody
	public int managerChangePwd(String newPwd, HttpSession session){
		Manager manager = (Manager) session.getAttribute("currentuser");
		int mId=manager.getmId();
		System.out.println(newPwd);
		int result=0;
		if(managerService.managerChangePwd(newPwd, mId)){
			result=1;
		}
		return result;
	}
	
	@RequestMapping("/managerAddStudent")
	@ResponseBody
	public int managerAddStudent(int sNo,String sName,int classesId){
		return managerService.managerAddStudent(sNo,sName,classesId);
	}
	
	@RequestMapping("/managerAddTeacher")
	@ResponseBody
	public int managerAddTeacher(String tname){
		return managerService.managerAddStudent(tname);
	}
	
	@RequestMapping("/managerAddStudentUnion")
	@ResponseBody
	public int managerAddStudentUnion(String suname){
		return managerService.managerAddStudentUnion(suname);
	}
}
