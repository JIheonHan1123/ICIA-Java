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
<style>
	.whisper {
		color: red;
	}
</style>
</head>
<body>
	<div>
		<input type="text" id="message" placeholder="메시지를 입력하세요...">
		<button id="send">보내기</button>
	</div>
	<div>
		<input type="text" id="opponent" placeholder="귓말 보낼 아이디 입력...">
		<input type="text" id="whisper-message" placeholder="메시지를 입력하세요...">
		<button id="send_whisper">보내기</button>
	</div>
	<div id="messages">
	</div>
	<script>
		const socket = new SockJS('/connect');
		const stompClient = Stomp.over(socket);

		stompClient.connect({}, function(frame) {
			stompClient.subscribe('/to-client/chat5', function(message) {
				const m = message.body;
				const html=`<p>\${m}</p>`;
				console.log(html);
				$('#messages').append(html);
			});
			
			// 사용자를 지정해서 수신하는 주소는  /user로 시작
			// 이거 빼먹으면 안됨
			stompClient.subscribe('/user/to-client/whisper', function(message) {
				const m = message.body
				const html=`<p class='whisper'>\${m}</p>`;
				console.log(html);
				$('#messages').append(html);
			});
		});
		
		$('#send').on('click', function() {
			const message = $('#message').val();
			$('#message').val("").focus();
			stompClient.send("/to-server/chat5", {}, message);
		});
		
		$('#send_whisper').on('click', function() {
			const opponent = $('#opponent').val();
			const message = $('#whisper-message').val();
			const msg = {opponent, message};
			$('#whisper-message').val("").focus();
			stompClient.send("/to-server/whisper", {}, JSON.stringify(msg));
		});
	</script>
</body>
</html>