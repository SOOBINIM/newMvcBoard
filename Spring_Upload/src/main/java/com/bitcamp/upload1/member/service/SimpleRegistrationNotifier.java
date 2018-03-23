package com.bitcamp.upload1.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

import com.bitcamp.upload1.member.model.Member;



public class SimpleRegistrationNotifier {
	
	@Autowired
	private MailSender mailsender;

	// 오버 로딩
	public void sendMail(Member member) {		
	
		// 보내는 정보를 SimpleMailMessage 객체에 담는다.

		SimpleMailMessage message = new SimpleMailMessage();
		message.setSubject("[회원 가입 안내] "+member.getMember_name()+ "님 회원가입을 축하합니다.");
		message.setFrom("743492@gmail.com");
		message.setText("회원가입이 완료 되었습니다.");
		message.setTo(member.getMember_id());
		/*
		 * // 메일 보내기 설정 SimpleMailMessage message = new SimpleMailMessage(); // 제목설정
		 * message.setSubject(member.getMember_name()+"님 회원 가입을 감사드립니다."); // 내용 설정
		 * message.setText(member.getMember_name()+"님 회원 가입을 감사드립니다."); // 가입 회원의 메일 주소
		 * message.setTo(member.getMember_id()); // 보내는 메일 설정
		 * message.setFrom("743492@gmail.com");
		 * 
		 * // 메일 발송 notifier.sendMail(member);		 */
		
		
		mailsender.send(message);
	}
		
		
	public void sendMail(String email) {
		
		SimpleMailMessage message = new SimpleMailMessage();
		message.setSubject("[회원 가입 안내]  회원가입을 축하합니다.");
		message.setFrom("743492@gmail.com");
		message.setText("회원가입이 완료 되었습니다.");
		message.setTo(email);
		
		mailsender.send(message);
		
	}


	public void sendMail(String email, String msg) {

		SimpleMailMessage message = new SimpleMailMessage();
		message.setSubject("[회원 가입 안내]  회원가입을 축하합니다.");
		message.setFrom("743492@gmail.com");
		message.setText(msg);
		message.setTo(email);
		
		mailsender.send(message);
		
	}
}
