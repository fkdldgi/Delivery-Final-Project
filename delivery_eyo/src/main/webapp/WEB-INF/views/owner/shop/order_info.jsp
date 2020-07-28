<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
		<input type="hidden" name="shopNum" value="${shopVo.num }">
		<div class="form-group under_border">
			<label for="min_price">최소주문금액</label><br> 
			<input type="number" min="0" max="100000" step="500" maxlength="6" name="min_price" id="min_price" oninput="maxLengthCheck(this)" value="${shopVo.min_price }" required>원
		</div>
		<div class="form-group under_border">
			<label for="delivery_tip">배달팁 입력</label><br>
			<input type="number" min="0" max="100000" step="500" maxlength="5" name="tip" id="tip" oninput="maxLengthCheck(this)" value="${shopVo.min_price }" required>원
		</div>
		<div class="form-group under_border">
			<input type="hidden" name="sido" value="${del_locVo.sido }">
			<input type="hidden" name="sigungu" value="${del_locVo.sigungu }">
			<label>지역선택</label><br>
			<p><b>${del_locVo.sido }></b> ${del_locVo.sigungu }</p>
			<!-- 읍면동 -->
			<c:set var="hnameArr" value="${fn:split(del_locVo.hname,',')}"/> <!-- 휴무일을 jstl split으로 쪼개기 -->
			<div class="btn-group-toggle" data-toggle="buttons" id="chk1">			
				<c:forEach items="${hnameArr }" var="hname">
					<label class='btn btn-light border border-dark'> 
						<input type='checkbox' autocomplete='off' name='hname' value='${hname }'>${hname }
					</label>
				</c:forEach>
			</div>
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