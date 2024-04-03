<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/css/main.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<title>Insert title here</title>
<!-- WEB/INF폴더 안에는 직접실행금지. 직접실행하면 안되는 애들만 넣고 나머지(css, js)는 넣으면 안된다 -->
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
				<table class="table table-hover">
					<thead>
						<tr>
							<th>번호</th>
							<th>제목</th>
							<th>작성자</th>
							<th>작성일</th>
							<th>읽기</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${page.list}" var="board">
							<tr>
								<td>${board.bno }</td>
								<td><a href="/board/read?bno=${board.bno}">${board.title }</a></td>
								<td>${board.writer }</td>
								<td>${board.writeTime }</td>
								<td>${board.readCnt }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<div style="display: flex; justify-content: center;">
					<ul class="pagination">
						<!-- li에 page-item, li에 내부에 page-link를 적용한 a -->
						<c:if test="${page.prev>0}">
							<li class="page-item"><a class="page-link" href="/?pageno=${page.prev}">이전으로</a></li>
						</c:if>
						<c:forEach begin="${page.start}" end="${page.end}" var="i">
							<li class="page-item ${page.pageno==i? 'active':''}"><a class="page-link" href="/?pageno=${i}">${i}</a></li>
						</c:forEach>
						<c:if test="${page.next>0}">
							<li class="page-item"><a class="page-link" href="/?pageno=${page.next}">다음으로</a></li>
						</c:if>
					</ul>
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