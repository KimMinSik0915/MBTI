/**
 * 서버가 실행될 때 초기화 시켜주는 Servlet
 * 작성자 : 궁금해조
 * 작성일 : 2021.03.21
 * ver_1.0
 */
package com.mbti.main.controller;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import com.mbti.mbti.controller.MbtiController;

/**
 * Servlet implementation class Init
 */
@WebServlet(value = "/Init", loadOnStartup = 1)
public class Init extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Init() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		
		System.out.println("MBTI 서버 실행 ======================================================================= ");
		
		// Service, Controller, DAO를 저장할 때 오탈자 꼭 확인하고 Service는 꼭 DAO를 넣었는지 확인할 것!!!!
		// Main ==========================================================================
		Beans.putController("/mbti", new MbtiController());
		
		// Service, Controller, DAO를 저장할 때 오탈자 꼭 확인하고 Service는 꼭 DAO를 넣었는지 확인할 것!!!!
		// List ==========================================================================
		
		
		// Service, Controller, DAO를 저장할 때 오탈자 꼭 확인하고 Service는 꼭 DAO를 넣었는지 확인할 것!!!!
		// Type ==========================================================================
		
		
		// Service, Controller, DAO를 저장할 때 오탈자 꼭 확인하고 Service는 꼭 DAO를 넣었는지 확인할 것!!!!
		// Board ==========================================================================
		
		
		// Service, Controller, DAO를 저장할 때 오탈자 꼭 확인하고 Service는 꼭 DAO를 넣었는지 확인할 것!!!!
		// Notice ==========================================================================
		
		
		// Service, Controller, DAO를 저장할 때 오탈자 꼭 확인하고 Service는 꼭 DAO를 넣었는지 확인할 것!!!!
		// FeedBack ==========================================================================
		
		
		// Service, Controller, DAO를 저장할 때 오탈자 꼭 확인하고 Service는 꼭 DAO를 넣었는지 확인할 것!!!!
		// Member ==========================================================================
		
		
		
		// 저장이 잘 되어 있는지 확인
		//System.out.println("Init.init().Beans.get(\"/main/main.do\" :  " + Beans.getService("/main/main.do"));
		System.out.println("Init.init().Beans.getCotroller(\"/mbti :  " + Beans.getController("/mbti"));
		//System.out.println("Init.init().Beans.get(\"/main/main.do\" :  " + Beans.getDAO("/main/main.do"));
		
		try {
			
			Class.forName("com.mbti.util.db.DBInfo");			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
			throw new ServletException("드라이버를 확인하는 중 오류가 발생하였습니다. 드라이버를 확인해 주세요");
			
		}
		
	}

}
