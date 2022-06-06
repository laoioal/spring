$(document).ready(function(){
	$('#wbtn').click(function(){
		$('#frm').submit();
	});
	$('#lbtn').click(function(){
		$('#frm').attr('action', '/www/gboard/gboardList.blp');
		$('#frm').submit();
	});
	$('#rbtn').click(function(){
		document.frm.reset();
	});
});