package com.bitcamp.upload1.member.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.bitcamp.upload1.dao.MemberDao;
import com.bitcamp.upload1.member.model.Member;

public class MemberLoginService {
	
	@Autowired
	MemberDao dao;
		
	public Member loginCheck(String id, String pw) {
		// Member 객체를 dao 통해서 받는다.
		Member member = dao.selectById(id);
		System.out.println("svc: " +member);
		
		// 비밀번호 체크
		if(member != null && !member.matchPassword(pw)) {
			member = null;
		}
		
		
		
		return member;
		
	}
	
	public Member selectById(String id) {
		return dao.selectById(id);
	}
}
