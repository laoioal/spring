$(document).ready(function(){
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
		$(location).attr('href', '/www/member/logout.blp');
	});
	$('#wbtn').click(function(){
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
	
});