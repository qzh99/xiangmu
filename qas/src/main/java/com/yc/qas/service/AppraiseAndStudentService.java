package com.yc.qas.service;

import com.yc.qas.entity.EUDataGridList;
import com.yc.qas.entity.StudentAppraise;

public interface AppraiseAndStudentService {


EUDataGridList<StudentAppraise> selectStudnetAppraiseBySno(int page, int rows,int sNo);

}
