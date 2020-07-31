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
	background: linear-gradient(to bottom right, #0098FF, #6BA8D1);
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
	<div class="card align-middle"style="width: 900px; border-radius: 20px;">
		<div class="card-title" style="margin-left:260px; margin-top: -50px;">
			<img style="height: 350px;" src="/delivery/resources/images/logo_start.png">
		</div>
		<div class="card-body">
				<h2 class="form-signin-heading" align="center" style="margin-bottom: 30px; 
				margin-top: -130px;">무슨 회원이신가요?</h2>
				<br>
				<div class="card text-white bg-primary mb-3"
					style="max-width: 18rem; float: left;
					cursor:pointer" onclick = "window.location.href='${pageContext.request.contextPath}/member/main'">
					<div class="card-header">일반회원</div>
					<div class="card-body">
						<h5 class="card-title">주문하러 가볼까요~?</h5>
						<p class="card-text">배달이요 사이트로 가기</p>
					</div>
				</div>
				<div class="card text-white bg-secondary mb-3"
					style="max-width: 18rem; float: left; margin-left: 85px;
					cursor:pointer" onclick = "window.location.href='${pageContext.request.contextPath}/owner/main'">
					<div class="card-header">기업회원</div>
					<div class="card-body">
						<h5 class="card-title">장사하러 가볼까요~?</h5>
						<p class="card-text">사장님 사이트로 가기</p>
					</div>
				</div>
				<div class="card text-white bg-info mb-3"
					style="max-width: 18rem; float: right;
					cursor:pointer" onclick = "window.location.href='${pageContext.request.contextPath}/rider/main'">
					<div class="card-header">라이더회원</div>
					<div class="card-body">
						<h5 class="card-title">배달하러 가볼까요~?</h5>
						<p class="card-text">라이더 사이트로 가기</p>
					</div>
				</div>
		</div>
	</div>

	<div class="modal"></div>
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
</body>
</html>