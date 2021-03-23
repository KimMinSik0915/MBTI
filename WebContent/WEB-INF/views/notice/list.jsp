<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="pageObject" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>시네마 ▶ 공지사항</title>
<script type="text/javascript">
$(function(){
	// class가 dataRow인 대상을 클릭시 일어나는 함수
	$(".dataRow").click(function(){
		// dataRow 클래스에 해당하는 데이터가 가진 no값을  -> view으로 no값과 perPageNum,page값을 같이 넘겨준다.(되돌아올시 그대로 받는다.)
		// .do=.jsp
		var no = $(this).find(".no").text();
		location = "view.do?no=" + no + "&page=${pageObject.page}&perPageNum={$pageObject.perPageNum}";
	})
	
})
</script>
<style type="text/css">
.dataRow:hover{
	cursor: pointer;
	background: #eee;
}
</style>
</head>
<body>
	<div class="container">
		<h2>MBTI〔시네마〕공지</h2>	
		
		<table class="table">
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>기간</th>
				<th>작성일</th>
			</tr>
			<c:forEach items="${list }" var="vo">
			<tr class="dataRow">
				<td class="no">${vo.no }</td>
				<td>${vo.title }</td>
				<td>${vo.startDate }~${vo.endDate }</td>
				<td>${vo.writeDate }</td>
			</tr>
			</c:forEach>
			<c:if test="${login.gradeNo == 9 }">
			<tr>
				<td colspan="4">
					<a href="writeForm.do" class="btn btn-default">작성</a>		
				</td>
			</tr>
			</c:if>
			<tr>
				<td colspan="4">
					<pageObject:pageNav listURI="list.do" pageObject="${pageObject }"/>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>