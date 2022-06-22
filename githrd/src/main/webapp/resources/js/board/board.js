$(document).ready(function(){
	$('#hbtn').click(function(){
		$(location).attr('href', '/www');
	});
	
	$('#obtn').click(function(){
		$(location).attr('href', '/www/member/logout.blp');
	});
	
	$('#lbtn').click(function(){
		$('#vw').val('/www/board/boardList.blp');
		$('#frm').attr('action', '/www/member/login.blp');
		$('#frm').submit();
	});
	
	$('#jbtn').click(function(){
		$(location).attr('href', '/www/member/join.blp');
	});
	
	$('.pbtn').click(function(){
		// 클릭된 버튼의 아이디 읽고
		var spage = $(this).attr('id');
		
		$('#nowPage').val(spage);
		$('#bno').prop('disabled', true);
		
		// action 속성 변경하고
		$('#frm').attr('action', '/www/board/boardList.blp');
		$('#frm').submit();
	});
	$('.brdList').click(function(){
		var sno = $(this).attr('id');
		$('#bno').val(sno);
		
		$('#frm').submit();
	});
	
	$('#wbtn').click(function(){
		$('#frm').attr('action', '/www/board/boardWrite.blp');
		$('#frm').submit();
	});
	
	// 리셋버튼 클릭이벤트
	$('#rbtn').click(function(){
		document.frm.reset();
	});
	
	$('#listbtn').click(function() {
		$('#frm').attr('action', '/www/board/boardList.blp');
		$('#frm').submit();
	});
	$('#filebox').on('change', '.upfile', function(){
		var str = $(this).val();
		if(!str) {
			$(this).remove();
			return;
		}
		$('#filebox').append('<input type="file" name="file" class="w3-input w3-border w3-margin-bottom upfile">');
	$('#previewbox').css('display', 'block');
	});
});