package com.example.springmall.sample.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.example.springmall.sample.vo.SampleFile;

@Mapper
public interface SampleFileMapper {
	// 1. 입력
	int insertSampleFile(SampleFile sampleFile);
	// 2. 삭제
	int deleteSampleFile(int sampleNo);
	// 3. 선택
	SampleFile selectFileOne(int sampleNo);
}
