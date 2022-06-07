<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BlackPink 방명록</title>
<link rel="stylesheet" type="text/css" href="/www/css/w3.css">
<link rel="stylesheet" type="text/css" href="/www/css/user.css">
<script type="text/javascript" src="/www/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src=/www/js/gBoard/gBoard.js></script>
<style type="text/css">
	.w3-button {
		padding: 1px 16px;
	}
	.box120 {
		width: 135px;
	}
</style>
<script type="text/javascript">
	$(document).ready(function(){

	})

</script>
</head>
<body>


	<div class="w3-content mxw650 w3-margin-top">
		<!-- 페이지 헤더 -->
		<header class="w3-col w3-card-4 mgb20">
			<h1 class="w3-pink w3-center w3-padding mg0">BlackPink 방명록</h1>
			<nav class="w3-bar w3-yellow">
				<div class="w3-col w150 w3-button w3-small w3-green" id="hbtn">home</div>
	<c:if test="${empty SID}">
				<div class="w3-col w150 w3-button w3-small w3-deep-orange w3-right" id="lbtn">login</div>
				<div class="w3-col w150 w3-button w3-small w3-orange w3-right" id="jbtn">join</div>
	</c:if>
	<c:if test="${not empty SID}">
				<div class="w3-col w150 w3-button w3-small w3-red w3-right" id="obtn">logout</div>
		<c:if test="${CNT eq 0}">
				<div class="w3-col w150 w3-button w3-small w3-orange w3-right" id="wbtn">글작성</div>
		</c:if>
	</c:if>
			</nav>
		</header>
		
<c:if test="${CNT != 1}">
		<div class="w3-content mxw650 w3-margin-top" id="div1" style="display: none;">
			
			<form method="POST" action="/www/gboard/gboardForm.blp" name="frm1" id="frm1" class="w3-col w3-round-large w3-card-4 w3-margin-bottom w3-padding mgb20">
				<input type="hidden" name="mno" value="${DATA.mno}">
				<div class="w3-col box120 pdAll10 w3-border-right w3-border-deep-orange">
					<img src="/www/img/avatar/${DATA.avatar}" class="inblock avtBox100 w3-border w3-border-grey">
				</div>ㅠ
				<div class="w3-rest w3-padding">
					<div class="w3-col w3-border-bottom w3-border-deep-orange">
						<span class="mgb10 ft10"><b>${SID}</b></span>

					</div>
					<div class="w3-col w3-margin-top">
						<textarea name="body" id="body" class="w3-col w3-padding ft12 w3-border-orange" style="resize:none; height: 100%"></textarea>
						<div class="w3-col mgt10">
							<div class="w3-harf w3-button w3-deep-orange w3-hover-yellow w3-right" id="wbtn1">글등록</div>
							<div class="w3-harf w3-button w3-amber w3-hover-yellow w3-right w3-margin-right" id="rbtn">reset</div>
						</div>
					</div>
				</div>
				<input type="hidden" id="nowPage1" name="nowPage" value="${PAGE.nowPage}">
			</form>
		</div>
</c:if>
		
		<!-- 페이지 본문 -->
<c:forEach var="data" items="${LIST}">
		<div class="w3-col w3-round-large w3-card-4 w3-margin-bottom w3-padding">
			<div class="w3-col box120 pdAll10 w3-border-right">
				<img src="/www/img/avatar/${data.avatar}" class="inblock avtBox100 w3-border w3-border-gray">
			</div>
			<div class="w3-rest w3-padding">
				<div class="w3-col w3-border-bottom">
					<span class="mgb10 ft10"><b>${data.id}</b></span>
					<span class="w3-right mgb10 ft10"><small>${data.sdate}</small></span>
				</div>
				<div class="w3-col w3-margin-top">
					<span class="w3-col w3-padding ft12">${data.body}</span>
				</div>
			</div>
		</div>
</c:forEach>

		<!-- 페이지 처리 시작 -->
		<div class="w3-center">
			<div class="w3-bar w3-border w3-margin-top w3-margin-bottom">
			<c:if test="${PAGE.startPage eq 1}">
				<div class="w3-bar-item w3-light-gray">&laquo;</div>
			</c:if>
			<c:if test="${PAGE.startPage ne 1}">
				<div class="w3-bar-item w3-button w3-hover-blue pbtn" id="${PAGE.startPage -1}">&laquo;</div>
			</c:if>
			
		<c:forEach var="page" begin="${PAGE.startPage}" end="${PAGE.endPage}">	
			<c:if test="${page ne PAGE.nowPage}">	
				<div class="w3-bar-item w3-button w3-hover-blue pbtn" id="${page}">${page}</div>
			</c:if> 
			<c:if test="${page eq PAGE.nowPage}">	
				<div class="w3-bar-item w3-orange">${page}</div>
			</c:if> 
		</c:forEach>
		
			<c:if test="${PAGE.endPage eq PAGE.totalPage}">
				<div class="w3-bar-item w3-light-gray" >&raquo;</div>
			</c:if>
			<c:if test="${PAGE.endPage ne PAGE.totalPage}">
				<div class="w3-bar-item w3-button w3-hover-blue pbtn" id="${PAGE.endPage + 1}">&raquo;</div>
			</c:if>
			
			</div>
		</div>		
		<!-- 페이지 처리 태그 끝 -->
	</div>
	
	<!-- 데이터 전송용 form 태그 -->
	<form method="POST" action="/www/gBoard/gBoardList.blp" id="frm" name="frm">
		<input type="hidden" id="nowPage" name="nowPage" value="${PAGE.nowPage}">
	</form>
</body>
</html>