<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
a {
	color: inherit;
	text-decoration: none;
}
.pwfind {
    display: block;
    margin: 13px 0 30px;
    font-size: 12px;
    color: #8e929f;
}

#join_table {
	height: 500px;
}
/* .help-block 을 일단 보이지 않게 설정 */
.help-block {
	display: none;
	color: red;
}
/* glyphicon 을 일단 보이지 않게 설정 */
.glyphicon {
	display: none;
}
</style>
<div>
	<nav class="navbar navbar-expand-md navbar-dark bg-dark">
		<a class="navbar-brand mx-auto">어서오세요 배달이요입니다.</a>
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
								id="store_managehref">
						가게운영
					</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="/delivery/owner/board/">
						공지사항
					</a>
				</li>
			</ul>
		</div>
	</nav>
</div>
<div class="container p-3 my-5 border">
	<form action="${pageContext.request.contextPath}/owner/mypage" method="POST" onsubmit="return submitAction()">
	  <div class="form-group">
	    <label class="font-weight-bold">비밀번호 재확인</label>
	    <small id="emailHelp" class="form-text text-muted">회원님의 개인정보를 안전하게 보호하기 위해 비밀번호를 다시 한 번 확인합니다.</small><br>
	    <label for="exampleInputPassword1" class="font-weight-bold">Password</label>
	    <input type="password" class="form-control" id="pwd" name="pwd" placeholder="비밀번호를 입력해주세요.">
	    <span id="pwdErr" class="help-block">8글자 이상 입력하세요.</span>
	    <span id="pwdErr2" class="help-block">비밀번호를 다시 확인해주세요.</span>
	    <a href="" class="pwfind">비밀번호 찾기</a>
	  </div>
	  <button class="col-md-1 btn btn-outline-primary" type="submit">확인</button>
	</form>
</div>
<script>
//비밀번호 재확인 후 form 전송
function submitAction(){
	var pwd="<%=request.getAttribute("ownerPwd") %>";
	if(pwd==$("#pwd").val()){
		$("#pwdErr2").hide();
		return true;
	}else{
		$("#pwdErr").hide();
		$("#pwdErr2").show();
		return false;
	}
}

$("#pwd").keyup(function() {
	var pwd = $(this).val();
	// 비밀번호 검증할 정규 표현식
	var reg = /^.{8,}$/;
	if (reg.test(pwd)) {//정규표현식을 통과 한다면
		$("#pwdErr2").hide();
		$("#pwdErr").hide();
	}else {//정규표현식을 통과하지 못하면
		$("#pwdErr2").hide();
		$("#pwdErr").show();
	}
});

</script>
