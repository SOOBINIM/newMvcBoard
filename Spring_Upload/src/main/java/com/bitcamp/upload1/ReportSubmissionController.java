/*package com.bitcamp.upload1;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ReportSubmissionController {
	
	@RequestMapping(value ="/report/upload", method = RequestMethod.GET)
	public String form() {
		return "report/form";
	}
	
	@RequestMapping(value ="/report/submitReport1")
	public String submit1(
			@RequestParam("studentNumber") String studentNumber,
			@RequestParam("studentName") String studentName,
			@RequestParam("report")	MultipartFile report,
			Model model
			) throws IllegalStateException, IOException{
	
	printInfo("studentNumber", report);
	
	model.addAttribute("studentNumber", studentNumber);
	model.addAttribute("studentname", studentName);
	model.addAttribute("fileName",report.getOriginalFilename());
	model.addAttribute("fileSize",report.getSize());
	
	// 저장 경로 설정
	File file = new File("d:\\pds\\"+report.getOriginalFilename());
	
	// 파일 저장 처리
	report.transferTo(file);
	
	return "report/uploadOk";
	}	
	

	private void printInfo(String studentNumber, MultipartFile report) {
		System.out.println(studentNumber + "가 업로드 한 파일 : " + report.getOriginalFilename());
		
	}
}
*/