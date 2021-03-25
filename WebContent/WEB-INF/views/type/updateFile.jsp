<%@page import="com.mbti.util.file.FileUtil"%>
<%@page import="com.mbti.util.filter.AuthorityFilter"%>
<%@page import="com.mbti.main.controller.Beans"%>
<%@page import="com.mbti.main.controller.ExeService"%>
<%@page import="com.mbti.type.vo.TypeVO"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//올라갈 파일 서버의 상대 위치
String path = "/upload/image/";
String realPath = request.getServletContext().getRealPath(path);
int fileSize = 10 * 1024 * 1024;

// 파일 올리는 라이브러리 MultipartRequest 객체 생성 -> 자동으로 파일이 올라간다.
MultipartRequest multi = new MultipartRequest(request, realPath, fileSize,
		"utf-8", new DefaultFileRenamePolicy());

String strNo = multi.getParameter("no");
String deleteFile = multi.getParameter("deleteFile");
String image = multi.getFilesystemName("imageFile");

// Page에 대한 정보를 문자열로 받아서 되돌아가는 url뒤에 정보로 붙여서 이동시킨다.
String strPage = multi.getParameter("page");
String strPerPageNum = multi.getParameter("perPageNum");

// 넘겨받은 정보 확인
System.out.println("updateFile.do [no] : " + strNo);
System.out.println("updateFile.do [deleteFile] : " + deleteFile);
System.out.println("updateFile.do [image] : " + image);

// 파일 정보 수정 - 번호, 파일명
TypeVO vo = new TypeVO();
vo.setNo(Long.parseLong(strNo));
vo.setImage(path + image);

// DB에 파일 정보 수정
int result = (Integer)ExeService.execute(Beans.getService(AuthorityFilter.url), vo);

//이전 파일 삭제
String deletepath = request.getServletContext().getRealPath("/");
if(FileUtil.exist(deletepath + deleteFile))
		System.out.println(deleteFile + " 파일이 존재합니다.");
//실제적으로 지우는 처리
FileUtil.remove(deletepath + deleteFile);
// 자동으로 보기로 이동시킨다.
response.sendRedirect("view.do?no=" + strNo 
+ "&page=" + strPage + "&perPageNum=" + strPerPageNum);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>updateFile</title>
</head>
<body>
realPath: <%= realPath %><br/>
strNo: <%= strNo %><br/>
deleteFile: <%= deleteFile %><br/>
image: <%= image %><br/>
</body>
</html>