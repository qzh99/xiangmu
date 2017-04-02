package com.yc.qas.service;

import java.util.List;

import com.yc.qas.entity.Student;
import com.yc.qas.entity.TreeNode;

public interface StudentService {
	
	Student login(Student student);
	
	boolean changePwd(String sPwd,int sNo);

	List<TreeNode> selcetSIdByClassId(int id);
}
