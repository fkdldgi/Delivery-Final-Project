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
				$('#preview').attr('src', e.target.result);

			}
			reader.readAsDataURL(input.files[0]);
		}
	}
	function pwdcheck() {
		var inputpwd = document.getElementById("inputpwd").value;
		var orgpwd = document.getElementById("orgpwd").value;

		//var inputpwd = $("input[name=inputpwd]").val();
		console.log(inputpwd);
		console.log(orgpwd);
		if (inputpwd === orgpwd) {
			alert("비밀번호가 일치합니다");
			$("input[name=email]").removeAttr("readonly");
			$("input[name=tel]").removeAttr("readonly");
			$("input[name=changedpwd]").removeAttr("readonly");
			$("input[name=pwd]").removeAttr("readonly");
			$("span[id=before]").removeAttr("hidden");
			$("span[id=after]").Attr("hidden");
		} else {
			alert("비밀번호가 불일치합니다");
		}

	}
</script>
<body>
	<br>
	<div class="container"
		style="border: 1.5px solid orange; margin-bottom: 50px">
		<br> <img class="d-block mx-auto mb-4"
			src="/delivery/resources/images/mypage_logo1.png" width="700"
			height="150">
		<hr style="border: 1px solid orange;">
		<form action="/delivery/member/mypageOk" method="post" enctype="multipart/form-data">
			<table class="table table-bordered">
				<tbody>
					<tr>
						<div class="form-group under_border" style="text-align: center;">
							<br> <img src="${pageContext.request.contextPath }/resources/images/${vo.img}"
								class="rounded-circle" id="preview" width="200" height="200">
							<br> <label>프로필사진 변경하기</label> <br> 
							<input type="file" name="file1" accept="image/*" id="file">
						</div>
					</tr>
					<tr>
						<th>아이디</th>
						<td><input type="text" value="${vo.id}" id="title"
							class="form-control" readonly="readonly" /></td>
					</tr>
					<tr>
						<th>비밀번호 확인</th>
						<td>
							<div class="input-group mb-3">
								<!-- 원래 비밀번호 가져옴 orgpwd -->
								<input type="text" id=orgpwd value="${vo.pwd}" hidden="hidden">
								<input type="text" class="form-control" id="inputpwd"
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
						<td><input type="text" value="${vo.tel}"
							class="form-control-file" name="tel" readonly="readonly"></td>
					</tr>
					<tr>
						<th>가입일</th>
						<td><input type="text" value="${vo.regdate}"
							class="form-control-file" name="regdate" readonly="readonly"></td>
					</tr>
				</tbody>
			</table>
			<button type="submit" class="btn btn-primary">수정완료</button>
			<input type="hidden" name="num" value="${memberNum }">
		</form>
		<br>
		<div style="margin-bottom: 50px; text-align: center;">
			<button type="button" class="btn btn-primary"
				onclick="location.href='/delivery/member/QnaList?memberNum=${sessionScope.memberNum}'">문의목록</button>
			<button type="button" class="btn btn-primary"
				onclick="location.href='/delivery/member/orderList?memberNum=${sessionScope.memberNum}'">주문목록</button>
		</div>
	</div>
</body>
</html>