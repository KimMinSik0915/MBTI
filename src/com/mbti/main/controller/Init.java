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

import com.mbti.board.controller.BoardController;
import com.mbti.board.dao.BoardDAO;
import com.mbti.board.service.BoardDeleteService;
import com.mbti.board.service.BoardListService;
import com.mbti.board.service.BoardUpdateService;
import com.mbti.board.service.BoardViewService;
import com.mbti.board.service.BoardWriteService;
import com.mbti.mbti.controller.MbtiController;
import com.mbti.member.controller.MemberController;
import com.mbti.member.dao.MemberDAO;
import com.mbti.member.service.MemberLoginService;
//import com.mbti.member.dao.MemberDAO;
//import com.mbti.member.service.MemberCheckIdService;
//import com.mbti.member.service.MemberGradeModifyService;
//import com.mbti.member.service.MemberListService;
//import com.mbti.member.service.MemberLoginService;
//import com.mbti.member.service.MemberViewService;
//import com.mbti.member.service.MemberWriteService;
//import com.mbti.memeber.controller.MemberController;
import com.mbti.notice.controller.NoticeController;
import com.mbti.notice.dao.NoticeDAO;
import com.mbti.notice.service.NoticeDeleteService;
import com.mbti.notice.service.NoticeListService;
import com.mbti.notice.service.NoticeViewService;
import com.mbti.notice.service.NoticeWriteService;
import com.mbti.result.controller.ResultController;
import com.mbti.type.controller.TypeController;
import com.mbti.type.dao.TypeDAO;
import com.mbti.type.service.TypeListService;

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

		Beans.putController("/result", new ResultController());


		
		// Service, Controller, DAO를 저장할 때 오탈자 꼭 확인하고 Service는 꼭 DAO를 넣었는지 확인할 것!!!!
		// List ==========================================================================
		
		
		// Service, Controller, DAO를 저장할 때 오탈자 꼭 확인하고 Service는 꼭 DAO를 넣었는지 확인할 것!!!!
		// Type ==========================================================================
		// controller 생성 -> 저장
		Beans.putController("/type", new TypeController());
		
		//dao 생성 -> 저장
		Beans.putDAO("typeDAO", new TypeDAO());
		
		//service 생성 -> 저장
		Beans.putService("/type/list.do", new TypeListService());
		
		//service에 dao 넣기
		Beans.getService("/type/list.do").setDAO(Beans.getDAO("typeDAO"));
		
		// Service, Controller, DAO를 저장할 때 오탈자 꼭 확인하고 Service는 꼭 DAO를 넣었는지 확인할 것!!!!
		// Board ==========================================================================
		// controller 생성 -> 저장
		Beans.putController("/board", new BoardController());
		

		//dao 생성 -> 저장 

		//dao 생성 -> 저장
		
		//dao 생성 -> 저장
		Beans.putDAO("boardDAO", new BoardDAO());
		
		//service 생성 -> 저장
		Beans.putService("/board/list.do", new BoardListService());
		Beans.putService("/board/view.do", new BoardViewService());
		Beans.putService("/board/write.do", new BoardWriteService());
		Beans.putService("/board/update.do", new BoardUpdateService());
		Beans.putService("/board/delete.do", new BoardDeleteService());
		
		//service에 dao 넣기
		Beans.getService("/board/list.do").setDAO(Beans.getDAO("boardDAO"));
		Beans.getService("/board/view.do").setDAO(Beans.getDAO("boardDAO"));
		Beans.getService("/board/write.do").setDAO(Beans.getDAO("boardDAO"));
		Beans.getService("/board/update.do").setDAO(Beans.getDAO("boardDAO"));
		Beans.getService("/board/delete.do").setDAO(Beans.getDAO("boardDAO"));
		
		// Service, Controller, DAO를 저장할 때 오탈자 꼭 확인하고 Service는 꼭 DAO를 넣었는지 확인할 것!!!!
		// Notice ==========================================================================
		// Controller 생성 -> 저장
		Beans.putController("/notice", new NoticeController());
		
		// dao 생성 -> 저장
		Beans.putDAO("noticeDAO", new NoticeDAO());
		
		// service 생성 -> 저장
		Beans.putService("/notice/list.do", new NoticeListService());
		Beans.putService("/notice/view.do", new NoticeViewService());
		Beans.putService("/notice/write.do", new NoticeWriteService());
		Beans.putService("/notice/delete.do", new NoticeDeleteService());
		
		//service에 dao 넣기
		Beans.getService("/notice/list.do").setDAO(Beans.getDAO("noticeDAO"));
		Beans.getService("/notice/view.do").setDAO(Beans.getDAO("noticeDAO"));
		Beans.getService("/notice/write.do").setDAO(Beans.getDAO("noticeDAO"));
		Beans.getService("/notice/delete.do").setDAO(Beans.getDAO("noticeDAO"));
		
		// Service, Controller, DAO를 저장할 때 오탈자 꼭 확인하고 Service는 꼭 DAO를 넣었는지 확인할 것!!!!
		// FeedBack ==========================================================================
		
		
		// Service, Controller, DAO를 저장할 때 오탈자 꼭 확인하고 Service는 꼭 DAO를 넣었는지 확인할 것!!!!
		// Member ==========================================================================
		// controller 생성 -> 저장
		Beans.putController("/member", new MemberController());
//		
//		//dao 생성 -> 저장
		Beans.putDAO("memberDAO", new MemberDAO());
//		
//		//service 생성 -> 저장
//		Beans.putService("/member/list.do", new MemberListService());
//		Beans.putService("/member/view.do", new MemberViewService());
//		Beans.putService("/member/write.do", new MemberWriteService());
		Beans.putService("/member/login.do", new MemberLoginService());
//		Beans.putService("/member/checkId.do", new MemberCheckIdService());
//		Beans.putService("/member/gradeModify.do", new MemberGradeModifyService());
		
		//service에 dao 넣기
		Beans.getService("/member/list.do").setDAO(Beans.getDAO("memberDAO"));
		Beans.getService("/member/view.do").setDAO(Beans.getDAO("memberDAO"));
		Beans.getService("/member/write.do").setDAO(Beans.getDAO("memberDAO"));
		Beans.getService("/member/login.do").setDAO(Beans.getDAO("memberDAO"));
		Beans.getService("/member/checkId.do").setDAO(Beans.getDAO("memberDAO"));
		Beans.getService("/member/gradeModify.do").setDAO(Beans.getDAO("memberDAO"));
		
		
		// 저장이 잘 되어 있는지 확인
		System.out.println("Init.init().Beans.getService(\"/type/list.do\" :  " + Beans.getService("/type/list.do"));
		System.out.println("Init.init().Beans.getCotroller(\"/type :  " + Beans.getController("/type"));
		//System.out.println("Init.init().Beans.get(\"/main/main.do\" :  " + Beans.getDAO("/main/main.do"));
		
		try {
			
			Class.forName("com.mbti.util.db.DBInfo");			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
			throw new ServletException("드라이버를 확인하는 중 오류가 발생하였습니다. 드라이버를 확인해 주세요");
			
		}
		
	}

}
