package com.mbti.type.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mbti.type.vo.TypeVO;
import com.mbti.util.db.DBInfo;
import com.mbti.util.db.TypeDBSQL;
import com.mbti.util.page.PageObject;

public class TypeDAO {

	// 필요한 객체 선언
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	//1. 이미지 유형 리스트
	public List<TypeVO> list(PageObject pageObject) throws Exception{
		
		System.out.println("TypeDAO.list().pageObject : " + pageObject);
		
		List<TypeVO> list = null;
		
		try {
			//1.드라이버 확인 2.연결
			con = DBInfo.getConnection();
			System.out.println("TypeDAO.list().DBSQL.TYPE_LIST :" + TypeDBSQL.TYPE_LIST);
			//3.
			System.out.println("TypeDAO.list().pstmt : " + pstmt);
			pstmt.setLong(1, pageObject.getStartRow());
			pstmt.setLong(2, pageObject.getEndRow());
			//5. 실행
			rs = pstmt.executeQuery();
			System.out.println("TypeDAO.list().rs : " + rs);
			//6. 표시 -> 데이터 담기
			if(rs != null) {
				while(rs.next()) {
					if(list == null) list= new ArrayList<>();
					TypeVO vo = new TypeVO();
					vo.setNo(rs.getLong("no"));
					vo.setType(rs.getString("type"));
					vo.setImage(rs.getString("image"));
					vo.setUpdateDate(rs.getString("updateDate"));
					list.add(vo);
					System.out.println("TypeDAO.list().while.vo :" + vo);
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			//사용자를 위한 오류 처리
			throw new Exception("유형 관리 실행 중 DB처리 오류");
		} finally {
			//7. 닫기
			DBInfo.close(con, pstmt, rs);
		}
		System.out.println("TypeDAO.list().list : " + list);
		return list;
	}
	
	// 1-1. 유형이미지 전체 데이터 개수
	public long getTotalRow() throws Exception {
		System.out.println("TypeDAO.getTotalRow()");

		long result = 0;
		
		try {
			//1.2.
			con = DBInfo.getConnection();
			System.out.println("TypeDAO.getTotalRow().con : " + con);
			//3.4.
			//쿼리확인
			System.out.println("TypeDAO.getTotalRow().DBSQL.TYPE_GET_TOTALROW : " 
			+ TypeDBSQL.TYPE_GET_TOTALROW);
			System.out.println("TypeDAO.getTotalRow().pstmt : " + pstmt);
			
			// 5.
			rs = pstmt.executeQuery();
			System.out.println("TypeDAO.getTotalRow().rs : " + rs);
			//6.
			if(rs != null && rs.next()) {
				result = rs.getLong(1);
				System.out.println("TypeDAO.getTotalRow().result : " + result);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception("유형 이미지 데이터 전체 개수 실행중 DB 처리 오류 ");
		}finally {
			DBInfo.close(con, pstmt, rs);
		}
		System.out.println("TypeDAO.getTotalRow().result :" + result);
		return result;
	}
}
