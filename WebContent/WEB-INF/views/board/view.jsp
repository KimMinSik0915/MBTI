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
// 	$("#RCcontent")
	//댓글 등록처리
	$("#reply_btn").click(function(){
// 		alert("클릭");
		$("#replyForm").attr("action", "replyWrite.do?page=1&perPageNum=10&no=${vo.no}");
		$("#replyForm").submit();
	});
	//댓글 수정처리
	$(".replyUpdateBtn").click(function(){
 		//alert("수정 클릭");
 		//댓글 -> 댓글 수정 
 		$(".datarow").hide();
 		$(".reply").text("댓글 수정");
 		$(".reply_btn").val("댓글 수정");
 		var dataRow = $(this).closest(".dataRow");
 		
 		$(this).find("#replyForm").attr("action", "replyUpdate.do");
 		var t = $(this).find(".pre").text();
 		
 		alert(t);
// 		$("#replyForm").attr("action", "replyUpdate.do");
// 		$("#replyForm").attr("type", "submit");
// 		$("#replyForm").submit();
	});
	
	//댓글 삭제
	$("#replyDeleteBtn").click(function(){
		if(!confirm("댓글을 삭제하시겠습니까?")) return false;
	});
});
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
			<td colspan="3">
				<c:if test="${vo.id==login.id }">
					<a href="updateForm.do?no=${vo.no }&page=${pageObject.page}&perPageNum=${pageObject.perPageNum}"
					class="button">수정</a>
				</c:if>
				<c:if test="${vo.id==login.id }">
					<a href="delete.do?no=${vo.no }&perPageNum=${pageObject.perPageNum}"
				 	class="button" id="deleteBtn">삭제</a>
				</c:if>
				<a href="list.do?page=${pageObject.page }&perPageNum=${pageObject.perPageNum}"
				class="button">리스트</a>
			</td>
		</tr>
	</tfoot>
</table>
</div>

<!-- 댓글 -->
<div class="container">
<div class="w3-border w3-padding form-group reply">댓글</div>
<div id="replyList" class="form-group">
	<!-- 댓글 리스트 -->
	<!-- 댓글이 없으면 '등록된 댓글이 없습니다'라고 나온다 -->
	<c:if test="${empty list }">
		<textarea rows="2" cols="50" class="w3-input w3-border newLogin form-control" readonly>등록된 댓글이 없습니다.</textarea>
	</c:if>
	<!-- 등록된 댓글이 있으면 리스트를 보여준다 -->
	<c:if test="${!empty list }">
	<c:forEach items="${list }" var="rvo">
	<!-- 댓글 리스트 -->
		<li class="list-group-item datarow" id="rcontent">
			<pre style="background: #fff; border: none; padding: 0px;"class="pre" id="pre"><span class="r_content" id="r_content">${rvo.rcontent }</span></pre>
			<span class="id">${rvo.id }</span> - ${rvo.writeDate }
			<span class="pull-right" style="margin-top: -10px">
			<!-- 댓글 작성자와 로그인한 사람이 같으면 삭제 버튼과 수정 버튼이 보인다 -->
			<c:if test="${rvo.id==login.id }">
<%-- 				<a href="replyUpdate.do?rno=${rvo.rno }&no=${vo.no}" class="button" id="replyUpdateBtn">수정</a> --%>
<!-- 				<input /> -->
				<button class="replyUpdateBtn button" id="replyUpdateBtn" value="${vo.id }">수정</button>
			</c:if>
			<c:if test="${rvo.id==login.id }">
				<a href="replyDelete.do?rno=${rvo.rno }&no=${vo.no}" class="button" id="replyDeleteBtn">삭제</a>
			</c:if>
			</span>
		</li>
	</c:forEach>
	</c:if>
</div>
			<div class="w3-border w3-padding form-group">
			<!-- 로그인이 되어있지 않으면 '로그인을 해주세요'라는 말이 나오고 댓글 작성이 불가능하다 -->
				<c:if test="${ login == null }">
					<textarea rows="5" cols="50" class="w3-input w3-border newLogin form-control" readonly>로그인을 해주세요.</textarea>
				</c:if>
			<!-- 로그인이 되어있으면 댓글 작성창에 작성이 가능하다 -->
				<c:if test="${ login != null }">
				<!-- 댓글 작성 form -->
					<i class="fa fa-user w3-padding-16"></i> ${ login.id }
					<form action="replyWrite.do" method="post" id="replyForm">
						<input type="hidden" name="no" id="no" value="${ vo.no }"> 
						<input type="hidden" name="id" id="id" value="${ login.id }">
						<textarea rows="5" cols="50" class="w3-input w3-border form-control" placeholder="댓글 작성" name="reply_content" id="reply_content"></textarea>
						<!-- 댓글 등록 버튼 -->
						<input type="button" class="button reply_btn" id="reply_btn" value="댓글 등록">
					</form>
				</c:if>
			</div>
</div>
</body>
</html>