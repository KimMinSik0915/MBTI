package com.mbti.member.service;

import com.mbti.member.dao.MemberDAO;
import com.mbti.main.controller.Service;

public class MemberListService implements Service{

	//dao가 필요하다. 밖에서 생성한 후 넣어준다. - 1. 생성자. 2. setter()
	MemberDAO dao;
	
	@Override
	public void setDAO(Object dao) {
		this.dao = (MemberDAO) dao;
	}
	
	@Override
	public Object service(Object obj) throws Exception {
		// TODO Auto-generated method stub
		return dao.list(); 
	}

}
