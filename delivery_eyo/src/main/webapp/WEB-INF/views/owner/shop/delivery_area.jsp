<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
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

/* ������� css */
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
<div id="div_wrap">
	<form id="form_wrap" action="${pageContext.request.contextPath }/owner/shop/deliveryLocation" method="post">
		<input type="hidden" name="num" value="${vo.num }">
		<div class="form-group under_border" id="deliveryArea">
			<label for="sel1">�������</label> 
			<select class="form-control" id="sel1">
				<option value="null">-- ��,���� �������ּ��� --</option>
				<option value="11">����Ư����</option>
				<option value="21">�λ걤����</option>
				<option value="22">�뱸������</option>
				<option value="23">��õ������</option>
				<option value="24">���ֱ�����</option>
				<option value="25">����������</option>
				<option value="26">��걤����</option>
				<option value="31">��⵵</option>
				<option value="32">������</option>
				<option value="33">��û�ϵ�</option>
				<option value="34">��û����</option>
				<option value="35">����ϵ�</option>
				<option value="36">���󳲵�</option>
				<option value="37">���ϵ�</option>
				<option value="38">��󳲵�</option>
				<option value="39">����Ư����ġ��</option>
			</select>
			<!-- �ñ��� --> 
			<select class="form-control" id="sel2"></select>
			<!-- ���鵿 -->
			<div class="btn-group-toggle" data-toggle="buttons" id="chk1"></div>
		</div>
		<div class="form-group form-check">
			<label class="form-check-label"></label>
			<input type="submit" id="btn1" class="btn btn-primary btn-lg float-right" value="�Ϸ�">
		</div>
	</form>
</div>
<script>
var accessToken="";	
//�������� ��������ū ������
$.ajax({
	url:"https://sgisapi.kostat.go.kr/OpenAPI3/auth/authentication.json",
	data:{consumer_key:"22368008e43f41cbaa0b",consumer_secret:"497a4a53690046ff9233"},
	dataType:'json',
	success:function(data){
		accessToken=data.result.accessToken;
	}
});
var chk1=$("#chk1");
//������� �ñ��� ������(accessToken�� 4�ð����� ��ȿ)
$("#sel1").change(function(){
	
	
	var cityNum=this.value;
	var sel2=$("#sel2");
	if($("#deliveryArea input[name='delivery_sido']")!=null){
		$("#deliveryArea input[name='delivery_sido']").remove();
	}
	$("#deliveryArea").append("<input type='hidden' name='delivery_sido' value='"+$("#sel1 option:checked").text()+"'>");
	chk1.empty();
	sel2.empty();
	$.ajax({
		url:'https://sgisapi.kostat.go.kr/OpenAPI3/addr/stage.json',
		data:{accessToken:accessToken,cd:cityNum},
		dataType:'json',
		success:function(data){
			sel2.append("<option value='null'>-- ��,��,���� �������ּ��� --</option>");
			data.result.forEach(function(item,index,array){
				sel2.append("<option value='"+item.cd+"'>"+item.addr_name+"</option>");
			});
		}
	});
});

//�������  ���鵿 ������(accessToken�� 4�ð����� ��ȿ)
$("#sel2").change(function(){
	var cityNum=this.value;
	if($("#deliveryArea input[name='delivery_sigungu']")!=null){
		$("#deliveryArea input[name='delivery_sigungu']").remove();
	}
	$("#deliveryArea").append("<input type='hidden' name='delivery_sigungu' value='"+$("#sel2 option:checked").text()+"'>");
	
	chk1.empty();
	$.ajax({
		url:'https://sgisapi.kostat.go.kr/OpenAPI3/addr/stage.json',
		data:{accessToken:accessToken,cd:cityNum},
		dataType:'json',
		success:function(data){
			data.result.forEach(function(item,index,array){
				chk1.append("<label class='btn btn-light border border-dark'>"+ 
								"<input type='checkbox' autocomplete='off' name='addr_name' value='"+item.addr_name+"'>"+item.addr_name+
							"</label>");
			});
			$("label.btn").on('click',function(){ //���� Ŭ������ ��
				if($(this).hasClass('active')===true){ //activeŬ������ �����Ѵٴ� ���� üũ�� ������ ��
					$(this).children().removeAttr('checked');
				}else if($(this).hasClass('active')===false){
					$(this).children().attr('checked', 'checked');
				}
			});
		}
	});
});
</script>