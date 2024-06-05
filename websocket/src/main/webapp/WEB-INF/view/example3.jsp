<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
	<div id="messages"></div>
	<script>
		const socket = new SockJS('/connect');
		const stompClient = Stomp.over(socket);

		stompClient.connect({}, function(frame) {
			stompClient.subscribe('/to-client/chat3', function(message) {
				$('#messages').append(message.body + "<br>")
			});
		});

		$('#send').on('click', function() {
			const message = $('#message').val();
			$('#message').val("").focus();
			stompClient.send("/to-server/chat3", {}, message);
		});
	</script>
</body>
</html>