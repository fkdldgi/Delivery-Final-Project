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
	$(document).ready(function() {
		var num = $("input[name=num]").val();
		$("#drop").on('click',function(){
			location.href="/delivery/rider/drop?num="+num;
		});
	});

	function pwdcheck() {
		var inputpwd = document.getElementById("inputpwd").value;
		var orgpwd = document.getElementById("orgpwd").value;
		
		if (inputpwd === orgpwd) {
			alert("비밀번호가 일치합니다");
			$("input[name=email]").removeAttr("readonly");
			$("input[name=phone]").removeAttr("readonly");
			$("input[name=changedpwd]").removeAttr("readonly");
			$("input[name=pwd]").removeAttr("readonly");
			$("input[name=name]").removeAttr("readonly");
			$("span[id=before]").removeAttr("hidden");
			$("span[id=after]").attr("hidden");
			$("input[name=status]").attr("disabled",false);
		} else {
			alert("비밀번호가 불일치합니다");
		}
	}
</script>
<body>
	<br>
	<div class="container "
		style="border: 1.5px solid darkgray; margin-bottom: 50px">
		<br> <img class="d-block mx-auto mb-4"
			src="/delivery/resources/images/mypage_logo1.png" width="700"
			height="150">
		<hr style="border: 1px solid darkgray;">
		<form action="/delivery/rider/mypageOk" method="post" enctype="multipart/form-data">
			<table class="table table-bordered">
				<tbody>
					<tr>
						<th>아이디</th>
						<td><input type="text" value="${vo.id}" id="title" name="id"
							class="form-control" readonly="readonly" /></td>
					</tr>
					<tr>
						<th>비밀번호 확인</th>
						<td>
							<div class="input-group mb-3">
								<!-- 원래 비밀번호 가져옴 orgpwd -->
								<input type="text" id=orgpwd value="${vo.pwd}" hidden="hidden">
								<input type="password" class="form-control" id="inputpwd"
									placeholder="비밀번호를 입력하세요" aria-label="Recipient's username"
									aria-describedby="button-addon2">
								<div class="input-group-append">
									<input type="button" class="btn btn-outline-secondary"
										onclick="pwdcheck()" value="비밀번호 확인">
								</div>
							</div> 
							<span id="before"> *개인정보 보호를 위해 비밀번호 확인이 필요합니다</span>
							<span id="after" hidden="hidden">비밀번호가 확인 되었습니다.</span>
						</td>
					</tr>
					<tr>
						<th>비밀번호 변경:</th>
						<td><input type="password" class="form-control-file"
							name="pwd" readonly="readonly"></td>
					</tr>
					<tr>
						<th>이메일:</th>
						<td><input type="email" value="${vo.email}"
							class="form-control-file" name="email" readonly="readonly"></td>
					</tr>
					<tr>
						<th>이름:</th>
						<td><input type="text" value="${vo.name}"
							class="form-control-file" name="name" readonly="readonly"></td>
					</tr>
					<tr>
						<th>전화번호:</th>
						<td><input type="text" value="${vo.phone}"
							class="form-control-file" name="phone" readonly="readonly"></td>
					</tr>
					<tr>
						<th>상태</th>
						<td>
							<c:choose>
								<c:when test="${vo.status==2 }">
									<c:set var="ttt" value="true"></c:set>
									<c:set var="ttt2" value="false"></c:set>
								</c:when>
								<c:otherwise>
									<c:set var="ttt" value="false"></c:set>
									<c:set var="ttt2" value="true"></c:set>
								</c:otherwise>
							</c:choose>
							<input type="radio" id="rest" name="status" value='1' style="float: left; 
								margin-top: 5px;" disabled="disabled" checked="${ttt }">
							<label for="rest">휴면중</label>
							<input type="radio" id="run" name="status" value='2' style="margin-top:5px; 
								margin-left: 50px;" disabled="disabled" checked="${ttt2 }">
							<label for="run">활동중</label>
						</td>
 					</tr>
				</tbody>
			</table>
			<div style="float: right;">
				<button type="submit" class="btn btn-primary" style="margin: 10px;">수정완료</button>
				<input type="button" class="btn btn-primary" value="탈퇴하기" style="margin: 10px;" id="drop">
				<input type="hidden" name="num" value="${vo.num }">
			</div>
		</form>
	</div>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
</body>
</html>