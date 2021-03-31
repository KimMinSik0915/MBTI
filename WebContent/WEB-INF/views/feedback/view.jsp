
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>피드백 보기</title>
</head>
<body>
<div class="container">
	<h1>피드백 보기</h1>
	<table class="table">
		<tr>
			<th>번호</th>
			<td>${vo.no }</td>
		</tr>
		<tr> 
			<th>제목</th>
			<td>${vo.title }</td>
		</tr>
		<tr>
			<th>내용</th>
			<td><pre style="border: none; background: none; padding:0px; color:white ;" >${vo.content }</pre></td>
		</tr>
		<tr>
			<th>작성일</th>
			<td>${vo.writeDate }</td>
		</tr>
		<tr>
			<td colspan="2">
				<c:if test="${vo.id == login.id || login.gradeNo == 9}">
					<a href ="answerForm.do?no=${vo.no }" class="button">답변</a>
					<a href ="delete.do?no=${vo.no }" class="button">삭제</a>
				</c:if>
				<a href ="list.do" class="button">리스트</a>
				<c:if test="${vo.id == login.id || login.gradeNo == 9}">
					<a href ="adminList.do" class="button">관리자 리스트</a>
				</c:if>
			</td>
		</tr>
	</table>
</div>
</body>
</html>