function showProfile() {
	const profile = $('#profile')[0].files[0];
	// $('#profile')[0] -> <input type='file' id='profile'>
	// file 속성을 가진 input 요소는 사용자가 선택한 파일을 files라는 배열 속성으로 저장한다
	// 파일을 하나 선택했다면 files[0]

	const maxSize = 1024 * 1024;
	if (profile.size > maxSize) {
		alert('사진 크기는 1MB이하여야 합니다');
		$('#profile')[0].files[0] = '';
	}

	let reader = new FileReader();
	// 파일을 로딩했을 때 동작할 콜백함수 지정
	reader.onload = function() {
		$('#show-profile').css('display', 'inline').attr('src', reader.result);
	}

	// 파일을 로딩한다
	reader.readAsDataURL(profile);
}

const patterns = {
	username: [/^[A-Za-z0-9]{6,10}$/, "아이디는 영숫자 6~10자입니다"],
	password: [/^[A-Za-z0-9]{8,10}$/, "비밀번호는 영숫자 8~10자입니다"],
	email: [
		/^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i,
		"잘못된 이메일입니다"],
	birthday: [/^[0-9]{4}-[0-9]{2}-[0-9]{2}$/, "잘못된 날짜입니다"],
};

// await를 사용하면 함수에 async를 붙여야 한다
async function usernameCheck() {
	const $element = $("#username");
	const value = $element.val();
	$element.next().text("");
	// 패턴비교
	if (patterns.username[0].test(value) == false) {
		$element.next().text(patterns.username[1]).addClass("error");
		return false;
	}

	try {
		// 서버의 응답은 메시지+상태코드로 구성된 객체인데
		// $.ajax()는 200인 경우에 서버에서 결과데이터(메시지)를 자동으로 꺼내도록 구현되어있다 
		const msg = await $.ajax("/member/id-check?username=" + value); // 그래서 msg에 객체가 오는게 아니라 문자열이 들어감
		$element.next().text(msg);
		return true;
	} catch (response) {
		// 200이 아닌 경우 catch절을 이용해 서버응답을 얻어와서 에러 메시지를 꺼낸다
		console.log(response);
		$element.next().text(response.responseText);
		return false;
	}
	/*
	$.ajax({
		url: "/member/id-check",
		data: "username=" + value,
		success: function() {
			// 내가 원하는 결과: 상태코드200(오류가 발생하지 않았다)
			$element.next().text("사용가능합니다").addClass("success");
			return true;
		},
		error: function() {
			// 내가 원하지 않는 결과: 상태코드가 200이 아니다
			$element.next().text("사용중인 아이디입니다").addClass("error");
			return false;
		},
	});
	*/
}

function passwordCheck() {
	const $element = $("#password");
	const value = $element.val();
	$element.next().text("");

	if (patterns.password[0].test(value) == false) {
		$element.next().text(patterns.password[1]).addClass("error");
		return false;
	}
	return true;
}

function password2Check() {
	const password = $("#password").val();
	const $element = $("#password2");
	const value = $element.val();
	$element.next().text("");

	if (password !== value) {
		$element.next().text("새비밀번호가 일치하지 않습니다").addClass("error");
		return false;
	}
	return true;
}

function emailCheck() {
	const $element = $("#email");
	const value = $element.val();
	$element.next().text("");

	if (patterns.email[0].test(value) == false) {
		$element.next().text(patterns.email[1]).addClass("error");
		return false;
	}
	return true;
}

function birthdayCheck() {
	const $element = $("#birthday");
	const value = $element.val();
	$element.next().text("");

	if (patterns.birthday[0].test(value) == false) {
		$element.next().text(patterns.birthday[1]).addClass("error");
		return false;
	}
	return true;
}

$(document).ready(function() {
	$("#profile").on("change", showProfile); // 사진을 선택하면 출력
	$("#username").on("blur", usernameCheck);
	$("#password").on("blur", passwordCheck);
	$("#password2").on("blur", password2Check);
	$("#email").on("blur", emailCheck);
	$("#birthday").on("blur", birthdayCheck);

	$("#join").on("click", async function() {
		const r1 = await usernameCheck(); // async함수에 대해서 await를 다시 사용할 수 있음
		const r2 = passwordCheck();
		const r3 = password2Check();
		const r4 = emailCheck();
		const r5 = birthdayCheck();
		const result = r1 && r2 && r3 && r4 && r5;
		if (result == false){
			return false;
		}
		$("#join_form").submit();
	});
});