<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="pageObject" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>일반 게시판</title>

<style type="text/css">
.dataRow:hover{
	cursor: pointer;
	background: #eee;
}
</style>

<script type="text/javascript">
$(function(){
	$(".dataRow").click(function(){
		//alert($(this));
		var no = $(this).find(".no").text();
		location = "view.do?no=" + no + "&inc=1&page=${pageObject.page}&perPageNum=${pageObject.perPageNum}";
	});
});
</script>

</head>
<body>
<div class="container">
<h1>게시판 리스트</h1>
<table class="table">
	<thead>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>아이디</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${list }" var="vo">
		<tr class="dataRow">
			<td class="no">${vo.no }</td>
			<td>${vo.title }</td>
			<td>${vo.id }</td>
			<td>${vo.writeDate }</td>
			<td>${vo.hit }</td>
		</tr>
		</c:forEach>
	</tbody>
	<tfoot>
		<tr>
			<td colspan="5">
				<a href="writeForm.do?perPageNum=${pageObject.perPageNum }" class="btn btn-default">글쓰기</a>
			</td>
			<tr>
			<td	colspan="5">
				<pageObject:pageNav listURI="list.do" pageObject="${pageObject }"/>
			</td>
		</tr>
	</tfoot>
</table>
</div>

</body>
</html>