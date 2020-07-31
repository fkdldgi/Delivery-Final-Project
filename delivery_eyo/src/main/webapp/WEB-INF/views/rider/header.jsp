<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
		<!-- views/header.jsp -->
<script>
	$(document).ready(function(){
	   $('#logo').click(function(){
		   location.href="/delivery/rider/main";
	   });
	});
	function check_form(){
		var id=$('#inputId').val();
		var pwd=$('#inputPwd').val();
		$.ajax({
			url: "${pageContext.request.contextPath}/owner/login",
			data: {id:id,pwd:pwd},
			dataType: "text",
			success:function(data){
				console.log(data);
				if(data==1){
					location.reload(); //로그인 성공 후 헤더 새로고침
					location.href="${pageContext.request.contextPath}/owner/main";
				}else{
					alert("아이디 또는 비밀번호를 확인해주세요");
				}
			}
		});
	}
	function logout(){
		$.ajax({
			url:"${pageContext.request.contextPath}/rider/logout",
			success:function(data){
				location.href=data;
			}
		});
	}
</script>
<nav class="navbar navbar-expand-lg navbar-light" style="border-bottom:1px solid #dee2e6;">

	<img id="logo" class="nav-link" alt="Logo" src="/delivery/resources/images/logo.PNG">
	
	<ul class="navbar-nav mr-auto">
	</ul>
	
	<ul class="navbar-nav">
		<c:choose>
			<c:when test="${empty sessionScope.riderId }">
				 <li class="nav-item">
					<a class="nav-link btn btn-link" data-toggle="modal" data-target="#myModal">로그인</a>
		         </li>			
			</c:when>
			<c:otherwise>
				<li class="nav-item">
					<a class="nav-link" href="">${sessionScope.riderId } 님</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="/delivery/rider/update?num=${sessionScope.riderNum }">내정보</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="/delivery/rider/logout">로그아웃</a>
				</li>
			</c:otherwise>
		</c:choose>

		<!-- 모달영역 -->
		<form class="form-inline" method="post">
			<div class="modal fade in" id="myModal" tabindex="-1" aria-labelledby="mySmallModalLabel">
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
								<input type="text" name="login_id" id="inputId" class="form-control" placeholder="아이디" required autofocus>
							</div>
							<div class="row">
								<label for="inputPwd" class="col-xs-6 col-md-4">비밀번호</label>
								<input type="password" name="login_pwd" id="inputPwd" class="form-control" placeholder="비밀번호" required>
							</div>
						</div>
						
						<!-- 모달 fotter -->
						<div class="modal-fotter">
			                <button type="button" id="join_user" class="btn btn-link float-right" onclick="return check_form()">로그인</button>
						</div>
					</div>
				</div>
			</div>
		</form>
	</ul>
</nav>	