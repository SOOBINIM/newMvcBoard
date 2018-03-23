<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>리포트 업데이트 페이지</title>
<style>
</style>
</head>
<body>

<h3>@RequestParam 이용</h3>

	<form action="submitReport1" method ="post" enctype="multipart/form-data">
		학번 <input type="text"name="studentNumber"><br>
		이름 <input type="text"name="studentName"><br>
		리포트 파일 <input type="file"name="report"><br>
		<input type="submit">
	</form>
	
<h3>MultipartHttpServletRequest 사용</h3>

	<form action="submintReport2" method="post" enctype="multipart/form-data">
		학번 <input type="text"name="studentNumber"><br>
		이름 <input type="text"name="studentName"><br>
		리포트 파일 <input type="file"name="report"><br>
		<input type="submit">
	</form>

<h3>커멘드 객체 사용</h3>

	<form action="submintReport3" method="post" enctype="multipart/form-data">
		학번 <input type="text"name="studentNumber"><br>
		이름 <input type="text"name="studentName"><br>
		리포트 파일 <input type="file"name="report"><br>
		<input type="submit">
	</form>

</body>
</html>