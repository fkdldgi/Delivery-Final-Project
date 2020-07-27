<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
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


</style>
<div id="div_wrap">
	<form id="form_wrap" action="${pageContext.request.contextPath }/owner/shop/orderinfo" method="post">
		<div class="form-group under_border">
			<h2>주문정보</h2>
		</div>
		<input type="hidden" name="shopNum" value="${vo.num }">
		<div class="form-group under_border">
			<label for="min_price">최소주문금액</label><br> 
			<input type="number" min="0" max="100000" step="500" maxlength="6" name="min_price" id="min_price" oninput="maxLengthCheck(this)" required>원
		</div>
		<div class="form-group under_border">
			<label for="delivery_tip">지역별 배달팁</label><br> 
			<input type="number" name="delivery_tip" id="delivery_tip" required>원
		</div>

		<div class="form-group form-check">
			<label class="form-check-label"></label>
			<input type="submit" id="btn1" class="btn btn-primary btn-lg float-right" value="수정">
		</div>
	</form>
</div>
<script>
//최소주문금액 최대길이 검증
function maxLengthCheck(object) {
	if (object.value.length > object.maxLength) {
		object.value = object.value.slice(0, object.maxLength);
	}
}

</script>