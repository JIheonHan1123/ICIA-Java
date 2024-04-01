<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<title>Insert title here</title>
<script>
	$(document).ready(function() {
		// 폼으로 전달할 때는 enctype만 바꿔주면 된다
		$('#form-btn').on('click', function() {
			$('#my-form').submit();
		});

		$('#ajax-btn').on('click', function() {
			// data속성이 urlencoded가 아니라 form-data여야 한다
			// form-data 전송을 위한 js 객체가 FormData
			const formData = new FormData(document.getElementById('my-form'));

			// processData : js객체를 자동으로 urlencoded로 변환하는 기능
			//					     FormData 전송의 경우 false로 지정해야 한다
			// contentType : ajax 데이터의 종류
			$.ajax({
				url : '/example12/test2',
				method : 'post',
				data : formData,
				contentType : false,
				processData : false,
				success : function(result) {
					console.log(result);
				}
			})

		})
	})
</script>
</head>
<body>
	<form action="/example12/test1" method="post" enctype="multipart/form-data" id="my-form">
		아이디:
		<input type="text" name="username" id="username" value="spring">
		<br>
		사진:
		<input type="file" name="profile" id="profile">
		<br>
		<hr>
		<button type="button" id="form-btn">form으로 보내기</button>
		<hr>
		<button type="button" id="ajax-btn">ajax로 보내기</button>
	</form>
</body>
</html>




