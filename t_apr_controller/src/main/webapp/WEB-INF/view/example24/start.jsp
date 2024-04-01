<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script>
	$(document).ready(function() {
		const $file = $('#file');
		$('#add').on('click', function() {
			const html = `
				<div>
					<input type='file' name='profiles'>
				</div>
			`;
			$file.append(html);
		})
	})
</script>
<title>Insert title here</title>
</head>
<body>
	<form action="/example24/end" method="post" enctype="multipart/form-data">
		<input type="text" name="username" value="spring">
		<button type="button" id="add">파일 추가</button>
		<hr>
		<div id="file"></div>
		<button>보내기</button>
	</form>
</body>
</html>