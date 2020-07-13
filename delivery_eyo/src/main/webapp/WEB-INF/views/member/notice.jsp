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
<h1>��������</h1>
<div class="container">
	<table class="table">
	  <thead>
	    <tr>
	      <th scope="col">No.</th>
	      <th scope="col">�ۼ���</th>
	      <th scope="col">����</th>
	      <th scope="col">�ۼ���</th>
	      <th scope="col">����</th>
	      <th scope="col">����</th>
	    </tr>
	  </thead>
	  <tbody>
	    <c:forEach var="vo" items="${list}"> <!-- list�ִ� ���� -->
		<tr>
			<td>${vo.num}</td>
			<td>${vo.writer}</td>
			<td><a href="/delivery/member/detail?num=${vo.num }">${vo.title}</a></td>
			<td>${regdate}</td>
			<td><a href="/delivery/member/update?num=${vo.num}">����</a></td>
			<td><a href="/delivery/memberdelete?num=${vo.num}">����</a></td>
		</tr>
	</c:forEach>
	  </tbody>
</table>
</div>
<!-- ����,���� -->
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
			<c:if test="${field=='title' }">seleted</c:if>>����</option>
			<option value="writer"
			<c:if test="${field=='writer' }">seleted</c:if>>�ۼ���</option>
			<option value="content"
			<c:if test="${field=='content' }">seleted</c:if>>����</option>
		</select>
		<input type="text" name="keyword">
		<input type="submit" name="�˻�">		
	</form>
</div>
<ul>
	<li><a href="/delivery/member/noticeInsert">�۵��</a></li>
</ul>
</body>
</html>