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
#updateForm .help-block {
	display: none;
}

</style>
</head>
<body>
<!-- 맨 위에 뜨는 nav바 -->
<div>
	<nav class="navbar navbar-expand-md navbar-dark bg-dark" style="font-family: 'Do Hyeon', sans-serif;">
		<a class="navbar-brand mx-auto" style="font-size:24px;">어서오세요 배달이요입니다.</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#store_manage"
			aria-controls="store_manage" aria-expanded="false"
			aria-label="Toggle navigation">
		</button>
		<div class="collapse navbar-collapse" id="store_manage">
			<ul class="navbar-nav mr-auto">
				<!-- 가게인사랑 가게운영 href랑 떨어지게 하기 위해서 넣음 -->
				<li class="nav-item active">
     				<a class="nav-link" href="#">
     					<span class="sr-only">
     						(current)
     					</span>
     				</a>
     			</li>
				<li class="nav-item">
					<a class="nav-link" href="/delivery/owner/store_manage?id=${sessionScope.ownerId }" 
								id="store_managehref" style="font-size:22px;">
						가게운영
					</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="/delivery/owner/board/" style="font-size:22px;">
						공지사항
					</a>
				</li>
			</ul>
		</div>
	</nav>
</div>
	<div class="container"  style="font-family: 'Do Hyeon', sans-serif;padding:50px;">
		<h2>회원정보</h2><br>
		<form action="${pageContext.request.contextPath }/owner/owner_update" method="post" id="updateForm" onsubmit="return submitAction();">
			<input type="hidden" name="id" value="${ownerId }">
			<div class="form-group has-feedback">
				<label class="control-label" for="name">이름</label> 
				<input class="form-control" type="text" id="name" name="name" value="${name }"/> 
				<span id="nameErr" class="help-block">올바른 이름 형식이 아닙니다. 다시 입력해주세요.</span>
			</div>
			<div class="form-group has-feedback">
				<label class="control-label" for="tel">전화번호</label> 
				<input class="form-control" type="text" name="tel" id="tel" value="${tel }"/> 
				<span id="telErr" class="help-block">올바른 전화번호 형식이 아닙니다. 다시 입력해주세요.</span> 
			</div>
			<div class="form-group has-feedback">
				<label class="control-label" for="email">이메일</label> 
				<input class="form-control" type="text" name="email" id="email" value="${email }"/> 
				<span id="emailErr" class="help-block">올바른 이메일 형식이 아닙니다. 다시 입력해주세요.</span> 
				<span class="glyphicon glyphicon-ok form-control-feedback"></span>
			</div>
			<br>
			<div class="row justify-content-end">
				<div class="col-md-2">
					<button class="btn btn-info btn-block" type="reset" onclick="history.go(-1)">취소</button>
				</div>
				<div class="col-md-2">
					<button class="btn btn-info btn-block" type="submit">가입</button>
				</div>
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
	} else {//정규표현식을 통과하지 못하면
		$("#nameErr").show();
	}
});
$("#tel").keyup(function(){
	var tel=$(this).val();
	// 전화번호 검증할 정규 표현식
	let reg=/^\d{3}\d{3,4}\d{4}$/;

	if (reg.test(tel)) {//정규표현식을 통과 한다면
		$("#telErr").hide();
	} else {//정규표현식을 통과하지 못하면
		$("#telErr").show();
	}
});
$("#email").keyup(function() {
	var email = $(this).val();
	// 이메일 검증할 정규 표현식
	let reg = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	if (reg.test(email)) {//정규표현식을 통과 한다면
		$("#emailErr").hide();
	} else {//정규표현식을 통과하지 못하면
		$("#emailErr").show();
	}
});



function submitAction(){
	let name = $("#name");
	let email = $("#email");
	let tel = $("#tel");
	let nameErr=$("#nameErr").css('display');
	let emailErr=$("#emailErr").css('display');
	let telErr=$("#telErr").css('display');
	let rname="<%=request.getAttribute("name")%>";
	let remail="<%=request.getAttribute("email")%>";
	let rtel="<%=request.getAttribute("tel")%>";
	if(name.val()=="" || name.val()==null || name.val()!="" && name.val()!=null && nameErr=='inline'){
		name.focus();
		return false;
	}else if(tel.val()=="" || tel.val()==null || tel.val()!="" && tel.val()!=null && telErr=='inline'){
		tel.focus();
		return false;
	}else if(email.val()=="" || email.val()==null || email.val()!="" && email.val()!=null && emailErr=='inline'){
		email.focus();
		return false;
	}else if(name.val()==rname && tel.val()==rtel && email.val()==remail){
		alert("수정사항이 없습니다.");
		return false;
	}else{
		return true;
	}
}
</script>

















