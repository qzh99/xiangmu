package com.yc.qas.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yc.qas.entity.EUDataGridList;
import com.yc.qas.entity.StudentAppraise;
import com.yc.qas.mapper.AppraiseAndStudentMapper;
import com.yc.qas.service.AppraiseAndStudentService;
@Service("appraiseAndStudentService")
public class AppraiseAndStudentServiceImpl implements AppraiseAndStudentService {

	@Resource(name="appraiseAndStudentMapper")
	private AppraiseAndStudentMapper appraiseAndStudentMapper;
	
	@Override
	public EUDataGridList<StudentAppraise> selectStudnetAppraiseBySno(int page, int rows, int sNo) {
		PageHelper.startPage(page, rows);
		List<StudentAppraise> list=appraiseAndStudentMapper.selectStudnetAppraiseBySno(sNo);
		PageInfo<StudentAppraise> pageinfo= new PageInfo<StudentAppraise>(list);
		
		EUDataGridList<StudentAppraise> data=new EUDataGridList<StudentAppraise>();
		data.setTotal(pageinfo.getTotal());
		data.setRows(list);
		return data;
	}
}
