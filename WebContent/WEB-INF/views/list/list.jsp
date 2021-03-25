<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="pageObject" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Test list</title>
</head>
<body>
 <div class="container">
  <h1>Test List</h1>
  <div class="pull-left">
   <a href="writeForm.jsp?perPageNum=${pageObject.perPageNum }" class="btn btn-default">등록</a>
  </div>
  <div class="pull-rigth form-inline">
   <label>한 페이지에 표시할 데이터</label>
   <select class="form-controll" id="sel_perPageNum">
    <option>${(pageObject.perPageNum==4)?"selected":"" }4</option>
    <option>${(pageObject.perPageNum==4)?"selected":"" }8</option>
    <option>${(pageObject.perPageNum==4)?"selected":"" }12</option>
    <option>${(pageObject.perPageNum==4)?"selected":"" }16</option>
   </select>
  </div>
 </div>
 <div class="line"></div>
 <div id="MBTIList">
  <div class="orw">
   <c:forEach items="${list }" var="no" varStatus="vs">
    <c:if test="${(vs.index > 0) && (vs.index % 4 == 0) }">
     <img src="${vo.image }" alt="Light" style="width: 100%">
     <div class="caption">
      <p>${vo.title }</p><span>[${vo.hit }]</span>
     </div>
    </c:if>
   </c:forEach>
  </div>
  <div>
   <pageObject:pageNav listURI="list.jsp" pageObject="${pageObject }"/>
  </div>
  <div>
   <a href="wrtieForm.jsp?perPageNum=${pageObject.perPageNum }" class="btn btn-default">등록</a>
  </div>
 </div>
</body>
</html>