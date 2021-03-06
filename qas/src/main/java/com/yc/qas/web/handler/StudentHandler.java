package com.yc.qas.web.handler;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.qas.entity.EUDataGridList;
import com.yc.qas.entity.Student;
import com.yc.qas.entity.StudentFinalRank;
import com.yc.qas.entity.StudentSelectApprise;
import com.yc.qas.entity.StudentSelectScore;
import com.yc.qas.entity.TreeNode;
import com.yc.qas.service.StudentService;
import com.yc.qas.util.AttributeData;


@Controller
public class StudentHandler {

	@Autowired
	private StudentService studentService;
	
	@RequestMapping("/studentLogin")
	@ResponseBody
	public int login(int sNo,String sPwd, HttpSession session) {
			Student student = new Student(sNo,sPwd);
			student = studentService.login(student);
			
			int result=0;
			if (student != null) {
				result=2;
				session.setAttribute(AttributeData.CURRENTUSER, student);
			} else {
				result=1;
			}
			return result;
	}
	
	@RequestMapping("/studentChangePwd")
	@ResponseBody
	public int changePwd(String newPwd, HttpSession session) {
			Student student =(Student) session.getAttribute("currentuser");
			int sNo=student.getsNo();
			String pwd=student.getsPwd();
			
			int result=0;
			if(newPwd.equals(pwd)){
				result=2;
			}else{
				if(studentService.changePwd(newPwd, sNo)){
					result=1;
				}
			}
			return result;
	}
	
	@RequestMapping("/selcetSIdByClassId")
	@ResponseBody
	public List<TreeNode> selcetSIdByClassId(int id) {
			return studentService.selcetSIdByClassId(id);
	}
	
	
	@RequestMapping("/studentSelectAllAppraise")
	@ResponseBody
	public EUDataGridList<StudentSelectApprise> studentSelectAllAppraise(int studentSno,int page,int rows) {
			return (EUDataGridList<StudentSelectApprise>) studentService.studentSelectAllAppraise(studentSno,page,rows);
	}
	
	@RequestMapping("/studentSelectAllScore")
	@ResponseBody
	public EUDataGridList<StudentSelectScore> studentSelectAllScore(int studentSno,int page,int rows) {
			return (EUDataGridList<StudentSelectScore>) studentService.studentSelectAllScore(studentSno,page,rows);
	}
	
	@RequestMapping("/studentFinalRank")
	@ResponseBody
	public EUDataGridList<StudentFinalRank> studentFinalRank(int studentSno,int page,int rows) {
			return (EUDataGridList<StudentFinalRank>) studentService.studentFinalRank(studentSno,page,rows);
	}
}
