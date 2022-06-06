$(document).ready(function() {
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
	$('#gbtn').click(function(){
		$('#frm').attr('action', '/www/gboard/gboardList.blp');
		$('#frm').submit();
	});
	$('#rbtn').click(function(){
		$('#frm').attr('action', '/www/reboard/reboardList.blp');
		$('#frm').submit();
	});
	
	
	
});