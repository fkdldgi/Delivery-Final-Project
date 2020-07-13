<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>공지사항</h1>
<div class="container">
	<table class="table">
	  <thead>
	    <tr>
	      <th scope="col">No.</th>
	      <th scope="col">작성자</th>
	      <th scope="col">제목</th>
	      <th scope="col">작성일</th>
	      <th scope="col">수정</th>
	      <th scope="col">삭제</th>
	    </tr>
	  </thead>
	  <tbody>
	    <c:forEach var="vo" items="${list}"> <!-- list있는 값들 -->
		<tr>
			<td>${vo.num}</td>
			<td>${vo.writer}</td>
			<td><a href="/delivery/member/detail?num=${vo.num }">${vo.title}</a></td>
			<td>${regdate}</td>
			<td><a href="/delivery/member/update?num=${vo.num}">수정</a></td>
			<td><a href="/delivery/memberdelete?num=${vo.num}">삭제</a></td>
		</tr>
	</c:forEach>
	  </tbody>
</table>
</div>
<!-- 이전,다음 -->
<div>
	<c:forEach var="i" begin="${pu.startPageNum }" end="${pu.endPageNum }">
		<c:choose>
			<c:when test="${i==pu.pageNum}">
				<a href="/delivery/member/list?pageNum=${i}&field=${field}&keyword=${keyword}">
				<span style="color:aqua">${i }</span>
				</a>
			</c:when>
			<c:otherwise>
				<a href="/delivery/member/list?pageNum=${i}&field=${field}&keyword=${keyword}">
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
			<option value="writer"
			<c:if test="${field=='writer' }">seleted</c:if>>작성자</option>
			<option value="content"
			<c:if test="${field=='content' }">seleted</c:if>>내용</option>
		</select>
		<input type="text" name="keyword">
		<input type="submit" name="검색">		
	</form>
</div>
<ul>
	<li><a href="/delivery/member/noticeInsert">글등록</a></li>
</ul>
</body>
</html>