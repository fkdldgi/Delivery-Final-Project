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
	<h2>����������</h2>
	<hr style="border: solid 1px orange;">
 	<span>������ �����Ͻ÷��� ��й�ȣ�� �Է��� �ּ���</span>
 	��й�ȣ :<input type="password" value="pwd">
	<input type="password" value="${vo.pwd}" id="pwdchk" hidden="hidden"> <!-- �� ������ vo���� ���� ���̵�� -->
	
	<!-- ���������� �͵� (��й�ȣ,�̸���,��ȭ��ȣ,�ּҴ�..?)-->
	<input type="button" value="pwdchkbtn" id="pwdchkbtn"> 
	<input>
</div>
</body>
<script type="text/javascript">
 	// var pwd=�� ���Ҥſ�
 	function name() {
		if (pwd==pwdchk) {
			
		}
	}
</script>
</html>