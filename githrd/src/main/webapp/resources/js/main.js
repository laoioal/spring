$(document).ready(function() {
	$('#msgClose').click(function(){
		$('#msgWin').css('display', 'none');
	});
	
	$.ajax({
		url: '/www/mainMsgCheck.blp',
		type: 'post',
		dataType: 'json',
		success: function(data) {
			if(data.result == 'NO') {
				// 처리에 성공한 경우
				$('#msgWin').remove();
			}
		},
		error: function(){
			alert('### 통신에러');
		}
	});
	
	$('#lbtn').click(function() {
	$(location).attr('href', '/www/member/login.blp');
	});
	
	$('#obtn').click(function(){
		$(location).attr('href', '/www/member/logout.blp');
	});
	$('#jbtn').click(function(){
		$(location).attr('href', '/www/member/join.blp');
	});
/*	
	$('#ibtn').click(function(){
		$(location).attr('href', '/www/member/memberInfo.blp');
	});
*/	
	$('#mlbtn').click(function(){
		$(location).attr('href', '/www/member/memberList.blp');
	});

	$('#ibtn').click(function(){
		$('#frm').attr('action', '/www/member/myInfo.blp');
		$('#frm').submit();
	});
	
	/*방명록 버튼 클릭 이벤트*/
	$('#gbtn').click(function(){
		$(location).attr('href', '/www/gBoard/gBoardList.blp');
	});
	
/*
	$('#gbtn').click(function(){
		$('#frm').attr('action', '/www/gboard/gboardList.blp');
		$('#frm').submit();
	});
*/
	$('#rbtn').click(function(){
		$('#frm').attr('action', '/www/reboard/reboardList.blp');
		$('#frm').submit();
	});
	
	
	
});