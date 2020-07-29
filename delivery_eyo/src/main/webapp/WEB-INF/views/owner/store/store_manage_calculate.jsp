<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script type="text/javascript" src="/delivery/resources/js/jquery-ui.js"></script>
<html>
  <head>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
  </head>
  <body>
  	<!-- 현재년도 -->
  	<div style="margin: 20px; padding: auto; padding-left: 200px;">
	  	<c:set var="now" value="<%=new java.util.Date() %>"/>
	  	<c:set var="sysYear">
	  		<fmt:formatDate value="${now }" pattern="yyyy"/>
	  	</c:set>
	  	<button type="button" id="lastyear" class="btn btn-outline-primary">
	  		<c:out value="${sysYear-1 }"/>년
	  	</button>
	  	
	  	<button style="margin-left: 15px;" type="button" id="thisyear" class="btn btn-outline-primary">
	  		<c:out value="${sysYear }"/>년
	  	</button>
  	</div>
  
    <div id="chart_div" style="width: 100%; height: 500px;"></div>
  </body>
    <script type="text/javascript">
    google.charts.load('current', {
		'packages' : [ 'corechart' ]
	});
	google.charts.setOnLoadCallback(drawChart);

	function drawChart() {
		var num = ${vo.num};
		
		$.getJSON({
			url : "/delivery/owner/store_manage/calculate1",
			data : {num : num},
			success : function(data) {
				
				
				var array = new Array();
				array[0] = [ 'tt', '판매' ];
				$(data).each(function(i, arr) {
					console.log(arr.num);
					var subArray = [i, arr.total_price];
						array[++i] = subArray;
						
				});
				var data2 = google.visualization.arrayToDataTable(array);

				var options = {
					title : '월별 실적  [단위:원]',
					hAxis : {
						title : '${vo.name}',
						titleTextStyle : {
							color : '#333'
						}
						,minValue : 1
						,ticks: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12]
					},
					vAxis : {
						minValue : 0
					}
				};

				var chart = new google.visualization.AreaChart(document
						.getElementById('chart_div'));

				chart.draw(data2, options);
			}
		});
	}
  
		 //console.log(data);
		 //$("#chart_div").empty();
		 //getData(data);
  		// $.getJSON("/delivery/owner/store_manage/calculate1?num="+num,function(data){
      
    </script>
</html>























