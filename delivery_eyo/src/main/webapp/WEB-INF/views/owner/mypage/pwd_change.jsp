<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
* {
	margin: 0px;
	padding: 0px;
}
input {
	width: 350px;
}
.help-block{
	color: red;
}
#join_table {
	height: 500px;
}
/* .help-block 을 일단 보이지 않게 설정 */
#joinForm .help-block {
	display: none;
}
/* glyphicon 을 일단 보이지 않게 설정 */
#joinForm .glyphicon {
	display: none;
}
</style>
</head>
<body>
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-md-4">
				<img id="store_img" class="nav-link" src="/delivery/resources/images/logo.PNG">
			</div>
		</div>
		<form action="${pageContext.request.contextPath }/owner/pwdChange" method="post" id="joinForm" onsubmit="return submitAction();">
			<div class="form-group has-feedback">
				<label class="control-label" for="pwd">현재 비밀번호</label> 
				<input class="form-control" type="password" id="pwd" /> 
				<span id="pwdErr" class="help-block">8글자 이상 입력하세요.</span>
				<span id="originalPwdErr" class="help-block">현재 비밀번호와 일치하지 않습니다.</span>
			</div>
			<div class="form-group has-feedback">
				<label class="control-label" for="pwd">새 비밀번호</label> 
				<input class="form-control" type="password" name="pwd" id="newPwd" /> 
				<span id="newPwdErr" class="help-block">8글자 이상 입력하세요.</span> 
				<span id="sameNewPwdErr" class="help-block">현재 비밀번호와 다른 비밀번호를 입력하세요.</span> 
			</div>
			<div class="form-group has-feedback">
				<label class="control-label" for="rePwd">새 비밀번호 재확인</label> 
				<input class="form-control" type="password" id="rePwd" />
				<span id="rePwdErr" class="help-block">비밀번호와 일치하지 않습니다. 다시 입력해주세요.</span> 
			</div>
			<div class="row justify-content-end">
				<button class="col-md-1 btn btn-outline-secondary" type="reset">취소</button>
				<button class="col-md-1 btn btn-outline-primary" type="submit">가입</button>
			</div>
		</form>
	</div>
</body>
<script type="text/javascript">

$("#pwd").keyup(function() {
	var pwd = $(this).val();
	// 비밀번호 검증할 정규 표현식
	var reg = /^.{8,}$/;
	if (reg.test(pwd)) {//정규표현식을 통과 한다면
		$("#originalPwdErr").hide();
		$("#pwdErr").hide();
	} else {//정규표현식을 통과하지 못하면
		$("#originalPwdErr").hide();
		$("#pwdErr").show();
	}
});
$("#newPwd").keyup(function() {
	var pwd = $(this).val();
	// 비밀번호 검증할 정규 표현식
	var reg = /^.{8,}$/;
	if (reg.test(pwd)) {//정규표현식을 통과 한다면
		$("#sameNewPwdErr").hide();
		$("#newPwdErr").hide();
	} else {//정규표현식을 통과하지 못하면
		$("#sameNewPwdErr").hide();
		$("#newPwdErr").show();
	}
});
$("#rePwd").keyup(function() {
	var rePwd = $(this).val();
	var newPwd = $("#newPwd").val();
	// 비밀번호 같은지 확인
	if (rePwd == newPwd) {//비밀번호 같다면
		$("#rePwdErr").hide();
	} else {//비밀번호 다르다면
		$("#rePwdErr").show();
	}
});



function submitAction(){
	let pwd = $("#pwd");
	let newPwd=$("#newPwd");
	let rePwd = $("#rePwd");
	let pwdErr=$("#pwdErr").css('display');
	let	newPwdErr=$("#newPwdErr").css('display');
	let rePwdErr=$("#rePwdErr").css('display');
	let sameNewPwdErr=$("#sameNewPwdErr").css('display');
	
	//required를 사용하지 않는 이유는 에러문구가 있는 상태에서 
	if(pwd.val()=="" || pwd.val()==null || pwd.val()!="" && pwd.val()!=null && pwdErr=='inline'){
		pwd.focus();
		return false;
	}else if(newPwd.val()=="" || newPwd.val()==null || newPwd.val()!="" && newPwd.val()!=null && newPwdErr=='inline'){
		newPwd.focus();
		return false;
	}else if(rePwd.val()=="" || rePwd.val()==null || rePwd.val()!="" && rePwd.val()!=null && rePwdErr=='inline'){
		rePwd.focus();
		return false;
	}else if(!(pwd.val()=="<%=session.getAttribute("ownerPwd")%>")){
		$("#originalPwdErr").show();
		return false;
	}else if(rePwd.val()=="<%=session.getAttribute("ownerPwd")%>"){
		$("#originalPwdErr").hide();
		$("#sameNewPwdErr").show();
		return false;
	}else{
		return true;
	}
}
</script>

















