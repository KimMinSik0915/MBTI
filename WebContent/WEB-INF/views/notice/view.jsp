<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="pageObject" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>▶ 공지 사항</title>
<script type="text/javascript">
$(function(){
	$("#deleteA").click(function(){
		if(!confirm("삭제 하시겠습니까?")) 
			return false;
	});
	//댓글 등록처리
	$("#reply_btn").click(function(){
		$("#replyForm").attr("action", "replyWrite.do?page=1&perPageNum=10&no=${vo.no}");
		$("#replyForm").submit();
	});
	//댓글 수정처리
	$("#replyUpdateBtn").click(function(){
		$("#replyForm").attr("action", "replyUpdate.do");
		$("#replyForm").submit();
	});
	//댓글 삭제
	$("#replyDeleteBtn").click(function(){
		if(!confirm("댓글을 삭제하시겠습니까?")) return false;
	});
});
</script>
<style type="text/css">
.table{
	border: 2px white solid;
	background: white;
	color: black;
}
.b1{
	border: 2px solid white;
	background: black;
	color: white;
	
}
</style>
</head>
<body>
<input name="perPageNum" type="hidden" value="${pageObject.perPageNum }">
	<br/>
	<br/>
	<div class="container">
		<div style="float:right;">
				<a href="list.do?page=${pageObject.page }&perPageNum=${pageObject.perPageNum}"  class="button">목록</a>
		</div>
	<table class="table">
	<tbody>
		<tr>
			<th class="no" hidden="no">번호</th>
			<td hidden="no">${vo.no }</td>
		</tr>
		<tr>
			<th class="b1">분류</th>
			<td>공 지</td>
		</tr>
		<tr>
			<th class="b1">제목</th>
			<td>${vo.title }</td>
		</tr>
		<tr>
			<th class="b1">내용</th>
			<td height="250px">${vo.content }</td>
		</tr>
		<tr>			
			<th class="b1">기 간</th>
			<td>${vo.startDate } ~ ${vo.endDate }</td>
		</tr>
					<c:if test="${login.gradeNo == 9 }">
					<div style="float: left;">
				<a href="delete.do?no=${vo.no }&perPageNum=${pageObject.perPageNum}" id="deleteA" class="button">삭제</a>
					</div>
					</c:if>
	</tbody>
	</table>		
	</div>	
	<!-- 댓글 -->
	<div class="container">
		<div class="w3-border w3-padding form-group" style="font-size: large; color: white;">댓글 (${pageObject.totalRow })</div>
				<div id="replyList" class="form-group">
			<!-- 댓글 리스트 -->
			<c:if test="${empty list }">
				<textarea rows="2" cols="50" class="w3-input w3-border newLogin form-control" readonly>등록된 댓글이 없습니다.</textarea>
			</c:if>
					<c:if test="${!empty list }">
						<c:forEach items="${list }" var="rvo">
							<li class="list-group-item datarow">
							<span class="id" style="font-weight:800; color: black;">${rvo.id }</span>
								<pre style="background: #fff; border: none; padding: 0px;"><input type="hidden" id="rno" value="${ rvo.rno }"><span class="ncontent">${rvo.ncontent }</span></pre>
								 ${rvo.writeDate }
									<span class="pull-right" style="margin-top: -10px">
									<c:if test="${rvo.id == login.id || login.gradeNo == 9 }">
									<a href="replyDelete.do?rno=${rvo.rno }&no=${vo.no }" class="button" id="replyDeleteBtn">삭제</a>
									</c:if>
									<c:if test="${rvo.id == login.id }">
									<a href="replyUpdate.do?rno=${rvo.rno }&no=${vo.no }&ncontent=${rvo.ncontent }&id=${rvo.id }" class="button" id="replyUpdateBtn">수정</a>
<!-- 										<button class="button replyUpdateBtn" id="replyUpdateBtn">수정</button> -->
							<form action="replyUpdate.do" method="post" id="replyUpdateForm">
								<input type="hidden" name="no" id="no" value="${ vo.no }"> 
								<input type="hidden" name="rno" id="rno" value="${ rvo.rno }"> 
								<input type="hidden" name="id" id="id" value="${ vo.id }">
							<textarea rows="5" cols="50" class="w3-input w3-border form-control w1" placeholder="댓글 작성" name="ncontent" id="reply_content" style="margin-bottom: 5px;">${rvo.ncontent }</textarea>
						<input type="button" class="button" id="replyUpdate_btn" value="댓글 수정" style="float: left;">
				<a href="list.do?page=${pageObject.page }&perPageNum=${pageObject.perPageNum}" style="float: right;" class="button">목록</a>

					</form> 
									</c:if>
								</span>
							</li>
						</c:forEach>
					</c:if>
				</div>
				<div class="w3-border w3-padding form-group">
					<c:if test="${ login == null }">
						<textarea rows="5" cols="50" class="w3-input w3-border newLogin form-control" readonly>로그인을 해주세요.</textarea>
				<a href="list.do?page=${pageObject.page }&perPageNum=${pageObject.perPageNum}" style="float: right; margin-top: 5px;" class="button" >목록</a>
					</c:if>
						<c:if test="${ login != null }">
					<i class="fa fa-user w3-padding-16" style="font-size: large; color: white;"> ${ login.id } </i>
						<form action="replyWrite.do" method="post" id="replyForm">
							<input type="hidden" name="no" id="no" value="${ vo.no }"> 
								<input type="hidden" name="id" id="id" value="${ vo.id }">
							<textarea rows="5" cols="50" class="w3-input w3-border form-control w1" placeholder="댓글 작성" name="ncontent" id="reply_content" required="required" style="margin-bottom: 5px;"></textarea>
						<input type="button" class="button" id="reply_btn" value="댓글 등록" style="float: left;">
				<a href="list.do?page=${pageObject.page }&perPageNum=${pageObject.perPageNum}" style="float: right;" class="button">목록</a>

					</form>
						</c:if>
						
				</div>
				<table>
					<tr>
				<td colspan="2">
				<!-- 페이지 오브젝트 같이 넘겨서 리스트로 돌아갈때 정보 그대로 받음 -->
				</td>
					</tr>
				</table>
	</div>
</body>
</html>