package com.bitcamp.upload1.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.upload1.member.model.Member;
import com.bitcamp.upload1.member.service.MemberLoginService;
import com.bitcamp.upload1.member.service.SimpleRegistrationNotifier;

@Controller
@RequestMapping("member/login")
public class MemberLoginController {

	@Autowired
	private MemberLoginService memberLoginService;
	
	@Autowired
	private SimpleRegistrationNotifier notifier;
	
	
	@RequestMapping(method=RequestMethod.GET)
	public String loginForm() {
		return "member/loginForm";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String login(
			@RequestParam(value="member_id", defaultValue="0") String id,
			@RequestParam(value="password", required=false) String pw,
			HttpSession session
			) {
		System.out.println(id);
		System.out.println(pw);
		
		// 정살적으로 로그인 처리가 되면 리다이렉트 처리 : mvpage로 이동
		String view = "redirect:mypage"; // /member/mypage
		
		Member member = memberLoginService.loginCheck(id, pw);
		// null/ member 객체
		
		if(member == null) {
			return "member/loginFail";
		}
		
		
		member.setPassword("");
		
		// 세션에 데이터 저장
		session.setAttribute("loginInfo", member);
		System.out.println(session.getAttribute("loginInfo"));
		
		notifier.sendMail(member.getMember_id(),"로그인이 성공적으로 처리 되었습니다.");
		
		return view;
	}


}
