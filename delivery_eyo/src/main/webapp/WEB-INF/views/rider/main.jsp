<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<body>
<!-- 배달완료인지, 승인목록인지 변경하는 버튼 -->
<div style="margin: auto; margin-bottom: 0px; padding: auto; width: 80%">
	<div style="float: right; margin: 10px; width: 40%;">
		<input type="button" class="btn btn-primary" value="배달완료목록 보기" id="show_successList">
		<input type="button" class="btn btn-primary" value="배달승인목록 보기" id="show_acceptList" style="display: none;">
	</div>
</div>
<div style="margin: auto; margin-top: 100px; padding: auto; width: 80%;">
	<!-- 주문승인 된거-> 배달목록 -->
	<div style="float: left; margin: 10px; width: 40%; border: 1px solid black;">
		<img style="width: 100%; height: 48px;" src="/delivery/resources/images/OrderList.png">
		<input type="button" style="float: right; margin: 10px;" onclick="OrderList()" 
			class="btn btn-primary" value="새로고침">
		<br>
		<br>
		<br>
		<!-- 주문승인목록 전체 감싸는 div -->
		<div id="orderListContainer" style="margin: 10px; margin-left: 15px;">
		</div>
	</div>
	<!-- 라이더가 받은 주문목록 -->
	<div style="float:right; margin: 10px; width: 40%; border: 1px solid black; display: block;" id="riderAcceptList">
		<img style="width: 100%; height: 48px;" src="/delivery/resources/images/AcceptList.png">
		
		<!-- 배달승인목록 전체 감싸는 div -->
		<div id="AcceptListContainer" style="margin: auto;">
		</div>
	</div>
	
	<!-- 배달완료한 목록 -->
	<div style="float: right; margin: 10px; width: 40%; border: 1px solid black; display: none;" id="riderSuccessList">
		<img style="width: 100%; height: 48px;" src="/delivery/resources/images/SuccessList.png">
		
		<!-- 배달완료목록 전체 감싸는 div -->
		<div id="SuccessListContainer" style="margin: auto;">		
		</div>
	</div>
</div>
<br><br><br>
<br><br><br>
<br><br><br>
</body>
<script>
// 주문승인된 주문목록 띄워주기
OrderList();
// 라이더가 받은 배달승인목록 띄워주기
riderAcceptList();

// 배달완료목록 보기
$("#show_successList").on('click',function(){
	
	$(this).css('display','none');
	$("#show_acceptList").css('display','block');
	
	// 배달승인목록 숨기기
	$("#riderAcceptList").css('display','none');
	// 배달완료목록 띄우기
	$("#riderSuccessList").css('display','block');
	riderSuccessList();
});

// 배달승인목록 보기
$("#show_acceptList").on('click',function(){
	
	$(this).css('display','none');
	$("#show_successList").css('display','block');
	
	// 배달승인목록 띄우기
	$("#riderAcceptList").css('display','block');
	// 배달완료목록 숨기기
	$("#riderSuccessList").css('display','none');
	riderAcceptList();
});

// 주문승인된 주문목록
function OrderList(){
	$("#orderListContainer").empty();	
	$.ajax({
		url: "/delivery/rider/riderorderList",
		success:function(data){
			if(data != null){ 
				$(data).each(function(i, val){
					let html = "";
					// 전체 감싸는 div(상세보기 누르면 나오는 div까지)
					html += "<div style='border: 1px solid #B8E9FF; margin-bottom: 10px;'>";
					
					// 처음에 보여지는 div(button포함)
					html += "<div style='margin: 0px; padding: 0px;'>";
					
					// 주문시간
					html += "<div class='row' style='margin: 10px;'>";
					html += "<span class='col-xs-6 col-md-4' style='text-align: left; font-size: x-large;'>주문시간 &nbsp;:</span>";
					html += "<span style='text-align: center; font-size: x-large;'>"+val.start_time+"</span>";
					html += "</div>";
					
					// 배달예정시간
					html += "<div class='row' style='margin: 10px;'>";
					html += "<span class='col-xs-6 col-md-4' style='text-align: left; font-size: x-large;'>배달예정시간 &nbsp;:</span>";
					html += "<span style='text-align: center; font-size: x-large;'>"+val.ex_time+"</span>";
					html += "</div>";
					
					// 가게명
					html += "<div class='row' style='margin: 10px;'>";
					html += "<span class='col-xs-6 col-md-4' style='text-align: left; font-size: x-large;'>가게명 &nbsp;:</span>";
					html += "<span style='text-align: center; font-size: x-large;'>"+val.shop_name+"</span>";
					html += "</div>";
					
					// 가게 전화번호
					html += "<div class='row' style='margin: 10px;'>";
					html += "<span class='col-xs-6 col-md-4' style='text-align: left; font-size: x-large;'>가게 전화번호 &nbsp;:</span>";
					html += "<span style='text-align: center; font-size: x-large;'>"+val.shop_phone+"</span>";
					html += "</div>";
					
					// 가게주소
					html += "<div class='row' style='margin: 10px;'>";
					html += "<span class='col-xs-6 col-md-4' style='text-align: left; font-size: x-large;'>가게 주소 &nbsp;:</span>";
					html += "<span style='text-align: center; font-size: x-large;'>"+val.shop_addr+"("+val.shop_address_detail+")</span>";
					html += "</div>";
					
					// 거래금액
					html += "<div class='row' style='margin: 10px;'>";
					html += "<span class='col-xs-6 col-md-4' style='text-align: left; font-size: x-large;'>거래금액 &nbsp;:</span>";
					html += "<span style='text-align: center; font-size: x-large;'>"+val.total_price+"</span>";
					html += "</div>";
					
					if(val.requests != null){
						// 요청사항
						html += "<div class='row' style='margin: 10px;'>";
						html += "<span class='col-xs-6 col-md-4' style='text-align: left; font-size: x-large;'>요청사항 &nbsp;:</span>";
						html += "<span style='text-align: center; font-size: x-large;'>"+val.requests+"</span>";
						html += "</div>";
					}else{
						// 요청사항이 없을 때
						html += "<div class='row justify-content-center' style='margin: 10px;'>";
						html += "<span class='text-danger' style='text-align: center; font-size: x-large;'>요청사항이 없습니다.</span>";
						html += "</div>";
					}
					
					// 상세보기 버튼
					html += "<div class='row-fluid' style='margin: 10px;'>";
					html += "<input type='button' value='상세보기' name='delivery_detail' class='btn btn-primary'>";
					html += "</div>";
					html += "</div>";
					
					// 상세보기 버튼 눌렀을때 나타나는 div
					html += "<div style='display: none;'>";
					
					// 받는사람이름
					html += "<div class='row' style='margin: 10px;'>";
					html += "<span class='col-xs-6 col-md-4' style='text-align: left; font-size: x-large;'>받는사람 이름 &nbsp;:</span>";
					html += "<span style='text-align: center; font-size: x-large;'>"+val.member_name+"</span>";
					html += "</div>";
					
					// 받는사람 전화번호
					html += "<div class='row' style='margin: 10px;'>";
					html += "<span class='col-xs-6 col-md-4' style='text-align: left; font-size: x-large;'>전화번호 &nbsp;:</span>";
					html += "<span style='text-align: center; font-size: x-large;'>"+val.member_phone+"</span>";
					html += "</div>";
					
					// 배달지
					html += "<div class='row' style='margin: 10px;'>";
					html += "<span class='col-xs-6 col-md-4' style='text-align: left; font-size: x-large;'>배달지 &nbsp;:</span>";
					html += "<span style='text-align: center; font-size: x-large;'>"+val.member_building_number+"("+val.member_address_detail+")</span>";
					html += "</div>";
					
					// 배달승인 버튼
					html += "<div class='row' style='margin: 10px;'>";
					html += "<input type='button' value='배달승인' name='delivery_accept' class='btn btn-primary'>";
					html += "<input type='text' value='"+val.om_num+"' name='delivery_num' hidden='hidden'>";
					html += "</div>";
					html += "</div>";
					
					
					html += "</div>";
					$("#orderListContainer").append(html);					
				});
			}
		}
	});
} 

// 라이더가 승인받은 주문목록
function riderAcceptList(){
	$("#AcceptListContainer").empty();
	$.ajax({
		url: "/delivery/rider/acceptList",
		data: {num:${sessionScope.riderNum}},
		success:function(data){
			if(data != null){
				$(data).each(function(i,val){
					let html = "";
					html += "<div style='border: 1px solid #B8E6E1; margin: 10px;'>";
					
					html += "<div style='margin: 0px; padding: 0px;'>";
					
					// 라이더가 승인받은 가게명
					html += "<div class='row' style='margin: 10px;'>";
					html += "<span class='col-xs-6 col-md-4' style='text-align: left; font-size: x-large;'>가게명 &nbsp;:</span>";
					html += "<span style='text-align: center; font-size: x-large;'>"+val.shop_name+"</span>";
					html += "</div>";
					
					// 승인받은 가게 전화번호
					html += "<div class='row' style='margin: 10px;'>";
					html += "<span class='col-xs-6 col-md-4' style='text-align: left; font-size: x-large;'>가게 전화번호 &nbsp;:</span>";
					html += "<span style='text-align: center; font-size: x-large;'>"+val.shop_phone+"</span>";
					html += "</div>";
					
					// 승인받은 가게주소
					html += "<div class='row' style='margin: 10px;'>";
					html += "<span class='col-xs-6 col-md-4' style='text-align: left; font-size: x-large;'>가게 주소 &nbsp;:</span>";
					html += "<span style='text-align: center; font-size: x-large;'>"+val.shop_addr+"("+val.shop_address_detail+")</span>";
					html += "</div>";
					
					// 승인받은 거래금액
					html += "<div class='row' style='margin: 10px;'>";
					html += "<span class='col-xs-6 col-md-4' style='text-align: left; font-size: x-large;'>거래금액 &nbsp;:</span>";
					html += "<span style='text-align: center; font-size: x-large;'>"+val.total_price+"</span>";
					html += "</div>";
					
					if(val.requests != null){
						// 승인받은 요청사항
						html += "<div class='row' style='margin: 10px;'>";
						html += "<span class='col-xs-6 col-md-4' style='text-align: left; font-size: x-large;'>요청사항 &nbsp;:</span>";
						html += "<span style='text-align: center; font-size: x-large;'>"+val.requests+"</span>";
						html += "</div>";
					}else{
						// 승인받은 요청사항이 없을 때
						html += "<div class='row justify-content-center' style='margin: 10px;'>";
						html += "<span class='text-danger' style='text-align: center; font-size: x-large;'>요청사항이 없습니다.</span>";
						html += "</div>";
					}
					
					// 승인받은 주문시간
					html += "<div class='row' style='margin: 10px;'>";
					html += "<span class='col-xs-6 col-md-4' style='text-align: left; font-size: x-large;'>주문시간 &nbsp;:</span>";
					html += "<span style='text-align: center; font-size: x-large;'>"+val.start_time+"</span>";
					html += "</div>";
					
					// 승인받은 도착예정시간
					html += "<div class='row' style='margin: 10px;'>";
					html += "<span class='col-xs-6 col-md-4' style='text-align: left; font-size: x-large;'>배달예정시간 &nbsp;:</span>";
					html += "<span style='text-align: center; font-size: x-large;'>"+val.ex_time+"</span>";
					html += "</div>";
					
					// 승인받은 목록 상세보기 버튼
					html += "<div class='row-fluid' style='margin: 10px;'>";
					html += "<input type='button' value='상세보기' name='delivery_Acceptdetail' class='btn btn-primary'>";
					html += "</div>";					
					html += "</div>"
					
					// 상세보기 버튼 눌렀을때 나타나는 div
					html += "<div style='display: none;'>";
					
					// 승인받은 주문자 전화번호 
					html += "<div class='row' style='margin: 10px;'>";
					html += "<span class='col-xs-6 col-md-4' style='text-align: left; font-size: x-large;'>전화번호 &nbsp;:</span>";
					html += "<span style='text-align: center; font-size: x-large;'>"+val.member_phone+"</span>";
					html += "</div>";
					
					// 승인받은 배달지
					html += "<div class='row' style='margin: 10px;'>";
					html += "<span class='col-xs-6 col-md-4' style='text-align: left; font-size: x-large;'>배달지 &nbsp;:</span>";
					html += "<span style='text-align: center; font-size: x-large;'>"+val.member_building_number+"("+val.member_address_detail+")</span>";
					html += "</div>";
					
					html += "<div class='row-fluid' style='margin: 10px;'>";
					html += "<input type='button' value='배달완료' name='closeAcceptDetail' class='btn btn-primary'>";
					html += "<input type='text' value='"+val.om_num+"' hidden='hidden'>";
					html += "</div>";
					html += "</div>";					
					
					html += "</div>";
					$("#AcceptListContainer").append(html);
				});
			}
		}
	});
}

function riderSuccessList(){
	$("#SuccessListContainer").empty();
	$.ajax({
		url: "/delivery/rider/successList",
		data: {num:${sessionScope.riderNum}},
		success:function(data){
			if(data != null){
				$(data).each(function(i,val){
					let html = "";
					html += "<div style='border: 1px solid #E0BFE6; margin: 10px;'>";
					html += "<div style='margin: 0px; padding: 0px;'>";
					
					// 라이더가 승인받은 가게명
					html += "<div class='row' style='margin: 10px;'>";
					html += "<span class='col-xs-6 col-md-4' style='text-align: left; font-size: x-large;'>가게명 &nbsp;:</span>";
					html += "<span style='text-align: center; font-size: x-large;'>"+val.shop_name+"</span>";
					html += "</div>";
					
					// 승인받은 가게 전화번호
					html += "<div class='row' style='margin: 10px;'>";
					html += "<span class='col-xs-6 col-md-4' style='text-align: left; font-size: x-large;'>가게 전화번호 &nbsp;:</span>";
					html += "<span style='text-align: center; font-size: x-large;'>"+val.shop_phone+"</span>";
					html += "</div>";
					
					// 승인받은 가게주소
					html += "<div class='row' style='margin: 10px;'>";
					html += "<span class='col-xs-6 col-md-4' style='text-align: left; font-size: x-large;'>가게 주소 &nbsp;:</span>";
					html += "<span style='text-align: center; font-size: x-large;'>"+val.shop_addr+"("+val.shop_address_detail+")</span>";
					html += "</div>";
					
					// 승인받은 거래금액
					html += "<div class='row' style='margin: 10px;'>";
					html += "<span class='col-xs-6 col-md-4' style='text-align: left; font-size: x-large;'>거래금액 &nbsp;:</span>";
					html += "<span style='text-align: center; font-size: x-large;'>"+val.total_price+"</span>";
					html += "</div>";
					
					if(val.requests != null){
						// 승인받은 요청사항
						html += "<div class='row' style='margin: 10px;'>";
						html += "<span class='col-xs-6 col-md-4' style='text-align: left; font-size: x-large;'>요청사항 &nbsp;:</span>";
						html += "<span style='text-align: center; font-size: x-large;'>"+val.requests+"</span>";
						html += "</div>";
					}else{
						// 승인받은 요청사항이 없을 때
						html += "<div class='row justify-content-center' style='margin: 10px;'>";
						html += "<span class='text-danger' style='text-align: center; font-size: x-large;'>요청사항이 없습니다.</span>";
						html += "</div>";
					}
					
					// 승인받은 주문시간
					html += "<div class='row' style='margin: 10px;'>";
					html += "<span class='col-xs-6 col-md-4' style='text-align: left; font-size: x-large;'>주문시간 &nbsp;:</span>";
					html += "<span style='text-align: center; font-size: x-large;'>"+val.start_time+"</span>";
					html += "</div>";
					
					// 승인받은 도착예정시간
					html += "<div class='row' style='margin: 10px;'>";
					html += "<span class='col-xs-6 col-md-4' style='text-align: left; font-size: x-large;'>배달예정시간 &nbsp;:</span>";
					html += "<span style='text-align: center; font-size: x-large;'>"+val.ex_time+"</span>";
					html += "</div>";
					
					// 승인받은 목록 상세보기 버튼
					html += "<div class='row-fluid' style='margin: 10px;'>";
					html += "<input type='button' value='상세보기' name='delivery_Acceptdetail' class='btn btn-primary'>";
					html += "</div>";					
					html += "</div>"
					
					// 상세보기 버튼 눌렀을때 나타나는 div
					html += "<div style='display: none;'>";
					
					// 승인받은 주문자 전화번호 
					html += "<div class='row' style='margin: 10px;'>";
					html += "<span class='col-xs-6 col-md-4' style='text-align: left; font-size: x-large;'>전화번호 &nbsp;:</span>";
					html += "<span style='text-align: center; font-size: x-large;'>"+val.member_phone+"</span>";
					html += "</div>";
					
					// 승인받은 배달지
					html += "<div class='row' style='margin: 10px;'>";
					html += "<span class='col-xs-6 col-md-4' style='text-align: left; font-size: x-large;'>배달지 &nbsp;:</span>";
					html += "<span style='text-align: center; font-size: x-large;'>"+val.member_building_number+"("+val.member_address_detail+")</span>";
					html += "</div>";
					html += "</div>";					
					
					html += "</div>";
					$("#SuccessListContainer").append(html);
				});
			}
		}
	});
}

//상세보기 버튼	
$("#orderListContainer").on('click',"input[name='delivery_detail']",function(){
	var aa = $(this).parent().parent().next();
	aa.animate({				
		height: 'toggle'
	});
});

// 배달승인 버튼
$("#orderListContainer").on('click',"input[name='delivery_accept']",function(){
	// 주문번호 가져오기
	var om_num = $(this).next().val();
	
	$.ajax({
		url: "/delivery/rider/accept",
		data: {om_num:om_num, rider_num:${sessionScope.riderNum}},
		success:function(){
			// 배달목록 새로고침
			OrderList();
			// 배달승인목록 새로고침
			riderSuccessList();
		}
	});
});

// 배달승인 상세보기
$("#AcceptListContainer").on('click',"input[name='delivery_Acceptdetail']",function(){
	var aa = $(this).parent().parent().next();
	aa.animate({
		height: 'toggle'
	});
});

// 배달완료
$("#AcceptListContainer").on('click',"input[name='closeAcceptDetail']",function(){
	// 주문번호 가져오기
	var om_num = $(this).next().val();
	
	$.ajax({
		url: "/delivery/rider/success",
		data: {om_num:om_num, rider_num:${sessionScope.riderNum}},
		success:function(){
			// 배달목록 새로고침
			OrderList();
			// 배달승인목록 새로고침
			riderSuccessList();
		}
	});
});
</script>