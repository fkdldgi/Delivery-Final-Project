<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" src="/delivery/resources/js/jquery-3.5.1.js"></script>

<!-- 가게목록 첫화면 불러오기 -->
<div id="storeWrap" style="width: 70%; margin: auto;">
	<c:forEach var="list" items="${list }">
		<div class="media position-relative"
			style="border: 1px solid gray; margin-top: 10px; margin-bottom: 10px;">
			<img
				src="http://www.seoulfn.com/news/photo/201809/319058_113243_2622.gif"
				style="width: 20%; height: 100px;" class="mr-3">
			<div class="media-body">
				<p><h5 class="mt-0">${list.name}</h5></p>
				<p>최소 결제금액 : ${list.min_price }원</p>
				<p> ${list.info }</p>
				<p> 전화번호 : ${list.reg_num }</p>
				<p>리뷰 수 : 120 | 별점  : 4.2</p>
				<p>가게번호 :  ${list.num}</p>
				<a href="/delivery/member/storeDetail?num=${list.num }&owner_num=${list.owner_num }&memberNum=${sessionScope.memberNum }" class="stretched-link"></a>
			</div>
		</div>
	</c:forEach>
</div>


<!-- 가게목록 무한스크롤 불러오기 -->
<script type="text/javascript">
	var startrow = 1;
	$(window).scroll(function() {
	    if ($(window).scrollTop() == $(document).height() - $(window).height()) {
	    	console.log($(document).height());
	    	console.log($(window).height());
	    	startrow = startrow + 5;
	    	 $.ajax({
	    	        url: "/delivery/member/storeList1",
	    	        type: "post",
	    	        data: JSON.stringify(startrow),
	    	        dataType: "json",
	    	        contentType: "application/json",
	    	        success: function(data) {
	    	        	$(data).each(function(i,list){
							var str = 	"<div class='media position-relative'" +
							"style='border: 1px solid gray; margin-top: 10px; margin-bottom: 10px;'>" +
							"<img src='http://www.seoulfn.com/news/photo/201809/319058_113243_2622.gif'" +
								"style='width: 20%; height: 100px;' class='mr-3'>" +
							"<div class='media-body'>" +
								"<p><h5 class='mt-0'>" + list.name + "</h5></p>" +
								"<p>최소 결제금액 : " + list.min_price + "원</p>" + 
								"<p>전화번호 : " + list.reg_num + "</p>" +
								"<p>리뷰 수 : 120 | 별점  : 4.2</p> " +	
								"<p>가게번호 : " + list.num + "</p> " +
								"<a href='/delivery/member/storeDetail?num=" + list.num +"&owner_num=" + list.owner_num +"&memberNum=${sessionScope.memberNum}' class='stretched-link'></a>" +
							"</div>" +
						"</div>";
							$("#storeWrap").append(str);
						});  
	    	        },error: function(errorThrown) {
					alert(errorThrown.statusText);
				}
			});
		}
	});
</script>