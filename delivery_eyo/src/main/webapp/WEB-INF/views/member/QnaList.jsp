<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
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
<nav aria-label="Page navigation example">
  <ul class="pagination">
    <li class="page-item">
    <c:forEach var="i" begin="${pu.startPageNum }" end="${pu.endPageNum }">
		<c:choose>
		<c:when test="${i==pu.pageNum}">
      <a class="page-link" href="/delivery/member/QnaList?pageNum=${i}&field=${field}&keyword=${keyword}" aria-label="Previous">
        <span style="color:aqua"><<</span>
      </a>
    </li>
    <li class="page-item"><a class="page-link" href="/delivery/member/QnaList?pageNum=${i}&field=${field}&keyword=${keyword}">1</a></li>
    <li class="page-item"><a class="page-link" href="/delivery/member/QnaList?pageNum=${i}&field=${field}&keyword=${keyword}">2</a></li>
    </c:when>
   	 <c:otherwise>
      <a class="page-link" href="/delivery/member/QnaList?pageNum=${i}&field=${field}&keyword=${keyword}" aria-label="Next">
       <span style="color:gray">>></span>
       		</c:otherwise>
		</c:choose>
	</c:forEach>
      </a>
    </li>
  </ul>
</nav>
<div>		
</div>
<div>
	<form method="post" action="/delivery/member/QnaList">
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