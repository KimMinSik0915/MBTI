/*
 * 권한 설정을 위한 필터
 * 작성자 : 궁금해조
 * 작성일 : 2021.03.21
 * ver_1.0
 */
package com.mbti.util.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class AuthorityFilter
 */
//@WebFilter("/AuthorityFilter")
public class AuthorityFilter implements Filter {

	private static Map<String, Integer> authMap = new HashMap<>();	// url에 대한 권한 정보를 저장하는 MAP 서버가 로딩될 때 정해져야 한다.
	
	{	// 페이지에 대한 등급 정보를 저장하는 method
		
		//==================== 테스트 목록 ===========================================
		authMap.put("/list/update.do", 9);
		authMap.put("/list/delete.do", 9);
		authMap.put("/list/write.do", 9);
		
		//=================== 게시판 ===============================================     
		authMap.put("/board/view.do", 1);
		authMap.put("/board/write.do", 1);
		authMap.put("/board/update.do", 1);
		authMap.put("/board/delete.do", 1);
		
		//=================== 공지사항 ==============================================
		authMap.put("/notice/view.do", 1);
		authMap.put("/notice/update.do", 9);
		authMap.put("/notice/delete.do", 9);
		
		//================== 피드백 ================================================
		authMap.put("/feedback/list.do", 1);
		authMap.put("/feedback/view.do", 1);
		authMap.put("/feedback/update.do", 1);
		authMap.put("/feedback/delete.do", 1);
		authMap.put("/feedback/write.do", 1);
		
		//=================== 로그인 =============================================
//
//		
	}
	
	public static String url;
	
    /**
     * Default constructor. 
     */
    public AuthorityFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		HttpServletRequest req = (HttpServletRequest) request;
		
		System.out.println("AuthorityFilter.doFilter : 권한처리");
		
		url = req.getServletPath();
		
		System.out.println("Authority.doFilter.url : " + url);
		
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/*
	 * private boolean checkAuthority(LoginVO vo) {
	 * 
	 * Integer pageGradeNo = authMap.get(url);
	 * 
	 * // ================== 로그인이 필요없는 서비스 ========================================
	 * if(pageGradeNo == null) {
	 * 
	 * System.out.println("AuthorityFilter.checkAuthority() : 권한이 필요없는 서비스 입니다. ");
	 * 
	 * return true;
	 * 
	 * }
	 * 
	 * 
	 * if(vo==null) {
	 * 
	 * System.out.println("AuthorityFilter.doFilter() : 로그인이 필요한 서비스 입니다");
	 * 
	 * return false;
	 * 
	 * }
	 * 
	 * // 로그인이 필요할 때 로그인이 필요한 처리 if(pageGradeNo > vo.getGreadeNo()) {
	 * 
	 * System.out.println("AuthorityFilter.checkAuthority() : 페이지에 대한 권한이 없습니다.");
	 * 
	 * return false;
	 * 
	 * }
	 * 
	 * System.out.println("AuthorityFilter.checkAuthority() : 페이지에 대한 권한이 있습니다.");
	 * 
	 * return true;
	 * 
	 * }
	 */
	
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
