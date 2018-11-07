package com.example.springmall.sample.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.springmall.sample.vo.Sample;

@Mapper
public interface SampleMapper {
	// 1. Select All
	List<Sample> selectSampleAllPage(HashMap<String, Object> map);
	int selectSampleAll();
	// 2. Delete
	int deleteSample(int sampleNo);
	// 3. Insert
	int insertSample(Sample sample);
	// 4. Update
	int updateSample(Sample sample);
}
