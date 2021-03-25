<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="pageObject" tagdir="/WEB-INF/tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>▶ 공지사항◀</title>
<script type="text/javascript">
$(function(){
	// class가 dataRow인 대상을 클릭시 일어나는 함수
	$(".dataRow").click(function(){
		// dataRow 클래스에 해당하는 데이터가 가진 no값을  -> view으로 no값과 perPageNum,page값을 같이 넘겨준다.(되돌아올시 그대로 받는다.)
		// .do=.jsp
		var no = $(this).find(".no").text();
		location = "view.do?no=" + no + "&page=${pageObject.page}&perPageNum=${pageObject.perPageNum}";
	});
	
});
</script>
<style type="text/css">
.dataRow:hover{
	cursor: pointer;
	background: #eee;
}
.total:hover{
	cursor: text;
}
</style>
</head>
<body>
	<div class="container">
		<h1 style="text-align: center;">〔공지〕</h1>	
		<br/>
		<br/>
				<label class="total" style="float: right; font-weight: normal;">총 게시글 : ${pageObject.totalRow }건</label>
		<table class="table">
			<tr>
				<th style="padding-left: 20px;">번호</th>
				<th style="padding-left: 63px;">제목</th>
				<th style="padding-left: 70px;">기간</th>
				<th style="padding-left: 23px;">작성일</th>
			</tr>
				<c:if test="${empty list }">
					<tr><td colspan="5" class="text-center">글이 존재하지 않습니다.</td></tr>
				</c:if>
			<c:forEach items="${list }" var="vo">
			<tr class="dataRow">
				<td class="no" hidden="no">${vo.no }</td>
				<td style="color: blue; font: bolder; padding-left: 20px;">공지</td>
				<td style="padding-left: 50px;">${vo.title }</td>
				<td>${vo.startDate } ~ ${vo.endDate }</td>
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