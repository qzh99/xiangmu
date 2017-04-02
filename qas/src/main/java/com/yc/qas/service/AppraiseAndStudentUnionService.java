package com.yc.qas.service;

public interface AppraiseAndStudentUnionService {

	int addMessagesForStudent(int sNo, String author, String qids);

	int deleteMessagesForStudent(int sNo, String qids);

}
