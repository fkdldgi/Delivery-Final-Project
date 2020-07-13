<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!-- store_manage.jsp (가게운영) -->
    <!-- for문으로 한 사람당 가게 얼마인지에 따라서  카드로 나타내기 -->
<style>
	*{
		margin: 0px;
		padding: 0px;
	}
	
	.card{
		width: 20rem;
		margin: 20px;
		float: left;
	}
	
	img{
		width: 18rem;
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
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<a class="navbar-brand">가게운영</a>
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
					<a class="nav-link" href="/delivery/owner/board">사장님,공지사항을 꼭 확인해주세요~</a>
				</li>
			</ul>
			<ul class="navbar-nav">
				<li class="nav-item">
					<button id="add_store" class="btn btn-primary btn-lg">가게 등록</button>
				</li>
			</ul>
		</div>
	</nav>
</div>
<div style="margin: auto; padding: auto;">
	<div style="height: 1000px;">
		<c:forEach var="list" items="${list }">
			<div class="card">
				<div class="card-img-top">
				  	<img src="/delivery/resources/images/logo.PNG" alt="Card image cap">
				</div>
				<div class="card-body">
					<h5 class="card-title">${list.name }</h5>
					<p class="card-text">
						<p>위치</p>
						<p>${list.addr }</p>
					</p>
					<button class="btn btn-primary manage">
						<a style="color: white;"href="/delivery/owner/store_manage/home?num=${list.num }">
							관리하기
						</a>
					</button>
				</div>
			</div>
		</c:forEach>	
	</div>
</div>