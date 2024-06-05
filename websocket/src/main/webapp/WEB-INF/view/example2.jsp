<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/sockjs-client/dist/sockjs.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/stompjs/lib/stomp.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div>
		<input type="text" id="message" placeholder="메시지를 입력하세요...">
		<button id="send">보내기</button>
	</div>
	<script>
		const socket = new SockJS('/connect');
		const stompClient = Stomp.over(socket);

		// 클라이언트가 구독할 서버측 주소(/to-client)
		stompClient.connect({}, function(frame) {
			stompClient.subscribe('/to-client/chat1', function(message) {
				console.log("수신: " + message.body);
			});
		});
		
		$('#send').on('click', function() {
			const message = $('#message').val();
			stompClient.send("/to-server/chat2", {}, message)
		})
	</script>
</body>
</html>