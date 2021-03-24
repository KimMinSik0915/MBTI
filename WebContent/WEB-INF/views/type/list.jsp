<%@page import="com.mbti.util.filter.AuthorityFilter"%>
<%@page import="com.mbti.main.controller.Beans"%>
<%@page import="com.mbti.main.controller.ExeService"%>
<%@page import="com.mbti.type.vo.TypeVO"%>
<%@page import="java.util.List"%>
<%@page import="com.mbti.util.page.PageObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="pageObject" tagdir="/WEB-INF/tags" %>    
 <%
 // 자바 - 게시판 리스트 동일
 // 페이지 정보의 초기값 세팅
 Long curPage = 1L;
 Long perPageNum = 12L;
 // 넘어오는 데이터 저장
 String strCurPage = request.getParameter("page");
 String strPerPageNum = request.getParameter("perPageNum");
 //PageObject 생성 세팅
 PageObject pageObject = new PageObject();
 if(strCurPage != null&& !strCurPage.equals("")) curPage = Long.parseLong(strCurPage);
 if(strPerPageNum != null&& !strPerPageNum.equals("")) perPageNum = Long.parseLong(strPerPageNum);
 pageObject.setPage(curPage);
 pageObject.setPerPageNum(perPageNum);
 
 @SuppressWarnings("unchecked")
 List<TypeVO> list = (List<TypeVO>)ExeService.execute(Beans.getService(AuthorityFilter.url), pageObject);
 // 서버 객체에 담기 - List와 PageObject, 프로젝트의 패스 
 request.setAttribute("list", list);
 request.setAttribute("pageObject", pageObject);
 request.setAttribute("path", request.getContextPath());
 %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>유형 관리</title>
<style type="text/css">
	.dataRow:hover {
		background: #eee;
		cursor: pointer;
}
</style>
<script type="text/javascript">
$(function(){
	$(".dataRow").click(function(){
		alert("click");
	});
});
</script>
</head>
<body>
<div class="container">
	<h1>유형 관리</h1>
	<div style="margin: 10px; padding: 10px; border-bottom: 2px solid #eee; height: 55px;">
		<div class="pull-left">
			<a href="writeForm.jsp?perPageNum=${pageObject.perPageNum }" class="btn btn-default">등록</a>
		</div>
	<div class="pull-right form-inline">
		<label>한 페이지에 표시되는 데이터</label>
		<select class="form-control" id="sel_perPageNum">
			<option ${(pageObject.perPageNum == 4)?"selected":"" }>4</option>
			<option ${(pageObject.perPageNum == 8)?"selected":"" }>8</option>
			<option ${(pageObject.perPageNum == 12)?"selected":"" }>12</option>
			<option ${(pageObject.perPageNum == 16)?"selected":"" }>16</option>
		</select>
	</div>
	</div>
	<div class="line"></div>
	<div id="type_manage">
	
		<div class="row">
			<c:forEach items="${list }" var="vo" varStatus="vs">
			<c:if test="${(vs.index > 0 ) && (vs.index % 4 == 0)}">
			${"<div>"}
			${"<div class='row'>"}
			</c:if>
<!-- 			 	BootStrap Grid : 한줄은 12칸으로 나눠서 운영하는 시스템 -->
			  <div class="col-md-3 dataRow">
				    <div class="thumbnail">
				        <img src="${path }${vo.image}" alt="Lights" style="width:100%">
				        <div class="caption">
				          <p>[<span class="no">${vo.no }</span>] ${vo.type }</p>
						 ${vo.updateDate }
				        </div>
				    </div>
				</div>
			</c:forEach>
		</div>
		<div>
			<pageObject:pageNav listURI="list.jsp" pageObject="${pageObject }"/>
		</div>
		<c:if test="${!empty login }">
			<div>
				<a href="writeFor.jsp?perPageNum=${pageObject.perPageNum }" class="btn btn-default">등록</a>
			</div>
		</c:if>
	</div>
</div>
</body>
</html>