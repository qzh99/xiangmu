package com.yc.qas.web.handler;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.qas.service.AppraiseAndStudentUnionService;


@Controller
public class AppraiseHandler {
	@Resource(name="appraiseAndStudentUnionService")
	private AppraiseAndStudentUnionService appraiseAndStudentUnionService;

	@RequestMapping("/addMessagesForStudent")
	@ResponseBody
	public int addMessagesForStudent(int sNo,String author ,String  qids){
		int temp=appraiseAndStudentUnionService.addMessagesForStudent( sNo , author, qids);
		int result=0;
		if(temp>0){
			result=2;
		}else{
			result=1;
		}
		return  result;
	}
	
	@RequestMapping("/studentUnionDeleteMessages")
	@ResponseBody
	public int deleteMessagesForStudent(int sNo,String  qids){
		int temp=appraiseAndStudentUnionService.deleteMessagesForStudent( sNo , qids);
		int result=0;
		if(temp>0){
			result=2;//删除成功
		}else{
			result=1;
		}
		return  result;
	}
}
