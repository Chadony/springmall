package com.example.springmall.sample.vo;

public class Sample {
	private int sampleNo;
	private String sampleId;
	private String samplePw;
	
	
	// 생성자 ------
	public Sample() {
		super();
	}
	public Sample(int sampleNo, String sampleId, String samplePw) {
		super();
		this.sampleNo = sampleNo;
		this.sampleId = sampleId;
		this.samplePw = samplePw;
	}
	// 생성자 끝 -------------
	
	@Override
	public String toString() {
		return "Sample [sampleNo=" + sampleNo + ", sampleId=" + sampleId + ", samplePw=" + samplePw + "]";
	}
	public int getSampleNo() {
		return sampleNo;
	}
	public void setSampleNo(int sampleNo) {
		System.out.println("sampleNo");
		this.sampleNo = sampleNo;
	}
	public String getSampleId() {
		return sampleId;
	}
	public void setSampleId(String sampleId) {
		System.out.println("sampleId");
		this.sampleId = sampleId;
	}
	public String getSamplePw() {
		return samplePw;
	}
	public void setSamplePw(String samplePw) {
		System.out.println("samplePw");
		this.samplePw = samplePw;
	}
}
