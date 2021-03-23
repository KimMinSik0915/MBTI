package com.mbti.notice.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.mbti.main.controller.Beans;
import com.mbti.main.controller.Controller;
import com.mbti.main.controller.ExeService;
import com.mbti.notice.vo.NoticeVO;
import com.mbti.util.filter.AuthorityFilter;
import com.mbti.util.page.PageObject;

public class NoticeController implements Controller{
	private final String MODULE = "notice";
	private String jspInfo = null;
	
	@Override
	public String execute(HttpServletRequest request) throws Exception{
		
		// 페이지 처리를 한다.
		// 페이지는 여기서 처리하므로 따로 처리해줄 필요가 없다.
		PageObject pageObject = PageObject.getInstance(request);
		request.setAttribute("pageObject", pageObject); // 페이지를 보여주기 위해 서버객체에 담
		
		switch (AuthorityFilter.url) {
		case "/" + MODULE + "/list.do":
			
			list(request, pageObject);
			// "notice/list" 넘긴다. -> /WEB-INF/views/ + notice/list + .jsp를 이용해서 HTML을 만든다.
			jspInfo = MODULE + "/list";
			
			break;

		default:
			break;
		}
		return jspInfo;
	}
	
	private void list(HttpServletRequest request, PageObject pageObject) throws Exception{
		
		@SuppressWarnings("unchecked")
		List<NoticeVO> list = (List<NoticeVO>) ExeService.execute(Beans.get(AuthorityFilter.url), pageObject);
		//서버 객체에 데이터 저장하기
		request.setAttribute("list", list);
	}
}
