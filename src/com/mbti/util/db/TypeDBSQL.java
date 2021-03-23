package com.mbti.util.db;

public class TypeDBSQL {

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