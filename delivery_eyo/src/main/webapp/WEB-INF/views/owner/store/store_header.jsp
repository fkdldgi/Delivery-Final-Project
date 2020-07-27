<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div>
	<nav class="navbar navbar-expand-md navbar-dark bg-dark">
		<a class="navbar-brand mx-auto">가게운영</a>
	</nav>
</div>
	
<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	
	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item">
				<a class="nav-link" href="/delivery/owner/store_manage/home?num=${vo.num }">메뉴관리</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="/delivery/owner/store_manage/advertisement?num=${vo.num }">광고관리</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="/delivery/owner/store_manage/review?num=${vo.num }">리뷰관리</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="/delivery/owner/store_manage/order?num=${vo.num }">주문관리</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="/delivery/owner/store_manage/calculate?num=${vo.num }">정산관리</a>
			</li>
			<li class="nav-item">
				<div class="dropdown">
					<button class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
						운영관리
					</button>
					<div class="dropdown-menu">				
						<a class="dropdown-item" href="${pageContext.request.contextPath }/owner/shop/basicinfo?num=${vo.num }">기본정보</a>
						<a class="dropdown-item" href="${pageContext.request.contextPath }/owner/shop/operationinfo?num=${vo.num }">운영정보</a>
						<a class="dropdown-item" href="/delivery/owner/store_manage/shop_info?num=${vo.num }">주문정보</a>
						<a class="dropdown-item" href="/delivery/owner/store_manage/shop_info?num=${vo.num }">배달권역</a>
					</div>
				</div>
			</li>
	    </ul>
	</div>
</nav>