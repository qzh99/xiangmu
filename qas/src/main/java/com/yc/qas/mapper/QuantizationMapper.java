package com.yc.qas.mapper;

import java.util.List;

import com.yc.qas.entity.Quantization;

public interface QuantizationMapper {

	List<Quantization> selectLists();

	int updateQuantization(List<Quantization> lists);

	int deleteQuantization(int [] list);

	int insertQuantization(String name, float score);

}
