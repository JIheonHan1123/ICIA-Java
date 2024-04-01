<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<title>Insert title here</title>
<script>
	$(document).ready(function() {
		$('#form-btn').on('click', function() {
			$('#my-form').submit();
		});
		
		$('#form-btn2').on('click', function() {
			// const a = 10;
			// js에서 변수를 담은 백틱 문자열 const b = `${a}`;
			
			// jsp에서는 a라는 값을 꺼내는 el도 ${a}라고 적는다
			// js와 jsp의 표기법이 충돌한다
			
			
			const pno = $('#pno').val();
			const pname = $('#pname').val();
			const price = $('#price').val();
			
			const html = `
				<form action='/example11/test1' method='post'>
					<input type='hidden' name='pno' value='\${pno}'>
					<input type='hidden' name='pname' value='\${pname}'>
					<input type='hidden' name='price' value='\${price}'>
				</form>
			`;
			
			$(html).appendTo($('body')).submit();
		});
		
		
		// ajax 작업 : a, b, c를 모두 수행해야 한다
		// ajax 작업은 병렬 수행 -> 어떤 작업이 먼저 끝날 지 알 수 없다
		// callback 지옥
		/*
		$.ajax({
			url: '/a',
			success: function() {
				$.ajax({
					url: '/b',
					success:function() {
						$.ajax({
							url:'/c',
							success:function() {
								console.log('a b c 모두 성공';
							}
						})
					}
				})
			}
		})
		*/
		
		// callback지옥 해소를 문법 : async ~ await
		/*
		try {
			await $.ajax('/a');
			await $.ajax('/b');
			await $.ajax('/c');
			// abc 모두 성공
		} catch(err) {
			console.log(err);
		}
		*/
		
		// pno=1&pname=맛동산&price=1000
		const params = {
			pno: $('#pno').val(),
			pname:$('#pname').val(),
			price:$('#price').val()
		};
		
		// 자바스크립트 객체를 $.ajax()의 data 속성에 주면 urlencoded로 자동변환
		
		$('#ajax-btn').on('click', function() {
			$.ajax({
				url: '/example11/test2',
				method: 'post',
				data: params,
				success:function(result) {
					// 200인 경우 서버 응답 중 데이터 부분만 자동으로 꺼내서 인자로 전달
					console.log(result);
				}, error:function(response) {
					// 실패인 경우 서버 응답을 인자에 그대로 전달
					console.log(response);
				}
			})
		})
	})
</script>
<script>
</script>
</head>
<body>
	<form action="/example11/test1" method="post" id="my-form">
		번호:
		<input type="text" name="pno" id="pno" value="1">
		<br>
		이름:
		<input type="text" name="pname" id="pname" value="맛동산">
		<br>
		가격:
		<input type="text" name="price" id="price" value="1000">
		<br>
		<hr>
		<button type="button" id="form-btn">form으로 보내기</button>
		<hr>
		<button type="button" id="form-btn2">form만들어서 보내기</button>
		<hr>
		<button type="button" id="ajax-btn">ajax로 보내기</button>
	</form>
</body>
</html>