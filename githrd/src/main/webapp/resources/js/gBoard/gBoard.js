$(document).ready(function(){
	$('.pbtn').click(function(){
		var sno = $(this).attr('id');
		$('#nowPage').val(sno);
		$('#frm').submit();
	});
	
	$('#hbtn').click(function(){
		$(location).attr('href', '/www/');
	});
	$('#jbtn').click(function(){
		$(location).attr('href', '/www/member/join.blp');
	});
	$('#lbtn').click(function(){
		$(location).attr('href', '/www/member/login.blp');
	});
	$('#obtn').click(function(){
		$('#frm').attr('action', '/www/member/logout.blp');
		$('#vw').val('/www/gBoard/gBoardList.blp');
		$('#frm').submit();
		
	});
	
	
	
	$('#wbtn').click(function(){
		$('#frm1').attr('action', '/www/gBoard/gBoardWrite.blp');
		$('#frm1').submit();
	});
	$('.pbtn').click(function(){
		var nowPage = $(this).attr('id');
		$('#nowPage').val(nowPage);
		$('#frm').submit();
	});
	$('#wbtn1').click(function(){
		$('#frm1').submit();
	});
	
	$('#addbtn').click(function(){
		var str = $('#body').val();
		if(!str) {
			return;
		}
		$('#frm').submit();
	});
});