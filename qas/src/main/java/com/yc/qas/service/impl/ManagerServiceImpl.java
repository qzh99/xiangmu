package com.yc.qas.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.qas.entity.Manager;
import com.yc.qas.mapper.ManagerMapper;
import com.yc.qas.service.ManagerService;
import com.yc.qas.util.Encrypt;
@Service("managerService")
public class ManagerServiceImpl implements ManagerService {
	@Resource(name="managerMapper")
	private ManagerMapper managerMapper;

	@Override
	public Manager login(Manager manager) {
		manager.setmPwd(Encrypt.md5AndSha(manager.getmPwd()));
		return managerMapper.findManagerByManager(manager);
	}

}
