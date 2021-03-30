<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>4walls<decorator:title /></title>
<!--  부트 스트랩 라이브러리 등록을 전체적으로 진행을 했다. Filter가 적용이 되면 개별적으로 한 것은 지워야 한다. -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="../../css/style.css" type="text/css" media="all" />
<decorator:head/>
</head>
<body>
	<header>
  <div id="header"> 
    <h1 id="logo"><a href="#">4Walls </a></h1>
    <div id="navigation">
      <ul>
        <li><a class="active" href="/list/list.do">HOME</a></li>
        <li><a href="#">공지사항</a></li>
        <li><a href="#">게시판</a></li>
        <li><a href="#">Q&amp;A게시판</a></li>
        <li><a href="#">관리자용 Q&amp;A게시판</a></li>
        <li><a href="#">유형관리</a></li>
        <li><a href="#">회원가입</a></li>
        <li><a href="#">로그인</a></li>
      </ul>
    </div>
    <div id="sub-navigation">
      <ul>
        <li><a href="#">SHOW ALL</a></li> 
        <li><a href="#">LATEST TRAILERS</a></li>
        <li><a href="#">TOP RATED</a></li>
        <li><a href="#">MOST COMMENTED</a></li>
      </ul>
      <div id="search">
        <form action="#" method="get" accept-charset="utf-8">
          <label for="search-field">검색</label>
          <input type="text" name="search field" value="Enter search here" id="search-field" class="blink search-field"  />
          <input type="submit" value="GO!" class="search-button" />
        </form>
      </div>
    </div>
  </div>
	</header>
	<article>
		<decorator:body />
	</article>
	<footer>
		  <div id="footer">
    <p class="lf">Copyright &copy; 2010 <a href="#">SiteName</a> - All Rights Reserved</p>
    <p class="rf">Design by <a href="http://chocotemplates.com/">ChocoTemplates.com</a></p>
    <div style="clear:both;"></div>
  </div>
	</footer>
</body>
</html>