package com.mbti.result.controller;

import javax.servlet.http.HttpServletRequest;

import com.mbti.main.controller.Controller;
import com.mbti.util.filter.AuthorityFilter;

public class ResultController implements Controller {

	private final String MODULE = "result";
	
	private String jspInfo = null;
	
	@Override
	public String execute(HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub

		System.out.println("resultController 실행");
		
		switch (AuthorityFilter.url) {
		 
			case "/" +  MODULE + "/result.do" :
				
				jspInfo = MODULE + "/result";
			
				System.out.println(jspInfo);
				
				break;
				
			default:

				throw new Exception("MainController - 404 Not Found : 존재하지 않는 URL입니다.");
					
		}
		
		return jspInfo;
		
	}

}
