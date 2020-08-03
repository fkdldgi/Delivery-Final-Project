<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	$(document).ready(function(){
		
	});
</script>
<style>
	#carouselExampleInterval{
		height: 500px;
		 margin-top: 50px; 
	}
	
	#carouselExampleInterval2{
		height: 500px;
	}
</style>
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
								id="store_managehref" style="font-size:20px;">
						가게운영
					</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="/delivery/owner/board/" style="font-size:20px;">
						공지사항
					</a>
				</li>
			</ul>
		</div>
	</nav>
</div>
			<!-- carousel 띄우기 -->
<div id="carouselExampleInterval"
	class="carousel slide" data-ride="carousel">
	<ol class="carousel-indicators">
		<li data-target="#carouselExampleInterval" data-slide-to="0"
			class="active"></li>
		<li data-target="#carouselExampleInterval" data-slide-to="1"></li>
		<li data-target="#carouselExampleInterval" data-slide-to="2"></li>
	</ol>
	<div class="carousel-inner">
		<div class="carousel-item active" data-interval="3000">
			<img
				src="/delivery/resources/images/owner_carousel1.png"
				class="d-block w-75 h-50" 
				 style="margin: auto; border: 4px solid #2FA599; width:75% !important;height:450px !important;"
				 alt="...">
		</div>
		<div class="carousel-item" data-interval="3000">
			<img
				src="/delivery/resources/images/owner_carousel2.png"
				class="d-block w-75 h-75"
				 style="margin: auto; border: 4px solid #FCAB1E; width:75% !important;height:450px !important;" alt="...">
		</div>
		<div class="carousel-item" data-interval="3000">
			<img
				src="/delivery/resources/images/owner_carousel3.png"
				class="d-block w-75 h-100"
				 style="margin: auto; border: 4px solid #139164; width:75% !important;height:450px !important;" alt="...">
		</div>
		<div class="slide-count-wrap">
			<span class="slide-count"><span class="current"></span>  <span
				class="total"></span></span> <a href="javascript:;" class="btn-play"></a>
		</div>
	</div>
	<a class="carousel-control-prev" href="#carouselExampleInterval"
		role="button" data-slide="prev"> <span
		class="carousel-control-prev-icon" aria-hidden="true"></span> <span
		class="sr-only">Previous</span>
	</a> <a class="carousel-control-next" href="#carouselExampleInterval"
		role="button" data-slide="next"> <span
		class="carousel-control-next-icon" aria-hidden="true"></span> <span
		class="sr-only">Next</span>
	</a>
</div>
<div id="carouselExampleInterval2"
	class="carousel slide" data-ride="carousel">
	<ol class="carousel-indicators">
		<li data-target="#carouselExampleInterval2" data-slide-to="0"
			class="active"></li>
	</ol>
	<div class="carousel-inner">
		<div class="carousel-item active">
			<img
				style="margin: auto; border: 4px solid #FECCBE; height:450px !important;"
				src="/delivery/resources/images/Hoxy.png"
				class="d-block w-75 h-50" 
				 alt="...">
		</div>
	</div>
</div>

