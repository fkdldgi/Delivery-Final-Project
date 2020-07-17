<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container" style="text-">
		<br>
		<h1>1대1 문의하기</h1>
		<br>
		<div class="input-group mb-3">
			<select class="form-control">
				<option>회원가입문의</option>
				<option>결제관련문의</option>
				<option>음식관련문의</option>
				<option>서비스불만문의</option>
				<option>회원가입문의</option>
				<option>기타문의</option>
			</select>
		</div>
			<hr style="border: solid 1px orange;">
		<form class="form-group">
			<div class="mb-3">
				<br>
				<input class="form-control" type="text" id="title" placeholder="제목을 작성해주세요" style="float: left">
				<br>
				<br>
				<hr style="border: solid 1px orange;">
				<label for="validationTextarea">문의내용</label>
				<textarea class="form-control" id="validationTextarea"
					placeholder="문의하실 내용을 적어주세요" required></textarea>
				<hr style="border: solid 1px orange;">
				<div class="form-group">
					<label for="exampleFormControlFile1">문의사항 관련 첨부파일</label> <input
						type="file" class="form-control-file" id="exampleFormControlFile1">
				</div>
			</div>
		</form>
				<div class="form-group">
					<label for="exampleFormControlInput1">답변받으실 이메일 주소</label> 
					<input type="email" class="form-control" id="exampleFormControlInput1" placeholder="name@example.com">
				</div>
			<hr style="border: solid 1px orange;">
		</div>
</body>
</html>