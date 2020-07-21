<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>myPage</title>
</head>
<script>

$(document).ready(function(){
	
	$("#file").change(function() {
		readURL(this);
	});
	
	$("#preview").change(function() {
		$("#file").click();
	});
});

function readURL(input) {
	if (input.files && input.files[0]) {
		var reader = new FileReader();
		reader.onload = function(e) {
			$('#preview').attr('src',e.target.result);
			
		}
		reader.readAsDataURL(input.files[0]);
	}
}
function pwdcheck() {
	var pwd=document.getElementById("pwd");
	var pwdchk=document.getElementById("pwdchk");
	if (pwd=== pwdchk) {
		alert("비밀번호가 일치합니다");
		$("#email").removeAttr("readonly");
		$("#tel").removeAttr("readonly");
		
	}else {
		alert("비밀번호가 불일치합니다");
		$("waring").removeAttr("hidden");
	}
}
</script>
<body>
<br>
<div class="container" style="border: 1.5px solid orange; margin-bottom: 50px">
<br>
 <img class="d-block mx-auto mb-4" src="/delivery/resources/images/mypage_logo1.png" width="700" height="150">
	<div class="form-group under_border" style="text-align: center;" >
		<br>
		<img src="/delivery/resources/images/mypage_logo.png" class="rounded-circle" id="preview" width="200" height="200">
		<br>
		<label>프로필사진 변경하기</label>
		<br>
		<input type="file" name="file1" accept="image/*" id="file">
	</div>
	<hr style="border: 1px solid orange;">
	<table class="table table-bordered">
    <tbody>
        <form action="mypage.jsp" method="post">
            <tr>
            	<th>아이디</th>
				<td><input type="text" value="${vo.getId}" id="title" class="form-control" readonly="readonly"/></td>
            </tr>
            <tr>
                <th>비밀번호 확인</th>
                   <td>	                
					<div class="input-group mb-3">
					  <input type="password" class="form-control" placeholder="비밀번호를 입력하세요" aria-label="Recipient's username" aria-describedby="button-addon2">
					  <div class="input-group-append">
					    <button class="btn btn-outline-secondary" type="button" id="pwdcheck" onclick="pwdcheck()">비밀번호 확인</button>
					  </div>
					</div>
					    <span> *개인정보 보호를 위해 비밀번호 확인이 필요합니다</span>
					</td>
            </tr>
            <tr>
                <th>비밀번호 변경: </th>
                <td><input type="password" placeholder="${vo.getPwd}" class="form-control-file" id="changedpwd" readonly="readonly"></td>
            </tr>
            <tr>
                <th>이메일: </th>
                <td><input type="email" placeholder="${vo.getEmail}" class="form-control-file" id="email" readonly="readonly"></td>
            </tr>
            <tr>
                <th>이름: </th>
                <td><input type="text" placeholder="${vo.getName}" class="form-control-file" id="name" readonly="readonly"></td>
            </tr>
            <tr> 
                <th>전화번호: </th>
                <td><input type="text" placeholder="${vo.getTel}" class="form-control-file" id="tel" readonly="readonly" ></td>
            </tr>
            <tr> 
                <th>가입일</th>
                <td><input type="text" placeholder="${vo.getRegdate}" class="form-control-file" id="tel" readonly="readonly" ></td>
            </tr>
        </form>
   	</tbody>
    </table>   
   	 <br> 
        <div style="margin-bottom: 50px; text-align:center; ">        
        <button type="submit" class="btn btn-primary">수정완료</button>
        <button type="button" class="btn btn-primary" onclick="location.href='/delivery/member/QnaList?memberNum=${sessionScope.memberNum}'">문의목록</button>
        <script type="text/javascript">
        console.log('${sessionScope.memberNum}');
        </script>
        </div>
        
</div>
</body>
</html>