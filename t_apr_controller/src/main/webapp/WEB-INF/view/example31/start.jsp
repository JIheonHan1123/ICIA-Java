<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<title>Insert title here</title>
<script>
	$(function() {
		$('#all').on('click', function(){
			const $choices = $('.choice');
			for(c of $choices) {
				// 여기서 c = <input type='checkbox' class='choice'>
				// jQuery로 여러개를 선택한 다음 반복문을 돌리면 jQuery가 아니라 html이다
				// 다시 jQuery로 만들어 주려먼 다시 $를 붙인다.
//				console.log(c);
//				console.log($(c));
				$(c).prop('checked', true); 
				// cf) true, false로 속성값 주는 애들
				// readonly, checked, selected ...
			}
		})
		
		// 선택한 체크박스들이 가진 data-mno값을 서버로 넘긴다
		$('#delete').on('click', function() {
			// 선택한 체크박스들의 data-mno값을 저장할 배열
			const arr = [];
			const $choice = $('.choice');
			for(c of $choice) {
				const $c = $(c);
				// 속성들중에서 값이 아니라 존재여부에 따라 적용되는 속성이 있다
				// ex) readonly -> <input type='text' readonly> 적용, <input type='text'> 미적용
				// readonly, disabled, checked, selected
				
				// jQeury에는 속성을 다루는 함수가 2개 있다
				// attr('value', 'aaaaa')
				// porp('disabled', true) -> 25라인의 속성 4개를 다루는 전용 함수
				if ($c.prop('checked')==true) {
					arr.push($c.attr('data-mno'));
				}
			}
			// console.log(arr);
			
			const params =  { mnos:arr };
			$.ajax({
				url: '/example31/test1',
				method: 'post',
				data: params,
				success: function(result) {
					console.log(result);
				}, error: function(response) {
					console.log(response);
				}
			})
		})
	});
</script>
</head>
<body>
	<h1>받은 메모함</h1>
	<table>
		<tr>
			<th></th>
			<th>제목</th>
			<th>보낸이</th>
			<th>읽음</th>
		</tr>
		<tr>
			<td><input type="checkbox" data-mno="3" class="choice"></td>
			<td>광고 광고 광고</td>
			<td>SPRING</td>
			<td>X</td>
		</tr>
		<tr>
			<td><input type="checkbox" data-mno="2" class="choice"></td>
			<td>광고 광고 광고</td>
			<td>SUMMER</td>
			<td>○</td>
		</tr>
		<tr>
			<td><input type="checkbox" data-mno="1" class="choice"></td>
			<td>광고 광고 광고</td>
			<td>SPRING</td>
			<td>○</td>
		</tr>
	</table>
	<button id="delete">선택 삭제</button>
	<button id="all">모두 선택</button>
</body>
</html>