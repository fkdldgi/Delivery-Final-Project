<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	$(document).ready(function(){
		// 댓글달기 버튼을 눌렀을 경우
		$("input[name=reply]").on('click',function(){
			// 버튼 나타내기
			var reply_button_area = $(this).next();			
			reply_button_area.css('display','block');		
			
			// textarea 나타내기
			var reply_area = $(this).parent().parent().parent().next();
			reply_area.animate({
				height: 'toggle'
			});
			
			// 댓글달기버튼 숨기기
			$(this).css('display','none');
		});
		
		// 댓글취소 눌렀을 경우
		$("input[name=reply_cancle]").on('click',function(){
			// 댓글달기 버튼 나타내기
			var reply = $(this).parent().prev();
			reply.css('display','block');
			
			// textarea 숨기기
			var reply_area = reply.parent().parent().parent().next();
			reply_area.animate({
				height: 'toggle'
			});
			
			// 댓글달기, 댓글취소버튼 숨기기
			$(this).parent().css('display','none');
			
		});
		
		// 기업회원댓글이 있을 때 버튼 없애기
		$("textarea[name='content1']").each(function(){
			if($(this).text() != ''){
				// 리뷰내용, 댓글버튼이 있는 div
				var div = $(this).parent().parent().prev();
				var reply = div.find("input[name=reply]");
				
				reply.css('display','none');			
			}
		});
	});
</script>
<style>

</style>

<!-- img 넣는 div -->
<div style="margin: auto; padding: auto; width: 80%; text-align: center;">
	<img src="/delivery/resources/images/review.png" style="margin: auto; margin-top: 0px; margin-bottom: 0px; padding: auto; padding-top: 0px; padding-bottom: 0px; width: 500px; height: 150px;">
</div>

<!-- 댓글 넣을 div -->
<div style="margin: auto; padding: auto; padding-top: 15px; width: 60%; border-top: 1px solid lightgray;">
	<!-- 가게에 따라서 넣은 리뷰 전체 구해 for문 -->
	<c:forEach var="list" items="${requestScope.shopReviewList }">
		<div style="margin-bottom: 30px; padding-bottom: 30px; border-bottom: 1px solid lightgray;">
			<!-- 맨 위에 있을 한줄 -->
			<div style="width: 100%; height: 50px; ">
				<!-- 이미지가 있는지 없는지 -->
				<div style="width: 10%; height: 100%; float:left; text-align: right;">
					<c:choose>
						<c:when test="${list.img == 0 }">
							<img src="/delivery/resources/images/user.png" style="border-radius: 70%; width: 50px; height: 50px;">
						</c:when>
						<c:otherwise>
							<img src="/delivery/resources/images/user.png" style="border-radius: 70%; width: 50px; height: 50px;">
						</c:otherwise>
					</c:choose>
				</div>
				<!-- 이미지 옆에 회원아이디 별점 날짜 -->
				<div style="width: 85%; height: 100%; float: left; margin-left: 5px;">
					<!-- 회원아이디 -->
					<span style="font-weight: bold">${list.id }&nbsp;></span><br>	
					<span>평점&nbsp; ></span>
					<!-- 별점 -->
					<span>
						<c:choose>
							<c:when test="${list.grade eq '5' }">
								<img src="/delivery/resources/images/star_5.png" style="width: 100px; height: 25px;">
							</c:when>
							<c:when test="${list.grade eq '4' }">
								<img src="/delivery/resources/images/star_4.png" style="width: 100px; height: 25px;">
							</c:when>
							<c:when test="${list.grade eq '3' }">
								<img src="/delivery/resources/images/star_3.png" style="width: 100px; height: 25px;">
							</c:when>
							<c:when test="${list.grade eq '2' }">
								<img src="/delivery/resources/images/star_2.png" style="width: 100px; height: 25px;">
							</c:when>
							<c:when test="${list.grade eq '1' }">
								<img src="/delivery/resources/images/star_1.png" style="width: 100px; height: 25px;">
							</c:when>
						</c:choose>
					</span>
					<!-- 댓글 날짜 -->
					<span>${list.regdate }</span>
				</div>
			</div>
			
			<form action="/delivery/owner/store_manage/insertReview" method="post">
			<input type="text" name="shop_num" value="${vo.num }" hidden="hidden">
			<input type="text" name="ref" value="${list.num }" hidden="hidden">
			<div style="width: 100%; height: 250px;">
				<!-- 리뷰내용 -->
				<div style="margin-left: 10%; width: 70%; height: 100%; float: left;">
					<textarea rows="10" cols="80" style="align: left;" readonly="readonly">${list.content }</textarea>	
				</div>
				
				<div style="width: 20%; height: 100%; float: right; position: relative">
					<div style="position:absolute; bottom: 0px; right: 0px;">
						<!-- 댓글달기 버튼 -->
						<input name="reply" type="button" value="댓글달기" class="btn btn-primary btn-sm">
						
						<div style="display: none;">
							<!-- 댓글완료, 댓글 취소 -->
							<input name="reply_cancle" style="float:left; margin-right: 10px;" type="reset" value="댓글취소" class="btn btn-primary btn-sm">
							<input name="reply_complete" style="float:right;" type="submit" value="댓글완료" class="btn btn-primary btn-sm">
						</div>
					</div>
				</div>
			</div>		
			<c:forEach var="list2" items="${requestScope.shopRereviewList }">
				<c:choose>					
					<c:when test="${list.num == list2.ref }">
						<div style="width: 100%; height: 250px; text-align: right; margin-top: 20px;">
							<div style="margin-right: 0px; width: 70%; height: 100%; float: right;">
								<span>답글날짜: &nbsp;</span>
								<span style="font-weight: bold">${list2.regdate }</span>
								<br>
								<textarea name="content1" rows="10" cols="80" readonly="readonly">${list2.content }</textarea>
							</div>
						</div>
					</c:when>
					<c:otherwise>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<div style="width: 100%; height: 250px; text-align: right; margin-top: 20px; display: none;">
				<div style="margin-right: 0px; width: 70%; height: 100%; float: right;">
					<textarea name="content" rows="10" cols="80" placeholder="댓글에 대한 답변을 입력해 주세요."></textarea>
				</div>
			</div>					
			</form>
		</div>
	</c:forEach>
</div>









