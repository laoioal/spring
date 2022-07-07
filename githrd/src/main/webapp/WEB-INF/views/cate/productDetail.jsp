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
		<h1 class="w3-padding w3-center w3-blue w3-card-4">Product Detail</h1>

		<div class="w3-center pdAll5 product">
			<div class="w3-col w3-card-4 pdAll10">
				<img src="${LIST.dir}${LIST.sname}" alt="Product" style="width:100%">
				<div class="w3-col" style="height:92px;">
					<h3>${LIST.pname}</h3>
				</div>
				<p>가격 : ${LIST.price}</p>
				<p>제조사 : ${LIST.manuf_co}</p>
				<p>출시일 : ${LIST.sdate}</p>
				<p>상세정보 : ${LIST.summary}</p>
			</div>
		</div>
		
	</div>
</body>
</html>