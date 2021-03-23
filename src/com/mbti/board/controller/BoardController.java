package com.mbti.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.mbti.board.vo.BoardVO;
import com.mbti.main.controller.Beans;
import com.mbti.main.controller.Controller;
import com.mbti.main.controller.ExeService;
import com.mbti.util.filter.AuthorityFilter;
import com.mbti.util.page.PageObject;

public class BoardController implements Controller {
	
	private final String MODULE = "board";
	private String jspInfo = null;
	private HttpSession session = null;

	@Override
	public String execute(HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("BoardController.execute()");
		//넘어오는 세션 저장하기
		session = request.getSession();
		
		//페이지를 위한 처리
		PageObject pageObject = PageObject.getInstance(request);
		request.setAttribute("poageObject", pageObject); // 페이지를 보여주기 위해 서버객체에 담는다.
		
		switch (AuthorityFilter.url) {
		//1. 게시판 리스트
		case "/" + MODULE + "/list.do":
			// service - dao --> request에 저장까지 해준다.
			list(request, pageObject);
		
			jspInfo = MODULE + "/list";
			break;
		
		//2. 게시판 글보기	
		case "/" + MODULE + "/view.do":
			Long no = view(request);
		
			jspInfo = MODULE + "/view";
			break;
			
		//3-1. 게시판 글쓰기 폼
		case "/" + MODULE + "/writeForm.do":
			jspInfo = MODULE + "/writeForm";
			break;
			
		//3-2. 게시판 글쓰기 처리
		case "/" + MODULE + "/write.do":
			write(request);
		
			jspInfo = "redirect:list.do?page=1&perPageNum" + pageObject.getPerPageNum();
			break;
			
		//4-1. 게시판 글수정 폼
		case "/" + MODULE + "/updateForm.do":
			updateForm(request);
		
			jspInfo = MODULE + "/updateForm";
			break;
			
		//4-2. 게시판 글수정 처리 --오류나면 여기랑 view 확인
		case "/" + MODULE + "/update.do":
			no = update(request);
			
			jspInfo = "redirect:view.do?no=" + no + "&inc=0&page=" + pageObject.getPage()
			+ "&perPageNum=" + pageObject.getPerPageNum();
			break;
			
		//5. 게시판 글삭제 처리
		case "/" + MODULE + "/delete.do":
			delete(request);
		
			jspInfo = "redirect:list.do?page=1&perPageNum=" + pageObject.getPerPageNum();
			break;
			
		default:
			throw new Exception("BoardController - 404 페이지 오류 : 존재하지 않는 페이지입니다.");
		}
		
		return jspInfo;
	}
	
	//1. 게시판 리스트 처리
	private void list(HttpServletRequest request, PageObject pageObject) throws Exception{
		//자바 코드 부분
		@SuppressWarnings("unchecked")
		List<BoardVO> list
		= (List<BoardVO>) ExeService.execute(Beans.getService(AuthorityFilter.url), pageObject);
		//서버 객체에 담는다
		request.setAttribute("list", list);
	}
	
	//2. 게시판 글보기
	private Long view(HttpServletRequest request) throws Exception{
		//넘어오는 데이터 받기
		String strNo = request.getParameter("no");
		long no = Long.parseLong(strNo);
		
		//조회수 1증가
		String strInc = request.getParameter("inc");
		long inc = Long.parseLong(strInc);
		
		//게시판 글보기 데이터 한 개 가져오기
		BoardVO vo = (BoardVO) ExeService.execute(Beans.getService(AuthorityFilter.url),
				new Long[] {no, inc});
		
		//서버 객에 request에 담는다
		request.setAttribute("vo", vo);
		
		// 글번호를 리턴한다.
		return no;
	}
	
	//3. 게시판 글쓰기 처리
	private void write(HttpServletRequest request) throws Exception{
		
		//1.데이터 수집
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String id = request.getParameter("id");
		
		BoardVO vo = new BoardVO();
		vo.setTitle(title);
		vo.setContent(content);
		vo.setId(id);
		
		//2. DB처리
		Integer result = (Integer) ExeService.execute(Beans.getService(AuthorityFilter.url), vo);
		System.out.println("BoardController.write().result : " + result);
		
		//전달 메시지 저장
		request.getSession().setAttribute("msg", "게시글 등록이 완료되었습니다.");
	}	
	//4-1. 게시판 글수정 폼
	private void updateForm(HttpServletRequest request) throws Exception{
		//1. 넘어오는 데이터 받기
		String strNo = request.getParameter("no");
		long no = Long.parseLong(strNo);
		//조회수 1 증가하는 부분은 inc=0으로 강제 세팅해서 넘긴다
		
		//2. 글번호에 맞는 데이터 가지고 오기
		String url = "/board/view.do";
		BoardVO vo = (BoardVO) ExeService.execute(Beans.getService(url), new Long[] {no, 0L});
		
		//3. 서버 객체에 넣기
		request.setAttribute("vo", vo);
	}
	
	//4-2. 게시판 글수정 처리
	private Long update(HttpServletRequest request) throws Exception{
		
		//1. 데이터 수집
		String strNo = request.getParameter("no");
		long no = Long.parseLong(strNo);
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String id = request.getParameter("id");
		
		BoardVO vo = new BoardVO();
		vo.setNo(no);
		vo.setTitle(title);
		vo.setContent(content);
		vo.setId(id);
		
		//2. DB찰;
		String url = request.getServletPath();
		Integer result = (Integer) ExeService.execute(Beans.getService(url), vo);
		
		if(result < 1) throw new Exception("수정할 게시글이 존재하지 않습니다.");
		
		return no;
	}
	
	//5. 게시판 글삭제 처리
	private void delete(HttpServletRequest request)throws Exception{
		//1. 데이터 수집
		String strNo = request.getParameter("no");
		long no = Long.parseLong(strNo);
		
		//2. DB처리
		String url = request.getServletPath();
		Integer result = (Integer) ExeService.execute(Beans.getService(url), no);
		if(result == 0 ) throw new Exception("글 삭제 중 오류가 발생했습니다.");
	}
}
