package com.yc.qas.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.qas.entity.Student;
import com.yc.qas.entity.TreeNode;
import com.yc.qas.mapper.StudentMapper;
import com.yc.qas.service.StudentService;
import com.yc.qas.util.Encrypt;
@Service("studentLoginService")
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentMapper studentMapper;
	
	@Override
	public Student login(Student student) {
		student.setsPwd(Encrypt.md5AndSha(student.getsPwd()));
		return studentMapper.findStudentByStudent(student);
	}

	@Override
	public boolean changePwd(String sPwd, int sNo) {
		String newPwd=Encrypt.md5AndSha(sPwd);
		return studentMapper.changePwd(newPwd, sNo);
	}

	@Override
	public List<TreeNode> selcetSIdByClassId(int id) {
		return studentMapper.selcetSIdByClassId(id);
	}

}
