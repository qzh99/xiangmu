package com.yc.qas.mapper;

import java.util.List;

import com.yc.qas.entity.TreeNode;

public interface ClassesMapper {

	List<TreeNode> selcetAllClass();

	List<TreeNode> teacherSelcetClass(int teacherId);

	List<Integer> selectStuIdBySno(int studentSno);

}
