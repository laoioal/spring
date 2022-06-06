$(document).ready(function(){
	$('#hbtn').click(function(){
		$(location).attr('href', '/www/');
	});
	$('#rbtn').click(function() {
		document.frm.reset();
	});
	$('#ebtn').click(function() {
		$('#frm').attr('action', '/www/member/myInfoEditProc.blp');
		var pw = $('#pw').val();
		var repw = $('#repw').val();
		if(pw != repw) {
			alert('비밀번호가 일치하지 않습니다.');
			return;	
		}
		$('#frm').submit();
	});
});