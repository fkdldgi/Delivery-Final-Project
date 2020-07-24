<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div class="container">
 <img class="d-block mx-auto mb-4" src="/delivery/resources/images/notice_logo.png" width="700" height="150">
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
				<a href="/delivery/member/notice?pageNum=${i}&field=${field}&keyword=${keyword}">
				<span style="color:blue">${i }</span>
				</a>
			</c:when>
			<c:otherwise>
				<a href="/delivery/member/notice?pageNum=${i}&field=${field}&keyword=${keyword}">
				<span style="color:gray">${i }</span>
				</a>
			</c:otherwise>
		</c:choose>
	</c:forEach>
</div>
<div>
	<form method="post" action="/delivery/member/notice">
		<select name="field">
			<option value="title"
			<c:if test="${field=='title' }">seleted</c:if>>제목</option>
			<option value="content"
			<c:if test="${field=='content' }">seleted</c:if>>내용</option>
		</select>
		<input type="text" name="keyword">
		<input type="submit" name="검색">		
	</form>
</div>
</div>
</body>
</html>