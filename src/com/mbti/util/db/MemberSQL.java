package com.mbti.util.db;

public class MemberSQL {
	
	// 회원관리 쿼리 ---------------------------------------------------------
	// 로그인 처리
	public static final String MEMBER_LOGIN
	= " select m.id, m.name, m.gradeNo, g.gradeName from member m, grade g "
	+ " where (m.id = ? and m.pw = ?) and (m.gradeNo = g.gradeNo) ";
	
	// 회원 리스트 처리 - id, name, gender, birth, tel, status, gradeNo, gradeName
	public static final String MEMBER_LIST 
	= " select rnum, id, name, "
	+ " tel, status, gradeNo, gradeName from( "
		+ " select rownum rnum, id, name, tel, status, "
		+ " gradeNo, gradeName from ( "
			+ " select m.id, m.name, m.tel, m.status, "
			+ " m.gradeNo, g.gradeName "
			+ " from member m, grade g "
			+ " where m.gradeNo = g.gradeNo "
			+ " order by id "
		+ " ) "
	+ ") where rnum between ? and ?  ";
	
	// 회원 리스트 처리 - id, name, gender, birth, tel, status, gradeNo, gradeName
	public static final String MEMBER_VIEW
	= " select id, name, tel, email, " +
	// to_char할때 (yy...)하고 나서 뒤에 m. 같은 줄임표시 치면 에러뜸 
			" status " + 
			" from member " + 
			" where id = ? ";
	// 회원가입
	public static final String MEMBER_WRITE
	= " insert into member(id, pw, name, tel, email ) "
	+ " values(?, ?, ?, ?, ?, ?, ?) ";
	// 아이디 중복 체크
	public static final String MEMBER_CHECK_ID
	= "select id from member where id = ?";
	
	public static final String MEMBER_GRADE_MODIFY
	= "update member set gradeNo = ? where id = ?";

}
