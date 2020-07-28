<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<link href="/delivery/resources/css/owner/TimePicker/mdtimepicker.css" rel="stylesheet">
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

/* submit 버튼이 맨 아래에 붙지 않게 떼어줌*/
#submit_btn {
	padding-bottom: 10px;
}

/* form_wrap에 있는  밑에 뜨는 span 가리기*/
#form_wrap .help-block {
	display: none;
	color: red;
}

/* input file 가리기 */
#file{
	display: none;
}

.form-group label{
	font-weight: 700;
}
/* 휴무일,가게카테고리 margin */
#personal_days label,#shop_categories label{
	margin: 0px 15px 5px 0px;
}


</style>
<div id="div_wrap">
	<form id="form_wrap" action="${pageContext.request.contextPath }/owner/shop/operationinfo" method="post">
		<div class="form-group under_border">
			<h2>운영정보</h2>
		</div>
		<input type="hidden" name="shopNum" value="${vo.num }">
		<c:set var="categoriesArr" value="${fn:split(vo.shop_category,' ')}"/> <!-- 가게카테고리 jstl split으로 쪼개기 -->
		<div class="form-group under_border">
			<label>가게카테고리</label> 
			<div class="btn-group-toggle" data-toggle="buttons" id="shop_categories">
				
					<label class='btn btn-light border border-dark'>
						<input type='checkbox' name='shop_category' value='프랜차이즈' 
						<c:forEach items="${categoriesArr }" var="category">
							<c:if test="${category=='프랜차이즈' }">
								checked 
							</c:if>
						</c:forEach>>프랜차이즈
					</label>
					<label class='btn btn-light border border-dark'>
						<input type='checkbox' name='shop_category' value='치킨'
						<c:forEach items="${categoriesArr }" var="category">
							<c:if test="${category=='치킨' }">
								checked 
							</c:if>
						</c:forEach>>치킨
					</label>
					<label class='btn btn-light border border-dark'>
						<input type='checkbox' name='shop_category' value='중국집'
						<c:forEach items="${categoriesArr }" var="category">
							<c:if test="${category=='중국집' }">
								checked 
							</c:if>
						</c:forEach>>중국집
					</label>
					<label class='btn btn-light border border-dark'>
						<input type='checkbox' name='shop_category' value='양식'
						<c:forEach items="${categoriesArr }" var="category">
							<c:if test="${category=='양식' }">
								checked 
							</c:if>
						</c:forEach>>양식
					</label>
					<label class='btn btn-light border border-dark'>
						<input type='checkbox' name='shop_category' value='한식'
						<c:forEach items="${categoriesArr }" var="category">
							<c:if test="${category=='한식' }">
								checked 
							</c:if>
						</c:forEach>>한식
					</label>
					<label class='btn btn-light border border-dark'>
						<input type='checkbox' name='shop_category' value='카페'
						<c:forEach items="${categoriesArr }" var="category">
							<c:if test="${category=='카페' }">
								checked 
							</c:if>
						</c:forEach>>카페
					</label>
					<label class='btn btn-light border border-dark'>
						<input type='checkbox' name='shop_category' value='일식'
						<c:forEach items="${categoriesArr }" var="category">
							<c:if test="${category=='일식' }">
								checked 
							</c:if>
						</c:forEach>>일식
					</label>
					<label class='btn btn-light border border-dark'>
						<input type='checkbox' name='shop_category' value='족발/보쌈'
						<c:forEach items="${categoriesArr }" var="category">
							<c:if test="${category=='족발/보쌈' }">
								checked 
							</c:if>
						</c:forEach>>족발/보쌈
					</label>
					<label class='btn btn-light border border-dark'>
						<input type='checkbox' name='shop_category' value='야식'
						<c:forEach items="${categoriesArr }" var="category">
							<c:if test="${category=='프랜차이즈' }">
								checked 
							</c:if>
						</c:forEach>>야식
					</label>
					<label class='btn btn-light border border-dark'>
						<input type='checkbox' name='shop_category' value='분식'
						<c:forEach items="${categoriesArr }" var="category">
							<c:if test="${category=='분식' }">
								checked 
							</c:if>
						</c:forEach>>분식
					</label>
			</div>
		</div>
		<div class="form-group under_border">
			<label>결제방법</label>
			<div class="form-check">
				<label class="form-check-label"> 
				<input type="radio"	class="form-check-input" name="payment_option" value="만나서결제" <c:if test="${vo.payment_option=='만나서결제' }">checked</c:if> required>만나서결제
				</label>
			</div>
			<div class="form-check">
				<label class="form-check-label"> 
				<input type="radio"	class="form-check-input" name="payment_option" value="바로결제" <c:if test="${vo.payment_option=='바로결제' }">checked</c:if>>바로결제
				</label>
			</div>
			<div class="form-check">
				<label class="form-check-label"> 
				<input type="radio"	class="form-check-input" name="payment_option" value="만나서결제,바로결제" <c:if test="${vo.payment_option=='만나서결제,바로결제' }">checked</c:if>>만나서결제,바로결제
				</label>
			</div>
		</div>
		<div class="form-group under_border">
			<label>운영시간</label>
			<div>
				<div class="row">
					<a id="open_time" class="col-md-2">오픈시간: </a> 
					<input type="text" class="form-control col-md-3" id="shop_open_time" name="open_time" value="${vo.open_time }" required>
					<a id="open_close" class="col-md-1">~</a> 
					<a id="close_time" class="col-md-2">마감시간: </a> 
					<input type="text" class="form-control col-md-3" id="shop_close_time" name="close_time" value="${vo.close_time }" required>
				</div>
			</div>
		</div>
		<div class="form-group under_border">
			<c:set var="personal_dayArr" value="${fn:split(vo.personal_day,',')}"/> <!-- 휴무일을 jstl split으로 쪼개기 -->
			<label for="">휴무일</label><br>
			<div class="btn-group-toggle" data-toggle="buttons" id="personal_days">
				<label class='btn btn-light border border-dark'>
					<input type='checkbox' autocomplete='off' name='personal_day' value='연중무휴' 
						<c:forEach items="${personal_dayArr }" var="personal_day">
							<c:if test="${personal_day=='연중무휴' }">
								checked 
							</c:if>
						</c:forEach>>연중무휴
				</label>
				<label class='btn btn-light border border-dark'>
					<input type='checkbox' autocomplete='off' name='personal_day' value='월' 
					<c:forEach items="${personal_dayArr }" var="personal_day">
							<c:if test="${personal_day=='월' }">
								checked 
							</c:if>
						</c:forEach>>월
				</label>
				<label class='btn btn-light border border-dark'>
					<input type='checkbox' autocomplete='off' name='personal_day' value='화' 
					<c:forEach items="${personal_dayArr }" var="personal_day">
							<c:if test="${personal_day=='화' }">
								checked 
							</c:if>
						</c:forEach>>화
				</label>
				<label class='btn btn-light border border-dark'>
					<input type='checkbox' autocomplete='off' name='personal_day' value='수' 
					<c:forEach items="${personal_dayArr }" var="personal_day">
							<c:if test="${personal_day=='수' }">
								checked 
							</c:if>
						</c:forEach>>수
				</label>
				<label class='btn btn-light border border-dark'>
					<input type='checkbox' autocomplete='off' name='personal_day' value='목' 
					<c:forEach items="${personal_dayArr }" var="personal_day">
							<c:if test="${personal_day=='목' }">
								checked 
							</c:if>
						</c:forEach>>목
				</label>
				<label class='btn btn-light border border-dark'>
					<input type='checkbox' autocomplete='off' name='personal_day' value='금' 
					<c:forEach items="${personal_dayArr }" var="personal_day">
							<c:if test="${personal_day=='금' }">
								checked 
							</c:if>
						</c:forEach>>금
				</label>
				<label class='btn btn-light border border-dark'>
					<input type='checkbox' autocomplete='off' name='personal_day' value='토' 
					<c:forEach items="${personal_dayArr }" var="personal_day">
							<c:if test="${personal_day=='토' }">
								checked 
							</c:if>
						</c:forEach>>토
				</label>
				<label class='btn btn-light border border-dark'>
					<input type='checkbox' autocomplete='off' name='personal_day' value='일' 
					<c:forEach items="${personal_dayArr }" var="personal_day">
							<c:if test="${personal_day=='일' }">
								checked 
							</c:if>
						</c:forEach>>일
				</label>
			</div>
		</div>

		<div class="form-group form-check">
			<label class="form-check-label"></label>
			<input type="submit" id="btn1" class="btn btn-primary btn-lg float-right" value="수정">
		</div>
	</form>
</div>
<script>

//가게 운영시간 입력하는 시계 띄우기
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

//운영시간 (오픈시간과 영업시간이 같거나 오픈시간이 더 늦고 마감시간이 더 빠를 때)
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
});

//휴무일 클릭시 checkbox에 checked추가 삭제
$("label.btn").on('click',function(){ //라벨을 클릭했을 때
	if($(this).hasClass('active')===true){ //체크를 해제했을 경우 (active클래스가 존재한다는 것) 
		if($(this).children().val()=='연중무휴'){
			$("#personal_days").children('label.btn').each(function(index,item){ //연중무휴,월,...,일
				if(index>0){
					$(this).removeAttr('disabled'); //라벨 비활성화
					$(this).children().removeAttr('disabled');
				}
			});
		}else{
			$(this).children().removeAttr('checked');
		}
	}else if($(this).hasClass('active')===false){ //체크를 했을경우
		if($(this).children().val()=='연중무휴'){
			$("#personal_days").children('label.btn').each(function(index,item){ //연중무휴,월,...,일
				if(index>0){
					$(this).attr('disabled','disabled'); //라벨 비활성화
					$(this).removeClass('active'); //active클래스 삭제
					$(this).children().removeAttr('checked'); //체크박스의 checked삭제
					$(this).children().attr('disabled','disabled');
				}
			});
		}else{
			if($(this).attr('disabled')!='disabled'){ //라벨이 disabled가 아닐경우
				$(this).children().attr('checked', 'checked'); //체크박스에 checked 추가			
			}
		}
		
	}
});

</script>