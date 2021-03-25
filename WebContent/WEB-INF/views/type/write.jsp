<%@page import="com.mbti.member.vo.LoginVO"%>
<%@page import="com.mbti.util.filter.AuthorityFilter"%>
<%@page import="com.mbti.main.controller.Beans"%>
<%@page import="com.mbti.main.controller.ExeService"%>
<%@page import="com.mbti.type.vo.TypeVO"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// 자바 
// 저장 위치
String path = "/upload/image/";
String realPath = request.getServletContext().getRealPath(path);
System.out.println("/image/write.do [realPath] - " + realPath);
// fileSize : 용량 제한 -10 MByte
int fileSize = 10 * 1024 * 1024; // 1000 -> 1K, 1000k -> 1M, 1000M -> 1G, 1000G -> 1T

// 파일의 정보를 처리해 주는 객체 생성 -> 파일 업로드가 자동으로 이루어 진다.
// new MultipartRequest(request, 실제적인 저장위치 - 컴에서, 파일용량제한, 엔코딩방식, 중복된파일이름처리객체)
MultipartRequest multi = new MultipartRequest(request, realPath, fileSize, 
		"utf-8", new DefaultFileRenamePolicy());
// System.out.println("/image/write.do [request.title] - " + request.getParameter("title"));
System.out.println("/image/write.do [multi.type] - " + multi.getParameter("type"));
String type = multi.getParameter("type");
String content = multi.getParameter("content");
String gType = multi.getParameter("gType");
String bType = multi.getParameter("bType");
// 서버에 저장된 파일명
String image = multi.getFilesystemName("imageFile");
System.out.println("/image/write.do [image] - " + image);
//VO 객체를 생성하고 저장한다.
TypeVO vo = new TypeVO();
vo.setType(type);
vo.setContent(content);
vo.setImage(path + image);
vo.setgType(gType);
vo.setgImage(path + image);
vo.setbType(bType);
vo.setbImage(path + image);

//DB처리
ExeService.execute(Beans.getService(AuthorityFilter.url), vo);

// 리스트로 이동시킨다.
response.sendRedirect("list.do?page=1&perPageNum=" + multi.getParameter("perPageNum"));

%>
