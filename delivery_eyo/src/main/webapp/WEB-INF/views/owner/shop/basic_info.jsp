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
	<form id="form_wrap" action="${pageContext.request.contextPath }/owner/shop/basicinfo" method="post" enctype="multipart/form-data">
		<div class="form-group under_border">
			<h2>가게정보</h2>
		</div>
		<input type="hidden" name="shopNum" value="${vo.num }"> 
		<div class="form-group under_border">
			<label for="">가게 프로필사진</label><br>
			<img src="${pageContext.request.contextPath }/resources/profile/${profile_img }" class="rounded-circle" id="preview" width="70" height="70">
			<input type="hidden" name="profile_img" value="${profile_img }"> 
			<input type="file" name="file1" accept="image/*" id="file" required>
		</div>
		<div class="form-group under_border">
			<label for="introduce">가게소개</label> 
			<textarea class="form-control" cols="30" rows="5" placeholder="가게소개에 대한 내용을 입력하세요" id="introduce" name="introduce" required></textarea>
		</div>
		<div class="form-group has-feedback under_border">
			<label for="tel">전화번호</label> 
			<input type="text" class="form-control" id="tel" placeholder="'-'를 빼고 입력해주세요." name="tel" required> 
			<span id="tel_err" class="help-block">올바른 전화번호 형식이 아닙니다. 다시 입력해 주세요.</span>
		</div>
		<div class="form-group has-feedback under_border">
			<label>가게상태</label> 
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
			<input type="submit" id="btn1" class="btn btn-primary btn-lg float-right" value="수정">
		</div>
	</form>
</div>
<script>

//전화번호 확인
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

//프로필사진 변경시 readURL함수 호출
$("#file").change(function() {
    readURL(this);
});

$("#preview").click(function(){
	$("#file").click();
});

//프로필사진 선택시 미리보여주기
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