<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Page</title>
<link rel="stylesheet" type="text/css" href="/www/css/w3.css">
<link rel="stylesheet" type="text/css" href="/www/css/user.css">
<script type="text/javascript" src="/www/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="/www/js/product/product.js"></script>
</head>
<body>
	<div class="w3-content mxw700">
		<h1 class="w3-padding w3-center w3-blue w3-card-4">Product Page</h1>
		<div class="w3-col w3-margin-top">
			<div class="w3-quarter">
				<select id="xlcate" class="w3-center w3-select w3-border">
					<option disabled selected>분류선택</option>
		<c:forEach var="data" items="${LIST}">
					<option value="${data.cno}">${data.cname}</option>
		</c:forEach>
				</select>
			</div>
			
			<div class="w3-quarter pdl5">
				<select id="lcate" class="w3-center w3-select w3-border">
					<option disabled selected>분류선택</option>
				</select>
			</div>
			
			<div class="w3-quarter pdl5">
				<select id="mcate" class="w3-center w3-select w3-border">
					<option disabled selected>분류선택</option>
				</select>
			</div>
			
			<div class="w3-quarter pdl5">
				<select id="scate" class="w3-center w3-select w3-border">
					<option disabled selected>분류선택</option>
				</select>
			</div>
		</div>
	
	</div>
</body>
</html>