<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div style="margin: auto; margin-top: 100px; padding: auto; width: 80%;">
	<!-- 주문승인 된거-> 배달목록 -->
	<div style="float: left; margin: 10px; width: 40%; border: 1px solid red;">
	
		<h1 style="text-align: center;">배달요청목록</h1>
		<input type="button" style="float: right; margin: 10px;" onclick="OrderList()" 
			class="btn btn-primary" value="새로고침">
			
		<div id="orderListContainer" style="margin: auto;">
		
		</div>
	</div>
	<!-- 라이더가 받은 주문목록 -->
	<div style="float:right; margin: 10px; width: 40%; border: 1px solid blue;">
		<h1 style="text-align: center;">배달승인목록</h1>
		<div id="AcceptListContainer" style="margin: auto;">
		</div>
	</div>
</div>
<script>

OrderList();

// 주문승인된 주문목록
function OrderList(){
	$("#orderListContainer").empty();	
	$.ajax({
		url: "/delivery/rider/riderorderList",
		success:function(data){
			if(data != null){ 
				$(data).each(function(i, val){
					let html = "";
					html += "<div style='margin: 10px;'>";
					html += "<h1>주문시간:"+new Date(val.start_time)+"</h1>";
					html += "<h1>도착예정시간:"+val.end_ex_time+"</h1>";
					html += "<span>고객주소번호: "+val.addr_num+"</span>";
					html += "<span>상세주소: "+val.addr_detail+"</span>";
					html += "<input type='button' class='btn btn-primary' value='배달정보' name='riderDeliveryInfo'>"
					html += "</div>";
					$("#orderListContainer").append(html);					
				});
			}
		}
	});
}

riderSuccessList();

// 라이더가 승인받은 주문목록
function riderSuccessList(){
	$.ajax({
		url: "/delivery/rider/acceptList",
		data: {num:${sessionScope.riderNum}},
		success:function(data){
			if(data != null){
				$(data).each(function(i,val){
					let html = "";
					html += "<div style='margin: 10px;'>";
					html += "<h1>"+val.num+"</h1>";
					html += "</div>";
					$("#AcceptListContainer").append(html);
				});
			}
		}
	});
}
</script>