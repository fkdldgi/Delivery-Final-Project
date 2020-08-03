<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<div class="container" style="text-align: center;">
		<hr style="border: 1px solid darkgray;">
	<br>
		<h1>매운 음식 할인</h1>
	<br>
		<hr style="border: 1px solid darkgray;">
	<br>
		<img class="d-block mx-auto mb-4" src="/delivery/resources/images/event04.png" width="900" height="1260" usemap="#imgMap">
		<map name="imgMap" id="imgMap">
		<area shape="rect" coords="216,680,670,765" onclick="coupon(${memberNum },${coupon_num })">
		</map>
	<br>
		<hr style="border: 1px solid darkgray;">
		<input type="button" value="목록으로" onclick="location.href='/delivery/member/event_main'" class="btn btn-primary"> 
	<br>
	<br>
</div>
</body>
<script type="text/javascript">
function coupon(memberNum ,coupon_num){
	if (memberNum==0) {
		alert("로그인 후 사용가능합니다.");
		location.href="/delivery/member/event_main"
		return
	}
	$.ajax({
		url:"/delivery/member/event",
		data:{memberNum:memberNum,coupon_num:coupon_num},
		success:function(data){
			if (data===0) {
				alert("이미 발급된 쿠폰입니다");
			}else if(data===1){
				alert("쿠폰이 발급되었습니다. (마이페이지 나의 쿠폰함에서 확인 가능합니다)");
			}
		}
	});
}
//이미지 좌표구하기
/* function getLoc(){
	var x= event.offsetX;
	var y=event.offsetY;
	alert("x"+x+","+"y"+y);
} */
</script>
</html>