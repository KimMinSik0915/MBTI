package com.mbti.util.db;

public class DBSQL {
	//=======================================================================
	// 게시판 쿼리 작성 -----------------------------------------------------------
	//1. 게시판 리스트
	public static final String BOARD_LIST
	= " select rnum, no, title, id, "
			+ " to_char(WriteDate, 'yyyy-mm-dd') writeDate, hit from ( "
			+ " select rownum rnum, no, title, id, writeDate, hit "
			+ " from ( select no, title, id, writeDate, hit from board "
			+ " order by no desc "
			+ " ) "
			+ " ) where rnum between ? and ? ";

	//1-1 게시판 리스트 전체 데이터 보기
	public static final String BOARD_GET_TOTALROW
	= " select count(*) from board ";
	
	//2. 게시판 글보기
	public static final String BOARD_VIEW
	= " select no, title, content, id, to_char(writeDate, 'yyyy-mm-dd') writeDate, "
			+ " hit from board where no = ? ";
	
	//2-1. 게시판 글보기 조회수 1 증가
	public static final String BOARD_INCREASE
	= " update board set hit = hit + 1 where no = ? ";
	
	//3. 게시판 글쓰기
	public static final String BOARD_WRITE
	= " insert into board(no, title, content, id) "
			+ " values(board_seq.nextval, ?, ?, ?) ";
	
	//4. 게시판 글수정
	public static final String BOARD_UPDATE
	= " update board set title = ?, content = ?, id = ? "
			+ " where no = ? ";
	
	//5. 게시판 글 삭제
	public static final String BOARD_DELETE
	= " delete from board where no = ? ";
	
	//=======================================================================
	// 공지사항 쿼리 -------------------------------------------------------------
	// 1. 공지사항 리스트 
	public static final String NOTICE_LIST
	= " select rnum, no, title, "
			+ " to_char(writeDate, 'yyyy-mm-dd') writeDate, "
			+ " to_char(startDate, 'yyyy-mm-dd') startDate, "
			+ " to_char(endDate, 'yyyy-mm-dd') endDate from ( "
				+ " select rownum rnum, no, title, writeDate, startDate, endDate from ( "
					+ " select no, title, writeDate, startDate, endDate from notice "
					+ " order by no desc "
				+ " ) "
			+ " ) where rnum between ? and ? ";
	// 1-1. 공지사항 총 게시글 갯수
	public static final String NOTICE_GET_TOTALROW
	= " select count(*) from notice ";
	// 2. 공지사항 작성 글 보기
	public static final String NOTICE_VIEW
	= " select no, title, content, "
			+ " to_char(writeDate, 'yyyy-mm-dd') writeDate, "
			+ " to_char(startDate, 'yyyy-mm-dd') startDate, "
			+ " to_char(endDate, 'yyyy-mm-dd') endDate from notice "
			+ " where no = ? ";
	// 3. 공지사항 작성하기
	public static final String NOTICE_WRITE
	= " insert into notice (no, title, content, startDate, endDate) "
			+ "values(notice_seq.nextval, ?, ?, ?, ?) ";
	// 4. 공지사항 삭제하기
	public static final String NOTICE_DELETE
	= " delete from notice where no = ? ";
	
	//=======================================================================
	// 유형 게시판 쿼리 -----------------------------------------------------------
	//1. 리스트 - 번호, 유형, 이미지, 수정일
	public static final String TYPE_LIST
	
	= " select rnum, no, type, image, "
		+ " to_char(updateDate, 'yyyy.mm.dd') updateDate from( "
			+ "select rownum rnum, no, type, image, updateDate from  ("
			+ " select no, type, image, updateDate from type"
			+ " order by no desc "
			+ " ) "
		+ " )  where rnum between ? and ? ";

	// 1-1. 전체 데이터 개수 - 페이지 처리: 리스트
	public static final String TYPE_GET_TOTALROW
	= " select count(*) from type ";
	
	//2. 유형 이미지 보기 - 번호, 유형, 내용, 이미지, g유형, g이미지, b유형, b이미지, 수정일
	public static final String TYPE_VIEW
	= " select no, type, content, image, gType, gImage, bType, bImage, "
			+ " to_char(updateDate, 'yyyy.mm.dd') updateDate "
			+ " from type where no = ? ";
	
	//3. 유형 이미지 등록 - 번호, 유형, 이미지, g유형, g이미지, b유형, b이미지
	public static final String TYPE_WRITE
	= " insert into type(no, type, image, gType, gImage, bType, bImage)"
			+ " values(type_seq.nextval, ?, ?, ?, ?, ?, ?) ";
	
	//4.유형 이미지 파일 정보 수정
	public static final String TYPE_UPDATE_FILE
	= " update type set image = ? where no = ? ";
	
	//5.유형 이미지 삭제 
	public static final String TYPE_DELETE
	= " delete from type where no = ? ";
	//=======================================================================
	// 회원관리 쿼리 -------------------------------------------------------------
	// 1. 로그인 처리
	public static final String MEMBER_LOGIN
	= " select id, name, gradeNo, gradeName from memeber m, grade g "
	+ " where (m.id = ? and m.pw = ?) and (m.gradeNo = g.gradeNo) ";
	
	// 2. 회원가입 처리
	public static final String MEMBER_WRITE
	= " insert into member(id, pw, name, gender, birth, tel, email) "
	+ " values(?, ?, ?, ?, ?, ?, ?) ";
	
	// 2-1. 아이디 중복체크
	public static final String MEMBER_CHECK_ID
	= " select id from member where id = ?";
	
	// 3. 회원 정보 보기
	public static final String MEMBER_VIEW
	= " select m.id, m.name, m.gender, m.tel, m.email, "
	+ " to_char(m.birth, 'yyyy.mm.dd') birth, "
	+ " m.status, g.gradeNo, g.gradeName " 
	+ " from member m, grade g "
	+ " where id = ? and (m.gradeNo = g.gradeNo) ";
	
	// 4. 회원 리스트
	public static final String MEMBER_LIST
	= " select rnum, id, name, gender, "
	+ "to_char(birth, 'yyyy.mm.dd' birth,m tel, status, gradeNo, gradeName from( "
		+ " select rownum rnum, id, name, gender, birht, tel, tsatus, "
		+ " gradeNo, gradeName from( "
			+ " select m.id, m.name, m.gender, m.birth, m.tel, m.status, "
			+ " m.gradeNo, g.gradeName "
			+ " from member m, grade g "
			+ " where m.gradeNo = g.gradeNo "
			+ " order by id "
		+ " ) "
	+ " ) where rnum between ? and ? ";
	
	// 5. 회원 등급 수정
	public static final String MEMBER_GRADE_MODIFY
	= "update member set gradeNo = ? where id = ?";
	//=======================================================================
	// 테스트 목록 쿼리 -----------------------------------------------------------
	public static final String LIST_LIST
	= " SELECT rnum, no, title, image, url, hit FROM ( "
			+ " SELECT rownum rnum, no, title, image, url, hit FROM ("
				+ " SELECT nom title, image, url, hit "
				+ " FROM list "
				+ " ORDER bt hit DESC "
			+ " ) "
		+ ") "
	+ " WHERE rnum BETWEEN ? AND ?";
	
	public static final String LIST_GET_TOTALROW
	= " SELECT COUNT(*) FROM list ";
	
	public static final String LIST_INCREASE
	= " UPDATE list SET hit = hit + 1 ";
	
	public static final String LIST_WRITE
	= " INSERT INTO list(no, title, image, url, hit) "
	+ " VALUES(list_seq.NEXTVAL, ?, ?, ?, ?) ";
	
	public static final String LIST_UPDATE
	= " UPDATE list SET title = ?, image = ?, url = ? "
	+ " WHERE no = ? ";
	
	public static final String LIST_DELETE
	= " DELETE FROM list WHERE no = ? ";
	
}




