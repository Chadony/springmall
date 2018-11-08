package com.example.springmall.sample.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.springmall.sample.vo.Sample;

@Mapper
public interface SampleMapper { // 추상클래스(단일상속) ,인터페이스(다중상속)
	// 1. Select All
	List<Sample> selectSampleAllPage(HashMap<String, Object> map); // 추상메서드의 법칙 무조건 public 이라서 생략가능 (abstract 생략가능)
	int selectSampleAll();
	// 2. Delete
	int deleteSample(int sampleNo);
	// 3. Insert
	int insertSample(Sample sample);
	// 4. Update
	int updateSample(Sample sample);
	// 5. select one
	Sample selectOne(int sampleNo);
}
