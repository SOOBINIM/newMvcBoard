package com.bitcamp.upload1.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bitcamp.upload1.dao.MemberDao;
import com.bitcamp.upload1.member.model.Member;

public class MemberListService {

	@Autowired
	private MemberDao dao;
	
	public List<Member> getMemberList(){
		
		List<Member> list = dao.selectMembers();
	
		return list;
	}
	
}
