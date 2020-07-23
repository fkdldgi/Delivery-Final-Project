<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<div class="container" style="margin-top:50px ; margin-bottom: 50px;">
 <img class="d-block mx-auto mb-4" src="/delivery/resources/images/personalQna_logo.png" width="900" height="150">
	<table class="table">
	  <thead>
	    <tr>
	      <th scope="col">No.</th>
	      <th scope="col">제목</th>
	      <th scope="col">작성일</th>
	    </tr>
	  </thead>
	  <tbody>
	    <c:forEach var="vo" items="${list}"> <!-- list있는 값들 -->
		<tr>
			<td>${vo.num}</td>
			<td><a href="/delivery/member/detail?num=${vo.num }">${vo.title}</a></td>
			<fmt:formatDate value="${vo.regdate }" pattern="yyyy-MM-dd" var="regdate"/>
			<td>${regdate}</td>
		</tr>
	</c:forEach>
	  </tbody>
</table>
<!-- 이전,다음 -->
<div>
	<c:forEach var="i" begin="${pu.startPageNum }" end="${pu.endPageNum }">
		<c:choose>
			<c:when test="${i==pu.pageNum}">
				<a href="/delivery/member/QnaList?pageNum=${i}&memberNum=${sessionScope.memberNum}">
				<span style="color:blue">${i }</span>
				</a>
			</c:when>
			<c:otherwise>
				<a href="/delivery/member/QnaList?pageNum=${i}&memberNum=${sessionScope.memberNum}">
				<span style="color:gray">${i }</span>
				</a>
			</c:otherwise>
		</c:choose>
	</c:forEach>
</div>
</div>
</body>
</html>