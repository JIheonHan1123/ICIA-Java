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
					<button type='button' class='delete'>삭제</button>
				</div>
			`;
			$file.append(html);
		});
		
		// 동적으로 추가된 요소의 이벤트 처리
		// S('넓은선택자').on( '이벤트이름', '선택자', function(){} )
		// $(document).ready() 까지는 정적으로 만들어 진 것 
		// $(document).ready()가 끝난 이후로 만들어 진건 동적인 것
		$('#file').on('click', '.delete', function(){
			// 요소를 선택하고 empty(): 자식들을 삭제
			// 요소를 선택하고 remove(): 자기 자신을 삭제
//			$(this).parent().remove();
			
			// 삭제버튼을 클릭하면 #add를 지우려면
			$(this).parent().parent().prev().prev().remove();
		});
	});
</script>
<title>Insert title here</title>
</head>
<body>
	<form action="/example25/end" method="post" enctype="multipart/form-data">
		<input type="text" name="username" value="spring">
		<button type="button" id="add">파일 추가</button>
		<hr>
		<div id="file"></div>
		<button>보내기</button>
	</form>
</body>
</html>