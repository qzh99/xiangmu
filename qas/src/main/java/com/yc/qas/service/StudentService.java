package com.yc.qas.service;

import java.util.List;

import com.yc.qas.entity.EUDataGridList;
import com.yc.qas.entity.Student;
import com.yc.qas.entity.StudentFinalRank;
import com.yc.qas.entity.StudentSelectApprise;
import com.yc.qas.entity.StudentSelectScore;
import com.yc.qas.entity.TreeNode;

public interface StudentService {
	
	Student login(Student student);
	
	boolean changePwd(String sPwd,int sNo);

	List<TreeNode> selcetSIdByClassId(int id);

	EUDataGridList<StudentSelectApprise> studentSelectAllAppraise(int studentSno, int page, int rows);

	EUDataGridList<StudentSelectScore> studentSelectAllScore(int studentSno,
			int page, int rows);

	EUDataGridList<StudentFinalRank> studentFinalRank(int studentSno, int page,
			int rows);
}
