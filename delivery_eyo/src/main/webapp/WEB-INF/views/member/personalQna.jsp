<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
<br>
<img class="d-block mx-auto mb-4" src="/delivery/resources/images/qna_logo.png" width="900" height="170">
    
<form action="${pageContext.request.contextPath }/member/personalQna" method="post">
	<table class="table table-bordered">
		<tbody>
	            <tr>
	            	<th>문의분류 </th>
	            	
				<td>
				<select name="category" class="form-control">
						<option>회원가입문의</option>
						<option>결제관련문의</option>
						<option>음식관련문의</option>
						<option>서비스불만문의</option>
						<option>회원가입문의</option>
						<option>기타문의</option>
				</select>
				</td>
	            </tr>
	            <input type="text" name ="memberNum" value="${sessionScope.memberNum }" hidden>
	            <input type="text" name ="name" value="${sessionScope.memberName }" hidden>
	            
	            <tr>
	                <th>제목: </th>
	                <td><input type="text" placeholder="제목을 입력하세요. " name="title" class="form-control"/></td>
	            </tr>
	            <tr>
	                <th>내용: </th>
	                <td><textarea cols="10" placeholder="내용을 입력하세요. " name="content" class="form-control"></textarea></td>
	            </tr>
	            <tr>
	                <th>첨부파일: </th>
	                <td><input type="file" placeholder="파일을 선택하세요." class="form-control-file" name="filename" ></td>
	            </tr>
	            <tr>
	                <th>비밀번호: </th>
	                <td><input type="password" placeholder="비밀번호를 입력하세요" class="form-control" name="pwd"/></td>
	            </tr>
	            <tr>	
	                <th>답변받으실 이메일 주소</th>
	                <td><input type="email" class="form-control" name="email" placeholder="name@example.com"></td>
	            </tr>
	            <tr>
	                <td colspan="2">
	                    <input type="submit" value="등록" class="pull-right"/>
	                    <input type="button" value="문의목록" onclick="location.href='${pageContext.request.contextPath }/member/QnaList?memberNum=${sessionScope.memberNum }'"  class="pull-right"/>
	                </td>
	            </tr>
		</tbody>
	</table>
</form>
    
</div>
</body>
</html>