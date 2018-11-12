package com.example.springmall.sample.service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.example.springmall.sample.mapper.SampleFileMapper;
import com.example.springmall.sample.mapper.SampleMapper;
import com.example.springmall.sample.vo.Sample;
import com.example.springmall.sample.vo.SampleFile;
import com.example.springmall.sample.vo.SampleRequest;

@Service
@Transactional
public class SampleService {
	@Autowired
	private SampleMapper sampleMapper;
	@Autowired
	private SampleFileMapper sampleFileMapper;
	
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
	public int addSample(SampleRequest sampleRequest) {
		System.out.println(sampleRequest + "<-- Service addSample");
		/*
		 * SampleRequest -> Sample 변환
		 * 1. multipartfile 파일데이터 -> 저장
		 * 2. multipartfile 정보 -> 새로운 정보 추가(이름....) ->SampleFIle
		 */
		Sample sample = new Sample();
		sample.setSampleId(sampleRequest.getSampleId());
		sample.setSamplePw(sampleRequest.getSamplePw());
		sampleMapper.insertSample(sample);
		
		SampleFile sampleFile = new SampleFile();
		MultipartFile multipartFile = sampleRequest.getMultipartFile();
		
		// 1. SampleFileNo : Autoincrement
		// 2. SampleNo
		sampleFile.setSampleNo(sample.getSampleNo()); // insertSample(sample)후에 PK값이 sample에 채워진다.
		// 3. SampleFilePath
		String path = "c:\\uploads"; // 복잡한 루틴을 통해서 
		sampleFile.setSampleFilePath(path);
		// 4. SampleFileExt
		String originalFileName = multipartFile.getOriginalFilename(); // 이름.확장자
		String ext = originalFileName.substring(0); // 확장자 짜르기
		sampleFile.setSampleFileExt(ext);
		// 5. SampleFileName
		String filename = UUID.randomUUID().toString(); // 랜덤 이름 만들기  
		sampleFile.setSampleFileName(filename);
		// 6. SampleFileType
		sampleFile.setSampleFileType(multipartFile.getContentType());
		// 7. SampleFileSize
		sampleFile.setSampleFileSize(multipartFile.getSize());
		//sampleFileMapper.insertSampleFile(sampleFile);
		// 내가 원하는 이름의 빈 파일을 만들자
		File file = new File(path+"\\"+filename+"."+ext);
		// multipartFile 파일을 빈 파일로 복사하자 ((에러가 발생할수도 있으니 try catch절로 묶기..)) ex.. 전송중에러 크기에러
		
		int insertSampleFiles = sampleFileMapper.insertSampleFile(sampleFile);
		if(insertSampleFiles == 1) {
			System.out.println(originalFileName + "<-- 데이터 입력 성공");
		}
		try {
			multipartFile.transferTo(file);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		
		// @Transactional
		return insertSampleFiles;
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
