package com.yc.qas.service;

import com.yc.qas.entity.EUDataGridList;
import com.yc.qas.entity.Quantization;

public interface QuantizationService {

	EUDataGridList<Quantization> selectLists(int page, int rows);

	int updateQuantization(String list);

	int deleteQuantization(String list);

	int insertQuantization(String name, float score);

}
