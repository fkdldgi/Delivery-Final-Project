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
<div class="row no-gutters bg-light position-relative">
<!-- 사진 클릭시 해당 가게로 이동하게 함. -->
  <div class="col-md-6 mb-md-0 p-md-4">
    <img src="..." class="w-100" alt="...">
  </div>
  <div class="col-md-6 position-static p-4 pl-md-0">
    <h5 class="mt-0"><!--가게이름 --></h5>
    <p><!-- 주문한 내역 내용 나옴 상품이름,수량,주문일시,가격 보이게 --></p>
    <a href="#target" class="stretched-link">리뷰 작성하러 가기</a><!-- 리뷰작성창에 name 속성을 넣어야 함. -->
  </div>
</div>
</body>
</html>