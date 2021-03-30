<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${vo.type }</title>
<script type="text/javascript">

	$(function() {
		
		$("#list").click(function() {
			
			location = "/list/list.do";
			
		});
		
	});

</script>
</head>
<body>
 <div class="container">
  <table class="table">
   <tr>
    <td><img alt="" src="${vo.image }">
   </tr>
   <tr>
    <td>${vo.content }</td>
   </tr>
   <tr>
    <td><img alt="" src=" ${vo.gImage }"></td>
   </tr>
   <tr>
    <td>${vo.gType }</td>
   </tr>
   <tr>
    <td><img alt="" src="${vo.bImage }"></td>
   </tr>
   <tr>
    <td>${vo.bType }</td>
   </tr>
   <tr>
    <td colspan="1">
     <button type="button" id="list" class="btn btn-default">리스트</button>
   </tr>
  </table>
  <input name="no" value="${param.no }" type="hidden">	
 </div>
</body>
</html>