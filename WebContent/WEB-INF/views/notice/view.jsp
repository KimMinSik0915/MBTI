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
	})
})
</script>
<style type="text/css">
.table{
	border: 2px #ddd solid;
}
</style>
</head>
<body>
<input name="perPageNum" type="hidden" value="${pageObject.perPageNum }">
	<br/>
	<br/>
	<div class="container">
	<table class="table">
	<tbody>
		<tr>
			<th class="no" hidden="no">번호</th>
			<td hidden="no">${vo.no }</td>
		</tr>
		<tr>
			<th>분류</th>
			<td>공 지</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>${vo.title }</td>
		</tr>
		<tr>
			<th>내용</th>
			<td height="250px">${vo.content }</td>
		</tr>
		<tr>			
			<th>기 간</th>
			<td>${vo.startDate } ~ ${vo.endDate }</td>
		</tr>
	</tbody>
		<tfoot>
			<tr>
				<td colspan="2">
				<c:if test="${login.gradeNo == 9 }">
				<a href="delete.do?no=${vo.no }&perPageNum=${pageObject.perPageNum}" id="deleteA" class="btn btn-default">삭제</a>
				</c:if>
				<!-- 페이지 오브젝트 같이 넘겨서 리스트로 돌아갈때 정보 그대로 받음 -->
				<a href="list.do?page=${pageObject.page }&perPageNum=${pageObject.perPageNum}" style="float: right;" class="btn btn-default">돌아가기</a>
				</td>
			</tr>
		</tfoot>
	</table>		
	</div>
</body>
</html>