<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 
		챔피언은 숫자아이디와 이름으로 구성
	 -->
	<form action="/dsr/read">
		<select name="id"> 
		<c:forEach items="${list}" var="c">
			<option value="${c.ID}">${c.NAME}</option>
		</c:forEach>
		</select>
		<button>선택</button>
	</form>
</body>
</html>