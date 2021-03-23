package com.mbti.notice.controller;

import javax.servlet.http.HttpServletRequest;

import com.mbti.main.controller.Controller;
import com.mbti.util.filter.AuthorityFilter;

public class NoticeController implements Controller{
	private final String MODULE = "notice";
	private String jspInfo = null;
	
	@Override
	public String execute(HttpServletRequest request) throws Exception{
		switch (AuthorityFilter.url) {
		case "/" + MODULE + "/list.do":
			
			break;

		default:
			break;
		}
		return jspInfo;
	}
}
