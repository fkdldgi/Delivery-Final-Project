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
				<img id="store_img" class="nav-link"
					src="/delivery/resources/images/logo.PNG">
			</div>
		</div>
		<form action="${pageContext.request.contextPath }/owner/join" method="post" id="joinForm" onsubmit="return submitAction();">
			<div class="form-group has-feedback">
				<label class="control-label" for="id">아이디</label> 
				<input class="form-control" type="text" name="id" id="id" /> 
				<span id="idErr" class="help-block">사용할 수 없는 아이디 입니다.</span> 
				<span class="glyphicon glyphicon-ok form-control-feedback"></span>
			</div>
			<div class="form-group has-feedback">
				<label class="control-label" for="pwd">비밀번호</label> 
				<input class="form-control" type="password" name="pwd" id="pwd" /> 
				<span id="pwdErr" class="help-block">8글자 이상 입력하세요.</span> 
				<span class="glyphicon glyphicon-ok form-control-feedback"></span>
			</div>
			<div class="form-group has-feedback">
				<label class="control-label" for="rePwd">비밀번호 재확인</label> 
				<input class="form-control" type="password" id="rePwd" />
				<span id="rePwdErr" class="help-block">비밀번호와 일치하지 않습니다. 다시 입력해주세요.</span> 
				<span class="glyphicon glyphicon-ok form-control-feedback"></span>
			</div>
			<div class="form-group has-feedback">
				<label class="control-label" for="name">이름</label> 
				<input class="form-control" type="text" name="name" id="name" /> 
				<span id="nameErr" class="help-block">올바른 이름 형식이 아닙니다. 다시 입력해주세요.</span> 
				<span class="glyphicon glyphicon-ok form-control-feedback"></span>
			</div>
			<div class="form-group has-feedback">
				<label class="control-label" for="email">이메일</label> 
				<input class="form-control" type="text" name="email" id="email" /> 
				<span id="emailErr" class="help-block">올바른 이메일 형식이 아닙니다. 다시 입력해주세요.</span> 
				<span class="glyphicon glyphicon-ok form-control-feedback"></span>
			</div>
			<div class="form-group has-feedback">
				<label class="control-label" for="tel">전화번호</label> 
				<input class="form-control" type="text" name="tel" id="tel" /> 
				<span id="telErr" class="help-block">올바른 전화번호 형식이 아닙니다. 다시 입력해주세요.</span> 
				<span class="glyphicon glyphicon-ok form-control-feedback"></span>
			</div>
			<div class="row justify-content-end">
				<button class="col-md-1 btn btn-outline-secondary" type="reset">취소</button>
				<button class="col-md-1 btn btn-outline-primary" type="submit">가입</button>
			</div>
		</form>
	</div>


	<!-- 
	<div>
	<form method="post" action="${pageContext.request.contextPath }/owner/join" id="joinForm">
		<div class="row justify-content-center">
			<div class="col-md-4">
				<img id="store_img" class="nav-link" src="/delivery/resources/images/logo.PNG">
			</div>
		</div>
		<table id="join_table" class="table text-center">
			<tr>
				<td>아이디</td>
				<td><input  class="input check-id error" type="text" name="id" placeholder="아이디를 입력하세요." required="required"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="pwd" placeholder="비밀번호를 입력하세요." required="required"></td>
				<td></td>
			</tr>
			<tr>
				<td>비밀번호재확인</td>
				<td><input type="password" name="rePwd" placeholder="비밀번호를 입력하세요." required="required"></td>
				<td></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" placeholder="이름을 입력하세요." required="required"></td>
				<td></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="text" name="email" placeholder="이메일을 입력하세요." required="required"></td>
				<td></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><input type="text" name="tel" placeholder="전화번호를 입력하세요." required="required"></td>
				<td></td>
			</tr>
		</table>
		<div class="row justify-content-end">
			<button class="col-md-1 btn btn-outline-secondary" type="reset">취소</button>
			<button class="col-md-1 btn btn-outline-primary" type="submit">가입</button> 
		</div>
	</form>
	</div>-->
</body>
<script type="text/javascript">
//아이디 입력란에 keyup 이벤트가 일어 났을때 실행할 함수 등록 
$("#id").keyup(function() {
	//입력한 문자열을 읽어온다.
	var id = $(this).val();
	//ajax 요청을 해서 서버에 전송한다.
	$.ajax({
		url:"${pageContext.request.contextPath}/owner/idchk",
		data:{id:id},
		success:function(data){
			if(data==1){//사용 가능한 아이디 라면 
				$("#idErr").hide();
				// 성공한 상태로 바꾸는 함수 호출
				successState("#id");
			} else {//사용 가능한 아이디가 아니라면 
				$("#idErr").show();
			}
		}
	});
});
$("#pwd").keyup(function() {
	var pwd = $(this).val();
	// 비밀번호 검증할 정규 표현식
	var reg = /^.{8,}$/;
	if (reg.test(pwd)) {//정규표현식을 통과 한다면
		$("#pwdErr").hide();
		successState("#pwd");
	} else {//정규표현식을 통과하지 못하면
		$("#pwdErr").show();
		errorState("#pwd");
	}
});
$("#rePwd").keyup(function() {
	var rePwd = $(this).val();
	var pwd = $("#pwd").val();
	// 비밀번호 같은지 확인
	if (rePwd == pwd) {//비밀번호 같다면
		$("#rePwdErr").hide();
		successState("#rePwd");
	} else {//비밀번호 다르다면
		$("#rePwdErr").show();
		errorState("#rePwd");
	}
});
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

// 성공 상태로 바꾸는 함수
function successState(sel) {
	$(sel).parent().removeClass("has-error").addClass("has-success").find(
			".glyphicon").removeClass("glyphicon-remove").addClass(
			"glyphicon-ok").show();
};
// 에러 상태로 바꾸는 함수
function errorState(sel) {
	$(sel).parent().removeClass("has-success").addClass("has-error").find(
			".glyphicon").removeClass("glyphicon-ok").addClass(
			"glyphicon-remove").show();
};

function submitAction(){
	let id = $("#id");
	let pwd = $("#pwd");
	let rePwd = $("#rePwd");
	let name = $("#name");
	let email = $("#email");
	let tel = $("#tel");
	let idErr=$("#idErr").css('display');
	let pwdErr=$("#pwdErr").css('display');
	let rePwdErr=$("#rePwdErr").css('display');
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
