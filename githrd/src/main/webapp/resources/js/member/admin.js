$(document).ready(function(){
	$('.w3-button').click(function(){
		// 클릭된 태그의 회원 아이디 읽고
		var sid = $(this).html();
		if(confirm(sid + ' 회원을 삭제하시겠습니까?')){
			// 입력태그에 데이터 채우고
			$(document.frm.id).val(sid);
			
			// 폼태그 전송
			$('#frm').submit();
		}
	});
});