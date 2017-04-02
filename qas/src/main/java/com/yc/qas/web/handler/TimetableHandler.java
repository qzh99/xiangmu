package com.yc.qas.web.handler;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.qas.entity.EUDataGridList;
import com.yc.qas.entity.Timetable;
import com.yc.qas.service.TimetableService;

@Controller
public class TimetableHandler {
	@Resource(name="timetableService")
	private TimetableService timetableService;

	@RequestMapping("/selectAllTimetable")
	@ResponseBody
	public EUDataGridList<Timetable> selectAllTimetable(int page ,int rows){
		return timetableService.selectAllTimetable( page , rows);
	}
}
