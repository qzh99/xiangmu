package com.yc.qas.service;


import com.yc.qas.entity.EUDataGridList;
import com.yc.qas.entity.StudentScore;
import com.yc.qas.entity.Teacher;
public interface TeacherService {

	Teacher login(Teacher teacher);

	EUDataGridList<StudentScore> selcetStuByClassId(int page,int rows, int classesId ,int tId);

}
