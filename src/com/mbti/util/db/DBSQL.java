package com.mbti.util.db;

public class DBSQL {
//=======================================================================
	//게시판 쿼리 작성
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
	= " select no, title, content, id, to_char(writeDate, 'yyyy-mm-dd') writeDate "
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
	// 공지사항 쿼리
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
	// 유형 게시판 쿼리 ------------------------------------
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
			+ " from where no = ? ";
	
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
}


