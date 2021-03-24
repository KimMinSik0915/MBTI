package com.mbti.util.db;

public class ListSQL {

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
