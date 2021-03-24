/*
 * 설정한 URL로 이동시켜주는 Servlet
 * 작성자 : 궁금해조
 * 작성일 : 2021.03.21
 * ver_1.0
 */
package com.mbti.main.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mbti.util.filter.AuthorityFilter;

/**
 * Servlet implementation class DispatcherServlet
 */
//@WebServlet("/DispatcherServlet")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DispatcherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("DispatcherServlet.service : *.do");
		
		int endIndex = AuthorityFilter.url.indexOf("/", 1);
		
		String module = "/main";
		
		if(endIndex >= 0) {
			
			module = AuthorityFilter.url.substring(0, endIndex);	// module이 존재하면 다른 module로 바꾼다.
			
			System.out.println("DispatcherServlet.service() [module] : " + module);
			
		}
		
		// 모듈에 포함이 되어 있지 않는 URL의 처리 : siteMesh에 적용이 되지 않도록 해야 한다.
		if(AuthorityFilter.url.equals("/result/result.do")) {
			
			module = "/mbti";
			
		} 
		
		try {

			Controller controller = Beans.getController(module);	// 실행할 Controller를 선택
			
			if(controller == null) {
				
				throw new Exception("DispatcherServlet.Controller = null : 404 Error : 요청하신 URL이 존재하지 않습니다.");
				
			}
			
			// Controller를 실행하고 forward 혹은 sendRedirect 정보를 돌려받음
			String jspInfo = controller.execute(request);
			
			System.out.println(jspInfo);
			
			if(jspInfo.indexOf("redirect:") == 0) {
				
				jspInfo = jspInfo.substring("redirect:".length());
				
				response.sendRedirect(jspInfo);
				
				return;
				
			} else if(jspInfo.indexOf("mbti:") == 0) {
				
				jspInfo = jspInfo.substring("mbti:".length());
				
				request.getRequestDispatcher("/mbti" + jspInfo + ".html").forward(request, response);
				
				return;
				
			} else {
				
				request.getRequestDispatcher("/WEB-INF/views/" + jspInfo + ".jsp").forward(request, response);
				
			} 
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
			request.setAttribute("exception", e);
			
			request.getRequestDispatcher("/WEB-INF/views/error/error_page.jsp").forward(request, response);
			
		}
		
	}

}
