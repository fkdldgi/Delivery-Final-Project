<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>���ۼ�</h1>
<form method="post" action="/delivery/member/update">

	�ۼ���<br>
	<input type="text" name="writer" value="${vo.writer}" readonly="readonly" > 
	
	����<br>
	<input type="text" name="title">
	
	����<br>
	<textarea rows="5" cols="50" name="content"></textarea><br>
	
	<input type="submit" value="����">

</form>
</body>
</html>