<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>orderList.jsp</title>
</head>
<body>
<div class="container">
<br>
	<img src="/delivery/resources/images/myorderlist_logo.png" width="800" height="150" style="margin-left: 150px">
<br>

</div>
<div class="container" >
<div class="row no-gutters bg-light position-relative" style="border:1px soild darkgray; ">
<!-- 사진 클릭시 해당 가게로 이동하게 함. -->
<c:forEach var="list" items= "${list1}">
  <div class="col-md-6 mb-md-0 p-md-4">
  <hr style="border: 1px solid darkgray;">
    <img src="${pageContext.request.contextPath }/resources/images/${list.PROFILE_IMG}" class="w-100" alt="/delivery/member/storeDetail">
  </div>
  <div class="col-md-6 position-static p-4 pl-md-0">
  <hr style="border: 1px solid darkgray;">
    <h5 class="mt-0">${list.SHOPNAME}</h5>
    <p>주문 메뉴</p><br>
    <p>${list.NAME}</p>
    <p>옵션메뉴 메뉴</p><br>
    <span style="color: blue">${list.OPTIONNAME}</span>
    <p>결제가격</p><br>
    <span style="color: blue">${list.TOTAL_PRICE}원</span>
    <p>주문일시</p><br>
    <fmt:formatDate pattern="yyyy/mm/dd" value="${list.START_TIME}"/>
    <a href="/delivery/member/storeDetail?num=${list.SHOP_NUM}&owner_num=${list.OWNER_NUM}&memberNum=${sessionScope.memberNum}">리뷰 작성하러 가기</a><!-- 리뷰작성창에 name 속성을 넣어야 함. -->
  </div>
</c:forEach>
</div>
</div>
</body>
</html>