package com.yc.qas.service;

import java.util.List;

import com.yc.qas.entity.TreeNode;

public interface ClassesService {
	/**
	 * 查询所有班级
	 * @return
	 */
	List<TreeNode> selcetAllClass();

	List<TreeNode> teacherSelcetClass(int teacherId);

}
