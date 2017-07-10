package com.yc.qas.web.handler;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.qas.entity.EUDataGridList;
import com.yc.qas.entity.StudentScore;
import com.yc.qas.entity.Teacher;
import com.yc.qas.service.TeacherService;
import com.yc.qas.util.AttributeData;

@Controller
public class TeacherHandler {
	@Resource(name = "teacherService")
	private TeacherService teacherService;

	@RequestMapping("/teacherLogin")
	@ResponseBody
	public int login(int tId, String tPwd, HttpSession session) {
		Teacher teacher = new Teacher(tId, tPwd);
		teacher = teacherService.login(teacher);

		int result = 0;
		if (teacher != null) {
			session.setAttribute(AttributeData.CURRENTUSER, teacher);
			result = 2;
		} else {
			result = 1;
		}
		return result;
	}

	@RequestMapping("/selcetStuByClassId")
	@ResponseBody
	public EUDataGridList<StudentScore> selcetStuByClassId(int page ,int rows,@RequestParam(defaultValue="-1",value="classId")int classId,int teacherId) {
		if(classId==-1){
			EUDataGridList<StudentScore>  result=new EUDataGridList<StudentScore>();
			result.setTotal(0l);
			List<StudentScore> list = new ArrayList<StudentScore>();
			result.setRows(list);
			return result;
		}
		return  teacherService.selcetStuByClassId(page,rows,classId,teacherId);
	}
	
	@RequestMapping("/teacherChangePwd")
	@ResponseBody
	public int teacherChangePwd( String newPwd,HttpSession session) {
		Teacher teacher=(Teacher) session.getAttribute("currentuser");
		int  tId=teacher.gettId();
		
		int result=0;
			if(teacherService.teacherChangePwd(newPwd, tId)){
				result=1;
			}
		return result;
	}
}
