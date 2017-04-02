package com.yc.qas.web.handler;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.qas.entity.EUDataGridList;
import com.yc.qas.entity.Teacher;
import com.yc.qas.entity.Timetable;
import com.yc.qas.service.ScoreService;

@Controller
public class ScoreHandler {
	@Resource(name="scoreService")
	private ScoreService scoreService;

	@RequestMapping("/teacherAddScore")
	@ResponseBody
	public int AddScore(String scores,HttpSession session){
		Teacher tacher=(Teacher) session.getAttribute("currentuser");
		String tacherName=tacher.gettName();
		return scoreService.addScore(scores,tacherName);
	}
	
	@RequestMapping("/studentSelectCourse")
	@ResponseBody
	public EUDataGridList<Timetable> studentSelectCourse(int sNo,int page,int rows){
		return scoreService.studentSelectCourse(sNo,page,rows);
	}
	
	
	@RequestMapping("/studnetAddScore")
	@ResponseBody
	public int studnetAddScore(int sNo,String timId){
		int temp= scoreService.studnetAddScore(sNo,timId);
		int result=0;
		if(temp>0){
			result=2;
		}else{
			result=1;
		}
		return result;
	}
}
