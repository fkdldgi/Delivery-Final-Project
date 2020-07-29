<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<style>

</style>
<script>

</script>
<!-- 맨위에 띄워지는 공지사항 nav -->
<div>
    <div>
     	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
     		<a class="navbar-brand" href="#">공지사항</a>
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
     							(current).
     						</span>
     					</a>
     				</li>
     				<li class="nav-item">
     					<a class="nav-link">공지사항을 확인해주세요~</a>
     				</li>
     			</ul>
     			<form class="form-inline">
     				<div style="display: flex;">
     				<input class="form-control form-control-lg" type="search"
     					style="width: 500px; margin-right: 10px;"
     					placeholder="Search..." aria-label="Search">
     				<button class="btn btn-outline-info btn-lg" type="submit">Search</button>
     				</div>
     			</form>
     		</div>
     	</nav>
     </div>
</div>
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
      		<button type="button" class="btn btn-primary" onclick="location.href='${pageContext.request.contextPath}/owner/board'" >목록으로</button>
        </div>
    </div>
</div>
