package com.yc.qas.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;



import org.springframework.stereotype.Service;

import com.yc.qas.entity.Appraise;
import com.yc.qas.mapper.AppraiseAndStudentUnionMapper;
import com.yc.qas.service.AppraiseAndStudentUnionService;
@Service("appraiseAndStudentUnionService")
public class AppraiseAndStudentUnionImpl implements AppraiseAndStudentUnionService {
	@Resource(name="appraiseAndStudentUnionMapper")
	private AppraiseAndStudentUnionMapper appraiseAndStudentUnionMapper;

	
	
	@Override
	public int addMessagesForStudent(int sNo, String author,String qids) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=sdf.format(new Date());
		
		String[] qids1 =qids.split(",");
		
		List<Appraise> appraiseList=new ArrayList<Appraise>();
		for(int i=0;i<qids1.length;i++){
			Appraise appraise=new Appraise(sNo,Integer.parseInt(qids1[i]),author,time);
			appraiseList.add(appraise);
		}
		return appraiseAndStudentUnionMapper.addMessagesForStudent( appraiseList);
	}



	@Override
	public int deleteMessagesForStudent(int sNo, String qids) {
		String[] qids1 =qids.split(",");
		List<Appraise> appraiseList=new ArrayList<Appraise>();
		for(int i=0;i<qids1.length;i++){
			Appraise appraise=new Appraise(sNo,Integer.parseInt(qids1[i]));
			appraiseList.add(appraise);
		}
		return appraiseAndStudentUnionMapper.deleteMessagesForStudent( appraiseList);
	}

}
