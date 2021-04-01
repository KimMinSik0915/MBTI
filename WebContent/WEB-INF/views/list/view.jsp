<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MBTI Test 등록</title>
<script type="text/javascript">

	$(function() {
		
		$(".updateBtn").click(function() {
			
			alert("수정");
			
		});
		
		$(".deleteBtn").click(function() {
			
			alert("삭제");
			
		});
		
		$(".listBtn").click(function() {
			
			alert("리스트");
			
		});
		
	});

</script>
</head>
<body>
 <div class="container">
  <h1>Test 등록</h1>
  <table>
   <tr>
    <th>번호</th>
    <td>${vo.no }</td>
   </tr>
   <tr>
    <th>타이틀</th>
    <td>${vo.title }</td>
   </tr>
   <tr>
    <th>이미지 주소</th>
    <td>${vo.image }</td>
   </tr>
   <tr>
    <th>url 주소</th>
    <td>${vo.url }</td>
   </tr>
   <tr>
    <td>
     <button type="button" class="updateBtn button">수정</button>
     <button type="button" class="deleteBtn button">삭제</button>
     <button type="button" class="listBtn button">리스트</button>
    </td>
   </tr>
  </table>
 </div>
</body>
</html>