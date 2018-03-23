package com.bitcamp.upload1.member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bitcamp.upload1.member.model.Member;
import com.bitcamp.upload1.member.service.MemberListService;


@Controller
public class MemberListController {
	
	@Autowired
	// memberlistservice 컨테이너 설정 파일에 저장 하면 자동 으로 찾음
	private MemberListService service;
	
	
	@RequestMapping("/member/memberList")
	public String memberList(Model model) {
		
		List<Member> members = service.getMemberList();
		model.addAttribute("members", members);
		
		return "member/memberList";
	}
	
	
}