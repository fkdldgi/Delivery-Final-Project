<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<style>
/* navbar�� form �������� �ϱ� */
#div_wrap {
	margin-top: 50px;
}
/* form ��� ��ġ�ϱ� input�� border�� �ʹ� ���� �ʰ� ����� */
#form_wrap {
	margin: auto;
	padding: 10px;
	width: 60%;
}

/* ���� �ؿ� ����� �ְ�, ����� ��ġ ���� */
.under_border {
	padding-bottom: 20px;
	border-bottom: 1px solid #ced4da;
	margin-bottom: 30px;
}

/* submit ��ư�� �� �Ʒ��� ���� �ʰ� ������*/
#submit_btn {
	padding-bottom: 10px;
}

/* form_wrap�� �ִ�  �ؿ� �ߴ� span ������*/
#form_wrap .help-block {
	display: none;
	color: red;
}

/* input file ������ */
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
			<h2>�ֹ�����</h2>
		</div>
		<input type="hidden" name="shopNum" value="${shopVo.num }">
		<div class="form-group under_border">
			<label for="min_price">�ּ��ֹ��ݾ�</label><br> 
			<input type="number" min="0" max="100000" step="500" maxlength="6" name="min_price" id="min_price" oninput="maxLengthCheck(this)" value="${shopVo.min_price }" required>��
		</div>
		<div class="form-group under_border">
			<label for="delivery_tip">����� �Է�</label><br>
			<input type="number" min="0" max="100000" step="500" maxlength="5" name="tip" id="tip" oninput="maxLengthCheck(this)" value="${shopVo.min_price }" required>��
		</div>
		<div class="form-group under_border">
			<input type="hidden" name="sido" value="${del_locVo.sido }">
			<input type="hidden" name="sigungu" value="${del_locVo.sigungu }">
			<label>��������</label><br>
			<p><b>${del_locVo.sido }></b> ${del_locVo.sigungu }</p>
			<!-- ���鵿 -->
			<c:set var="hnameArr" value="${fn:split(del_locVo.hname,',')}"/> <!-- �޹����� jstl split���� �ɰ��� -->
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
			<input type="submit" id="btn1" class="btn btn-primary btn-lg float-right" value="����">
		</div>
	</form>
</div>
<script>
//�ּ��ֹ��ݾ� �ִ���� ����
function maxLengthCheck(object) {
	if (object.value.length > object.maxLength) {
		object.value = object.value.slice(0, object.maxLength);
	}
}

</script>