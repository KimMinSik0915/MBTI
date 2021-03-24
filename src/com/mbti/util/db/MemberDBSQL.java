package com.mbti.util.db;

public class MemberDBSQL {
	
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

}
