package com.yc.qas.mapper;

import com.yc.qas.entity.StudentUnion;

public interface StudentUnionMapper {
	 StudentUnion findStudentUnion(StudentUnion studentUnion) ;

	boolean changePwd(String newPwd, int suId);
}
