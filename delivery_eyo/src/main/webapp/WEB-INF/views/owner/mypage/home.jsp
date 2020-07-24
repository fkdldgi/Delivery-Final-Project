<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 맨 위에 뜨는 nav바 -->
<div>
	<nav class="navbar navbar-expand-md navbar-dark bg-dark">
		<a class="navbar-brand mx-auto">어서오세요 배달이요입니다.</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#store_manage"
			aria-controls="store_manage" aria-expanded="false"
			aria-label="Toggle navigation">
		</button>
		<div class="collapse navbar-collapse" id="store_manage">
			<ul class="navbar-nav mr-auto">
				<!-- 가게인사랑 가게운영 href랑 떨어지게 하기 위해서 넣음 -->
				<li class="nav-item active">
     				<a class="nav-link" href="#">
     					<span class="sr-only">
     						(current)
     					</span>
     				</a>
     			</li>
				<li class="nav-item">
					<a class="nav-link" href="/delivery/owner/store_manage?id=${sessionScope.ownerId }" 
								id="store_managehref">
						가게운영
					</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="/delivery/owner/board/">
						공지사항
					</a>
				</li>
			</ul>
		</div>
	</nav>
</div>

<div class="container mt-4">
	<h1>내 정보 관리</h1>
	<div class="row">
		<div class="card col-xs-4 shadow my-4 mr-4 p-3" style="width: 18rem;">
		  <div class="card-body">
		    <h4 class="card-title">가게운영</h4><br>
		    <small class="card-subtitle mb-2 text-muted">사장님의 가게를 확인할 수 있습니다.</small><br><br>
		    <a href="${pageContext.request.contextPath }/owner/store_manage?id=${sessionScope.ownerId }" class="btn btn-outline-secondary stretched-link">관리하기</a>
		  </div>
		</div>
		<div class="card col-xs-4 shadow my-4 mr-4 p-3" style="width: 18rem;">
		  <div class="card-body">
		    <h4 class="card-title">계정정보</h4><br>
		    <small class="card-subtitle mb-2 text-muted">비밀번호를 변경하실 수 있습니다.</small><br><br>
		    <a href="${pageContext.request.contextPath }/owner/pwdChange" class="btn btn-outline-secondary stretched-link">변경하기</a>
		  </div>
		</div>
		<div class="card col-xs-4 shadow my-4 mr-4 p-3" style="width: 18rem;">
		  <div class="card-body">
		    <h4 class="card-title">회원정보</h4><br>
		    <small class="card-subtitle mb-2 text-muted">주소,이메일 등을 변경하실 수 있습니다.</small><br><br>
		    <a href="${pageContext.request.contextPath }/owner/owner_update?id=${ownerId}" class="btn btn-outline-secondary stretched-link">변경하기</a>
		  </div>
		</div>
	</div>
</div>
