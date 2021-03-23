package com.mbti.notice.sql;

public class NoticeSQL {
	// 공지사항 쿼리
	// 1. 공지사항 리스트 
	public static final String NOTICE_LIST
	= " select rnum, no, title, "
			+ " to_char(writeDate, 'yyyy-mm-dd') writeDate, "
			+ " to_char(startDate, 'yyyy-mm-dd') startDate, "
			+ " to_char(endDate, 'yyyy-mm-dd') endDate from ( "
				+ " select rownum rnum, no, title, writeDate, startDate, endDate from ( "
					+ " select no, title, writeDate, startDate, endDate from notice "
					+ " order by no desc ";
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
}
