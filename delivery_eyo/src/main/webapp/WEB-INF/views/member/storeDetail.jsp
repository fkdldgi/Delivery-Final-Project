<%@page import="com.jhta.delivery.vo.ShopVo"%>
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
    <!-- 주문표(장바구니) 부분 -->
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
			<div style="background-color: gray; height: 50px;" class="d-flex bd-highlight">
			  <div class="p-2 flex-grow-1 bd-highlight" style="color: white; margin-top: 5px; margin-left: 10px;"><h5>총 주문금액</h5></div>
			  <div class="p-2 bd-highlight" style="color: blue;"><h3 id="total"></h3></div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary" data-dismiss="modal" style="width: 48%;"onclick="addCart()">담기</button>
				<button type="button" class="btn btn-secondary" data-dismiss="modal" style="width: 48%; float: left;" onclick="cancle()">취소</button>
			</div>
		</div>
	</div>
</div>
<script>
	//console.log('${sessionScope.memberId}') //아이디 세션 확인하기
	
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
					$("#modal-title").append("<input type='text' id='menuNum' value='"+ data.menuInfo.num +"' hidden >");
					$("#modal-body").append("<img src='http://www.seoulfn.com/news/photo/201809/319058_113243_2622.gif' style='width:100%;'>");
					$("#modal-body").append("<p><h1 style='text-align: center;' id='menuName'>"+ data.menuInfo.name +"</h1></p>");
					$("#modal-body").append("<p><h5 style='text-align: center;'> 설명 : "+ data.menuInfo.menu_info +"</h5></p>");
					$("#modal-body").append("<label style='text-align: left;'> 가격 :</label><label style='text-align: right;'id='menuprice'>"+ data.menuInfo.price +"</label><label style='text-align: left;'>원</label>");
					$("#total").text(data.menuInfo.price +"원");
					if(data.optionList[0] != null){
						$("#modal-body").append("<p><h5>"+ data.optionList[0].category +"</h5></p>");
						for(i in data.optionList){
							$("#modal-body").append("<p><input type='checkbox' onclick='clickOption()' class='check' value="+ 
									data.optionList[i].price +
									',' + data.optionList[i].num + 
									',' + data.optionList[i].name + ">&nbsp;&nbsp;" +
									"<label>"+ data.optionList[i].name +"</label>" +
									"<label style='float:right'>+"+ data.optionList[i].price +"원</label></p>"+
									"<div id='optionNum' hidden >"+ data.optionList[i].num + "</div>");
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
	
	//묶음으로 담을 List 만들기
	
	var cart_totalPrice = 0;
	//담기 눌렀을 때 실행되는 함수
	function addCart(){
		//총 가격 가져와서 숫자부분 자르기
		var menuPrice = $('#total').text().split('원'); //컨트롤러로 보낼 때 숫자만 보내야하므로 미리 자름
		var menuNmae = $('#menuName').text();
		var volume = $('#volumeText').val();
		var menuNum = $('#menuNum').val();
		var count = 0;
		
		cart_totalPrice = (parseInt(cart_totalPrice) + parseInt(menuPrice[0]));
		
		var optionStr = '옵션 : ';
		var optionNum = '';
		if($(".check").each(function(){
			if($(this).is(":checked")){
				++count;
				if(count === 1){
					optionStr = optionStr + $(this).val().split(',')[2];
					optionNum = optionNum + $(this).val().split(',')[1];
				}else{  
					optionStr = optionStr + ',' +$(this).val().split(',')[2];
					optionNum = optionNum + ',' +$(this).val().split(',')[1];
				}
			}
		}));
		
		$('#cart-body').append(
				"<div class='list' hidden >"+menuNum+','+volume+','+optionNum+';'+"</div>"+
				"<div class='cart-menu'>"+
					'<p>' + menuNmae + "</p>" + 
					'<p>' + optionStr + "</p>" + 
					"<div class='row row-cols-2 border-bottom' style='width:100%;'>" + 
					"<div class='col'>" + menuPrice[0] + " 원</div>" + 
					"<div class='col' name='volume'>" +  volume + "개</div>" +
					"</div>"+
				"</div>"
		);
		
		$('#total-price').text(cart_totalPrice + '원');
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
	
	
	//자식객체 갯수 가져오기(연습-- 이미 담은 메뉴를 또 담을 시 수량 변경 ==== 보류)
	function childLength(){
		var length = $('#cart-body').children().length;
		console.log('자식객체 수 : ' + length);
	}
	
	//전체삭제 함수
	function delChild(){
		//장바구니의 자식객체 없애기
		$('#cart-body').empty();
		$('#cart-body').children().remove();
		//총 금액 초기화
		$('#total-price').text('선택된 메뉴가 없습니다');
	}
	
	//장바구니 요소 더블클릭시 삭제하는 함수
	$('#cart').on('dblclick','.cart-menu',function(){
		console.log($(this).children('div').text()); //클릭한 요소의 자식 요소 중 div의 텍스트값을 가져오라는 뜻
		var price = parseInt($(this).children('div').text().split('원')[0]);
		var volume = parseInt($(this).children('div').text().split('원')[1]);
		var delPrice =parseInt(price);
		var orgPrice = parseInt($('#total-price').text());
		if((orgPrice-delPrice)===0){
			cart_totalPrice = 0
			$('#total-price').text('선택된 메뉴가 없습니다');
		}else{
			$('#total-price').text((orgPrice-delPrice));
		}
		console.log('총 금액  후: ' + $('#total-price').text());
		$(this).prev().text('');
		$(this).remove();
	});
	
	//주문하기 누르면 실행되는 함수
	$('#orderBtn').click(function(){
		console.log('주문 리스트 : '+$('#cart-body').find('.list').text()); //주문 리스트(메뉴 번호, 수량, 옵션번호) 가져오기
		var orderList = $('#cart-body').find('.list').text();
		var split1 = $('#cart-body').find('.list').text().split(';');
		console.log(split1);
		var split2 = '';
			
		for(var i=0; i<split1.length-1; i++){ //담은 메뉴의 수만큼 행이 나오도록 length의 길이를 조절했음
			console.log('split1 값 : ' + split1[i]);
			split2 = split1[i].split(',');
			console.log('split2 크기 : ' + split2.length);
			for(var j=0; j<split2.length; j++){
				console.log('순서' + split2[j]);
			}
		}
		
		var lastPrice = parseInt($('#total-price').text()); //주문하기 직전 장바구니 총 금액
		var minPrice = parseInt(${info.min_price }); //최소 주문금액
		
		if(lastPrice>=minPrice){
			location.href="${pageContext.request.contextPath}/member/orderPage?orderList=" + orderList + "&memberId='${sessionScope.memberId}'&shopNum=" + ${info.num} + "&lastPrice="+lastPrice;
			//${pageContext.request.contextPath }
		}else{
			alert('최소 주문금액보다 적습니다');
		}
	});
	
</script>
