package com.example.springmall;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional // 매퍼가 겹치면 자동으로 모든 행동을 취소
public class MemberService {
	@Autowired // 자동으로 감기는 기능(비디오테잎처럼?)
	private MemberMapper memberMapper;
	public int getCountMember() {
		return memberMapper.SelectCountMember();
	}
}
