package com.example.springmall.sample.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.springmall.sample.service.SampleService;
import com.example.springmall.sample.vo.Sample;
import com.example.springmall.sample.vo.SampleRequest;

@Controller
public class SampleController {
	
	/*
	 * DATA(변수) + FUNCTION(함수(제어문,메서드,연산자))
	 */
	
	@Autowired
	private SampleService sampleService;
	// 1. 샘플리스트
	@RequestMapping(value="/sample/sampleList", method=RequestMethod.GET)
	public String sampleList(Model model, @RequestParam(value="currentPage", required=false, defaultValue="1") int currentPage) { // Model model = new Model();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("currentPage", currentPage);
		List<Sample> sampleList = sampleService.getSampleAll(map);
		model.addAttribute("sampleList", sampleList);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("lastPage", (int)map.get("lastPage"));
		return "/sample/sampleList";
	}
	// 2. 삭제
	@RequestMapping(value="/sample/removeSample", method=RequestMethod.GET)
	public String removeSample(@RequestParam(value="sampleNo") int sampleNo ) {
		System.out.println("removeSample  controller START ---------");
		if(sampleService.removeSample(sampleNo)==1) {
			System.out.println(sampleNo + "<-- 데이터 삭제 성공");
		}
		System.out.println("removeSample END -----------");
		return "redirect:/sample/sampleList";
	}
	
	// 3-1. 입력폼
	@RequestMapping(value="/sample/addSample", method=RequestMethod.GET)
	public String addSample(Model model) {
		System.out.println("입력폼");
		return "sample/addSample";
		// jquery, bootstrap, Sample command객체 매칭
	}
	// 3-2. 입력액션 
	@RequestMapping(value="/sample/addSample", method=RequestMethod.POST)
	public String addSample(SampleRequest sampleRequest, HttpSession session) { // 커맨드 객체 => Sample 빈 객체에 폼의 input name과 vo의 name이 같으면 SampleRequest객체에 값이 담긴다,,?
		// command객체의 멤버변수 == input태그 name속성 , 세트를불러오는데 표준 setter가 필요
		String realPath = session.getServletContext().getRealPath("/WEB-INF/uploads");
		System.out.println("sampleRequest"+sampleRequest.getMultipartFile());
		int row = sampleService.addSample(sampleRequest, realPath);
		if(row != 0) {
			System.out.println(sampleRequest + "<-- 데이터 입력 성공");
		}
		System.out.println(sampleRequest + "<-- 입력액션");
		return "redirect:/sample/sampleList";
	}
	
	// 4-1. 수정폼
	@RequestMapping(value="/sample/modifySample", method=RequestMethod.GET)
	public String modifySample(Model model, @RequestParam(value="sampleNo") int sampleNo) {
		Sample sample = sampleService.getSample(sampleNo);
		model.addAttribute("sample", sample);
		System.out.println(model + "<-- 수정폼");
		return "/sample/modifySample";
	}
	// 4-2. 수정액션
	@RequestMapping(value="/sample/modifySample", method=RequestMethod.POST)
	public String modifySample(Sample sample) {
		if(sampleService.modifySample(sample)==1) {
			System.out.println(sample + "<-- 데이터 수정 성공");
		}
		System.out.println(sample + "<-- 수정액션");
		return "redirect:/sample/sampleList";
	}
}
