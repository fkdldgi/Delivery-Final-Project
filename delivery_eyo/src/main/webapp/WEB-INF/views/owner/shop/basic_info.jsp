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


</style>
<div id="div_wrap">
	<form id="form_wrap" action="${pageContext.request.contextPath }/owner/shop/basicinfo" method="post" enctype="multipart/form-data">
		<div class="form-group under_border">
			<h2>��������</h2>
		</div>
		<input type="hidden" name="shopNum" value="${vo.num }"> 
		<div class="form-group under_border">
			<label for="">���� �����ʻ���</label><br>
			<img src="${pageContext.request.contextPath }/resources/profile/${profile_img }" class="rounded-circle" id="preview" width="70" height="70">
			<input type="hidden" name="profile_img" value="${profile_img }"> 
			<input type="file" name="file1" accept="image/*" id="file" required>
		</div>
		<div class="form-group under_border">
			<label for="introduce">���ԼҰ�</label> 
			<textarea class="form-control" cols="30" rows="5" placeholder="���ԼҰ��� ���� ������ �Է��ϼ���" id="introduce" name="introduce" required></textarea>
		</div>
		<div class="form-group has-feedback under_border">
			<label for="tel">��ȭ��ȣ</label> 
			<input type="text" class="form-control" id="tel" placeholder="'-'�� ���� �Է����ּ���." name="tel" required> 
			<span id="tel_err" class="help-block">�ùٸ� ��ȭ��ȣ ������ �ƴմϴ�. �ٽ� �Է��� �ּ���.</span>
		</div>
		<div class="form-group has-feedback under_border">
			<label>���Ի���</label> 
			<div class="form-check">
				<label class="form-check-label"> 
				<input type="radio"	class="form-check-input" name="status" value="0">close
				</label>
			</div>
			<div class="form-check">
				<label class="form-check-label"> 
				<input type="radio"	class="form-check-input" name="status" value="1" required>open
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

//��ȭ��ȣ Ȯ��
var phone_status = 1;
$("#tel").keyup(function() {
	var tel = $(this).val();
	var reg = /^\d{3}\d{3,4}\d{4}$/;
	if (reg.test(tel)) {
		$("#tel_err").hide();
		phone_status = 0;
	} else {
		$("#tel_err").show();
		phone_status = 1;
	}
});

//�����ʻ��� ����� readURL�Լ� ȣ��
$("#file").change(function() {
    readURL(this);
});

$("#preview").click(function(){
	$("#file").click();
});

//�����ʻ��� ���ý� �̸������ֱ�
function readURL(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();
        reader.onload = function(e) {
            $('#preview').attr('src', e.target.result);
        }
        reader.readAsDataURL(input.files[0]);
    }
}

	
</script>