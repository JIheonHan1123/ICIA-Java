<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!--
	자바스크립트는 웹소켓 연결을 지원하는데...지금은 서버가 stomp로 만들어져 있다 
	stomp 연결 자바스크립트 라이브러리를 cdn으로 추가
-->
<script src="https://cdn.jsdelivr.net/npm/sockjs-client/dist/sockjs.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/stompjs/lib/stomp.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<script>
		// 웹소켓을 연결해서 stomp객체를 생성
		const socket = new SockJS('/connect');
		const stompClient = Stomp.over(socket);

		// 수신 설정
		stompClient.connect({}, function(frame) {
			console.log('연결: ' + frame);
			stompClient.subscribe('/to-client/all', function(message) {
				console.log(message);
				console.log("수신: " + message.body);
			});
		});
	</script>
</body>
</html>