$(document).ready(function(){
	$('#msgClose').click(function(){
		$('#msgWin').css('display', 'none');
	});
	$('#hbtn').click(function(){
		$(location).attr('href', '/www/');
	});
	$('#rbtn').click(function() {
		document.frm.reset();
	});
	$('#ebtn').click(function() {
		
		var pw = $('#pw').val();
		var repw = $('#repw').val();
		
		var pwBool = false;
		var mailBool = false;
		var telBool = false;
		var anoBool = false;
		
		
		if(pw != repw) {
			$('#repw').val('');
			alert('비밀번호가 일치하지 않습니다.');
			return;	
		}
		
		if(!pw) {
			// 비밀번호를 수정하지 않는 경우이므로 비밀번호는 전송하지 않는다.
			$('#pw').prop('disabled', true);
		} else if(pw && repw){
			pwBool = true;
		}
		
		var smail = $('#mail').val();
		if(smail == $('#tmail').val()) {
			$('#mail').prop('disabled', true);
		} else {
			mailBool = true;
		}
		
		var stel = $('#tel').val();
		if(stel == $('#ttel').val()) {
			$('#tel').prop('disabled', true);
		} else {
			telBool = true;
		}
		
		var sano = $('[nane="ano"]:checked').val();
		if(sano == $('#tano').val()) {
			$('[name="ano"]').prop('disabled', true);
		} else {
			anoBool = true;
		}
		
		if(!(pwBool || mailBool || telBool || anoBool)) {
			// 수정데이터가 없는 경우이므로 뷰로 돌려보낸다.
			$('#msgWin').css('display', 'block');
			return;
		}
		
		$('#frm').attr('action', '/www/member/myInfoEditProc.blp');
		$('#frm').submit();
	});
});