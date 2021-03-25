<%@page import="com.mbti.main.controller.Beans"%>
<%@page import="com.mbti.util.filter.AuthorityFilter"%>
<%@page import="com.mbti.main.controller.ExeService"%>
<%@page import="com.mbti.type.vo.TypeVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>유형관리 보기</title>

</head>
<body>
<div class="container">
<h1>유형관리 보기</h1>
<table class="table">
	<tr>
		<td colspan="2">
				<!--작성자가 회원 또는 관리자의 경우에만 나타나는 메뉴 -->
				<a href="updateForm.do?no=${vo.no }" class="btn btn-default" >수정(제목,내용)</a>
				<a href="delete.do?no=${vo.no }&perPageNum=${pageObject.perPageNum }&deleteFile=${vo.image}" class="btn btn-default">삭제</a>
			<!--EL 객체 -pageObject.page =>reqest.getParameter("page")  -->
			<a href="list.do?page=${pageObject.page }&perPageNum=${pageObject.perPageNum}" 
			class="btn btn-default">리스트</a>
			
		</td>
	</tr>

	<tr>
		<th style="width: 100px">번호</th>
		<td>${vo.no }</td>
		
	</tr>
	<tr>
		<th>유형</th>
		<td>${vo.type }</td>
		
	</tr>
	<tr>
		<th>내용</th>
		<td>${vo.content }</td>
		
	</tr>
	<tr>
		<th>이미지</th>
		<td><img src="${path }${vo.image}" style="width:95%"></td>
		
	</tr>
	<tr>
		<th>g유형</th>
		<td>${vo.gType}</td>
		
	</tr>
	<tr>
		<th>g이미지</th>
		<td><img src="${path }${vo.gImage}" style="width:40%"></td>
		
	</tr>
	<tr>
		<th>b유형</th>
		<td>${vo.bType}</td>
		
	</tr>
	<tr>
		<th>b이미지</th>
		<td><img src="${path }${vo.bImage}" style="width:40%"></td>
		
	</tr>
	<tr>
		<th>수정일</th>
		<td>${vo.updateDate}</td>
		
	</tr>
	<tr>
		<td colspan="2">
		</td>
	</tr>
</table>

  <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
        	<form action="updateFile.do" method="post" enctype="multipart/form-data"
        	id="updateFileForm">
<!--         	페이지 정보를 숨겨서 넘긴다. -->
				<input name="page" value="${pageObject.page }" type="hidden">
				<input name="perPageNum" value="${pageObject.perPageNum }" type="hidden">
        		<div class="form-group">
        			<label for="no">번호</label>
        			<input name="no" id="no" class="form-control" value="${vo.no }" 
        			readonly="readonly">
        		</div>
        		<div class="form-group">
        		</div>
        	</form>
        
        </div>
      </div>
      </div>
</body>
</html>