<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Page</title>
<link rel="stylesheet" type="text/css" href="/www/css/w3.css">
<link rel="stylesheet" type="text/css" href="/www/css/user.css">
<script type="text/javascript" src="/www/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="/www/js/member/admin.js"></script>

</head>
<body>
	<form method="POST" action="/www/admin/delMember.blp" id="frm" name="frm">
		<input type="hidden" name="id">
	</form>

	<div class="w3-content mxw700 w3-center">
		<h1 class="w3-padding w3-purple">Admin Page</h1>
		<div class="w3-col w3-margin-top">
<c:forEach var="data" items="${LIST}">
			<div class="w3-button w3-blue inblock w100 mgb10">${data}</div>
</c:forEach>
		</div>
	</div>
	
	<!-- 결과 모달창 -->
	
</body>
</html>