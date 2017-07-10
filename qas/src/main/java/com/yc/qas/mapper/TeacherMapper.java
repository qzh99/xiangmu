package com.yc.qas.mapper;

import com.yc.qas.entity.Teacher;

public interface TeacherMapper {

	Teacher findTeacherByTeacher(Teacher teacher);

	boolean teacherChangePwd(String pwd, int tId);

	int managerAddStudent(String tname);

}
