<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>myPage</title>
<style type="text/css">
.container{
	border: 2px solid orange;
}
</style>
</head>
<body>
<div class="container text-center">
	<h2>마이페이지</h2>
	<hr style="border: solid 1px orange;">
 	<span>정보를 수정하시려면 비밀번호를 입력해 주세요</span>
 	비밀번호 :<input type="password" value="pwd">
	<input type="password" value="${vo.pwd}" id="pwdchk" hidden="hidden"> <!-- 값 얻어오기 vo에서 얻어온 아이디로 -->
	
	<!-- 수정가능한 것들 (비밀번호,이메일,전화번호,주소는..?)-->
	<input type="button" value="pwdchkbtn" id="pwdchkbtn"> 
	<input>
</div>
</body>
<script type="text/javascript">
 	// var pwd=값 가죠ㅕ와
 	function name() {
		if (pwd==pwdchk) {
			
		}
	}
</script>
</html>