package com.yc.qas.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yc.qas.entity.EUDataGridList;
import com.yc.qas.entity.Timetable;
import com.yc.qas.mapper.TimetableMapper;
import com.yc.qas.service.TimetableService;
@Service("timetableService")
public class TimetableServiceImpl implements TimetableService {
	@Resource(name="timetableMapper")
	private TimetableMapper timetableMapper;

	@Override
	public EUDataGridList<Timetable> selectAllTimetable(int page, int rows) {
		PageHelper.startPage(page, rows);
		List<Timetable> list=timetableMapper.selectAllTimetable();
		PageInfo<Timetable> pageinfo = new PageInfo<Timetable>(list);

		EUDataGridList<Timetable> data = new EUDataGridList<Timetable>();
		data.setTotal(Long.signum(pageinfo.getTotal()));
		data.setRows(list);
		return data;
	}

}
