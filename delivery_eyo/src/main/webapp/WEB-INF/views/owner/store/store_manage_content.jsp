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
	// 메뉴 추가했다가 다시 삭제하는 거 안됨
	var category_menu_menu = 0;
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
		
		// 메뉴추가()
		
		/* $("input[name=add_menu]").on('click',function(){
			
			var copy_menu = $("#copy_menu").clone();
			copy_menu.css('display','block');
			copy_menu.attr('name','menu');
			copy_menu.removeAttr('id');
			
			var a = $(this).parent();
			a.prev().append(copy_menu);
			
		}); */
		
		
			/*
			주문안내 shop_info
			메뉴이름 menu_name
			메뉴설명 menu_info
			메뉴가격 min_price
			*/
		var category_hit = 0;
		// 카테고리 추가
		$("#add_category_menu").on('click',function(){
			// 카테고리 메뉴 복사
			var copy_category_menu = $("#copy_category_menu").clone();
			copy_category_menu.css('display','block');
			copy_category_menu.attr('name','category_name');
			// copy_category_menu.name='category_name';
			copy_category_menu.removeAttr('id');
			
			// 바꿀값 얻어와서 int로 바꿈
			var a = parseInt(copy_category_menu.find("input[name=category_num]").val());
			// hit랑 합침
			var b = a+category_hit;
			category_menu_menu = b;
			// 넣을 input타입 얻어오기
			var c = copy_category_menu.find("input[name=category_num]");
			// input타입 val 설정
			c.attr("value",b);
			
			// 여러번할때마다 -1더함
			category_hit += -1;
			
			console.log("가져온 값"+a);
			console.log("새로 넣어야 할 값: "+b);
			console.log(c);
			console.log("가져온 값2"+a);
			console.log("c타입:"+c.val());
			console.log('---');
			console.log(category_menu_menu);
			
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
			
			var zzz=$("#add_menu_wrap").append(div1); 
			div1.append("<input type='text' hidden='hidden' name='category_list_num' value='"+category_menu_menu+"'>");
			
			//"<input typ리 div 눌렀을 때 div숨기고, 나타내기
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
			var num = category1.find("input[name=category_num]").val();
			
			var trash_category = $("#trash").clone();
			trash_category.removeAttr('id');
			trash_category.attr('name','trash_category');
			trash_category.val(num);
			
			var trash_can = $("#trash_can");
			trash_can.append(trash_category);
			
			if(category.length > 2){
				category1.remove();
			}else{
				alert("대표메뉴는 삭제가 불가능 합니다.");
			}
		});
		
		/*메뉴랑 메뉴카테고리 추가할 때 ajax로 넘기기*/
		
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
		
		// 메뉴 삭제
		$("input[name=remove_menu]").on("click",function(){			
			var target = $(this).parent().prev().children("div[name=menu]:last");
			var num = target.find("input[name=menu_num]").val();
			var num1 = target.fin("input[name=category_list_num]").val();
			console.log(num1);
			
			if(num1 == -1){
				target.remove();
			}else{
				
			var trash = $("#trash").clone();
			trash.removeAttr('id');
			trash.attr('name','trash');
			trash.val(num);
			var trash_can = $("#trash_can");
			trash_can.append(trash);
			
			target.remove();			
			}
		});
	});
	
	//메뉴 추가 함수
	function menu_add(menu_category_num, aa){		
		var copy_menu = $("#copy_menu").clone();
		copy_menu.css('display','block');
		copy_menu.attr('name','menu');
		copy_menu.removeAttr('id');
		
		//var mcm = menu_category_num;
		
		if(menu_category_num >= 0){
			// mcm=category_menu_menu;
			copy_menu.append("<input type='text' hidden='hidden' name='category_list_num' value='"+menu_category_num+"'>");
		}else{
			
			copy_menu.css('width','100%');
			var a = $(aa).parent().parent().find("input[name=category_list_num]");
			// var name_list_num = a.find("input[name=category_list_num]:last");
			
			//copy_menu.append("<input type='text' name='category_list_num' value='"+mcm+"'>");
			copy_menu.append("<input type='text' hidden='hidden' name='category_list_num' value='"+a.val()+"'>");
		}
		
		var b = $(aa).parent();
		b.prev().append(copy_menu);
	}
</script>
<body>
	<input id="trash" type="text" style="display:none;">
	<!-- 삭제한 값 넣기 -->
	<!-- 복사할 메인메뉴 -->
	<div id="copy_main_menu" style="display: none;">
		<div>
			<div style="width: 50%; height: 200px; float:left; margin-top: 20px; text-align: center; border-left: 3px solid #FC5230;">
				<input name="menu_name" style="width: 70%; margin: 15px; margin-top: 30px;" type="text" placeholder="메뉴이름" required="required">
				<br>
				<input style="width: 70%; margin: 15px; margin-top: 0px;" type="text" placeholder="메뉴구성" required="required">
				<br>
				<input style="width: 70%; margin: 15px; margin-top: 0px;" type="text" placeholder="가격" required="required">
			</div>
		</div>
		<div style="margin-top: 20px; width: 50%; height: 200px; float:right; text-align: center; border-right: 3px solid #FC5230;">
			<img style="margin-left: 50px; width: 500px; height: 180px; border: 1px solid black;" src="/delivery/resources/images/plus2.png">										
		</div>
	</div>
	
	<!-- 복사할 카테고리메뉴 -->
	<div id="copy_category_menu" style="display: none; margin: auto; margin-top: 20px; width: 80%;height: 100%">
		<input type="text" name="category_num" style="display:none;" value="-1">
		<div style="margin-top: 10px; width: 100%; font-weight: 900; background-color: lightgray; padding: 10px; border: none;">
			<div style="position: relative; text-align: center; height: 40px;">
				<div style="display: inline-block; text-align: center; width: 40%;"><h2><input name="menu_category_name" style="text-align: center; width: 100%;" type="text" required="required" placeholder="메뉴카테고리명을 입력해 주세요."></h2></div>
				<div style="position: absolute; display: inline-block; text-align: right; right: 1px;"><h2>∧∨</h2></div>
			</div>
		</div>			
	</div>
	
	<!-- 복사할 메뉴 -->		
	<div id="copy_menu"  style="display: none; width: 80%; margin: auto; margin-top: 0px; padding-top: 0px; border: 1px solid lightgray;">
		<input type="text" name="menu_num" value="-1" style="display: none;">
		<div class="menu_wrap" style="margin-top: 15px; margin-bottom: 15px; padding-left: 100px;">
			<h2><input type="text" name="menu_name" placeholder="메뉴이름을 입력해 주세요." style="width: 40%;" required="required"></h2>
			<span>메뉴설명:&nbsp;<input name="menu_info" type="text" placeholder="메뉴설명을 입력해 주세요." style="width: 35%;" required="required"></span>
			<br>
			<span>가격:&nbsp;&nbsp;<input type="number" min="0" max="100000" step="500" maxlength="6" required="required" name="min_price"
				oninput="maxLengthCheck(this)" placeholer="가격">원</span>
				
		</div>
	</div>
	
	<!-- 복사할 버튼 -->
	<div  id="copy_button" style="text-align: center; display: none;">
		<input name="add_menu" type="button" style="width: 40%; margin-top: 20px;" class="btn btn-primary"
			value="메뉴 추가" onclick='menu_add(-1,this)'>
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
		<!-- 아이디 -->
		<input type="text" name="owner_id" hidden="hidden" value="${sessionScope.ownerId }">
		<!-- 가게번호 얻어오기 -->
		<input type="text" name="Shop_num" value="${Shop_num }" hidden="hidden">
		<div id="trash_can" style="display:none;"></div>
		
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
						<input type="text" name="category_num" style="display:none;" value="${list.num }">
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
								<input type="text" name="menu_num" value="${menu.num}" style="display: none;">
								
								<div style="margin-top: 15px; margin-bottom: 15px; padding-left: 100px;"><!-- 여기에 input append해주기 -->
								
									<h2><input name="menu_name" type="text" placeholder="메뉴이름을 입력해 주세요." value="${menu.name }" style="width: 40%;"></h2>
									<span>메뉴설명:&nbsp;<input name="menu_info" placeholder="메뉴설명을 입력해 주세요." type="text" value="${menu.menu_info }" style="width: 35%;"></span>
						
									<br>
									<span>가격:&nbsp;&nbsp;<input value="${menu.price }" type="number" min="0" max="100000" step="500" maxlength="6" name="min_price"
										oninput="maxLengthCheck(this)" placeholder="가격"></span>
									<input type="text" name="category_list_num" style="display:none;" value="${list.num }">
									
								</div>
							</div>
						</c:if>
					</c:forEach>
					</div>
				
					<!-- 메뉴추가, 삭제 버튼 -->
					<div style="text-align: center;">
						<input name="add_menu" type="button" style="width: 40%; margin-top: 20px;" class="btn btn-primary"
							value="메뉴 추가" onclick='menu_add(${list.num},this)'>
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
























