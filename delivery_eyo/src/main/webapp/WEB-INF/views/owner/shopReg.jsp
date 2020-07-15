<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link href="/delivery/resources/css/owner/TimePicker/mdtimepicker.css"
	rel="stylesheet">
<script src="//code.jquery.com/jquery.min.js"></script>
<script src="/delivery/resources/css/owner/TimePicker/mdtimepicker.js"></script>
<style>

/* navbar랑 form 떨어지게 하기 */
#div_wrap {
	margin-top: 50px;
}
/* form 가운데 위치하기 input이 border에 너무 붙지 않게 떼어내줌 */
#form_wrap {
	margin: auto;
	padding: 10px;
	width: 60%;
}

/* 글자 밑에 언더바 넣고, 언더바 위치 설정 */
.under_border {
	padding-bottom: 20px;
	border-bottom: 1px solid #ced4da;
	margin-bottom: 30px;
}

/* input 왼쪽으로 밀기 */
#shop_open_time {
	float: left;
}

#shop_close_time {
	float: left;
}

/* 글자 가운데로 위치 */
#open_close {
	float: left;
	text-align: center;
}

/* 글자 가운데로 위치 */
#open_time {
	text-align: center;
}

#close_time {
	text-align: center;
}

/* submit 버튼이 맨 아래에 붙지 않게 떼어줌*/
#submit_btn {
	padding-bottom: 10px;
}

/* form_wrap에 있는  밑에 뜨는 span 가리기*/
#form_wrap .help-block {
	display: none;
	color: red;
}



#sel1{
	margin-bottom:20px;
}

#sel2{
	margin-bottom:20px;
}

#chk1 label{
	margin: 0px 15px 5px 0px;

}
</style>
<script>
	$(document).ready(function() {
		// 가게 운영시간 입력하는 시계 띄우기
		$('#shop_open_time').mdtimepicker({
			theme : 'indigo'
		});
		$('#shop_close_time').mdtimepicker({
			theme : 'indigo'
		});

		var open_time;
		var close_time;

		// 시간 function
		$('#shop_open_time').mdtimepicker().on('timechanged', function(e) {
			console.log(e.value);
			open_time = e.time;
			console.log(open_time);
		});

		$('#shop_close_time').mdtimepicker().on('timechanged', function(e) {
			console.log(e.value);
			close_time = e.time;
			console.log(close_time);
		});

		// 전화번호 확인
		var phone_status = 1;
		$("#shop_phone").keyup(function() {
			var tel = $(this).val();
			var reg = /^\d{3}\d{3,4}\d{4}$/;
			if (reg.test(tel)) {
				$("#shop_phone_err").hide();
				phone_status = 0;
			} else {
				$("#shop_phone_err").show();
				phone_status = 1;
			}
		});

		// 사업자등록번호 확인
		var reg_num_status = 1;
		$("#reg_num").keyup(function() {
			var num = $(this).val();
			var reg = /^\d{3}-\d{2}-\d{5}$/;
			if (reg.test(num)) {
				$("#reg_num_err").hide();
				reg_num_status = 0;
			} else {
				$("#reg_num_err").show();
				reg_num_status = 1;
			}
		});
		// 사업자 상세주소 확인
		var address_detail_status = 1;
		$("#address_detail").keyup(function() {
			var address = $(this).val();
			var reg = /[`~!@#$%^&*()'"'"'",._+=|<>?:{}]/;
			if (reg.test(address)) {
				$("#address_detail_err").show();
				address_detail_status = 1;
			} else {
				$("#address_detail_err").hide();
				address_detail_status = 0;
			}
		});

		// 운영시간 (오픈시간과 영업시간이 같거나 오픈시간이 더 늦고 마감시간이 더 빠를 때)
		$("#form_wrap").submit(function(e) {
			var open = $("#shop_open_time").val();
			var close = $("#shop_close_time").val();
			console.log('1');
			if (open == "" || open == null) {
				alert("오픈시간을 정해주세요.");
			}
			if (close == "" || close == null) {
				alert("마감시간을 정해주세요.");
				e.preventDefault();
			}
			if (open_time >= close_time) {
				alert("영업시간을 다시 설정해 주세요.");
				e.preventDefault();
			}
			if (phone_status == 1) {
				alert("전화번호를 제대로 입력해 주세요.");
				e.preventDefault();
			}
			if (reg_num_status == 1) {
				alert("사업자등록번호를 제대로 입력해 주세요.");
				e.preventDefault();
			}
			if (address_detail == 1) {
				alert("상세주소를 제대로 입력해 주세요.");
				e.preventDefault();
			}
			e.preventDefault();
		});
		
		
		var chk1=$("#chk1");
		//배달지역 시군구 얻어오기
		$("#sel1").change(function(){
			var cityNum=this.value;
			var sel2=$("#sel2");
			chk1.empty();
			sel2.empty();
			$.ajax({
				url:'https://sgisapi.kostat.go.kr/OpenAPI3/addr/stage.json',
				data:{accessToken:'722974ee-1eca-4997-ad5d-95233b59e248',cd:cityNum},
				dataType:'json',
				success:function(data){
					sel2.append("<option value='null'>-- 시,군,구를 선택해주세요 --</option>");
					data.result.forEach(function(item,index,array){
						sel2.append("<option value='"+item.cd+"'>"+item.addr_name+"</option>");
					});
				}
			});
		});
		
		//배달지역  읍면동 얻어오기
		$("#sel2").change(function(){
			var cityNum=this.value;
			chk1.empty();
			$.ajax({
				url:'https://sgisapi.kostat.go.kr/OpenAPI3/addr/stage.json',
				data:{accessToken:'722974ee-1eca-4997-ad5d-95233b59e248',cd:cityNum},
				dataType:'json',
				success:function(data){
					data.result.forEach(function(item,index,array){
						chk1.append("<label class='btn btn-light border border-dark'>"+ 
										"<input type='checkbox' autocomplete='off' class='btn11'>"+item.addr_name+
									"</label>");
					});
				}
			});
		});
	});
	
	function maxLengthCheck(object) {
		if (object.value.length > object.maxLength) {
			object.value = object.value.slice(0, object.maxLength);
		}
	}
	
	
	
	
</script>
<div>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<a class="navbar-brand">가게추가</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarColor01" aria-controls="navbarColor01"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarColor01">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link" href="#"> <span
						class="sr-only"> (current) </span>
				</a></li>
			</ul>
			<ul class="navbar-nav">
				<li class="nav-item">
					<button id="add_store" class="btn btn-primary btn-lg">가게
						등록</button>
				</li>
			</ul>
		</div>
	</nav>
</div>
<!-- 
	가게번호, 가게명, 최소주문금액, 운영시간, 전화번호, 배달지역, 상호명, 사업자주소, 사업자 등록번호
	가게 프로필사진, 건물관리번호, 상세주소, 가게카테고리, 사장번호
	
	null 가능
	결제방법, 가게소개, 안내, 휴무일, 리뷰안내, 가게상태, 울트라콜, 광고클릭수
 -->
<div id="div_wrap">
	<form id="form_wrap" action="/delivery/owner/shopReg" method="post">
		<div class="form-group under_border">
			<h2>사업자정보</h2>
		</div>
		<div class="form-group under_border">
			<h2>가게정보</h2>
		</div>
		<div class="form-group under_border">
			<label for="shop_name"><b>가게명</b></label> <input type="text"
				class="form-control" id="shop_name" placeholder="가게명을 입력해주세요."
				name="name" required>
		</div>
		<div class="form-group under_border">
			<label><b>결제방법</b></label>
			<div class="form-check">
				<label class="form-check-label"> 
				<input type="radio"	class="form-check-input" name="payment_option">만나서결제
				</label>
			</div>
			<div class="form-check">
				<label class="form-check-label"> 
				<input type="radio"	class="form-check-input" name="payment_option">바로결제
				</label>
			</div>
			<div class="form-check">
				<label class="form-check-label"> 
				<input type="radio"	class="form-check-input" name="payment_option" checked="checked">만나서결제,바로결제
				</label>
			</div>
		</div>
		<div class="form-group under_border">
			<label for="min_price"><b>최소주문금액</b></label><br> 
			<input type="number" min="0" max="100000" step="500" maxlength="6" name="min_price" id="min_price" oninput="maxLengthCheck(this)">원
		</div>
		<div class="form-group under_border">
			<label><b>운영시간</b></label>
			<div>
				<div class="row">
					<a id="open_time" class="col-md-2">오픈시간: </a> <input type="text"
						class="form-control col-md-3" id="shop_open_time" name="open_time">
					<a id="open_close" class="col-md-1">~</a> <a id="close_time"
						class="col-md-2">마감시간: </a> <input type="text"
						class="form-control col-md-3" id="shop_close_time"
						name="close_time">
				</div>
			</div>
		</div>
		<div class="form-group has-feedback under_border">
			<label for="shop_phone"><b>전화번호</b></label> <input type="text"
				class="form-control" id="shop_phone" placeholder="'-'를 빼고 입력해주세요."
				name="shop_phone" required> <span id="shop_phone_err"
				class="help-block">올바른 전화번호 형식이 아닙니다. 다시 입력해 주세요.</span>
		</div>
		<div class="form-group under_border">
			<label for="mutual_name"><b>가게 상호명</b></label> <input type="text"
				class="form-control" id="mutual_name" placeholder="가게 상호명을 입력해 주세요."
				name="mutual_name" required>
		</div>
		<div class="form-group has-feedback under_border">
			<label for="reg_num"><b>사업자등록번호</b></label> <input type="text"
				class="form-control" id="reg_num" placeholder="사업자등록번호를 입력해 주세요."
				name="reg_num" required> <span id="reg_num_err"
				class="help-block">올바른 사업자등록번호 형식이 아닙니다. 다시 입력해 주세요.</span>
		</div>
		<div class="form-group has-feedback under_border">
			<label for="address_detail"><b>상세주소</b></label> <input type="text"
				class="form-control" id="address_detail"
				placeholder="상세주소를 입력해 주세요." name="address_detail" required>
			<span id="address_detail_err" class="help-block">올바른 상세주소 형식이
				아닙니다. 다시 입력해 주세요.</span>
		</div>

		<div class="form-group under_border" id="deliveryArea">
			<label for="sel1"><b>배달지역</b></label> 
			<select class="form-control" id="sel1">
				<option value="null">-- 시,도를 선택해주세요 --</option>
				<option value="11">서울특별시</option>
				<option value="21">부산광역시</option>
				<option value="22">대구광역시</option>
				<option value="23">인천광역시</option>
				<option value="24">광주광역시</option>
				<option value="25">대전광역시</option>
				<option value="26">울산광역시</option>
				<option value="31">경기도</option>
				<option value="32">강원도</option>
				<option value="33">충청북도</option>
				<option value="34">충청남도</option>
				<option value="35">전라북도</option>
				<option value="36">전라남도</option>
				<option value="37">경상북도</option>
				<option value="38">경상남도</option>
				<option value="39">제주특별자치도</option>
			</select>
			<!-- 시군구 --> 
			<select class="form-control" id="sel2"></select>
			<!-- 읍면동 -->
			<div class="btn-group-toggle" data-toggle="buttons" id="chk1"></div>
		</div>
		<div class="form-group under_border">
			<label for="">사업자주소</label> <input type="text" class="form-control"
				id="" placeholder="사업자주소" name="" required>
		</div>
		<div class="form-group under_border">
			<label for="">건물관리번호</label> <input type="text" class="form-control"
				id="" placeholder="건물관리번호" name="" required>
		</div>
		<div class="form-group under_border">
			<label for="">가게카테고리</label> <input type="text" class="form-control"
				id="" placeholder="가게카테고리" name="" required>
		</div>
		<div class="form-group under_border">
			<label for="">가게 프로필사진</label> <input type="text"
				class="form-control" id="" placeholder="가게 프로필사진" name="" required>
		</div>
		<div class="form-group under_border">
			<label for="">가게소개</label> <input type="text" class="form-control"
				id="" placeholder="가게소개" name="" required>
		</div>
		<div class="form-group under_border">
			<label for="">안내</label> <input type="text" class="form-control"
				id="" placeholder="안내" name="" required>
		</div>
		<div class="form-group under_border">
			<label for="">휴무일</label>
			<div class="row">
				<input type="checkbox" class="form-control col-md-1" id=""
					placeholder="휴무일" name="" required>
			</div>
		</div>
		<div class="form-group under_border">
			<label for="">리뷰안내</label> <input type="text" class="form-control"
				id="" placeholder="리뷰안내" name="" required>
		</div>

		<!-- 
	가게명, 최소주문금액, 운영시간, 전화번호, 배달지역, 상호명, 사업자주소, 사업자 등록번호
	가게 프로필사진, 건물관리번호, 상세주소, 가게카테고리(한식,중식)(checkbox)
	
	사장번호,가게번호		-- 입력X
	
	광고클릭수,
	
	울트라콜,가게상태,결제방법 -- 가게 관리
	
	null 가능
	가게소개, 안내(정보탭에 안내 및 혜택), 휴무일, 리뷰안내 -- 입력할 수도 있고 아닐 수도 있고
 -->
		<div class="form-group form-check">
			<label class="form-check-label"></label> <input type="submit"
				id="btn1" class="btn btn-primary btn-lg float-right" value="가게등록">
		</div>
	</form>
</div>