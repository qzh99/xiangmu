package com.yc.qas.service;

import com.yc.qas.entity.EUDataGridList;
import com.yc.qas.entity.Timetable;

public interface TimetableService {

	EUDataGridList<Timetable> selectAllTimetable(int page, int rows);

}
