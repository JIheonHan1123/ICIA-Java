<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<link rel="stylesheet" href="/css/main.css" />
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" />
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<link href="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.20/summernote-lite.min.css" rel="stylesheet" />
<script src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.20/summernote-lite.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/lang/summernote-ko-KR.js"></script>
<title>Insert title here</title>
<style type="text/css">
ul {
	list-style: none;
	margin: 0;
	padding: 0;
}

#lower {
	display: flex;
	justify-content: space-between;
}

#lower_left li, #lower_right li {
	display: inline-block;
}
</style>
<!-- ------------------ 일단 값을 만들어 놓고 로그인을 했다면 변경해라 ----------------------- -->
<script>
	// 로그인여부, 작정자여부... 일단 false로 하자
	let isLogin = false;
	let isWriter = false;
</script>

<!-- 로그인한 경우에만 스크립트가 실행된다  -->
<sec:authorize access="isAuthenticated()">
	<script>
		// 로그인여부는 참으로 변경
		isLogin = true;

		// 작성자여부: 로그인 아이디와 ${dto.writer}가 같은가?
		const writer = "${dto.writer}";
		const loginId = '<sec:authentication property="name"/>';
		isWriter = writer == loginId;
	</script>
</sec:authorize>
<script>
	// 로그인했고, 글 작성자  맞음 => 제목/내용 편집가능, 변경/삭제버튼 보임
	// 로그인했고, 글 작성자 아님 => 좋아요, 싫어요 활성화, 댓글 활성화

	function 글쓴이가아닌경우() {
		// 좋아요 싫어요 enable
		// 댓글 enable

		// html속성중에 속성이 값이 아니라 속성이 있느냐/없느냐로 적용
		// -> readonly, disabled, checked, selected => 얘네들 값을 읽고 쓰는게 prop()
		$("#good-btn").prop("disabled", false);
		$("#bad-btn").prop("disabled", false);
	}

	function 글쓴이인경우() {
		// 제목 enable
		$("#title").prop("disabled", false);
		$("#btn_area").css("display", "block");
		const fontList = [ "맑은 고딕", "굴림", "돋움", "바탕", "궁서", "NotoSansKR" ];
		// jQuery가 사용하는 $의 우선권을 양보한다
		jQuery.noConflict();

		$("#summernote").summernote({
			height : 450,
			lang : "ko-KR",
			fontNames : fontList,
		});
		// 내용에 summernote 적용
		// 변경/삭제버튼을 보이게
	}

	$(document).ready(function() {
		if (isLogin == true && isWriter == false) {
			글쓴이가아닌경우();
		} else if (isLogin == true && isWriter == true) {
			글쓴이인경우();
		}
		
		$('#update').on('click', function(){
			const title = $('#title').val();
			// const content = $('#summernote').val();
			// summernote가 적용된  $('#summernote')는 val()로 못 읽어온다
			const content = $('#summernote').summernote('code');
			
			// 앞에 \붙이는 이유는 jsp가 $로 시작하면 el로 인식하기 때문 -> 그래서 \를 붙여서 자바스크립트로 인식하게 함
			const html = `
				<form action='/board/update' method='post'>
					<input type='hidden' name='title' value='\${title}'>  
					<input type='hidden' name='content' value='\${content}'>
					<input type='hidden' name='bno' value='${dto.bno}'>
					<input type='hidden' name='_csrf' value='${_csrf.token}'>
				</form>
			`;
			$(html).appendTo($('body')).submit();
		})
	});
</script>
<!-- ----------------------------------------------------------------------------------------------- -->
</head>
<body>
	<div id="page">
		<header>
			<jsp:include page="/WEB-INF/view/include/header.jsp" />
		</header>
		<nav>
			<jsp:include page="/WEB-INF/view/include/nav.jsp" />
		</nav>
		<main>
			<aside>
				<jsp:include page="/WEB-INF/view/include/aside.jsp" />
			</aside>
			<section>
				<div id="board">
					<div id="upper" class="mb-3 mt-3">
						<input type="text" id="title" value="${dto.title}" class="form-control" disabled />
						<span id="writer"></span>
					</div>
					<div id="lower" class="mb-3 mt-3">
						<ul id="lower_left">
							<li>글번호<span id="bno"></span></li>
							<li><span>${dto.writeTime}</span></li>
						</ul>
						<ul id="lower_right">
							<li>
								<button type="button" class="btn btn-primary" id="good-btn" disabled>
									추천 <span class="badge bg-dark" id="good-cnt">${dto.goodCnt}</span>
								</button>
							</li>
							<li>
								<button type="button" class="btn btn-success" disabled>
									조회 <span class="badge bg-dark">${dto.readCnt}</span>
								</button>
							</li>
							<li>
								<button type="button" class="btn btn-danger" id="bad-btn" disabled>
									신고 <span class="badge bg-dark" id="bad-cnt">${dto.badCnt}</span>
								</button>
							</li>
						</ul>
					</div>
					<div class="form-group">
						<div class="form-control" id="summernote" name="content">${dto.content}</div>
					</div>
				</div>
				<div id="btn_area" class="mb-3 mt-3" style="display: none">
					<button class="btn btn-success" id="update">변경</button>
					&nbsp; &nbsp;
					<button class="btn btn-danger" id="delete">삭제</button>
				</div>

				<div id="comments"></div>
			</section>
			<aside>
				<jsp:include page="/WEB-INF/view/include/aside.jsp" />
			</aside>
		</main>
		<footer>
			<jsp:include page="/WEB-INF/view/include/footer.jsp" />
		</footer>
	</div>
</body>
</html>
