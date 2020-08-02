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
  
    <div class="container" style="margin: auto; padding: auto; width: 80%; height: 500px; border: 1px solid red;">
    	<div class="row">
    		<c:forEach var="index" begin="1" end="12">
    			<div class="col" style="text-align: center;">
	    			<c:out value="${index}" />
    			</div>
    		</c:forEach>
    	</div>
    </div>
  </body>
</html>























