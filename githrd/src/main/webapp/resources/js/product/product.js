$(document).ready(function(){
	$('#pPanel').css('display', 'none');
	$('.w3-select').not('#xlcate').css('display', 'none');
	
	$('.w3-select').not('#scate').change(function() {
		var sno =$(this).val();
		
		/*
		$('#lcate').css('display', 'none');
		$('#lacte').html('<option disabled selected>분류선택</option>');
		*/
		var tarr = {
			'lcate' : '대분류선택',
			'mcate' : '중분류선택',
			'scate' : '소분류선택'
		}
		var el = $(this).parent().next().find('.w3-select');
		$(el).css('display', 'none');
		var tname = $(el).attr('id');
		$(el).html('<option disabled selected>' + tarr[tname] + '</option>');
		$.ajax({
			url: '/www/cate/cateList.blp',
			type: 'post',
			dataType: 'json',
			data: {
				cno: sno
			},
			success: function(arr){
				if(arr.length != 0) {
					for(var i = 0; i < arr.length; i++) {
						$(el).append('<option value="' + arr[i].cno + '">' + arr[i].cname + '</option>');
					}
					$(el).css('display', 'block');
				}
			},
			error: function() {
				alert('### 통신오류 ###');
			}
		});
	});
	
	$('#scate').change(function(){
		// 할일
		// 기존 내용 지우고
		$('#pPanel').css('display', 'none');
		$('#pPanel').html('');
		
		// 분류번호 가져오고
		var sno = $(this).val();
		
		$.ajax({
			url: '/www/cate/productList.blp',
			type: 'post',
			dataType: 'json',
			data: {
				cno: sno
			},
			success: function(arr){
				if(arr.length > 0) {
					for(var i = 0; i < arr.length; i++) {
						var stag = 	
								'<div class="w3-half w3-center pdAll5 product" id="' + arr[i].pno + '">' +
								'<div class="w3-col w3-card-4 pdAll10">' +
								'<img src="' + (arr[i].dir + arr[i].sname) + '" alt="Product" style="width:100%">' +
								'<div class="w3-col" style="height:92px;"><h3>' + arr[i].pname + '</h3></div>' +
								'<p>가격 : ' + arr[i].price + '</p>' +
								'<p>제조사 : ' + arr[i].manuf_co + '</p>' +
								'</div>' +
								'</div>';
								
						$('#pPanel').append(stag);
					}
					$('#pPanel').css('display', 'block');
				}
			},
			error: function(){
				alert('### 통신오류 ###');
			}
		});
		
	});
	
	$('#pPanel').on('click', '.product', function() {
		// 할일
		// 상품번호 알아내고
		var sno = $(this).attr('id');
		
		// get방식으로 전송
//		$(location).attr('href', '/www/cate/productDetail.blp?pno=' + sno);
		
		// post 방식으로 전송
		$(document.frm.pno).val(sno); // name 속성값으로 부르는방법
		$('#frm').submit();
		
	});
});