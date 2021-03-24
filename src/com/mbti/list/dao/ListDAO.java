/*
 * List DAO
 * 작성자 : 김민식
 * 작성일 : 2021.03.24
 * ver_1.0
 */
package com.mbti.list.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mbti.list.vo.ListVO;
import com.mbti.util.db.DBInfo;
import com.mbti.util.db.DBSQL;
import com.mbti.util.page.PageObject;

public class ListDAO {

	Connection con = null;
	
	PreparedStatement pstmt = null;
	
	ResultSet rs = null;
	
	// MBTI 항목 가져오기
	public List<ListVO> list(PageObject pageObject) throws Exception {
		
		List<ListVO> list = null;
		
		try {
			
			con = DBInfo.getConnection();
			
			pstmt = con.prepareStatement(DBSQL.LIST_LIST);
			
			pstmt.setLong(1, pageObject.getStartRow());
			pstmt.setLong(2, pageObject.getEndRow());
			
			rs = pstmt.executeQuery();
			
			if(rs != null) {
				
				while(rs.next()) {
					
					if(list == null) {
						
						list = new ArrayList<ListVO>();
						
					}
					
					ListVO vo = new ListVO();
					
					vo.setNo(rs.getLong("no"));
					vo.setTitle(rs.getString("title"));
					vo.setIamge(rs.getString("imgae"));
					vo.setUrl(rs.getString("url"));
					vo.setHit(rs.getLong("hit"));
					
					list.add(vo);
					
				}
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace();
			
			throw new Exception("MBTI 목록을 불러오는 중 DB에 오류가 발생하였습니다.");
			
		} finally {
			
			DBInfo.close(con, pstmt, rs);
			
		}
		
		return list;
		
	}
	
	// MBTI TEST 총 개수 가져오기
	public long getTotalRow() throws Exception {
		
		long result = 0;
		
		try {
			
			con = DBInfo.getConnection();
			
			pstmt = con.prepareStatement(DBSQL.LIST_GET_TOTALROW);
			
			rs = pstmt.executeQuery();
			
			if(rs != null && rs.next()) {
				
				result = rs.getLong(1);
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace();
			
			throw new Exception("MBTI 항목 갯수를 가져오는 중 DB에 오류가 발생하였습니다.");
			
		} finally {
			
			DBInfo.close(con, pstmt, rs);
			
		}
		
		return result;
		
	}
	
}