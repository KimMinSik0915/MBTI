<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="pageObject" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Test list</title>
<style type="text/css">

	.dataRow:hover {
	
		background: #eee; 
		cursor: pointer;
	
	}
	
	#image_gallery, .line {
	
		clear: both;
	
	}
	
	.line {
	
		height: 20px;
	
	}
	
}
</style>
<script type="text/javascript">

	$(function () {
		
		$(".dataRow").click(function() {
			
			var url = $("#url").val();
				
			//alert(url);
			
			location = url;
			
		});
		
	});

</script>
</head>
<body>
 <div class="container">
  <h1>Test List</h1>
  <div style="padding: 10pxl; border-bottom: 2px solid #eee; height: 55px;">
  <div class="pull-left">
   <a href="writeForm.jsp?perPageNum=${pageObject.perPageNum }" class="btn btn-default">등록</a>
  </div>
  <div class="pull-right form-inline">
   <label>한 페이지에 표시할 데이터</label>
   <select class="form-control" id="sel_perPageNum">
    <option>${(pageObject.perPageNum==4)?"selected":"" }4</option>
    <option>${(pageObject.perPageNum==4)?"selected":"" }8</option>
    <option>${(pageObject.perPageNum==4)?"selected":"" }12</option>
    <option>${(pageObject.perPageNum==4)?"selected":"" }16</option>
   </select>
  </div>
 </div>
 <div class="line"></div>
 <div id="image_gallery">
  <div class="row">
   <c:forEach items="${list }" var="vo" varStatus="vs">
    <c:if test="${(vs.index > 0) && (vs.index % 4 == 0) }">
     ${"</div>" }
     ${"<div class='row'>" }
    </c:if>
    <div class="col-md-3 dataRow">
     <div class="thumbnail">
      <form action="${vo.url }" method="post">
       <img src="${vo.image }" alt="Light" style="width: 100%" class="img">
       <div class="caption">
        <p> [<span class="no">${vo.no }</span>] ${vo.title }</p><span>[${vo.hit }]</span>
        <input type="hidden" value="${vo.url }" id="url">
       </div>
      </form>
     </div>
    </div>
   </c:forEach>
  </div>
  <div>
   <pageObject:pageNav listURI="list.jsp" pageObject="${pageObject }"/>
  </div>
  <div>
   <a href="wrtieForm.jsp?perPageNum=${pageObject.perPageNum }" class="btn btn-default">등록</a>
  </div>
 </div>
</div>
</body>
</html>