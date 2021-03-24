package com.mbti.util.db;

public class DBSQL_Board {
	
	//게시판 쿼리 작성---------------------------------------------------
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
}
