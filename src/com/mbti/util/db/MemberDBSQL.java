package com.mbti.util.db;

public class MemberDBSQL {
	
	// 1. 로그인 처리
	public static final String MEMBER_LOGIN
	= " select id, name, gradeNo, gradeName from memeber m, grade g "
	+ " where (m.id = ? and m.pw = ?) and (m.gradeNo = g.gradeNo) ";

}
