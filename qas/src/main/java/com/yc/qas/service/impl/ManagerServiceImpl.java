package com.yc.qas.service.impl;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.qas.entity.Manager;
import com.yc.qas.mapper.ManagerMapper;
import com.yc.qas.mapper.StudentMapper;
import com.yc.qas.mapper.StudentUnionMapper;
import com.yc.qas.mapper.TeacherMapper;
import com.yc.qas.service.ManagerService;
import com.yc.qas.util.Encrypt;
@Service("managerService")
public class ManagerServiceImpl implements ManagerService {
	@Resource(name="managerMapper")
	private ManagerMapper managerMapper;
	
	@Resource(name="studentMapper")
	private StudentMapper studentMapper;
	@Resource(name="teacherMapper")
	private TeacherMapper teacherMapper;
	@Resource(name="studentUnionMapper")
	private StudentUnionMapper studentUnionMapper;

	@Override
	public Manager login(Manager manager) {
		manager.setmPwd(Encrypt.md5AndSha(manager.getmPwd()));
		return managerMapper.findManagerByManager(manager);
	}

	@Override
	public boolean managerChangePwd(String newPwd, int mId) {
		String pwd=Encrypt.md5AndSha(newPwd);
		System.out.println(pwd);
		System.out.println(mId);
		return managerMapper.managerChangePwd(pwd,mId);
	}

	@Override
	public int managerAddStudent(int sNo, String sName, int classesId) {
		return studentMapper.managerAddStudent(sNo,sName,classesId);
	}

	@Override
	public int managerAddStudent(String tname) {
		return teacherMapper.managerAddStudent(tname);
	}

	@Override
	public int managerAddStudentUnion(String suname) {
		return studentUnionMapper.managerAddStudentUnion(suname);
	}

}
