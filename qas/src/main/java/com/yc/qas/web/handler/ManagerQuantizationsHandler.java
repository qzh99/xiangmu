package com.yc.qas.web.handler;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.qas.entity.EUDataGridList;
import com.yc.qas.entity.Quantization;
import com.yc.qas.service.QuantizationService;

@Controller
public class ManagerQuantizationsHandler {
	
	@Autowired
	private QuantizationService quantizationService;
	
	@RequestMapping("/selectLists")
	@ResponseBody
	public EUDataGridList<Quantization> selectLists( int page ,int rows){
		
		return quantizationService.selectLists(page,rows);
	}
	
	
	@RequestMapping("/updateQuantization")
	@ResponseBody
	public int updateQuantization(String list){
		 

		return quantizationService.updateQuantization( list);
	}
	
	@RequestMapping("/deleteQuantization")
	@ResponseBody
	public int deleteQuantization(String list){
		return quantizationService.deleteQuantization( list);
	}
	
	@RequestMapping("/insertQuantization")
	@ResponseBody
	public int insertQuantization(String name,float score){
		return quantizationService.insertQuantization( name, score);
	}
}
