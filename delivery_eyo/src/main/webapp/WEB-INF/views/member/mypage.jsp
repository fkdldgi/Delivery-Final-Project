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
	아이디 :<input type="text" value="${vo.id}" readonly="readonly"><br> 
 	<span>정보를 수정하시려면 비밀번호를 입력해 주세요</span><br>
 	비밀번호 :<input type="password" value="pwd"><br>
	<input type="password" value="${vo.pwd}" id="pwdchk" hidden="hidden"> <!-- 값 얻어오기 vo에서 얻어온 아이디로 -->
	<input type="button" value="pwdchkbtn" id="pwdchkbtn"> 
	<!-- 수정가능한 것들 (비밀번호,이메일,전화번호,주소는..?)-->
	
	<form>
	<h2>회원정보 수정</h2>
	  <div class="form-group">
	    <label for="exampleInputEmail1">이메일</label>
	    <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" style="margin-left: 100px">
	  </div>
	  <div class="form-group">
	    <label for="exampleInputPassword1">전화번호</label>
	    <input type="password" class="form-control" id="exampleInputPassword1">
	  </div>
	  <div class="form-group form-check">
	    <h2>주소변경</h2>
	  <button class="btn btn-outline-success" onclick="sample5_execDaumPostcode()" type="button">주소 검색</button>
	  <input type="text" id="building_nanagement_number" value="${vo.building_nanagement_number}">
	  <label for="exampleInputPassword1">상세주소</label>
	  <input type="text" id="address_detail" value="${vo.address_detail}">
	  </div>
	<br>
	  <button type="submit" class="btn btn-primary">Submit</button>
	</form>
</div>
</body>
<script type="text/javascript">
 	// var pwd=값 가죠ㅕ와
 	function expose() {
		if (pwd==pwdchk) {
			
		}
	}
 	
</script>
</html>