package com.yc.qas.service;

import com.yc.qas.entity.Manager;

public interface ManagerService {

	Manager login(Manager manager);

	boolean managerChangePwd(String newPwd, int mId);

	int managerAddStudent(int sNo, String sName, int classesId);

	int managerAddStudent(String tname);

	int managerAddStudentUnion(String suname);


}
