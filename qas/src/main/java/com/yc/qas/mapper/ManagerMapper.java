package com.yc.qas.mapper;

import com.yc.qas.entity.Manager;

public interface ManagerMapper {
	Manager findManagerByManager(Manager manager);

	boolean managerChangePwd(String pwd, int mId);
}
