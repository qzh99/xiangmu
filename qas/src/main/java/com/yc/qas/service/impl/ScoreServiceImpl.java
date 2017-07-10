package com.yc.qas.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yc.qas.entity.EUDataGridList;
import com.yc.qas.entity.Score;
import com.yc.qas.entity.StudentScore;
import com.yc.qas.entity.Timetable;
import com.yc.qas.mapper.ScoreMapper;
import com.yc.qas.service.ScoreService;

@Service("scoreService")
public class ScoreServiceImpl implements ScoreService {
	@Resource(name = "scoreMapper")
	private ScoreMapper scoreMapper;

	@Override
	public int addScore(String scores, String tacherName) {
		Gson gson = new Gson();
		List<StudentScore> studentScores = gson.fromJson(scores,new TypeToken<List<StudentScore>>() {}.getType());
		List<Score> list = new ArrayList<Score>();
		for (StudentScore studentScore : studentScores) {
			int sNo = studentScore.getsNo();
			int timId = studentScore.getTimId();
			float sGrade = studentScore.getsGrade();
			Score score = new Score(sNo, timId, sGrade, tacherName);
			list.add(score);
		}
		return scoreMapper.addScore(list);
	}

	@Override
	public EUDataGridList<Timetable> studentSelectCourse(int sNo, int page,
			int rows) {
		PageHelper.startPage(page, rows);
		List<Timetable> list = scoreMapper.studentSelectCourse(sNo);
		PageInfo<Timetable> pageinfo = new PageInfo<Timetable>(list);

		EUDataGridList<Timetable> data = new EUDataGridList<Timetable>();
		data.setTotal(pageinfo.getTotal());
		data.setRows(list);
		return data;
	}

	@Override
	public int studnetAddScore(int sNo, String timId) {
		String[] timIds = timId.split(",");
		List<Score> list = new ArrayList<Score>();
		for (int i = 0; i < timIds.length; i++) {
			Score score = new Score(sNo, Integer.parseInt(timIds[i]));
			list.add(score);
		}
		int temp = scoreMapper.studnetAddScore(list);
		if (temp < 0) {
			return 0;
		} else {
			return temp;
		}
	}

	@Override
	public int studnetDeleteScore(int sNo, String timId) {
		String[] timIds = timId.split(",");
		List<Score> list = new ArrayList<Score>();
		for (int i = 0; i < timIds.length; i++) {
			Score score = new Score(sNo, Integer.parseInt(timIds[i]));
			list.add(score);
		}
		return scoreMapper.studnetDeleteScore(list);
	}

}
