<%@page import="com.jhta.delivery.member.vo.ShopVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="storeWrap"
	style="width: 50%; margin: auto; margin-bottom: 10px;">
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
	
	<!-- 주문표 부분 -->
	<div class="sticky-top" style="position: absolute; top: 222px; right: 150px; width: 300px; height: 400px; border: 1px solid gray;">고정 메뉴바</div>
	
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
	<div class="tab-content" id="nav-tabContent"
		style="border: 1px solid black;">
		<div class="tab-pane fade show active" id="nav-home" role="tabpanel"
			aria-labelledby="nav-home-tab">
			<div class="card-body">
				<c:forEach items="${mainmenu }" var="main">
					<div style="border: 1px solid gray;" data-toggle="modal"
						data-target="#menuModal"
						onclick="javascript:menu_detail(${main.num})">
						<p>${main.num }</p>
						<p>${main.name}</p>
						<p>${main.menu_info}</p>
						<p>${main.price}</p>
						<p>${main.img}</p>
					</div>
				</c:forEach>
			</div>
		</div>
		<div class="tab-pane fade" id="nav-profile" role="tabpanel"
			aria-labelledby="nav-profile-tab">리뷰 숨기기2</div>
		<div class="tab-pane fade" id="nav-contact" role="tabpanel"
			aria-labelledby="nav-contact-tab">가게정보 숨기기3</div>
	</div>
</div>

<!-- Modal -->
<div class="modal fade" id="menuModal" data-backdrop="static"
	data-keyboard="false" tabindex="-1" role="dialog"
	aria-labelledby="staticBackdropLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<p class="modal-title" id="modal-title"></p>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body" id="modal-body"></div>
			<div id="volume" style="margin: auto; margin-bottom: 10px;">
				<div class="btn-group mr-2" role="group">
				    <button type="button" class="btn btn-info" onclick="volumeDown()">-</button>
				    <input type="text" id="volumeText" class="btn btn-white" value="1" style="width: 5%; border: 1px solid gray;" readonly="readonly">
				    <button type="button" class="btn btn-info" onclick="volumeUp()">+</button>
				</div> 
			</div>
			<div style="background-color: gray;height: 50px;" class="d-flex bd-highlight">
			  <div class="p-2 flex-grow-1 bd-highlight" style="color: white; margin-top: 5px; margin-left: 10px;"><h5>총 주문금액</h5></div>
			  <div class="p-2 bd-highlight" style="color: blue;"><h3 id="total"></h3></div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary" style="width: 48%;"onclick="addCart()">담기</button>
				<button type="button" class="btn btn-secondary" data-dismiss="modal" style="width: 48%; float: left;" onclick="cancle()">취소</button>
			</div>
		</div>
	</div>
</div>
<script>

	//메뉴 모달 띄우면서 출력값(메뉴,옵션메뉴) 뿌려주는 함수
	function menu_detail(num){
		$.ajax({
		        url: "/delivery/store/menu_option",
		        type: "post",
		        data: JSON.stringify(num),
		        dataType: "json",
		        contentType: "application/json",
		        success: function(data) {
		        	$("#modal-title").empty();
		        	$("#modal-body").empty();
		        	$("#total").empty();
					$("#modal-title").append("<h5 style='text-align: center;'>메뉴 상세</h5>");
					$("#modal-body").append("<img src='http://www.seoulfn.com/news/photo/201809/319058_113243_2622.gif' style='width:100%;'>");
					$("#modal-body").append("<p><h1 style='text-align: center;'>"+ data.menuInfo.name +"</h1></p>");
					$("#modal-body").append("<p><h5 style='text-align: center;'> 설명 : "+ data.menuInfo.menu_info +"</h5></p>");
					$("#modal-body").append("<label style='text-align: left;'> 가격 :</label><label style='text-align: right;'id='menuprice'>"+ data.menuInfo.price +"</label><label style='text-align: left;'>원</label>");
					$("#total").text(data.menuInfo.price +"원");
					if(data.optionList[0] != null){
						$("#modal-body").append("<p><h5>"+ data.optionList[0].category +"</h5></p>");
						for(i in data.optionList){
							$("#modal-body").append("<p><input type='checkbox' onclick='clickOption()' class='check' value="+ data.optionList[i].price+">&nbsp;&nbsp;<label>"+ data.optionList[i].name +"</label><label style='float:right'>+"+ data.optionList[i].price +"원</label></p>");
						}
					}
		        },error: function(errorThrown) {
				alert(errorThrown.statusText);
			}
		});
	}
	
	//수량 증가 함수
	function volumeUp(){
		var price = 0 ;
		var totalPrice = 0;
		if($(".check").each(function(){
			if($(this).is(":checked")){
				price =  (price + parseInt($(this).val()));
			}
		}))
		if(price===0){
			totalPrice = (parseInt($("#menuprice").text()))*(parseInt($("#volumeText").val()) + 1);
		}else{
			totalPrice = (price + parseInt($("#menuprice").text()))*(parseInt($("#volumeText").val()) + 1);
		}
		$('#volumeText').val((parseInt($("#volumeText").val()) + 1));
		$("#total").text(totalPrice+'원');
	}
	
	//수량 감소 함수
	function volumeDown(){
		var price = 0 ;
		var totalPrice = 0;
		if((parseInt($("#volumeText").val()) - 1) > 0){
			if($(".check").each(function(){
				if($(this).is(":checked")){
					price =  (price + parseInt($(this).val()));
				}
			}))
			if(price===0){
				totalPrice = (parseInt($("#menuprice").text()))*(parseInt($("#volumeText").val()) + -1);
			}else{
				totalPrice = (price + parseInt($("#menuprice").text()))*(parseInt($("#volumeText").val()) + -1);
			}
			$('#volumeText').val((parseInt($("#volumeText").val()) + -1));
			$("#total").text(totalPrice+'원');
		}
	}
	
	//메뉴 모달페이지에서 닫기를 누르면 수량 초기화 함수
	function cancle(){
		if($(".check").each(function(){
			if($(this).is(":checked")){
				
			}
		}))
		$('#volumeText').val(1); 
	}
	
	//주문표에 담기 눌렀을 때 실행되는 함수
	function addCart(){
		
		
		$('#volumeText').val(1);
	}
	
	//옵션 메뉴 선택시 총금액 변경해주는 함수
	function clickOption(){
		//메뉴 가격
		var menuPrice = parseInt($("#menuprice").text());
		//현재 선택한 수량
		var volume = parseInt($("#volumeText").val());
		//옵션가격
		var optionPrice = 0 ;
		if($(".check").each(function(){
			if($(this).is(":checked")){
				optionPrice =  (optionPrice + parseInt($(this).val()));
			}
		}))
		//총 가격 넣어주기
		var totalPrice = ((menuPrice + optionPrice)*volume);
		$('#total').text(totalPrice + '원');
	}
	console.log(sessionStorage.getItem('id'));
</script>
