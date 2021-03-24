package com.mbti.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mbti.memver.vo.LoginVO;
import com.mbti.util.db.DBInfo;
import com.mbti.util.db.MemberDBSQL;

public class MemberDAO {
	
	// 객체 선언
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public LoginVO login(LoginVO vo) throws Exception{
		LoginVO loginVO = null;
		
		try {
			con = DBInfo.getConnection();
			
			pstmt = con.prepareStatement(MemberDBSQL.MEMBER_LOGIN);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			
			rs = pstmt.executeQuery();
			
			if(rs != null && rs.next()) {
				loginVO = new LoginVO();
				loginVO.setId(rs.getString("id"));
				loginVO.setName(rs.getString("name"));
				loginVO.setGradeNo(rs.getInt("gradeNo"));
				loginVO.setGradeName(rs.getString("gradeName"));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception("로그인 DB 처리 중 오류");
		} finally {
			DBInfo.close(con, pstmt, rs);
			
		}
		return loginVO;
	}

}
