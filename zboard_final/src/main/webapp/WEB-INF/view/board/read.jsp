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
}

#lower {
	display: flex;
	justify-content: space-between;
}

#lower_left li, #lower_right li {
	display: inline-block;
}

#lower ul {
	margin: 0;
	padding: 0;
}

#summernote {
	min-height: 450px;
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
	
	function 댓글출력(comments) {
		// 댓글 모두 지우고 다시 출력
		
		// $('#c').remove() -> $('#c') 자신과 자식을 모두 삭제
		// $('#c').empty() -> 자식을 삭제
		$('#comments').empty();
		
		for(const c of comments) {
			// 로그인 아이디와 댓글 작성자가 다르면 display:none;
			const style = loginId==c.writer? '':'display:none;'; 
			const html = `
				<div>
					<span>\${c.writer }</span>
					<span>\${c.writeTime }</span>
					<button class="delete_comment" 
						data-cno="\${c.cno}" style="\${style}">
						삭제
					</button>
					<div>\${c.content }</div>
				</div>
				<hr>						
			`;
			$('#comments').append(html);
		}
	}

	$(document).ready(function() {
		if (isLogin == true && isWriter == false) {
			글쓴이가아닌경우();
		} else if (isLogin == true && isWriter == true) {
			글쓴이인경우();
		}
		
		// 로그인 하면 댓글작성 가능하도록 textarea 활성화
		if (isLogin == true) {
			$('#comment').prop('disabled', false);
			$('#comment').attr('placeholder','');
			$('#write_comment').css('display','inline');
		}
		
		// 댓글 작성 - ajax
		$('#write_comment').on('click', function() {
			// 댓글을 입력하지 않은 오류 메시지 + 작업 중단 
			if($('#comment').val()=='') {
				alert('댓글을 입력해주세요');
				return false;
			}
			// 댓글 받아오고
			const params = {
					bno: '${dto.bno}',
					content: $('#comment').val(),
					_csrf: '${_csrf.token}'
			}
			// ajax로 작성
			$.ajax({
				url: '/comment/write',
				method: 'post',
				data: params,
				success:function(result) {
					댓글출력(result);
					$('#comment').val("");
				}, error:function(response) {
					console.log(response);
				}
			}) // ajax end
		}) // 댓글 작성 - ajax end
		
		// 댓글 삭제
		// 1. 이벤트 처리할 때 동적으로 생성된 요소는 $(넓은선택자).on('이벤트', 선택자)
		// 2. 정적으로 생성한 요소도 1번 처리해도 된다
		// 3. 정적인 요소 vs 동적인 요소 구별하는 방법
		// 	화면이 로딩될 때($(document).ready일때) 만들어지면 정적, 그 이후에 만들어지면 동적
		$('#comments').on('click', '.delete_comment', function() {
			const params = {
					cno: $(this).attr('data-cno'),
					bno: '${dto.bno}',
					_csrf: '${_csrf.token}'
			};
			$.ajax({
				url: '/comment/delete',
				method: 'post',
				data: params,
				success:function(result) {
					댓글출력(result);
				}, error:function(response) {
					console.log(response);
				}
			})
		}) // 댓글 삭제 end
		
		// 글 변경
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
		}) // 글 변경 end
		
		// 추천
		$('#good-btn').on('click', function(){
			const params = {
					bno: '${dto.bno}',
					_csrf: '${_csrf.token}'
			};
			$.ajax({
				url: '/board/good',
				method: 'post',
				data: params,
				success:function(result) {
					$('#good-cnt').text(result);
				}, error:function(response) {
					console.log(response);
				}
			})
		}) // 추천 end
		
	}); // $(document).ready(function() {}) end
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
									추천
									<span class="badge bg-dark" id="good-cnt">${dto.goodCnt}</span>
								</button>
							</li>
							<li>
								<button type="button" class="btn btn-success" disabled>
									조회
									<span class="badge bg-dark">${dto.readCnt}</span>
								</button>
							</li>
							<li>
								<button type="button" class="btn btn-danger" id="bad-btn" disabled>
									신고
									<span class="badge bg-dark" id="bad-cnt">${dto.badCnt}</span>
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

				<!-- 댓글 작성할 공간 -->
				<div class="mb-3 mt-3">
					<textarea id="comment" style="width: 760px; height: 200px;" disabled placeholder="댓글을 작성하려면 로그인하세요"></textarea>
					<button id="write_comment" style="display: none;">작성하기</button>
				</div>

				<!-- 댓글 출력할 공간 -->
				<div id="comments">
					<!-- principal 읽어오는 법 -->
					<!-- sec:authentication property="name" 으로 로그인한 아이디를 읽어와서 var="username"에 저장해라 -->
					<sec:authentication property="name" var="username" />
					<c:forEach items="${dto.comments}" var="c">
						<div>
							<span>${c.writer}</span>
							<span>${c.writeTime}"</span>
							<!-- 현재 로그인한 사용자 아이디와 댓글 작성자가 같은 경우에만 삭제 버튼 -->
							<c:if test="${c.writer == username}">
								<button class="delete_comment" data-cno="${c.cno}">삭제</button>
							</c:if>
							<div>${c.content}</div>
						</div>
						<hr>
					</c:forEach>
				</div>

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
