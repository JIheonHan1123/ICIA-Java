<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- forward할 때 username값 만 저장 -->
	${username}<br>
	<!-- password란 값은 없다 -> null -> null이라고 뜨는 것이 아니라 그냥 출력하지 않음 -->
	${password}<br>
	${username==null}<br>
	${password==null}<br>
	
	<hr>
	<!--  출력 작업할 때 전달받은 객체를 찍어라 -->
	${pagination }

	<hr>
	<!-- 객체의 값을 꺼낼 때: Getter => 아래 코드는 pagination.getStart() -->
	${paginaion.start}
	<!-- 아래 코드는 자바로 pagination.getTop() -> 인데 top 필드는 존재하지 않기 때문에 에러 -->
	${paginaion.top}
</body>
</html>