<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!--  id 세션값 이용해서 가져온 회원정보 -->
<c:out value="${param.member}" /> 
<!--  모델객체 이용해서 가져온 가게 번호 -->
<c:out value="${param.shopNum}" />
<form action="${pageContext.request.contextPath }/member/order" method="post">
	<div class="container" style="width: 100%;">
		<div class="row" style="width: 100%;">
		<!-- 가게 번호 받아서 숨기기 -->
		<input type="text" name="shopNum" style="width: 60%;" value="${param.shopNum }" hidden>
		<!-- 고객번호 받아서 숨기기 -->
		<input type="text" name="memberNum" style="width: 60%;" value="${sessionScope.memberNum }" hidden>
		<!-- 주소관련 데이터 받아서 넘기기 -->
		<input type="text" name="buildingCode" style="width: 60%;" hidden>
		<input type="text" name="zonecode" style="width: 60%;" hidden>
		<input type="text" name="address" style="width: 60%;" hidden>
		<input type="text" name="addressEnglish" style="width: 60%;" hidden>
		<input type="text" name="addressType" style="width: 60%;"  hidden>
		<input type="text" name="userSelectedType" style="width: 60%;" hidden>
		<input type="text" name="userLanguageType" style="width: 60%;"  hidden>
		<input type="text" name="roadAddress" style="width: 60%;" hidden>
		<input type="text" name="roadAddressEnglish" style="width: 60%;" hidden>
		<input type="text" name="jibunAddress" style="width: 60%;"  hidden>
		<input type="text" name="jibunAddressEnglish" style="width: 60%;"  hidden>
		<input type="text" name="buildingName" style="width: 60%;" hidden>
		<input type="text" name="apartment" style="width: 60%;" hidden>
		<input type="text" name="sido" style="width: 60%;" hidden>
		<input type="text" name="sigungu" style="width: 60%;" hidden>
		<input type="text" name="sigunguCode" style="width: 60%;" hidden>
		<input type="text" name="roadnameCode" style="width: 60%;" hidden>
		<input type="text" name="bcode" style="width: 60%;" hidden>
		<input type="text" name="roadname" style="width: 60%;" hidden>
		<input type="text" name="bname" style="width: 60%;" hidden>
		<input type="text" name="bname1" style="width: 60%;"hidden>
		<input type="text" name="bname2" style="width: 60%;" hidden>
		<input type="text" name="hname" style="width: 60%;" hidden>
		<input type="text" name="query" style="width: 60%;" hidden>
		<input type="text" name="addr_x" style="width: 60%;" hidden>
		<input type="text" name="addr_y" style="width: 60%;" hidden>
		
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
	//주소 데이터 세션값 가져오기
	var data = sessionStorage.getItem('addrData');
	var addrData=JSON.parse(data)
	
	var dataXY = sessionStorage.getItem('dataXY');
	var XYdata=JSON.parse(dataXY);
	
	$('input[name=buildingCode]').val(addrData.buildingCode);
	$('input[name=zonecode]').val(addrData.zonecode);
	$('input[name=address]').val(addrData.address);
	$('input[name=addressEnglish]').val(addrData.addressEnglish);
	$('input[name=addressType]').val(addrData.addressType);
	$('input[name=userSelectedType]').val(addrData.userSelectedType);
	$('input[name=userLanguageType]').val(addrData.userLanguageType);
	$('input[name=roadAddress]').val(addrData.roadAddress);
	$('input[name=roadAddressEnglish]').val(addrData.roadAddressEnglish);
	$('input[name=jibunAddress]').val(addrData.jibunAddress);
	$('input[name=jibunAddressEnglish]').val(addrData.jibunAddressEnglish);
	$('input[name=buildingName]').val(addrData.buildingName);
	$('input[name=apartment]').val(addrData.apartment);
	$('input[name=sido]').val(addrData.sido);
	$('input[name=sigungu]').val(addrData.sigungu);
	$('input[name=sigunguCode]').val(addrData.sigunguCode);
	$('input[name=roadnameCode]').val(addrData.roadnameCode);
	$('input[name=bcode]').val(addrData.bcode);
	$('input[name=roadname]').val(addrData.roadname);
	$('input[name=bname]').val(addrData.bname);
	$('input[name=bname1]').val(addrData.bname1);
	$('input[name=bname2]').val(addrData.bname2);
	$('input[name=hname]').val(addrData.hname);
	$('input[name=query]').val(addrData.query);
	$('input[name=addr_x]').val(XYdata.x);
	$('input[name=addr_y]').val(XYdata.y);
	
	console.log("주소 데이터 객체 값:" + addrData.buildingCode);
	console.log("주소 데이터 객체 값:" + addrData.zonecode);
	console.log("주소 데이터 객체 값:" + addrData.address);
	console.log("주소 데이터 객체 값:" + addrData.addressEnglish);
	console.log("주소 데이터 객체 값:" + addrData.addressType);
	console.log("주소 데이터 객체 값:" + addrData.userSelectedType);
	console.log("주소 데이터 객체 값:" + addrData.userLanguageType);
	console.log("주소 데이터 객체 값:" + addrData.roadAddress);
	console.log("주소 데이터 객체 값:" + addrData.roadAddressEnglish);
	console.log("주소 데이터 객체 값:" + addrData.jibunAddress);
	console.log("주소 데이터 객체 값:" + addrData.jibunAddressEnglish);
	console.log("주소 데이터 객체 값:" + addrData.buildingName);
	console.log("주소 데이터 객체 값:" + addrData.apartment);
	console.log("주소 데이터 객체 값:" + addrData.sido);
	console.log("주소 데이터 객체 값:" + addrData.sigungu);
	console.log("주소 데이터 객체 값:" + addrData.sigunguCode);
	console.log("주소 데이터 객체 값:" + addrData.roadnameCode);
	console.log("주소 데이터 객체 값:" + addrData.bcode);
	console.log("주소 데이터 객체 값:" + addrData.roadname);
	console.log("주소 데이터 객체 값:" + addrData.bname);
	console.log("주소 데이터 객체 값:" + addrData.bname1);
	console.log("주소 데이터 객체 값:" + addrData.bname2);
	console.log("주소 데이터 객체 값:" + addrData.hname);
	console.log("주소 데이터 객체 값:" + addrData.query);
	console.log("주소 데이터 x좌표 값:" + XYdata.x);
	console.log("주소 데이터 y좌표 값" + XYdata.y);
	
</script>  