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
		
		// main_menu 밑에 있는 메뉴 추가를 눌렀을 때 div가 추가됨
		$('#add_main_menu').on('click',function(){	
			var div2 = $('div[name=main_menu]').first().clone();
			$("div[name=append_main_menu]").append(div2);
		});
		
		// main_menu 밑에 있는 메뉴 삭제를 눌렀을 때 div가 삭제 마지막 div인 경우에는 삭제 불가
		$("#remove_main_menu").on('click',function(){
			
			var div = $('div[name=main_menu]');
			if(div.length > 1){
				div.last().remove();
			}else{
				alert("삭제 불가합니다.");
			}
		});
		
		$("img").on('click',function(e){
			
		});
	});
</script>
<body>
	<div id="menu_wrap">
		<br>
		<div>
			<h1>${sessionScope.ownerId } 회원님의 ${requestScope.vo.name }</h1>
			<p>위치: ${requestScope.vo.addr }
		</div>
		<div id="menu_bar">
			<h3 style="text-align: center;">메뉴관리</h3>
		</div>
		<h4 style="margin-left: 15px; ">주문안내: &nbsp;&nbsp;<input style="width: 30%; " type="text" placeholder="주문안내" value="${requestScope.vo.info }"></h4>
		
		<div name="append_main_menu" style="margin: auto; margin-top: 20px; border: 3px solid #FC5230;width: 80%;height: 100%">
			<h2 style="text-align: center; margin-top: 10px; width: 100%; color: brown; font-weight: 900;">대표 메뉴</h2>
			
			<div name="main_menu">
				<div>
					<div style="width: 50%; height: 200px; float:left; margin-top: 20px; text-align: center; border-left: 3px solid #FC5230;">
						<input style="width: 70%; margin: 15px; margin-top: 30px;" type="text" placeholder="메뉴이름">
						<br>
						<input style="width: 70%; margin: 15px; margin-top: 0px;" type="text" placeholder="메뉴구성">
						<br>
						<input style="width: 70%; margin: 15px; margin-top: 0px;" type="text" placeholder="가격">
					</div>
				</div>
				<div style="margin-top: 20px; width: 50%; height: 200px; float:right; text-align: center; border-right: 3px solid #FC5230;">	
					<img style="margin-left: 50px; width: 500px; height: 180px; border: 1px solid black;"src="/delivery/resources/images/plus2.png">			
				</div>
			</div>
		</div>
		<div style="text-align: center;">
			<button id="add_main_menu" style="width: 40%; margin-top: 20px;" class="btn btn-primary">
				대표메뉴 추가
			</button>
			<button id="remove_main_menu" style="width: 40%; margin-top: 20px;" class="btn btn-primary">
				대표메뉴 삭제
			</button>
		</div>
		<br><br>
		
		<div name="category_name" style="margin: auto; margin-top: 20px; border: 3px solid #CC9966;width: 80%;height: 100%">
			<h2 style="text-align: center; margin-top: 10px; width: 100%; color: brown; font-weight: 900;">대표 메뉴</h2>
			
			<div name="category_menu">
				<div>
					<div style="width: 50%; height: 200px; float:left; margin-top: 20px; text-align: center; border-left: 3px solid #CC9966;">
						<input style="width: 70%; margin: 15px; margin-top: 30px;" type="text" placeholder="메뉴이름">
						<br>
						<input style="width: 70%; margin: 15px; margin-top: 0px;" type="text" placeholder="메뉴구성">
						<br>
						<input style="width: 70%; margin: 15px; margin-top: 0px;" type="text" placeholder="가격">
					</div>
				</div>
				<div style="margin-top: 20px; width: 50%; height: 200px; float:right; border-right: 3px solid #CC9966; text-align: center;">
					<img style="margin-left: 50px; width: 500px; height: 180px; border: 1px solid black;"src="/delivery/resources/images/plus2.png">				
				</div>
			</div>
		</div>
		<div style="text-align: center;">
			<button id="add_category" style="width: 40%; margin-top: 20px;" class="btn btn-primary">
				메인메뉴 추가
			</button>
			<button id="remove_category" style="width: 40%; margin-top: 20px;" class="btn btn-primary">
				메인메뉴 삭제
			</button>
		</div>
		
		
	</div>
</body>

























