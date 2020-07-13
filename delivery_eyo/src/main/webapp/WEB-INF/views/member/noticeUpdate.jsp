<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>글작성</h1>
<form method="post" action="/delivery/member/update">

	작성자<br>
	<input type="text" name="writer" value="${vo.writer}" readonly="readonly" > 
	
	제목<br>
	<input type="text" name="title">
	
	내용<br>
	<textarea rows="5" cols="50" name="content"></textarea><br>
	
	<input type="submit" value="수정">

</form>
</body>
</html>