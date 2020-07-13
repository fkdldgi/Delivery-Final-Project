<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>views/layout.jsp</title>
<style>
	*{
		margin: 0px;
		padding: 0px;
	}
	
	#wrap{
			width: 80%;
			height: 1000px;
			margin: auto;
	}
	
	#header{
			width: 100%;
			height: 10%;
	}
	
	#owner_name{
		margin-left: 0px;
		padding-left: 0px;
	}
	
	#logo{
			width: 130px;
	}
	
	#content{
			width: 100%;
			height: 90%;
	}
</style>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
	<div id="wrap">
		<div id="header">			
			<!-- tiles.xml에 설정된 tiles를 설정하기 위해 -->
			<tiles:insertAttribute name="header"/>
		</div>
		<div id="content">
			<tiles:insertAttribute name="content"/>		
		</div>
	</div>
</body>
</html>