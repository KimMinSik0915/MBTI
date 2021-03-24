package com.mbti.mbti.controller;

import javax.servlet.http.HttpServletRequest;

import com.mbti.main.controller.Controller;
import com.mbti.util.filter.AuthorityFilter;

public class MbtiController implements Controller {

	private final String MODULE = "mbti";
	
	private String jspInfo = null;
	
	@Override
	public String execute(HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub

		switch (AuthorityFilter.url) {
		
			case "/" + MODULE + "/movieMBTI.do" :
			
				jspInfo = "mbti:/movieMBTI";
				
				System.out.println( "MainController : " + jspInfo);
				
				break;

			case "/result/result.do" :
				
				jspInfo = "result:/result.do";
			
				System.out.println(jspInfo);
				
				break;
				
			default:

				throw new Exception("MainController - 404 Not Found : 존재하지 않는 URL입니다.");
					
		}
		
		return jspInfo;
		
	}

}
