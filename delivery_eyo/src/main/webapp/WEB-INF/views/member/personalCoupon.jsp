<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div class="container" style="text-align: center;">
<br>
	<img src="/delivery/resources/images/mycoupon_logo.png" width="800" height="150" style="margin-top: 50px">
<br>
<hr style="1px soild darkgray">
	<img src="/delivery/resources/images/canusecoupon01.png" width="200" height="100">
<hr style="1px soild darkgray">
<!-- 사용가능한 쿠폰 리스트 뽑아오기  st=2 -->
<c:forEach var="list" items= "${list1}">
	<c:choose>
		<c:when test="${list.STATUS==2}">
			<div class="media">
  				<img src="/delivery/resources/images/coupon_mini.png" class="mr-3">
  				<div class="media-body">
  				  <h5 class="mt-0">${list.NAME}</h5>
				    쿠폰명 : ${list.NAME}<br>
				    할인가격 : ${list.DISCOUNT_PRICE}원
				    최소주문금액 : ${list.MIN_PRICE}원
				    기간 :<fmt:formatDate pattern="yyyy/MM/dd" value="${list. ENDDATE}"/>
				<hr style="1px soild darkgray">
 	 		</div>
		</div>
		</c:when>
	</c:choose>
</c:forEach>
<!-- 사용가능한 쿠폰에서 쿠폰이 얼마 할인되는 건지, 사용가능한 날짜, 최소주문 금액 보여주기 -->
<hr style="1px soild darkgray">
<img src="/delivery/resources/images/usedcoupon01.png" width="200" height="100">
<hr style="1px soild darkgray">
<c:forEach var="list" items= "${list1}">
	<c:choose>
		<c:when test="${list.STATUS==1}">
			<div class="media">
  				<img src="/delivery/resources/images/coupon_mini.png" class="mr-3">
  				<div class="media-body">
  				  <h5 class="mt-0">${list.NAME}</h5>
				    쿠폰명 : ${list.NAME}<br>
				    할인가격 : ${list.DISCOUNT_PRICE}원
				    최소주문금액 : ${list.MIN_PRICE}원
				    기간 :<fmt:formatDate pattern="yyyy/MM/dd" value="${list. ENDDATE}"/>
				<hr style="1px soild darkgray">
 	 		</div>
		</div>
		</c:when>
	</c:choose>
</c:forEach>
<!-- 사용한 쿠폰 리스트 뽑아오기 st=1-->
<hr style="1px soild darkgray">
	<img src="/delivery/resources/images/cantusecoupon01.png" width="200" height="100">
	<hr style="1px soild darkgray">
<c:forEach var="list" items= "${list1}">
	<c:choose>
		<c:when test="${list.STATUS==0}">
			<div class="media">
  				<img src="/delivery/resources/images/coupon_mini.png" class="mr-3">
  				<div class="media-body">
  				  <h5 class="mt-0">${list.NAME}</h5>
				    쿠폰명 : ${list.NAME}<br>
				    할인가격 : ${list.DISCOUNT_PRICE}원
				    최소주문금액 : ${list.MIN_PRICE}원
				    기간 :<fmt:formatDate pattern="yyyy/MM/dd" value="${list. ENDDATE}"/>
				<hr style="1px soild darkgray">
 	 		</div>
		</div>
		</c:when>
	</c:choose>
</c:forEach>
<!-- 기간만료 리스트 뽑아오기-->
<hr style="1px soild darkgray">
</div>
<script type="text/javascript">
</script>
</body>
</html>