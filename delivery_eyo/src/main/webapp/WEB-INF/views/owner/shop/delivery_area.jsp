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

/* 배달지역 css */
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
			<label for="sel1">배달지역</label> 
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
		<div class="form-group form-check">
			<label class="form-check-label"></label>
			<input type="submit" id="btn1" class="btn btn-primary btn-lg float-right" value="완료">
		</div>
	</form>
</div>
<script>
var accessToken="";	
//동적으로 엑세스토큰 얻어오기
$.ajax({
	url:"https://sgisapi.kostat.go.kr/OpenAPI3/auth/authentication.json",
	data:{consumer_key:"22368008e43f41cbaa0b",consumer_secret:"497a4a53690046ff9233"},
	dataType:'json',
	success:function(data){
		accessToken=data.result.accessToken;
	}
});
var chk1=$("#chk1");
//배달지역 시군구 얻어오기(accessToken은 4시간동안 유효)
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
			sel2.append("<option value='null'>-- 시,군,구를 선택해주세요 --</option>");
			data.result.forEach(function(item,index,array){
				sel2.append("<option value='"+item.cd+"'>"+item.addr_name+"</option>");
			});
		}
	});
});

//배달지역  읍면동 얻어오기(accessToken은 4시간동안 유효)
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
			$("label.btn").on('click',function(){ //라벨을 클릭했을 때
				if($(this).hasClass('active')===true){ //active클래스가 존재한다는 것은 체크를 해제한 것
					$(this).children().removeAttr('checked');
				}else if($(this).hasClass('active')===false){
					$(this).children().attr('checked', 'checked');
				}
			});
		}
	});
});
</script>