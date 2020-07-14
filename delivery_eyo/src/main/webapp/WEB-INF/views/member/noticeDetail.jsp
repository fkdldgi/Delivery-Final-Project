<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>notice detail</title>
</head>
<body>
<div class="container col-md-6">
<h1>공지사항</h1>
    <div class="card">
        <div class="card-body">
            <h4 class="card-title mb-3">${vo.title }</h4>
            <h6 class="card-subtitle text-muted mb-4">
                NO.
                <i class="far fa-num"></i> ${vo.num }
                <br>
                <fmt:formatDate value="${vo.regdate }" pattern="yyyy-MM-dd" var="regdate"/>
                <i class="far fa-clock"></i> ${regdate}
               	에 작성된 글
            </h6>
            <p class="card-text">${vo.content }</p>
        </div>
        <div class="card-body">
            <span>이전글</span>
			<a href="/delivery/member/detail?num=${pre.num }">${pre.title }</a></td>
			<br>
            <span>다음글</span>
			<a href="/delivery/member/detail?num=${next.num }">${next.title }</a></td>
        </div>
        <div class="card-body">
      		<button type="button" class="btn btn-primary" onclick="location.href='${pageContext.request.contextPath}/member/notice'" >목록으로</button>
        </div>
    </div>
</div>
</body>
</html>