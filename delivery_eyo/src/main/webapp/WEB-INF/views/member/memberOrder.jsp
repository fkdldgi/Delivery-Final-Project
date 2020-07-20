<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container" style="width: 100%;">
  <div class="row" style="width: 100%;">
    <div class="col-8" id="storeWrap"
style="width: 90%; margin: auto; margin-bottom: 10px;">
	<c:out value="${param.info}" />
	<div class="media position-relative"
		style="border: 1px solid gray; margin-top: 10px; margin-bottom: 10px;">
		<img
			src="http://www.seoulfn.com/news/photo/201809/319058_113243_2622.gif"
			style="width: 20%; height: 100px;" class="mr-3">
		<div class="media-body">
			<p><h5 class="mt-0">${info.name}</h5></p>
			<p>최소 결제금액 : ${info.min_price }원</p>
			<p>전화번호 : ${info.reg_num }</p>
			<p>결재 수단 : ${info.payment_option}</p>
			<p>가게번호 : ${info.num}</p>
		</div>
	</div>
	
	<nav>
		<div class="nav nav-tabs" id="nav-tab" role="tablist"
			style="width: 100%;">
			<a class="nav-item nav-link active" id="nav-home-tab"
				data-toggle="tab" href="#nav-home" role="tab"
				aria-controls="nav-home" aria-selected="true"
				style="width: 33%; border: 1px solid blue;">메뉴</a> <a
				class="nav-item nav-link" id="nav-profile-tab" data-toggle="tab"
				href="#nav-profile" role="tab" aria-controls="nav-profile"
				aria-selected="false" style="width: 33%; border: 1px solid green;">리뷰</a>
			<a class="nav-item nav-link" id="nav-contact-tab" data-toggle="tab"
				href="#nav-contact" role="tab" aria-controls="nav-contact"
				aria-selected="false" style="width: 34%; border: 1px solid gray;">가게정보</a>
		</div>
	</nav>
	<div class="tab-content" id="nav-tabContent" style="border: 1px solid black;">
		<div class="tab-pane fade show active" id="nav-home" role="tabpanel"
			aria-labelledby="nav-home-tab">
			<div class="card-body">
					<div style="border: 1px solid gray;" data-toggle="modal"
						data-target="#menuModal"
						onclick="javascript:menu_detail(${main.num})">
						<p>${main.num }</p>
						<p>${main.name}</p>
						<p>${main.menu_info}</p>
						<p>${main.price}</p>
						<p>${main.img}</p>
					</div>
			</div>
		</div>
		<div class="tab-pane fade" id="nav-profile" role="tabpanel"
			aria-labelledby="nav-profile-tab">리뷰 숨기기2</div>
		<div class="tab-pane fade" id="nav-contact" role="tabpanel"
			aria-labelledby="nav-contact-tab">가게정보 숨기기3</div>
	</div>
</div>
    <!-- 주문표 부분 -->
	<div class="card sticky-top" id="cart" style="width:25%; height: 600px; border: 0px solid black; margin-top: 10px; margin-left: -90px;" >
		<div class="bg-dark" style="width: 100%; height: 10%; border: 0px solid black; color: white;">
			<div class='row'>
				<div class='col'>
					<h4 style="margin-top: 15px; margin-left: 20px;">장바구니</h4>
				</div>	
				<div class='col'>
					<button type="button" class="btn btn-sm btn-info" style=" margin-left:20px; margin-top: 15px;" onclick="delChild()">전체 삭제</button>
				</div>
			</div>
		</div>
		<div id="cart-body" style="width: 100%; height: 60%; border: 1px solid black; overflow: auto;"></div>
		<div id="cart-num"></div>
		<div id="cart-footer" style="width: 100%; height: 30%; border: 0px solid black; margin-top: 10px;">
			<div id="min-price" style="width: 100%; height: 30%; border: 1px solid black;">최소 결제금액<br>${info.min_price }원</div>
			<div style="width: 100%; height: 30%; border: 1px solid black;">총 금액<div id="total-price">선택된 메뉴가 없습니다</div>원</div>
			<button type="button" id='orderBtn' class='btn btn-primary btn-lg' style="width: 100%; height: 30%;">주문하기</button>
		</div>
	</div>    
  </div> 
  </div>