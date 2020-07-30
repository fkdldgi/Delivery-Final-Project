<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<style type="text/css">
#thumbimg{
	margin-top: 50px;
	margin-bottom: 50px;
}
</style>
</head>
<body>
<div class="container">
	<div id="thumbimg">
		<img name="01" class="img-responsive" src="/delivery/resources/images/event_thumb01.jpg"  width="1000" height="250" onclick="location.href='/delivery/member/event01?coupon_num=1&memberNum=${memberNum}'">
	</div>
	<div id="thumbimg">
		<img name="01" class="img-responsive" src="/delivery/resources/images/event_thumb02.jpg" width="1000" height="250" onclick="location.href='/delivery/member/event02?coupon_num=2&memberNum=${memberNum}'"> 
	</div>
	<div id="thumbimg">
		<img name="01" class="img-responsive" src="/delivery/resources/images/event_thumb03.png"  width="1000" height="250" onclick="location.href='/delivery/member/event03?coupon_num=3&memberNum=${memberNum}'"> 
	</div>
	<div id="thumbimg">
		<img  name="01" class="img-responsive" src="/delivery/resources/images/event_thumb04.jpg"  width="1000" height="250" onclick="location.href='/delivery/member/event04?coupon_num=4&memberNum=${memberNum}'"> 
	</div>
</div>
</body>
</html>