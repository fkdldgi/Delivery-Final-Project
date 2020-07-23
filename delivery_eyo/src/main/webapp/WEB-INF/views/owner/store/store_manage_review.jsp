<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	$(document).ready(function(){
		
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
					<span>${list.id }&nbsp;></span><br>	
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
					<span>${list.regdate }</span>
				</div>
			</div>
			<div style="width: 100%; height: 250px;">
				<!-- 리뷰내용 -->
				<div style="margin-left: 10%; width: 70%; height: 100%; float: left;">
					<textarea rows="10" cols="70" style="align: left;">${list.content }</textarea>	
				</div>
				<div style="width: 20%; height: 100%; float: right; position: relative">
					<input style="bottom: 0px; right: 0px; position: absolute;" name="comment" type="button" value="댓글달기" class="btn btn-primary btn-sm">
				</div>
			</div>		
		</div>
	</c:forEach>
</div>









