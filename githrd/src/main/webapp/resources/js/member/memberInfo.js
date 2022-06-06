$(document).ready(function(){
	$('#lbtn').click(function(){
		$(location).attr('href', '/www/member/memberList.blp');
	});
	
	$('#dbtn').click(function(){
		$('#id01').css('display', 'block');

	});

	$('#ebtn').click(function(){
		$('#frm').attr('action', '/www/member/myInfoEdit.blp');
		$('#frm').submit();
	});
	$('#cancle').click(function(){
		$('#id01').css('display', 'none');
	});
	$('#delclick').click(function(){
		var sid = $('#sid').val();
		var ck = $('#delid').val();
		if(sid != ck) {
			alert('잘못 입력하셨습니다.');
			return;
		} else {
			$('#frm').attr('action', '/www/gboard/gboardForm.blp');
			$('#frm').submit();
		}
		
		
	});
	
});