package com.yc.qas.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yc.qas.entity.EUDataGridList;
import com.yc.qas.entity.StudentScore;
import com.yc.qas.entity.Teacher;
import com.yc.qas.mapper.ScoreMapper;
import com.yc.qas.mapper.TeacherMapper;
import com.yc.qas.service.TeacherService;
import com.yc.qas.util.Encrypt;
@Service("teacherService")
public class TeacherServiceImpl implements TeacherService {

	@Resource(name="teacherMapper")
	private TeacherMapper teacherMapper;
	
	@Resource(name="scoreMapper")
	private ScoreMapper scoreMapper;

	@Override
	public Teacher login(Teacher teacher) {
		teacher.settPwd(Encrypt.md5AndSha(teacher.gettPwd()));
		return teacherMapper.findTeacherByTeacher(teacher);
	}

	@Override
	public EUDataGridList<StudentScore> selcetStuByClassId(int page, int rows,int classesId,int tId) {
		PageHelper.startPage(page, rows);
		List<StudentScore> list=scoreMapper.selcetStuByClassId(classesId,tId);
		PageInfo<StudentScore> pageinfo= new PageInfo<StudentScore>(list);
		
		EUDataGridList<StudentScore> data=new EUDataGridList<StudentScore>();
		data.setTotal(Long.signum(pageinfo.getTotal()));
		data.setRows(list);
		return data;
	}

}
