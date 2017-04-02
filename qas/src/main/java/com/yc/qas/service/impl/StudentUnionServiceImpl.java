package com.yc.qas.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.qas.entity.StudentUnion;
import com.yc.qas.mapper.StudentUnionMapper;
import com.yc.qas.service.StudentUnionService;
import com.yc.qas.util.Encrypt;

@Service("studentUnionLoginService")
public class StudentUnionServiceImpl implements StudentUnionService {
	
	@Autowired
	private StudentUnionMapper studentUnionMapper;
	
	@Override
	public StudentUnion login(StudentUnion studentUnion) {
		
		studentUnion.setSuPwd(Encrypt.md5AndSha(studentUnion.getSuPwd()));
		
		return studentUnionMapper.findStudentUnion(studentUnion);
	}

	@Override
	public boolean changePwd(String newPwd, int suId) {
		String pwd=Encrypt.md5AndSha(newPwd);
		return studentUnionMapper.changePwd(pwd,suId);
	}

}