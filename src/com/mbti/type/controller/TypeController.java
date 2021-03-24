package com.mbti.type.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.mbti.main.controller.Beans;
import com.mbti.main.controller.Controller;
import com.mbti.main.controller.ExeService;
import com.mbti.type.vo.TypeVO;
import com.mbti.util.filter.AuthorityFilter;
import com.mbti.util.page.PageObject;
import com.sun.glass.ui.View;

public class TypeController implements Controller {

	private final String MODULE = "type";
	private String jspInfo = null;
	private HttpSession session = null;
	
	@Override
	public String execute(HttpServletRequest request) throws Exception{
		System.out.println("TypeController.execute()");
		
		// 넘어오는 세션 저장
		session = request.getSession();
		
		//페이지 처리
		PageObject pageObject = PageObject.getInstance(request);
		request.setAttribute("pageObject", pageObject);
		
		switch (AuthorityFilter.url) {
		// 1. 유형 이미지 리스트
		case "/" + MODULE + "/list.do":
			list(request, pageObject);
		
			jspInfo = MODULE + "/list";
			break;
		
		// 2. 유형 관리 보기
		case "/" + MODULE + "/view.do":
			view(request);
		
		jspInfo = MODULE + "/view";
		break;
		
		//3-1. 유형 관리 이미지 게시판 글쓰기 폼
		case "/" + MODULE + "/writeForm.do":
		jspInfo = MODULE + "/writeForm";
		break;
		
		//3-2. 유형 관리 이미지 게시판 글쓰기 
		case "/" + MODULE + "/write.do":
			write(request);
		
		session.setAttribute("msg", "유형 관리 게시판 글쓰기가 성공적으로 완료되었습니다.");
		// "image/view" 넘긴다. -> /WEB-INF/views/ + image/view + .jsp를 이용해서 HTML을 만든다.
		jspInfo = "redirect:list.do?page=1&perPageNum=" + pageObject.getPerPageNum();			
		break;

		default:
			throw new Exception("TypeController - 페이지 오류 404 - 존재하지 않는 페이지입니다.");
		}
		return jspInfo;
		}
	//1. 유형 관리 리스트 처리
	private void list(HttpServletRequest request, PageObject pageObject) throws Exception {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<TypeVO> list
		= (List<TypeVO>) ExeService.execute(Beans.getService(AuthorityFilter.url), pageObject);
		request.setAttribute("list", list);
	}
	
	//2. 유형관리 글보기 처리.
	private Long view (HttpServletRequest request) throws Exception {
		
		String strNo = request.getParameter("no");
		long no = Long.parseLong(strNo);
		
		//유형관리 글보기 데이터 1개 가져오기
		TypeVO vo = (TypeVO) ExeService.execute(Beans.getService(AuthorityFilter.url), no );
		
		// 서버객체 request에 담는다.
		request.setAttribute("vo", vo);
		return no;
	}
	
	//3. 유형관리 글쓰기 처리.
	private void write (HttpServletRequest request) throws Exception {
		
		// 1. 데이터 수집
		String type = request.getParameter("type");
		String content = request.getParameter("content");

		TypeVO vo = new TypeVO();
		vo.setType(type);
		vo.setContent(content);

		// 2. DB 처리 - write.jsp -> service -> dao
		Integer result = (Integer) ExeService.execute(Beans.getService(AuthorityFilter.url), vo);

		System.out.println("TypeController.write().result : " + result);
		// 전달 메시지 저장
		request.getSession().setAttribute("msg", "유형 관리 게시판에 글이 등록되었습니다.");
	}
	
}
