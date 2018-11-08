package com.example.springmall.sample.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.springmall.sample.mapper.SampleMapper;
import com.example.springmall.sample.vo.Sample;

@Service
@Transactional
public class SampleService {
	@Autowired
	private SampleMapper sampleMapper;
	
	// 1. 샘플리스트
	public List<Sample> getSampleAll(HashMap<String, Object> map){
		// 페이징 코드
		int pagePerRow=10; // 10개씩
		int startRow = ((int)map.get("currentPage")-1)*pagePerRow; // 1page 0행 2페이지 10행
		int SampleAllList = sampleMapper.selectSampleAll();
		int lastPage = SampleAllList/pagePerRow;
		if(SampleAllList%pagePerRow != 0) {
			lastPage++;
		}
		map.put("startRow", startRow);
		map.put("pagePerRow", pagePerRow);
		map.put("lastPage", lastPage);
		
		return sampleMapper.selectSampleAllPage(map);
	}
	
	// 2. 삭제
	public int removeSample(int sampleNo) {
		System.out.println(sampleNo + "<-- Service removeSample");
		return sampleMapper.deleteSample(sampleNo);
	}
	
	// 3. 추가
	public int addSample(Sample sample) {
		System.out.println(sample + "<-- Service addSample");
		return sampleMapper.insertSample(sample);
	}
	
	// 4-1
	public Sample getSample(int sampleNo) {
		System.out.println(sampleNo + "<-- Service getSample");
		return sampleMapper.selectOne(sampleNo);
	}
	// 4-2
	public int modifySample(Sample sample) {
		System.out.println(sample + "<-- Service modifySample");
		return sampleMapper.updateSample(sample);
	}
}
