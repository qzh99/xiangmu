package com.yc.qas.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.qas.entity.TreeNode;
import com.yc.qas.mapper.ClassesMapper;
import com.yc.qas.service.ClassesService;

@Service("classesService")
public class ClassesServiceImpl implements ClassesService {

	@Resource(name = "classesMapper")
	private ClassesMapper classesMapper;

	@Override
	public List<TreeNode> selcetAllClass() {
		return classesMapper.selcetAllClass();
	}

	
	@Override
	public List<TreeNode> teacherSelcetClass(int teacherId) {
		return classesMapper.teacherSelcetClass(teacherId);
	}

}
