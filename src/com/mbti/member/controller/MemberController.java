package com.mbti.member.controller;

import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;

import com.mbti.main.controller.Beans;
import com.mbti.main.controller.Controller;
import com.mbti.main.controller.ExeService;
import com.mbti.member.vo.LoginVO;
import com.mbti.member.vo.MemberVO;
import com.mbti.util.filter.AuthorityFilter;
import com.mbti.util.page.PageObject;

public class MemberController implements Controller{
	
	private final String MODULE = "member";
	private String jspInfo = null;
	
	@Override
	public String execute(HttpServletRequest request) throws Exception {
		System.out.println("MemberController.execute()");
		
		// 페이지 처리
		PageObject pageObject = PageObject.getInstance(request);
		request.setAttribute("pageObject", pageObject);
		
		switch (AuthorityFilter.url) {
		
		// 1. 로그인 처리
		case "/" + MODULE + "/login.do":
			login(request);
			
	//		jspInfo = MODULE + "/list";
			jspInfo = "redirect:/main/main.do";
			break;
			
		// 1-1. 로그인  폼 처리
		case "/" + MODULE + "/loginForm.do":
			
	//		jspInfo = MODULE + "/list";
			jspInfo = MODULE + "/loginForm";
			break;
			
		// 2. 로그아웃 처리
		case "/" + MODULE + "/logout.do":
			logout(request);
			// "member/view" 넘긴다 -> WEB-INF/views/ + member/writeForm + .jsp를 이용해서 HTML을 만든다.
			jspInfo = "redirect:/board/list.do";
			break;
		
		// 3. 회원가입 처리
		case "/" + MODULE + "/write.do":
			write(request);
			jspInfo = "redirect:/board/list.do";
			break;
		
		// 3-1. 회원가입 폼 처리
		case "/" + MODULE + "/writeForm.do":
			jspInfo = MODULE + "/writeForm";
			break;
		
		// 3-2. 아이디 중복 체크
		case "/ajax/checkId.do":
			// DB에서 입력한 아이디를 찾아온다.
			// 찾아온 아이디를 request에 넣는다.
			checkId(request);
			
			// div안에 들어갈 코드만 있는 jsp로 이동시킨다.
			jspInfo = "member/checkId";
			break; 
			
		// 4. 회원 정보 보기
		case "/" + MODULE + "/view.do":
			view(request);
			// "member/view" 넘긴다. -> /WEB-INF/views/ + member/view + .jsp를 이용해서 HTML을 만든다.
			jspInfo = MODULE + "/view";
			break;
		
		// 5. 회원 리스트 처리
		case "/" + MODULE + "/list.do":
			list(request, pageObject);
			jspInfo = MODULE + "/list";
			break;
		
		
		default:
			throw new Exception("페이지 오류 404 - 존재하지 않는 페이지입니다.");
		}
		// jhp의 정보를 가지고 리턴
		// TODO Auto-generated method stub
		return jspInfo;
	}
	
	// 1. 로그인 처리
	private void login(HttpServletRequest request) throws Exception{
		
		// 자바부분
		// 데이터 받기
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		// 받은 데이터를 VO객체에 저장하기
		LoginVO vo = new LoginVO();
		vo.setId(id);
		vo.setPw(pw);
		// jsp - service - dao
		LoginVO loginVO = (LoginVO) ExeService.execute(Beans.getService(AuthorityFilter.url), vo); 
		
		// id, pw 틀린 경우 처리
		if(loginVO == null) throw new Exception("로그인 정보를 확인해 주세요");
		// 로그인 처리
		request.getSession().setAttribute("login", loginVO);
	}
	
	// 2. 로그아웃 처리
	private void logout(HttpServletRequest request) throws Exception{
		request.getSession().invalidate();
		System.out.println("로그아웃 처리가 되었습니다.");
	}
	
	// 3. 회원가입 처리
	private void write(HttpServletRequest request) throws Exception{
		
		// 자바 
		// 데이터 수집
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String birth= request.getParameter("birth");
		String tel= request.getParameter("tel");
		String email= request.getParameter("email");
		
		MemberVO vo = new MemberVO();
		vo.setId(id);
		vo.setPw(pw);
		vo.setName(name);
		vo.setGender(gender);
		vo.setBirth(birth);
		vo.setTel(tel);
		vo.setEmail(email);
		
		Integer result = (Integer) ExeService.execute(Beans.get(AuthorityFilter.url), vo);
		System.out.println("BoardController.write().result : " + result); 
	}
	
	// 3-1. 아이디 중복체크
	private void checkId(HttpServletRequest request) throws Exception{
		
		// 자바
		// 넘어온 아이디 받기
		String id = request.getParameter("id");
		// DB처리 -> id 가져오기
		String result = (String) ExeService.execute(Beans.getService(AuthorityFilter.url), id);
		// 서버 객체 저장
		request.setAttribute("id", result);
	}
	
	// 4. 회원 정보 보기
	private void view(HttpServletRequest request) throws Exception{
		
		// 자바
		LoginVO loginVO = (LoginVO) request.getSession().getAttribute("login");
		System.out.println(loginVO);
		
		String id = loginVO.getId();
		MemberVO vo = (MemberVO) ExeService.execute(Beans.getService(AuthorityFilter.url), id);
		
		System.out.println(id);
		request.setAttribute("vo", vo);
	}
	
	// 5. 회원 리스트 처리
	private void list(HttpServletRequest request, PageObject pageObject) throws Exception{
		
		// 자바
		@SuppressWarnings("unchecked")
		List<MemberVO> list = (List<MemberVO>) ExeService.execute(Beans.getService(AuthorityFilter.url), pageObject);
		// 서버객체 request에 담는다.
		request.setAttribute("list", list);
	}

}
