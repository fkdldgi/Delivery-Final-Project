<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>

<!--  id 세션값 이용해서 가져온 회원정보 -->
<c:out value="${param.member}" /> 
<!--  모델객체 이용해서 가져온 가게 번호 -->
<c:out value="${param.shopNum}" />
<!-- onsubmit="return payment()" -->
 <form action="${pageContext.request.contextPath }/member/order" method="post"  id="ff1">
	<div class="container" style="width: 100%;">
		<div class="row" style="width: 100%;">
		<!-- 가게 번호 받아서 숨기기 -->
		<input type="text" name="shopNum" class="data" style="width: 60%;" value="${param.shopNum }" hidden>
		<!-- 고객번호 받아서 숨기기 -->
		<input type="text" name="memberNum" class="data" style="width: 60%;" value="${sessionScope.memberNum }" hidden>
		<!-- 주소관련 데이터 받아서 넘기기 -->
		<input type="text" name="buildingCode" style="width: 60%;" hidden class="data">
		<input type="text" name="zonecode" style="width: 60%;" hidden  class="data">
		<input type="text" name="address" style="width: 60%;" hidden  class="data">
		<input type="text" name="addressEnglish" style="width: 60%;" hidden class="data">
		<input type="text" name="addressType" style="width: 60%;"  hidden class="data">
		<input type="text" name="userSelectedType" style="width: 60%;" hidden class="data">
		<input type="text" name="userLanguageType" style="width: 60%;"  hidden class="data">
		<input type="text" name="roadAddress" style="width: 60%;" hidden class="data">
		<input type="text" name="roadAddressEnglish" style="width: 60%;" hidden class="data">
		<input type="text" name="jibunAddress" style="width: 60%;"  hidden>
		<input type="text" name="jibunAddressEnglish" style="width: 60%;"  hidden class="data">
		<input type="text" name="buildingName" style="width: 60%;" hidden class="data">
		<input type="text" name="apartment" style="width: 60%;" hidden class="data">
		<input type="text" name="sido" style="width: 60%;" hidden class="data">
		<input type="text" name="sigungu" style="width: 60%;" hidden class="data">
		<input type="text" name="sigunguCode" style="width: 60%;" hidden class="data">
		<input type="text" name="roadnameCode" style="width: 60%;" hidden class="data">
		<input type="text" name="bcode" style="width: 60%;" hidden class="data">
		<input type="text" name="roadname" style="width: 60%;" hidden class="data">
		<input type="text" name="bname" style="width: 60%;" hidden class="data">
		<input type="text" name="bname1" style="width: 60%;"hidden class="data">
		<input type="text" name="bname2" style="width: 60%;" hidden class="data">
		<input type="text" name="hname" style="width: 60%;" hidden class="data">
		<input type="text" name="query" style="width: 60%;" hidden class="data">
		<input type="text" name="addr_x" style="width: 60%;" hidden class="data">
		<input type="text" name="addr_y" style="width: 60%;" hidden class="data">
	 	
			<div class="col-8 card" style="width: 100%; margin: auto; margin-bottom: 10px;">
				<div class="card bg-dark" style="width: 100%; height: 50px; color: white; text-align: left;">
					<h4 style="margin-top: 8px;">결제하기</h4>
				</div>
				<div class="card" style="wid th: 100%; height: 50px; color: black; text-align: left; background-color: lightgray;">
					<h4 style="margin-top: 8px;">배달정보</h4>
				</div>
				<div class="card" style="width: 100%;">
					<!-- 주소  -->
					주소 <input type="text" id="addr" class="data" name="userAddr" style="width: 60%;" readonly="readonly"><br>
					<input type="text" class="data" name="addr_detail" style="width: 60%;" placeholder="(필수)상세주소 입력" required="required"><br>
					<!-- 전화번호 -->
					휴대전화번호 <input type="text" class="data" id="tel" name='tel' value='${member.tel }' style="width: 60%;" placeholder="(필수)전화번호 입력" required="required">
				</div>
					<!-- 사장님 요청 -->
				<div class="card" style="width: 100%; height: 50px; color: black; text-align: left; background-color: lightgray;">
					<h4 style="margin-top: 8px;">주문 요청사항</h4>
				</div>
				<div class="card" style="width: 100%;">
					<textarea name="owner_request" class="data" rows="2" cols="20" style="width: 80%;" placeholder="사장님에게 요청하는 사항입니다"></textarea>
				</div>
					<!-- 라이더 요청 -->
				<div class="card" style="width: 100%; height: 50px; color: black; text-align: left; background-color: lightgray;">
					<h4 style="margin-top: 8px;">배달 요청사항</h4>
				</div>
				<div class="card" style="width: 100%;">
					<textarea name="rider_request" class="data" rows="2" cols="20" style="width: 80%;" placeholder="라이더님께 요청하는 사항입니다"></textarea>
				</div>
					<!-- 쿠폰 -->
					<div class="card" style="width: 100%; height: 50px; color: black; text-align: left; background-color: lightgray;">
					<h4 style="margin-top: 8px;">할인방법 선택</h4>
				</div>
			</div>
			<!-- 주문내역 부분 -->
			<div class="card sticky-top" style="width: 25%; height: 400px; margin-left: -90px; text-align: left;" >
				<div class="card" style="width: 100%; height: 50px; color: black; text-align: left; background-color: lightgray; ">
					<h5 style="margin-top: 10px; margin-left: 10px;">주문내역</h5>
				</div>
				<div id="body" style="overflow: auto; width: 100%; height: 100%;">
					<c:forEach var='orderList' items='${orderList }'>
						<div class="card" style="width: 100%; border: 0px solid black;">
							${orderList.menuVo.name }
							<!-- 메뉴번호 보내기 -->
							<input type="text" name="menuNum" value="${orderList.menuVo.num }" hidden class="data">
							<p>옵션 : 
							<c:forEach var="i" begin="1" end="${fn:length(orderList)-2 }" varStatus="status">
								<c:set var="optionVo">optionVo${i}</c:set>
								${orderList[optionVo].name}
								<!-- 옵션번호 보내기(동적인 부분) -->
								<input type="text" name="optionNum" value="${orderList[optionVo].num}" hidden class="data">
							</c:forEach>
							<br>수량 : ${orderList.volume } 개
							<!-- 수량 보내기 -->
							<input type="text" name="volume" value="${orderList.volume }" hidden class="data">
							</p>
						</div>
					</c:forEach>
				</div>
				<div class="row" style="background-color: lightgray; width:100%; height: 60px; margin-left: 1px;">
					<div class="col" style="text-align: left;">
						<h5 style="margin-top: 5px;">총 결제금액</h5>
					</div>
					<div class="col" style="text-align: right;">
						<h5 style="margin-top: 5px;"><span>${lastPrice }</span>원</h5>
						<!-- 최종가격 보내기 -->
						<input type="text" name="lastPrice" value="${lastPrice }" hidden class="data">
					</div>
				</div>
				<br><input type="button" id="submit" class="btn btn-primary btn-lg" style="width: 100%; margin-top: -20px;" value="결제하기">
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
	
 //전화번호 유효성검사
// 	$("").on("click",function(){
// 		var regex = /^01\d\d{3,4}\d{4}$/;
// 		var result = regex.exec($("#tel").val());
// 			if(result != null){
// 				$("#tel").html("");  
// 			}else{
// 				$("#tel").html("올바른 번호가 아닙니다");
// 			}
// 	});
 
	 $("input[value='결제하기']").on('click',function(){
	        var IMP = window.IMP; // 생략가능
	        IMP.init('imp42126053'); // 'iamport' 대신 부여받은 "가맹점 식별코드"를 사용
	        var msg;
	 		console.log('11112222')
	        IMP.request_pay({
	            pg : 'inicis',
	            pay_method : 'vbank',
	            merchant_uid : 'merchant_' + new Date().getTime(),
	            name : '주문명 : 배달이요 테스트 결제',
	            amount : 100,
	            buyer_name :'${member.name }',
	            buyer_tel :${member.tel},
	            buyer_addr : addrData.address,
	            buyer_postcode : '123-456',
	        }, function(rsp) {
	            if ( rsp.success ) {
	                var msg = '결제가 완료되었습니다.';
	                msg += '고유ID : ' + rsp.imp_uid;
	                msg += '상점 거래ID : ' + rsp.merchant_uid;
	                msg += '결제 금액 : ' + rsp.paid_amount;
	                msg += '카드 승인번호 : ' + rsp.apply_num;
	               	var form=$("<form></form>")
	               	form.attr('method','post');
	               	form.attr('action','${pageContext.request.contextPath }/member/order')
	               	form.appendTo("body")
	               	$('.data').each(function(){
	               		$(this).appendTo(form);
	               	})
	               	form.submit();
	               	
	            } else {
	                var msg = '결제에 실패하였습니다.';
	                msg += '에러내용 : ' + rsp.error_msg;
	            } 
	        });
	 });
</script>  