package com.yc.qas.mapper;

import java.util.List;

import com.yc.qas.entity.StudentAppraise;

public interface AppraiseAndStudentMapper {


	List<StudentAppraise> selectStudnetAppraiseBySno(int sNo);

}
