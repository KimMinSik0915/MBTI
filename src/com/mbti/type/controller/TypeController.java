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
}
