<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" src="/delivery/resources/js/jquery-ui.js"></script>
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
			var div2 = $('#copy_div').clone();
			div2.css("display","block");
			div2.attr("name","main_menu");
			div2.removeAttr("id");
			$("div[name=append_main_menu]").append(div2);
		});
		
		// main_menu 밑에 있는 메뉴 삭제를 눌렀을 때 div가 삭제 마지막 div인 경우에는 삭제 불가
		$("#remove_main_menu").on('click',function(){
			
			var div = $('div[name=main_menu]');
			if(div.length > 1){
				div.last().remove();
			}else{
				alert("더 이상 삭제 불가합니다.");
			}
		});
		
		$("img").on('click',function(e){
			console.log('1');
		});
	});
</script>
<body>
	<div id="copy_div" style="display: none;">
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
						<img style="margin-left: 50px; width: 500px; height: 180px; border: 1px solid black;" src="/delivery/resources/images/plus2.png">										
					</div>
	</div>
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
			<c:forEach var="list" items="${requestScope.mainMenuList }">
				<div name="main_menu">
					<div>
						<div style="width: 50%; height: 200px; float:left; margin-top: 20px; text-align: center; border-left: 3px solid #FC5230;">
							<input style="width: 70%; margin: 15px; margin-top: 30px;" type="text" value="${list.name }" placeholder="메뉴이름">
							<br>
							<input style="width: 70%; margin: 15px; margin-top: 0px;" type="text"  value="${list.menu_info }" placeholder="메뉴구성">
							<br>
							<input style="width: 70%; margin: 15px; margin-top: 0px;" type="text" value="${list.price }" placeholder="가격">
						</div>
					</div>
					<div style="margin-top: 20px; width: 50%; height: 200px; float:right; text-align: center; border-right: 3px solid #FC5230;">
						<c:choose>
							<c:when test="${empty list.img }">
								<img style="margin-left: 50px; width: 500px; height: 180px; border: 1px solid black;" src="/delivery/resources/images/plus2.png">										
							</c:when>
							<c:otherwise>	
							<!-- DB에 들어있는 이미지 경로 src에 넣기 -->
								<img style="margin-left: 50px; width: 500px; height: 180px; border: 1px solid black;" src="${list.img } ">										
							</c:otherwise>
						</c:choose>
					</div>
				</div>
			</c:forEach>
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
		
		<!-- 메뉴카테고리 명 -->
		<c:forEach var="list" items="${requestScope.menuCategoryList }">
			<div name="category_name" style="margin: auto; margin-top: 20px; width: 80%;height: 100%">
				<div style="margin-top: 10px; width: 100%; font-weight: 900; background-color: lightgray; padding: 10px; border: none;">
				 	<div style="position: relative; text-align: center; height: 40px;">
				 		<div style="display: inline-block; text-align: center;"><h2>${list.name }</h2></div>
				 		<div style="position: absolute; display: inline-block; text-align: right; right: 1px;"><h2>∧∨</h2></div>
				 	</div>
				</div>			
			</div>
			<!-- 메뉴 -->
			<div name="menu" style="width: 80%; margin: auto; margin-top: 0px; padding-top: 0px; border: 1px solid lightgray;">
				<div style="margin-top: 15px; margin-bottom: 15px; padding-left: 100px;">
					<h2>메뉴이름</h2>
					<span>menu_info</span>
					<br>
					<span>menu_price</span>
				</div>
			</div>
		</c:forEach>
	</div>
	<div style="text-align: right;">
		<button id="update_menu">수정완료</button>
	</div>
</body>

























