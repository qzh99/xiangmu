package com.yc.qas.web.handler;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.qas.entity.EUDataGridList;
import com.yc.qas.entity.Timetable;
import com.yc.qas.service.ScoreService;

@Controller
public class ScoreHandler {
	@Resource(name="scoreService")
	private ScoreService scoreService;

	@RequestMapping("/teacherAddScore")
	@ResponseBody
	public int AddScore(String scores,String tacherName){
		return scoreService.addScore(scores,tacherName);
	}
	
	@RequestMapping("/studentSelectCourse")
	@ResponseBody
	public EUDataGridList<Timetable> studentSelectCourse(int sNo,int page,int rows){
		return scoreService.studentSelectCourse(sNo,page,rows);
	}
	
	
	@RequestMapping("/studnetAddScore")
	@ResponseBody
	public int studnetAddScore(int sNo, String timId){
		int temp= scoreService.studnetAddScore(sNo,timId);
		int result=0;
		if(temp>0){
			result=2;
		}else{
			result=1;
		}
		return result;
	}
	
	
	@RequestMapping("/studnetDeleteScore")
	@ResponseBody
	public int studnetDeleteScore(int sNo,String timId){
		int temp= scoreService.studnetDeleteScore(sNo,timId);
		int result=0;
		if(temp>0){
			result=2;
		}else{
			result=1;
		}
		return result;
	}
}
