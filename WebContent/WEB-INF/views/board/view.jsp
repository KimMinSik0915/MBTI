<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>일반 게시판</title>

<script type="text/javascript">
$(function(){
	//글 삭제 시 삭제 여부를 확인
	$("#deleteBtn").click(function(){
		if(!confirm("게시글을 삭제하시겠습니까?")) return false; //a tag 이동 취소
	});
}
</script>

</head>
<body>
<div class="container">
<h1>게시판 글보기</h1>
<table class="table">
	<tbody>
		<tr>
			<th>글번호</th>
			<td class="no">${vo.no }</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>${vo.title }</td>
		</tr>
		<tr>
			<th>내용</th>
			<td><pre style="background: #fff; border: none; padding: 0px;">${vo.content }</pre></td>
		</tr>
		<tr>
			<th>아이디</th>
			<td>${vo.id }</td>
		</tr>
		<tr>
			<th>작성일</th>
			<td>${vo.writeDate }</td>
		</tr>
		<tr>
			<th>조회수</th>
			<td>${vo.hit }</td>
		</tr>		
	</tbody>
	<tfoot>
		<tr>
			<td colspan="2">
				<a href="updateForm.do?no=${vo.no }&page=${pageObject.page}&perPageNum=${pageObject.perPageNum}"
				class="btn btn-default">수정</a>
				<a href="delete.do?no=${vo.no }&perPageNum=${pageObject.perPageNum}"
				 class="btn btn-default" id="deleteBtn">삭제</a>
				<a href="list.do?page=${pageObject.page }&perPageNum=${pageObject.perPageNum}"
				class="btn btn-default">리스트</a>
			</td>
		</tr>
	</tfoot>
</table>
</div>

<!-- 댓글 -->
<div class="container">
<h4>댓글</h4>
			<div class="w3-border w3-padding">댓글</div>
			<div class="w3-border w3-padding">
				<c:if test="${ id == null }">
					<textarea rows="5" cols="50" class="w3-input w3-border newLogin" readonly>로그인 후 댓글 달기</textarea>
				</c:if>
				<c:if test="${ id != null }">
					<i class="fa fa-user w3-padding-16"></i> ${ content.id }
					<form>
						<input type="hidden" name="no" id="no" value="${ content.board_no }"> 
						<input type="hidden" name="id" id="id" value="${ id }">
						<textarea rows="5" cols="50" class="w3-input w3-border" placeholder="댓글 작성" name="reply_content" id="reply_content"></textarea>
						<input type="button" class="w3-button w3-border" id="reply_btn" value="댓글 등록">
					</form>
				</c:if>
			</div>
</div>
</body>
</html>