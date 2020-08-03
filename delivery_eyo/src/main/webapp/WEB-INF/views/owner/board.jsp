<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!-- 맨위에 띄워지는 공지사항 nav -->
<div>
    <div>
     	<nav class="navbar navbar-expand-lg navbar-dark bg-dark" style="font-family: 'Do Hyeon', sans-serif;">
     		<a class="navbar-brand" href="#" style="font-size:24px;">공지사항</a>
     		<button class="navbar-toggler" type="button" data-toggle="collapse" 
	     		data-target="#navbarColor01" 
	     		aria-controls="navbarColor01" aria-expanded="false"
	     		aria-label="Toggle navigation">
     			<span class="navbar-toggler-icon"></span>
     		</button>
     		<div class="collapse navbar-collapse" id="navbarColor01">
     			<ul class="navbar-nav mr-auto">
     				<li class="nav-item active">
     					<a class="nav-link" href="#">
     						<span class="sr-only">
     							(current)
     						</span>
     					</a>
     				</li>
     				<li class="nav-item">
     					<a class="nav-link" style="font-size:22px;">공지사항을 확인해주세요~</a>
     				</li>
     			</ul>
     			<!--  
     			<form class="form-inline">
     				<div style="display: flex;">
     				<input class="form-control form-control-lg" type="search"
     					style="width: 500px; margin-right: 10px;"
     					placeholder="Search..." aria-label="Search">
     				<button class="btn btn-outline-info btn-lg" type="submit">Search</button>
     				</div>
     			</form>
     			-->
     		</div>
     	</nav>
     </div>
</div>
<br>
<div class="container" style="min-height: 700px;">
	<img class="d-block mx-auto mb-4" src="/delivery/resources/images/owner_notice_logo.png" width="700" height="150">
	<table class="table">
		<thead>
			<tr>
				<th scope="col">No.</th>
				<th scope="col">제목</th>
				<th scope="col">작성일</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="vo" items="${list}" varStatus="i"> <!-- list있는 값들 -->
			<tr>
				<td>${(pu.pageNum-1)*10+(i.index+1)}</td>
				<td><a href="/delivery/owner/boardDetail?num=${vo.num }">${vo.title}</a></td>
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
				<a href="/delivery/owner/board?pageNum=${i}&field=${field}&keyword=${keyword}">
				<span style="color:blue">${i }</span>
				</a>
			</c:when>
			<c:otherwise>
				<a href="/delivery/owner/board?pageNum=${i}&field=${field}&keyword=${keyword}">
				<span style="color:gray">${i }</span>
				</a>
			</c:otherwise>
		</c:choose>
	</c:forEach>
</div>
	<div>
		<form method="post" action="/delivery/owner/board">
			<br>
			<div class="row">
				<div class="col-md-2">
					<select name="field" class="form-control">
						<option value="title"
							<c:if test="${field=='title' }">seleted</c:if>>제목</option>
						<option value="content"
							<c:if test="${field=='content' }">seleted</c:if>>내용</option>
					</select>
				</div>
				<div class="col-md-3">
					<input type="text" name="keyword" class="form-control">
				</div>
				<div class="col-md-1" style="padding:3px;">
					<input type="submit" name="검색" class="btn btn-outline-info btn-sm">		
				</div>
			</div>
			<br>
		</form>
	</div>
</div>
















