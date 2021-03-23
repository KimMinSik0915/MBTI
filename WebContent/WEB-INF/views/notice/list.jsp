<%@page import="com.mbti.util.filter.AuthorityFilter"%>
<%@page import="com.mbti.main.controller.Beans"%>
<%@page import="com.mbti.main.controller.ExeService"%>
<%@page import="com.mbti.notice.vo.NoticeVO"%>
<%@page import="java.util.List"%>
<%@page import="com.mbti.util.page.PageObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="pageObject" tagdir="/WEB-INF/tags" %>
<%
//자바부분 데이터 가져오기 - 페이지 처리 : 페이지와 한페이지당 표시 데이터의 갯수를 전달 받아야 한다.
String strCurPage = request.getParameter("page");
long curPage = 1; // 현재 페이지의 기본값 세팅
if(strCurPage != null) curPage = Long.parseLong(strCurPage);
String strPerPageNum = request.getParameter("perPageNum");
long perPageNum = 10;
if(strPerPageNum != null) perPageNum = Long.parseLong(strPerPageNum);

//page처리를 위한 객체 생성
PageObject pageObject = new PageObject();
pageObject.setPage(curPage);
pageObject.setPerPageNum(perPageNum);

// //DB에서 데이터 가져오기
// String url = request.getServletPath();
// @SuppressWarnings("unchecked")
// List<NoticeVO> list = (List<NoticeVO>) ExeService.execute(Beans.get(AuthorityFilter.url), pageObject);
// //서버 객체에 데이터 저장하기
// request.setAttribute("list", list);
// request.setAttribute("pageObject", pageObject);
%>

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