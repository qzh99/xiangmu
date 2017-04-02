package com.yc.qas.web.handler;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.qas.entity.EUDataGridList;
import com.yc.qas.entity.StudentAppraise;
import com.yc.qas.service.AppraiseAndStudentService;

@Controller
@RequestMapping("/appraiseAndStudent")
public class AppraiseAndStudentHandler {

	@Resource(name="appraiseAndStudentService")
	private AppraiseAndStudentService appraiseAndStudentService;
	
	@RequestMapping("/selectStudnetAppraiseBySno")
	@ResponseBody
	public EUDataGridList<StudentAppraise> selectStudnetAppraiseBySno(int page ,int rows,int sNo){
		return  appraiseAndStudentService.selectStudnetAppraiseBySno(page,rows,sNo);
	}
}
