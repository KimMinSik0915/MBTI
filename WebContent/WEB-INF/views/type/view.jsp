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
<title>유형관리 보기</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
body, h1,h2,h3,h4,h5,h6 {font-family: "Montserrat", sans-serif}
/* Set the width of the sidebar to 120px */
/* Add a left margin to the "page content" that matches the width of the sidebar (120px) */
/* Remove margins from "page content" on small screens */
/* @media only screen and (max-width: 600px) {#main {margin-left: 0}} */
</style>
</head>
<body>
<h1>유형관리</h1>
<a href="updateForm.do?no=${vo.no }" class="btn btn-default" >수정</a>
<a href="delete.do?no=${vo.no }&perPageNum=${pageObject.perPageNum }" class="btn btn-default">삭제</a>
<!--EL 객체 -pageObject.page =>reqest.getParameter("page")  -->
<a href="list.do?page=${pageObject.page }&perPageNum=${pageObject.perPageNum}" 
class="btn btn-default">리스트</a>

 <div class="w3-container w3-padding-32 w3-center" id="home">
    <h1 class="w3-jumbo"><span class="w3-hide-small" style="font-style: italic; ">${vo.title }</span></h1>
    <p style="font-size: 1.5em;">${vo.name }</p><br/>
    

  <div class="w3-content w3-justify w3-text-grey w3-padding-64" id="about">
    <h2 class="w3-text-light-grey"></h2>
    <hr style="width:200px" class="w3-opacity">
    <img src="${vo.image }" alt="boy" class="w3-image" width="992" height="1108">
	<p>
	${vo.content }
    </p>
    <h3 class="w3-padding-16 w3-text-light-grey"></h3>
    <p class="w3-wide">Photography</p>
    <div class="w3-white">
      <div class="w3-dark-grey" style="height:28px;width:95%"></div>
    </div>
    <p class="w3-wide">Web Design</p>
    <div class="w3-white">
      <div class="w3-dark-grey" style="height:28px;width:85%"></div>
    </div>
    <p class="w3-wide">Photoshop</p>
    <div class="w3-white">
      <div class="w3-dark-grey" style="height:28px;width:80%"></div>
    </div><br>
  </div>
  

<!-- END PAGE CONTENT -->
</div>
</body>
</html>