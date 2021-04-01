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


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Karma">
<title>유형 관리</title> 
<style type="text/css">
	.dataRow:hover {
		background: none;
		opacity: 0.8; 
		cursor: pointer; 
}

</style>
<script type="text/javascript">
$(function(){
	$(".dataRow").click(function(){
// 		alert("click");
	var no = $(this).find(".no").text();
// 	alert(no);
	location = "view.do?no=" + no + "&page=${pageObject.page}&perPageNum=${pageObject.perPageNum}";
	});
	
	// 한 페이지에 보여주는 데이터 선택의 이벤트 처리 -> 변경이 일어나면 처리
	$("#sel_perPageNum").change(function(){
// 		alert("값 변경");
//		다시 리스트 불러오기 - 전달 정보는 페이지: 1, perPageNum을 선택된 값으로 전달
		location = "list.do?page=1&perPageNum=" + $(this).val();
	});
}); 
</script> 
</head>
<body>
<div class="container">
	<h1>유형 관리</h1> 
	<div style="margin: 10px; padding: 10px; border-bottom: 2px solid #eee; height: 55px;">
		<div class="pull-left"> 
			<a href="writeForm.do?perPageNum=${pageObject.perPageNum }" class="button"
			style="font-size: 14pt">등록</a>
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
			${"</div>"}
			${"<div class='row'>"}
			</c:if>
<!-- 			 	BootStrap Grid : 한줄은 12칸으로 나눠서 운영하는 시스템 -->
			  <div class="col-md-3 dataRow">
				    <div class="w3-row-padding w3-padding-16 w3-center">
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
			<pageObject:pageNav listURI="list.do" pageObject="${pageObject }"/>
		</div>
		<c:if test="${!empty login }"> 
		</c:if>
	</div>
</div>
</body>
</html>