package com.yc.qas.service;

import com.yc.qas.entity.EUDataGridList;
import com.yc.qas.entity.Timetable;

public interface ScoreService {

	int addScore(String scores, String tacherName);

	EUDataGridList<Timetable> studentSelectCourse(int sNo, int page, int rows);

	int studnetAddScore(int sNo, String timId);

}
