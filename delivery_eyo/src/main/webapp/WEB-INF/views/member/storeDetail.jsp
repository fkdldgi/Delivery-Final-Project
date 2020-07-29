<%@page import="com.jhta.delivery.vo.ShopVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<style>
	.starR{
		  background: url('http://miuu227.godohosting.com/images/icon/ico_review.png') no-repeat right 0;
		  background-size: auto 100%;
		  width: 30px;
		  height: 30px;
		  display: inline-block;
		  text-indent: -9999px;
		  cursor: pointer;
	}
	.starR.on{background-position:0 0;}
	
	.reviewImg{
		margin-left: 100px;
		width: 500px; 
		height: 400px; 
		margin-bottom: 20px;
	}
</style>


<div class="container" style="width: 100%;">
  <div class="row" style="width: 100%;">
    <div class="col-8" id="storeWrap" style="width: 90%; margin: auto; margin-bottom: 10px;">
	<c:out value="${param.info}" />
	<div class="media position-relative"
		style="border: 1px solid gray; margin-top: 10px; margin-bottom: 10px;">
		<img
			src="${pageContext.request.contextPath }/resources/profile/${info.profile_img }" 
			style="width: 20%; height: 100px; margin-top: 20px;" class="mr-3">
		<div class="media-body">
			<p hidden="hidden" id="shop_num">${info.num}</p>
			<p hidden="hidden" id="owner_num">${info.owner_num }</p>
			<p><h2 style="font-weight: bold;" class="mt-0">${info.name}</h2></p>
			<p><h4>최소 결제금액 : <span style="color: red;">${info.min_price }</span>원</h4></p>
			<p><h4>결재 수단 : <span style="color: green;">${info.payment_option}</span></h4></p>
		</div>
	</div>
	
	<nav>
		<div class="nav nav-tabs" id="nav-tab" role="tablist"
			style="width: 100%;">
			<a class="nav-item nav-link active" id="nav-home-tab"
				data-toggle="tab" href="#nav-home" role="tab"
				aria-controls="nav-home" aria-selected="true"
				style="width: 33%; border: 1px solid blue;"><h4 style="font-weight: bold;">메뉴</h4></a> <a
				class="nav-item nav-link" id="nav-profile-tab" data-toggle="tab"
				href="#nav-profile" role="tab" aria-controls="nav-profile"
				aria-selected="false" style="width: 33%; border: 1px solid green;"><h4 style="font-weight: bold;">리뷰</h4></a>
			<a class="nav-item nav-link" id="nav-contact-tab" data-toggle="tab"
				href="#nav-contact" role="tab" aria-controls="nav-contact"
				aria-selected="false" style="width: 34%; border: 1px solid gray;"><h4 style="font-weight: bold;">가게정보</h4></a>
		</div>
	</nav>
	<div class="tab-content" id="nav-tabContent" style="border: 1px solid black;">
		<div class="tab-pane fade show active" id="nav-home" role="tabpanel"
			aria-labelledby="nav-home-tab">
			<div class="card-body">
			<c:choose>
				<c:when test="${mainmenu eq '[]' }">
					<div style="width: 100%; height: 410px;">
						<h1>등록된 메뉴가 없습니다.</h1>
					</div>
				</c:when>
				<c:otherwise>
				<c:forEach items="${mainmenu }" var="main">
					<div class="row border-bottom" data-toggle="modal" data-target="#menuModal" onclick="javascript:menu_detail(${main.num})">
<%-- 					<p>${main.num }</p> --%>
						<div class="col-5">
							<img src="${pageContext.request.contextPath }/resources/menu/${main.img}" style="width: 250px; height: 150px; margin-top: 10px; margin-bottom: 10px;">
						</div>
						<div class="col-7">
							<p><h2 style="font-weight: bold;">${main.name}</h2></p>
							<p><h5>${main.menu_info}</h5></p>
							<p><h4 style="color: red;">${main.price}원</h4></p>
						</div>
					</div>
				</c:forEach>
				</c:otherwise>
			</c:choose>	
			</div>
		</div>
		<!-- 리뷰 넣는 부분 -->
		<div class="tab-pane fade" id="nav-profile" role="tabpanel" aria-labelledby="nav-profile-tab">
			<c:choose>
				<c:when test="${reviewAble eq '[]'}">
				</c:when>
				<c:otherwise>
					<h4 style="font-weight:bold; margin-top: 20px; margin-left: 70px; margin-bottom: 20px;">*작성 가능한 리뷰가 있습니다.</h4>
					<c:out value="${param.menuInfo}" />
					<h1 style="font-weight: bold; text-align: center;"> ${menuInfo.name }</h1>
					<img src="${pageContext.request.contextPath }/resources/menu/${menuInfo.img }" style="width: 80px; height: 100px; margin-left: 300px;">
					<form action="${pageContext.request.contextPath }/member/insertReview" enctype="multipart/form-data" method="post">
						 <div class="starRev" style="margin-left: 45px; margin-bottom: 20px; margin-left: 250px;">
							<span class="starR on"><input type="text" id="input" value="1" hidden="hidden"></span>
							<span class="starR"><input type="text" id="input" value="2"  hidden="hidden"></span>
							<span class="starR"><input type="text" id="input" value="3"  hidden="hidden"></span>
							<span class="starR"><input type="text" id="input" value="4"  hidden="hidden"></span>
							<span class="starR"><input type="text" id="input" value="5"  hidden="hidden"></span>
						</div>
						<input type="text" name="order_num" value=" ${reviewAble.num }" hidden="hidden">
						<input type="text" name="member_num" value="${sessionScope.memberNum}" hidden="hidden">
						<input type="text" name="owner_num" value="${info.owner_num }" hidden="hidden">
						<input type="text" name="shop_num" value="${info.num}" hidden="hidden">
						<img src="" id="reviewImg" class="">
						<textarea name="reviewText" style="margin-left: 50px;" rows="10" cols="83" placeholder="10자 이상 써주세요~"></textarea><br>
						<input type="file" accept="image/*" name="file123" id="file" style="margin-left: 50px;" class="upload-hidden">
						<button type="submit" id="reviewBtn" class="btn btn-primary" style="width: 100px; height: 50px; margin-left: 555px; margin-bottom: 10px; margin-top: -30px;" >리뷰 등록</button>
					</form>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${review_member_list eq '[]' }">
					<div style="width: 100%; height: 450px;">
						<h1>등록된 리뷰가 없습니다.</h1>
					</div>
				</c:when>
				<c:otherwise>
					<c:forEach items="${review_member_list }" var="rmList">
						<div class="card">
							<!-- 리뷰 회원 프로필 이미지 -->
							<c:choose>
								<c:when test="${rmList eq null}">
									<div style="width: 10%; height: 100%; float:left; text-align: right;">
										<img src="/delivery/resources/images/user.png" style="border-radius: 70%; width: 50px; height: 50px;">
									</div>
									<div style="width: 85%; height: 100%; float: left; margin-left: 5px;">
										<span>${rmList.NAME }님</span>
									</div>
								</c:when> 
								<c:otherwise>
									<div style="width: 100%; margin-top: 10px; margin-bottom: 10px;">
										<div style="width: 10%; height: 100%; float:left; text-align: right; margin-right: 10px;">
											<img src="/delivery/resources/images/${rmList.IMG }" style="border-radius: 70%; width: 50px; height: 50px;">
										</div>
										<div style="width: 60%; height: 100%; margin-left: 15px; margin-top: 10px; float:left">
											<h4 style="font-weight: bold;">${rmList.NAME }님</h4>
										</div>
										<div style="width: 30%;">
											<c:choose>
												<c:when test="${rmList.GRADE eq '5' }">
													<img src="/delivery/resources/images/star_5.png" style="width: 100px; height: 25px;">
												</c:when>
												<c:when test="${rmList.GRADE eq '4' }">
													<img src="/delivery/resources/images/star_4.png" style="width: 100px; height: 25px;">
												</c:when>
												<c:when test="${rmList.GRADE eq '3' }">
													<img src="/delivery/resources/images/star_3.png" style="width: 100px; height: 25px;">
												</c:when>
												<c:when test="${rmList.GRADE eq '2' }">
													<img src="/delivery/resources/images/star_2.png" style="width: 100px; height: 25px;">
												</c:when>
												<c:when test="${rmList.GRADE eq '1' }">
													<img src="/delivery/resources/images/star_1.png" style="width: 100px; height: 25px;">
												</c:when>
											</c:choose>
										</div>
									</div>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${rmList.REVIEW_IMG_NUM eq null}">
								</c:when>
								<c:otherwise>
									<c:forEach items="${reviewImg }" var="img">
										<c:choose>
											<c:when test="${rmList.REVIEW_IMG_NUM == img.num }">
<!-- 												<p>=============이미지 부분===========</p> -->
<%-- 												<p>이미지 번호 : ${img.num }</p> --%>
<%-- 												<p>이미지 경로 : ${img.img_path }</p> --%>
<%-- 												<p>이미지 원본파일 이름 : ${img.original_filename }</p> --%>
<%-- 												<p>이미지 저장파일 이름 : ${img.save_filename }</p> --%>
												<img src="/delivery/resources/images/${img.original_filename }" style=" width: 600px; height: 400px; margin: auto; margin-top: 20px; margin-bottom: 20px;"> 
											</c:when>
											<c:otherwise></c:otherwise>
										</c:choose>
									</c:forEach>
								</c:otherwise>
							</c:choose>
<%-- 							<p>사장 번호 : ${rmList.OWNER_NUM }</p> --%>
<%-- 							<p>리뷰 번호 : ${rmList.NUM }</p> --%>
<%-- 							<p>리뷰 등록일 : ${rmList.OWNER_NUM }</p> --%>
<%-- 							<p>사장 번호 : ${rmList.OWNER_NUM }</p> --%>
<%-- 							<p>리뷰 점수 : ${rmList.GRADE }</p> --%>
							<h5 style="margin-left: 60px; margin-bottom: 30px;">${rmList.CONTENT }</h5>
<!-- 							<p>---------------------------</p> -->
						</div>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</div>
		<!-- 가게정보 넣는 부분 -->
		<div class="tab-pane fade" id="nav-contact" role="tabpanel" aria-labelledby="nav-contact-tab">
			<div class="card" style="width: 100%;">
				<h3 style="font-weight: bold; margin-top: 20px;">가게 소개</h3>
				<br>
				<h4 style="margin-bottom: 20px;">${info.introduce }</h4>
			</div>
			<div class="card" style="width: 100%;">
				<h3 style="font-weight: bold; margin-top: 20px;">안내 및 혜택</h3>
				<br>
				<h4 style="margin-bottom: 20px;">${info.review_info }</h4>
			</div>
			<div class="card" style="width: 100%;">
				<h3 style="font-weight: bold; margin-top: 20px;">영업 정보</h3>
				<br>
				<div class="row row-cols-2" style="margin-bottom: 20px;">
					<div class="col-2">운영시간</div>
					<div class="col-10">매일- 오전 ${info.open_time } ~ 오후 ${info.close_time }</div>
					<div class="col-2">휴무일</div>
					<div class="col-10">${info.personal_day }</div>
					<div class="col-2">전화번호</div>
					<div class="col-10">${info.tel }</div>
				</div>
			</div>
		</div>
	</div>
</div>
    <!-- 주문표(장바구니) 부분 -->
	<div class="card sticky-top" id="cart" style="width:25%; height: 600px; border: 0px solid black; margin-top: 10px; margin-left: -90px;" >
		<div class="bg-dark" style="width: 100%; height: 10%; border: 0px solid black; color: white;">
			<div class='row'>
				<div class='col'>
					<h4 style="margin-top: 15px; margin-left: 20px;">장바구니</h4>
				</div>	
				<div class='col'>
					<button type="button" class="btn btn-sm btn-info" style=" margin-left:20px; margin-top: 15px;" onclick="delChild()">전체 삭제</button>
				</div>
			</div>
		</div>
		<div id="cart-body" style="width: 100%; height: 60%; border: 1px solid black; overflow: auto;"></div>
		<div id="cart-num"></div>
		<div id="cart-footer" style="width: 100%; height: 30%; border: 0px solid black; margin-top: 10px;">
			<div id="min-price" style="width: 100%; height:35%; border: 1px solid black;"><h4 style="font-weight: bold;">최소 결제금액<br><span style="color: red;">${info.min_price }</span>원</h4></div>
			<div style="width: 100%; height: 50%; border: 1px solid black;"><h4 style="font-weight: bold;">총 금액</h4><div id="total-price" style="float: left; font-weight: bold; font-size: 1.5em; color: blue;">선택된 메뉴가 없습니다</div></div>
			<button type="button" id='orderBtn' class='btn btn-primary btn-lg' style="width: 100%; height: 30%;">주문하기</button>
		</div>
	</div>    
  </div> 
  </div>


<!-- Modal -->
<div class="modal fade" id="menuModal" data-backdrop="static"
	data-keyboard="false" tabindex="-1" role="dialog"
	aria-labelledby="staticBackdropLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<p class="modal-title" id="modal-title"></p>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body" id="modal-body"></div>
			<div id="volume" style="margin: auto; margin-bottom: 10px;">
				<div class="btn-group mr-2" role="group">
				    <button type="button" class="btn btn-info" onclick="volumeDown()"><h1 style="font-weight: bold;">-</h1></button>
				    <input type="text" id="volumeText" class="btn btn-white" value="1" style="width: 5%; border: 1px solid gray; font-weight: bold; font-size: 1.2em;" readonly="readonly">
				    <button type="button" class="btn btn-info" onclick="volumeUp()"><h1 style="font-weight: bold;">+</h1></button>
				</div> 
			</div>
			<div style="background-color: gray; height: 50px;" class="d-flex bd-highlight">
			  <div class="p-2 flex-grow-1 bd-highlight" style="color: white; margin-top: 5px; margin-left: 10px;"><h5>총 주문금액</h5></div>
			  <div class="p-2 bd-highlight" style="color: blue;"><h3 id="total"></h3></div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary" data-dismiss="modal" style="width: 48%;"onclick="addCart()">담기</button>
				<button type="button" class="btn btn-secondary" data-dismiss="modal" style="width: 48%; float: left;" onclick="cancle()">취소</button>
			</div>
		</div>
	</div>
</div>

<script>

	//console.log('${sessionScope.memberId}') //아이디 세션 확인하기
	
	//메뉴 모달 띄우면서 출력값(메뉴,옵션메뉴) 뿌려주는 함수
	function menu_detail(num){
		$.ajax({
		        url: "/delivery/store/menu_option",
		        type: "post",
		        data: JSON.stringify(num),
		        dataType: "json",
		        contentType: "application/json",
		        success: function(data) {
		        	$("#modal-title").empty();
		        	$("#modal-body").empty();
		        	$("#total").empty();
					$("#modal-title").append("<h5 style='text-align: center;'>메뉴 상세</h5>");
					$("#modal-title").append("<input type='text' id='menuNum' value='"+ data.menuInfo.num +"' hidden >");
					$("#modal-body").append("<img src='${pageContext.request.contextPath}/resources/menu/" + data.menuInfo.img +"' style='width:100%;'>");
					$("#modal-body").append("<p><h1 style='text-align: center; font-weight:bold;' id='menuName'>"+ data.menuInfo.name +"</h1></p>");
					$("#modal-body").append("<p><h5 style='text-align: center;'> 설명 : "+ data.menuInfo.menu_info +"</h5></p>");
					$("#modal-body").append("<label style='text-align: left;'><h5 style='font-weight:bold;'> 가격 :</h5></label><label style='text-align: right;'id='menuprice'><h4 style='font-weight:bold; color:red;'>"+ data.menuInfo.price +"</h4></label><label style='text-align: left;'><h5 style='font-weight:bold;'>원</h5></label>");
					$("#total").text(data.menuInfo.price +"원");
					if(data.optionList[0] != null){
						$("#modal-body").append("<p><h5 style='font-weight:bold;'>"+ data.optionList[0].category +"</h5></p>");
						for(i in data.optionList){
							$("#modal-body").append("<p><input type='checkbox' onclick='clickOption()' class='check' value="+ 
									data.optionList[i].price +
									',' + data.optionList[i].num + 
									',' + data.optionList[i].name + ">&nbsp;&nbsp;" +
									"<label>"+ data.optionList[i].name +"</label>" +
									"<label style='float:right'>+"+ data.optionList[i].price +"원</label></p>"+
									"<div id='optionNum' hidden >"+ data.optionList[i].num + "</div>");
						}
					}
		        },error: function(errorThrown) {
				alert(errorThrown.statusText);
			}
		});
	}
	
	//수량 증가 함수
	function volumeUp(){
		var price = 0 ;
		var totalPrice = 0;
		if($(".check").each(function(){
			if($(this).is(":checked")){
				price =  (price + parseInt($(this).val()));
			}
		}))
		if(price===0){
			totalPrice = (parseInt($("#menuprice").text()))*(parseInt($("#volumeText").val()) + 1);
		}else{
			totalPrice = (price + parseInt($("#menuprice").text()))*(parseInt($("#volumeText").val()) + 1);
		}
		$('#volumeText').val((parseInt($("#volumeText").val()) + 1));
		$("#total").text(totalPrice+'원');
	}
	
	//수량 감소 함수
	function volumeDown(){
		var price = 0 ;
		var totalPrice = 0;
		if((parseInt($("#volumeText").val()) - 1) > 0){
			if($(".check").each(function(){
				if($(this).is(":checked")){
					price =  (price + parseInt($(this).val()));
				}
			}))
			if(price===0){
				totalPrice = (parseInt($("#menuprice").text()))*(parseInt($("#volumeText").val()) + -1);
			}else{
				totalPrice = (price + parseInt($("#menuprice").text()))*(parseInt($("#volumeText").val()) + -1);
			}
			$('#volumeText').val((parseInt($("#volumeText").val()) + -1));
			$("#total").text(totalPrice+'원');
		}
	}
	
	//메뉴 모달페이지에서 닫기를 누르면 수량 초기화 함수
	function cancle(){
		if($(".check").each(function(){
			if($(this).is(":checked")){
				
			}
		}))
		$('#volumeText').val(1); 
	}
	
	//묶음으로 담을 List 만들기
	
	var cart_totalPrice = 0;
	//담기 눌렀을 때 실행되는 함수
	function addCart(){
		//총 가격 가져와서 숫자부분 자르기
		var menuPrice = $('#total').text().split('원'); //컨트롤러로 보낼 때 숫자만 보내야하므로 미리 자름
		var menuNmae = $('#menuName').text();
		var volume = $('#volumeText').val();
		var menuNum = $('#menuNum').val();
		var count = 0;
		
		cart_totalPrice = (parseInt(cart_totalPrice) + parseInt(menuPrice[0]));
		
		var optionStr = '옵션 : ';
		var optionNum = '';
		if($(".check").each(function(){
			if($(this).is(":checked")){
				++count;
				if(count === 1){
					optionStr = optionStr + $(this).val().split(',')[2];
					optionNum = optionNum + $(this).val().split(',')[1];
				}else{  
					optionStr = optionStr + ',' +$(this).val().split(',')[2];
					optionNum = optionNum + ',' +$(this).val().split(',')[1];
				}
			}
		}));
		
		$('#cart-body').append(
				"<div class='list' hidden >"+menuNum+','+volume+','+optionNum+';'+"</div>"+
				"<div class='cart-menu'>"+
					'<p>' + menuNmae + "</p>" + 
					'<p>' + optionStr + "</p>" + 
					"<div class='row row-cols-2 border-bottom' style='width:100%;'>" + 
					"<div class='col'>" + menuPrice[0] + " 원</div>" + 
					"<div class='col' name='volume'>" +  volume + "개</div>" +
					"</div>"+
				"</div>"
		);
		
		$('#total-price').text(cart_totalPrice + '원');
		$('#volumeText').val(1);
	}
	
	//옵션 메뉴 선택시 총금액 변경해주는 함수
	function clickOption(){
		//메뉴 가격
		var menuPrice = parseInt($("#menuprice").text());
		//현재 선택한 수량
		var volume = parseInt($("#volumeText").val());
		//옵션가격
		var optionPrice = 0 ;
		if($(".check").each(function(){
			if($(this).is(":checked")){
				optionPrice =  (optionPrice + parseInt($(this).val()));
			}
		}))
		//총 가격 넣어주기
		var totalPrice = ((menuPrice + optionPrice)*volume);
				
		$('#total').text(totalPrice + '원');
	}
	
	
	//자식객체 갯수 가져오기(연습-- 이미 담은 메뉴를 또 담을 시 수량 변경 ==== 보류)
	function childLength(){
		var length = $('#cart-body').children().length;
		console.log('자식객체 수 : ' + length);
	}
	
	//전체삭제 함수
	function delChild(){
		//장바구니의 자식객체 없애기
		$('#cart-body').empty();
		$('#cart-body').children().remove();
		//총 금액 초기화
		cart_totalPrice = 0;
		$('#total-price').text('선택된 메뉴가 없습니다');
	}
	
	//장바구니 요소 더블클릭시 삭제하는 함수
	$('#cart').on('dblclick','.cart-menu',function(){
		console.log($(this).children('div').text()); //클릭한 요소의 자식 요소 중 div의 텍스트값을 가져오라는 뜻
		var price = parseInt($(this).children('div').text().split('원')[0]);
		var volume = parseInt($(this).children('div').text().split('원')[1]);
		var delPrice =parseInt(price);
		var orgPrice = parseInt($('#total-price').text());
		if((orgPrice-delPrice)===0){
			cart_totalPrice = 0
			$('#total-price').text('선택된 메뉴가 없습니다');
		}else{
			$('#total-price').text((orgPrice-delPrice)+'원');
		}
		console.log('총 금액  후: ' + $('#total-price').text());
		$(this).prev().text('');
		$(this).remove();
	});
	
	//주문하기 누르면 실행되는 함수
	$('#orderBtn').click(function(){
		console.log('주문 리스트 : '+$('#cart-body').find('.list').text()); //주문 리스트(메뉴 번호, 수량, 옵션번호) 가져오기
		var orderList = $('#cart-body').find('.list').text();
		var split1 = $('#cart-body').find('.list').text().split(';');
		console.log(split1);
		var split2 = '';
			
		for(var i=0; i<split1.length-1; i++){ //담은 메뉴의 수만큼 행이 나오도록 length의 길이를 조절했음
			console.log('split1 값 : ' + split1[i]);
			split2 = split1[i].split(',');
			console.log('split2 크기 : ' + split2.length);
			for(var j=0; j<split2.length; j++){
				console.log('순서' + split2[j]);
			}
		}
		
		var lastPrice = parseInt($('#total-price').text()); //주문하기 직전 장바구니 총 금액
		var minPrice = parseInt(${info.min_price }); //최소 주문금액
		
		if(lastPrice>=minPrice){
			location.href="${pageContext.request.contextPath}/member/orderPage?orderList=" + orderList + "&memberId='${sessionScope.memberId}'&shopNum=" + ${info.num} + "&lastPrice="+lastPrice;
			//${pageContext.request.contextPath }
		}else{
			alert('최소 주문금액보다 적습니다');
		}
	});
	
	//리뷰 작성 함수
	function reviewCheck(){
		var reviewLength = $('#reviewText').val().length;
		if(reviewLength<10){
			alert("10자 이상 입력해주세요~");
			return false;
		}else{
			return true;
		}
	};
	
	//리뷰 이미지 함수
	$("#file").change(function() {
		readURL(this);
	});
	
	//별점 주기 함수
	$('.starRev span').click(function(){
		$(this).parent().children('span').removeClass('on');
		$(this).parent().children('span').children('#input').attr('name','');
		$(this).addClass('on').prevAll('span').addClass('on');
		$(this).children('#input').attr('name','on');
		return false;
	});
	
	//선택한 리뷰 이미지 붙이기
		$("#file").change(function() {
			readURL(this);
		});

		$("#reviewImg").change(function() {
			$("#file").click();
		});

	function readURL(input) {
		if (input.files && input.files[0]) {
			var reader = new FileReader();
			reader.onload = function(e) {
				$('#reviewImg').attr('src', e.target.result);

			}
			$('#reviewImg').addClass('reviewImg');
			reader.readAsDataURL(input.files[0]);
		}
	}
	
</script>
