package com.yc.qas.mapper;

import java.util.List;

import com.yc.qas.entity.Score;
import com.yc.qas.entity.StudentScore;
import com.yc.qas.entity.Timetable;

public interface ScoreMapper {

	List<StudentScore> selcetStuByClassId(int classesId, int tId);

	int addScore(List<Score> lists);

	List<Timetable> studentSelectCourse(int sno);

	int studnetAddScore(List<Score> list);

}
