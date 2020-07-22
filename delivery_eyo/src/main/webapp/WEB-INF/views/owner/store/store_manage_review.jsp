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
<div style="margin: auto; padding: auto; width: 80%; border-top: 1px solid lightgray;">
	<!-- 가게에 따라서 넣은 리뷰 전체 구해 for문 -->
	<c:forEach var="list" items="${requestScope.shopReviewList }">
		<div style="margin: auto; paddin: auto; width: 80%; border-top: 2px solid black;">
			<div style="text-align: left;">
				<c:choose>
					<c:when test="${list.img_path == 0 }">
						<img src="/delivery/resources/images/user.png" style="border-radius: 70%; width: 100px; height: 100px;">
					</c:when>
					<c:otherwise>
							리뷰2
					</c:otherwise>
				</c:choose>
			</div>
			<br>
		</div>
			<input style="text-align: right;" name="comment" type="button" value="댓글달기" class="btn btn-primary">
		
	</c:forEach>
</div>