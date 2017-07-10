package com.yc.qas.mapper;

import java.util.List;

import com.yc.qas.entity.Student;
import com.yc.qas.entity.StudentFinalRank;
import com.yc.qas.entity.StudentSelectApprise;
import com.yc.qas.entity.StudentSelectScore;
import com.yc.qas.entity.TreeNode;

public interface StudentMapper {
	int insertStudent(Student student);

	int deleteStudentById(String sid);

	Student findStudentByStudent(Student student);

	boolean changePwd(String sPwd,int sNo);

	List<TreeNode> selcetSIdByClassId(int id);

	List<StudentSelectApprise> studentSelectAllAppraise(int studentSno);

	List<StudentSelectScore> studentSelectAllScore(int studentSno);

	List<StudentFinalRank> studentFinalRank(int studentSno);

	List<Student> managerSelectAllStudnet(int page, int rows);

	int managerAddStudent(int sNo, String sName, int classesId);

}
