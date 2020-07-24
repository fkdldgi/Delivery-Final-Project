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

</style>
</head>
<body>
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-md-4">
				<img id="store_img" class="nav-link" src="/delivery/resources/images/logo.PNG">
			</div>
		</div>
		<h2>회원정보</h2><br>
		<form action="${pageContext.request.contextPath }/owner/pwdChange" method="post" id="joinForm" onsubmit="return submitAction();">
			<div class="form-group has-feedback">
				<label class="control-label" for="name">이름</label> 
				<input class="form-control" type="text" id="name" name="name" value="${ownerVo.name }"/> 
				<span id="nameErr" class="help-block">올바른 이름 형식이 아닙니다. 다시 입력해주세요.</span>
			</div>
			<div class="form-group has-feedback">
				<label class="control-label" for="tel">전화번호</label> 
				<input class="form-control" type="text" name="tel" id="tel" value="${ownerVo.tel }"/> 
				<span id="telErr" class="help-block">올바른 전화번호 형식이 아닙니다. 다시 입력해주세요.</span> 
			</div>
			<div class="form-group has-feedback">
				<label class="control-label" for="email">이메일</label> 
				<input class="form-control" type="text" name="email" id="email" value="${ownerVo.email }"/> 
				<span id="emailErr" class="help-block">올바른 이메일 형식이 아닙니다. 다시 입력해주세요.</span> 
				<span class="glyphicon glyphicon-ok form-control-feedback"></span>
			</div>
			<div class="row justify-content-end">
				<button class="col-md-1 btn btn-outline-secondary" type="reset" onclick="history.go(-1)">취소</button>
				<button class="col-md-1 btn btn-outline-primary" type="submit">가입</button>
			</div>
		</form>
	</div>
</body>
<script type="text/javascript">

$("#name").keyup(function() {
	var name = $(this).val();
	// 이메일 검증할 정규 표현식
	let reg = /^[가-힣]{2,4}|[a-zA-Z]{2,10}\s[a-zA-Z]{2,10}$/;
	if (reg.test(name)) {//정규표현식을 통과 한다면
		$("#nameErr").hide();
		successState("#name");
	} else {//정규표현식을 통과하지 못하면
		$("#nameErr").show();
		errorState("#name");
	}
});
$("#tel").keyup(function(){
	var tel=$(this).val();
	// 전화번호 검증할 정규 표현식
	let reg=/^\d{3}\d{3,4}\d{4}$/;

	if (reg.test(tel)) {//정규표현식을 통과 한다면
		$("#telErr").hide();
		successState("#tel");
	} else {//정규표현식을 통과하지 못하면
		$("#telErr").show();
		errorState("#tel");
	}
});
$("#email").keyup(function() {
	var email = $(this).val();
	// 이메일 검증할 정규 표현식
	let reg = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	if (reg.test(email)) {//정규표현식을 통과 한다면
		$("#emailErr").hide();
		successState("#email");
	} else {//정규표현식을 통과하지 못하면
		$("#emailErr").show();
		errorState("#email");
	}
});



function submitAction(){
	let name = $("#name");
	let email = $("#email");
	let tel = $("#tel");
	let nameErr=$("#nameErr").css('display');
	let emailErr=$("#emailErr").css('display');
	let telErr=$("#telErr").css('display');
	if(id.val()=="" || id.val()==null || id.val()!="" && id.val()!=null && idErr=='inline'){
		errorState("#id");
		id.focus();
		return false;
	}else if(pwd.val()=="" || pwd.val()==null || pwd.val()!="" && pwd.val()!=null && pwdErr=='inline'){
		errorState("#pwd");
		pwd.focus();
		return false;
	}else if(rePwd.val()=="" || rePwd.val()==null || rePwd.val()!="" && rePwd.val()!=null && rePwdErr=='inline'){
		errorState("#rePwd");
		rePwd.focus();
		return false;
	}else if(name.val()=="" || name.val()==null || name.val()!="" && name.val()!=null && nameErr=='inline'){
		errorState("#name");
		name.focus();
		return false;
	}else if(email.val()=="" || email.val()==null || email.val()!="" && email.val()!=null && emailErr=='inline'){
		errorState("#email");
		email.focus();
		return false;
	}else if(tel.val()=="" || tel.val()==null || tel.val()!="" && tel.val()!=null && telErr=='inline'){
		errorState("#tel");
		tel.focus();
		return false;
	}else{
		return true;
	}
}
</script>

















