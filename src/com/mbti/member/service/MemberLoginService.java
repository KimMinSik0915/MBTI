package com.mbti.member.service;

import com.mbti.main.controller.Service;
import com.mbti.member.dao.MemberDAO;
import com.mbti.member.vo.LoginVO;

public class MemberLoginService implements Service{
	
	//dao 생성
	private MemberDAO dao;

	@Override
	public Object service(Object obj) throws Exception {
		// TODO Auto-generated method stub
		return dao.login((LoginVO) obj);
	}

	@Override
	public void setDAO(Object dao) {
		// TODO Auto-generated method stub
		this.dao = (MemberDAO) dao;
	}

}
