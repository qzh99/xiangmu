package com.yc.qas.service.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yc.qas.entity.EUDataGridList;
import com.yc.qas.entity.Quantization;
import com.yc.qas.mapper.QuantizationMapper;
import com.yc.qas.service.QuantizationService;

@Service("quantizationService")
public class QuantizationServiceImpl implements QuantizationService {
	@Autowired
	private QuantizationMapper quantizationMapper;
	
	@Override
	public EUDataGridList<Quantization> selectLists(int page, int rows) {
		PageHelper.startPage(page, rows);//启用分页：注意：一定要放在查询语句之前（相邻）
		List<Quantization> list = quantizationMapper.selectLists();//查询的结果集
		PageInfo<Quantization> pageinfo= new PageInfo<Quantization>(list);//获取分页信息
		
		EUDataGridList<Quantization> data=new EUDataGridList<Quantization>();
		data.setTotal(pageinfo.getTotal());
		data.setRows(list);
		return data;
	}

	@Override
	public int updateQuantization(String list) {
		int result=0;
		ObjectMapper objectMapper = new ObjectMapper();  
	    JavaType javaType = objectMapper.getTypeFactory().constructParametricType(List.class, Quantization.class);  
		try {
			List<Quantization> lists = objectMapper.readValue(list, javaType);
			result=quantizationMapper.updateQuantization(lists);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int deleteQuantization(String lists) {
		String[] li=lists.split(",");
		int j=li.length;
		int[] list = new int[j];
		for(int i=0;i<j;i++){
			list [i]=Integer.parseInt(li[i]);
		}
		int result=quantizationMapper.deleteQuantization(list);
		return result;
	}

	@Override
	public int insertQuantization(String name, float score) {
		return quantizationMapper.insertQuantization( name,  score);
	}

	
}
