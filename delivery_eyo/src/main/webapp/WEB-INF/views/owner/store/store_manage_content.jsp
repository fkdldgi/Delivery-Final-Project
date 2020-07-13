<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
	#menu_wrap{ margin: auto;
				padding: auto;
				width: 80%;
				margin-top: 10px;
				margin-bottom: 10px;
				}
	
	#menu_bar{
			  margin-top: 10px;
			  margin-bottom: 10px;
			  padding-top: 10px;
			  padding-bottom: 10px;
			  border-top: 1px solid black;
			  border-bottom: 1px solid black;
			  }
</style>
<script>
	$(document).ready(function(){
		
	});
</script>
<body>
	<div id="menu_wrap">
		<div id="menu_bar">
			<h3 style="text-align: center;">메뉴관리</h3>
		</div>
		<div>
			<input class="col-md-4" type="text" placeholder="주문안내를 입력해 주세요.">
		</div>
		<div style="margin-top: 10px; border: 3px solid brown;">
			<h4 style="margin: 15px; text-align: center;">대표메뉴</h4>
			<div style="margin: 15px; border: 1px solid brown;">
				<input style="margin: 15px;" class="col-md-4" type="text" placeholder="메뉴이름을 입력해 주세요.">
				<br>
				<input style=" margin: 15px; margin-top: 0px;" class="col-md-4" type="text" placeholder="메뉴구성을 입력해 주세요.">
			</div>
		</div>
		<div>
		
		</div>
	</div>
</body>