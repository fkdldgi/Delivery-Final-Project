<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- 이벤트 슬라이드 div -->
<div class="container">
	<div style="height: 450px;" id="carouselExampleInterval"
		class="carousel slide" data-ride="carousel">
		<ol class="carousel-indicators">
			<li data-target="#carouselExampleInterval" data-slide-to="0"
				class="active"></li>
			<li data-target="#carouselExampleInterval" data-slide-to="1"></li>
			<li data-target="#carouselExampleInterval" data-slide-to="2"></li>
		</ol>
		<div class="carousel-inner" style="height: 450px">
			<div class="carousel-item active" data-interval="1000">
				<img
					src="/delivery/resources/images/main_1year_01.png"
					class="d-block w-100" alt="..." style="height: 450px;">
			</div>
			<div class="carousel-item" data-interval="1000">
				<img
					src="/delivery/resources/images/main_summer_enent_01.png"
					class="d-block w-100" alt="..." style="height: 450px;">
			</div>
			<div class="carousel-item" data-interval="1000">
				<img
					src="/delivery/resources/images/main_healthy_event.png"
					class="d-block w-100" alt="..." style="height: 450px;">
			</div>
			<div class="slide-count-wrap">
				<span class="slide-count"><span class="current">1</span> / <span
					class="total">3</span></span> <a href="javascript:;" class="btn-play">btnPlay</a>
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
</div>

<!-- 카테로그 블록 div -->
<div class="row" style="width: 80%; margin: auto; margin-bottom: 100px; margin-top: 100px;">
	<!-- 오늘의 혜택 블록 -->
	<div class="col-xs-6 col-sm-4 col-md-3 col-lg-3">
		<a href="/delivery/member/event_main" class="thumbnail"> <img
			src="/delivery/resources/images/main_01.png"></a>
	</div>
	<!-- 맛있는 음식 모아보기 블록 -->
	<div class="col-xs-6 col-sm-4 col-md-3 col-lg-3">
		<a href="/delivery/member/storeList?startrow=1"><img
			src="/delivery/resources/images/main_02.png"></a>
	</div>
	<!-- 프렌차이즈 블록 -->
	<div class="col-xs-6 col-sm-4 col-md-3">
		<a href="" class="thumbnail"> <img
			src="/delivery/resources/images/main_03.png"></a>
	</div>
	<!-- 치킨 블록 -->
	<div class="col-xs-6 col-sm-4 col-md-3">
		<a href="" class="thumbnail"> <img
			src="/delivery/resources/images/main_04.png"></a>
	</div>
	<!-- 중국집 블록 -->
	<div class="col-xs-6 col-sm-4 col-md-3" style="margin-top: 20px">
		<a href="" class="thumbnail"> <img
			src="/delivery/resources/images/main_05.png"></a>
	</div>
	<!-- 양식 블록 -->
	<div class="col-xs-6 col-sm-4 col-md-3" style="margin-top: 20px">
		<a href="" class="thumbnail"> <img
			src="/delivery/resources/images/main_06.png"></a>
	</div>
	<!-- 한식 블록 -->
	<div class="col-xs-6 col-sm-4 col-md-3" style="margin-top: 20px">
		<a href="" class="thumbnail"> <img
			src="/delivery/resources/images/main_07.png"></a>
	</div>
	<!-- 카페 블록 -->
	<div class="col-xs-6 col-sm-4 col-md-3" style="margin-top: 20px">
		<a href="" class="thumbnail"> <img
			src="/delivery/resources/images/main_08.png"></a>
	</div>
	<!-- 일식 블록 -->
	<div class="col-xs-6 col-sm-4 col-md-3" style="margin-top: 20px">
		<a href="" class="thumbnail"><img
			src="/delivery/resources/images/main_09.png"></a>
	</div>
	<!-- 족발/보쌈 블록 -->
	<div class="col-xs-6 col-sm-4 col-md-3" style="margin-top: 20px">
		<a href="" class="thumbnail"><img
			src="/delivery/resources/images/main_10.png"></a>
	</div>
	<!-- 야식 블록 -->
	<div class="col-xs-6 col-sm-4 col-md-3" style="margin-top: 20px">
		<a href="" class="thumbnail"><img
			src="/delivery/resources/images/main_11.png"></a>
	</div>
	<!-- 분식 블록 -->
	<div class="col-xs-6 col-sm-4 col-md-3" style="margin-top: 20px">
		<a href="" class="thumbnail"><img
			src="/delivery/resources/images/main_12.png"></a>
	</div>
</div>

