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
	���̵� :<input type="text" value="${vo.id}" readonly="readonly"><br> 
 	<span>������ �����Ͻ÷��� ��й�ȣ�� �Է��� �ּ���</span><br>
 	��й�ȣ :<input type="password" value="pwd"><br>
	<input type="password" value="${vo.pwd}" id="pwdchk" hidden="hidden"> <!-- �� ������ vo���� ���� ���̵�� -->
	<input type="button" value="pwdchkbtn" id="pwdchkbtn"> 
	<!-- ���������� �͵� (��й�ȣ,�̸���,��ȭ��ȣ,�ּҴ�..?)-->
	
	<form>
	<h2>ȸ������ ����</h2>
	  <div class="form-group">
	    <label for="exampleInputEmail1">�̸���</label>
	    <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" style="margin-left: 100px">
	  </div>
	  <div class="form-group">
	    <label for="exampleInputPassword1">��ȭ��ȣ</label>
	    <input type="password" class="form-control" id="exampleInputPassword1">
	  </div>
	  <div class="form-group form-check">
	    <h2>�ּҺ���</h2>
	  <button class="btn btn-outline-success" onclick="sample5_execDaumPostcode()" type="button">�ּ� �˻�</button>
	  <input type="text" id="building_nanagement_number" value="${vo.building_nanagement_number}">
	  <label for="exampleInputPassword1">���ּ�</label>
	  <input type="text" id="address_detail" value="${vo.address_detail}">
	  </div>
	<br>
	  <button type="submit" class="btn btn-primary">Submit</button>
	</form>
</div>
</body>
<script type="text/javascript">
 	// var pwd=�� ���Ҥſ�
 	function expose() {
		if (pwd==pwdchk) {
			
		}
	}
 	
</script>
</html>