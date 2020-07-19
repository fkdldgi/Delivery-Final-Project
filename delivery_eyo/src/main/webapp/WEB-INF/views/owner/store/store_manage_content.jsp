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
			var div2 = $('#copy_main_menu').clone();
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
		
		// 메뉴추가
		
		$("input[name=add_menu]").on('click',function(){
			
			var copy_menu = $("#copy_menu").clone();
			copy_menu.css('display','block');
			copy_menu.attr('name','menu');
			copy_menu.removeAttr('id');
			
			var a = $(this).parent();
			a.prev().append(copy_menu);
			
		});
		
		// 메뉴 삭제
		$("input[name=remove_menu]").on("click",function(){
			
			console.log('remove_menu');
			
			var target = $(this).parent().prev().children("div[name=menu]:last");
			target.remove();
		});
		
		// 카테고리 추가
		$("#add_category_menu").on('click',function(){
			// 카테고리 메뉴 복사
			var copy_category_menu = $("#copy_category_menu").clone();
			copy_category_menu.css('display','block');
			copy_category_menu.attr('name','category_name');
			// copy_category_menu.name='category_name';
			copy_category_menu.removeAttr('id');
			
			// 메뉴 복사
			var copy_menu = $("#copy_menu").clone();
			copy_menu.css('display','block');
			copy_menu.attr('name','menu');
			// copy_menu.name='menu';
			copy_menu.removeAttr('id');
			
			// 버튼 복사
			var copy_button = $("#copy_button").clone();
			copy_button.css('display','block');
			copy_button.removeAttr('id');
			
			// 전체를 감쌀 div 만들기
			var div1 = $("#div1").clone();
			div1.removeAttr('id');
			div1.css('display','block');
			div1.append(copy_category_menu);
			div1.append(copy_menu);
			div1.append(copy_button);
			$("#add_menu_wrap").append(div1);
			
			$("input[name=add_menu]").on('click',function(){
				var copy_menu = $("#copy_menu").clone();
				copy_menu.css('display','block');
				copy_menu.css('width','100%');
				copy_menu.attr('name','menu');
				copy_menu.removeAttr('id');
				
				var a = $(this).parent();
				a.prev().append(copy_menu);
			});
			
			// 카테고리 div 눌렀을 때 div숨기고, 나타내기
			$("div[name=category_name]").on('click',function(){
				var cate = $(this).nextAll();
				// 위 아래로 나타태는 효과
				cate.animate({
					height: 'toggle'
				});
			});
			
		});
		
		// 카테고리 삭제
		$("#remove_category_menu").on('click',function(){
			// 전체 카테고리
			var category = $("div[name=category]");
			
			// 전체 카테고리 중 마지막 div
			var category1 = $("div[name=category]:last");
			
			// 전체 카테고리 크기가 2 이상일때만 삭제 가능
			if(category.length > 2){
				category1.remove();
			}else{
				alert("대표메뉴는 삭제가 불가능 합니다.");
			}
			
		});
		
		// 이미지 추가
		$("img").on('click',function(e){
			console.log('이미지 추가 버튼');
		});
		
		// 카테고리 div 눌렀을 때 div숨기고, 나타내기
		$("div[name=category_name]").on('click',function(){
			var cate = $(this).nextAll();
			// 위 아래로 나타태는 효과
			cate.animate({
				height: 'toggle'
			});
		});
		
	});
	
</script>
<body>
	<!-- 복사할 메인메뉴 -->
	<div id="copy_main_menu" style="display: none;">
		<div>
			<div style="width: 50%; height: 200px; float:left; margin-top: 20px; text-align: center; border-left: 3px solid #FC5230;">
				<input name="menu_name" style="width: 70%; margin: 15px; margin-top: 30px;" type="text" placeholder="메뉴이름">
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
	
	<!-- 복사할 카테고리메뉴 -->
	<div id="copy_category_menu" style="display: none; margin: auto; margin-top: 20px; width: 80%;height: 100%">
		<div style="margin-top: 10px; width: 100%; font-weight: 900; background-color: lightgray; padding: 10px; border: none;">
			<div style="position: relative; text-align: center; height: 40px;">
				<div style="display: inline-block; text-align: center; width: 40%;"><h2><input style="text-align: center; width: 100%;" type="text" placeholder="메뉴카테고리명을 입력해 주세요."></h2></div>
				<div style="position: absolute; display: inline-block; text-align: right; right: 1px;"><h2>∧∨</h2></div>
			</div>
		</div>			
	</div>
	
		<!-- 복사할 메뉴 -->		
	<div id="copy_menu"  style="display: none; width: 80%; margin: auto; margin-top: 0px; padding-top: 0px; border: 1px solid lightgray;">
		<div style="margin-top: 15px; margin-bottom: 15px; padding-left: 100px;">
			<h2><input type="text" placeholder="메뉴이름을 입력해 주세요." style="width: 40%;"></h2>
			<span>메뉴설명:&nbsp;<input name="menu_info" type="text" placeholder="메뉴설명을 입력해 주세요." style="width: 35%;"></span>
			<br>
			<span>가격:&nbsp;&nbsp;<input type="number" min="0" max="100000" step="500" maxlength="6" name="min_price"
				oninput="maxLengthCheck(this)" placeholer="가격">원</span>
		</div>
	</div>
	
	<!-- 복사할 버튼 -->
	<div  id="copy_button" style="text-align: center; display: none;">
		<input name="add_menu" type="button" style="width: 40%; margin-top: 20px;" class="btn btn-primary"
			value="메뉴 추가">
		<input name="remove_menu" type="button" style="width: 40%; margin-top: 20px;" class="btn btn-primary" 
			value="메뉴 삭제">
	</div>
	
	<div id="div1" name="category" style="display: none;"></div>
<!-- 
	주문안내 shop_info
	메뉴이름 menu_name
	메뉴설명 menu_info
	메뉴가격 min_price
 -->
	<form action="/delivery/owner/store_manage" method="post">
		<div id="menu_wrap">
		<div id="add_menu_wrap">
			<br>
			<div>
				<h1>${sessionScope.ownerId } 회원님의 ${requestScope.vo.name }</h1>
				<p>위치: ${requestScope.vo.addr }
			</div>
			<div id="menu_bar">
				<h3 style="text-align: center;">메뉴관리</h3>
			</div>
			<h4 style="margin-left: 15px; ">주문안내: &nbsp;&nbsp;<input name="shop_info" style="width: 30%; " type="text" placeholder="주문안내" value="${requestScope.vo.info }"></h4>
			
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
				<input id="add_main_menu" type="button" style="width: 40%; margin-top: 20px;" class="btn btn-primary"
					value="대표메뉴 추가">
				<input id="remove_main_menu" type="button" style="width: 40%; margin-top: 20px;" class="btn btn-primary"
					value="대표메뉴 삭제">
			</div>
			<br><br>
			
			<!-- 메뉴카테고리 명 -->
			<c:forEach var="list" items="${menuCategoryList }" >
				<div name="category">
					<div name="category_name" style="margin: auto; margin-top: 20px; width: 80%;height: 100%">
						<div style="margin-top: 10px; width: 100%; font-weight: 900; background-color: lightgray; padding: 10px; border: none;">
						 	<div style="position: relative; text-align: center; height: 40px;">
						 		<div style="display: inline-block; text-align: center; width: 40%;"><h2><input name="menu_category_name" style="text-align: center; width: 100%;"type="text" placeholder="메뉴카테고리명을 입력해 주세요." 
						 						value="${list.name }"></h2></div>
						 		<div style="position: absolute; display: inline-block; text-align: right; right: 1px;"><h2>∧∨</h2></div>
						 	</div>
						</div>			
					</div>
					<div>
					<c:forEach var="menu" items="${menu }" >
						<c:if test="${list.num == menu.menu_category_num }">
							<!-- 메뉴 -->		
							<div name="menu" style="width: 80%; margin: auto; margin-top: 0px; padding-top: 0px; border: 1px solid lightgray;">
								<div style="margin-top: 15px; margin-bottom: 15px; padding-left: 100px;">
									<h2><input name="menu_name" type="text" placeholder="메뉴이름을 입력해 주세요." value="${menu.name }" style="width: 40%;"></h2>
									<span>메뉴설명:&nbsp;<input name="menu_info" placeholder="메뉴설명을 입력해 주세요." type="text" value="${menu.menu_info }" style="width: 35%;"></span>
						
									<br>
									<span>가격:&nbsp;&nbsp;<input value="${menu.price }" type="number" min="0" max="100000" step="500" maxlength="6" name="min_price"
										oninput="maxLengthCheck(this)" placeholder="가격"></span>
								</div>
							</div>
						</c:if>
					</c:forEach>
					</div>
				
					<!-- 메뉴추가, 삭제 버튼 -->
					<div style="text-align: center;">
						<input name="add_menu" type="button" style="width: 40%; margin-top: 20px;" class="btn btn-primary"
							value="메뉴 추가">
						<input name="remove_menu" type="button" style="width: 40%; margin-top: 20px;" class="btn btn-primary" 
							value="메뉴 삭제">
					</div>
				</div>
			</c:forEach>
			</div>
			<!-- 카테고리메뉴 추가, 삭제 버튼  -->
			<div style="text-align: center; margin-top: 30px;">
				<input id="add_category_menu" type="button" style="width: 40%; margin-top: 20px;" class="btn btn-primary"
					value="카테고리메뉴 추가">
				<input id="remove_category_menu" type="button" style="width: 40%; margin-top: 20px;" class="btn btn-primary"
					value="카테고리메뉴 삭제">
			</div>
		</div>
		<div style="text-align: right; width: 80%; margin-top: 50px;">
			<input id="update_menu" type="submit" class="btn btn-lg btn-primary" value="수정완료">
		</div>
	</form>
</body>
























