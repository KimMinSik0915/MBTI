
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
			<td><pre style="border: none; background: white;padding: 0px;">${vo.content }</pre></td>
		</tr>
		<tr>
			<th>작성일</th>
			<td>${vo.writeDate }</td>
		</tr>
		<tr>
			<td colspan="2">
				<c:if test="${vo.id == login.id || login.gradeNo == 9}">
					<a href ="answerForm.do?no=${vo.no }" class="btn btn-default">답변</a>
				</c:if>
					<a href ="delete.do?no=${vo.no }" class="btn btn-default">삭제</a>
				<a href ="list.do" class="btn btn-default">리스트</a>
			</td>
		</tr>
	</table>
</div>
</body>
</html>