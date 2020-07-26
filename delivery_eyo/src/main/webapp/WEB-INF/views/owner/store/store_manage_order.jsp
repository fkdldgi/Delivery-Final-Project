<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" src="/delivery/resources/js/jquery-ui.js"></script>
<style>

</style>
<script>
	$(document).ready(function(){
		
		// 상세보기 버튼		
		$("input[name='show_detail']").on('click',function(){
			var aa = $(this).parent().parent().next();
			aa.animate({				
				height: 'toggle'
			});
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
			<form method="post" action="/delivery/owner/store_manage/order_accept?num=${vo.num }">
				<input type="text" name="main_num" value="${list.main_num }" hidden="hidden">
				
				<div style="border: 1px solid lightgray; margin: 10px; margin-top: 30px; margin-bottom: 0px; padding: 20px;">
					<h2 style="margin-bottom: 10px;">주문 메뉴: &nbsp; &nbsp; &nbsp;${list.menu_name }</h2>
					<h3 style="margin-top: 10px; margin-bottom: 10px;">가격: &nbsp; &nbsp; &nbsp;${list.total_price }</h3>
					<h3 style="margin-top: 10px;">주문시간: &nbsp; &nbsp; &nbsp;${list.start_time }</h3>
					<div style="width: 100%; text-align: right;">
						<input type="button" name="show_detail" class="btn btn-primary" value="상세보기">
					</div>
				</div>
				<div style="border: 1px solid lightgray; border-top: 0px; margin: 10px; margin-top: 0px; padding: 10px; display: none;">
					<h3 style="margin: 10px;">예상 소요시간</h3>
					<div style="margin: auto; padding: auto;" class="btn-group btn-group-toggle" data-toggle="buttons">
						<label class="btn btn-outline-primary btn-lg" style="margin-left: 10px; border-radius: 5px;">
							<input type="radio" name="end_ex_time" value="30" required="required">30분
						</label>
						<label class="btn btn-outline-primary btn-lg" style="margin-left: 10px; border-radius: 5px;">
							<input type="radio" name="end_ex_time" value="60">60분
						</label>
						<label class="btn btn-outline-primary btn-lg" style="margin-left: 10px; border-radius: 5px;">
							<input type="radio" name="end_ex_time" value="90">90분
						</label>
						<label class="btn btn-outline-primary btn-lg" style="margin-left: 10px; border-radius: 5px;">
							<input type="radio" name="end_ex_time" value="120">120분
						</label>
					</div>
					<br>
					<br>
					<h3 style="margin: 10px;">요청사항</h3>
					<div style="margin: auto; padding: auto;">
						<p style="margin-left: 30px;">
							<c:choose>
								<c:when test="${empty list.owner_requests }">
									요청사항이 없습니다.								
								</c:when>
								<c:otherwise>
									${list.owner_requests }
								</c:otherwise>
							</c:choose>
						</p>
					</div>
					<br>
					<h3 style="magin: 10px; margin-left: 10px; margin-bottom: 0px;" >개수: &nbsp; &nbsp; &nbsp; ${list.count }</h3>
					<div style="padding: 0px; margin-bottom: 10px; margin-right: 10px; text-align: right;">
						<input class="btn btn-primary" type="submit" name="accept" value="주문승인">
					</div>
				</div>
			</form>
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
		<input type="text" value="${list.start_time }">
		<input type="text" value="${list.end_ex_time }">
	</c:forEach>
</body>
























