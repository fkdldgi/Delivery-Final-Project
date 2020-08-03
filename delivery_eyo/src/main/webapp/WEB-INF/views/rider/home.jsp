<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
@import url("http://fonts.googleapis.com/earlyaccess/nanumgothic.css");

html {
	height: 100%;
}

body {
	width: 100%;
	height: 100%;
	margin: 0;
	padding-top: 80px;
	padding-bottom: 40px;
	font-family: "Nanum Gothic", arial, helvetica, sans-serif;
	background-repeat: no-repeat;
	background: linear-gradient(to bottom right, #6495ED, #8CBDED);
}

.card {
	margin: 0 auto; /* Added */
	float: none; /* Added */
	margin-bottom: 10px; /* Added */
	box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0
		rgba(0, 0, 0, 0.19);
}

.form-signin .form-control {
	position: relative;
	height: auto;
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	box-sizing: border-box;
	padding: 10px;
	font-size: 16px;
}
</style>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<title>배달이요~</title>

</head>
<body>
	<div class="card align-middle"style="width: 600px; border-radius: 20px;">
	<!-- 맨위에 뜨는 이미지 -->
		<div class="card-title" style="margin-left:110px; margin-top: -50px;">
			<img style="height: 350px;" src="/delivery/resources/images/logo_start.png">
		</div>
		<div class="card-body">
				<h2 class="form-signin-heading" align="center" style="margin-bottom: 30px; 
				margin-top: -130px;">라이더 회원에 오신것을 환영합니다.</h2>
				<br>
				<!-- 로그인을 누르면 모달 -->
				<div class="card text-white bg-primary mb-3"
					style="max-width: 18rem; text-align: center; 
					cursor:pointer" data-toggle="modal" data-target="#loginModal">
					<div class="card-header">
					<span>로그인</span></div>
				</div>
				
				<!-- 회원가입 누르면 모달 -->
				<div class="card text-white bg-secondary mb-3"
					style="max-width: 18rem; 
					cursor:pointer" data-toggle="modal" data-target="#joinModal">
					<div class="card-header" style="text-align: center;"><span>회원가입</span></div>
				</div>
		</div>
	</div>
	<!-- 로그인 모달 -->
	<form class="form-inline" method="post">
		<div class="modal fade in" id="loginModal" tabindex="-1" aria-labelledby="mySmallModalLabel">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h4 class="modal-title">로그인</h4>
						<button type="button" class="close" data-dismiss="modal" aria-label="close">
							<span aria-hidden="true">x</span>
						</button>
					</div>
					
					<!-- 로그인 내용 입력(모달) -->
					<div class="modal-body">
						<div class="row">
							<label for="inputId" class="col-xs-6 col-md-4">아이디</label>
							<input type="text" name="login_id" id="inputId" class="form-control" placeholder="아이디" required="required">
						</div>
						<div class="row">
							<label for="inputPwd" class="col-xs-6 col-md-4">비밀번호</label>
							<input type="password" name="login_pwd" id="inputPwd" class="form-control" placeholder="비밀번호" required="required">
						</div>
					</div>
					
					<!-- 모달 fotter -->
					<div class="modal-fotter">
		                <button type="button" id="login_user" class="btn btn-link float-right" onclick="return check_form()">로그인</button>
					</div>
				</div>
			</div>
		</div>
	</form>
	<!-- 회원가입 모달 -->
	<form class="form-inline" method="post" action="/delivery/rider/join" onsubmit="return check_join()">
		<div class="modal fade in" id="joinModal" tabindex="-1">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h4 class="modal-title">회원가입</h4>
						<button class="close" data-dismiss="modal" aria-label="close">
							<span aria-hidden="true">x</span>
						</button> 
					</div>
					<div class="modal-body">
						<div class="row">
							<label for="joinId" class="col-xs-6 col-md-4">아이디</label>
							<input type="text" name="id" id="joinId" class="form-control" placeholder="아이디" required>
						</div>
						<div class="row">
							<label for="joinPwd" class="col-xs-6 col-md-4">비밀번호</label>
							<input type="password" name="pwd" id="joinPwd" class="form-control" placeholder="비밀번호" required="required">
						</div>
						<div class="row">
							<label for="joinName" class="col-xs-6 col-md-4">이름</label>
							<input type="text" name="name" id="joinName" class="form-control" placeholder="이름" required="required">
						</div>
						<div class="row">
							<label for="joinPhone" class="col-xs-6 col-md-4">전화번호</label>
							<input type="text" name="phone" id="joinPhone" class="form-control" placeholder="'-'없이 입력해주세요." required="required">
						</div>
						<div class="row">
							<label for="joinEmail" class="col-xs-6 col-md-4">이메일</label>
							<input type="email" name="email" id="joinEmail" class="form-control" placeholder="이메일" required="required">
						</div>
					</div>
					<div class="modal-fotter">
						<button type="submit" id="join_user" class="btn btn-link float-right">가입</button>
					</div>
				</div>
			</div>
		</div>
	</form>
	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
	  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</body>
<script>
	
	// 로그인모달에 function
	function check_form(){
		var id = $("#inputId").val();
		var pwd = $("#inputPwd").val();
		$.ajax({
			url: "/delivery/rider/login",
			data: {id:id,pwd:pwd},
			dataType: "text",
			success:function(data){
				if(data==1){
					location.href="/delivery/rider/main";
				}else{
					alert("아이디 또는 비밀번호를 확인해 주세요.");
				}
			}
		});
	}
	
	// 회원가입 버튼
	function check_join(){
		
		var a = 0;
		
  		// 비밀번호 검증
		var pwd = $("#joinPwd").val();
		// 비밀번호 검증할 정규 표현식
		var reg = /^.{8,}$/;
		if(reg.test(pwd)){
		}else{
			alert("비밀번호는 8자리 이상으로 입력하셔야 합니다.");	
			return false;
		}		
		
		// 아이디 검사
		var id = $("#joinId").val();	
		
		$.ajax({
			url: "/delivery/rider/checkId",
			dataType:"text",
			data: {id:id},
			async: false,
			success:function(data){
				if(data=="fail"){
					alert("이미 존재하는 아이디 입니다.");
					a=1;
				}else{
					a=2;
				}
			}
		});
		 
		if(a==1){			
			return false;
		}else{
			return true;
		} 
	}
</script>
</html>