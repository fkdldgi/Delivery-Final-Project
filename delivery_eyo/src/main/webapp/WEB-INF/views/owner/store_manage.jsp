<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!-- store_manage.jsp (가게운영) -->
    <!-- for문으로 한 사람당 가게 얼마인지에 따라서  카드로 나타내기 -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
<style>
	*{
		margin: 0px;
		padding: 0px;
	}
	
	.card{
		width: 30rem;
		margin: 20px;
		float: left;
		height: 210px;
	}
	
	.profile-img{
		width: 100%;
		height:100%;
		border-radius: 50px;
		margin:0 auto;
	}
	
</style>
<script>
	$(document).ready(function(){
	   $('#add_store').click(function(){
		   location.href="/delivery/owner/shopReg";
	   });
	});
</script>
<div>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark" style="font-family: 'Do Hyeon', sans-serif;">
		<a class="navbar-brand" style="font-size:24px;">가게운영</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse" 
			data-target="#navbarColor01" 
			aria-controls="navbarColor01" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarColor01">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active">
					<a class="nav-link" href="#">
						<span class="sr-only">
							(current)
						</span>
					</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="/delivery/owner/board" style="font-size:20px;">사장님,공지사항을 꼭 확인해주세요~</a>
				</li>
			</ul>
			<ul class="navbar-nav">
				<li class="nav-item">
					<button id="add_store" class="btn btn-info btn-lg">가게 등록</button>
				</li>
			</ul>
		</div>
	</nav>
</div>
<div style="margin: auto; padding: auto;font-family: 'Do Hyeon', sans-serif;">
	<div style="height: 1000px;">
		<c:forEach var="list" items="${list }">
			<div class="card">
				<div class="card-body">
					<div class="row">
						<div class="col-md-5">
							<img src="${pageContext.request.contextPath }/resources/profile/${list.profile_img }" alt="Card image cap" class="profile-img">
						</div>
						<div class="col-md-7">
							<br>
							<h5 class="card-title">${list.name }</h5>
							<p class="card-text">
								<%-- <p>${list.address_detail }</p> --%>
								<p>${list.addr }</p>
							</p>
						<button class="btn btn-info manage">
							<a style="color: white;"href="/delivery/owner/store_manage/home?num=${list.num }">
								관리하기
							</a>
						</button>
						</div>
					</div>
				</div>
			</div>
		</c:forEach>	
	</div>
</div>