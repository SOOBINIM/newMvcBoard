package com.bitcamp.upload1.member.service;

import java.io.UnsupportedEncodingException;

import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.mail.internet.MimeUtility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.bitcamp.upload1.member.model.Member;



public class SimpleRegistrationNotifier2 {
	
	@Autowired
	// MailSender->JavaMailSender
	private JavaMailSender mailSender;

	// 오버 로딩
	public void sendMail(Member member) {
		
		// 보내는 정보를 MimeMessage 객체에 담는다.	
	
		MimeMessage message = mailSender.createMimeMessage();
		
		try {
			message.setSubject("회원가입 안내");
			String htmlMsg = "<strong>안녕하세요"+member.getMember_name()+" </strong>, 반갑습니다.";
			message.setText(htmlMsg, "utf-8","html");
			//보내는 메일 주소
			message.setFrom(new InternetAddress("bint92@naver.com"));
			//받는 메일 주소
			message.addRecipient(RecipientType.TO, new InternetAddress(member.getMember_id()));
			
			mailSender.send(message);
			
		}catch(MessagingException e) {
			e.printStackTrace();
		}
		
		
	}
		
		
	public void sendMailAttach(Member member) {
		MimeMessage message = mailSender.createMimeMessage();
		
		try {
			// 메일에 파일 첨부를 위해서 MimeMessageHelper 클래스 이용, 생성자 매개변수(메시지, 파일첨부여부, 인코딩처리)
			MimeMessageHelper helper = new MimeMessageHelper(message, true,"UTF-8");			
			helper.setSubject("회원가입");
			String htmlContext  = "<strong>안녕하세요.</strong>,반갑습니다.";
			helper.setText(htmlContext, true);
			// 보내는 사람 설정
			helper.setFrom("743492@gmail.com","수빈");
			// 받는 사람 설정
			helper.setTo(new InternetAddress(member.getMember_id(), member.getMember_name(), "UTF-8"));
			// 첨부 파일 설정
			DataSource dataSource = new FileDataSource("d:\\condam.png");// 파일객체 or 경로
			helper.addAttachment(MimeUtility.encodeText("건담.png","UTF-8","B"), dataSource);
			mailSender.send(message);
			
		}
		catch(MessagingException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	
	}



}
