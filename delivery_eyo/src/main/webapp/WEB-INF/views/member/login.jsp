<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<style type="text/css">
#loginform{
	margin-left: 350px;
}
</style>
</head>
<body>
<div id="loginform">
	<form>
	  <div class="form-group">
	    <label for="exampleInputEmail1">아이디</label>
	    <input type="id" class="form-control" id="exampleInputEmail1" aria-describedby="id-help">
	    <small id="emailHelp" class="form-text text-muted">아이디는 특수문자를 포함하고 있습니다.</small>
	  </div>
	  <div class="form-group">
	    <label for="exampleInputPassword1">비밀번호</label>
	    <input type="password" class="form-control" id="exampleInputPassword1">
	  </div>
	  <div class="form-group form-check">
	    <input type="checkbox" class="form-check-input" id="exampleCheck1">
	    <label class="form-check-label" for="exampleCheck1">Check me out</label>
	  </div>
	  <button type="submit" class="btn btn-primary">로그인</button>
	</form>
</div>
</body>
</html>