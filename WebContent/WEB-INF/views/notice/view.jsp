<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="pageObject" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지 사항</title>
<script type="text/javascript">
$(function(){
	$("#deleteA").click(function(){
		if(!confirm("삭제 하시겠습니까?")) 
			return false;
	})
})
</script>
</head>
<body>
<input name="perPageNum" type="hidden" value="${pageObject.perPageNum }">
	<div class="container">
	<table class="table">
	<tbody>
		<tr>
			<th class="no">번호</th>
			<td>${vo.no }</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>${vo.title }</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>${vo.content }</td>
		</tr>
		<tr>			
			<th>기 간</th>
			<td>${vo.startDate }~${vo.endDate }</td>
		</tr>
	</tbody>
		<tfoot>
			<tr>
				<td colspan="2">
				<c:if test="${login.gradeNo == 9 }">
				<a href="delete.do?no=${vo.no }&perPageNum=${pageObject.perPageNum}" id="deleteA">삭제</a>
				</c:if>
				<!-- 페이지 오브젝트 같이 넘겨서 리스트로 돌아갈때 정보 그대로 받음 -->
				<a href="list.do?page=${pageObject.page }&perPageNum=${pageObject.perPageNum}" >돌아가기</a>
				</td>
			</tr>
		</tfoot>
	</table>		
	</div>
</body>
</html>