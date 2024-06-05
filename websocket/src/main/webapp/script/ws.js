const socket = new SockJS('/connect');
const stompClient = Stomp.over(socket);

stompClient.connect({}, function(frame) {
	console.log('연결: ' + frame);
	stompClient.subscribe('/user/to-client/all', function(message) {
		alert(message.body)
	});
});