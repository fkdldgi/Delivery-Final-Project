<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<link href="/delivery/resources/css/owner/TimePicker/mdtimepicker.css" rel="stylesheet">
<script src="//code.jquery.com/jquery.min.js"></script>
<script src="/delivery/resources/css/owner/TimePicker/mdtimepicker.js"></script>
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
/* �޹���,����ī�װ� margin */
#personal_days label,#shop_categories label{
	margin: 0px 15px 5px 0px;
}


</style>
<div id="div_wrap">
	<form id="form_wrap" action="${pageContext.request.contextPath }/owner/shop/operationinfo" method="post">
		<div class="form-group under_border">
			<h2>�����</h2>
		</div>
		<input type="hidden" name="shopNum" value="${vo.num }">
		<c:set var="categoriesArr" value="${fn:split(vo.shop_category,' ')}"/> <!-- ����ī�װ� jstl split���� �ɰ��� -->
		<div class="form-group under_border">
			<label>����ī�װ�</label> 
			<div class="btn-group-toggle" data-toggle="buttons" id="shop_categories">
				
					<label class='btn btn-light border border-dark'>
						<input type='checkbox' name='shop_category' value='����������' 
						<c:forEach items="${categoriesArr }" var="category">
							<c:if test="${category=='����������' }">
								checked 
							</c:if>
						</c:forEach>>����������
					</label>
					<label class='btn btn-light border border-dark'>
						<input type='checkbox' name='shop_category' value='ġŲ'
						<c:forEach items="${categoriesArr }" var="category">
							<c:if test="${category=='ġŲ' }">
								checked 
							</c:if>
						</c:forEach>>ġŲ
					</label>
					<label class='btn btn-light border border-dark'>
						<input type='checkbox' name='shop_category' value='�߱���'
						<c:forEach items="${categoriesArr }" var="category">
							<c:if test="${category=='�߱���' }">
								checked 
							</c:if>
						</c:forEach>>�߱���
					</label>
					<label class='btn btn-light border border-dark'>
						<input type='checkbox' name='shop_category' value='���'
						<c:forEach items="${categoriesArr }" var="category">
							<c:if test="${category=='���' }">
								checked 
							</c:if>
						</c:forEach>>���
					</label>
					<label class='btn btn-light border border-dark'>
						<input type='checkbox' name='shop_category' value='�ѽ�'
						<c:forEach items="${categoriesArr }" var="category">
							<c:if test="${category=='�ѽ�' }">
								checked 
							</c:if>
						</c:forEach>>�ѽ�
					</label>
					<label class='btn btn-light border border-dark'>
						<input type='checkbox' name='shop_category' value='ī��'
						<c:forEach items="${categoriesArr }" var="category">
							<c:if test="${category=='ī��' }">
								checked 
							</c:if>
						</c:forEach>>ī��
					</label>
					<label class='btn btn-light border border-dark'>
						<input type='checkbox' name='shop_category' value='�Ͻ�'
						<c:forEach items="${categoriesArr }" var="category">
							<c:if test="${category=='�Ͻ�' }">
								checked 
							</c:if>
						</c:forEach>>�Ͻ�
					</label>
					<label class='btn btn-light border border-dark'>
						<input type='checkbox' name='shop_category' value='����/����'
						<c:forEach items="${categoriesArr }" var="category">
							<c:if test="${category=='����/����' }">
								checked 
							</c:if>
						</c:forEach>>����/����
					</label>
					<label class='btn btn-light border border-dark'>
						<input type='checkbox' name='shop_category' value='�߽�'
						<c:forEach items="${categoriesArr }" var="category">
							<c:if test="${category=='����������' }">
								checked 
							</c:if>
						</c:forEach>>�߽�
					</label>
					<label class='btn btn-light border border-dark'>
						<input type='checkbox' name='shop_category' value='�н�'
						<c:forEach items="${categoriesArr }" var="category">
							<c:if test="${category=='�н�' }">
								checked 
							</c:if>
						</c:forEach>>�н�
					</label>
			</div>
		</div>
		<div class="form-group under_border">
			<label>�������</label>
			<div class="form-check">
				<label class="form-check-label"> 
				<input type="radio"	class="form-check-input" name="payment_option" value="����������" <c:if test="${vo.payment_option=='����������' }">checked</c:if> required>����������
				</label>
			</div>
			<div class="form-check">
				<label class="form-check-label"> 
				<input type="radio"	class="form-check-input" name="payment_option" value="�ٷΰ���" <c:if test="${vo.payment_option=='�ٷΰ���' }">checked</c:if>>�ٷΰ���
				</label>
			</div>
			<div class="form-check">
				<label class="form-check-label"> 
				<input type="radio"	class="form-check-input" name="payment_option" value="����������,�ٷΰ���" <c:if test="${vo.payment_option=='����������,�ٷΰ���' }">checked</c:if>>����������,�ٷΰ���
				</label>
			</div>
		</div>
		<div class="form-group under_border">
			<label>��ð�</label>
			<div>
				<div class="row">
					<a id="open_time" class="col-md-2">���½ð�: </a> 
					<input type="text" class="form-control col-md-3" id="shop_open_time" name="open_time" value="${vo.open_time }" required>
					<a id="open_close" class="col-md-1">~</a> 
					<a id="close_time" class="col-md-2">�����ð�: </a> 
					<input type="text" class="form-control col-md-3" id="shop_close_time" name="close_time" value="${vo.close_time }" required>
				</div>
			</div>
		</div>
		<div class="form-group under_border">
			<c:set var="personal_dayArr" value="${fn:split(vo.personal_day,',')}"/> <!-- �޹����� jstl split���� �ɰ��� -->
			<label for="">�޹���</label><br>
			<div class="btn-group-toggle" data-toggle="buttons" id="personal_days">
				<label class='btn btn-light border border-dark'>
					<input type='checkbox' autocomplete='off' name='personal_day' value='���߹���' 
						<c:forEach items="${personal_dayArr }" var="personal_day">
							<c:if test="${personal_day=='���߹���' }">
								checked 
							</c:if>
						</c:forEach>>���߹���
				</label>
				<label class='btn btn-light border border-dark'>
					<input type='checkbox' autocomplete='off' name='personal_day' value='��' 
					<c:forEach items="${personal_dayArr }" var="personal_day">
							<c:if test="${personal_day=='��' }">
								checked 
							</c:if>
						</c:forEach>>��
				</label>
				<label class='btn btn-light border border-dark'>
					<input type='checkbox' autocomplete='off' name='personal_day' value='ȭ' 
					<c:forEach items="${personal_dayArr }" var="personal_day">
							<c:if test="${personal_day=='ȭ' }">
								checked 
							</c:if>
						</c:forEach>>ȭ
				</label>
				<label class='btn btn-light border border-dark'>
					<input type='checkbox' autocomplete='off' name='personal_day' value='��' 
					<c:forEach items="${personal_dayArr }" var="personal_day">
							<c:if test="${personal_day=='��' }">
								checked 
							</c:if>
						</c:forEach>>��
				</label>
				<label class='btn btn-light border border-dark'>
					<input type='checkbox' autocomplete='off' name='personal_day' value='��' 
					<c:forEach items="${personal_dayArr }" var="personal_day">
							<c:if test="${personal_day=='��' }">
								checked 
							</c:if>
						</c:forEach>>��
				</label>
				<label class='btn btn-light border border-dark'>
					<input type='checkbox' autocomplete='off' name='personal_day' value='��' 
					<c:forEach items="${personal_dayArr }" var="personal_day">
							<c:if test="${personal_day=='��' }">
								checked 
							</c:if>
						</c:forEach>>��
				</label>
				<label class='btn btn-light border border-dark'>
					<input type='checkbox' autocomplete='off' name='personal_day' value='��' 
					<c:forEach items="${personal_dayArr }" var="personal_day">
							<c:if test="${personal_day=='��' }">
								checked 
							</c:if>
						</c:forEach>>��
				</label>
				<label class='btn btn-light border border-dark'>
					<input type='checkbox' autocomplete='off' name='personal_day' value='��' 
					<c:forEach items="${personal_dayArr }" var="personal_day">
							<c:if test="${personal_day=='��' }">
								checked 
							</c:if>
						</c:forEach>>��
				</label>
			</div>
		</div>

		<div class="form-group form-check">
			<label class="form-check-label"></label>
			<input type="submit" id="btn1" class="btn btn-primary btn-lg float-right" value="����">
		</div>
	</form>
</div>
<script>

//���� ��ð� �Է��ϴ� �ð� ����
$('#shop_open_time').mdtimepicker({
	theme : 'indigo'
});
$('#shop_close_time').mdtimepicker({
	theme : 'indigo'
});

var open_time;
var close_time;

// �ð� function
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

//��ð� (���½ð��� �����ð��� ���ų� ���½ð��� �� �ʰ� �����ð��� �� ���� ��)
$("#form_wrap").submit(function(e) {
	var open = $("#shop_open_time").val();
	var close = $("#shop_close_time").val();
	console.log('1');
	if (open == "" || open == null) {
		alert("���½ð��� �����ּ���.");
	}
	if (close == "" || close == null) {
		alert("�����ð��� �����ּ���.");
		e.preventDefault();
	}
	if (open_time >= close_time) {
		alert("�����ð��� �ٽ� ������ �ּ���.");
		e.preventDefault();
	}
});

//�޹��� Ŭ���� checkbox�� checked�߰� ����
$("label.btn").on('click',function(){ //���� Ŭ������ ��
	if($(this).hasClass('active')===true){ //üũ�� �������� ��� (activeŬ������ �����Ѵٴ� ��) 
		if($(this).children().val()=='���߹���'){
			$("#personal_days").children('label.btn').each(function(index,item){ //���߹���,��,...,��
				if(index>0){
					$(this).removeAttr('disabled'); //�� ��Ȱ��ȭ
					$(this).children().removeAttr('disabled');
				}
			});
		}else{
			$(this).children().removeAttr('checked');
		}
	}else if($(this).hasClass('active')===false){ //üũ�� �������
		if($(this).children().val()=='���߹���'){
			$("#personal_days").children('label.btn').each(function(index,item){ //���߹���,��,...,��
				if(index>0){
					$(this).attr('disabled','disabled'); //�� ��Ȱ��ȭ
					$(this).removeClass('active'); //activeŬ���� ����
					$(this).children().removeAttr('checked'); //üũ�ڽ��� checked����
					$(this).children().attr('disabled','disabled');
				}
			});
		}else{
			if($(this).attr('disabled')!='disabled'){ //���� disabled�� �ƴҰ��
				$(this).children().attr('checked', 'checked'); //üũ�ڽ��� checked �߰�			
			}
		}
		
	}
});

</script>