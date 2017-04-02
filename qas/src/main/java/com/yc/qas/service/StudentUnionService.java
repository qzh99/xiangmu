package com.yc.qas.service;

import com.yc.qas.entity.StudentUnion;

public interface StudentUnionService {
	StudentUnion login(StudentUnion studentUnion);

	boolean changePwd(String newPwd, int suId);
}
