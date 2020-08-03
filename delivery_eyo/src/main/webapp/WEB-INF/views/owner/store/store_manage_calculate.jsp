<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script type="text/javascript" src="/delivery/resources/js/jquery-ui.js"></script>
<style>
	th{border: 3px solid black;}
	td{border: 1px solid lightgray;}
</style>
<html>
  <head>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
  </head>
  <body>
  	<!-- img 넣는 div -->
	<div style="margin: auto; padding: auto; width: 80%; text-align: center;">
		<img src="/delivery/resources/images/owner_cal.png" style="margin: auto; margin-top: 0px; margin-bottom: 0px; padding: auto; padding-top: 0px; padding-bottom: 0px; width: 500px; height: 150px;">
	</div>
	
	<!-- 년도 월 -->
	<div style="margin: auto; padding: auto; width: 80%; text-align: right;">
		<c:set var="now" value="<%=new java.util.Date()%>" />
		<c:set var="sysYear"><fmt:formatDate value="${now}" pattern="yyyy" /></c:set>
		<c:set var="sysMonth"><fmt:formatDate value="${now}" pattern="MM" /></c:set>
		<c:set var="sysDate"><fmt:formatDate value="${now}" pattern="dd" /></c:set>
		<select id="year">
			<c:forEach var="i" begin="1990" end="${sysYear}">
				<option value="${i }">${i }</option>
			</c:forEach>
		</select>&nbsp;년&nbsp;
		<select id="month">
			<c:forEach var="i" begin="1" end="12">
				<option value="${i }">${i }</option>
			</c:forEach>
		</select>&nbsp;월&nbsp;
		<input type="button" value="조회" id="btn_select" class="btn-sm btn-info" style="border: none;">
	</div>
	<br>
	<!-- 정산결과표시 -->
	<div style="margin: auto; paddin:auto; width: 80%;">
		<table class="table">
			<thead class="thead-light">
				<tr>
					<th>날짜</th>
					<th>실수령 금액</th>
					<th>수수료</th>
					<th>총 금액</th>
				<tr>
			</thead>
			<tbody id="tbody">
				<c:forEach var="i" items="${calList }">
					<tr>
						<c:choose>
							<c:when test="${empty i.year }">
								<td>총합</td>								
							</c:when>
							<c:otherwise>
								<td>${i.year }</td>
							</c:otherwise>
						</c:choose>
						<td>${i.real_amount }</td>
						<td>${i.commission }</td>
						<td>${i.real_amount + i.commission }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<br>
	<br>
	<br>
	<br>
  </body>
<script>
	$("#btn_select").on('click',function(){
		var year = $("#year").val();
		var month = $("#month").val();
		if(month < 10){
			month = "0"+month;
		}
		
		$.ajax({
			url: "/delivery/owner/store_cal",
			data:{num:${vo.num},year:year,month:month},
			success:function(data){
				$("#tbody").empty();
				$(data).each(function(i,val){
					let html ="";
					html +="<tr>";
					if(val.year==null || val.year==""){
						html +="<td>총합</td>";
					}else{
						html +="<td>"+val.year+"</td>";
					}
					html +="<td>"+val.real_amount+"</td>";
					html +="<td>"+val.commission+"</td>";
					html +="<td>"+(Number(val.real_amount)+Number(val.commission))+"</td>";
					html +="</tr>";
					$("#tbody").append(html);
				});
			}
		});
	});
</script>
</html>























