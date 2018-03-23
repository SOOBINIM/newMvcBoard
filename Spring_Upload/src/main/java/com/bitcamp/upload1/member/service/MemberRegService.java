package com.bitcamp.upload1.member.service;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;

import com.bitcamp.upload1.dao.MemberDao;
import com.bitcamp.upload1.member.model.Member;

public class MemberRegService {

	
	MemberDao dao;
	
	//@Autowired
	//private SimpleRegistrationNotifier notifier;
	
	@Autowired
	private SimpleRegistrationNotifier2 notifier2;

	// 프러퍼티 방식으로 의존 주입 . setter 메서드 이용
	public void setDao(MemberDao dao) {
		this.dao = dao;
	}
	public int memberReg(Member member, HttpServletRequest request) throws IllegalStateException, IOException {

		// 파일 업로드 처리

		/* 업로드 폴더 시스템 물리적 경로 찾기 */
		String uploadURI = "/uploadfile/memberphoto";
		String dir = request.getSession().getServletContext().getRealPath(uploadURI);
		System.out.println(dir);

		// 업로드 파일의 물리적 저장
		// 파일 저장 : 증명사진.jpg
		// 회원의 사진은 하나만 존재한다.
		// 파일 이름 생성 : 회원아이디_원본파일이름
		if (!member.getPhotofile().isEmpty()) {
			// 새로운 파일 이름 생성 -> 파일 저장 -> DB에 저장할 파일이름 set
			String fileName = member.getMember_id() + "_" + member.getPhotofile().getOriginalFilename();
			member.getPhotofile().transferTo(new File(dir, fileName));
			member.setPhoto(fileName);
		}

		// 업로드한 파일의 데이터를 Member에 등록

		// dao 요청 : 데이터 저장 요청
		int resultCnt = dao.insertMember(member);
		
		/*// 메일 보내기 설정		
		SimpleMailMessage message = new SimpleMailMessage();
		// 제목설정
		message.setSubject(member.getMember_name()+"님 회원 가입을 감사드립니다.");
		// 내용 설정
		message.setText(member.getMember_name()+"님 회원 가입을 감사드립니다.");
		// 가입 회원의 메일 주소
		message.setTo(member.getMember_id());
		// 보내는 메일 설정
		message.setFrom("743492@gmail.com");*/
		
		// 메일 발송
		notifier2.sendMailAttach(member);
		

		return resultCnt;
	}

}
