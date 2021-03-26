package com.mbti.list.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;


import com.mbti.list.vo.ListVO;
import com.mbti.main.controller.Beans;
import com.mbti.main.controller.Controller;
import com.mbti.main.controller.ExeService;
import com.mbti.util.filter.AuthorityFilter;
import com.mbti.util.page.PageObject;

public class ListController implements Controller {

	private final String MODULE = "list";
	
	private String jspInfo = null;
	
	@Override
	public String execute(HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		
		PageObject pageObject = PageObject.getInstance(request);
		
		request.setAttribute("pageObject", pageObject);
		
		switch (AuthorityFilter.url) {
		
			case "/" + MODULE + "/list.do" :
				
				list(request, pageObject); 
			
				jspInfo = MODULE + "/list";
				
				break;

			default:
				
				throw new Exception("404 Not Found : 존재하지 않는 페이지 입니다.");
			
			
		}
		
		
		return jspInfo;
	}

	private void list(HttpServletRequest request, PageObject pageObject) throws Exception {
		
		@SuppressWarnings("unchecked")
		List<ListVO> list = (List<ListVO>) ExeService.execute(Beans.getService(AuthorityFilter.url), pageObject);
		
		ListVO vo = new ListVO();
		
		request.setAttribute("list", list);
		
	}
	
}
