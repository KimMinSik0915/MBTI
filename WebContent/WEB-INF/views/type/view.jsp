<%@page import="com.mbti.main.controller.Beans"%>
<%@page import="com.mbti.util.filter.AuthorityFilter"%>
<%@page import="com.mbti.main.controller.ExeService"%>
<%@page import="com.mbti.type.vo.TypeVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
//자바
//넘어오는 데이터
String strNo = request.getParameter("no");
Long no = Long.parseLong(strNo);
//DB에서 받아오기
TypeVO vo = (TypeVO) ExeService.execute(Beans.getService(AuthorityFilter.url), no);
// 프로젝트 패스 구하기
String path = request.getContextPath();
// 서버객체 request에 저장하기
request.setAttribute("vo", vo);
request.setAttribute("path", path);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>유형관리 보기</title>

<script type="text/javascript">
$(function(){
	//이미지 파일 형식
	var imageExt = ["JPG","JPEG","GIF","PNG"];
	
	//이벤트 처리
	$("#changeBtn").click(function(){
// 		alert("change");
		var image = $("#imageFile").val();
// 		alert(image);
		if(!image){
			alert("변경할 이미지를 선택하세요. ");
			$("#imageFile").focus();
			return false;
		}
		var ext = image.substring(image.lastIndexOf(".")+1).toUpperCase();
		alert(ext);
		
		var checkExt = false;
		for(i = 0; i < imageExt.length; i++){
			if(ext == imageExt[i])
				checkExt = true;
				break;
		}
		
		if(!checkExt){
			alert("지원하지 않는 이미지 파일입니다.");
			$("#imageFile").focus();
			return false;
			
		}
		
		$("#updateFileForm").submit();
		
	});
});
</script>
</head>
<body>
<div class="container">
<h1>유형관리 보기</h1>
<table class="table">
	<tr>
		<td colspan="2">
				<!--작성자가 회원 또는 관리자의 경우에만 나타나는 메뉴 -->
				<a href="updateForm.do?no=${vo.no }" class="btn btn-default" >수정(제목,내용)</a>
				<button type="button" class="btn btn-default btn-default"
				 data-toggle="modal" data-target="#myModal">파일바꾸기</button>
				<a href="delete.do?no=${vo.no }&perPageNum=${param.perPageNum }&deleteFile=${vo.image}" class="btn btn-default">삭제</a>
			<!--EL 객체 -param.page =>reqest.getParameter("page")  -->
			<a href="list.do?page=${param.page }&perPageNum=${param.perPageNum}" 
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
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">이미지 변경</h4>
        </div>
        <div class="modal-body">
          <p>변경할 이미지 파일을 선택하세요.</p>
        </div>
        <div class="modal-footer">
        	<form action="updateFile.do" method="post" enctype="multipart/form-data"
        	id="updateFileForm">
<!--         	페이지 정보를 숨겨서 넘긴다. -->
				<input name="page" value="${param.page }" type="hidden">
				<input name="perPageNum" value="${param.perPageNum }" type="hidden">
        		<div class="form-group">
        			<label for="no">번호</label>
        			<input name="no" id="no" class="form-control" value="${vo.no }" 
        			readonly="readonly">
        		</div>
        		<div class="form-group">
        			<label for="deleteFile">원본파일</label>
        			<input name="deleteFile" id="deleteFile" class="form-control" value="${vo.image }" 
        			readonly="readonly">
        		</div>
        		<div class="form-group">
        			<label for="imageFile">변경 파일 선택</label>
        			<input name="imageFile" id="imageFile" class="form-control"
        			type="file"> 
        		</div>
        	</form>
        	<div class="modal-footer"> 
         <button type="button" class="btn btn-default" id="changeBtn">변경</button>
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        
        </div>
      </div>
      </div>
      </div>
      </div>
</div>
</body>
</html>