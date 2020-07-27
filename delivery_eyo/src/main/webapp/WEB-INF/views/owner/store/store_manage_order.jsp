<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" src="/delivery/resources/js/jquery-ui.js"></script>
<style>

</style>
<script>
	$(document).ready(function(){
		
		// 상세보기 버튼
		$("input[name=show_detail]").onclick(function(){
			
		});
	});

</script>
<body>
	<div style="margin: auto; padding: auto; text-align: center;">
		<img src="/delivery/resources/images/owner_order.png" style="width: 750px; height: 200px;">
	</div>
	
	<!-- 가게에 들어온 주문 확인하기 -->
	<div style="margin: auto; padding: auto; width: 80%;">
		<c:forEach var="list" items="${orderList }">
			<div style="border: 1px solid black; margin: 10px; margin-top: 30px; padding: 10px;">
				<h2>주문 메뉴: &nbsp; &nbsp; &nbsp;${list.menu_name }</h2>
				<h3>위치: &nbsp; &nbsp; &nbsp;${list.addr_num }(${list.addr_detail })</h3>
				<span>주문시간: &nbsp; &nbsp; &nbsp;${list.start_time }</span>
				<div style="width: 100%; text-align: right;">
					<input type="button" name="show_detail" class="btn btn-primary" value="상세보기">
				</div>
			</div>
		</c:forEach>
	</div>
	<!-- 
				<input type="text" value="${list.main_num }">
				<input type="text" value="${list.start_time }">
				<input type="text" value="${list.end_ex_time }">
				<input type="text" value="${list.status }">
				<input type="text" value="${list.owner_requests }">
				<input type="text" value="${list.total_price }">
				<input type="text" value="${list.order_price }">
				<input type="text" value="${list.count }">
				<input type="text" value="${list.menu_name }">
				<input type="text" value="${list.price }">
				<input type="text" value="${list.menu_option_name }"><br>
	 -->
	
	<!-- 가게주문 승인 리스트 -->
	<c:forEach var="list" items="${successList }">
	
	</c:forEach>
</body>
























