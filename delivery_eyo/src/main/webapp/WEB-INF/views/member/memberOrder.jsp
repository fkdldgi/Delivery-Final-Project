<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form action="${pageContext.request.contextPath }/member/order" method="post">
	<c:out value="${param.member}" /> <!--  id 세션값 이용해서 가져온 회원정보 -->
	<c:out value="${param.shopNum}" /> <!--  모델객체 이용해서 가져온 가게 번호 -->
	<div class="container" style="width: 100%;">
		<div class="row" style="width: 100%;">
		<!-- 가게 번호 받아서 숨기기 -->
		 <input type="text" name="shopNum" style="width: 60%;" value="${param.shopNum }" hidden>
			<div class="col-8 card" style="width: 100%; margin: auto; margin-bottom: 10px;">
				<div class="card bg-dark" style="width: 100%; height: 50px; color: white; text-align: left;">
					<h4 style="margin-top: 8px;">결제하기</h4>
				</div>
				<div class="card" style="width: 100%; height: 50px; color: black; text-align: left; background-color: lightgray;">
					<h4 style="margin-top: 8px;">배달정보</h4>
				</div>
				<div class="card" style="width: 100%;">
					<!-- 주소  -->
					주소 <input type="text" id="addr" name="addr" style="width: 60%;" readonly="readonly"><br>
					<input type="text" name="addr_detail" style="width: 60%;" placeholder="(필수)상세주소 입력"><br>
					<!-- 전화번호 -->
					휴대전화번호 <input type="text" name='tel' value='${member.tel }' style="width: 60%;" placeholder="(필수)전화번호 입력">
				</div>
					<!-- 사장님 요청 -->
				<div class="card" style="width: 100%; height: 50px; color: black; text-align: left; background-color: lightgray;">
					<h4 style="margin-top: 8px;">주문 요청사항</h4>
				</div>
				<div class="card" style="width: 100%;">
					<textarea name="owner_request" rows="2" cols="20" style="width: 80%;" placeholder="사장님에게 요청하는 사항입니다"></textarea>
				</div>
					<!-- 라이더 요청 -->
				<div class="card" style="width: 100%; height: 50px; color: black; text-align: left; background-color: lightgray;">
					<h4 style="margin-top: 8px;">배달 요청사항</h4>
				</div>
				<div class="card" style="width: 100%;">
					<textarea name="rider_request" rows="2" cols="20" style="width: 80%;" placeholder="라이더님께 요청하는 사항입니다"></textarea>
				</div>
					<!-- 결제수단 -->                          
				<div class="card" style="width: 100%; height: 50px; color: black; text-align: left; background-color: lightgray;">
					<h4 style="margin-top: 8px;">결제수단 선택</h4>
				</div>
				<div class="card" style="width: 100%;">
					<div class="row">
						<div class="col" style="border: 1px solid lightgray; height: 60px; width: 50%;">결재방법1</div>
						<div class="col" style="border: 1px solid lightgray; height: 60px; width: 50%;">결재방법2</div>
					</div>
					<div class="row">
						<div class="col" style="border: 1px solid lightgray; height: 60px;">결재방법3</div>
						<div class="col" style="border: 1px solid lightgray;">결재방법4</div>
					</div>
				</div>
					<!-- 쿠폰 -->
					<div class="card" style="width: 100%; height: 50px; color: black; text-align: left; background-color: lightgray;">
					<h4 style="margin-top: 8px;">할인방법 선택</h4>
				</div>
			</div>
			
			<div class="card sticky-top" style="width: 25%; height: 4	00px;0px solid black; margin-top: 10px; margin-left: -90px; text-align: left;" >
				<div class="card" style="width: 100%; height: 50px; color: black; text-align: left; background-color: lightgray;">
					<h5 style="margin-top: 10px; margin-left: 10px;">주문내역</h5>
				</div>
			</div>
		</div>
	</div>
</form>

<script>
	//주소 세션값 받아서 넣어주기
	document.getElementById("addr").value = sessionStorage.getItem('addr');
</script>  