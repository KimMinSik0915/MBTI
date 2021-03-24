package com.mbti.member.controller;

import javax.servlet.http.HttpServletRequest;

import com.mbti.main.controller.Beans;
import com.mbti.main.controller.Controller;
import com.mbti.main.controller.ExeService;
import com.mbti.memver.vo.LoginVO;
import com.mbti.util.filter.AuthorityFilter;
import com.mbti.util.page.PageObject;

public class MemberController implements Controller{
	
	private final String MODULE = "member";
	private String jspInfo = null;
	
	@Override
	public String execute(HttpServletRequest request) throws Exception {
		System.out.println("MemberController.execute()");
		
		// 페이지 처리
		PageObject pageObject = PageObject.getInstance(request);
		request.setAttribute("pageObject", pageObject);
		
		switch (AuthorityFilter.url) {
		
		// 1. 로그인 처리
		case "/" + MODULE + "/login.do":
			login(request);
		
//		jspInfo = MODULE + "/list";
		jspInfo = "redirect:/main/main.do";
			break;
			
		// 1-1. 로그인  폼 처리
		case "/" + MODULE + "/loginForm.do":
		
//		jspInfo = MODULE + "/list";
		jspInfo = MODULE + "/loginForm";
		break;

		default:
			throw new Exception("페이지 오류 404 - 존재하지 않는 페이지입니다.");
		}
		// jhp의 정보를 가지고 리턴
		// TODO Auto-generated method stub
		return jspInfo;
	}
	
	// 1. 로그인 처리
	private void login(HttpServletRequest request) throws Exception{
		
		// 자바부분
		// 데이터 받기
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		// 받은 데이터를 VO객체에 저장하기
		LoginVO vo = new LoginVO();
		vo.setId(id);
		vo.setPw(pw);
		// jsp - service - dao
		LoginVO loginVO = (LoginVO) ExeService.execute(Beans.getService(AuthorityFilter.url), vo); 
		
		// id, pw 틀린 경우 처리
		if(loginVO == null) throw new Exception("로그인 정보를 확인해 주세요");
		// 로그인 처리
		request.getSession().setAttribute("login", loginVO);
	}
	

}
