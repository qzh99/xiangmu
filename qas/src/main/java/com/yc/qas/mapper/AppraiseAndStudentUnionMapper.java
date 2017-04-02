package com.yc.qas.mapper;

import java.util.List;

import com.yc.qas.entity.Appraise;


public interface AppraiseAndStudentUnionMapper {

	int addMessagesForStudent(List<Appraise> list);

	int deleteMessagesForStudent(List<Appraise> appraiseList);

}
