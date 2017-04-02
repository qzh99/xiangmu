package com.yc.qas.mapper;

import java.util.List;

import com.yc.qas.entity.Student;
import com.yc.qas.entity.TreeNode;

public interface StudentMapper {
	int insertStudent(Student student);

	int deleteStudentById(String sid);

	Student findStudentByStudent(Student student);

	boolean changePwd(String sPwd,int sNo);

	List<TreeNode> selcetSIdByClassId(int id);

}
