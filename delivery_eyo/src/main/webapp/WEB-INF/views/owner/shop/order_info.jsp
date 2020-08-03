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

/* ���鵿 margin */
#chk1 label{
	margin: 0px 15px 5px 0px;
}

</style>
<div id="div_wrap">
	<form id="form_wrap" action="${pageContext.request.contextPath }/owner/shop/orderinfo" method="post">
		<div class="form-group under_border">
			<h2>�ֹ�����</h2>
		</div>
		<input type="hidden" name="num" value="${vo.num }">
		<div class="form-group under_border">
			<label for="min_price">�ּ��ֹ��ݾ�</label><br> 
			<input type="number" min="0" max="100000" step="500" maxlength="6" name="min_price" id="min_price" oninput="maxLengthCheck(this)" value="${vo.min_price }" required>��
		</div>
		<button type="button" class="btn btn-primary" id="btn1" onclick="showTip()">������߰�</button> <!-- �� ���� ��ư�� type="button"�� �ָ� ��ư���θ� ��밡�� -->
		<div class="form-group under_border d-none" id="tip_wrap">
			<input type="hidden" name="sido" value="${del_locVo.sido }">
			<input type="hidden" name="sigungu" value="${del_locVo.sigungu }">
			<label>��������</label><br>
			<p><b>${del_locVo.sido }></b> ${del_locVo.sigungu }</p>
			<!-- ���鵿 -->
			<%-- <c:set var="lochnameArr" value="${fn:split(del_locVo.hname,',')}"/> <!-- �������� jstl split���� �ɰ��� --> --%>
			<div class="btn-group-toggle" data-toggle="buttons" id="chk1">			
				<c:forEach items="${tipList }" var="hname">
					<label class='btn btn-light border border-dark'> 
						<input type='checkbox' autocomplete='off' name='hname' value='${hname }'>${hname }
					</label>
				</c:forEach>
				<br><br>
				<label for="tip">����� �Է�</label><br>
				<input type="number" min="0" max="100000" step="500" maxlength="5" name="tip" id="tip" oninput="maxLengthCheck(this)" value="0" required>��
				<br><br>
				<button type="button" class="btn btn-primary" id="cancleBtn" onclick="hideTip()">���</button>
				<button type="button" class="btn btn-primary" id="addBtn" onclick="addTip()">�Ϸ�</button>
			</div>
		</div>

		<div class="form-group form-check">
			<label class="form-check-label"></label>
			<input type="submit" id="btn1" class="btn btn-primary btn-lg float-right" value="����">
		</div>
	</form>
</div>
<script>
//����� �߰� ���̱�
function showTip(){
	$("#tip_wrap").removeClass("d-none");
	$("#btn1").addClass("d-none");
}
//����� �߰� �����
function hideTip(){
	$("#tip_wrap").addClass("d-none");
	$("#btn1").removeClass("d-none");
}
function addTip(){
	var num=$('input[name="num"]').val();
	var tip=$("#tip").val();
	var sido=$('input[name="sido"]').val();
	var sigungu=$('input[name="sigungu"]').val();
	var hnames=new Array();
	$('input[name=hname]:checked').each(function(index){
		hnames.push(this.value);	
	});
	var hname="";
	for(let i=0; i<hnames.length; i++){
		if(i==hnames.length-1){
			hname+=hnames[i];
		}else{
			hname+=hnames[i]+",";
		}
	}
	$.ajax({
		url:"/delivery/owner/shop/deliveryTip",
		data:{shop_num:num,tip:tip,sido:sido,sigungu:sigungu,hname:hname},
		success:function(data){
			if(data==1){
				alert('������ ����� �����Ϸ�');
				location.reload(); //����� ���� �Ϸ� �� ���ΰ�ħ
			}else{
				alert("����� ���� ����!");
			}
		}
	});
}

$("label.btn").on('click',function(){ //���� Ŭ������ ��
	if($(this).hasClass('active')===true){ //activeŬ������ �����Ѵٴ� ���� üũ�� ������ ��
		$(this).children().removeAttr('checked');
	}else if($(this).hasClass('active')===false){
		$(this).children().attr('checked',true);
	}
});

//�ּ��ֹ��ݾ� �ִ���� ����
function maxLengthCheck(object) {
	if (object.value.length > object.maxLength) {
		object.value = object.value.slice(0, object.maxLength);
	}
}


</script>